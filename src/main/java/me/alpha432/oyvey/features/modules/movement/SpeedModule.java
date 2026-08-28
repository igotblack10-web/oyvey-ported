package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;

/**
 * Simple ground/air movement speed multiplier implemented against OyVey's
 * existing attribute API rather than Meteor's event/settings API.
 */
public class SpeedModule extends Module {
    private final Setting<Float> multiplier = num("Multiplier", 2.0f, 1.0f, 5.0f);
    private double previousSpeed;

    public SpeedModule() {
        super("Speed", "Increases movement speed.", Category.MOVEMENT);
    }

    @Override
    public void onEnable() {
        if (nullCheck()) return;

        AttributeInstance attribute = mc.player.getAttribute(Attributes.MOVEMENT_SPEED);
        if (attribute != null) {
            previousSpeed = attribute.getBaseValue();
        }
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;

        AttributeInstance attribute = mc.player.getAttribute(Attributes.MOVEMENT_SPEED);
        if (attribute != null) {
            attribute.setBaseValue(previousSpeed * multiplier.getValue());
        }
    }

    @Override
    public void onDisable() {
        if (nullCheck()) return;

        AttributeInstance attribute = mc.player.getAttribute(Attributes.MOVEMENT_SPEED);
        if (attribute != null) {
            attribute.setBaseValue(previousSpeed);
        }
    }
}
