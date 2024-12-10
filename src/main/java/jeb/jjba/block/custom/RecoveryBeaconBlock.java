package jeb.jjba.block.custom;

import com.mojang.serialization.MapCodec;
import jeb.jjba.block.ModBlockEntityTypes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RecoveryBeaconBlock extends BlockWithEntity {
    public RecoveryBeaconBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {return null;}

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new RecoveryBeaconBlockEntity(pos, state);}

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntityTypes.RECOVERY_BEACON, RecoveryBeaconBlockEntity::tick);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity blockEntityHere = world.getBlockEntity(pos);
            if (blockEntityHere instanceof RecoveryBeaconBlockEntity) {
                ItemStack playerHeldItemStack = player.getStackInHand(player.getActiveHand());
                if(playerHeldItemStack.getItem() == Items.ENDER_EYE) {
                    RecoveryBeaconBlockEntity thisRecoveryBeacon = (RecoveryBeaconBlockEntity) blockEntityHere;
                    playerHeldItemStack.decrementUnlessCreative(1, player);
                    thisRecoveryBeacon.bindPlayer(player);
                }
            }
        }

        return ActionResult.SUCCESS;
    }
}
