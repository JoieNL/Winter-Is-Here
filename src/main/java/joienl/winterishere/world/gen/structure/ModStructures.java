package joienl.winterishere.world.gen.structure;

import net.minecraft.world.gen.structure.MapGenStructureIO;

public class ModStructures {
    public static void registerStructures() {
        MapGenStructureIO.registerStructure(MapGenFrozenNetherBridge.Start.class, "Frozen Fortress");
        StructureFrozenNetherBridgePieces.registerFrozenNetherFortressPieces();
    }
}