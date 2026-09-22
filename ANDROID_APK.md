# AetherFall Android APK
This Android wrapper opens the live AetherFall application at https://redbound-rpg.hatchable.site in an Android WebView.

It requests microphone permission only when the web app asks for audio capture, supporting AetherFall's press-to-talk interaction.

## Build
GitHub Actions runs **Build AetherFall APK** and uploads `app-debug.apk` as the artifact `AetherFall-v68-debug-apk`.

Package: `org.aetherfall.app`
Minimum Android: 8.0 (API 26)
