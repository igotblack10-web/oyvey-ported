package me.alpha432.oyvey.features.modules.render;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;

public class ZoomModule extends Module {
    private final Setting<Float> zoom = num("Zoom", 3.0f, 1.0f, 10.0f);

    public ZoomModule() {
        super("Zoom", "Zooms the camera view.", Category.RENDER);
    }
}
