package telemetryui;


// BASE CLASS

/*
WARNING : Modifying this class can (and most likely will) break functionality.

Since this is an integral part of the system, it is important to keep as is.

If you are looking to create a new menu subclass type, I would suggest creating a NEW class, and building it from there.
 */

public class ListOption {
    private final String displayName;
    private final String[] options;
    private int selectedIndex;
    private boolean isSelecting = false; // Tracks if modifying

    public ListOption(String displayName, String... options) {
        this.displayName = displayName;
        this.options = options;
        this.selectedIndex = 0;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSelectedOption() {
        return options[selectedIndex];
    }

    public void nextOption() {
        selectedIndex = (selectedIndex + 1) % options.length;
    }
    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void previousOption() {
        selectedIndex = (selectedIndex - 1 + options.length) % options.length;
    }

    public void toggleSelecting() {
        isSelecting = !isSelecting;
    }

    public boolean isSelecting() {
        return isSelecting;
    }
}
