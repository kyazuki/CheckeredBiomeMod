package com.github.kyazuki.checkeredbiomemod;

import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class ChunkGeneratorCheckered extends OverworldChunkGenerator {
  public ChunkGeneratorCheckered(IWorld worldIn, BiomeProvider provider, OverworldGenSettings settingsIn) {
    super(worldIn, provider, settingsIn);
  }
}
