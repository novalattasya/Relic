package com.heartstone.mod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class ModItems {

    // 1. Registry Item
    public static final RegistryKey<Item> HEARTSTONE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HeartstoneMod.MOD_ID, "heartstone"));

    // 2. Registrasi Item dengan Data Component untuk Lore (Standar baru MC 1.21+)
    public static final Item HEARTSTONE = registerItem("heartstone",
        new Item(new Item.Settings()
            .registryKey(HEARTSTONE_KEY)
            .rarity(Rarity.EPIC)
            // Menambahkan deskripsi langsung sebagai komponen item!
            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                Text.translatable("item.heartstone.heartstone.tooltip").formatted(Formatting.GRAY)
            )))
        )
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(HeartstoneMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        HeartstoneMod.LOGGER.info("Registering Mod Items for " + HeartstoneMod.MOD_ID);

        // Menambahkan ke Creative Tab (Functional)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(HEARTSTONE);
        });
    }
}