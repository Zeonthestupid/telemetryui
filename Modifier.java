package telemetryui;


public class Modifier {
    private final String displayName;
    private double value;
    private final double stepSize;
    private boolean isModifying = false;

    public Modifier(String displayName, double initialValue, double stepSize) {
        this.displayName = displayName;
        this.value = initialValue;
        this.stepSize = stepSize;
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

    public void toggleModifyMode() {
        isModifying = !isModifying;
    }

    public boolean isModifying() {
        return isModifying;
    }
}
