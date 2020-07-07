package com.RandomP3r5on.mining.init;

import com.RandomP3r5on.mining.Mining;
import com.RandomP3r5on.mining.objects.items.Coke;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Mining.MOD_ID);

    // Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().group(Mining.MiningItemGroup.instance)));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new Item(new Item.Properties().group(Mining.MiningItemGroup.instance)));
    public static final RegistryObject<Item> COKE = ITEMS.register("coke", () -> new Coke(new Item.Properties().group(Mining.MiningItemGroup.instance)));
    public static final RegistryObject<BucketItem> OIL_BUCKET = ITEMS.register("oil_bucket", () -> new BucketItem(() -> FluidInit.OIL_FLUID.get(), new Item.Properties().group(Mining.MiningItemGroup.instance)));

    // Ruby Tools
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new SwordItem(RubyItemTier.EXAMPLE, 5, 2.0F, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(RubyItemTier.EXAMPLE, 3, 2.0F, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<AxeItem> RUBY_AXES = ITEMS.register("ruby_axes", () -> new AxeItem(RubyItemTier.EXAMPLE, 4, 2.0F, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ShovelItem(RubyItemTier.EXAMPLE, 2, 2.0F, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new HoeItem(RubyItemTier.EXAMPLE,2.0F, new Item.Properties().group(Mining.CombatItemGroup.instance)));

    // Ruby Armour
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new ArmorItem(RubyArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new ArmorItem(RubyArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new ArmorItem(RubyArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new ArmorItem(RubyArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(Mining.CombatItemGroup.instance)));

    // Platinum Tools
    public static final RegistryObject<SwordItem> PLATINUM_SWORD = ITEMS.register("platinum_sword", () -> new SwordItem(PlatinumItemTier.EXAMPLE, 7, 2.0F, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<PickaxeItem> PLATINUM_PICKAXES = ITEMS.register("platinum_pickaxes", () -> new PickaxeItem(PlatinumItemTier.EXAMPLE, 5, 2.0F, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<AxeItem> PLATINUM_AXE = ITEMS.register("platinum_axe", () -> new AxeItem(PlatinumItemTier.EXAMPLE, 6, 2.0F, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<ShovelItem> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel", () -> new ShovelItem(PlatinumItemTier.EXAMPLE, 4, 2.0F, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<HoeItem> PLATINUM_HOE = ITEMS.register("platinum_hoe", () -> new HoeItem(PlatinumItemTier.EXAMPLE,2.0F, new Item.Properties().group(Mining.CombatItemGroup.instance)));

    // Platinum Armour
    public static final RegistryObject<ArmorItem> PLATINUM_HELMET = ITEMS.register("platinum_helmet", () -> new ArmorItem(RubyArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<ArmorItem> PLATINUM_CHESTPLATE = ITEMS.register("platinum_chestplate", () -> new ArmorItem(RubyArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<ArmorItem> PLATINUM_LEGGINGS = ITEMS.register("platinum_leggings", () -> new ArmorItem(RubyArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(Mining.CombatItemGroup.instance)));
    public static final RegistryObject<ArmorItem> PLATINUM_BOOTS = ITEMS.register("platinum_boots", () -> new ArmorItem(RubyArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(Mining.CombatItemGroup.instance)));



    public enum PlatinumItemTier implements IItemTier {
        EXAMPLE(5, 2500, 15, 4, 6, () -> {
            return Ingredient.fromItems(PLATINUM_INGOT.get());
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        private PlatinumItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }


    public enum RubyItemTier implements IItemTier {
    EXAMPLE(4, 2000, 12, 4, 8, () -> {
        return Ingredient.fromItems(RUBY.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private RubyItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
    public enum RubyArmorMaterial implements IArmorMaterial {
        RUBY(Mining.MOD_ID + ":ruby", 5, new int[] {4, 7, 9, 4}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
            return Ingredient.fromItems(ItemInit.RUBY.get());
        });

        private static final int[] MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11 };
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        private RubyArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactorIn;
            this.damageReductionAmountArray = damageReductionAmountIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
            }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness(){
            return this.toughness;
        }
    }

    public enum PlatinumArmorMaterial implements IArmorMaterial {
        RUBY(Mining.MOD_ID + ":platinum", 5, new int[] {5, 8, 10, 5}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
            return Ingredient.fromItems(ItemInit.PLATINUM_INGOT.get());
        });

        private static final int[] MAX_DAMAGE_ARRAY = new int[] {14, 16, 17, 12 };
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        private PlatinumArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactorIn;
            this.damageReductionAmountArray = damageReductionAmountIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness(){
            return this.toughness;
        }
    }
}

