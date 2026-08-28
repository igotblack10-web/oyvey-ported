package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;

/**
 * Prevents the local player from stepping off ledges while enabled.
 * The actual movement hook lives in MixinSafeWalk.
 */
public class SafeWalkModule extends Module {
    public SafeWalkModule() {
        super("SafeWalk", "Prevents walking off block edges.", Category.MOVEMENT);
    }
}
