package paintballMain;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.scheduler.BukkitRunnable;

public class FallingBlockDeletion extends BukkitRunnable{
	
	Block block = null;
	
	public FallingBlockDeletion(Block currentblock){
		this.block = currentblock;
	}
	
	@Override
	public void run() {
		block.removeMetadata("fallingblock", XtremePaintball.plugin);
		block.setType(Material.AIR);
	}

}
