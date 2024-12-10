package jeb.jjba.block.custom;

import com.google.common.collect.Lists;
import jeb.jjba.JebsJustBustedAdditions;
import jeb.jjba.block.ModBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RecoveryBeaconBlockEntity extends BlockEntity implements Nameable {
    private Text customName;
    private List<PlayerEntity> boundPlayers = Lists.newArrayList(); //TODO: save this with data components (codec moment)

    public RecoveryBeaconBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.RECOVERY_BEACON, pos, state);
    }

    public void bindPlayer(PlayerEntity player) {
        if(!this.boundPlayers.contains(player)){this.boundPlayers.add(player);}
    }

    public void unbindPlayer(PlayerEntity player) {this.boundPlayers.remove(player);}

    public List<PlayerEntity> getBoundPlayers() {return this.boundPlayers;}

    public static void tick(World world, BlockPos pos, BlockState state, RecoveryBeaconBlockEntity thisRecoveryBeacon) {
        if(world.getTime() % 60L == 0L) {
            for(PlayerEntity player : thisRecoveryBeacon.getBoundPlayers()) {
                JebsJustBustedAdditions.LOGGER.info("[Jeb's Just Busted Additions](Tick " + world.getTime() +") : Player " + player.getName() + " is bound to a recovery beacon");
            }
        }
    }

    @Override
    public Text getName() {
        return this.customName;
    }

    public void setCustomName(@Nullable Text customName) {
        this.customName = customName;
    }


}
