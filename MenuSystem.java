package telemetryui;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;


/* How to add new menu items

Create a new class under the TUI root, and import it to both the MenuSystem and the Menu Classes

In your class include:
- Some type of display method (
*/

public class MenuSystem {
    private final Telemetry telemetry;
    private final Gamepad gamepad;
    private boolean lastUp = false;
    private boolean lastDown = false;
    private boolean lastSelect = false;
    private boolean lastLeft = false;
    private boolean lastRight = false;

    public MenuSystem(Telemetry telemetry, Gamepad gamepad) {
        this.telemetry = telemetry;
        this.gamepad = gamepad;
    }

    public void displayMenu(Menu menu) {
        telemetry.addLine("=== " + menu.getMenuName() + " ===");

        // Display items on the menu screen (telemetry)
        for (int i = 0; i < menu.getDisplayItems().size(); i++) {
            displayItem item = menu.getDisplayItems().get(i);
            if (item != null) {
                telemetry.addLine( "- " + item.getDisplayName() + "  ");
            }
        }

        // Add to this to add to the object display buffer
        for (int i = 0; i < menu.getMenuItems().size(); i++) {
            Object item = menu.getMenuItems().get(i);
            boolean isSelected = (i == menu.getSelectedIndex());
            String prefix = isSelected ? "> " : "  ";

            if (item instanceof Action) {
                telemetry.addLine(prefix + ((Action) item).getDisplayName());
            }
            else if (item instanceof Modifier) {
                Modifier modifier = (Modifier) item;
                String modifyingText = modifier.isModifying() ? "[ " : "  ";
                String modifyingTexttwo = modifier.isModifying() ? " ]" : "  ";
                telemetry.addLine(prefix + modifier.getDisplayName() + ": " + modifyingText + modifier.getValue() + modifyingTexttwo);
            }
            else if (item instanceof ListOption) {
                ListOption list = (ListOption) item;
                String selectingText = list.isSelecting() ? " [ " : "  ";
                String selectingTexttwo = list.isSelecting() ? " ]" : "  ";
                telemetry.addLine(prefix + list.getDisplayName() + ": "+ selectingText + list.getSelectedOption() + selectingTexttwo);
            }
            else if (item instanceof MultiModifier) {
                MultiModifier m_modifier = (MultiModifier) item;
                String telemetryOutput = "";
                for (int j = 0; j < m_modifier.getitems().length; j++) {
                    String selectingText = m_modifier.isModifying() ? "[" : "";
                    String selectingTexttwo = m_modifier.isModifying() ? "]" : "";
                    // Put brackets around selected rows
                    String indextext = (m_modifier.getrow() == j) ? "(" : " ";
                    String indextexttwo = (m_modifier.getrow() == j) ? ")" : " ";
                    // Telemetry output for this
                    telemetryOutput = telemetryOutput + indextext + selectingText + m_modifier.getrowDisplayName() + m_modifier.getrowValue(i) + selectingTexttwo + indextexttwo;
                }
                telemetry.addLine(telemetryOutput);
            }
            else if (item instanceof Toggleable) {
                Toggleable tgle = (Toggleable) item;
                telemetry.addLine(tgle.getDisplayName());
            }
        }
        telemetry.update();

        boolean upPressed = gamepad.dpad_up && !lastUp;
        boolean downPressed = gamepad.dpad_down && !lastDown;
        boolean selectPressed = gamepad.a && !lastSelect;
        boolean leftPressed = gamepad.dpad_left && !lastLeft;
        boolean rightPressed = gamepad.dpad_right && !lastRight;

        Object selectedItem = menu.getMenuItems().get(menu.getSelectedIndex());

        if (upPressed) {
            if (selectedItem instanceof Modifier && ((Modifier) selectedItem).isModifying()) {
                menu.modifySelected(true);
            }
            else if (selectedItem instanceof ListOption && ((ListOption) selectedItem).isSelecting()) {
                menu.modifySelected(true);
            }
            else if (selectedItem instanceof MultiModifier && ((MultiModifier) selectedItem).isModifying()) {
                menu.modifySelected(true);
            }
            else {
                menu.previousItem();
            }
        }

        if (downPressed) {
            if (selectedItem instanceof Modifier && ((Modifier) selectedItem).isModifying()) {
                menu.modifySelected(false);
            }
            else if (selectedItem instanceof ListOption && ((ListOption) selectedItem).isSelecting()) {
                menu.modifySelected(false);
            }
            else if (selectedItem instanceof MultiModifier && ((MultiModifier) selectedItem).isModifying()) {
                menu.modifySelected(false);
            }
            else {
                menu.nextItem();
            }
        }

        if (selectPressed) {
            menu.executeSelected();
        }
        if (leftPressed) {
            menu.prevrow();
        }
        if (rightPressed) {
            menu.nextrow();
        }
        lastUp = gamepad.dpad_up;
        lastDown = gamepad.dpad_down;
        lastSelect = gamepad.a;
        lastLeft = gamepad.dpad_left;
        lastRight = gamepad.dpad_right;
    }
}
