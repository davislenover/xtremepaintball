package paintballMain;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitTask;

public class GetPlayerSpeed implements Listener{
	
	static Map<UUID, Double> playerSpeedList = new HashMap<UUID, Double>();
	static Map<UUID, Integer> playerJumpList = new HashMap<UUID, Integer>();
	
	@EventHandler
	public void OnMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		UUID uuidOfPlayer = player.getUniqueId();
		double playerSpeed = event.getFrom().distance(event.getTo());
		//Schedule task to remove the players speed data after 8 ticks
		BukkitTask removePlayerData = new RemovePlayerSpeedData(uuidOfPlayer, 1).runTaskLaterAsynchronously(XtremePaintball.plugin, 8L);
		//Schedule task to remove the players jump data after 1 tick
		BukkitTask removePlayerData2 = new RemovePlayerSpeedData(uuidOfPlayer, 2).runTaskLaterAsynchronously(XtremePaintball.plugin, 1L);

		//If the players data is still in the hash map and they are on the ground, they are still moving
		if (playerSpeedList.containsKey(uuidOfPlayer) && ((player.isOnGround()))) {
			//Update the hash map with the new speed
			playerSpeedList.put(uuidOfPlayer, playerSpeed);
			//Cancel the speed data deletion
			removePlayerData.cancel();
		//If the players data is not in the speed hash map and they are on the ground, they are moving
		} else if (!(playerSpeedList.containsKey(uuidOfPlayer)) && ((player.isOnGround()))) {
			//Place their speed in the hash map
			playerSpeedList.put(uuidOfPlayer, playerSpeed);
		//If the player is not on the ground and there speed is in the hash map, they are still moving but not jumping
		} else if (playerSpeedList.containsKey(uuidOfPlayer) && (!(player.isOnGround()))){
			//Place their updated speed in the hash map
			playerSpeedList.put(uuidOfPlayer, playerSpeed);
			//Place an integer for jumping in the jump hash map
			playerJumpList.put(uuidOfPlayer, 1);
			//Cancel any events set to delete their positions and jumping status
			removePlayerData.cancel();
			removePlayerData2.cancel();
		//If the player is not on the ground and is not in the speed hash map
		} else if (!(playerSpeedList.containsKey(uuidOfPlayer)) && (!(player.isOnGround()))) {
			playerSpeedList.put(uuidOfPlayer, playerSpeed);
			playerJumpList.put(uuidOfPlayer, 1);
		}
	}
}
