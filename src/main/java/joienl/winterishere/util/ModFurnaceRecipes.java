package joienl.winterishere.util;

import joienl.winterishere.block.ModBlocks;
import joienl.winterishere.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ModFurnaceRecipes {
    public static void registerRecipes() {
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.BLUE_SAND, new ItemStack(Blocks.GLASS), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.FROSTED_NETHERRACK, new ItemStack(ModItems.FROSTED_NETHERBRICK), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.FROSTED_QUARTZ_ORE, new ItemStack(Items.QUARTZ), 0.2F);
    }
}