// localStorage 封装
const P = 'ghm:'

export const storage = {
  get<T>(key: string, fallback: T): T {
    try {
      const raw = localStorage.getItem(P + key)
      return raw == null ? fallback : (JSON.parse(raw) as T)
    } catch {
      return fallback
    }
  },
  set(key: string, value: unknown) {
    try {
      localStorage.setItem(P + key, JSON.stringify(value))
    } catch {
      /* ignore */
    }
  },
  remove(key: string) {
    try {
      localStorage.removeItem(P + key)
    } catch {
      /* ignore */
    }
  },
}
