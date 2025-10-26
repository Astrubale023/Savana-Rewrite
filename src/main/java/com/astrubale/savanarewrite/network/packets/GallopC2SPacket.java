package com.astrubale.savanarewrite.network.packets;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.entity.custom.OstrichEntity;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class GallopC2SPacket implements ServerPlayNetworking.PlayChannelHandler {

    public static final Identifier ID = new Identifier(SavanaRewrite.MOD_ID, "gallop");

    @Override
    public void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        boolean galloping = buf.readBoolean();

        server.execute(() -> {
            if(player.hasVehicle() && player.getVehicle() instanceof OstrichEntity ostrich) {
                ostrich.setGallop(true);
                System.out.println("[server] Gallop " + (galloping ? "start" : "stop"));
            } else {
                System.out.println("[server] No vehicle found");
            }
        });
    }
}
