package paintballMain;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class FireworkTntSpawn extends BukkitRunnable{
	
	Entity primedTnt = null;
	String teamColor = null;

	
	public FireworkTntSpawn(Entity tnt, String team) {
		this.primedTnt = tnt;
		this.teamColor = team;
	}
	
	
	@Override
	public void run() {
		if (primedTnt.isDead()) {
			this.cancel();
		}
		
		if (teamColor == "blue") {
			FireworkEffect effect = FireworkEffect.builder().withColor(Color.BLUE).withFade(Color.WHITE).with(FireworkEffect.Type.BALL).trail(false).flicker(true).build();
			Firework firework = (Firework)primedTnt.getWorld().spawnEntity(primedTnt.getLocation().add(0,1,0), EntityType.FIREWORK);
			FireworkMeta meta = firework.getFireworkMeta();
			meta.addEffect(effect);
			firework.setFireworkMeta(meta);
			firework.detonate();
			primedTnt.getWorld().playSound(primedTnt.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST_FAR, 3, 1);
			
		} else if (teamColor == "red") {
			FireworkEffect effect = FireworkEffect.builder().withColor(Color.RED).withFade(Color.WHITE).with(FireworkEffect.Type.BALL).trail(false).flicker(true).build();
			Firework firework = (Firework)primedTnt.getWorld().spawnEntity(primedTnt.getLocation().add(0,1,0), EntityType.FIREWORK);
			FireworkMeta meta = firework.getFireworkMeta();
			meta.addEffect(effect);
			firework.setFireworkMeta(meta);
			firework.detonate();
			primedTnt.getWorld().playSound(primedTnt.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST_FAR, 3, 1);
		}
	}

}
