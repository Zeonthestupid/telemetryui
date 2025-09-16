package telemetryui.basemodules;

import telemetryui.core.tuiModule;

public class Classic extends tuiModule {
    String line;
    String data;
    boolean skipping;


    public Classic (String Line) {
        this.line = Line;
        this.data = "";
        this.skipping = true;
    }

    public Classic (String Line, Object Data) {
        this.line = Line;
        this.data = Data.toString();
        this.skipping = true;
    }

    public Classic (String Line, Object Data, boolean skipping) {
        this.line = Line;
        this.data = Data.toString();
        this.skipping = skipping;
    }


    public void updateData(Object Data) {
        data = Data.toString();
    }

    public void updateLine(String Line) {
        line = Line;
    }

    public void updateAll(String Line, Object Data) {
        data = Data.toString();
        line = Line;
    }

    @Override
    public String display() {
        return line + data;
    }

    @Override
    public boolean isSkipping() {
        return skipping;
    }
}
