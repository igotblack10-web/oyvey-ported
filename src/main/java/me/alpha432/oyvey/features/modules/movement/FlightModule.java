package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;

public class FlightModule extends Module {
    private final Setting<Float> speed = num("Speed", 0.5f, 0.1f, 2.0f);

    public FlightModule() {
        super("Flight", "Fly around freely.", Category.MOVEMENT);
    }

    @Override
    public void onEnable() {
        if (nullCheck()) return;
        mc.player.getAbilities().flying = true;
    }

    @Override
    public void onDisable() {
        if (nullCheck()) return;
        mc.player.getAbilities().flying = false;
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        mc.player.getAbilities().flying = true;
        mc.player.getAbilities().setFlyingSpeed(speed.getValue() / 10.0f);
    }
}
