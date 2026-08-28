package me.alpha432.oyvey.features.modules.player;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;

public class ReachModule extends Module {
    private final Setting<Float> reach = num("Reach", 3.0f, 3.0f, 6.0f);

    public ReachModule() {
        super("Reach", "Extends the player's interaction reach.", Category.PLAYER);
    }

    public float getReach() {
        return reach.getValue();
    }
}
