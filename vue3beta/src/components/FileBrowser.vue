<script setup lang="ts">
import { ref, computed, watch } from 'vue'
import { useRouter } from 'vue-router'
import { showToast, showSuccessToast, showConfirmDialog, showLoadingToast, closeToast } from 'vant'
import { GH } from '@/api/github'
import { useStore } from '@/stores'
import { fileMenuItems, isZipFile, isMainSite } from '@/composables/useContextMenu'
import { getProxiedUrl, rawUrl, triggerDownload } from '@/utils/proxy'
import { sortFiles, getFileIcon, IMAGE_EXTS, type FileSort } from '@/utils/files'
import { formatSize } from '@/utils/format'
import PromptDialog from '@/components/dialog/PromptDialog.vue'
import type { GithubContentItem, GithubRepo } from '@/types'

const props = defineProps<{
  owner: string
  name: string
  branch: string
  path: string
  repo?: GithubRepo | null
}>()

const router = useRouter()
const store = useStore()
const settings = store.state.settings
const login = computed(() => store.activeAccount.value?.login ?? '')

const items = ref<GithubContentItem[]>([])
const loading = ref(false)
const refreshing = ref(false)
const error = ref(false)

// 多选
const multiSelect = ref(false)
const selected = ref<Set<string>>(new Set())
const sheetActions = ref<{ name: string; danger?: boolean }[]>([])
const showSheet = ref(false)
const currentItem = ref<GithubContentItem | null>(null)

// 重命名
const showRename = ref(false)
const renamePath = ref('')
const renameType = ref<'file' | 'dir'>('file')

// 视图/排序
const viewMode = ref(settings.viewMode)
const fileSort = ref<FileSort>('type_name_asc')
const SORTS: { key: FileSort }[] = [
  { key: 'type_name_asc' },
  { key: 'name_asc' },
  { key: 'name_desc' },
  { key: 'size_desc' },
  { key: 'size_asc' },
]
function onSortClick() {
  const i = SORTS.findIndex((s) => s.key === fileSort.value)
  fileSort.value = SORTS[(i + 1) % SORTS.length].key
}

const IMG = IMAGE_EXTS

const displayFiles = computed(() =>
  sortFiles(items.value, fileSort.value, settings.folderFirst),
)
const webEmpty = computed(() => !loading.value && !error && !items.value.length)

async function load() {
  loading.value = true
  try {
    items.value = await GH.getContents(props.owner, props.name, props.path, props.branch)
    error.value = false
  } catch {
    error.value = true
  } finally {
    loading.value = false
    refreshing.value = false
  }
}

function onRefresh() {
  load()
}

watch(
  () => [props.owner, props.name, props.branch, props.path],
  () => load(),
  { immediate: true },
)

function onItemClick(item: GithubContentItem) {
  if (multiSelect.value) {
    toggleSelect(item)
    return
  }
  if (item.type === 'dir') {
    router.push({
      name: 'Files',
      params: { owner: props.owner, name: props.name, branch: props.branch, path: item.path },
    })
  } else {
    openFilePreview(item)
  }
}

// 预览
const showPreviewer = ref(false)
const previewName = ref('')
const previewContent = ref('')
const previewIsImage = ref(false)
const previewUrl = ref('')

function openFilePreview(item: GithubContentItem) {
  const ext = item.name.split('.').pop()?.toLowerCase() ?? ''
  previewIsImage.value = IMAGE_EXTS.includes(ext)
  previewName.value = item.name
  showPreviewer.value = true
  if (previewIsImage.value) {
    previewUrl.value = getProxiedUrl(item.download_url || rawUrl(item), settings)
  } else {
    previewContent.value = '加载中...'
    loadText(item)
  }
}
async function loadText(item: GithubContentItem) {
  try {
    const res = await fetch(getProxiedUrl(rawUrl(item), settings))
    if (res.ok) previewContent.value = await res.text()
    else throw new Error()
  } catch {
    try {
      const cell = await GH.getContentItem(props.owner, props.name, item.path, props.branch)
      previewContent.value = cell.content
        ? decodeURIComponent(escape(atob(cell.content)))
        : '（二进制文件）'
    } catch {
      previewContent.value = '无法预览'
    }
  }
}

// 多选
function toggleMultiSelectMode(on: boolean) {
  multiSelect.value = on
  if (!on) selected.value.clear()
}
function toggleSelect(item: GithubContentItem) {
  if (selected.value.has(item.path)) selected.value.delete(item.path)
  else selected.value.add(item.path)
}
function selectAll() {
  displayFiles.value.forEach((i) => selected.value.add(i.path))
}
function invertSelect() {
  displayFiles.value.forEach((i) => {
    if (selected.value.has(i.path)) selected.value.delete(i.path)
    else selected.value.add(i.path)
  })
}
function isSelected(item: GithubContentItem) {
  return selected.value.has(item.path)
}

