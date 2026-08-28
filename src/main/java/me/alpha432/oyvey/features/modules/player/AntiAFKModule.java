package me.alpha432.oyvey.features.modules.player;

import me.alpha432.oyvey.features.modules.Module;

/** Periodically sends harmless movement input to keep the client active. */
public class AntiAFKModule extends Module {
    private int timer;

    public AntiAFKModule() {
        super("AntiAFK", "Performs a small periodic movement to avoid inactivity.", Category.PLAYER);
    }

    @Override
    public void onEnable() {
        timer = 0;
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        if (++timer < 100) return;
        timer = 0;
        mc.player.swing(net.minecraft.world.InteractionHand.MAIN_HAND);
    }
}
