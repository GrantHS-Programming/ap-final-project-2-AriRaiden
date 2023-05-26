package net.ari.mymod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.ari.mymod.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

import javax.annotation.concurrent.Immutable;
import java.util.Map;
import java.util.Properties;

public class ModArmorItem extends ArmorItem {
    public static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModItems.ArmorTiers.BANANA,
                            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1)).build();
    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties settings) {
        super(material,slot,settings);
    }
}
