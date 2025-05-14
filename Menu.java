package telemetryui;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

// Menu Handler

/*
WARNING : Modifying this class can (and most likely will) break functionality.
 */
public class Menu {
    private final String menuName;
    private final List<Action> actions;
    private final List<Modifier> modifiers;
    private final List<ListOption> lists;
    private final List<Object> menuItems;
    private final List<displayItem> displayitems;
    private final List<Toggleable> toggleables;
    private final List<MultiModifier> multimodifiers;
    private int selectedIndex;

    public Menu(String menuName) {
        this.menuName = menuName;
        this.actions = new ArrayList<>();
        this.modifiers = new ArrayList<>();
        this.lists = new ArrayList<>();
        this.displayitems = new ArrayList<>();
        this.toggleables = new ArrayList<>();
        this.menuItems = new ArrayList<>();
        this.multimodifiers = new ArrayList<>();
        this.selectedIndex = 0;
    }

    public void addAction(String displayName, Runnable function) {
        Action action = new Action(displayName, function);
        actions.add(action);
        menuItems.add(action);
    }

    public void addModifier(String displayName, double initialValue, double stepSize) {
        Modifier modifier = new Modifier(displayName, initialValue, stepSize);
        modifiers.add(modifier);
        menuItems.add(modifier);
    }
    public void addModifier(String displayName, double initialValue, double stepSize, double pstepsize) {
        Modifier modifier = new Modifier(displayName, initialValue, stepSize, pstepsize);
        modifiers.add(modifier);
        menuItems.add(modifier);
    }

    public void addDisplayItem(String id , String displayName) {
        displayItem displayitem = new displayItem(id, displayName);
        displayitems.add(displayitem);
    }

    public void addListOption(String displayName, String... options) {
        ListOption list = new ListOption(displayName, options);
        lists.add(list);
        menuItems.add(list);
    }

    public void addmultimodifier(String displayName, Modifier... options) {
        MultiModifier mmod = new MultiModifier(displayName, options);
        multimodifiers.add(mmod);
        menuItems.add(mmod);
    }

    public void addToggleable(String offname, String onname, Boolean State) {
        Toggleable toggleable = new Toggleable(offname, onname, State);
        toggleables.add(toggleable);
        menuItems.add(toggleable);
    }

    public Toggleable getToggleOption(String offname){
        for (Toggleable toggleable : toggleables) {
            if (toggleable.getOffname().equals(offname)){
                return toggleable;
            }
        }
        return null;
    }

    public ListOption getListOption(String displayName) {
        for (ListOption list : lists) {
            if (list.getDisplayName().equals(displayName)) {
                return list;
            }
        }
        return null;
    }

    public MultiModifier getMultiMod(String displayName) {
        for (MultiModifier mmod: multimodifiers) {
            if (mmod.getDisplayName().equals(displayName)) {
                return mmod;
            }
        }
        return null;
    }

    public void changedisplay(String id, String newDisplay) {
        for (displayItem displayitem: displayitems) {
            if (displayitem.getid().equals(id)) {
                displayitem.changeDisplayName(newDisplay);
            }
        }
    }


    public void nextItem() {
        selectedIndex = (selectedIndex + 1) % menuItems.size();
    }

    public void previousItem() {
        selectedIndex = (selectedIndex - 1 + menuItems.size()) % menuItems.size();
    }

    public void executeSelected() {
        Object selectedItem = menuItems.get(selectedIndex);
        if (selectedItem instanceof Action) {
            ((Action) selectedItem).execute();
        } else if (selectedItem instanceof Modifier) {
            ((Modifier) selectedItem).toggleModifyMode();
        } else if (selectedItem instanceof ListOption) {
            ((ListOption) selectedItem).toggleSelecting();
        } else if (selectedItem instanceof Toggleable) {
            ((Toggleable) selectedItem).toggle();
        } else if (selectedItem instanceof MultiModifier) {
            ((MultiModifier) selectedItem).toggleModifyMode();
        }
    }

    public void modifySelected(boolean increase) {
        Object selectedItem = menuItems.get(selectedIndex);

        if (selectedItem instanceof Modifier) {
            Modifier modifier = (Modifier) selectedItem;
            if (modifier.isModifying()) {
                if (increase) modifier.increase();
                else modifier.decrease();
            }
        }
        else if (selectedItem instanceof ListOption) {
            ListOption list = (ListOption) selectedItem;
            if (list.isSelecting()) {
                if (increase) list.nextOption();
                else list.previousOption();
            }
        }
        else if (selectedItem instanceof MultiModifier) {
            MultiModifier mmod = (MultiModifier) selectedItem;
            if (mmod.isModifying()) {
                if (increase) mmod.increase();
                else mmod.decrease();
            }
        }
    }

    public void preciceModifySelected (boolean increase) {
        Object selectedItem = menuItems.get(selectedIndex);
        if (selectedItem instanceof Modifier) {
            Modifier modifier = (Modifier) selectedItem;
            if (modifier.isModifying()) {
                if (increase) modifier.p_increase();
                else modifier.p_decrease();
            }
        }

        else if (selectedItem instanceof MultiModifier) {
            MultiModifier mmod = (MultiModifier) selectedItem;
            if (mmod.isModifying()) {
                if (increase) mmod.p_increase();
                else mmod.p_decrease();
            }
        }
    }

    public void nextrow() {
        Object selectedItem = menuItems.get(selectedIndex);
        if (selectedItem instanceof MultiModifier) {
            MultiModifier mmod = (MultiModifier) selectedItem;
            if (!mmod.isModifying()) {
                mmod.nextrow();
            }
        }
    }
    public void prevrow() {
        Object selectedItem = menuItems.get(selectedIndex);
        if (selectedItem instanceof MultiModifier) {
            MultiModifier mmod = (MultiModifier) selectedItem;
            if (!mmod.isModifying()) {
                mmod.prevrow();
            }
        }
    }



    public int getSelectedIndex() {
        return selectedIndex;
    }

    public List<Object> getMenuItems() {
        return menuItems;
    }

    public List<displayItem> getDisplayItems() {
        return displayitems;
    }

    public String getMenuName() {
        return menuName;
    }
}
