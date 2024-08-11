package com.astrubale.savanarewrite.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;

public class GliderItem extends Item implements Equipment {

    public GliderItem(Settings settings) {
        super(settings);
    }

    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.CHEST;
    }

    @Override
    public SoundEvent getEquipSound() {
        return Equipment.super.getEquipSound();
    }
}
