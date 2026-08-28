package me.alpha432.oyvey.mixin.client;

import me.alpha432.oyvey.OyVey;
import me.alpha432.oyvey.features.modules.render.NoRenderModule;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class MixinGameRendererNoRender {
    @Inject(method = "renderLevel", at = @At("HEAD"), cancellable = false)
    private void oyvey$noRenderLevel(CallbackInfo ci) {
        // Hook point for NoRender-specific effects; world rendering itself must remain intact.
        NoRenderModule module = OyVey.moduleManager.getModuleByClass(NoRenderModule.class);
        if (module != null && module.isEnabled()) {
            // Intentionally leave level rendering intact. Individual effect hooks belong here.
        }
    }
}
