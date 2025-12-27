# BookBridge

BookBridge is a Kotlin Multiplatform (KMP) application that uses Jetpack Compose / Compose Multiplatform to provide a shared codebase across Android, iOS and Desktop targets. The app demonstrates a modern KMP project layout with an Android Compose module and an iOS SwiftUI wrapper.

Key points
- Multiplatform UI using Jetpack Compose / Compose Multiplatform
- Modules: Android app (Compose), iOS app (SwiftUI wrapper), shared Kotlin code
- Gradle Kotlin DSL build

Repository layout (top-level)
- `composeApp/` - primary app module with Compose multiplatform sources and Android target
  - `src/androidMain/`, `src/iosMain/`, `src/desktopMain/`, `src/commonMain/`
  - `build/` - build outputs (generated; usually ignored)
- `iosApp/` - Xcode project that wraps the shared module for iOS
- Gradle wrapper and top-level Gradle configuration files

Prerequisites
- JDK 11 or newer installed and JAVA_HOME configured
- Gradle wrapper (project includes `gradlew`) — prefer using `./gradlew`
- Android Studio Arctic Fox or newer (for Android targets)
- Xcode (for building/running iOS targets)
- For Compose Desktop, a desktop-capable JDK and display environment

Quick build & run
Note: adapt the commands below to your platform and installed tooling. Use the Gradle wrapper (`./gradlew`) from the repo root.

1) Build all targets

    ./gradlew build

This compiles the shared module and platform-specific targets.

2) Android (run from Android Studio or command-line)
- Open the project in Android Studio and run the `composeApp`/`app` configuration.
- From the command line you can assemble an APK / install on a connected device:

    # assemble debug APK
    ./gradlew :composeApp:assembleDebug

    # install to a connected device (requires a configured Android project/app variant)
    ./gradlew :composeApp:installDebug

3) Desktop
- If the project exposes a desktop run task (Compose Desktop), run it via Gradle. Check available tasks:

    ./gradlew :composeApp:tasks --all | grep -i run

- Common desktop run command (if configured):

    ./gradlew :composeApp:run

4) iOS
- Open `iosApp/iosApp.xcodeproj` in Xcode. Select a simulator/device and build & run.
- You may need to run Gradle tasks first to prepare the shared framework:

    ./gradlew :composeApp:assemble

Development notes
- Avoid committing build outputs and IDE files. Add/maintain a `.gitignore` that excludes:
  - `.gradle/`, `**/build/`, `.idea/`, `.kotlin/`, `local.properties` and other generated artifacts.
- Shared code is under `composeApp/src/commonMain` and platform-specific implementations live in the respective source sets.
- Keep platform-specific UI small; prefer composing UI in the shared module when possible.

Testing
- Run unit tests with Gradle:

    ./gradlew test

- Platform-specific instrumentation tests should be run from Android Studio or Xcode.

Contributing
- Feel free to open issues or submit PRs. When contributing:
  - Keep changes focused and create a feature branch per change.
  - Run `./gradlew build` and ensure tests pass before opening PRs.

License
- Add a license file (`LICENSE`) at the project root if you intend to open-source this project. If you want, I can add an MIT or Apache-2.0 license for you.

Contact / Support
- If you want me to make additional changes (improve README sections, add a `.gitignore`, remove build artifacts from the repo, or create a PR), tell me which item to do next and I'll proceed.

