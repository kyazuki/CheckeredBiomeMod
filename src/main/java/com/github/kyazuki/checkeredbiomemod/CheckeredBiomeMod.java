package com.github.kyazuki.checkeredbiomemod;

import net.minecraft.server.dedicated.ServerProperties;
import net.minecraft.world.WorldType;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CheckeredBiomeMod.MODID)
@Mod.EventBusSubscriber
public class CheckeredBiomeMod {
  public static final String MODID = "checkeredbiomemod";
  public static final Logger LOGGER = LogManager.getLogger(MODID);
  public static WorldType CHECKERED_WORLD_TYPE;

  public CheckeredBiomeMod() {
    LOGGER.debug("CheckeredBiomeMod Loaded!");
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::dedicatedServerSetup);
    ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CheckeredBiomeModConfig.CLIENT_SPEC);
    CHECKERED_WORLD_TYPE = new WorldTypeCheckered();
  }

  public void dedicatedServerSetup(FMLDedicatedServerSetupEvent event) {
    ServerProperties serverProperties = event.getServerSupplier().get().getServerProperties();
    serverProperties.serverProperties.setProperty("level-type", "checkered");
    serverProperties.worldType = CHECKERED_WORLD_TYPE;
  }
}
