package joienl.winterishere.block;

import joienl.winterishere.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings({"unused", "WeakerAccess"})
public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static Block BLUE_SAND; //12
    public static Block FROSTED_NETHERRACK; //87
    public static Block FROSTED_NETHER_BRICK; //112.0
    public static ModBlockSlab.Half FROSTED_NETHER_BRICK_HALF_SLAB; //112.1
    public static ModBlockSlab.Double FROSTED_NETHER_BRICK_DOUBLE_SLAB; //112.2
    public static Block FROSTED_NETHER_BRICK_FENCE; //112.3
    public static Block FROSTED_NETHER_BRICK_STAIRS; //112.4
    public static Block FROSTED_QUARTZ_ORE ; //153
    public static Block AQUA_BLOCK; //213
    public static Block BLUE_NETHER_BRICK; //215

    static {
        //<editor-fold desc="Harvest Levels">
        /*
         Hand:          -1
         Wood/Gold:     0
         Stone:         1
         Iron:          2
         Diamond:       3
         */
        //</editor-fold>
        BLUE_SAND = new ModBlockFalling("blue_sand", Material.SAND, 0.5F, 2.5F, 10016468);
        FROSTED_NETHERRACK = new ModBlockBase("frosted_netherrack", Material.ROCK, 0.4F, 2F, 0);
        FROSTED_NETHER_BRICK = new ModBlockBase("frosted_nether_brick", Material.ROCK, 2.0F, 30.0F, 0);
        FROSTED_NETHER_BRICK_HALF_SLAB = new ModBlockSlab.Half(FROSTED_NETHER_BRICK.getDefaultState());
        FROSTED_NETHER_BRICK_DOUBLE_SLAB = new ModBlockSlab.Double(FROSTED_NETHER_BRICK.getDefaultState());
        ModItems.ITEMS.add(new ItemSlab(FROSTED_NETHER_BRICK_HALF_SLAB, FROSTED_NETHER_BRICK_HALF_SLAB, FROSTED_NETHER_BRICK_DOUBLE_SLAB).setRegistryName(Objects.requireNonNull(FROSTED_NETHER_BRICK_HALF_SLAB.getRegistryName())));
        FROSTED_NETHER_BRICK_FENCE = new ModBlockFence(FROSTED_NETHER_BRICK.getDefaultState());
        FROSTED_NETHER_BRICK_STAIRS = new ModBlockStairs(FROSTED_NETHER_BRICK.getDefaultState());
        FROSTED_QUARTZ_ORE = new ModBlockOre("frosted_quartz_ore", new ItemStack(Items.QUARTZ), 3.0F, 15.0F, 0);
        AQUA_BLOCK = new ModBlockAqua();
        BLUE_NETHER_BRICK = new ModBlockBase("blue_nether_brick", Material.ROCK, 2.0F, 30.0F, 0);
    }
}