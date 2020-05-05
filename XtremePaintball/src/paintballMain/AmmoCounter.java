package paintballMain;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class AmmoCounter {
	static Map<UUID, Integer> playerAmmoList = new HashMap<UUID, Integer>();
	
	public static void addAmmo(UUID player, int gunType) {
		Player playerObject = Bukkit.getPlayer(player);
		//If automatic gun is used
		if (gunType == 1) {
			playerAmmoList.put(player, 20);
			playerObject.setExp(1);
		//If shotgun is used
		} else if (gunType == 2) {
			playerAmmoList.put(player, 4);
			playerObject.setExp(1);
		//If sniper is used
		} else if (gunType == 3) {
			playerAmmoList.put(player, 5);
			playerObject.setExp(1);
		}
	}
	
	public static void subtractAmmo(UUID player, int gunType) {
		Player playerObject = Bukkit.getPlayer(player);
		int currentAmmo = playerAmmoList.get(player);
		currentAmmo = currentAmmo - 1;
		playerAmmoList.put(player, currentAmmo);
		if (playerAmmoList.get(player) == 0) {
			playerObject.setExp((float) (0));
		} else if (gunType == 1) {
			playerObject.setExp((float) (playerObject.getExp()-0.05));
		} else if (gunType == 2) {
			playerObject.setExp((float) (playerObject.getExp()-0.25));
		} else if (gunType == 3) {
			playerObject.setExp((float) (playerObject.getExp()-0.2));
		}
	}

}
