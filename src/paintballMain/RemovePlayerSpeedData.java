package paintballMain;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class RemovePlayerSpeedData extends BukkitRunnable {
	
	UUID uuidOfPlayer;
	int removeCode;
	
	public RemovePlayerSpeedData(UUID uuidOfPlayer, int toRemove) {
		this.removeCode = toRemove;
		this.uuidOfPlayer = uuidOfPlayer;
	}
	
	@Override
	public void run() {
		if (GetPlayerSpeed.playerSpeedList.containsKey(uuidOfPlayer) && (removeCode == 1)) {
			GetPlayerSpeed.playerSpeedList.remove(uuidOfPlayer);
		}
		if (GetPlayerSpeed.playerJumpList.containsKey(uuidOfPlayer) && (removeCode == 2)) {
			GetPlayerSpeed.playerJumpList.remove(uuidOfPlayer);
		}
	}

}
