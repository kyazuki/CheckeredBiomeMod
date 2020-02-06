package com.github.kyazuki.checkeredbiomemod;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class WorldTypeCheckered extends WorldType {
  public WorldTypeCheckered() {
    super("checkered");
  }

  @Override
  public ChunkGenerator<?> createChunkGenerator(World world) {
    if (world.getDimension().getType() == DimensionType.OVERWORLD) {
      OverworldGenSettings overworldGenSettings = new OverworldGenSettings();
      OverworldBiomeProviderSettings biomeProviderSettings = new OverworldBiomeProviderSettings(world.getWorldInfo());
      return new ChunkGeneratorCheckered(world, new BiomeProviderCheckered(biomeProviderSettings), overworldGenSettings);
    } else if (world.getDimension().getType() == DimensionType.THE_NETHER) {
      if (CheckeredBiomeModConfig.activate_in_nether) {
        OverworldGenSettings overworldGenSettings = new OverworldGenSettings();
        OverworldBiomeProviderSettings biomeProviderSettings = new OverworldBiomeProviderSettings(world.getWorldInfo());
        return new ChunkGeneratorCheckered(world, new BiomeProviderCheckered(biomeProviderSettings), overworldGenSettings);
      } else
        return super.createChunkGenerator(world);
    } else {
      if (CheckeredBiomeModConfig.activate_in_the_end) {
        OverworldGenSettings overworldGenSettings = new OverworldGenSettings();
        OverworldBiomeProviderSettings biomeProviderSettings = new OverworldBiomeProviderSettings(world.getWorldInfo());
        return new ChunkGeneratorCheckered(world, new BiomeProviderCheckered(biomeProviderSettings), overworldGenSettings);
      } else
        return super.createChunkGenerator(world);
    }
  }
}
