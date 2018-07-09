package joienl.winterishere.world.gen.structure;

import com.google.common.collect.Lists;
import joienl.winterishere.entity.EntityBlizzard;
import joienl.winterishere.entity.EntityIceCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

import java.util.List;
import java.util.Random;

public class MapGenFrozenNetherBridge extends MapGenStructure {

    private final List<Biome.SpawnListEntry> spawnList = Lists.newArrayList();

    public MapGenFrozenNetherBridge() {
        this.spawnList.add(new Biome.SpawnListEntry(EntityBlizzard.class, 10, 2, 3));
        this.spawnList.add(new Biome.SpawnListEntry(EntityPigZombie.class, 5, 4, 4));
        this.spawnList.add(new Biome.SpawnListEntry(EntityWitherSkeleton.class, 8, 5, 5));
        this.spawnList.add(new Biome.SpawnListEntry(EntitySkeleton.class, 2, 5, 5));
        this.spawnList.add(new Biome.SpawnListEntry(EntityIceCube.class, 3, 4, 4));
    }

    @Override
    public String getStructureName() { return "Frozen Fortress"; }

    public List<Biome.SpawnListEntry> getSpawnList() { return this.spawnList; }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        int i = chunkX >> 4;
        int j = chunkZ >> 4;
        this.rand.setSeed((long)(i ^ j << 4) ^ this.world.getSeed());
        this.rand.nextInt();

        if (this.rand.nextInt(3) != 0) {
            return false;
        }
        else if (chunkX != (i << 4) + 4 + this.rand.nextInt(8)) {
            return false;
        }
        else {
            return chunkZ == (j << 4) + 4 + this.rand.nextInt(8);
        }
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        return new MapGenFrozenNetherBridge.Start(this.world, this.rand, chunkX, chunkZ);
    }

    @Override
    public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean findUnexplored) {
        int j = pos.getX() >> 4;
        int k = pos.getZ() >> 4;

        for (int l = 0; l <= 1000; ++l) {
            for (int i1 = -l; i1 <= l; ++i1) {
                boolean flag = i1 == -l || i1 == l;

                for (int j1 = -l; j1 <= l; ++j1) {
                    boolean flag1 = j1 == -l || j1 == l;

                    if (flag || flag1) {
                        int k1 = j + i1;
                        int l1 = k + j1;

                        if (this.canSpawnStructureAtCoords(k1, l1) && (!findUnexplored || !worldIn.isChunkGeneratedAt(k1, l1))) {
                            return new BlockPos((k1 << 4) + 8, 64, (l1 << 4) + 8);
                        }
                    }
                }
            }
        }

        return null;
    }

    public static class Start extends StructureStart {
        public Start() { }

        public Start(World worldIn, Random random, int chunkX, int chunkZ) {
            super(chunkX, chunkZ);
            StructureFrozenNetherBridgePieces.Start structurefrozennetherbridgepieces$start = new StructureFrozenNetherBridgePieces.Start(random, (chunkX << 4) + 2, (chunkZ << 4) + 2);
            this.components.add(structurefrozennetherbridgepieces$start);
            structurefrozennetherbridgepieces$start.buildComponent(structurefrozennetherbridgepieces$start, this.components, random);
            List<StructureComponent> list = structurefrozennetherbridgepieces$start.pendingChildren;

            while (!list.isEmpty()) {
                int i = random.nextInt(list.size());
                StructureComponent structurecomponent = list.remove(i);
                structurecomponent.buildComponent(structurefrozennetherbridgepieces$start, this.components, random);
            }

            this.updateBoundingBox();
            this.setRandomHeight(worldIn, random, 48, 70);
        }
    }
}