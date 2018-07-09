package joienl.winterishere.item;

import joienl.winterishere.WinterIsHere;
import joienl.winterishere.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItemBase extends Item implements IHasModel {
    public ModItemBase(String name) {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);

        ModItems.ITEMS.add(this);
    }


    @Override
    public void registerModels() {
        WinterIsHere.proxy.registerItemRenderer(this, 0);
    }
}