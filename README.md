For full info, visit our [docs](https://25929.vercel.app/docs/telemetryui/index.html)

TelemetryUI is built for FTC teams to utilize the telemetry system beyond just displaying data. We tried to provide as many features as possible to make your telemetry system go from okay, to great!

Primarily, it is used to create interactive menus that can run functions and change values, plus, it's competition legal! That being said, you can go wild with implementation.


## Installation

Our jitpack [Package](https://jitpack.io/#Zeonthestupid/telemetryui) is generally more recommended.

Or, if you'd rather, you can clone the repo directly into your project folder!


## Getting Started

To use TUI, use the d-pad on your controller, plus the A button to select.


TelemetryUI is split into four different sections:

- **Core modules** (Which makeup the functionality and must be imported in any project using TUI)

- **Base modules** (Which makeup the base actions of menus such as the ability to run functions, change parameters and more)

- **Decorated modules** (Which are base modules with extra **flair**)

- **Wrapped modules** (Which are ways to wrap other modules into things like dropdowns and columns)


In order to add an instance of telemetryUI to your opMode, you may use the sample code below:

```java
import telemetryui.core.*;

    List<tuiModule> display01 = new ArrayList<>();
    displayBuffer mainmenu = new displayBuffer("0. Main Menu");
    displayManager displaymanager;

    @Override
    public void init() {

        displaymanager = new displayManager(telemetry, gamepad1);
        display01.add(new Action("Stop Robot", this::requestOpModeStop));
        displaymanager.loadBuffer(mainmenu);
        mainmenu.setItems(display01);

    }

    @Override
    public void loop() {
        displaymanager.update();
    }
```

For documentation on how to use the base, or decorated modules, visit our [docs](https://25929.vercel.app/docs/telemetryui/index.html)

