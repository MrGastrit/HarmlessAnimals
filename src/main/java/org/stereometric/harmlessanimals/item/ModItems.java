package org.stereometric.harmlessanimals.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.stereometric.harmlessanimals.HarmlessAnimals;

import java.util.function.Function;

public class ModItems {
    public static final Item PEARL = register("pearl", Item::new, new Item.Settings());
    public static final Item CRAB_MEAT = register("crab_meat", Item::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HarmlessAnimals.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerItems() {
        HarmlessAnimals.LOGGER.info("Registering Items for " + HarmlessAnimals.MOD_ID);
    }
}
