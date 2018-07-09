package joienl.winterishere.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

class ModBlockOre extends ModBlockBase {

    private final ItemStack drop;

    ModBlockOre(String name, ItemStack drop, float hardness, float resistance, int harvestLevel) {
        super(name, Material.ROCK, hardness, resistance, harvestLevel);
        this.drop = drop;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) { return drop.getItem(); }

    @Override
    public int quantityDropped(Random random) { return drop.getCount(); }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int i = 0;

            if (this == ModBlocks.FROSTED_QUARTZ_ORE) {
                i = MathHelper.getInt(rand, 2, 5);
            }

            return i;
        }
        return 0;
    }
}