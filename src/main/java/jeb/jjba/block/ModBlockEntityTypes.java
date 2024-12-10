package jeb.jjba.block;

import jeb.jjba.JebsJustBustedAdditions;
import jeb.jjba.block.ModBlocks;
import jeb.jjba.block.custom.RecoveryBeaconBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntityTypes {
    public static <T extends BlockEntityType<?>> T register(String id, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(JebsJustBustedAdditions.MOD_ID, id), blockEntityType);
    }

    public static final BlockEntityType<RecoveryBeaconBlockEntity> RECOVERY_BEACON = register(
            "recovery_beacon", FabricBlockEntityTypeBuilder.create(RecoveryBeaconBlockEntity::new, ModBlocks.RECOVERY_BEACON).build()
    );

    public static void initialize() {
        JebsJustBustedAdditions.LOGGER.info("[Jeb's Just Busted Additions] : Initialized block entity types!");
    }
}
