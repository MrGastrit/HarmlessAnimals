package org.stereometric.harmlessanimals.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.stereometric.harmlessanimals.HarmlessAnimals;

public class ModItemsGroups {

    public static final ItemGroup HARMLESS_ANIMALS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(HarmlessAnimals.MOD_ID, "harmlessanimals_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PEARL))
                    .displayName(Text.translatable("itemgroup.harmlessanimals.harmlessanimals_items"))
                    .entries(((displayContext, entries) -> {
                        entries.add(new ItemStack(ModItems.PEARL));
                        entries.add(new ItemStack(ModItems.CRAB_MEAT));
                    }))
                    .build());

    public static void registerItemGroups() {
        HarmlessAnimals.LOGGER.info("Registering ItemGroups for" + HarmlessAnimals.MOD_ID);
    }
}
