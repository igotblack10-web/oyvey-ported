package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;

public class NoSlowModule extends Module {
    public NoSlowModule() {
        super("NoSlow", "Prevents item use from slowing movement.", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        if (mc.player.isUsingItem() && !mc.player.isPassenger()) {
            mc.player.zza = mc.player.input.getMoveVector().y();
            mc.player.xxa = mc.player.input.getMoveVector().x();
        }
    }
}
