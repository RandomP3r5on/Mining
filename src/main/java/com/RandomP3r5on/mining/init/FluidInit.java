package com.RandomP3r5on.mining.init;

import com.RandomP3r5on.mining.Mining;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {

    public static final ResourceLocation OIL_STILL_RL = new ResourceLocation(Mining.MOD_ID, "blocks/oil_still");
    public static final ResourceLocation OIL_FLOWING_RL = new ResourceLocation(Mining.MOD_ID, "blocks/oil_flowing");
    public static final ResourceLocation OIL_OVERLAY_RL = new ResourceLocation(Mining.MOD_ID, "blocks/oil_overlay");

    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, Mining.MOD_ID);
    public static final RegistryObject<FlowingFluid> OIL_FLUID = FLUIDS.register("oil_fluid", () -> new ForgeFlowingFluid.Source(FluidInit.OIL_PROPERTIES));
    public static final RegistryObject<FlowingFluid> OIL_FLOWING = FLUIDS.register("oil_flowing", () -> new ForgeFlowingFluid.Flowing(FluidInit.OIL_PROPERTIES));

    public static final ForgeFlowingFluid.Properties OIL_PROPERTIES = new ForgeFlowingFluid.Properties(() -> OIL_FLUID.get(),() -> OIL_FLOWING.get(), FluidAttributes
            .builder(OIL_STILL_RL, OIL_FLOWING_RL).density(5).sound(SoundEvents.BLOCK_LAVA_POP).overlay(OIL_OVERLAY_RL)).block(() -> FluidInit.OIL_BLOCK.get())
            .bucket(() -> ItemInit.OIL_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> OIL_BLOCK = BlockInit.BLOCKS.register("oil", () -> new FlowingFluidBlock(() -> FluidInit.OIL_FLUID.get(),
            Block.Properties.create(Material.LAVA).doesNotBlockMovement().doesNotBlockMovement().hardnessAndResistance(100F).noDrops()));
}
