package com.RandomP3r5on.mining.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Food;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class ConcreteStairs extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 12, 15.999999999999998, 16, 16),
            Block.makeCuboidShape(0, 0, 8, 15.999999999999998, 12, 11.999999999999998),
            Block.makeCuboidShape(0, 0, 4, 15.999999999999998, 8, 7.999999999999998),
            Block.makeCuboidShape(8.881784197001252e-15, 0, 0, 16.000000000000007, 4, 4)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1.7763568394002505e-15, 0, 0, 16, 16, 4),
            Block.makeCuboidShape(1.7763568394002505e-15, 0, 4, 16, 12, 7.999999999999998),
            Block.makeCuboidShape(1.7763568394002505e-15, 0, 8, 16, 8, 11.999999999999996),
            Block.makeCuboidShape(-7.105427357601002e-15, 0, 12, 15.999999999999993, 4, 15.999999999999998)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(12.100000000000009, 0, -0.10000000000000497, 16.10000000000001, 16, 15.899999999999991),
            Block.makeCuboidShape(8.100000000000007, 0, -0.10000000000000497, 12.100000000000005, 12, 15.899999999999991),
            Block.makeCuboidShape(4.1000000000000085, 0, -0.10000000000000497, 8.100000000000005, 8, 15.899999999999991),
            Block.makeCuboidShape(0.1000000000000103, 0, -0.10000000000001386, 4.1000000000000085, 4, 15.899999999999984)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 4, 16, 15.999999999999996),
            Block.makeCuboidShape(4, 0, 0, 7.999999999999998, 12, 15.999999999999996),
            Block.makeCuboidShape(8, 0, 0, 11.999999999999996, 8, 15.999999999999996),
            Block.makeCuboidShape(12, 0, 0, 15.999999999999998, 4, 15.999999999999996)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public ConcreteStairs(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;

            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
}