// 长按菜单
let pressTimer: ReturnType<typeof setTimeout> | null = null
function onPressStart(item: GithubContentItem) {
  currentItem.value = item
  const ctx = {
    isOwner: login.value ? props.owner.toLowerCase() === login.value.toLowerCase() : false,
    isSearchResults: false,
    hasPages: props.repo?.has_pages ?? false,
    isMainSiteRepo: props.repo ? isMainSite(props.repo, login.value) : false,
    hasCustomDomain: !!(props.repo as any)?.customDomain,
    isZip: isZipFile(item.name),
  }
  sheetActions.value = fileMenuItems(
    item,
    ctx,
    settings.menuVisibility[item.type === 'dir' ? 'folder' : 'file'],
  ).map((m) => ({ name: m.text, danger: m.danger ?? false }))
  pressTimer = setTimeout(() => {
    showSheet.value = true
  }, 500)
}
function onPressEnd() {
  if (pressTimer) {
    clearTimeout(pressTimer)
    pressTimer = null
  }
}

async function copyText(t: string) {
  try {
    await navigator.clipboard.writeText(t)
    showToast('已复制')
  } catch {
    showToast('复制失败')
  }
}

function parentPath(p: string): string {
  const i = p.lastIndexOf('/')
  return i > 0 ? p.slice(0, i) : ''
}
function pagesLink(item: GithubContentItem): string {
  const isMain = props.repo ? isMainSite(props.repo, login.value) : false
  if (isMain) return `https://${props.owner}.github.io/${item.path}`
  return `https://${props.owner}.github.io/${props.name}/${item.path}`
}

async function onAction(action: { name: string; danger?: boolean }) {
  const item = currentItem.value
  if (!item) return
  const A = action.name
  if (A === '多选') {
    toggleMultiSelectMode(true)
    selected.value.add(item.path)
  } else if (A === '进入目录' && item.type === 'file') {
    router.push({
      name: 'Files',
      params: { owner: props.owner, name: props.name, branch: props.branch, path: parentPath(item.path) },
    })
  } else if (A === '重命名') {
    renamePath.value = item.path
    renameType.value = item.type === 'dir' ? 'dir' : 'file'
    showRename.value = true
  } else if (A === '代理下载') {
    triggerDownload(getProxiedUrl(rawUrl(item), settings, true))
    showToast('开始下载')
  } else if (A === '下载 ZIP') {
    triggerDownload(`https://github.com/${props.owner}/${props.name}/archive/refs/heads/${props.branch}.zip`)
    showToast('下载中')
  } else if (A === '网站链接') {
    await copyText(pagesLink(item))
  } else if (A === '域名链接') {
    await copyText(`https://${(props.repo as any)?.customDomain}/${item.path}`)
  } else if (A === '仓库链接') {
    await copyText(item.html_url)
  } else if (A === '复制raw链接') {
    await copyText(rawUrl(item))
  } else if (A === '复制代理链接') {
    await copyText(getProxiedUrl(rawUrl(item), settings, true))
  } else if (A === '解压缩(仅ZIP)') {
    await doUnzip(item)
  } else if (A === '删除') {
    await doDelete(item)
  }
}

async function onRenameConfirm(newName: string | null) {
  if (newName == null || !currentItem.value) return
  const item = currentItem.value
  const slash = item.path.lastIndexOf('/')
  const base = slash >= 0 ? item.path.slice(0, slash + 1) : ''
  const newPath = base + newName
  if (newPath === item.path) return
  showLoadingToast({ message: '重命名中...', forbidClick: true })
  try {
    if (renameType.value === 'file' && item.size != null && item.size <= 1024 * 1024) {
      const cell = await GH.getContentItem(props.owner, props.name, item.path, props.branch)
      if (cell.content) {
        await GH.createOrUpdateFile(props.owner, props.name, newPath, {
          message: 'rename',
          content: cell.content,
          branch: props.branch,
        })
        await GH.deleteFile(props.owner, props.name, item.path, {
          message: 'rename',
          sha: cell.sha || item.sha || '',
          branch: props.branch,
        })
      }
    } else {
      await renameViaGitData(item.path, newPath)
    }
    showSuccessToast('已重命名')
    load()
  } catch {
    showToast('重命名失败')
  } finally {
    closeToast()
  }
}

