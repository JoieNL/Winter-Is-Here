package joienl.winterishere.block;

import joienl.winterishere.WinterIsHere;
import joienl.winterishere.item.ModItems;
import joienl.winterishere.util.IHasModel;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

@SuppressWarnings("ConstantConditions")
class ModBlockStairs extends BlockStairs implements IHasModel {
    ModBlockStairs(IBlockState state) {
        super(state);
        String name = state.getBlock().getRegistryName().getResourcePath() + "_stairs";
        setRegistryName(name);
        setUnlocalizedName(name);
        this.useNeighborBrightness = true;

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        WinterIsHere.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}