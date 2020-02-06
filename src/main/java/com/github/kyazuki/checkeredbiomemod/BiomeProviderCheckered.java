package com.github.kyazuki.checkeredbiomemod;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.lang.Math.abs;

public class BiomeProviderCheckered extends BiomeProvider {
  private static long seed;
  private static final Set<Biome> overworldBiomesSet;
  private static final List<Biome> overworldBiomesList;
  private static final List<Biome> oceanBiomesList;
  private static final List<Biome> riverBiomesList;

  public BiomeProviderCheckered(OverworldBiomeProviderSettings settingsProvider) {
    super(overworldBiomesSet);
    seed = settingsProvider.func_226850_a_();
    if (CheckeredBiomeModConfig.enable_nether_biome)
      overworldBiomesList.add(Biomes.NETHER);
    if (CheckeredBiomeModConfig.enable_the_end_biome)
      overworldBiomesList.add(Biomes.THE_END);
  }

  @Override
  public Biome getNoiseBiome(int x, int y, int z) {
    x = x >> 2;
    z = z >> 2;
    String stringSeed = String.valueOf(seed);
    int a = stringSeed.charAt(abs(x) % stringSeed.length());
    int b = stringSeed.charAt(stringSeed.length() - (abs(z) % stringSeed.length()) - 1);
    int rand = abs(a * x + b * z);
    int index = rand % overworldBiomesList.size();
    if (overworldBiomesList.get(index) == Biomes.OCEAN)
      return oceanBiomesList.get(rand % oceanBiomesList.size());
    else if (overworldBiomesList.get(index) == Biomes.RIVER)
      return riverBiomesList.get(rand % riverBiomesList.size());
    return overworldBiomesList.get(index);
  }

  static {
    overworldBiomesSet = ImmutableSet.of(Biomes.OCEAN, Biomes.PLAINS, Biomes.DESERT, Biomes.MOUNTAINS, Biomes.FOREST, Biomes.TAIGA, new Biome[]{Biomes.SWAMP, Biomes.RIVER, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER, Biomes.SNOWY_TUNDRA, Biomes.SNOWY_MOUNTAINS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELD_SHORE, Biomes.BEACH, Biomes.DESERT_HILLS, Biomes.WOODED_HILLS, Biomes.TAIGA_HILLS, Biomes.MOUNTAIN_EDGE, Biomes.JUNGLE, Biomes.JUNGLE_HILLS, Biomes.JUNGLE_EDGE, Biomes.DEEP_OCEAN, Biomes.STONE_SHORE, Biomes.SNOWY_BEACH, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.DARK_FOREST, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA_HILLS, Biomes.GIANT_TREE_TAIGA, Biomes.GIANT_TREE_TAIGA_HILLS, Biomes.WOODED_MOUNTAINS, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.BADLANDS, Biomes.WOODED_BADLANDS_PLATEAU, Biomes.BADLANDS_PLATEAU, Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_WARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.SUNFLOWER_PLAINS, Biomes.DESERT_LAKES, Biomes.GRAVELLY_MOUNTAINS, Biomes.FLOWER_FOREST, Biomes.TAIGA_MOUNTAINS, Biomes.SWAMP_HILLS, Biomes.ICE_SPIKES, Biomes.MODIFIED_JUNGLE, Biomes.MODIFIED_JUNGLE_EDGE, Biomes.TALL_BIRCH_FOREST, Biomes.TALL_BIRCH_HILLS, Biomes.DARK_FOREST_HILLS, Biomes.SNOWY_TAIGA_MOUNTAINS, Biomes.GIANT_SPRUCE_TAIGA, Biomes.GIANT_SPRUCE_TAIGA_HILLS, Biomes.MODIFIED_GRAVELLY_MOUNTAINS, Biomes.SHATTERED_SAVANNA, Biomes.SHATTERED_SAVANNA_PLATEAU, Biomes.ERODED_BADLANDS, Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU, Biomes.MODIFIED_BADLANDS_PLATEAU});
    overworldBiomesList = new ArrayList<>(Arrays.asList(Biomes.OCEAN, Biomes.PLAINS, Biomes.DESERT, Biomes.MOUNTAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.SWAMP, Biomes.RIVER, Biomes.SNOWY_TUNDRA, Biomes.SNOWY_MOUNTAINS, Biomes.MUSHROOM_FIELDS, Biomes.BEACH, Biomes.DESERT_HILLS, Biomes.JUNGLE, Biomes.JUNGLE_HILLS, Biomes.SNOWY_BEACH, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST, Biomes.SNOWY_TAIGA, Biomes.GIANT_TREE_TAIGA, Biomes.WOODED_MOUNTAINS, Biomes.SAVANNA, Biomes.BADLANDS, Biomes.WOODED_BADLANDS_PLATEAU, Biomes.SUNFLOWER_PLAINS, Biomes.DESERT_LAKES, Biomes.GRAVELLY_MOUNTAINS, Biomes.FLOWER_FOREST, Biomes.TAIGA_MOUNTAINS, Biomes.SWAMP_HILLS, Biomes.ICE_SPIKES, Biomes.MODIFIED_JUNGLE, Biomes.TALL_BIRCH_FOREST, Biomes.DARK_FOREST_HILLS, Biomes.SNOWY_TAIGA_MOUNTAINS, Biomes.GIANT_SPRUCE_TAIGA, Biomes.MODIFIED_GRAVELLY_MOUNTAINS, Biomes.SHATTERED_SAVANNA, Biomes.ERODED_BADLANDS));
    oceanBiomesList = new ArrayList<Biome>(Arrays.asList(Biomes.OCEAN, Biomes.FROZEN_OCEAN, Biomes.DEEP_OCEAN, Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_WARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_FROZEN_OCEAN));
    riverBiomesList = new ArrayList<Biome>(Arrays.asList(Biomes.RIVER, Biomes.FROZEN_RIVER));
  }
}
