package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;

/**
 * Simple movement speed multiplier using Minecraft's movement-speed attribute.
 */
public class SpeedModule extends Module {
    private final Setting<Float> multiplier = num("Multiplier", 2.0f, 1.0f, 5.0f);
    private double previousSpeed;
    private boolean savedSpeed;

    public SpeedModule() {
        super("Speed", "Increases movement speed.", Category.MOVEMENT);
    }

    @Override
    public void onEnable() {
        if (nullCheck()) return;

        AttributeInstance attribute = mc.player.getAttribute(Attributes.MOVEMENT_SPEED);
        if (attribute != null) {
            previousSpeed = attribute.getBaseValue();
            savedSpeed = true;
        }
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;

        AttributeInstance attribute = mc.player.getAttribute(Attributes.MOVEMENT_SPEED);
        if (attribute != null && savedSpeed) {
            attribute.setBaseValue(previousSpeed * multiplier.getValue());
        }
    }

    @Override
    public void onDisable() {
        if (!savedSpeed || mc.player == null) return;

        AttributeInstance attribute = mc.player.getAttribute(Attributes.MOVEMENT_SPEED);
        if (attribute != null) {
            attribute.setBaseValue(previousSpeed);
        }
        savedSpeed = false;
    }
}
