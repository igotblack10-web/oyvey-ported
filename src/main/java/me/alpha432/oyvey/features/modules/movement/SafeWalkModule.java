package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;

public class SafeWalkModule extends Module {
    public SafeWalkModule() {
        super("SafeWalk", "Prevents walking off block edges.", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        if (mc.player.onGround()) mc.player.setOnGround(true);
    }
}
