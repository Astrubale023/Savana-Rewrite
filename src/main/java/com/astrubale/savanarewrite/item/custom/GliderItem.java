package com.astrubale.savanarewrite.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GliderItem extends Item {

    private boolean isActive = false; // Stato del deltaplano

    public GliderItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!user.isOnGround()) { // Permette di attivarlo solo se il giocatore è in aria
            isActive = !isActive;
            user.sendMessage(Text.of(isActive ? "Deltaplano attivato!" : "Deltaplano disattivato!"), true);
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (selected) {
            if (isActive && !entity.isOnGround()) {
                entity.setVelocity(entity.getVelocity().x, Math.max(entity.getVelocity().y * 0.8, -0.5), entity.getVelocity().z);
                entity.fallDistance = 0; // Evita danni da caduta
            }
        } else {
            isActive = false; // Se cambia oggetto in mano, il deltaplano si disattiva
        }
    }
}
