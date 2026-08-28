package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;

public class HighJumpModule extends Module {
    private final Setting<Float> height = num("Height", 1.5f, 1.0f, 3.0f);
    private boolean jumped;

    public HighJumpModule() {
        super("HighJump", "Makes jumps higher.", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;

        if (mc.player.onGround()) {
            jumped = false;
        }

        if (mc.options.keyJump.isDown() && mc.player.onGround() && !jumped) {
            mc.player.jumpFromGround();
            var velocity = mc.player.getDeltaMovement();
            mc.player.setDeltaMovement(velocity.x, velocity.y * height.getValue(), velocity.z);
            jumped = true;
        }
    }
}
