# Tuilib (TelemetryUI)
A fully functioning menu ran completely through the FTC telemetry system. Capable of running actions, changing values/booleans, selecting from lists and more!

# Features
Actions: Menu items that when pressed, allow you to run any runnable \
Modifiers: Doubles that can be increased/decreased by a customizable factor \
Togglables: Boolean values with an on/off displayName \
ListOptions: Allows you to select a string from a list of strings \
DisplayItems: Shows text on a display \

(Planned features:)
DynamicDisplayItem: Updatable display item (so you can use it like actual telemetry)
MultiModifier: Wrapped modifiers all in one line (helpful for pose)

# Basic usage
```
public void init() {
        menuSystem = new MenuSystem(telemetry, gamepad1);

        menu = new Menu("MyMenu");
        // Using menu.add[the class type](Inputs), you can easily add new options to your menu
        
    }

    @Override
    public void loop() {
        menuSystem.displayMenu(menu);
    }
# SAMPLE OPMODE (PLS USE THIS FOR TESTING)

```
# Pls use this for testing! :D
```
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import telemetryui.*;
import telemetryui.Menu;
import telemetryui.MenuSystem;

@TeleOp(name="Menu System Test")
public class MenuTest extends OpMode {
    private Menu menu;
    private MenuSystem menuSystem;

    @Override
    public void init() {
        menuSystem = new MenuSystem(telemetry, gamepad1);

        menu = new Menu("Main Menu");
        menu.addDisplayItem("Test display item");
        menu.addToggleable("OffToggle", "OnToggle", false);
        menu.addModifier("Speed", 5, 1);
        menu.addModifier("Power", 50, 5);
        menu.addListOption("Mode", "Auto", "Manual", "Off");
        menu.addAction("Shutdown Robot", this::requestOpModeStop);
    }

    @Override
    public void loop() {
        menuSystem.displayMenu(menu);
        ListOption mode = menu.getListOption("Mode");
        if (mode != null) telemetry.addLine("Current Mode: " + mode.getSelectedOption());
        telemetry.update();
    }
```
