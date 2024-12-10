package jeb.jjba.item;

import jeb.jjba.JebsJustBustedAdditions;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    private static Item registerItem(String id, Item item) {
        Identifier itemID = Identifier.of(JebsJustBustedAdditions.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

//    public static final Item RECOVERY_BEACON_ITEM = registerItem("recovery_beacon", new Item(new Item.Settings()
//            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JebsJustBustedAdditions.MOD_ID, "recovery_beacon")))));
//    public static final Item TEST_ITEM_TWO = registerItem("test_item_two", new Item(new Item.Settings()
//            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JebsJustBustedAdditions.MOD_ID, "test_item_two")))));

    public static void initialize() {
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> {
//            itemGroup.add(ModItems.TEST_ITEM_TWO);
//        });
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> {
//                itemGroup.add(ModItems.RECOVERY_BEACON_ITEM);
//        });

        JebsJustBustedAdditions.LOGGER.info("[Jeb's Just Busted Additions] : Initialized items!");
    }
}
