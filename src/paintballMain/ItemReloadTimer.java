package paintballMain;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

public class ItemReloadTimer {
	
	static Map<UUID, Long> playerTimerList = new HashMap<UUID, Long>();
	
	public static void timerSet(UUID player) {
		playerTimerList.put(player, System.currentTimeMillis());
	}
}
