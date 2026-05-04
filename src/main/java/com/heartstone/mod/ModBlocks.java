package com.heartstone.mod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final RegistryKey<Block> WORLDHEART_ORE_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(HeartstoneMod.MOD_ID, "worldheart_ore"));

    public static final Block WORLDHEART_ORE = registerBlock("worldheart_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(3, 7),
            AbstractBlock.Settings.create()
                .registryKey(WORLDHEART_ORE_KEY)
                .strength(50.0f, 1200.0f) // Setara Obsidian!
                .requiresTool() // Wajib pakai alat
                .sounds(BlockSoundGroup.STONE)
        )
    );

    private static Block registerBlock(String name, Block block) {
        Registry.register(Registries.BLOCK, Identifier.of(HeartstoneMod.MOD_ID, name), block);
        
        // Mendaftarkan BlockItem dan memberinya warna EPIC (Ungu)
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HeartstoneMod.MOD_ID, name));
        Item blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).rarity(Rarity.EPIC));
        Registry.register(Registries.ITEM, Identifier.of(HeartstoneMod.MOD_ID, name), blockItem);
        
        return block;
    }

    public static void registerModBlocks() {
        HeartstoneMod.LOGGER.info("Registering Mod Blocks for " + HeartstoneMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(WORLDHEART_ORE);
        });
    }
}