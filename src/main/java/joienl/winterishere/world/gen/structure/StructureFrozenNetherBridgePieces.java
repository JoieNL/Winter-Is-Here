package joienl.winterishere.world.gen.structure;

import com.google.common.collect.Lists;
import joienl.winterishere.block.ModBlocks;
import joienl.winterishere.entity.EntityBlizzard;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class StructureFrozenNetherBridgePieces
{
    private static final StructureFrozenNetherBridgePieces.PieceWeight[] PRIMARY_COMPONENTS = new StructureFrozenNetherBridgePieces.PieceWeight[] {new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.Straight.class, 30, 0, true), new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.Crossing3.class, 10, 4), new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.Crossing.class, 10, 4), new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.Stairs.class, 10, 3), new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.Throne.class, 5, 2), new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.Entrance.class, 5, 1)};
    private static final StructureFrozenNetherBridgePieces.PieceWeight[] SECONDARY_COMPONENTS = new StructureFrozenNetherBridgePieces.PieceWeight[] {new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.Corridor5.class, 25, 0, true), new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.Crossing2.class, 15, 5), new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.Corridor2.class, 5, 10), new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.Corridor.class, 5, 10), new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.Corridor3.class, 10, 3, true), new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.Corridor4.class, 7, 2), new StructureFrozenNetherBridgePieces.PieceWeight(StructureFrozenNetherBridgePieces.NetherStalkRoom.class, 5, 2)};

    public static void registerFrozenNetherFortressPieces()
    {
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Crossing3.class, "NeBCr");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.End.class, "NeBEF");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Straight.class, "NeBS");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Corridor3.class, "NeCCS");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Corridor4.class, "NeCTB");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Entrance.class, "NeCE");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Crossing2.class, "NeSCSC");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Corridor.class, "NeSCLT");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Corridor5.class, "NeSC");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Corridor2.class, "NeSCRT");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.NetherStalkRoom.class, "NeCSR");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Throne.class, "NeMT");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Crossing.class, "NeRC");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Stairs.class, "NeSR");
        MapGenStructureIO.registerStructureComponent(StructureFrozenNetherBridgePieces.Start.class, "NeStart");
    }

    private static StructureFrozenNetherBridgePieces.Piece findAndCreateBridgePieceFactory(StructureFrozenNetherBridgePieces.PieceWeight p_175887_0_, List<StructureComponent> p_175887_1_, Random p_175887_2_, int p_175887_3_, int p_175887_4_, int p_175887_5_, EnumFacing p_175887_6_, int p_175887_7_)
    {
        Class <? extends StructureFrozenNetherBridgePieces.Piece > oclass = p_175887_0_.weightClass;
        StructureFrozenNetherBridgePieces.Piece structurenetherbridgepieces$piece = null;

        if (oclass == StructureFrozenNetherBridgePieces.Straight.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.Straight.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == StructureFrozenNetherBridgePieces.Crossing3.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.Crossing3.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == StructureFrozenNetherBridgePieces.Crossing.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.Crossing.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == StructureFrozenNetherBridgePieces.Stairs.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.Stairs.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_7_, p_175887_6_);
        }
        else if (oclass == StructureFrozenNetherBridgePieces.Throne.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.Throne.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_7_, p_175887_6_);
        }
        else if (oclass == StructureFrozenNetherBridgePieces.Entrance.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.Entrance.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == StructureFrozenNetherBridgePieces.Corridor5.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.Corridor5.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == StructureFrozenNetherBridgePieces.Corridor2.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.Corridor2.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == StructureFrozenNetherBridgePieces.Corridor.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.Corridor.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == StructureFrozenNetherBridgePieces.Corridor3.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.Corridor3.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == StructureFrozenNetherBridgePieces.Corridor4.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.Corridor4.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == StructureFrozenNetherBridgePieces.Crossing2.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.Crossing2.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }
        else if (oclass == StructureFrozenNetherBridgePieces.NetherStalkRoom.class)
        {
            structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.NetherStalkRoom.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
        }

        return structurenetherbridgepieces$piece;
    }

    protected static class Corridor extends StructureFrozenNetherBridgePieces.Piece
    {
        private boolean chest;

        Corridor()
        {
        }

        Corridor(int p_i45615_1_, Random p_i45615_2_, StructureBoundingBox p_i45615_3_, EnumFacing p_i45615_4_)
        {
            super(p_i45615_1_);
            this.setCoordBaseMode(p_i45615_4_);
            this.boundingBox = p_i45615_3_;
            this.chest = p_i45615_2_.nextInt(3) == 0;
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        @Override
        protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_)
        {
            super.readStructureFromNBT(tagCompound, p_143011_2_);
            this.chest = tagCompound.getBoolean("Chest");
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        @Override
        protected void writeStructureToNBT(NBTTagCompound tagCompound)
        {
            super.writeStructureToNBT(tagCompound);
            tagCompound.setBoolean("Chest", this.chest);
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        @Override
        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            this.getNextComponentX((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 0, 1, true);
        }

        static StructureFrozenNetherBridgePieces.Corridor createPiece(List<StructureComponent> p_175879_0_, Random p_175879_1_, int p_175879_2_, int p_175879_3_, int p_175879_4_, EnumFacing p_175879_5_, int p_175879_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175879_2_, p_175879_3_, p_175879_4_, -1, 0, 0, 5, 7, 5, p_175879_5_);
            if (isAboveGround(structureboundingbox)) {
                StructureComponent.findIntersecting(p_175879_0_, structureboundingbox);
            }
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 1, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 0, 4, 5, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 3, 1, 4, 4, 1, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 3, 3, 4, 4, 3, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 0, 5, 0, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 4, 3, 5, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 3, 4, 1, 4, 4, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 3, 4, 3, 4, 4, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            if (this.chest && structureBoundingBoxIn.isVecInside(new BlockPos(this.getXWithOffset(3, 3), this.getYWithOffset(2), this.getZWithOffset(3, 3))))
            {
                this.chest = false;
                this.generateChest(worldIn, structureBoundingBoxIn, randomIn, 3, 2, 3, LootTableList.CHESTS_NETHER_BRIDGE);
            }

            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 0, 4, 6, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 4; ++j)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, -1, j, structureBoundingBoxIn);
                }
            }

            return true;
        }
    }

    protected static class Corridor2 extends StructureFrozenNetherBridgePieces.Piece
    {
        private boolean chest;

        Corridor2()
        {
        }

        Corridor2(int p_i45613_1_, Random p_i45613_2_, StructureBoundingBox p_i45613_3_, EnumFacing p_i45613_4_)
        {
            super(p_i45613_1_);
            this.setCoordBaseMode(p_i45613_4_);
            this.boundingBox = p_i45613_3_;
            this.chest = p_i45613_2_.nextInt(3) == 0;
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        @Override
        protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_)
        {
            super.readStructureFromNBT(tagCompound, p_143011_2_);
            this.chest = tagCompound.getBoolean("Chest");
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        @Override
        protected void writeStructureToNBT(NBTTagCompound tagCompound)
        {
            super.writeStructureToNBT(tagCompound);
            tagCompound.setBoolean("Chest", this.chest);
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        @Override
        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            this.getNextComponentZ((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 0, 1, true);
        }

        static StructureFrozenNetherBridgePieces.Corridor2 createPiece(List<StructureComponent> p_175876_0_, Random p_175876_1_, int p_175876_2_, int p_175876_3_, int p_175876_4_, EnumFacing p_175876_5_, int p_175876_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175876_2_, p_175876_3_, p_175876_4_, -1, 0, 0, 5, 7, 5, p_175876_5_);
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 1, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 0, 5, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 1, 0, 4, 1, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 3, 0, 4, 3, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 0, 4, 5, 0, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 4, 4, 5, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 3, 4, 1, 4, 4, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 3, 4, 3, 4, 4, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            if (this.chest && structureBoundingBoxIn.isVecInside(new BlockPos(this.getXWithOffset(1, 3), this.getYWithOffset(2), this.getZWithOffset(1, 3))))
            {
                this.chest = false;
                this.generateChest(worldIn, structureBoundingBoxIn, randomIn, 1, 2, 3, LootTableList.CHESTS_NETHER_BRIDGE);
            }

            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 0, 4, 6, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 4; ++j)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, -1, j, structureBoundingBoxIn);
                }
            }

            return true;
        }
    }

    static class Corridor3 extends StructureFrozenNetherBridgePieces.Piece
    {
        Corridor3()
        {
        }

        Corridor3(int p_i45619_1_, Random p_i45619_2_, StructureBoundingBox p_i45619_3_, EnumFacing p_i45619_4_)
        {
            super(p_i45619_1_);
            this.setCoordBaseMode(p_i45619_4_);
            this.boundingBox = p_i45619_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        @Override
        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            this.getNextComponentNormal((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 1, 0, true);
        }

        static StructureFrozenNetherBridgePieces.Corridor3 createPiece(List<StructureComponent> p_175883_0_, Random p_175883_1_, int p_175883_2_, int p_175883_3_, int p_175883_4_, EnumFacing p_175883_5_, int p_175883_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175883_2_, p_175883_3_, p_175883_4_, -1, -7, 0, 5, 14, 10, p_175883_5_);
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            IBlockState iblockstate = ModBlocks.FROSTED_NETHER_BRICK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH);

            for (int i = 0; i <= 9; ++i)
            {
                int j = Math.max(1, 7 - i);
                int k = Math.min(Math.max(j + 5, 14 - i), 13);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, i, 4, j, i, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, j + 1, i, 3, k - 1, i, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);

                if (i <= 6)
                {
                    this.setBlockState(worldIn, iblockstate, 1, j + 1, i, structureBoundingBoxIn);
                    this.setBlockState(worldIn, iblockstate, 2, j + 1, i, structureBoundingBoxIn);
                    this.setBlockState(worldIn, iblockstate, 3, j + 1, i, structureBoundingBoxIn);
                }

                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, k, i, 4, k, i, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, j + 1, i, 0, k - 1, i, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, j + 1, i, 4, k - 1, i, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

                if ((i & 1) == 0)
                {
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, j + 2, i, 0, j + 3, i, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, j + 2, i, 4, j + 3, i, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
                }

                for (int i1 = 0; i1 <= 4; ++i1)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i1, -1, i, structureBoundingBoxIn);
                }
            }

            return true;
        }
    }

    static class Corridor4 extends StructureFrozenNetherBridgePieces.Piece
    {
        Corridor4()
        {
        }

        Corridor4(int p_i45618_1_, Random p_i45618_2_, StructureBoundingBox p_i45618_3_, EnumFacing p_i45618_4_)
        {
            super(p_i45618_1_);
            this.setCoordBaseMode(p_i45618_4_);
            this.boundingBox = p_i45618_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        @Override
        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            int i = 1;
            EnumFacing enumfacing = this.getCoordBaseMode();

            if (enumfacing == EnumFacing.WEST || enumfacing == EnumFacing.NORTH)
            {
                i = 5;
            }

            this.getNextComponentX((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 0, i, rand.nextInt(8) > 0);
            this.getNextComponentZ((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 0, i, rand.nextInt(8) > 0);
        }

        static StructureFrozenNetherBridgePieces.Corridor4 createPiece(List<StructureComponent> p_175880_0_, Random p_175880_1_, int p_175880_2_, int p_175880_3_, int p_175880_4_, EnumFacing p_175880_5_, int p_175880_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175880_2_, p_175880_3_, p_175880_4_, -3, 0, 0, 9, 7, 9, p_175880_5_);
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 8, 1, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 8, 5, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 0, 8, 6, 5, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 2, 5, 0, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 2, 0, 8, 5, 0, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 3, 0, 1, 4, 0, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 3, 0, 7, 4, 0, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 4, 8, 2, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 1, 4, 2, 2, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 1, 4, 7, 2, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 8, 8, 3, 8, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 6, 0, 3, 7, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 3, 6, 8, 3, 7, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 4, 0, 5, 5, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 3, 4, 8, 5, 5, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 3, 5, 2, 5, 5, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 3, 5, 7, 5, 5, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 4, 5, 1, 5, 5, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 4, 5, 7, 5, 5, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);

            for (int i = 0; i <= 5; ++i)
            {
                for (int j = 0; j <= 8; ++j)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), j, -1, i, structureBoundingBoxIn);
                }
            }

            return true;
        }
    }

    static class Corridor5 extends StructureFrozenNetherBridgePieces.Piece
    {
        Corridor5()
        {
        }

        Corridor5(int p_i45614_1_, Random p_i45614_2_, StructureBoundingBox p_i45614_3_, EnumFacing p_i45614_4_)
        {
            super(p_i45614_1_);
            this.setCoordBaseMode(p_i45614_4_);
            this.boundingBox = p_i45614_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        @Override
        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            this.getNextComponentNormal((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 1, 0, true);
        }

        static StructureFrozenNetherBridgePieces.Corridor5 createPiece(List<StructureComponent> p_175877_0_, Random p_175877_1_, int p_175877_2_, int p_175877_3_, int p_175877_4_, EnumFacing p_175877_5_, int p_175877_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175877_2_, p_175877_3_, p_175877_4_, -1, 0, 0, 5, 7, 5, p_175877_5_);
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 1, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 0, 5, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 0, 4, 5, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 1, 0, 4, 1, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 3, 0, 4, 3, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 3, 1, 4, 4, 1, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 3, 3, 4, 4, 3, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 0, 4, 6, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 4; ++j)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, -1, j, structureBoundingBoxIn);
                }
            }

            return true;
        }
    }

    static class Crossing extends StructureFrozenNetherBridgePieces.Piece
    {
        Crossing()
        {
        }

        Crossing(int p_i45610_1_, Random p_i45610_2_, StructureBoundingBox p_i45610_3_, EnumFacing p_i45610_4_)
        {
            super(p_i45610_1_);
            this.setCoordBaseMode(p_i45610_4_);
            this.boundingBox = p_i45610_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        @Override
        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            this.getNextComponentNormal((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 2, 0, false);
            this.getNextComponentX((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 0, 2, false);
            this.getNextComponentZ((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 0, 2, false);
        }

        static StructureFrozenNetherBridgePieces.Crossing createPiece(List<StructureComponent> p_175873_0_, Random p_175873_1_, int p_175873_2_, int p_175873_3_, int p_175873_4_, EnumFacing p_175873_5_, int p_175873_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175873_2_, p_175873_3_, p_175873_4_, -2, 0, 0, 7, 9, 7, p_175873_5_);
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 6, 1, 6, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 6, 7, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 1, 6, 0, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 6, 1, 6, 6, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 2, 0, 6, 6, 0, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 2, 6, 6, 6, 6, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 0, 6, 1, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 5, 0, 6, 6, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 2, 0, 6, 6, 1, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 2, 5, 6, 6, 6, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 6, 0, 4, 6, 0, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 0, 4, 5, 0, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 6, 6, 4, 6, 6, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 6, 4, 5, 6, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 2, 0, 6, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 2, 0, 5, 4, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 6, 2, 6, 6, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 5, 2, 6, 5, 4, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);

            for (int i = 0; i <= 6; ++i)
            {
                for (int j = 0; j <= 6; ++j)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, -1, j, structureBoundingBoxIn);
                }
            }

            return true;
        }
    }

    static class Crossing2 extends StructureFrozenNetherBridgePieces.Piece
    {
        Crossing2()
        {
        }

        Crossing2(int p_i45616_1_, Random p_i45616_2_, StructureBoundingBox p_i45616_3_, EnumFacing p_i45616_4_)
        {
            super(p_i45616_1_);
            this.setCoordBaseMode(p_i45616_4_);
            this.boundingBox = p_i45616_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        @Override
        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            this.getNextComponentNormal((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 1, 0, true);
            this.getNextComponentX((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 0, 1, true);
            this.getNextComponentZ((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 0, 1, true);
        }

        static StructureFrozenNetherBridgePieces.Crossing2 createPiece(List<StructureComponent> p_175878_0_, Random p_175878_1_, int p_175878_2_, int p_175878_3_, int p_175878_4_, EnumFacing p_175878_5_, int p_175878_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175878_2_, p_175878_3_, p_175878_4_, -1, 0, 0, 5, 7, 5, p_175878_5_);
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 1, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 0, 5, 0, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 0, 4, 5, 0, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 4, 0, 5, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 4, 4, 5, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 0, 4, 6, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 4; ++j)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, -1, j, structureBoundingBoxIn);
                }
            }

            return true;
        }
    }

    public static class Crossing3 extends StructureFrozenNetherBridgePieces.Piece
    {
        Crossing3()
        {
        }

        Crossing3(int p_i45622_1_, Random p_i45622_2_, StructureBoundingBox p_i45622_3_, EnumFacing p_i45622_4_)
        {
            super(p_i45622_1_);
            this.setCoordBaseMode(p_i45622_4_);
            this.boundingBox = p_i45622_3_;
        }

        Crossing3(Random p_i2042_1_, int p_i2042_2_, int p_i2042_3_)
        {
            super(0);
            this.setCoordBaseMode(EnumFacing.Plane.HORIZONTAL.random(p_i2042_1_));

            if (this.getCoordBaseMode().getAxis() == EnumFacing.Axis.Z)
            {
                this.boundingBox = new StructureBoundingBox(p_i2042_2_, 64, p_i2042_3_, p_i2042_2_ + 19 - 1, 73, p_i2042_3_ + 19 - 1);
            }
            else
            {
                this.boundingBox = new StructureBoundingBox(p_i2042_2_, 64, p_i2042_3_, p_i2042_2_ + 19 - 1, 73, p_i2042_3_ + 19 - 1);
            }
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        @Override
        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            this.getNextComponentNormal((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 8, 3, false);
            this.getNextComponentX((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 3, 8, false);
            this.getNextComponentZ((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 3, 8, false);
        }

        static StructureFrozenNetherBridgePieces.Crossing3 createPiece(List<StructureComponent> p_175885_0_, Random p_175885_1_, int p_175885_2_, int p_175885_3_, int p_175885_4_, EnumFacing p_175885_5_, int p_175885_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175885_2_, p_175885_3_, p_175885_4_, -8, -3, 0, 19, 10, 19, p_175885_5_);
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 3, 0, 11, 4, 18, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 7, 18, 4, 11, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 0, 10, 7, 18, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 8, 18, 7, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 5, 0, 7, 5, 7, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 5, 11, 7, 5, 18, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 5, 0, 11, 5, 7, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 5, 11, 11, 5, 18, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 7, 7, 5, 7, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 5, 7, 18, 5, 7, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 11, 7, 5, 11, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 5, 11, 18, 5, 11, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 2, 0, 11, 2, 5, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 2, 13, 11, 2, 18, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 0, 0, 11, 1, 3, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 0, 15, 11, 1, 18, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            for (int i = 7; i <= 11; ++i)
            {
                for (int j = 0; j <= 2; ++j)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, -1, j, structureBoundingBoxIn);
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, -1, 18 - j, structureBoundingBoxIn);
                }
            }

            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 7, 5, 2, 11, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 13, 2, 7, 18, 2, 11, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 7, 3, 1, 11, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 15, 0, 7, 18, 1, 11, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            for (int k = 0; k <= 2; ++k)
            {
                for (int l = 7; l <= 11; ++l)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), k, -1, l, structureBoundingBoxIn);
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), 18 - k, -1, l, structureBoundingBoxIn);
                }
            }

            return true;
        }
    }

    protected static class End extends StructureFrozenNetherBridgePieces.Piece
    {
        private int fillSeed;

        End()
        {
        }

        End(int p_i45621_1_, Random p_i45621_2_, StructureBoundingBox p_i45621_3_, EnumFacing p_i45621_4_)
        {
            super(p_i45621_1_);
            this.setCoordBaseMode(p_i45621_4_);
            this.boundingBox = p_i45621_3_;
            this.fillSeed = p_i45621_2_.nextInt();
        }

        static StructureFrozenNetherBridgePieces.End createPiece(List<StructureComponent> p_175884_0_, Random p_175884_1_, int p_175884_2_, int p_175884_3_, int p_175884_4_, EnumFacing p_175884_5_, int p_175884_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175884_2_, p_175884_3_, p_175884_4_, -1, -3, 0, 5, 10, 8, p_175884_5_);
            return null;
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        @Override
        protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_)
        {
            super.readStructureFromNBT(tagCompound, p_143011_2_);
            this.fillSeed = tagCompound.getInteger("Seed");
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        @Override
        protected void writeStructureToNBT(NBTTagCompound tagCompound)
        {
            super.writeStructureToNBT(tagCompound);
            tagCompound.setInteger("Seed", this.fillSeed);
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            Random random = new Random((long)this.fillSeed);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 3; j <= 4; ++j)
                {
                    int k = random.nextInt(8);
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, i, j, 0, i, j, k, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
                }
            }

            int l = random.nextInt(8);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 0, 5, l, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            l = random.nextInt(8);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 5, 0, 4, 5, l, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            for (int i1 = 0; i1 <= 4; ++i1)
            {
                int k1 = random.nextInt(5);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, i1, 2, 0, i1, 2, k1, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            }

            for (int j1 = 0; j1 <= 4; ++j1)
            {
                for (int l1 = 0; l1 <= 1; ++l1)
                {
                    int i2 = random.nextInt(3);
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, j1, l1, 0, j1, l1, i2, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
                }
            }

            return true;
        }
    }

    static class Entrance extends StructureFrozenNetherBridgePieces.Piece
    {
        Entrance()
        {
        }

        Entrance(int p_i45617_1_, Random p_i45617_2_, StructureBoundingBox p_i45617_3_, EnumFacing p_i45617_4_)
        {
            super(p_i45617_1_);
            this.setCoordBaseMode(p_i45617_4_);
            this.boundingBox = p_i45617_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        @Override
        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            this.getNextComponentNormal((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 5, 3, true);
        }

        static StructureFrozenNetherBridgePieces.Entrance createPiece(List<StructureComponent> p_175881_0_, Random p_175881_1_, int p_175881_2_, int p_175881_3_, int p_175881_4_, EnumFacing p_175881_5_, int p_175881_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175881_2_, p_175881_3_, p_175881_4_, -5, -3, 0, 13, 14, 13, p_175881_5_);
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 0, 12, 4, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 12, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 1, 12, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 5, 0, 12, 12, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 11, 4, 12, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 11, 10, 12, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 9, 11, 7, 12, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 0, 4, 12, 1, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 0, 10, 12, 1, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 9, 0, 7, 12, 1, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 11, 2, 10, 12, 10, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 8, 0, 7, 8, 0, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);

            for (int i = 1; i <= 11; i += 2)
            {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, i, 10, 0, i, 11, 0, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, i, 10, 12, i, 11, 12, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 10, i, 0, 11, i, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 12, 10, i, 12, 11, i, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, 13, 0, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, 13, 12, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), 0, 13, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), 12, 13, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), i + 1, 13, 0, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), i + 1, 13, 12, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 0, 13, i + 1, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 12, 13, i + 1, structureBoundingBoxIn);
            }

            this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 0, structureBoundingBoxIn);
            this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 12, structureBoundingBoxIn);
            this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 0, structureBoundingBoxIn);
            this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 12, 13, 0, structureBoundingBoxIn);

            for (int k = 3; k <= 9; k += 2)
            {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 7, k, 1, 8, k, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 7, k, 11, 8, k, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            }

            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 0, 8, 2, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 4, 12, 2, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 0, 8, 1, 3, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 9, 8, 1, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 4, 3, 1, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 0, 4, 12, 1, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            for (int l = 4; l <= 8; ++l)
            {
                for (int j = 0; j <= 2; ++j)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), l, -1, j, structureBoundingBoxIn);
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), l, -1, 12 - j, structureBoundingBoxIn);
                }
            }

            for (int i1 = 0; i1 <= 2; ++i1)
            {
                for (int j1 = 4; j1 <= 8; ++j1)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i1, -1, j1, structureBoundingBoxIn);
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), 12 - i1, -1, j1, structureBoundingBoxIn);
                }
            }

            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 5, 5, 7, 5, 7, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 1, 6, 6, 4, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), 6, 0, 6, structureBoundingBoxIn);
            IBlockState iblockstate = Blocks.OBSIDIAN.getDefaultState();
            this.setBlockState(worldIn, iblockstate, 6, 5, 6, structureBoundingBoxIn);
            BlockPos blockpos = new BlockPos(this.getXWithOffset(6, 6), this.getYWithOffset(5), this.getZWithOffset(6, 6));

            if (structureBoundingBoxIn.isVecInside(blockpos))
            {
                worldIn.immediateBlockTick(blockpos, iblockstate, randomIn);
            }

            return true;
        }
    }

    static class NetherStalkRoom extends StructureFrozenNetherBridgePieces.Piece
    {
        NetherStalkRoom()
        {
        }

        NetherStalkRoom(int p_i45612_1_, Random p_i45612_2_, StructureBoundingBox p_i45612_3_, EnumFacing p_i45612_4_)
        {
            super(p_i45612_1_);
            this.setCoordBaseMode(p_i45612_4_);
            this.boundingBox = p_i45612_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        @Override
        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            this.getNextComponentNormal((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 5, 3, true);
            this.getNextComponentNormal((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 5, 11, true);
        }

        static StructureFrozenNetherBridgePieces.NetherStalkRoom createPiece(List<StructureComponent> p_175875_0_, Random p_175875_1_, int p_175875_2_, int p_175875_3_, int p_175875_4_, EnumFacing p_175875_5_, int p_175875_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175875_2_, p_175875_3_, p_175875_4_, -5, -3, 0, 13, 14, 13, p_175875_5_);
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 0, 12, 4, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 12, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 1, 12, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 5, 0, 12, 12, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 11, 4, 12, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 11, 10, 12, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 9, 11, 7, 12, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 0, 4, 12, 1, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 0, 10, 12, 1, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 9, 0, 7, 12, 1, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 11, 2, 10, 12, 10, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            for (int i = 1; i <= 11; i += 2)
            {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, i, 10, 0, i, 11, 0, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, i, 10, 12, i, 11, 12, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 10, i, 0, 11, i, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 12, 10, i, 12, 11, i, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, 13, 0, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, 13, 12, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), 0, 13, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), 12, 13, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), i + 1, 13, 0, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), i + 1, 13, 12, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 0, 13, i + 1, structureBoundingBoxIn);
                this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 12, 13, i + 1, structureBoundingBoxIn);
            }

            this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 0, structureBoundingBoxIn);
            this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 12, structureBoundingBoxIn);
            this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 0, structureBoundingBoxIn);
            this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 12, 13, 0, structureBoundingBoxIn);

            for (int j1 = 3; j1 <= 9; j1 += 2)
            {
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 7, j1, 1, 8, j1, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 7, j1, 11, 8, j1, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            }

            IBlockState iblockstate = ModBlocks.FROSTED_NETHER_BRICK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH);

            for (int j = 0; j <= 6; ++j)
            {
                int k = j + 4;

                for (int l = 5; l <= 7; ++l)
                {
                    this.setBlockState(worldIn, iblockstate, l, 5 + j, k, structureBoundingBoxIn);
                }

                if (k >= 5 && k <= 8)
                {
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 5, k, 7, j + 4, k, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
                }
                else if (k >= 9 && k <= 10)
                {
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 8, k, 7, j + 4, k, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
                }

                if (j >= 1)
                {
                    this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 6 + j, k, 7, 9 + j, k, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                }
            }

            for (int k1 = 5; k1 <= 7; ++k1)
            {
                this.setBlockState(worldIn, iblockstate, k1, 12, 11, structureBoundingBoxIn);
            }

            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 6, 7, 5, 7, 7, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 6, 7, 7, 7, 7, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 13, 12, 7, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 2, 3, 5, 3, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 9, 3, 5, 10, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 4, 2, 5, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 5, 2, 10, 5, 3, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 5, 9, 10, 5, 10, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 10, 5, 4, 10, 5, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            IBlockState iblockstate1 = iblockstate.withProperty(BlockStairs.FACING, EnumFacing.EAST);
            IBlockState iblockstate2 = iblockstate.withProperty(BlockStairs.FACING, EnumFacing.WEST);
            this.setBlockState(worldIn, iblockstate2, 4, 5, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate2, 4, 5, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate2, 4, 5, 9, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate2, 4, 5, 10, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate1, 8, 5, 2, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate1, 8, 5, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate1, 8, 5, 9, structureBoundingBoxIn);
            this.setBlockState(worldIn, iblockstate1, 8, 5, 10, structureBoundingBoxIn);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 4, 4, 4, 4, 8, Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 4, 4, 9, 4, 8, Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 5, 4, 4, 5, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 4, 9, 5, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 0, 8, 2, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 4, 12, 2, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 0, 8, 1, 3, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 9, 8, 1, 12, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 4, 3, 1, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 0, 4, 12, 1, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            for (int l1 = 4; l1 <= 8; ++l1)
            {
                for (int i1 = 0; i1 <= 2; ++i1)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), l1, -1, i1, structureBoundingBoxIn);
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), l1, -1, 12 - i1, structureBoundingBoxIn);
                }
            }

            for (int i2 = 0; i2 <= 2; ++i2)
            {
                for (int j2 = 4; j2 <= 8; ++j2)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i2, -1, j2, structureBoundingBoxIn);
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), 12 - i2, -1, j2, structureBoundingBoxIn);
                }
            }

            return true;
        }
    }

    abstract static class Piece extends StructureComponent
    {
        Piece()
        {
        }

        Piece(int p_i2054_1_)
        {
            super(p_i2054_1_);
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        @Override
        protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_)
        {
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        @Override
        protected void writeStructureToNBT(NBTTagCompound tagCompound)
        {
        }

        private int getTotalWeight(List<StructureFrozenNetherBridgePieces.PieceWeight> p_74960_1_)
        {
            boolean flag = false;
            int i = 0;

            for (StructureFrozenNetherBridgePieces.PieceWeight structurenetherbridgepieces$pieceweight : p_74960_1_)
            {
                if (structurenetherbridgepieces$pieceweight.maxPlaceCount > 0 && structurenetherbridgepieces$pieceweight.placeCount < structurenetherbridgepieces$pieceweight.maxPlaceCount)
                {
                    flag = true;
                }

                i += structurenetherbridgepieces$pieceweight.weight;
            }

            return flag ? i : -1;
        }

        private StructureFrozenNetherBridgePieces.Piece generatePiece(StructureFrozenNetherBridgePieces.Start p_175871_1_, List<StructureFrozenNetherBridgePieces.PieceWeight> p_175871_2_, List<StructureComponent> p_175871_3_, Random p_175871_4_, int p_175871_5_, int p_175871_6_, int p_175871_7_, EnumFacing p_175871_8_, int p_175871_9_)
        {
            int i = this.getTotalWeight(p_175871_2_);
            boolean flag = i > 0 && p_175871_9_ <= 30;
            int j = 0;

            while (j < 5 && flag)
            {
                ++j;
                int k = p_175871_4_.nextInt(i);

                for (StructureFrozenNetherBridgePieces.PieceWeight structurenetherbridgepieces$pieceweight : p_175871_2_)
                {
                    k -= structurenetherbridgepieces$pieceweight.weight;

                    if (k < 0)
                    {
                        if (!structurenetherbridgepieces$pieceweight.doPlace(p_175871_9_) || structurenetherbridgepieces$pieceweight == p_175871_1_.lastPlaced && !structurenetherbridgepieces$pieceweight.allowInRow)
                        {
                            break;
                        }

                        StructureFrozenNetherBridgePieces.Piece structurenetherbridgepieces$piece = StructureFrozenNetherBridgePieces.findAndCreateBridgePieceFactory(structurenetherbridgepieces$pieceweight, p_175871_3_, p_175871_4_, p_175871_5_, p_175871_6_, p_175871_7_, p_175871_8_, p_175871_9_);

                        if (structurenetherbridgepieces$piece != null)
                        {
                            ++structurenetherbridgepieces$pieceweight.placeCount;
                            p_175871_1_.lastPlaced = structurenetherbridgepieces$pieceweight;

                            if (!structurenetherbridgepieces$pieceweight.isValid())
                            {
                                p_175871_2_.remove(structurenetherbridgepieces$pieceweight);
                            }

                            return structurenetherbridgepieces$piece;
                        }
                    }
                }
            }

            return StructureFrozenNetherBridgePieces.End.createPiece(p_175871_3_, p_175871_4_, p_175871_5_, p_175871_6_, p_175871_7_, p_175871_8_, p_175871_9_);
        }

        private StructureComponent generateAndAddPiece(StructureFrozenNetherBridgePieces.Start p_175870_1_, List<StructureComponent> p_175870_2_, Random p_175870_3_, int p_175870_4_, int p_175870_5_, int p_175870_6_, @Nullable EnumFacing p_175870_7_, int p_175870_8_, boolean p_175870_9_)
        {
            if (Math.abs(p_175870_4_ - p_175870_1_.getBoundingBox().minX) <= 112 && Math.abs(p_175870_6_ - p_175870_1_.getBoundingBox().minZ) <= 112)
            {
                List<StructureFrozenNetherBridgePieces.PieceWeight> list = p_175870_1_.primaryWeights;

                if (p_175870_9_)
                {
                    list = p_175870_1_.secondaryWeights;
                }

                StructureComponent structurecomponent = this.generatePiece(p_175870_1_, list, p_175870_2_, p_175870_3_, p_175870_4_, p_175870_5_, p_175870_6_, p_175870_7_, p_175870_8_ + 1);

                if (structurecomponent != null)
                {
                    p_175870_2_.add(structurecomponent);
                    p_175870_1_.pendingChildren.add(structurecomponent);
                }

                return structurecomponent;
            }
            else
            {
                return StructureFrozenNetherBridgePieces.End.createPiece(p_175870_2_, p_175870_3_, p_175870_4_, p_175870_5_, p_175870_6_, p_175870_7_, p_175870_8_);
            }
        }

        /**
         * Gets the next component in any cardinal direction
         */
        @Nullable
        StructureComponent getNextComponentNormal(StructureFrozenNetherBridgePieces.Start p_74963_1_, List<StructureComponent> p_74963_2_, Random p_74963_3_, int p_74963_4_, int p_74963_5_, boolean p_74963_6_)
        {
            EnumFacing enumfacing = this.getCoordBaseMode();

            if (enumfacing != null)
            {
                switch (enumfacing)
                {
                    case NORTH:
                        return this.generateAndAddPiece(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX + p_74963_4_, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ - 1, enumfacing, this.getComponentType(), p_74963_6_);
                    case SOUTH:
                        return this.generateAndAddPiece(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX + p_74963_4_, this.boundingBox.minY + p_74963_5_, this.boundingBox.maxZ + 1, enumfacing, this.getComponentType(), p_74963_6_);
                    case WEST:
                        return this.generateAndAddPiece(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ + p_74963_4_, enumfacing, this.getComponentType(), p_74963_6_);
                    case EAST:
                        return this.generateAndAddPiece(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ + p_74963_4_, enumfacing, this.getComponentType(), p_74963_6_);
                }
            }

            return null;
        }

        /**
         * Gets the next component in the +/- X direction
         */
        @Nullable
        StructureComponent getNextComponentX(StructureFrozenNetherBridgePieces.Start p_74961_1_, List<StructureComponent> p_74961_2_, Random p_74961_3_, int p_74961_4_, int p_74961_5_, boolean p_74961_6_)
        {
            EnumFacing enumfacing = this.getCoordBaseMode();

            if (enumfacing != null)
            {
                switch (enumfacing)
                {
                    case NORTH:
                        return this.generateAndAddPiece(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ + p_74961_5_, EnumFacing.WEST, this.getComponentType(), p_74961_6_);
                    case SOUTH:
                        return this.generateAndAddPiece(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ + p_74961_5_, EnumFacing.WEST, this.getComponentType(), p_74961_6_);
                    case WEST:
                        return this.generateAndAddPiece(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX + p_74961_5_, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType(), p_74961_6_);
                    case EAST:
                        return this.generateAndAddPiece(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX + p_74961_5_, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType(), p_74961_6_);
                }
            }

            return null;
        }

        /**
         * Gets the next component in the +/- Z direction
         */
        @Nullable
        StructureComponent getNextComponentZ(StructureFrozenNetherBridgePieces.Start p_74965_1_, List<StructureComponent> p_74965_2_, Random p_74965_3_, int p_74965_4_, int p_74965_5_, boolean p_74965_6_)
        {
            EnumFacing enumfacing = this.getCoordBaseMode();

            if (enumfacing != null)
            {
                switch (enumfacing)
                {
                    case NORTH:
                        return this.generateAndAddPiece(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74965_4_, this.boundingBox.minZ + p_74965_5_, EnumFacing.EAST, this.getComponentType(), p_74965_6_);
                    case SOUTH:
                        return this.generateAndAddPiece(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74965_4_, this.boundingBox.minZ + p_74965_5_, EnumFacing.EAST, this.getComponentType(), p_74965_6_);
                    case WEST:
                        return this.generateAndAddPiece(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.minX + p_74965_5_, this.boundingBox.minY + p_74965_4_, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType(), p_74965_6_);
                    case EAST:
                        return this.generateAndAddPiece(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.minX + p_74965_5_, this.boundingBox.minY + p_74965_4_, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType(), p_74965_6_);
                }
            }

            return null;
        }

        /**
         * Checks if the bounding box's minY is > 10
         */
        static boolean isAboveGround(StructureBoundingBox p_74964_0_)
        {
            return p_74964_0_ != null && p_74964_0_.minY > 10;
        }
    }

    static class PieceWeight
    {
        final Class <? extends StructureFrozenNetherBridgePieces.Piece > weightClass;
        final int weight;
        int placeCount;
        final int maxPlaceCount;
        final boolean allowInRow;

        PieceWeight(Class<? extends StructureFrozenNetherBridgePieces.Piece> p_i2055_1_, int p_i2055_2_, int p_i2055_3_, boolean p_i2055_4_)
        {
            this.weightClass = p_i2055_1_;
            this.weight = p_i2055_2_;
            this.maxPlaceCount = p_i2055_3_;
            this.allowInRow = p_i2055_4_;
        }

        PieceWeight(Class<? extends StructureFrozenNetherBridgePieces.Piece> p_i2056_1_, int p_i2056_2_, int p_i2056_3_)
        {
            this(p_i2056_1_, p_i2056_2_, p_i2056_3_, false);
        }

        boolean doPlace(int p_78822_1_)
        {
            return this.maxPlaceCount == 0 || this.placeCount < this.maxPlaceCount;
        }

        boolean isValid()
        {
            return this.maxPlaceCount == 0 || this.placeCount < this.maxPlaceCount;
        }
    }

    static class Stairs extends StructureFrozenNetherBridgePieces.Piece
    {
        Stairs()
        {
        }

        Stairs(int p_i45609_1_, Random p_i45609_2_, StructureBoundingBox p_i45609_3_, EnumFacing p_i45609_4_)
        {
            super(p_i45609_1_);
            this.setCoordBaseMode(p_i45609_4_);
            this.boundingBox = p_i45609_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        @Override
        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            this.getNextComponentZ((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 6, 2, false);
        }

        static StructureFrozenNetherBridgePieces.Stairs createPiece(List<StructureComponent> p_175872_0_, Random p_175872_1_, int p_175872_2_, int p_175872_3_, int p_175872_4_, int p_175872_5_, EnumFacing p_175872_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175872_2_, p_175872_3_, p_175872_4_, -2, 0, 0, 7, 11, 7, p_175872_6_);
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 6, 1, 6, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 6, 10, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 1, 8, 0, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 2, 0, 6, 8, 0, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 1, 0, 8, 6, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 2, 1, 6, 8, 6, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 6, 5, 8, 6, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 2, 0, 5, 4, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 3, 2, 6, 5, 2, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 3, 4, 6, 5, 4, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), 5, 2, 5, structureBoundingBoxIn);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 5, 4, 3, 5, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 2, 5, 3, 4, 5, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 2, 5, 2, 5, 5, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 5, 1, 6, 5, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 7, 1, 5, 7, 4, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 8, 2, 6, 8, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 6, 0, 4, 8, 0, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 0, 4, 5, 0, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);

            for (int i = 0; i <= 6; ++i)
            {
                for (int j = 0; j <= 6; ++j)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, -1, j, structureBoundingBoxIn);
                }
            }

            return true;
        }
    }

    public static class Start extends StructureFrozenNetherBridgePieces.Crossing3
    {
        /** Instance of StructureNetherBridgePieceWeight. */
        StructureFrozenNetherBridgePieces.PieceWeight lastPlaced;
        /** Contains the list of valid piece weights for the set of nether bridge structure pieces. */
        List<StructureFrozenNetherBridgePieces.PieceWeight> primaryWeights;
        /** Contains the list of valid piece weights for the secondary set of nether bridge structure pieces. */
        List<StructureFrozenNetherBridgePieces.PieceWeight> secondaryWeights;
        public final List<StructureComponent> pendingChildren = Lists.newArrayList();

        public Start()
        {
        }

        public Start(Random p_i2059_1_, int p_i2059_2_, int p_i2059_3_)
        {
            super(p_i2059_1_, p_i2059_2_, p_i2059_3_);
            this.primaryWeights = Lists.newArrayList();

            for (StructureFrozenNetherBridgePieces.PieceWeight structurenetherbridgepieces$pieceweight : StructureFrozenNetherBridgePieces.PRIMARY_COMPONENTS)
            {
                structurenetherbridgepieces$pieceweight.placeCount = 0;
                this.primaryWeights.add(structurenetherbridgepieces$pieceweight);
            }

            this.secondaryWeights = Lists.newArrayList();

            for (StructureFrozenNetherBridgePieces.PieceWeight structurenetherbridgepieces$pieceweight1 : StructureFrozenNetherBridgePieces.SECONDARY_COMPONENTS)
            {
                structurenetherbridgepieces$pieceweight1.placeCount = 0;
                this.secondaryWeights.add(structurenetherbridgepieces$pieceweight1);
            }
        }
    }

    static class Straight extends StructureFrozenNetherBridgePieces.Piece
    {
        Straight()
        {
        }

        Straight(int p_i45620_1_, Random p_i45620_2_, StructureBoundingBox p_i45620_3_, EnumFacing p_i45620_4_)
        {
            super(p_i45620_1_);
            this.setCoordBaseMode(p_i45620_4_);
            this.boundingBox = p_i45620_3_;
        }

        /**
         * Initiates construction of the Structure Component picked, at the current Location of StructGen
         */
        @Override
        public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand)
        {
            this.getNextComponentNormal((StructureFrozenNetherBridgePieces.Start)componentIn, listIn, rand, 1, 3, false);
        }

        static StructureFrozenNetherBridgePieces.Straight createPiece(List<StructureComponent> p_175882_0_, Random p_175882_1_, int p_175882_2_, int p_175882_3_, int p_175882_4_, EnumFacing p_175882_5_, int p_175882_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175882_2_, p_175882_3_, p_175882_4_, -1, -3, 0, 5, 10, 19, p_175882_5_);
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 0, 4, 4, 18, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 5, 0, 3, 7, 18, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 0, 5, 18, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 5, 0, 4, 5, 18, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 4, 2, 5, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 13, 4, 2, 18, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 1, 3, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 15, 4, 1, 18, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);

            for (int i = 0; i <= 4; ++i)
            {
                for (int j = 0; j <= 2; ++j)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, -1, j, structureBoundingBoxIn);
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, -1, 18 - j, structureBoundingBoxIn);
                }
            }

            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 1, 0, 4, 1, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 4, 0, 4, 4, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 14, 0, 4, 14, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 17, 0, 4, 17, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 1, 1, 4, 4, 1, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 3, 4, 4, 4, 4, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 3, 14, 4, 4, 14, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 1, 17, 4, 4, 17, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            return true;
        }
    }

    protected static class Throne extends StructureFrozenNetherBridgePieces.Piece
    {
        private boolean hasSpawner;

        Throne()
        {
        }

        Throne(int p_i45611_1_, Random p_i45611_2_, StructureBoundingBox p_i45611_3_, EnumFacing p_i45611_4_)
        {
            super(p_i45611_1_);
            this.setCoordBaseMode(p_i45611_4_);
            this.boundingBox = p_i45611_3_;
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        @Override
        protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_)
        {
            super.readStructureFromNBT(tagCompound, p_143011_2_);
            this.hasSpawner = tagCompound.getBoolean("Mob");
        }

        /**
         * (abstract) Helper method to write subclass data to NBT
         */
        @Override
        protected void writeStructureToNBT(NBTTagCompound tagCompound)
        {
            super.writeStructureToNBT(tagCompound);
            tagCompound.setBoolean("Mob", this.hasSpawner);
        }

        static StructureFrozenNetherBridgePieces.Throne createPiece(List<StructureComponent> p_175874_0_, Random p_175874_1_, int p_175874_2_, int p_175874_3_, int p_175874_4_, int p_175874_5_, EnumFacing p_175874_6_)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175874_2_, p_175874_3_, p_175874_4_, -2, 0, 0, 7, 8, 9, p_175874_6_);
            return null;
        }

        /**
         * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
         * Mineshafts at the end, it adds Fences...
         */
        @Override
        public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
        {
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 6, 7, 7, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 0, 5, 1, 7, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 1, 5, 2, 7, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 3, 2, 5, 3, 7, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 4, 3, 5, 4, 7, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 0, 1, 4, 2, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 2, 0, 5, 4, 2, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 5, 2, 1, 5, 3, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 5, 2, 5, 5, 3, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 3, 0, 5, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 5, 3, 6, 5, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 5, 8, 5, 5, 8, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), false);
            this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 1, 6, 3, structureBoundingBoxIn);
            this.setBlockState(worldIn, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), 5, 6, 3, structureBoundingBoxIn);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 3, 0, 6, 8, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 6, 3, 6, 6, 8, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 6, 8, 5, 7, 8, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 8, 8, 4, 8, 8, ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), ModBlocks.FROSTED_NETHER_BRICK_FENCE.getDefaultState(), false);

            if (!this.hasSpawner)
            {
                BlockPos blockpos = new BlockPos(this.getXWithOffset(3, 5), this.getYWithOffset(5), this.getZWithOffset(3, 5));

                if (structureBoundingBoxIn.isVecInside(blockpos))
                {
                    this.hasSpawner = true;
                    worldIn.setBlockState(blockpos, Blocks.MOB_SPAWNER.getDefaultState(), 2);
                    TileEntity tileentity = worldIn.getTileEntity(blockpos);

                    if (tileentity instanceof TileEntityMobSpawner)
                    {
                        ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic().setEntityId(EntityList.getKey(EntityBlizzard.class));
                    }
                }
            }

            for (int i = 0; i <= 6; ++i)
            {
                for (int j = 0; j <= 6; ++j)
                {
                    this.replaceAirAndLiquidDownwards(worldIn, ModBlocks.FROSTED_NETHER_BRICK.getDefaultState(), i, -1, j, structureBoundingBoxIn);
                }
            }

            return true;
        }
    }
}