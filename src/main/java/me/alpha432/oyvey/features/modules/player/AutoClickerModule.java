package me.alpha432.oyvey.features.modules.player;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;

public class AutoClickerModule extends Module {
    private final Setting<Integer> cps = num("CPS", 10, 1, 20);

    public AutoClickerModule() {
        super("AutoClicker", "Automatically performs attack clicks.", Category.PLAYER);
    }

    @Override
    public void onTick() {
        // Input automation is intentionally kept out of the tick loop until a proper
        // mouse/input hook is available, so this module cannot get stuck attacking.
    }
}
