# BetaCore

BetaCore is a **native Android app** for hosting user-supplied Minecraft Java Edition Beta 1.7 server JARs. It is built with Kotlin and Jetpack Compose, not web technologies.

## Current milestone: GUI foundation

The current dashboard is UI scaffolding only. Server JAR import, runtime compatibility checks, actual server process control, console I/O, networking, and world backups are not implemented yet.

## Build

Open the project in Android Studio with JDK 17 and Android SDK 35 configured. Let Gradle sync, then run the `app` configuration on a device or emulator.

## Compatibility

Legacy server JARs and Java runtimes must be tested together on Android. No Mojang/Microsoft server JAR is bundled; import your own.

## Proprietary notice

Copyright © 2026 BetaCore. All rights reserved. No license is granted to copy, modify, redistribute, sublicense, or use this software except as expressly authorized in writing by the copyright holder.

Minecraft is a trademark of Microsoft/Mojang. BetaCore is an independent project and is not affiliated with or endorsed by Microsoft or Mojang.
