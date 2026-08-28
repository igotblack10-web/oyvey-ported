package me.alpha432.oyvey.features.modules.player;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;

public class AutoEatModule extends Module {
    private final Setting<Integer> health = num("Health", 8, 1, 20);

    public AutoEatModule() {
        super("AutoEat", "Automatically eats food when health is low.", Category.PLAYER);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        if (mc.player.getHealth() > health.getValue()) {
            mc.options.keyUse.setDown(false);
            return;
        }
        if (!mc.player.isUsingItem() && mc.player.getInventory().items.stream().anyMatch(stack -> stack.isEdible())) {
            mc.options.keyUse.setDown(true);
        }
    }

    @Override
    public void onDisable() {
        if (mc.options != null) mc.options.keyUse.setDown(false);
    }
}
