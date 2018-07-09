package joienl.winterishere.util.handlers;

import joienl.winterishere.block.ModBlocks;
import joienl.winterishere.command.CommandDimensionTeleport;
import joienl.winterishere.entity.ModEntities;
import joienl.winterishere.entity.render.ModEntityRenders;
import joienl.winterishere.item.ModItems;
import joienl.winterishere.util.IHasModel;
import joienl.winterishere.util.ModFurnaceRecipes;
import joienl.winterishere.world.biomes.ModBiomes;
import joienl.winterishere.world.dimensions.ModDimensions;
import joienl.winterishere.world.gen.WorldTypeWinter;
import joienl.winterishere.world.gen.structure.ModStructures;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> e) {
        e.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent e) {
        for (Item item : ModItems.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }

        for (Block block : ModBlocks.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }
    }

    public static void preInitRegistries() {
        ModBiomes.registerBiomes();
        ModDimensions.registerDimensions();

        ModEntities.registerEntities();
        ModEntityRenders.registerEntityRenders();
    }

    public static void initRegistries() { }

    public static void postInitRegistries() {
        new WorldTypeWinter();
        ModFurnaceRecipes.registerRecipes();
        ModStructures.registerStructures();
    }

    public static void serverRegistries(FMLServerStartingEvent e) {
        e.registerServerCommand(new CommandDimensionTeleport());
    }
}