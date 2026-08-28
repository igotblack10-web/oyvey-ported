package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;

public class AutoWalkModule extends Module {
    public AutoWalkModule() {
        super("AutoWalk", "Automatically walks forward.", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (nullCheck() || mc.screen != null) return;
        mc.player.zza = 1.0f;
    }
}
