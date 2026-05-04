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

    // KTP Item
    public static final RegistryKey<Item> FALLEN_SOUL_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HeartstoneMod.MOD_ID, "fallen_soul"));
    public static final RegistryKey<Item> WORLDHEART_GEM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HeartstoneMod.MOD_ID, "worldheart_gem"));
    public static final RegistryKey<Item> DOMINION_CORE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HeartstoneMod.MOD_ID, "dominion_core"));

    // Fallen Soul (Sebelumnya Heartstone)
    public static final Item FALLEN_SOUL = registerItem("fallen_soul",
        new Item(new Item.Settings().registryKey(FALLEN_SOUL_KEY).rarity(Rarity.EPIC)
            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                Text.translatable("item.heartstone.fallen_soul.tooltip.1").formatted(Formatting.GRAY),
                Text.translatable("item.heartstone.fallen_soul.tooltip.2").formatted(Formatting.GRAY)
            )))
        )
    );

    // Worldheart Gem
    public static final Item WORLDHEART_GEM = registerItem("worldheart_gem",
        new Item(new Item.Settings().registryKey(WORLDHEART_GEM_KEY).rarity(Rarity.EPIC)
            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                Text.translatable("item.heartstone.worldheart_gem.tooltip.1").formatted(Formatting.GRAY),
                Text.translatable("item.heartstone.worldheart_gem.tooltip.2").formatted(Formatting.GRAY)
            )))
        )
    );

    // Dominion Core (Sebelumnya Core of Dominion)
    public static final Item DOMINION_CORE = registerItem("dominion_core",
        new Item(new Item.Settings().registryKey(DOMINION_CORE_KEY).rarity(Rarity.EPIC)
            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                Text.translatable("item.heartstone.dominion_core.tooltip.1").formatted(Formatting.GRAY),
                Text.translatable("item.heartstone.dominion_core.tooltip.2").formatted(Formatting.GRAY)
            )))
        )
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(HeartstoneMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        HeartstoneMod.LOGGER.info("Registering Mod Items for " + HeartstoneMod.MOD_ID);
        
        // Menambahkan ketiga item ke Creative Tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(FALLEN_SOUL);
            entries.add(WORLDHEART_GEM);
            entries.add(DOMINION_CORE);
        });
    }
}