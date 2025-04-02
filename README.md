# Tuilib (TelemetryUI)
A fully functioning menu ran completely through the FTC telemetry system. Capable of running actions, changing values/booleans, selecting from lists and more!

# Features
Actions: Menu items that when pressed, allow you to run any runnable \
Modifiers: Doubles that can be increased/decreased by a customizable factor \
Togglables: Boolean values with an on/off displayName \
ListOptions: Allows you to select a string from a list of strings \
DisplayItems: Shows text on a display (Use this if you want standard telemetry to still show on the menu) \
Multimodifier: Wrapped modifiers that allow for easy multi-value functions (ex. Pose)


# Installation

Follow the steps listed on here! \
\
[![](https://jitpack.io/v/Zeonthestupid/telemetryui.svg)](https://jitpack.io/#Zeonthestupid/telemetryui) \

Or you can clone the repository into your already existing codebase

# Basic usage
To start create all the menu / menusystem objects needed
```
private MenuSystem menuSystem;
menuSystem = new MenuSystem(telemetry, gamepad1);
```

from there you can create menus, and items within those menus

```
Menu menu = new Menu("Main Menu");
menu.addDisplayItem("1", "Hello");
```

### Basic types (Actions, Displayitems)
Actions:
```
// use this method to make a new action. it takes in a runnable and a displayname
menu.addAction("Displayname", () -> motor.setpower(xyz));
```
DisplayItems:
```
// Display items can be created with an ID assigned
menu.addDisplayItem("id", "Text to display");
// Then can be changed by
menu.changedisplay("id", "New text");
```
### Advanced types (Modifiers, Togglables ListOptions)

### Wrappers (MultiModifier)
