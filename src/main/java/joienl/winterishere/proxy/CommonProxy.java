package joienl.winterishere.proxy;

import net.minecraft.item.Item;

public abstract class CommonProxy {
    public abstract void registerItemRenderer(Item item, int meta);
}