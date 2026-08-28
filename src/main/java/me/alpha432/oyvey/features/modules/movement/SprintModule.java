package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;

public class SprintModule extends Module {
    public SprintModule() {
        super("Sprint", "Automatically sprints while moving.", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;

        if (mc.player.zza != 0 || mc.player.xxa != 0) {
            mc.player.setSprinting(true);
        }
    }

    @Override
    public void onDisable() {
        if (nullCheck()) return;
        mc.player.setSprinting(false);
    }
}
