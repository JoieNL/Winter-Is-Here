package joienl.winterishere.world.biomes;

import joienl.winterishere.block.ModBlocks;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.feature.WorldGenFossils;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

class BiomeFrozenDesert extends BiomeFrozen {
    BiomeFrozenDesert(Biome.BiomeProperties properties) {
        super(properties);

        this.topBlock = ModBlocks.BLUE_SAND.getDefaultState();
        this.fillerBlock = ModBlocks.BLUE_SAND.getDefaultState();
        this.spawnableCreatureList.clear();

        this.spawnableMonsterList.removeIf(biome$spawnlistentry -> biome$spawnlistentry.entityClass == EntityZombie.class || biome$spawnlistentry.entityClass == EntityZombieVillager.class);

        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombie.class, 19, 4, 4));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombieVillager.class, 1, 1, 1));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityHusk.class, 80, 4, 4));
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        super.decorate(worldIn, rand, pos);

        if (TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.DESERT_WELL)) {
            if (rand.nextInt(1000) == 0) {
                int i = rand.nextInt(16) + 8;
                int j = rand.nextInt(16) + 8;
                BlockPos blockpos = worldIn.getHeight(pos.add(i, 0, j)).up();
                new WorldGenDesertWells().generate(worldIn, rand, blockpos);
            }
        }

        if (TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.FOSSIL)) {
            if (rand.nextInt(64) == 0) {
                new WorldGenFossils().generate(worldIn, rand, pos);
            }
        }
    }
}