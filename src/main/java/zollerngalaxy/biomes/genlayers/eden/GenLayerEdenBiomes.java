package zollerngalaxy.biomes.genlayers.eden;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import zollerngalaxy.biomes.ZGBiomes;
import zollerngalaxy.util.CachedEnum;
import com.google.common.collect.ImmutableList;

public class GenLayerEdenBiomes extends GenLayerEden {
	
	@SuppressWarnings("unchecked")
	private List<BiomeEntry>[] biomes = new ArrayList[CachedEnum.valuesBiomeCached().length];
	private ArrayList<BiomeEntry>[] biomesList = this.setupBiomes();
	
	public GenLayerEdenBiomes(long seed) {
		super(seed);
		
		for (BiomeType type : CachedEnum.valuesBiomeCached()) {
			ImmutableList<BiomeEntry> biomesToAdd = this.getBiomes(type);
			int idx = type.ordinal();
			
			if (this.biomes[idx] == null) {
				this.biomes[idx] = new ArrayList<>();
			}
			if (biomesToAdd != null) {
				this.biomes[idx].addAll(biomesToAdd);
			}
		}
	}
	
	private ArrayList<BiomeEntry>[] setupBiomes() {
		@SuppressWarnings("unchecked")
		ArrayList<BiomeEntry>[] currentBiomes = new ArrayList[CachedEnum.valuesBiomeCached().length];
		List<BiomeEntry> list = new ArrayList<>();
		list.add(new BiomeEntry(ZGBiomes.EDEN_TERRAN_VALLEY, 75));
		list.add(new BiomeEntry(ZGBiomes.EDEN_OCEAN, 70));
		list.add(new BiomeEntry(ZGBiomes.EDENWOOD_FOREST, 65));
		list.add(new BiomeEntry(ZGBiomes.EDEN_FLOWER_GARDEN, 55));
		list.add(new BiomeEntry(ZGBiomes.EDEN_CRATERS, 50));
		list.add(new BiomeEntry(ZGBiomes.EDEN_ROCK_MOUNTAINS, 45));
		list.add(new BiomeEntry(ZGBiomes.EDEN_GREEN_LANDS, 35));
		list.add(new BiomeEntry(ZGBiomes.EDEN_SWAMPLANDS, 30));
		list.add(new BiomeEntry(ZGBiomes.EDEN_BLOOD_DESERT, 25));
		list.add(new BiomeEntry(ZGBiomes.EDEN_GOLDEN_MEADOW, 20));
		list.add(new BiomeEntry(ZGBiomes.EDEN_SNOWY_PLAINS, 15));
		
		currentBiomes[BiomeType.WARM.ordinal()] = new ArrayList<>(list);
		return currentBiomes;
	}
	
	private ImmutableList<BiomeEntry> getBiomes(BiomeType type) {
		int idx = type.ordinal();
		List<BiomeEntry> list = idx >= this.biomesList.length ? null : this.biomesList[idx];
		return list != null ? ImmutableList.copyOf(list) : null;
	}
	
	@Override
	public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
		int[] dest = IntCache.getIntCache(areaWidth * areaHeight);
		
		for (int dz = 0; dz < areaHeight; dz++) {
			for (int dx = 0; dx < areaWidth; dx++) {
				this.initChunkSeed(dx + areaX, dz + areaY);
				dest[dx + dz * areaWidth] = Biome.getIdForBiome(this.getWeightedBiomeEntry(BiomeType.WARM).biome);
			}
		}
		return dest;
	}
	
	protected BiomeEntry getWeightedBiomeEntry(BiomeType type) {
		List<BiomeEntry> biomeList = this.biomes[type.ordinal()];
		int totalWeight = WeightedRandom.getTotalWeight(biomeList);
		int weight = BiomeManager.isTypeListModded(type) ? this.nextInt(totalWeight) : this.nextInt(totalWeight / 10) * 10;
		return WeightedRandom.getRandomItem(biomeList, weight);
	}
}