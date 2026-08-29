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

[Project Knowledge Summary]
- Date: 2026-08-29
- Context: Discovered by Agent while testing the code editor feature in the GithubKing web app
- Category: Environment Configuration
- Instructions:
  - Playwright is installed in /tmp/opencode/node_modules but has no chromium binary; headless browser tests fail. Use jsdom or Node-based DOM mocks for JS logic testing instead.
  - Code editor uses native textarea only (ACE removed); editor logic testable via Node mocks in /tmp/opencode/sim_editor*.js, extract script via `node --check` + regex on /workspace/index.html.

[Project Knowledge Summary]
- Date: 2026-08-29
- Context: Discovered by Agent while building the APK
- Category: Build Methods
- Instructions:
  - APK build: sync index.html/style.css to android/app/src/main/assets/ and /opt/android-project/app/src/main/assets/, then run `/opt/gradle/gradle-8.9/bin/gradle assembleRelease --no-daemon --max-workers=4` in /opt/android-project; output app-release.apk, copy to /workspace/GithubKing.apk.
