package me.alpha432.oyvey.mixin.render;

import me.alpha432.oyvey.OyVey;
import me.alpha432.oyvey.features.modules.render.ZoomModule;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(GameRenderer.class)
public class MixinGameRendererZoom {
    @ModifyVariable(method = "getFov", at = @At("RETURN"), ordinal = 0)
    private float oyvey$zoomFov(float fov, Camera camera, float partialTicks, boolean applyEffects) {
        ZoomModule zoom = OyVey.moduleManager.getModuleByClass(ZoomModule.class);
        if (zoom == null || !zoom.isEnabled()) return fov;
        return fov / zoom.getZoomFactor();
    }
}
