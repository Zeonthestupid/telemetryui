package telemetryui;

public class displayItem {
    private String displayName;
    private final String displid;

    public displayItem(String id, String displayName) {
        this.displayName = displayName;
        this.displid = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void changeDisplayName(String newname) {
        this.displayName = newname;
    }
    public String getid() {
        return displid;
    }
}
