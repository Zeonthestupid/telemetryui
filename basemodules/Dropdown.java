package telemetryui.basemodules;

import telemetryui.core.tuiModule;

public class Dropdown extends tuiModule {
    private final String displayName;
    private final String[] options;

    private final String preselectDeco = "[ ";
    private final String postselectDeco = " ]";
    private int selectedIndex;
    private boolean isSelecting = false; // Tracks if modifying

    public Dropdown(String displayName, String... options) {
        this.displayName = displayName;
        this.options = options;
        this.selectedIndex = 0;
    }

    @Override
    public String display() {
        return displayName + ": "+ preselectDeco + getValue() + postselectDeco;
    }

    @Override
    public void onLeft() {
        selectedIndex = (selectedIndex - 1 + options.length) % options.length;
    }

    @Override
    public void onRight() {
        selectedIndex = (selectedIndex + 1) % options.length;

    }

    @Override
    public String getValue() {
        return options[selectedIndex];
    }
}
