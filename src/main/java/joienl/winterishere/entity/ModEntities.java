package joienl.winterishere.entity;

import joienl.winterishere.WinterIsHere;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

    private static int id = 0;

    public static void registerEntities() {
        registerEntity("small_iceball", EntitySmallIceball.class);
        registerEntity("blizzard", EntityBlizzard.class, rgbToInt(175, 197, 255), rgbToInt(225, 226, 255));
        registerEntity("ice_cube", EntityIceCube.class, rgbToInt(0, 13, 19), rgbToInt(1, 186, 255));
    }

    private static void registerEntity(String name, Class<? extends Entity> clazz) {
        EntityRegistry.registerModEntity(new ResourceLocation("wih", name), clazz, name, id++, WinterIsHere.instance, 80, 3, true);
    }

    private static void registerEntity(String name, Class<? extends Entity> clazz, int baseColour, int spotColour) {
        EntityRegistry.registerModEntity(new ResourceLocation("wih", name), clazz, name, id++, WinterIsHere.instance, 80, 3, true, baseColour, spotColour);
    }

    private static int rgbToInt(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255){
            throw new IllegalArgumentException("Invalid colour arguments, must be between 0 and 255 (both inclusive).");
        }
        int rgb = r;
        rgb = (rgb << 8) + g;
        rgb = (rgb << 8) + b;
        return rgb;
    }
}