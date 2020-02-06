package com.github.kyazuki.checkeredbiomemod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = CheckeredBiomeMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CheckeredBiomeModConfig {
  public static final ClientConfig CLIENT;
  public static final ForgeConfigSpec CLIENT_SPEC;

  static {
    final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
    CLIENT_SPEC = specPair.getRight();
    CLIENT = specPair.getLeft();
  }

  public static boolean enable_nether_biome;
  public static boolean enable_the_end_biome;
  public static boolean activate_in_nether;
  public static boolean activate_in_the_end;

  @SubscribeEvent
  public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
    if (configEvent.getConfig().getSpec() == CheckeredBiomeModConfig.CLIENT_SPEC) {
      bakeConfig();
    }
  }

  public static void bakeConfig() {
    enable_nether_biome = CLIENT.enable_nether_biome.get();
    enable_the_end_biome = CLIENT.enable_the_end_biome.get();
    activate_in_nether = CLIENT.activate_in_nether.get();
    activate_in_the_end = CLIENT.activate_in_the_end.get();
  }

  public static class ClientConfig {

    public final ForgeConfigSpec.BooleanValue enable_nether_biome;
    public final ForgeConfigSpec.BooleanValue enable_the_end_biome;
    public final ForgeConfigSpec.BooleanValue activate_in_nether;
    public final ForgeConfigSpec.BooleanValue activate_in_the_end;

    public ClientConfig(ForgeConfigSpec.Builder builder) {
      builder.push("CheckeredBiomeMod Config");
      enable_nether_biome = builder
              .comment("Enable Nether biome in Overworld.")
              .translation(CheckeredBiomeMod.MODID + ".config" + "enable_nether_biome")
              .define("enable_nether_biome", false);
      enable_the_end_biome = builder
              .comment("Enable The End biome in Overworld.")
              .translation(CheckeredBiomeMod.MODID + ".config" + "enable_the_end_biome")
              .define("enable_the_end_biome", false);
      activate_in_nether = builder
              .comment("Enable in Nether.")
              .translation(CheckeredBiomeMod.MODID + ".config" + "activate_in_nether")
              .define("activate_in_nether", false);
      activate_in_the_end = builder
              .comment("Enable in The End.")
              .translation(CheckeredBiomeMod.MODID + ".config" + "activate_in_the_end")
              .define("activate_in_the_end", false);
      builder.pop();
    }

  }
}