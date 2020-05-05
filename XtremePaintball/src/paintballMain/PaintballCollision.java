package paintballMain;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class PaintballCollision implements Listener {
	@EventHandler
	public void EntityEvent(ProjectileHitEvent event) {
		if ((event.getEntity() instanceof EnderPearl) && (event.getEntity().getCustomName().substring(0,5).equalsIgnoreCase("BlueP"))) {
			Entity paintball = event.getEntity();
			double projectileY = paintball.getLocation().getY();
			if (event.getHitEntity() instanceof Player) {
				String gunType = "Test";
				boolean headShot = false;
				Player hitPlayer = (Player) event.getHitEntity();
				double playerYPos = hitPlayer.getEyeLocation().getY();
				Bukkit.broadcastMessage(Double.toString(playerYPos));
				Bukkit.broadcastMessage(Double.toString(projectileY));
				if (playerYPos-0.2 <= projectileY && playerYPos+1.4 >= projectileY) {
					headShot = true;
				}
				String hitPlayerName = hitPlayer.getName();
				String playerWhoShot = paintball.getCustomName().substring(6).toLowerCase();
				Player playerWhoShotObject = (Player) Bukkit.getPlayer(UUID.fromString(playerWhoShot));
				if (paintball.getCustomName().substring(0, 6).equalsIgnoreCase("BluePA")) {
					gunType = "Automatic";
				} else if (paintball.getCustomName().substring(0, 6).equalsIgnoreCase("BluePS")) {	
				gunType = "Shotgun";
				} else if (paintball.getCustomName().substring(0, 6).equalsIgnoreCase("BluePR")) {
					gunType = "Sniper";
				}
				Bukkit.broadcastMessage("Hit Detected:  " + hitPlayer.getName() + " from " + playerWhoShotObject.getName() + " via " + gunType + " - " + "Shot Landed on head?: " + headShot);
			}
		}
	}
}
	

