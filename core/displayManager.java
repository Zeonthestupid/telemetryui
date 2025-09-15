package telemetryui.core;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.List;

/* wtf is this class?
- Sets up and handles all inputs. Will be initialized ONCE in an opmode to handle every and all parts needed.
*/

public class displayManager {
    private final Telemetry telemetry;
    private final Gamepad gamepad;
    private int enabled = 1;
    private boolean lastUp = false;
    private boolean lastDown = false;
    private boolean lastSelect = false;
    private boolean lastLeft = false;
    private boolean lastRight = false;
    private displayBuffer loadedbuffer;

    /* If ur gonna configure anything, check if it's in here! */
    String decoMenu = "===";
    String decoMenuPadding = " "; // Space between deco menu and text (Def: " ")
    String decoPreSelect = "> "; // Deco, DisplayName (Def: "> "
    String decoPostSelect = ""; //(Def: "")

    /* LEAVE BLANK tyty */
    String prevbuffer;
    String postbuffer;

    public void loadBuffer(displayBuffer db) {
        this.loadedbuffer = db;
    }
    public displayManager(Telemetry telemetry, Gamepad gamepad) {
        this.telemetry = telemetry;
        this.gamepad = gamepad;

    }

    public void update() {
        if (this.enabled == 1) {
            telemetry.addLine(decoMenu + decoMenuPadding + loadedbuffer.getName() + decoMenuPadding + decoMenu);
            // Adds menu (1/3 buffers)

            for (int i = 0; i < this.loadedbuffer.getLength(); i++) {
                tuiModule item = loadedbuffer.getItems().get(i);

                if (item != null) {
                    Boolean isSelected = loadedbuffer.getselectedIndex()==i;
                    prevbuffer = isSelected? decoPreSelect : "  ";
                    postbuffer = isSelected? decoPostSelect: "";
                    if (item.mldisplay()==null) {
                        telemetry.addLine(prevbuffer + item.display() + postbuffer);
                    } else {
                        List<String> ml = item.mldisplay();
                        for (int j=0; j< ml.size(); j++) {
                            telemetry.addLine(ml.get(j));
                        }
                    }
                    // Adds non MLdisplay Items
                }
            }


            boolean upPressed = gamepad.dpad_up && !lastUp;
            boolean downPressed = gamepad.dpad_down && !lastDown;
            boolean selectPressed = gamepad.a && !lastSelect;
            boolean leftPressed = gamepad.dpad_left && !lastLeft;
            boolean rightPressed = gamepad.dpad_right && !lastRight;


            tuiModule item = loadedbuffer.getItems().get(loadedbuffer.getselectedIndex());
            if (upPressed) {
                if (item.inputReleased()) {
                    loadedbuffer.nextItem();
                } else {
                    item.onUp();
                }
            }

            if (downPressed) {
                if (item.inputReleased()) {
                    loadedbuffer.previousItem();
                } else {
                    item.onDown();
                }
            }
            if (leftPressed) {
                item.onLeft();
            }
            if (rightPressed) {
                item.onRight();
            }

            if (selectPressed) {
                item.onClick();
            }

            lastUp = gamepad.dpad_up;
            lastDown = gamepad.dpad_down;
            lastSelect = gamepad.a;
            lastLeft = gamepad.dpad_left;
            lastRight = gamepad.dpad_right;
            telemetry.update();
        }
    }

    public void disable() {
        this.enabled = 0;
    }
    public void enable() {
        this.enabled = 1;
    }
}
