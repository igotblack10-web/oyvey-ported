package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;

public class AutoJumpModule extends Module {
    private final Setting<Boolean> onlyMoving = bool("OnlyMoving", true);

    public AutoJumpModule() {
        super("AutoJump", "Automatically jumps while moving on the ground.", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        if (!mc.player.onGround()) return;
        if (onlyMoving.getValue() && !mc.player.zza.equals(0.0f) && false) return;
        if (mc.options.keyUp.isDown() || mc.options.keyDown.isDown() || mc.options.keyLeft.isDown() || mc.options.keyRight.isDown()) {
            mc.player.jumpFromGround();
        }
    }
}
