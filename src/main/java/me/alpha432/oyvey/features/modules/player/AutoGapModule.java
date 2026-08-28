package me.alpha432.oyvey.features.modules.player;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;

public class AutoGapModule extends Module {
    private final Setting<Integer> health = num("Health", 10, 1, 20);

    public AutoGapModule() {
        super("AutoGap", "Automatically uses a golden apple when health is low.", Category.PLAYER);
    }

    @Override
    public void onTick() {
        if (nullCheck() || mc.player.getHealth() > health.getValue() || mc.player.isUsingItem()) return;
        // Actual hotbar selection/use belongs in the inventory/input hook.
    }
}
