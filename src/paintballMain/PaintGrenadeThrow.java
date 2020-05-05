package paintballMain;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Result;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;

public class PaintGrenadeThrow implements Listener {
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		if (event.getItem().getType() == null) {
			return;
		}
		if ((event.getItem().getType() != Material.TNT)) {
			event.setUseInteractedBlock(Result.ALLOW);
			event.setUseItemInHand(Result.ALLOW);
			return;
		}
		long currentTime = System.currentTimeMillis();
		//Get the player that executed the event
		Player player = event.getPlayer();
		UUID uuidOfPlayer = player.getUniqueId();
		//Get the item clicked on
		ItemStack clicked = event.getItem();
		//Get that items internal data
		ItemMeta clickedItem = clicked.getItemMeta();
		if (clickedItem.hasCustomModelData()) {
			//Set the model data
			int modelData = clickedItem.getCustomModelData();
			//blue tnt
			if (modelData == 4) {
				
				//Get the current amount of the grenade in the players inventory and remove 1
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				
				//Spawn TNT
                Entity tnt = player.getWorld().spawn(player.getLocation().add(0, player.getEyeHeight(), 0), TNTPrimed.class);
                
                tnt.setMetadata("paintgrenadeblue", new FixedMetadataValue(XtremePaintball.plugin, "X"));
               
                //Sets it to detonate after 40 ticks (2 seconds)
                ((TNTPrimed)tnt).setFuseTicks(40);
                
                //Set and scale up its velocity so it will move 1.2 times faster
                tnt.setVelocity(player.getLocation().getDirection().multiply(1.2));
                
                //Create task for particle effects
                BukkitTask spawnParticles = new PrimedGrenadeParticles(tnt, "blue").runTaskTimer(XtremePaintball.plugin, 0L, 0L);
                BukkitTask spawnFireworkParticles = new FireworkTntSpawn(tnt,"blue").runTaskTimer(XtremePaintball.plugin, 0L, 5L);
                BukkitTask spawnTicks = new PrimedTntTick(tnt).runTaskTimer(XtremePaintball.plugin, 0L, 10L);
                
			} else if (modelData == 5) {
				//Get the current amount of the grenade in the players inventory and remove 1
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				
				//Spawn TNT
                Entity tnt = player.getWorld().spawn(player.getLocation().add(0, player.getEyeHeight(), 0), TNTPrimed.class);
                
                tnt.setMetadata("paintgrenadered", new FixedMetadataValue(XtremePaintball.plugin, "X"));
               
                //Sets it to detonate after 40 ticks (2 seconds)
                ((TNTPrimed)tnt).setFuseTicks(40);
                
                //Set and scale up its velocity so it will move 1.2 times faster
                tnt.setVelocity(player.getLocation().getDirection().multiply(1.2));
                
                //Create task for particle effects
                BukkitTask spawnParticles = new PrimedGrenadeParticles(tnt, "red").runTaskTimer(XtremePaintball.plugin, 0L, 0L);
                BukkitTask spawnFireworkParticles = new FireworkTntSpawn(tnt,"red").runTaskTimer(XtremePaintball.plugin, 0L, 5L);
                BukkitTask spawnTicks = new PrimedTntTick(tnt).runTaskTimer(XtremePaintball.plugin, 0L, 10L);
			}
		}
	}
}
