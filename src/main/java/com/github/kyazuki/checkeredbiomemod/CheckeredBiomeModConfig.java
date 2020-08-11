package com.github.kyazuki.checkeredbiomemod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = CheckeredBiomeMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CheckeredBiomeModConfig {
  public static final CommonConfig COMMON;
  public static final ForgeConfigSpec COMMON_SPEC;

  static {
    final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
    COMMON_SPEC = specPair.getRight();
    COMMON = specPair.getLeft();
  }

  public static boolean enable_nether_biome;
  public static boolean enable_the_end_biome;

  @SubscribeEvent
  public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
    if (configEvent.getConfig().getSpec() == CheckeredBiomeModConfig.COMMON_SPEC) {
      bakeConfig();
    }
  }

  public static void bakeConfig() {
    enable_nether_biome = COMMON.enable_nether_biome.get();
    enable_the_end_biome = COMMON.enable_the_end_biome.get();
  }

  public static class CommonConfig {

    public final ForgeConfigSpec.BooleanValue enable_nether_biome;
    public final ForgeConfigSpec.BooleanValue enable_the_end_biome;

    public CommonConfig(ForgeConfigSpec.Builder builder) {
      builder.push("CheckeredBiomeMod Config");
      enable_nether_biome = builder
              .comment("Enable Nether biome in Overworld.")
              .translation(CheckeredBiomeMod.MODID + ".config" + "enable_nether_biome")
              .define("enable_nether_biome", false);
      enable_the_end_biome = builder
              .comment("Enable The End biome in Overworld.")
              .translation(CheckeredBiomeMod.MODID + ".config" + "enable_the_end_biome")
              .define("enable_the_end_biome", false);
      builder.pop();
    }

  }
}