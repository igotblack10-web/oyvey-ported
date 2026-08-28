package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;

public class AirJumpModule extends Module {
    private boolean used;

    public AirJumpModule() {
        super("AirJump", "Allows jumping while airborne.", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;

        if (mc.player.onGround()) {
            used = false;
            return;
        }

        if (mc.options.keyJump.isDown() && !used) {
            var velocity = mc.player.getDeltaMovement();
            mc.player.setDeltaMovement(velocity.x, 0.42, velocity.z);
            used = true;
        }

        if (!mc.options.keyJump.isDown()) {
            used = false;
        }
    }
}
