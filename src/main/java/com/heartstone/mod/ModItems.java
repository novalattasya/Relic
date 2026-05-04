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

    public static final RegistryKey<Item> HEARTSTONE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HeartstoneMod.MOD_ID, "heartstone"));
    public static final RegistryKey<Item> WORLDHEART_GEM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HeartstoneMod.MOD_ID, "worldheart_gem"));

    // Heartstone (EPIC, Lore dipisah 2 baris)
    public static final Item HEARTSTONE = registerItem("heartstone",
        new Item(new Item.Settings().registryKey(HEARTSTONE_KEY).rarity(Rarity.EPIC)
            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                Text.translatable("item.heartstone.heartstone.tooltip.1").formatted(Formatting.GRAY),
                Text.translatable("item.heartstone.heartstone.tooltip.2").formatted(Formatting.GRAY)
            )))
        )
    );

    // Worldheart Gem (EPIC, Lore dipisah 2 baris)
    public static final Item WORLDHEART_GEM = registerItem("worldheart_gem",
        new Item(new Item.Settings().registryKey(WORLDHEART_GEM_KEY).rarity(Rarity.EPIC)
            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                Text.translatable("item.heartstone.worldheart_gem.tooltip.1").formatted(Formatting.GRAY),
                Text.translatable("item.heartstone.worldheart_gem.tooltip.2").formatted(Formatting.GRAY)
            )))
        )
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(HeartstoneMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        HeartstoneMod.LOGGER.info("Registering Mod Items for " + HeartstoneMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(HEARTSTONE);
            entries.add(WORLDHEART_GEM);
        });
    }
}