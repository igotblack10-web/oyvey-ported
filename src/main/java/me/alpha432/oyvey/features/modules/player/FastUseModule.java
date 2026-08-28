package me.alpha432.oyvey.features.modules.player;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;

public class FastUseModule extends Module {
    private final Setting<Integer> ticks = num("Ticks", 0, 0, 20);

    public FastUseModule() {
        super("FastUse", "Reduces the use-item delay.", Category.PLAYER);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        if (mc.player.getUseItem().isEmpty()) return;
        mc.player.setUseItemRemainingTicks(Math.min(mc.player.getUseItemRemainingTicks(), ticks.getValue()));
    }
}
