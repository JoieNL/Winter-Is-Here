package joienl.winterishere.block;

import joienl.winterishere.WinterIsHere;
import joienl.winterishere.util.IHasModel;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

@SuppressWarnings("ConstantConditions")
public abstract class ModBlockSlab extends BlockSlab implements IHasModel {

    private static final PropertyEnum<Variant> VARIANT = PropertyEnum.create("variant", Variant.class);

    ModBlockSlab(IBlockState state) {
        super(state.getMaterial());
        ModBlockBase block = (ModBlockBase) state.getBlock();
        String name = state.getBlock().getRegistryName().getResourcePath() + (!this.isDouble() ? "_half" : "_double") + "_slab";
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(block.getHardness());
        setResistance(block.getResistance() / 3F);
        if (block.getHarvestLevel(state) >= 0) {
            setHarvestLevel(block.getHarvestTool(state), block.getHarvestLevel(state));
        }
        setCreativeTab(block.getCreativeTabToDisplayOn());

        IBlockState iblockstate = this.blockState.getBaseState();
        if (!this.isDouble()) {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }

        this.setDefaultState(iblockstate.withProperty(VARIANT, Variant.DEFAULT));
        this.useNeighborBrightness = true;

        ModBlocks.BLOCKS.add(this);
    }

    @Override
    public void registerModels() {
        WinterIsHere.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }

    @Override
    public String getUnlocalizedName(int meta) { return super.getUnlocalizedName(); }

    @Override
    public IProperty<?> getVariantProperty() { return VARIANT; }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) { return Variant.DEFAULT; }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, Variant.DEFAULT);

        if (!this.isDouble()) {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }

        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP) {
            i |= 8;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, VARIANT) : new BlockStateContainer(this, HALF, VARIANT);
    }

    public enum Variant implements IStringSerializable {
        DEFAULT;

        @Override
        public String getName() { return "default"; }
    }

    public static class Half extends ModBlockSlab {
        public Half(IBlockState state) { super(state); }

        @Override
        public boolean isDouble() { return false; }
    }

    public static class Double extends ModBlockSlab {
        public Double(IBlockState state) { super(state); }

        @Override
        public boolean isDouble() { return true; }
    }
}