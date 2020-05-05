package paintballMain;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class PrimedGrenadeParticles extends BukkitRunnable{
	
	Entity primedTnt = null;
	String teamColor = null;
	
	public PrimedGrenadeParticles(Entity tnt, String team) {
		this.primedTnt = tnt;
		this.teamColor = team;
	}
	
	
	@Override
	public void run() {
		if (primedTnt.isDead()) {
			this.cancel();
		}
		if (teamColor == "blue") {
			Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(0,0,255), 1);
			primedTnt.getWorld().spawnParticle(Particle.REDSTONE, primedTnt.getLocation().getX(),(primedTnt.getLocation().getY())+1,primedTnt.getLocation().getZ(), 50, dust );
			primedTnt.getWorld().spawnParticle(Particle.SMOKE_LARGE, primedTnt.getLocation(),0);
		} else if (teamColor == "red") {
			Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(255,0,0), 1);
			primedTnt.getWorld().spawnParticle(Particle.REDSTONE, primedTnt.getLocation().getX(),(primedTnt.getLocation().getY())+1,primedTnt.getLocation().getZ(), 50, dust );
			primedTnt.getWorld().spawnParticle(Particle.SMOKE_LARGE, primedTnt.getLocation(),0);
		}

	}

}
