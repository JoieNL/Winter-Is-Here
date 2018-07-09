package joienl.winterishere.entity.render;

import joienl.winterishere.entity.EntityBlizzard;
import joienl.winterishere.entity.EntityIceCube;
import joienl.winterishere.entity.EntitySmallIceball;
import joienl.winterishere.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ModEntityRenders {

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySmallIceball.class, (RenderManager renderManagerIn) -> new RenderSnowball<>(renderManagerIn, ModItems.ICE_CHARGE, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlizzard.class, RenderBlizzard::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityIceCube.class, RenderIceCube::new);
    }
}