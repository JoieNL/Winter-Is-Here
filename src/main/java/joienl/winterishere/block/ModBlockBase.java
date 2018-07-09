package joienl.winterishere.block;

import joienl.winterishere.WinterIsHere;
import joienl.winterishere.item.ModItems;
import joienl.winterishere.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class ModBlockBase extends Block implements IHasModel {

    private final float hardness;
    private final float resistance;

    ModBlockBase(String name, Material material, float hardness, float resistance, int harvestLevel) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(this.hardness = hardness);
        setResistance(this.resistance = resistance / 3F);
        if (harvestLevel >= 0) {
            setHarvestLevel("pickaxe", harvestLevel);
        }
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        ModBlocks.BLOCKS.add(this);
        assert this.getRegistryName() != null;
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    float getHardness() { return hardness; }

    float getResistance() { return resistance * 3F; }

    @Override
    public void registerModels() {
        WinterIsHere.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}