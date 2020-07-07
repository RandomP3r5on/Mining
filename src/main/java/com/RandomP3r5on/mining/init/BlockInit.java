package com.RandomP3r5on.mining.init;

import com.RandomP3r5on.mining.Mining;
import com.RandomP3r5on.mining.objects.blocks.ConcreteStairs;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Mining.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(Block.Properties.create(Material.IRON)
            .hardnessAndResistance(5, 30).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new Block(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(3, 15).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(4)));

    public static final RegistryObject<Block> PLATINUM_BLOCK = BLOCKS.register("platinum_block", () -> new Block(Block.Properties.create(Material.IRON)
            .hardnessAndResistance(5, 30).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    public static final RegistryObject<Block> PLATINUM_ORE = BLOCKS.register("platinum_ore", () -> new Block(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(3, 15).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(4)));

    public static final RegistryObject<Block> CONCRETE_STAIRS = BLOCKS.register("concrete_stairs", () -> new ConcreteStairs(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(1.8F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));

    public static final RegistryObject<Block> WASTELAND_GRASS = BLOCKS.register("wasteland_grass", () -> new Block(Block.Properties.create(Material.ORGANIC)
            .hardnessAndResistance(0.6F).sound(SoundType.PLANT).harvestTool(ToolType.SHOVEL).harvestLevel(0)));
}
