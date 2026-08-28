package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;

public class SpiderModule extends Module {
    private final Setting<Float> speed = num("Speed", 0.2f, 0.05f, 1.0f);

    public SpiderModule() {
        super("Spider", "Climb walls while moving into them.", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (nullCheck() || mc.player.onGround() || mc.player.isInWater() || mc.player.isInLava()) return;
        if (mc.player.horizontalCollision && mc.player.zza > 0.0f) {
            mc.player.setDeltaMovement(mc.player.getDeltaMovement().x(), speed.getValue(), mc.player.getDeltaMovement().z());
        }
    }
}
