package net.ari.mymod.effect;

import net.ari.mymod.MyMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MyMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
        //4:03 timestamp https://www.youtube.com/watch?v=fm7urzE4pmo
    }
}
