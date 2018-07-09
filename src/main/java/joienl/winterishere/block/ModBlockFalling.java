package joienl.winterishere.block;

import joienl.winterishere.WinterIsHere;
import joienl.winterishere.item.ModItems;
import joienl.winterishere.util.IHasModel;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class ModBlockFalling extends BlockFalling implements IHasModel {

    private final int dustColour;

    ModBlockFalling(String name, Material material, float hardness, float resistance, int dustColour) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance/3F);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        if (material == Material.SAND) {setSoundType(SoundType.SAND);}
        this.dustColour = dustColour;

        ModBlocks.BLOCKS.add(this);
        assert this.getRegistryName() != null;
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public int getDustColor(IBlockState state) { return dustColour; }

    @Override
    public void registerModels() {
        WinterIsHere.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}