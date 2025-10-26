package com.astrubale.savanarewrite.client;

import com.astrubale.savanarewrite.network.packets.GallopC2SPacket;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.PacketByteBuf;

public class ClientInputHandler {
    public static boolean wasGallopKeyPressed = false;

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            boolean isPressed = ModKeyBinding.GALLOP_KEY.isPressed();

            if (isPressed && !wasGallopKeyPressed) {
                sendGallopPacket(true);
                System.out.println("[CLIENT] Gallop START");
            } else if (!isPressed && wasGallopKeyPressed) {
                sendGallopPacket(false);
                System.out.println("[CLIENT] Gallop STOP");
            }

            wasGallopKeyPressed = isPressed;
        });
    }

    private static void sendGallopPacket(boolean galloping) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeBoolean(galloping);
        ClientPlayNetworking.send(GallopC2SPacket.ID, buf);
    }
}
