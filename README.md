# Theme Randomizer for JetBrains IDEs

A fun plugin that randomly changes your IDE theme at specified intervals or on demand. Add some variety to your coding experience!

## Features

- 🎨 **Manual Theme Randomization** - Change your theme instantly with a keyboard shortcut or menu action
- ⏰ **Automatic Theme Switching** - Set an interval (in minutes) to automatically randomize themes
- 🎯 **Smart Theme Matching** - Automatically applies matching editor color schemes with UI themes
- ⚙️ **Customizable Settings** - Enable/disable auto-randomization and set your preferred interval

## Installation

### Manual Installation
1. Download the latest release from the [Releases](https://github.com/ramonpiha/RiderThemeRandomizer/releases) page
2. Open your IDE and go to `Settings/Preferences` → `Plugins`
3. Click the three vertical dots icon and select `Install Plugin from Disk...`
4. Select the downloaded `.zip` file
5. Restart your IDE

## Usage

### Manual Randomization
- **Keyboard Shortcut**: Press `Ctrl+Alt+T` (Windows/Linux) or `Cmd+Alt+T` (Mac)
- **Menu**: Go to `Tools` → `Randomize Theme`

### Automatic Randomization
1. Go to `Settings/Preferences` → `Tools` → `Theme Randomizer`
2. Check **"Enable Auto-Randomization"**
3. Set your desired **interval in minutes** (default: 30 minutes, range: 1-1440 minutes)
4. Click `Apply` or `OK`

The plugin will now automatically change your theme at the specified interval!

## Configuration

| Setting | Description | Default |
|---------|-------------|---------|
| Enable Auto-Randomization | Toggle automatic theme switching | Disabled |
| Interval (minutes) | How often to change themes automatically | 30 minutes |

## Compatibility

- **Platform**: JetBrains IDEs (IntelliJ Platform)
- **Build Range**: 252 - 253.*
- **Tested On**: Rider 2025.2.2.1
- **Should Work On**: IntelliJ IDEA, WebStorm, PyCharm, PhpStorm, CLion, and other JetBrains IDEs

## How It Works

The plugin:
1. Retrieves all installed UI themes from your IDE
2. Randomly selects one theme
3. Applies both the UI theme and its matching editor color scheme
4. (If auto-randomization is enabled) Schedules the next theme change based on your interval

## Building from Source

### Prerequisites
- JDK 21 or higher
- Gradle

### Build Steps
```bash
# Clone the repository
git clone https://github.com/yourusername/theme-randomizer.git
cd theme-randomizer

# Build the plugin
./gradlew buildPlugin

# The plugin will be in build/distributions/
```

### Running in Development
```bash
./gradlew runIde
```

## Project Structure

```
theme-randomizer/
├── src/main/kotlin/com/ramon/themerandomizer/
│   ├── RandomizeThemeAction.kt          # Manual theme change action
│   ├── ThemeRandomizerConfigurable.kt   # Settings UI
│   ├── ThemeRandomizerSettings.kt       # Settings persistence
│   ├── ThemeRandomizerService.kt        # Auto-randomization scheduler
│   └── ThemeUtils.kt                    # Shared theme logic
├── src/main/resources/META-INF/
│   └── plugin.xml                       # Plugin configuration
├── build.gradle.kts                     # Build configuration
└── README.md
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Future Ideas

- [ ] Option to exclude specific themes from randomization
- [ ] Theme favorites/weighting system
- [ ] Different randomization modes (sequential, weighted random, etc.)
## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

**Ramon**

## Acknowledgments

- Built with the [IntelliJ Platform SDK](https://plugins.jetbrains.com/docs/intellij/welcome.html)
- Inspired by the need for more visual variety while coding!

---

**Enjoy your colorful coding experience! 🎨✨**
