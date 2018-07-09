package joienl.winterishere.world.biomes;

import joienl.winterishere.world.gen.feature.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

abstract class BiomeFrozen extends Biome {

    static final IBlockState WATER = Blocks.PACKED_ICE.getDefaultState();

    static final WorldGenDeadTrees TREE_FEATURE = new WorldGenDeadTrees(false);
    static final WorldGenDeadBigTree BIG_TREE_FEATURE = new WorldGenDeadBigTree(false);
    static final WorldGenDeadBirchTree SUPER_BIRCH_TREE = new WorldGenDeadBirchTree(false, true);
    static final WorldGenDeadBirchTree BIRCH_TREE = new WorldGenDeadBirchTree(false, false);
    static final WorldGenDeadCanopyTree ROOF_TREE = new WorldGenDeadCanopyTree(false);
    static final WorldGenDeadSwampTree SWAMP_FEATURE = new WorldGenDeadSwampTree();
    static final WorldGenDeadSavannaTree SAVANNA_TREE = new WorldGenDeadSavannaTree(false);

    BiomeFrozen(BiomeProperties properties) {
        super(properties);

        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPolarBear.class, 1, 1, 2));

        this.spawnableMonsterList.removeIf(biome$spawnlistentry -> biome$spawnlistentry.entityClass == EntitySkeleton.class);
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySkeleton.class, 20, 4, 4));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityStray.class, 80, 4, 4));

        this.decorator.waterlilyPerChunk = -999;
        this.decorator.flowersPerChunk = -999;
        this.decorator.grassPerChunk = -999;
        this.decorator.deadBushPerChunk = -999;
        this.decorator.mushroomsPerChunk = -999;
        this.decorator.reedsPerChunk = -999;
        this.decorator.cactiPerChunk = -999;
        this.decorator.bigMushroomsPerChunk = -999;
    }
}