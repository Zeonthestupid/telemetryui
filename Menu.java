package telemetryui;

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

    public void addDisplayItem(String displayName) {
        displayItem displayitem = new displayItem(displayName);
        displayitems.add(displayitem);
        menuItems.add(displayitem);
    }

    public void addListOption(String displayName, String... options) {
        ListOption list = new ListOption(displayName, options);
        lists.add(list);
        menuItems.add(list);
    }

    public void addmultimodifier(String displayName, Modifier... options) {
        //finish this
    }

    public void addToggleable(String offname, String onname, Boolean State) {
        Toggleable toggleable = new Toggleable(offname, onname, State);
        toggleables.add(toggleable);
        menuItems.add(toggleable);
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
