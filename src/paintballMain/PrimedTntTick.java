package paintballMain;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

public class PrimedTntTick extends BukkitRunnable{
	
	Entity primedTnt = null;
	
	PrimedTntTick(Entity tnt) {
		this.primedTnt = tnt;
	}
	
	@Override
	public void run() {
		if (primedTnt.isDead()) {
			primedTnt.getWorld().playSound(primedTnt.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 10, 1);
			this.cancel();
		}
		primedTnt.getWorld().playSound(primedTnt.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 3, 1);
		primedTnt.getWorld().playSound(primedTnt.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 3, 1);
	}

}
