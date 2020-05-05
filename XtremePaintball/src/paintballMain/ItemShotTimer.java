package paintballMain;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

public class ItemShotTimer {
	static Map<UUID, Long> playerGunShotTimerList = new HashMap<UUID, Long>();
	
	public static void shotCooldown(UUID player) {
		playerGunShotTimerList.put(player, System.currentTimeMillis());
	}
}
