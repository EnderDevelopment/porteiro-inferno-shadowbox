package com.enderdevelopment.shadowboxresearch;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod("shadowboxresearch")
public class ShadowboxResearch {
    public static final String MOD_ID = "shadowboxresearch";

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<EntityType<HellGatekeeperEntity>> HELL_GATEKEEPER = ENTITY_TYPES.register("hell_gatekeeper",
            () -> EntityType.Builder.of(HellGatekeeperEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f)
                    .build("hell_gatekeeper"));

    public ShadowboxResearch() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ENTITY_TYPES.register(modEventBus);
    }
}