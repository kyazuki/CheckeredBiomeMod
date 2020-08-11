package com.github.kyazuki.checkeredbiomemod;

import net.minecraft.client.gui.screen.BiomeGeneratorTypeScreens;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.ServerProperties;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import net.minecraft.world.storage.ServerWorldInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CheckeredBiomeMod.MODID)
public class CheckeredBiomeMod {
  public static final String MODID = "checkeredbiomemod";
  public static final Logger LOGGER = LogManager.getLogger(MODID);

  public CheckeredBiomeMod() {
    LOGGER.debug("CheckeredBiomeMod Loaded!");
    MinecraftForge.EVENT_BUS.addListener(this::serverStarting);
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CheckeredBiomeModConfig.COMMON_SPEC);

    if (FMLEnvironment.dist == Dist.CLIENT)
      BiomeGeneratorTypeScreens.field_239068_c_.add(new CheckeredBiomeGeneratorTypeScreen());
  }

  public static DimensionGeneratorSettings createDimensionGeneratorSettings(long seed, boolean generateFeatures, boolean generateBonusChest) {
    return new DimensionGeneratorSettings(seed, generateFeatures, generateBonusChest, DimensionGeneratorSettings.func_236216_a_(DimensionType.func_236022_a_(seed), new NoiseChunkGenerator(new BiomeProviderCheckered(seed), seed, DimensionSettings.Preset.OVERWORLD.getSettings())));
  }

  private void serverStarting(final FMLServerAboutToStartEvent event) {
    if (!(event.getServer() instanceof DedicatedServer)) return;

    DedicatedServer server = (DedicatedServer) event.getServer();
    ServerProperties properties = server.getServerProperties();

    if (server.func_240793_aU_().func_230407_G_() instanceof ServerWorldInfo) {
      ServerWorldInfo worldInfo = (ServerWorldInfo) server.func_240793_aU_().func_230407_G_();
      long seed = worldInfo.getDimensionGeneratorSettings().getSeed();
      worldInfo.generatorSettings = createDimensionGeneratorSettings(seed, worldInfo.getDimensionGeneratorSettings().doesGenerateFeatures(), worldInfo.getDimensionGeneratorSettings().hasBonusChest());
    }

    long seed = properties.field_241082_U_.getSeed();
    properties.field_241082_U_ = createDimensionGeneratorSettings(seed, properties.field_241082_U_.doesGenerateFeatures(), properties.field_241082_U_.hasBonusChest());
  }
}
