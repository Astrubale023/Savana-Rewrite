package com.astrubale.savanarewrite.network;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.entity.custom.OstrichEntity;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class ModNetworking {

    public static final Identifier GALLOP_PACKET_ID = new Identifier(
            SavanaRewrite.MOD_ID, "gallop_packet");

    public static void RegisterC2SPacket() {
        ServerPlayNetworking.registerGlobalReceiver(GALLOP_PACKET_ID,
            (server, player, handler, buf, responseSender) -> {
                server.execute(() -> {
                    boolean bl = buf.readBoolean();
                    if (bl) {
                        if (player.hasVehicle()) {
                            System.out.println("[server] Gallop start");
                            Entity isOstrich = player.getVehicle();
                            if (isOstrich instanceof OstrichEntity) {
                                OstrichEntity ostrich = (OstrichEntity) player.getVehicle();
                                ostrich.setGallop(true);
                            }
                        }
                        else {
                            System.out.println("[server] No vehicle found");
                        }
                    }
                    else {
                        if (player.hasVehicle()) {
                            System.out.println("[server] Gallop stop");
                            Entity isOstrich = player.getVehicle();
                            if (isOstrich instanceof OstrichEntity) {
                                OstrichEntity ostrich = (OstrichEntity) player.getVehicle();
                                ostrich.setGallop(false);
                            }
                        }
                        else {
                            System.out.println("[server] No vehicle found");
                        }
                    }
                });
            });
    }

}
