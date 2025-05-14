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
[![](https://jitpack.io/v/Zeonthestupid/telemetryui.svg)](https://jitpack.io/#Zeonthestupid/telemetryui) 

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
menu.addDisplayItem("1", "Hello"); // example item
```

You use different items from menus (Basic, advanced and Wrappers) to fully create dynamic menus.
### Basic types (Actions, Displayitems)
Actions:
```
// use this method to make a new action. it takes in a runnable and a displayname
menu.addAction("Displayname", () -> motor.setpower(xyz));
```
This action serves as a clickable function, and can run practically anything.

DisplayItems:
```
// Display items can be created with an ID assigned
menu.addDisplayItem("id", "Text to display");
// Then can be changed by
menu.changedisplay("id", "New text");
```
Display items can be menu descriptions or anything that needs a static / dynamic text display.
These are useful for both conventional telemetry (using changedisplay) or for displaying one thing.
You can use this for classic telemetry data as it works with the menu!
### Advanced types (Modifiers, Togglables ListOptions)
Modifiers:
```
menu.addModifier("Displayname", 5, 1);
```
This is the basic usage with the syntax being displayname, starting value, inc/dec value
When you are selected on this and click up / down, you will increase / decrease the value by a factor of the inc/dec value

For more precise cases (or things like pose when you need to be able to move fast but precise when needed),
you can use:
```
menu.addModifier("DisplayName", 5, 5, 1);
```
With displayname, startingval, inc/dec value, precise step value.
Pstep works whenever you hold down A while moving up/down

To get the value of the mod, use:
```
Modifier mod = menu.getMod("DisplayName");
x = mod.getValue();
```
Togglables:
```
menu.addToggleable("OffToggle", "OnToggle", false);
```
Toggles are just display based bools. 
Use "DisplayNameWhenFalse", "DisplayNameWhenTrue", "State"

then to get the state use:
```
Toggleable test = menu.getToggleOption("OffToggle");
test.getstate();
```
Make sure to use the falsename when getting

ListOptions:
```
menu.addListOption("DisplayName", "optionone", "optiontwo");
```
You can add as many as you want!

To get which one is selected, use:
```
ListOption e = menu.getListOption("T");
e.getSelectedOption()
```
or use 
```
e.getSelectedIndex()
```
if thats more of your jam.


### Wrappers (MultiModifier)
Wrappers allow you to fit multiple of things into one menu object.
They do have some limitations (like horizontal size)

MultiModifier:
```
menu.addmultimodifier("pose", new Modifier("x", 64, 1, 0.1), new Modifier("y", 64, 1, 0.1), new Modifier("r", 0, 15, 1));
```
Just define a modifier with a displayname then as many lambda modifiers as you want! 

To get the value from any row, use an index for the list.
```
MultiModifier e = menu.getMultiMod("e");
e.getrowDisplayName(1);
```

## Wanna help?
Shoot me an email - micahwpschmidt@gmail.com
or send me a msg on discord @zeonim
