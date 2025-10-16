package com.astrubale.savanarewrite.client;

import com.astrubale.savanarewrite.SavanaRewrite;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ModKeyBinding {

    public static KeyBinding GALLOP_KEY;

    public static void registerModKeyBindings() {
        GALLOP_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                SavanaRewrite.MOD_ID + ".key.gallop",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                SavanaRewrite.MOD_ID + ".category.controls"
        ));

        SavanaRewrite.LOGGER.info("Registered key bindings for " + SavanaRewrite.MOD_ID);
    }
}