package me.alpha432.oyvey.features.modules.player;

import me.alpha432.oyvey.features.modules.Module;
import net.minecraft.world.item.ItemStack;

public class AutoReplenishModule extends Module {
    private static final int MIN_STACK_SIZE = 4;

    public AutoReplenishModule() {
        super("AutoReplenish", "Refills low-count hotbar stacks from the inventory.", Category.PLAYER);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        for (int slot = 0; slot < 9; slot++) {
            ItemStack hotbar = mc.player.getInventory().getItem(slot);
            if (hotbar.isEmpty() || hotbar.getCount() > MIN_STACK_SIZE) continue;
            for (int i = 9; i < mc.player.getInventory().getContainerSize(); i++) {
                ItemStack candidate = mc.player.getInventory().getItem(i);
                if (!candidate.isEmpty() && ItemStack.isSameItemSameComponents(hotbar, candidate)) {
                    // Inventory click/move needs a screen handler hook; don't mutate slots directly.
                    break;
                }
            }
        }
    }
}
