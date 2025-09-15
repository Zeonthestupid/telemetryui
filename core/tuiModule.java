package telemetryui.core;

import java.util.List;

public abstract class tuiModule {
    public void onRight() {}
    public void onUp() {}
    public void onDown() {}
    public void onClick() {}
    public void onLeft() {}



    public boolean inputReleased() {return true;}


    public String display() {
        return "DisplayNotOverridden.";
    }

    public List<String> mldisplay() {
        return null;
    }


    public Object getValue() {
        return null;
    }



}
