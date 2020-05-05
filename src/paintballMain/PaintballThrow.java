package paintballMain;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

//This class will be fired if a command is executed by a player
public class PaintballThrow implements Listener {
	
	public void shootPaintball(Player player, int gunType, UUID uuidOfPlayer) {
		double playerSpeed = -1;
		double accuracyMax = 0;
		double accuracyMin = 0;
		boolean isPlayerJumping = false;
		if ((GetPlayerSpeed.playerSpeedList.containsKey(uuidOfPlayer))){
			playerSpeed = GetPlayerSpeed.playerSpeedList.get(uuidOfPlayer);
		} else if (!(GetPlayerSpeed.playerSpeedList.containsKey(uuidOfPlayer))) {
			playerSpeed = -1;
		}
		if ((GetPlayerSpeed.playerJumpList.containsKey(uuidOfPlayer))) {
			isPlayerJumping = true;
		}
		
		if (isPlayerJumping) {
			playerSpeed = playerSpeed*2;
		}

		if (gunType == 1) {
			if (playerSpeed != -1 && (playerSpeed < -1 || playerSpeed > -1)) {
				accuracyMax = (playerSpeed*2.8);
				accuracyMin = (-(playerSpeed*2.8));
			} else if (playerSpeed == -1) {
				accuracyMax = 0;
				accuracyMin = 0;
			}
			//Spawn a ender pearl (representing a paintball) (entity) at the players location 
			Entity paintball1 = player.getWorld().spawn(player.getLocation().add(0,player.getEyeHeight(),0), EnderPearl.class);
			//Give it a custom name to check upon impact (both if it is a blue paintball and which player threw it)
			paintball1.setCustomName("BluePA" + player.getUniqueId());
			Vector paintballVel = player.getEyeLocation().getDirection().add(new Vector((Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin)),(Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin)), (Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin))));
			paintballVel.normalize();
			paintballVel.multiply(1.5);
			//Set the velocity of the paintball given the players location and direction
			paintball1.setVelocity(paintballVel);
		} else if (gunType == 2) {
			if (playerSpeed != -1 && (playerSpeed < -1 || playerSpeed > -1)) {
				accuracyMax = (playerSpeed*2.8);
				accuracyMin = (-(playerSpeed*2.8));
			} else if (playerSpeed == -1) {
				accuracyMax = 0;
				accuracyMin = 0;
			}
			Entity paintball1 = player.getWorld().spawn(player.getLocation().add(0,player.getEyeHeight(),0), EnderPearl.class);
			Entity paintball2 = player.getWorld().spawn(player.getLocation().add(0,player.getEyeHeight(),0), EnderPearl.class);
			Entity paintball3 = player.getWorld().spawn(player.getLocation().add(0,player.getEyeHeight(),0), EnderPearl.class);
			Entity paintball4 = player.getWorld().spawn(player.getLocation().add(0,player.getEyeHeight(),0), EnderPearl.class);
			Entity paintball5 = player.getWorld().spawn(player.getLocation().add(0,player.getEyeHeight(),0), EnderPearl.class);
			paintball1.setCustomName("BluePS" + player.getUniqueId());
			paintball2.setCustomName("BluePS" + player.getUniqueId());
			paintball3.setCustomName("BluePS" + player.getUniqueId());
			paintball4.setCustomName("BluePS" + player.getUniqueId());
			paintball5.setCustomName("BluePS" + player.getUniqueId());
			Vector paintballVel1 = player.getEyeLocation().getDirection().add(new Vector((Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin)),(Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin)), (Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin))));
			paintballVel1.normalize();
			paintballVel1.multiply(1.2);
			paintball1.setVelocity(paintballVel1);
			Vector paintballVel2 = player.getEyeLocation().getDirection().add(new Vector((Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin)),(Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin)), (Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin))));
			paintballVel2.normalize();
			paintballVel2.multiply(1.2);
			paintball2.setVelocity(paintballVel2);
			paintball3.setVelocity((player.getLocation().getDirection()));
			Vector paintballVel4 = player.getEyeLocation().getDirection().add(new Vector((Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin)),(Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin)), (Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin))));
			paintballVel4.normalize();
			paintballVel4.multiply(1.2);
			paintball4.setVelocity(paintballVel4);
			Vector paintballVel5 = player.getEyeLocation().getDirection().add(new Vector((Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin)),(Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin)), (Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin))));
			paintballVel5.normalize();
			paintballVel5.multiply(1.2);
			paintball5.setVelocity(paintballVel5);
			
		} else if (gunType == 3) {
			if (playerSpeed != -1) {
				accuracyMax = (playerSpeed*2.8);
				accuracyMin = -(playerSpeed*2.8);
			} else if (playerSpeed == -1) {
				accuracyMax = 0;
				accuracyMin = 0;
			}
			Entity paintball1 = player.getWorld().spawn(player.getLocation().add(0,player.getEyeHeight(),0), EnderPearl.class);
			paintball1.setCustomName("BluePR" + player.getUniqueId());
			Vector paintballVel = player.getEyeLocation().getDirection().add(new Vector((Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin)),(Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin)), (Math.random() * (accuracyMax-(accuracyMin)) + (accuracyMin))));
			paintballVel.normalize();
			paintballVel.multiply(5);
			paintball1.setVelocity(paintballVel);
			
		}
	}
	
	@EventHandler
	//This method will fire if the player "right clicks" on an item
	public void onPlayerUse(PlayerInteractEvent event) {
		if(event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			if (event.getItem().getType() == null) {
				return;
			}
			if ((event.getItem().getType() != Material.IRON_HORSE_ARMOR)) {
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
			//Check if the item clicked has a custom tag (to determine if it is a paintball and which team, 1 = blue)
			if (clickedItem.hasCustomModelData()) {
				//Set the model data
				int modelData = clickedItem.getCustomModelData();
				//Check the type
				if (modelData == 1) {
					//Check if the player has a shot cool down (also check to make sure they have an ammo value stored)
					if (((AmmoCounter.playerAmmoList.containsKey(uuidOfPlayer)) && (ItemShotTimer.playerGunShotTimerList.containsKey(uuidOfPlayer)))) {
						//Get the system time when the last shot was made
						long delayTimer = ItemShotTimer.playerGunShotTimerList.get(uuidOfPlayer);
						//Subtract both to get the difference
						//If the difference has reached a certain threshold... (190 milliseconds)
						if ((currentTime - delayTimer)> 190) {
							//Allow the player to continue to fire (by removing them from the hash)
							ItemShotTimer.playerGunShotTimerList.remove(uuidOfPlayer);
						//If they still haven't reached 190 milliseconds in difference, then tell the player that they cannot fire
						} else if (!((currentTime - delayTimer)> 190)) {
							player.sendMessage("You are shooting too fast!");
						}
					}
					
					//Check if the player does not have a timer on them nor currently have any ammo
					if ((!ItemReloadTimer.playerTimerList.containsKey(uuidOfPlayer)) && (!AmmoCounter.playerAmmoList.containsKey(uuidOfPlayer)) ) {
						//Give the player ammo send both the identity of the player and the current gun used
						AmmoCounter.addAmmo(uuidOfPlayer, modelData);
						shootPaintball(player, modelData, uuidOfPlayer);
						AmmoCounter.subtractAmmo(uuidOfPlayer, 1);
						ItemShotTimer.shotCooldown(uuidOfPlayer);
					}
					//Check if the player has an ammo value stored and if they are not on a cool-down
					if ((AmmoCounter.playerAmmoList.containsKey(uuidOfPlayer)) && !(ItemShotTimer.playerGunShotTimerList.containsKey(uuidOfPlayer))) {
						//If they do, get the current ammo count
						int currentAmmo = AmmoCounter.playerAmmoList.get(uuidOfPlayer);
						//Check if their ammo is not equal to 0 (no ammo left)
						if (currentAmmo != 0) {
							//Call method to shoot a paintball, pass player and the gun type
							shootPaintball(player, modelData, uuidOfPlayer);
							//Subtract 1 from their current ammo
							AmmoCounter.subtractAmmo(uuidOfPlayer, 1);
							//Add player to shot cool-down
							ItemShotTimer.shotCooldown(uuidOfPlayer);
							currentAmmo = AmmoCounter.playerAmmoList.get(uuidOfPlayer);
						//Check if the player has no ammo and that they are not entered into the hash to reload
						} 
						if ((currentAmmo == 0) && !(ItemReloadTimer.playerTimerList.containsKey(uuidOfPlayer))) {
							//Enter the player into the hash
							ItemReloadTimer.timerSet(uuidOfPlayer);
							BukkitTask setXpToReload = new PlayerReloadTimer(uuidOfPlayer, 1).runTaskTimerAsynchronously(XtremePaintball.plugin, 0L, 1L);
						}
					} 
					
					//If the player has attempted to use their item while reloading call this statement
					if (ItemReloadTimer.playerTimerList.containsKey(uuidOfPlayer)) {
						//Get the server time at which the player shot their last paintball
						long delayTimer = ItemReloadTimer.playerTimerList.get(uuidOfPlayer);
						//Subtract both of them			
						//If the difference is greater than 3 seconds, then the player has reloaded
						if ((currentTime - delayTimer) > 1000) {
							//Give the player more ammo
							AmmoCounter.addAmmo(uuidOfPlayer, modelData);
							shootPaintball(player, modelData, uuidOfPlayer);
							AmmoCounter.subtractAmmo(uuidOfPlayer, 1);
							ItemShotTimer.shotCooldown(uuidOfPlayer);
							//Remove them from the reload timer
							ItemReloadTimer.playerTimerList.remove(uuidOfPlayer);
						} else if (!((currentTime - delayTimer) > 1000)){
						}
					
					} 
				
				//Check if shotgun was fired
				} else if (modelData == 2) {
					//Check if the player has a shot cool down (also check to make sure they have an ammo value stored)
					if (((AmmoCounter.playerAmmoList.containsKey(uuidOfPlayer)) && (ItemShotTimer.playerGunShotTimerList.containsKey(uuidOfPlayer)))) {
						//Get the system time when the last shot was made
						long delayTimer = ItemShotTimer.playerGunShotTimerList.get(uuidOfPlayer);
						//Subtract both to get the difference
						//If the difference has reached a certain threshold... (700 milliseconds)
						if ((currentTime - delayTimer)> 400) {
							//Allow the player to continue to fire (by removing them from the hash)
							ItemShotTimer.playerGunShotTimerList.remove(uuidOfPlayer);
						//If they still haven't reached 700 milliseconds in difference, then tell the player that they cannot fire
						} else if (!((currentTime - delayTimer)> 400)) {
							player.sendMessage("You are shooting too fast!");
						}
					}
					
					//Check if the player does not have a timer on them nor currently have any ammo
					if ((!ItemReloadTimer.playerTimerList.containsKey(uuidOfPlayer)) && (!AmmoCounter.playerAmmoList.containsKey(uuidOfPlayer)) ) {
						//Give the player ammo
						AmmoCounter.addAmmo(uuidOfPlayer, modelData);
						shootPaintball(player, modelData, uuidOfPlayer);
						AmmoCounter.subtractAmmo(uuidOfPlayer, 2);
						ItemShotTimer.shotCooldown(uuidOfPlayer);
					}
					//Check if the player has an ammo value stored and if they are not on a cool-down
					if ((AmmoCounter.playerAmmoList.containsKey(uuidOfPlayer)) && !(ItemShotTimer.playerGunShotTimerList.containsKey(uuidOfPlayer))) {
						//If they do, get the current ammo count
						int currentAmmo = AmmoCounter.playerAmmoList.get(uuidOfPlayer);
						//Check if their ammo is not equal to 0 (no ammo left)
						if (currentAmmo != 0) {
							//Call method to shoot the paintball
							shootPaintball(player, modelData, uuidOfPlayer);
							//Subtract 1 from their current ammo
							AmmoCounter.subtractAmmo(uuidOfPlayer, 2);
							//Add player to shot cool-down
							ItemShotTimer.shotCooldown(uuidOfPlayer);
							currentAmmo = AmmoCounter.playerAmmoList.get(uuidOfPlayer);
							
						//Check if the player has no ammo and that they are not entered into the hash to reload
						} 
						if ((currentAmmo == 0) && !(ItemReloadTimer.playerTimerList.containsKey(uuidOfPlayer))) {
							//Enter the player into the hash
							ItemReloadTimer.timerSet(uuidOfPlayer);
							BukkitTask setXpToReload2 = new PlayerReloadTimer(uuidOfPlayer, 2).runTaskTimerAsynchronously(XtremePaintball.plugin, 0L, 2L);
						}
					} 
					
					//If the player has attempted to use their item while reloading call this statement
					if (ItemReloadTimer.playerTimerList.containsKey(uuidOfPlayer)) {
						//Get the server time at which the player shot their last paintball
						long delayTimer = ItemReloadTimer.playerTimerList.get(uuidOfPlayer);
						//Subtract both of them			
						//If the difference is greater than 2 seconds, then the player has reloaded
						if ((currentTime - delayTimer) > 2000) {
							//Give the player more ammo
							AmmoCounter.addAmmo(uuidOfPlayer, modelData);
							shootPaintball(player, modelData, uuidOfPlayer);
							AmmoCounter.subtractAmmo(uuidOfPlayer, 2);
							ItemShotTimer.shotCooldown(uuidOfPlayer);
							//Remove them from the reload timer
							ItemReloadTimer.playerTimerList.remove(uuidOfPlayer);
						//If the difference is not greater than 2 seconds, then the player has not reloaded
						} else if (!((currentTime - delayTimer) > 2000)){
							//Tell player that they have not reloaded yet!
						}
					
					}
				} else if (modelData == 3) {
					//Check if the player has a shot cool down (also check to make sure they have an ammo value stored)
					if (((AmmoCounter.playerAmmoList.containsKey(uuidOfPlayer)) && (ItemShotTimer.playerGunShotTimerList.containsKey(uuidOfPlayer)))) {
						//Get the system time when the last shot was made
						long delayTimer = ItemShotTimer.playerGunShotTimerList.get(uuidOfPlayer);
						//Subtract both to get the difference
						//If the difference has reached a certain threshold... (700 milliseconds)
						if ((currentTime - delayTimer)> 1000) {
							//Allow the player to continue to fire (by removing them from the hash)
							ItemShotTimer.playerGunShotTimerList.remove(uuidOfPlayer);
						//If they still haven't reached 700 milliseconds in difference, then tell the player that they cannot fire
						} else if (!((currentTime - delayTimer)> 1000)) {
							player.sendMessage("You are shooting too fast!");
						}
					}
					
					//Check if the player does not have a timer on them nor currently have any ammo
					if ((!ItemReloadTimer.playerTimerList.containsKey(uuidOfPlayer)) && (!AmmoCounter.playerAmmoList.containsKey(uuidOfPlayer)) ) {
						//Give the player ammo
						AmmoCounter.addAmmo(uuidOfPlayer, modelData);
						shootPaintball(player, modelData, uuidOfPlayer);
						AmmoCounter.subtractAmmo(uuidOfPlayer, 3);
						ItemShotTimer.shotCooldown(uuidOfPlayer);
					}
					//Check if the player has an ammo value stored and if they are not on a cool-down
					if ((AmmoCounter.playerAmmoList.containsKey(uuidOfPlayer)) && !(ItemShotTimer.playerGunShotTimerList.containsKey(uuidOfPlayer))) {
						//If they do, get the current ammo count
						int currentAmmo = AmmoCounter.playerAmmoList.get(uuidOfPlayer);
						//Check if their ammo is not equal to 0 (no ammo left)
						if (currentAmmo != 0) {
							//Call method to shoot the paintball
							shootPaintball(player, modelData, uuidOfPlayer);
							//Subtract 1 from their current ammo
							AmmoCounter.subtractAmmo(uuidOfPlayer, 3);
							//Add player to shot cool-down
							ItemShotTimer.shotCooldown(uuidOfPlayer);
							currentAmmo = AmmoCounter.playerAmmoList.get(uuidOfPlayer);
							
						//Check if the player has no ammo and that they are not entered into the hash to reload
						} 
						if ((currentAmmo == 0) && !(ItemReloadTimer.playerTimerList.containsKey(uuidOfPlayer))) {
							//Enter the player into the hash
							ItemReloadTimer.timerSet(uuidOfPlayer);
							BukkitTask setXpToReload3 = new PlayerReloadTimer(uuidOfPlayer, 3).runTaskTimerAsynchronously(XtremePaintball.plugin, 0L, 3L);
						}
					} 
					
					//If the player has attempted to use their item while reloading call this statement
					if (ItemReloadTimer.playerTimerList.containsKey(uuidOfPlayer)) {
						//Get the server time at which the player shot their last paintball
						long delayTimer = ItemReloadTimer.playerTimerList.get(uuidOfPlayer);
						//Subtract both of them			
						//If the difference is greater than 4 seconds, then the player has reloaded
						if ((currentTime - delayTimer) > 3000) {
							//Give the player more ammo
							AmmoCounter.addAmmo(uuidOfPlayer, modelData);
							shootPaintball(player, modelData, uuidOfPlayer);
							AmmoCounter.subtractAmmo(uuidOfPlayer, 3);
							ItemShotTimer.shotCooldown(uuidOfPlayer);
							//Remove them from the reload timer
							ItemReloadTimer.playerTimerList.remove(uuidOfPlayer);
						//If the difference is not greater than 4 seconds, then the player has not reloaded
						} else if (!((currentTime - delayTimer) > 3000)){
							//Tell player that they have not reloaded yet!
						}
					}	
				}
			}
		}
	}
}

