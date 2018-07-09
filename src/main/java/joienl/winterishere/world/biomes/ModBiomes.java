package joienl.winterishere.world.biomes;

import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomes {
    public static final Biome FROZEN_OCEAN = new BiomeFrozenOcean(new Biome.BiomeProperties("Frozen Ocean").setBaseHeight(-1.0F).setHeightVariation(0.1F).setTemperature(-1.5F));
    public static final Biome FROZEN_PLAINS = new BiomeFrozenPlains(false, new Biome.BiomeProperties("Frozen Plains").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(-1.8F).setRainfall(0.4F));
    public static final Biome FROZEN_DESERT = new BiomeFrozenDesert(new Biome.BiomeProperties("Frozen Desert").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.0F).setRainfall(0.1F));
    public static final Biome FROZEN_EXTREME_HILLS = new BiomeFrozenHills(BiomeFrozenHills.Type.NORMAL, new Biome.BiomeProperties("Frozen Extreme Hills").setBaseHeight(1.0F).setHeightVariation(0.5F).setTemperature(-1.8F).setRainfall(0.3F));
    public static final Biome FROZEN_FOREST = new BiomeFrozenForest(BiomeFrozenForest.Type.NORMAL, new Biome.BiomeProperties("Frozen Forest").setTemperature(-1.3F).setRainfall(0.8F));
    public static final Biome FROZEN_TAIGA = new BiomeFrozenTaiga(BiomeFrozenTaiga.Type.NORMAL, new Biome.BiomeProperties("Frozen Taiga").setBaseHeight(0.2F).setHeightVariation(0.2F).setTemperature(-1.75F).setRainfall(0.8F));
    public static final Biome FROZEN_SWAMPLAND = new BiomeFrozenSwamp(new Biome.BiomeProperties("Frozen Swampland").setBaseHeight(-0.2F).setHeightVariation(0.1F).setTemperature(-1.2F).setRainfall(0.9F).setWaterColor(14745518));
    public static final Biome FROZEN_RIVER = new BiomeFrozenRiver(new Biome.BiomeProperties("Frozen River").setBaseHeight(-0.5F).setHeightVariation(0.0F).setTemperature(-1.5F));
    public static final Biome FROZEN_HELL = new BiomeFrozenHell(new Biome.BiomeProperties("Frozen Hell").setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());
    public static final Biome FROZEN_SKY = new BiomeFrozenEnd(new Biome.BiomeProperties("The Frozen End").setTemperature(-1.5F));
    //Ice Plains are definitely frozen.
    //Ice Mountains are definitely frozen.
    private static final Biome FROZEN_MUSHROOM_ISLAND = new BiomeFrozenMushroomIsland(new Biome.BiomeProperties("Frozen Mushroom Island").setBaseHeight(0.2F).setHeightVariation(0.3F).setTemperature(-1.1F).setRainfall(1.0F));
    private static final Biome FROZEN_MUSHROOM_ISLAND_SHORE = new BiomeFrozenMushroomIsland(new Biome.BiomeProperties("Frozen Mushroom Island Shore").setBaseHeight(0.0F).setHeightVariation(0.025F).setTemperature(-1.1F).setRainfall(1.0F));
    public static final Biome FROZEN_BEACH = new BiomeFrozenBeach(new Biome.BiomeProperties("Frozen Beach").setBaseHeight(0.0F).setHeightVariation(0.025F).setTemperature(-1.2F).setRainfall(0.4F));
    public static final Biome FROZEN_DESERT_HILLS = new BiomeFrozenDesert(new Biome.BiomeProperties("Frozen Desert Hills").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.0F).setRainfall(0.1F));
    private static final Biome FROZEN_FOREST_HILLS = new BiomeFrozenForest(BiomeFrozenForest.Type.NORMAL, new Biome.BiomeProperties("Frozen Forest Hills").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(-1.3F).setRainfall(0.8F));
    private static final Biome FROZEN_TAIGA_HILLS = new BiomeFrozenTaiga(BiomeFrozenTaiga.Type.NORMAL, new Biome.BiomeProperties("Frozen Taiga Hills").setTemperature(-1.75F).setRainfall(0.8F).setBaseHeight(0.45F).setHeightVariation(0.3F));
    private static final Biome FROZEN_EXTREME_HILLS_EDGE = new BiomeFrozenHills(BiomeFrozenHills.Type.EXTRA_TREES, new Biome.BiomeProperties("Frozen Extreme Hills Edge").setBaseHeight(0.8F).setHeightVariation(0.3F).setTemperature(-1.8F).setRainfall(0.3F));
    private static final Biome FROZEN_JUNGLE = new BiomeFrozenJungle(false, new Biome.BiomeProperties("Frozen Jungle").setTemperature(-0.05F).setRainfall(0.9F));
    private static final Biome FROZEN_JUNGLE_HILLS = new BiomeFrozenJungle(false, new Biome.BiomeProperties("Frozen Jungle Hills").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(-0.05F).setRainfall(0.9F));
    private static final Biome FROZEN_JUNGLE_EDGE = new BiomeFrozenJungle(true, new Biome.BiomeProperties("Frozen Jungle Edge").setTemperature(-0.05F).setRainfall(0.8F));
    public static final Biome FROZEN_DEEP_OCEAN = new BiomeFrozenOcean(new Biome.BiomeProperties("Frozen Deep Ocean").setBaseHeight(-1.8F).setHeightVariation(0.1F).setTemperature(-1.5F));
    public static final Biome FROZEN_STONE_BEACH = new BiomeFrozenStoneBeach(new Biome.BiomeProperties("Frozen Stone Beach").setBaseHeight(0.1F).setHeightVariation(0.8F).setTemperature(-1.8F).setRainfall(0.3F));
    //Cold Beach is definitely frozen.
    public static final Biome FROZEN_BIRCH_FOREST = new BiomeFrozenForest(BiomeFrozenForest.Type.BIRCH, new Biome.BiomeProperties("Frozen Birch Forest").setTemperature(-1.4F).setRainfall(0.6F));
    private static final Biome FROZEN_BIRCH_FOREST_HILLS = new BiomeFrozenForest(BiomeFrozenForest.Type.BIRCH, new Biome.BiomeProperties("Frozen Birch Forest Hills").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(-1.4F).setRainfall(0.6F));
    public static final Biome FROZEN_ROOFED_FOREST = new BiomeFrozenForest(BiomeFrozenForest.Type.ROOFED, new Biome.BiomeProperties("Frozen Roofed Forest").setTemperature(-1.3F).setRainfall(0.8F));
    //Cold Taiga is definitely frozen.
    //Cold Taiga Hills are definitely frozen.
    private static final Biome FROZEN_REDWOOD_TAIGA = new BiomeFrozenTaiga(BiomeFrozenTaiga.Type.MEGA, new Biome.BiomeProperties("Frozen Mega Taiga").setTemperature(-1.7F).setRainfall(0.8F).setBaseHeight(0.2F).setHeightVariation(0.2F));
    private static final Biome FROZEN_REDWOOD_TAIGA_HILLS = new BiomeFrozenTaiga(BiomeFrozenTaiga.Type.MEGA, new Biome.BiomeProperties("Frozen Mega Taiga Hills").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(-1.7F).setRainfall(0.8F));
    private static final Biome FROZEN_EXTREME_HILLS_WITH_TREES = new BiomeFrozenHills(BiomeFrozenHills.Type.EXTRA_TREES, new Biome.BiomeProperties("Frozen Extreme Hills+").setBaseHeight(1.0F).setHeightVariation(0.5F).setTemperature(-1.8F).setRainfall(0.3F));
    public static final Biome FROZEN_SAVANNA = new BiomeFrozenSavanna(new Biome.BiomeProperties("Frozen Savanna").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(-0.8F).setRainfall(0.1F));
    private static final Biome FROZEN_SAVANNA_PLATEAU = new BiomeFrozenSavanna(new Biome.BiomeProperties("Frozen Savanna Plateau").setBaseHeight(1.5F).setHeightVariation(0.025F).setTemperature(-1.0F).setRainfall(0.1F));
    private static final Biome FROZEN_MESA = new BiomeFrozenMesa(false, false, new Biome.BiomeProperties("Frozen Mesa").setTemperature(0.0F).setRainfall(0.1F));
    private static final Biome FROZEN_MESA_ROCK = new BiomeFrozenMesa(false, true, new Biome.BiomeProperties("Frozen Mesa Plateau F").setBaseHeight(1.5F).setHeightVariation(0.025F).setTemperature(0.0F).setRainfall(0.1F));
    private static final Biome FROZEN_MESA_CLEAR_ROCK = new BiomeFrozenMesa(false, false, new Biome.BiomeProperties("Frozen Mesa Plateau").setBaseHeight(1.5F).setHeightVariation(0.025F).setTemperature(0.0F).setRainfall(0.1F));

    //Frozen Void is unnecessary.
    private static final Biome FROZEN_MUTATED_PLAINS = new BiomeFrozenPlains(true, new Biome.BiomeProperties("Frozen Sunflower Plains").setBaseBiome("plains").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(-1.2F).setRainfall(0.4F));
    private static final Biome FROZEN_MUTATED_DESERT = new BiomeFrozenDesert(new Biome.BiomeProperties("Frozen Desert M").setBaseBiome("desert").setBaseHeight(0.225F).setHeightVariation(0.25F).setTemperature(0.0F).setRainfall(0.1F));
    private static final Biome FROZEN_MUTATED_EXTREME_HILLS = new BiomeFrozenHills(BiomeFrozenHills.Type.MUTATED, new Biome.BiomeProperties("Frozen Extreme Hills M").setBaseBiome("extreme_hills").setBaseHeight(1.0F).setHeightVariation(0.5F).setTemperature(-1.8F).setRainfall(0.3F));
    private static final Biome FROZEN_MUTATED_FOREST = new BiomeFrozenForest(BiomeFrozenForest.Type.FLOWER, new Biome.BiomeProperties("Frozen Flower Forest").setBaseBiome("forest").setHeightVariation(0.4F).setTemperature(-1.3F).setRainfall(0.8F));
    private static final Biome FROZEN_MUTATED_TAIGA = new BiomeFrozenTaiga(BiomeFrozenTaiga.Type.NORMAL, new Biome.BiomeProperties("Frozen Taiga M").setBaseBiome("taiga").setBaseHeight(0.3F).setHeightVariation(0.4F).setTemperature(-1.75F).setRainfall(0.8F));
    private static final Biome FROZEN_MUTATED_SWAMPLAND = new BiomeFrozenSwamp(new Biome.BiomeProperties("Frozen Swampland M").setBaseBiome("swampland").setBaseHeight(-0.1F).setHeightVariation(0.3F).setTemperature(-1.2F).setRainfall(0.9F).setWaterColor(14745518));
    //Ice Plains Spikes are definitely frozen.
    private static final Biome FROZEN_MUTATED_JUNGLE = new BiomeFrozenJungle(false, new Biome.BiomeProperties("Frozen Jungle M").setBaseBiome("jungle").setBaseHeight(0.2F).setHeightVariation(0.4F).setTemperature(-0.05F).setRainfall(0.9F));
    private static final Biome FROZEN_MUTATED_JUNGLE_EDGE = new BiomeFrozenJungle(true, new Biome.BiomeProperties("Frozen Jungle Edge M").setBaseBiome("jungle_edge").setBaseHeight(0.2F).setHeightVariation(0.4F).setTemperature(-0.05F).setRainfall(0.8F));
    private static final Biome FROZEN_MUTATED_BIRCH_FOREST = new BiomeFrozenForestMutated(new Biome.BiomeProperties("Frozen Birch Forest M").setBaseBiome("birch_forest").setBaseHeight(0.2F).setHeightVariation(0.4F).setTemperature(-1.4F).setRainfall(0.6F));
    private static final Biome FROZEN_MUTATED_BIRCH_FOREST_HILLS = new BiomeFrozenForestMutated(new Biome.BiomeProperties("Frozen Birch Forest Hills M").setBaseBiome("birch_forest_hills").setBaseHeight(0.55F).setHeightVariation(0.5F).setTemperature(-1.4F).setRainfall(0.6F));
    private static final Biome FROZEN_MUTATED_ROOFED_FOREST = new BiomeFrozenForest(BiomeFrozenForest.Type.ROOFED, new Biome.BiomeProperties("Frozen Roofed Forest M").setBaseBiome("roofed_forest").setBaseHeight(0.2F).setHeightVariation(0.4F).setTemperature(-1.3F).setRainfall(0.8F));
    //Cold Taiga M is definitely frozen.
    private static final Biome FROZEN_MUTATED_REDWOOD_TAIGA = new BiomeFrozenTaiga(BiomeFrozenTaiga.Type.MEGA_SPRUCE, new Biome.BiomeProperties("Frozen Mega Spruce Taiga").setBaseBiome("redwood_taiga").setBaseHeight(0.2F).setHeightVariation(0.2F).setTemperature(-1.75F).setRainfall(0.8F));
    private static final Biome FROZEN_MUTATED_REDWOOD_TAIGA_HILLS = new BiomeFrozenTaiga(BiomeFrozenTaiga.Type.MEGA_SPRUCE, new Biome.BiomeProperties("Frozen Redwood Taiga Hills M").setBaseBiome("redwood_taiga_hills").setBaseHeight(0.2F).setHeightVariation(0.2F).setTemperature(-1.75F).setRainfall(0.8F));
    private static final Biome FROZEN_MUTATED_EXTREME_HILLS_WITH_TREES = new BiomeFrozenHills(BiomeFrozenHills.Type.MUTATED, new Biome.BiomeProperties("Frozen Extreme Hills+ M").setBaseBiome("extreme_hills_with_trees").setBaseHeight(1.0F).setHeightVariation(0.5F).setTemperature(-1.8F).setRainfall(0.3F));
    private static final Biome FROZEN_MUTATED_SAVANNA = new BiomeFrozenSavannaMutated(new Biome.BiomeProperties("Frozen Savanna M").setBaseBiome("savanna").setBaseHeight(0.3625F).setHeightVariation(1.225F).setTemperature(-0.9F).setRainfall(0.1F));
    private static final Biome FROZEN_MUTATED_SAVANNA_ROCK = new BiomeFrozenSavannaMutated(new Biome.BiomeProperties("Frozen Savanna Plateau M").setBaseBiome("savanna_rock").setBaseHeight(1.05F).setHeightVariation(1.2125001F).setTemperature(-1.0F).setRainfall(0.1F));
    private static final Biome FROZEN_MUTATED_MESA = new BiomeFrozenMesa(true, false, new Biome.BiomeProperties("Frozen Mesa (Bryce)").setBaseBiome("mesa").setTemperature(0.0F).setRainfall(0.1F));
    private static final Biome FROZEN_MUTATED_MESA_ROCK = new BiomeFrozenMesa(false, true, new Biome.BiomeProperties("Frozen Mesa Plateau F M").setBaseBiome("mesa_rock").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.0F).setRainfall(0.1F));
    private static final Biome FROZEN_MUTATED_MESA_CLEAR_ROCK = new BiomeFrozenMesa(false, false, new Biome.BiomeProperties("Frozen Mesa Plateau M").setBaseBiome("mesa_clear_rock").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.0F).setRainfall(0.1F));

    public static void registerBiomes() {
        initBiome(FROZEN_OCEAN, "frozen_ocean");
        initBiome(FROZEN_PLAINS, "frozen_plains");
        initBiome(FROZEN_DESERT, "frozen_desert");
        initBiome(FROZEN_EXTREME_HILLS, "frozen_extreme_hills");
        initBiome(FROZEN_FOREST, "frozen_forest");
        initBiome(FROZEN_TAIGA, "frozen_taiga");
        initBiome(FROZEN_SWAMPLAND, "frozen_swampland");
        initBiome(FROZEN_RIVER, "frozen_river");
        initBiome(FROZEN_HELL, "frozen_hell");
        initBiome(FROZEN_SKY, "frozen_sky");
        initBiome(FROZEN_MUSHROOM_ISLAND, "frozen_mushroom_island");
        initBiome(FROZEN_MUSHROOM_ISLAND_SHORE, "frozen_mushroom_island_shore");
        initBiome(FROZEN_BEACH, "frozen_beaches");
        initBiome(FROZEN_DESERT_HILLS, "frozen_desert_hills");
        initBiome(FROZEN_FOREST_HILLS, "frozen_forest_hills");
        initBiome(FROZEN_TAIGA_HILLS, "frozen_taiga_hills");
        initBiome(FROZEN_EXTREME_HILLS_EDGE, "frozen_smaller_extreme_hills");
        initBiome(FROZEN_JUNGLE, "frozen_jungle");
        initBiome(FROZEN_JUNGLE_HILLS, "frozen_jungle_hills");
        initBiome(FROZEN_JUNGLE_EDGE, "frozen_jungle_edge");
        initBiome(FROZEN_DEEP_OCEAN, "frozen_deep_ocean");
        initBiome(FROZEN_STONE_BEACH, "frozen_stone_beach");
        initBiome(FROZEN_BIRCH_FOREST, "frozen_birch_forest");
        initBiome(FROZEN_BIRCH_FOREST_HILLS, "frozen_birch_forest_hills");
        initBiome(FROZEN_ROOFED_FOREST, "frozen_roofed_forest");
        initBiome(FROZEN_REDWOOD_TAIGA, "frozen_redwood_taiga");
        initBiome(FROZEN_REDWOOD_TAIGA_HILLS, "frozen_redwood_taiga_hills");
        initBiome(FROZEN_EXTREME_HILLS_WITH_TREES, "frozen_extreme_hills_with_trees");
        initBiome(FROZEN_SAVANNA, "frozen_savanna");
        initBiome(FROZEN_SAVANNA_PLATEAU, "frozen_savanna_rock");
        initBiome(FROZEN_MESA, "frozen_mesa");
        initBiome(FROZEN_MESA_ROCK, "frozen_mesa_rock");
        initBiome(FROZEN_MESA_CLEAR_ROCK, "frozen_mesa_clear_rock");

        initBiome(FROZEN_MUTATED_PLAINS, "frozen_mutated_plains");
        initBiome(FROZEN_MUTATED_DESERT, "frozen_mutated_desert");
        initBiome(FROZEN_MUTATED_EXTREME_HILLS, "frozen_mutated_extreme_hills");
        initBiome(FROZEN_MUTATED_FOREST, "frozen_mutated_forest");
        initBiome(FROZEN_MUTATED_TAIGA, "frozen_mutated_taiga");
        initBiome(FROZEN_MUTATED_SWAMPLAND, "frozen_mutated_swampland");
        initBiome(FROZEN_MUTATED_JUNGLE, "frozen_mutated_jungle");
        initBiome(FROZEN_MUTATED_JUNGLE_EDGE, "frozen_mutated_jungle_edge");
        initBiome(FROZEN_MUTATED_BIRCH_FOREST, "frozen_mutated_birch_forest");
        initBiome(FROZEN_MUTATED_BIRCH_FOREST_HILLS, "frozen_mutated_birch_forest_hills");
        initBiome(FROZEN_MUTATED_ROOFED_FOREST, "frozen_mutated_roofed_forest");
        initBiome(FROZEN_MUTATED_REDWOOD_TAIGA, "frozen_mutated_redwood_taiga");
        initBiome(FROZEN_MUTATED_REDWOOD_TAIGA_HILLS, "frozen_mutated_redwood_taiga_hills");
        initBiome(FROZEN_MUTATED_EXTREME_HILLS_WITH_TREES, "frozen_mutated_extreme_hills_with_trees");
        initBiome(FROZEN_MUTATED_SAVANNA, "frozen_mutated_savanna");
        initBiome(FROZEN_MUTATED_SAVANNA_ROCK, "frozen_mutated_savanna_rock");
        initBiome(FROZEN_MUTATED_MESA, "frozen_mutated_mesa");
        initBiome(FROZEN_MUTATED_MESA_ROCK, "frozen_mutated_mesa_rock");
        initBiome(FROZEN_MUTATED_MESA_CLEAR_ROCK, "frozen_mutated_mesa_clear_rock");
    }

    private static void initBiome(Biome biome, String name) {
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, 10));
        BiomeManager.addSpawnBiome(biome);
    }

    public static Biome freezeBiome(Biome biome) {
        if (!(biome instanceof BiomeFrozen)) {
            if (biome == Biomes.FROZEN_RIVER) {
                return ModBiomes.FROZEN_RIVER;
            }
            else if (biome == Biomes.FROZEN_OCEAN) {
                return ModBiomes.FROZEN_OCEAN;
            }
            else if (biome == Biomes.ICE_PLAINS || biome == Biomes.ICE_MOUNTAINS || biome == Biomes.COLD_BEACH
                    || biome == Biomes.COLD_TAIGA || biome == Biomes.COLD_TAIGA_HILLS
                    || biome == Biomes.MUTATED_ICE_FLATS || biome == Biomes.MUTATED_TAIGA_COLD) {
                return biome;
            }

            ResourceLocation resourceLocation = ForgeRegistries.BIOMES.getKey(biome);
            assert resourceLocation != null;
            String s = resourceLocation.toString().substring(10);
            return ForgeRegistries.BIOMES.getValue(new ResourceLocation("wih", "frozen_" + s));
        }
        return biome;
    }

    public static Biome thawBiome(Biome biome) {
        if (biome instanceof BiomeFrozen) {
            ResourceLocation resourceLocation = ForgeRegistries.BIOMES.getKey(biome);
            assert resourceLocation != null;
            String s = resourceLocation.toString().substring(11);
            return ForgeRegistries.BIOMES.getValue(new ResourceLocation("minecraft", s));
        }
        return biome;
    }
}