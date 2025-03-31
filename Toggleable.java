package telemetryui;


public class Toggleable {
    private final String offname, onname;
    private boolean state;

    public Toggleable(String offname, String onname, boolean state) {
        this.offname = offname;
        this.onname = onname;
        this.state = state;
    }

    public String getDisplayName() {
        if (getstate()) {
            return this.onname;
        } else {
            return this.offname;
        }
    }

    public boolean getstate() {
        return state;
    }

    public void toggle() {
        state = !state;
    }
}
