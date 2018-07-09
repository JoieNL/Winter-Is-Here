package joienl.winterishere.util;

import joienl.winterishere.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class ModBrewingRecipes {
    public static void registerRecipes() {
        BrewingRecipeRegistry.addRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER), new ItemStack(ModItems.BLIZZARD_POWDER), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.MUNDANE));
        BrewingRecipeRegistry.addRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.AWKWARD), new ItemStack(ModItems.BLIZZARD_POWDER), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.SLOWNESS));

        BrewingRecipeRegistry.addRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER), new ItemStack(ModItems.ICE_CREAM), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.MUNDANE));
        BrewingRecipeRegistry.addRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.AWKWARD), new ItemStack(ModItems.ICE_CREAM), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER_BREATHING));
    }
}