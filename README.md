# NeverHungryPlugin
Minecraft server plugin for disabling and enabling the hunger feature of vanilla minecraft for all players.

## Platform Information
- Tested on PaperMC (https://papermc.io/) version 1.20.1
- Java version: OpenJDK 17
- Dev Platform: IntelliJ Community Edition

## Installation
1. Using IntelliJ open the pom.xml file
2. Click the icon to import Maven dependencies (this may take a few moments)
3. Expand the Maven tab on the top right to access Maven commands
4. Expand "NeverHungryPlugin" > "Lifecycle" and double click on "Package"
5. Check the console for errors. If there are no errors look in your local project folder for a new folder called "target" This is where you will find the compiled jar file.
6. Place compiled jar (NeverHungryPlugin-1.0.jar) in the server "plugins" folder and restart:


    Example:
    /opt/minecraft/paper/plugins/NeverHungryPlugin-1.0.jar

## Usage:
Note: This plugin is only available to Operators

    Enable plugin: 
    /neverhungry on

    Disable plugin:
    /neverhungry off

    Get plugin status:
    /neverhungry status
