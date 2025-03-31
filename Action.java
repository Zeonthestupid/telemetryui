package telemetryui;

// BASE CLASS

/*
WARNING : Modifying this class can (and most likely will) break action functionality.

Since this is an integral part of the system, it is important to keep as is.

If you are looking to create a new menu subclass type, I would suggest creating a NEW class, and building it from there.
 */
public class Action {
    private final String displayName;
    private final Runnable function;

    public Action(String displayName, Runnable function) {
        this.displayName = displayName;
        this.function = function;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void execute() {
        function.run();
    }
}

