package com.RandomP3r5on.mining;

import com.RandomP3r5on.mining.init.BlockInit;
import com.RandomP3r5on.mining.init.FluidInit;
import com.RandomP3r5on.mining.init.ItemInit;
import com.RandomP3r5on.mining.world.gen.PlatinumOreGen;
import com.RandomP3r5on.mining.world.gen.RubyOreGen;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mining")
@Mod.EventBusSubscriber(modid = Mining.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Mining {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mining";
    public static Mining instance;

    public Mining() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        instance = this;

        MinecraftForge.EVENT_BUS.register(this);

        ItemInit.ITEMS.register(modEventBus);
        FluidInit.FLUIDS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInit.BLOCKS.getEntries().stream().filter(block -> !(block.get() instanceof FlowingFluidBlock)).map(RegistryObject::get).forEach(block -> {
            Item.Properties properties;
            if (block == BlockInit.PLATINUM_BLOCK.get() || block == BlockInit.PLATINUM_ORE.get() || block == BlockInit.RUBY_BLOCK.get() || block == BlockInit.RUBY_ORE.get() ) {
                properties = new Item.Properties().group(MiningItemGroup.instance);
            } else {
                properties = new Item.Properties().group(BlocksItemGroup.instance);
            }
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
        RubyOreGen.generateOre();
        PlatinumOreGen.generateOre();
    }

    public static class MiningItemGroup extends ItemGroup {
        public static final MiningItemGroup instance = new MiningItemGroup(ItemGroup.GROUPS.length, "miningtab");

        private MiningItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.RUBY.get());
        }
    }

        public static class CombatItemGroup extends ItemGroup {
            public static final CombatItemGroup instance = new CombatItemGroup(ItemGroup.GROUPS.length, "combattab");

            private CombatItemGroup(int index, String label) {
                super(index, label);
            }

            @Override
            public ItemStack createIcon() {
                return new ItemStack(ItemInit.RUBY_PICKAXE.get());
            }
        }

    public static class BlocksItemGroup extends ItemGroup {
        public static final BlocksItemGroup instance = new BlocksItemGroup(ItemGroup.GROUPS.length, "blockstab");

        private BlocksItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.CONCRETE_STAIRS.get());
        }
    }

}
