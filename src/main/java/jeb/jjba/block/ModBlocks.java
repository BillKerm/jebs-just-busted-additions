package jeb.jjba.block;

import jeb.jjba.JebsJustBustedAdditions;
import jeb.jjba.block.custom.RecoveryBeaconBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    private static Block registerBlock(String id, Block block, boolean shouldRegisterCompanionItem){
        if(shouldRegisterCompanionItem){registerBlockItem(id, block);}
        return Registry.register(Registries.BLOCK, Identifier.of(JebsJustBustedAdditions.MOD_ID, id), block);
    }
    private static void registerBlockItem(String id, Block block){
        Registry.register(Registries.ITEM, Identifier.of(JebsJustBustedAdditions.MOD_ID, id),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JebsJustBustedAdditions.MOD_ID, id)))));
    }


    public static final Block RECOVERY_BEACON = registerBlock("recovery_beacon",
            new RecoveryBeaconBlock(AbstractBlock.Settings.create().strength(3f, 20f).requiresTool().sounds(BlockSoundGroup.CALCITE)
                    .jumpVelocityMultiplier(3f).luminance((state) -> {return 15;})
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(JebsJustBustedAdditions.MOD_ID, "recovery_beacon")))),
            true);


    public static void initialize(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(RECOVERY_BEACON);
        });
        JebsJustBustedAdditions.LOGGER.info("[Jeb's Just Busted Additions] : Initialized blocks!");
    }
}
