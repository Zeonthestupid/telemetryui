package telemetryui.v1;


// MIGRATION FINISHED!

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
