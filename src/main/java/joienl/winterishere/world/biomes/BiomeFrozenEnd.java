package joienl.winterishere.world.biomes;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEndDecorator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

class BiomeFrozenEnd extends BiomeFrozen {
    BiomeFrozenEnd(Biome.BiomeProperties properties) {
        super(properties);

        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityEnderman.class, 10, 4, 4));
        this.topBlock = Blocks.DIRT.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
        this.decorator = new BiomeEndDecorator();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float currentTemperature) { return 0; }
}