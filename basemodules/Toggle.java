package telemetryui.basemodules;


import telemetryui.core.tuiModule;

public class Toggle extends tuiModule {
    private final String offname, onname;
    private boolean state;

    public Toggle(String offname, String onname, boolean state) {
        this.offname = offname;
        this.onname = onname;
        this.state = state;
    }


    @Override
    public String display() {
        if (state) {
            return onname;
        } else {
            return offname;
        }
    }

    @Override
    public Boolean getValue() {
        return state;
    }
}