async function renameViaGitData(oldPath: string, newPath: string) {
  const head = await GH.getRefHead(props.owner, props.name, props.branch)
  const commit = await GH.getCommit(props.owner, props.name, head.object.sha)
  const tree = await GH.createTree(props.owner, props.name, {
    base_tree: commit.tree.sha,
    tree: [
      { path: oldPath, mode: renameType.value === 'dir' ? '040000' : '100644', type: renameType.value === 'dir' ? 'tree' : 'blob', sha: null },
      { path: newPath, mode: '100644', type: 'blob', sha: '' },
    ],
  })
  const c = await GH.createCommit(props.owner, props.name, {
    message: `rename ${oldPath} -> ${newPath}`,
    tree: tree.sha,
    parents: [head.object.sha],
  })
  await GH.updateRef(props.owner, props.name, props.branch, { sha: c.sha })
}

async function doDelete(item: GithubContentItem) {
  const isDir = item.type === 'dir'
  await showConfirmDialog({
    title: '删除',
    message: `确定删除「${item.name}」${isDir ? '（将递归删除）' : ''}？`,
    confirmButtonText: '删除',
  })
  showLoadingToast({ message: '删除中...', forbidClick: true })
  try {
    await deleteTree(item)
    showSuccessToast('已删除')
    load()
  } catch {
    showToast('删除失败')
  } finally {
    closeToast()
  }
}

async function deleteTree(item: GithubContentItem) {
  if (item.type === 'file') {
    const sha = item.sha || (await GH.getContentItem(props.owner, props.name, item.path, props.branch)).sha
    await GH.deleteFile(props.owner, props.name, item.path, {
      message: 'delete',
      sha,
      branch: props.branch,
    })
    return
  }
  const children = await GH.getContents(props.owner, props.name, item.path, props.branch)
  for (const c of children) await deleteTree(c)
}

async function doUnzip(item: GithubContentItem) {
  showLoadingToast({ message: '解压准备中...', forbidClick: true })
  try {
    const JSZip = (await import('jszip')).default
    const resp = await fetch(getProxiedUrl(rawUrl(item), settings, true))
    const zip = await JSZip.loadAsync(await resp.blob())
    const files = Object.keys(zip.files).filter((f) => !zip.files[f].dir)
    let done = 0
    for (const f of files) {
      const content = await zip.files[f].async('uint8array')
      const b64 = await blobToBase64(new Blob([content as BlobPart]))
      await GH.createOrUpdateFile(props.owner, props.name, f, {
        message: `unzip ${item.name}`,
        content: b64,
        branch: props.branch,
      })
      done++
      showToast(`解压 ${done}/${files.length}`)
    }
    showSuccessToast('解压完成')
    load()
  } catch {
    showToast('解压失败')
  } finally {
    closeToast()
  }
}

function blobToBase64(blob: Blob): Promise<string> {
  return new Promise((resolve) => {
    const reader = new FileReader()
    reader.onload = () => {
      const result = String(reader.result)
      resolve(result.split(',')[1] ?? '')
    }
    reader.readAsDataURL(blob)
  })
}

// 暴露给父组件
defineExpose({
  refresh: load,
  multiSelect,
  selected,
  toggleMultiSelectMode,
  selectAll,
  invertSelect,
})
</script>

