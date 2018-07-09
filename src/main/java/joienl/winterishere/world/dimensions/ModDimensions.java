package joienl.winterishere.world.dimensions;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {
    static final DimensionType FROZEN_NETHER = DimensionType.register("Frozen Nether", "_frozen_nether", -2, WorldProviderFrozenHell.class, false);
    static final DimensionType THE_FROZEN_END = DimensionType.register("The Frozen End", "_frozen_end", 2, WorldProviderFrozenEnd.class, false);

    public static void registerDimensions() {
        DimensionManager.registerDimension(-2, FROZEN_NETHER);
        DimensionManager.registerDimension(2, THE_FROZEN_END);
    }
}