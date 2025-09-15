package telemetryui.basemodules;

import telemetryui.core.tuiModule;

public class Modifier extends tuiModule {
    private final String displayName;
    private double value;
    private final double stepSize;
    private boolean isModifying = false;


    public Modifier(String displayName, double initialValue, double stepSize) {
        this.displayName = displayName;
        this.value = initialValue;
        this.stepSize = stepSize;
    }



    @Override
    public void onClick() {
        if (isModifying) {
            isModifying=false;
        } else {
            isModifying=true;
        }
    }

    @Override
    public void onDown() {
        value -= 1;
    }

    @Override
    public void onUp() {
        value += 1;
    }


    @Override
    public boolean inputReleased() {
        return !isModifying;
    }

    public Double getValue() {
        return value;
    }

}
