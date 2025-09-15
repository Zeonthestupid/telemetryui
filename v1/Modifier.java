package telemetryui.v1;


public class Modifier {
    private final String displayName;
    private double value;
    private final double stepSize;
    private boolean isModifying = false;
    private final double pstepSize;


    public Modifier(String displayName, double initialValue, double stepSize) {
        this.displayName = displayName;
        this.value = initialValue;
        this.stepSize = stepSize;
        this.pstepSize = stepSize;
    }

    public Modifier(String displayName, double initialValue, double stepSize, double pstepSize) {
        this.displayName = displayName;
        this.stepSize = stepSize;
        this.value = initialValue;
        this.pstepSize = pstepSize;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getValue() {
        return value;
    }

    public void increase() {
        value += stepSize;
    }

    public void decrease() {
        value -= stepSize;
    }

    public void p_increase() {value += pstepSize;}

    public void p_decrease() {value += pstepSize;}

    public void toggleModifyMode() {
        isModifying = !isModifying;
    }

    public boolean isModifying() {
        return isModifying;
    }
}
