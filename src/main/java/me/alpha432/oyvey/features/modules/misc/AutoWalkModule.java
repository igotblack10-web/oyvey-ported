package me.alpha432.oyvey.features.modules.misc;

import me.alpha432.oyvey.features.modules.Module;

public class AutoWalkModule extends Module {
    public AutoWalkModule() {
        super("AutoWalk", "Automatically holds forward while enabled.", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (mc.player != null && mc.currentScreen == null) {
            mc.options.forwardKey.setPressed(true);
        }
    }

    @Override
    public void onDisable() {
        if (mc != null) {
            mc.options.forwardKey.setPressed(false);
        }
    }
}
