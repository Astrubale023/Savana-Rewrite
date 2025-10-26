package com.astrubale.savanarewrite.network;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.entity.custom.OstrichEntity;
import com.astrubale.savanarewrite.network.packets.GallopC2SPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class ModNetworking {

    public static void RegisterC2SPacket() {
        ServerPlayNetworking.registerGlobalReceiver(GallopC2SPacket.ID, new GallopC2SPacket());
    }

}
