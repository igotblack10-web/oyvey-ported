package me.alpha432.oyvey.features.modules.player;

import me.alpha432.oyvey.features.modules.Module;

/** Automatically respawns the local player when the death screen is open. */
public class AutoRespawnModule extends Module {
    public AutoRespawnModule() {
        super("AutoRespawn", "Automatically respawn after dying.", Category.PLAYER);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        if (mc.player.isDeadOrDying() && mc.screen instanceof net.minecraft.client.gui.screens.DeathScreen) {
            mc.player.respawn();
            mc.setScreen(null);
        }
    }
}
