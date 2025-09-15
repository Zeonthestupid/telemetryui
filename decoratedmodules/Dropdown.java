package telemetryui.decoratedmodules;

import java.util.List;

import telemetryui.core.tuiModule;

public class Dropdown extends tuiModule {

    private final String[] options;
    private final String displayName;
    private boolean isreleased;
    private Boolean isdropdown;

    private List<String> db;

    private final String preselectDeco = "[ ";
    private final String postselectDeco = " ]";

    private int internalPointer;


    public Dropdown(String display, String... options) {
        this.options = options;
        this.displayName = display;
        this.isreleased = true;
        this.isdropdown = false;
        this.internalPointer = 0;
    }
    @Override



    public String display() {
        return (displayName + (isdropdown?":> ":":v ") + preselectDeco + getValue() + postselectDeco);
    }



    @Override
    public List<String> mldisplay() {
        if (isdropdown) {
            db.clear();
            String prefixtext = "";
            for (int i = 0; i < options.length; i++) {
                prefixtext = i == internalPointer ? "> " : "";
                prefixtext = prefixtext + (options[i]);
                db.add(prefixtext);
            }
            return db;


        }else {
            return null;
        }
    }

    @Override
    public boolean inputReleased() {
        return !isdropdown;
    }
    @Override
    public void onDown() {
        internalPointer = (internalPointer - 1 + options.length) % options.length;
    }
    @Override
    public void onUp() {
        internalPointer = (internalPointer - 1 + options.length) % options.length;
    }




    public void onClick() {
        isdropdown= !isdropdown;
    }

    public String getValue() {return options[internalPointer]; }
}
