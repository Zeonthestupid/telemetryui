package telemetryui.v1;


public class MultiModifier {
    private final String displayName;
    private int row = 0;
    private final Modifier[] options;
    private boolean isModifying = false;

    public MultiModifier(String displayName, Modifier... options) {
        this.displayName = displayName;
        this.options = options;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getrowDisplayName(int row) {
        return options[row].getDisplayName();
    }

    public void nextrow() {
        row = (row + 1 + options.length) % options.length;

    }
    public void prevrow() {
        row = (row - 1);
        if (row < 0) {row = 0;}
    }
    public int getrow() {
        return row;
    }

    public double getrowValue(int row) { // Get selected value
        return options[row].getValue();
    }

    public void increase() { //Increase selected value
        options[row].increase();
    }

    public void decrease() { //Decrease selected value
        options[row].decrease();
    }

    public void p_increase() { //Increase selected value
        options[row].p_increase();
    }

    public void p_decrease() { //Decrease selected value
        options[row].p_decrease();
    }
    public Modifier[] getitems() {
        return options;
    }

    public void toggleModifyMode() {
        isModifying = !isModifying;
    }

    public boolean isModifying() {
        return isModifying;
    }
}
