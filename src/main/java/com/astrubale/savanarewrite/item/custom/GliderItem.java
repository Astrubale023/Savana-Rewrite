package com.astrubale.savanarewrite.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GliderItem extends Item {

    public GliderItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        NbtCompound nbt = stack.getOrCreateNbt();

        boolean isActive = !nbt.getBoolean("isActive");

        if (!user.isOnGround() && user.getVelocity().y < 0) { // Permette di attivarlo solo se il giocatore sta cadendo
            nbt.putBoolean("isActive", isActive);
            user.sendMessage(Text.of(isActive ? "Deltaplano attivato!" : "Deltaplano disattivato!"), true);
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (selected && entity instanceof PlayerEntity player) {
            NbtCompound nbt = stack.getOrCreateNbt();
            boolean isActive = nbt.getBoolean("isActive");

            if (isActive && !player.isOnGround()) {
                player.setVelocity(player.getVelocity().x, Math.max(player.getVelocity().y * 0.9, -0.6), player.getVelocity().z);
                player.fallDistance = 0; // Evita danni da caduta
            }
        }
    }
}
