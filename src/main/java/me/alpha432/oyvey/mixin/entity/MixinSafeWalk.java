package me.alpha432.oyvey.mixin.entity;

import me.alpha432.oyvey.OyVey;
import me.alpha432.oyvey.features.modules.Module;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LocalPlayer.class)
public class MixinSafeWalk {
    @Inject(method = "isStayingOnGroundSurface", at = @At("HEAD"), cancellable = true)
    private void oyvey$forceGroundSurface(CallbackInfoReturnable<Boolean> cir) {
        if (OyVey.moduleManager == null) return;

        Module safeWalk = OyVey.moduleManager.getModuleByName("SafeWalk");
        if (safeWalk != null && safeWalk.isEnabled()) {
            cir.setReturnValue(true);
        }
    }
}
