package telemetryui.core;

import java.util.ArrayList;
import java.util.List;

/*

    Prev: Menu's

    Display buffers are simply lightweight packages that store a pointer and list of tuiModules.z

    They also allow complex stuff (later) like rendering multi lists, ect.
    Simply put, put ur shit in a buffer, and get shit out!
 */
public class displayBuffer {
    private final String daname;
    private List<tuiModule> menuItems;
    private int selectedIndex;

    public displayBuffer(String menuName) {
        this.daname = menuName;
        this.menuItems = new ArrayList<>();
        this.selectedIndex = 0;
    }

    /* passthrough to upper modules (primarily displaymanager)


     */
    public String getName() {
        return daname;
    }
    public tuiModule getCurrent() {
        return menuItems.get(selectedIndex);
    }
    public void nextItem() {
        selectedIndex = (selectedIndex + 1) % menuItems.size();
    }

    public void previousItem() {
        selectedIndex = (selectedIndex - 1 + menuItems.size()) % menuItems.size();
    }


    /*
    Literally does the same thing, just put here for simplicity
     */
    public void updateItems(List<tuiModule> dalist) {
        menuItems = dalist;
    }
    public void setItems(List<tuiModule> dalist) {
        menuItems = dalist;
    }


    /* Gets and Helper functions */

    public int getselectedIndex() {
        return selectedIndex;
    }

    public List<tuiModule> getItems() {
        return menuItems;
    }
    public int getLength() {
        return menuItems.size();
    }

    public Object getValue(int Index){
        return menuItems.get(Index);
    }

}