<template>
  <div class="fb">
    <!-- 多选操作栏 -->
    <div v-if="multiSelect" class="multiselect-bar">
      <span>已选 {{ selected.size }} 项</span>
      <div class="ms-actions">
        <span @click="selectAll">全选</span>
        <span @click="invertSelect">反选</span>
        <span @click="toggleMultiSelectMode(false)">取消</span>
      </div>
    </div>

    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <van-list v-model:loading="loading" :finished="true" :error="error" finished-text="">
        <!-- 列表视图 -->
        <van-cell-group v-if="viewMode === 'list'" inset>
          <van-cell
            v-for="item in displayFiles"
            :key="item.sha"
            :class="{ 'is-selected': isSelected(item) }"
            center
            clickable
            @click="onItemClick(item)"
            @touchstart.stop="onPressStart(item)"
            @touchend="onPressEnd"
            @touchcancel="onPressEnd"
          >
            <template #icon>
              <img
                v-if="item.type === 'file' && IMG.includes(item.name.split('.').pop()?.toLowerCase() ?? '') && item.download_url"
                :src="getProxiedUrl(item.download_url, settings)"
                class="thumb"
                loading="lazy"
              />
              <van-icon
                v-else
                :name="item.type === 'dir' ? 'folder-o' : getFileIcon(item.name)"
                class="f-icon"
              />
            </template>
            <template #title>
              <div class="fi-name">{{ item.name }}</div>
              <div class="fi-meta">{{ item.type === 'dir' ? '文件夹' : formatSize(item.size) }}</div>
            </template>
            <template #right-icon>
              <van-checkbox
                v-if="multiSelect"
                :model-value="isSelected(item)"
                @click.stop="toggleSelect(item)"
              />
            </template>
          </van-cell>
        </van-cell-group>

        <!-- 网格视图 -->
        <div v-else class="grid-view">
          <div
            v-for="item in displayFiles"
            :key="item.sha"
            class="grid-item"
            :class="{ 'is-selected': isSelected(item) }"
            @click="onItemClick(item)"
            @touchstart.stop="onPressStart(item)"
            @touchend="onPressEnd"
            @touchcancel="onPressEnd"
          >
            <img
              v-if="item.type === 'file' && IMG.includes(item.name.split('.').pop()?.toLowerCase() ?? '') && item.download_url"
              :src="getProxiedUrl(item.download_url, settings)"
              class="grid-thumb"
              loading="lazy"
            />
            <van-icon
              v-else
              :name="item.type === 'dir' ? 'folder-o' : getFileIcon(item.name)"
              class="grid-icon"
            />
            <div class="grid-name ellipsis">{{ item.name }}</div>
          </div>
        </div>

        <van-empty v-if="webEmpty" description="空目录" />
      </van-list>
    </van-pull-refresh>

    <!-- 文件预览 -->
    <van-popup v-model:show="showPreviewer" position="bottom" :style="{ height: '70%' }">
      <div class="preview">
        <div class="preview-head">
          <span class="ellipsis flex-1">{{ previewName }}</span>
          <van-icon name="cross" @click="showPreviewer = false" />
        </div>
        <div v-if="previewIsImage" class="preview-img-wrap">
          <img :src="previewUrl" class="preview-img" />
        </div>
        <pre v-else class="preview-body">{{ previewContent }}</pre>
      </div>
    </van-popup>

    <!-- 长按菜单 -->
    <van-action-sheet
      v-model:show="showSheet"
      :actions="sheetActions"
      cancel-text="取消"
      close-on-click-action
      @select="onAction"
    />

    <!-- 重命名 -->
    <PromptDialog
      v-model:show="showRename"
      title="重命名"
      message="输入新的名称"
      :value="currentItem?.name ?? ''"
      @confirm="onRenameConfirm"
    />
  </div>
</template>

<style scoped>
.multiselect-bar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 8px 14px;
  font-size: 13px;
  color: var(--app-text);
  background: var(--app-card-bg);
  margin-bottom: 8px;
}
.ms-actions {
  display: flex;
  gap: 12px;
}
.ms-actions span {
  color: var(--app-accent);
}
.ms-actions .danger {
  color: #ee0a24;
}
.thumb {
  width: 36px;
  height: 36px;
  border-radius: 6px;
  object-fit: cover;
  background: var(--gh-avatar-bg);
  margin-right: 12px;
}
.f-icon {
  font-size: 26px;
  color: var(--app-text-sub);
  margin-right: 12px;
}
.fi-name {
  font-size: 15px;
  color: var(--app-text);
}
.fi-meta {
  font-size: 12px;
  color: var(--app-text-sub);
  margin-top: 2px;
}
.is-selected {
  background: var(--van-background-2) !important;
}
.grid-view {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 8px;
  padding: 8px 12px;
}
.grid-item {
  background: var(--app-card-bg);
  border-radius: 8px;
  padding: 8px;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 6px;
}
.grid-thumb {
  width: 100%;
  height: 72px;
  object-fit: cover;
  border-radius: 6px;
  background: var(--gh-avatar-bg);
}
.grid-icon {
  font-size: 40px;
  color: var(--app-text-sub);
  padding: 12px 0;
}
.grid-name {
  font-size: 12px;
  color: var(--app-text);
  max-width: 100%;
}
.preview {
  height: 100%;
  display: flex;
  flex-direction: column;
}
.preview-head {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 12px 16px;
  font-size: 15px;
  font-weight: 600;
  border-bottom: 1px solid var(--app-divider);
}
.preview-img-wrap {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: auto;
  padding: 12px;
}
.preview-img {
  max-width: 100%;
}
.preview-body {
  flex: 1;
  overflow: auto;
  padding: 12px 16px;
  margin: 0;
  font-size: 13px;
  line-height: 1.6;
  white-space: pre-wrap;
  word-break: break-all;
  color: var(--app-text);
}
</style>
