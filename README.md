# BetaCore

**BetaCore** is a proprietary Android companion for Minecraft server management and beta-version organization, built with Kotlin and Jetpack Compose.

> This repository is public for visibility, but the software is proprietary. No license is granted to copy, modify, redistribute, sublicense, or use the software except as expressly authorized in writing by the copyright holder.

## Planned capabilities

- Android-first dashboard for managing server projects
- Server lifecycle controls and console integration (planned)
- Beta/preview version catalog and compatibility notes (planned)
- World backup and configuration tools (planned)
- GitHub Actions build and unit-test workflow

## Project status

Early scaffold. The current app is a UI foundation; server execution, version downloads, and compatibility checks are not implemented yet. Features will be added incrementally and validated on supported devices.

## Build

Open this project in a recent Android Studio version with JDK 17 support, or use Gradle from the command line:

```bash
gradle assembleDebug
gradle testDebugUnitTest
```

The repository CI workflow builds a debug APK and runs unit tests on pushes and pull requests.

## Copyright

Copyright © 2026 BetaCore. All rights reserved.

Minecraft is a trademark of Microsoft/Mojang. BetaCore is an independent project and is not affiliated with or endorsed by Microsoft or Mojang.
