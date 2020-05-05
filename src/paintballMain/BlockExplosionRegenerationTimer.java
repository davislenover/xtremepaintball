package paintballMain;

import org.bukkit.block.BlockState;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockExplosionRegenerationTimer extends BukkitRunnable {
	
	BlockState state = null;
	
	public BlockExplosionRegenerationTimer(BlockState state) {
		this.state = state;
	}
	
	
	@Override
	public void run() {
		state.update(true, false);
	}

}
