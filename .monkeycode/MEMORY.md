# User Instruction Memory

This file records user instructions, preferences, and teachings for reference in future interactions.

## Format

### User Instruction Entry
User instruction entries should follow this format:

[User Instruction Summary]
- Date: [YYYY-MM-DD]
- Context: [Mentioned scenario or time]
- Instructions:
  - [Content of user teaching or instruction, described line by line]

### Project Knowledge Entry
Entries discovered by the Agent during task execution should follow this format:

[Project Knowledge Summary]
- Date: [YYYY-MM-DD]
- Context: Discovered by Agent while performing [specific task description]
- Category: [Operations & Deployment|Build Methods|Testing Methods|Troubleshooting & Debugging|Workflow & Collaboration|Environment Configuration]
- Instructions:
  - [Specific knowledge points, described line by line]

## Deduplication Strategy
- Before adding a new entry, check for similar or identical instructions.
- If a duplicate is found, skip the new entry or merge it with the existing one.
- When merging, update the context or date information.
- This helps avoid redundant entries and keeps the memory file tidy.

## Entries

[User Instruction Summary]
- Date: 2026-08-28
- Context: 用户明确要求不要主动构建 APK，验证与调试使用 node --check + jsdom 模拟 + 本地预览链接即可
- Instructions:
  - 未经用户明确要求时，不得运行 gradle 构建 APK 或同步 android assets；只做语法检查、jsdom 回归测试与预览验证。

[User Instruction Summary]
- Date: 2026-08-28
- Context: UI 反馈体系重构需求：成功不提示/按钮文字不变，失败时模态框确认按钮文字变为"创建失败/删除失败"等
- Instructions:
  - 新建/删除/发布/编辑/关注/置顶等操作的"成功"一律不弹 toast、不改变按钮文字，直接静默完成（必要时关闭模态框）。
  - 操作失败时，将模态框确认按钮文字改为对应的"XX失败"，并保持按钮可再次点击重试。
  - 模态框每次打开时必须在 show 函数中重置确认按钮的 disabled 状态，防止上次成功/失败后残留禁用导致"点不了确认键"。
  - 复制类操作（如复制链接）因无界面反馈，保留 toast。
