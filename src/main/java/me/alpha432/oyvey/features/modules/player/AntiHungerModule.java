package me.alpha432.oyvey.features.modules.player;

import me.alpha432.oyvey.features.modules.Module;

/** Prevents normal hunger exhaustion by keeping the player's exhaustion level at zero. */
public class AntiHungerModule extends Module {
    public AntiHungerModule() {
        super("AntiHunger", "Prevents hunger exhaustion.", Category.PLAYER);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        mc.player.getFoodData().setExhaustion(0.0f);
    }
}
