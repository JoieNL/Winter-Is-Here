package joienl.winterishere.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy {
    @Override
    public void registerItemRenderer(Item item, int meta) {
        assert item.getRegistryName() != null;
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}