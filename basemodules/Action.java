package telemetryui.basemodules;

import telemetryui.core.tuiModule;

public class Action extends tuiModule {
    private final Runnable function;
    private final String displayName;

    public Action(String display, Runnable function) {
        this.function = function;
        this.displayName = display;
    }

    @Override
    public void onClick() {
        function.run();
    }

    public String display() {
        return displayName;
    }
}
