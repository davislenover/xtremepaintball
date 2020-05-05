package paintballMain;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class PlayerReloadTimer extends BukkitRunnable {
	
	UUID uuidOfPlayer;
	int gunType;
	
	public PlayerReloadTimer(UUID uuidOfPlayer, int gunType) {
		this.gunType = gunType;
		this.uuidOfPlayer = uuidOfPlayer;
	}
	
	
	@Override
	public void run() {
		Player playerObject = Bukkit.getPlayer(uuidOfPlayer);
		if (playerObject.getExp() > 0.94) {
			playerObject.setExp(1);
			this.cancel();
		} else {
			playerObject.setExp((float) (playerObject.getExp() + 0.05));
		}
	}
}
