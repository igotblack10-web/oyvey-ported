package me.alpha432.oyvey.features.modules.misc;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.setting.Setting;

public class AntiAFKModule extends Module {
    public final Setting<Integer> interval = add(new Setting<>("Interval", 20, 1, 600));

    public AntiAFKModule() {
        super("AntiAFK", "Prevents simple AFK timeouts.", Category.MISC);
    }

    @Override
    public void onUpdate() {
        if (mc.player == null || mc.getNetworkHandler() == null) return;
        if (mc.player.age % interval.getValue() != 0) return;
        mc.player.networkHandler.sendChatCommand("list");
    }
}
