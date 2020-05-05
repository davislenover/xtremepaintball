package paintballMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class BlockExplosionRegeneration implements Listener {
	
	
	@EventHandler
	public void onExplode(EntityExplodeEvent event) {
		if ((event.getEntity().hasMetadata("paintgrenadeblue")) || (event.getEntity().hasMetadata("paintgrenadered"))) {
			List<BlockState> regenList = event.blockList().stream().map(Block::getState).collect(Collectors.toList());
			for (Block falling : event.blockList() ) {
				if (falling.hasMetadata("fallingblock")) {
					BlockState state = falling.getState();
					regenList.remove(state);
				}
			}
			
			int delay = 20;
			
			int AmountOfBlocks = 0;
			
			for (Block block : event.blockList()) {
				int randomSplatter = 1;
				randomSplatter = (int) (randomSplatter+(Math.random()*(5-1))+1);
				if (randomSplatter == 3) {
					if (event.getEntity().hasMetadata("paintgrenadeblue")) {
						block.setType(Material.BLUE_CONCRETE);
					} else if (event.getEntity().hasMetadata("paintgrenadered")) {
						block.setType(Material.RED_CONCRETE);
					}
				}
				float x = (float) -0.3 + (float) (Math.random() * ((0.5 - (-0.5) - 0.5)));
				float y = (float) 0.4 + (float) (Math.random() * ((0.3 - 0.4) + 1));
				float z = (float) -0.3 + (float) (Math.random() * ((0.5 - (-0.5) - 0.5)));
				
				FallingBlock fallingBlock = block.getWorld().spawnFallingBlock(block.getLocation(), block.getBlockData());
				fallingBlock.setDropItem(false);
				fallingBlock.setVelocity(new Vector(x,y,z));
				fallingBlock.setCustomName("PaintGrenadeBlock");
				block.setType(Material.AIR);
				AmountOfBlocks++;
			}
			

			for (BlockState state : regenList) {
				
				if (!(state.getBlock().hasMetadata("fallingblock"))) {
					delay = 200;
					
					if (!(state.getType() == Material.GLASS_PANE)) {
						delay = (int) (delay+(Math.random()*(500-200))+200);
						
						if ((state.getType() == Material.SAND) || (state.getType()== Material.GRAVEL)){
							delay += 1;
						}
						
						BukkitTask delayRegen = new BlockExplosionRegenerationTimer(state).runTaskLater(XtremePaintball.plugin, delay);
					}
				}
		
			}
			
			for (BlockState glassState : regenList) {
				
				if (!(glassState.getBlock().hasMetadata("fallingblock"))) {
					delay = 1;
					
					if ((glassState.getType() == Material.GLASS_PANE)) {
						delay = (int) (delay+(Math.random()*(5-1))+1);
						BukkitTask delayRegen = new BlockExplosionRegenerationTimer(glassState).runTaskLater(XtremePaintball.plugin, delay);
					}
				}
			}
		}
		
	}
	@EventHandler
	public void onEntityChangeBlock(final EntityChangeBlockEvent event) {
		if (event.getEntity() instanceof FallingBlock) {
			if (event.getEntity().getCustomName().equalsIgnoreCase("PaintGrenadeBlock")) {
				Block block = event.getBlock();
				block.setMetadata("fallingblock", new FixedMetadataValue(XtremePaintball.plugin, "test"));
				int delay = 100;
				delay = (int) (delay+(Math.random()*(180-100))+100);
				BukkitTask delayremoval = new FallingBlockDeletion(block).runTaskLater(XtremePaintball.plugin, delay);

			}
		}
	}
}
