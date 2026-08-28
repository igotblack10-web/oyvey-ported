package me.alpha432.oyvey.features.modules.render;

import me.alpha432.oyvey.features.modules.Module;

/** Keeps the client at maximum gamma while enabled. */
public class FullbrightModule extends Module {
    private double previousGamma;

    public FullbrightModule() {
        super("Fullbright", "Makes dark areas bright.", Category.RENDER);
    }

    @Override
    public void onEnable() {
        if (nullCheck()) return;
        previousGamma = mc.options.gamma().get();
        mc.options.gamma().set(16.0);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        mc.options.gamma().set(16.0);
    }

    @Override
    public void onDisable() {
        if (nullCheck()) return;
        mc.options.gamma().set(previousGamma);
    }
}
