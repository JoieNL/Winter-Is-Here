package joienl.winterishere.block;

import joienl.winterishere.WinterIsHere;
import joienl.winterishere.item.ModItems;
import joienl.winterishere.util.IHasModel;
import net.minecraft.block.BlockFence;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

@SuppressWarnings("ConstantConditions")
public class ModBlockFence extends BlockFence implements IHasModel {
    ModBlockFence(IBlockState state) {
        super(state.getMaterial(), state.getMapColor(null, null));
        ModBlockBase block = (ModBlockBase) state.getBlock();
        String name = state.getBlock().getRegistryName().getResourcePath() + "_fence";
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(block.getHardness());
        setResistance(block.getResistance() / 3F);
        if (block.getHarvestLevel(state) >= 0) {
            setHarvestLevel(block.getHarvestTool(state), block.getHarvestLevel(state));
        }
        setCreativeTab(block.getCreativeTabToDisplayOn());

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        WinterIsHere.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}