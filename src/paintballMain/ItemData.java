package paintballMain;

import java.util.Arrays;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemData {
	public static void giveItem(Player playerSelected, String item, CommandSender sender, String teamColor) {
		try {
			playerSelected.getInventory().addItem(getItem(item, teamColor));
		} catch (Exception e){
			sender.sendMessage(ChatColor.RED + "Player not found!");
		}
	}
	
	public static ItemStack getItem(String item, String teamColor) {
		if (item.equalsIgnoreCase("auto")) {
			if (teamColor == "blue") {
				ItemStack gunItem = new ItemStack((Material.IRON_HORSE_ARMOR), 1);
				ItemMeta itemmeta = gunItem.getItemMeta();
				itemmeta.setDisplayName("Paintball gun - Automatic");
				itemmeta.setLore(Arrays.asList("This is a Automatic Paintball gun!"));
				itemmeta.setCustomModelData(1);
				gunItem.setItemMeta(itemmeta);
				return gunItem;
			} else if (teamColor == "red") {
				ItemStack gunItem = new ItemStack((Material.IRON_HORSE_ARMOR), 1);
				ItemMeta itemmeta = gunItem.getItemMeta();
				itemmeta.setDisplayName("Paintball gun - Automatic");
				itemmeta.setLore(Arrays.asList("This is a Automatic Paintball gun!"));
				itemmeta.setCustomModelData(8);
				gunItem.setItemMeta(itemmeta);
				return gunItem;
			}
			ItemStack gunItem = new ItemStack((Material.IRON_HORSE_ARMOR), 1);
			ItemMeta itemmeta = gunItem.getItemMeta();
			itemmeta.setDisplayName("Paintball gun - Automatic");
			itemmeta.setLore(Arrays.asList("This is a Automatic Paintball gun!"));
			itemmeta.setCustomModelData(1);
			gunItem.setItemMeta(itemmeta);
			return gunItem;
		} 
		
		else if (item.equalsIgnoreCase("shotgun")) {
			if (teamColor == "blue") {
				ItemStack gunItem = new ItemStack((Material.GOLDEN_HORSE_ARMOR), 1);
				ItemMeta itemmeta = gunItem.getItemMeta();
				itemmeta.setDisplayName("Paintball gun - Shotgun");
				itemmeta.setLore(Arrays.asList("This is a Paintball Shotgun!"));
				itemmeta.setCustomModelData(2);
				gunItem.setItemMeta(itemmeta);
				return gunItem;
			} else if (teamColor == "red") {
				ItemStack gunItem = new ItemStack((Material.GOLDEN_HORSE_ARMOR), 1);
				ItemMeta itemmeta = gunItem.getItemMeta();
				itemmeta.setDisplayName("Paintball gun - Shotgun");
				itemmeta.setLore(Arrays.asList("This is a Paintball Shotgun!"));
				itemmeta.setCustomModelData(7);
				gunItem.setItemMeta(itemmeta);
				return gunItem;
			}
			ItemStack gunItem = new ItemStack((Material.GOLDEN_HORSE_ARMOR), 1);
			ItemMeta itemmeta = gunItem.getItemMeta();
			itemmeta.setDisplayName("Paintball gun - Shotgun");
			itemmeta.setLore(Arrays.asList("This is a Paintball Shotgun!"));
			itemmeta.setCustomModelData(2);
			gunItem.setItemMeta(itemmeta);
			return gunItem;
		} 
		
		else if (item.equalsIgnoreCase("sniper")) {
			if (teamColor == "blue") {
				ItemStack gunItem = new ItemStack((Material.DIAMOND_HORSE_ARMOR), 1);
				ItemMeta itemmeta = gunItem.getItemMeta();
				itemmeta.setDisplayName("Paintball gun - Sniper");
				itemmeta.setLore(Arrays.asList("This is a Paintball Sniper Rifle!"));
				itemmeta.setCustomModelData(3);
				gunItem.setItemMeta(itemmeta);
				return gunItem;
			} else if (teamColor == "red") {
				ItemStack gunItem = new ItemStack((Material.DIAMOND_HORSE_ARMOR), 1);
				ItemMeta itemmeta = gunItem.getItemMeta();
				itemmeta.setDisplayName("Paintball gun - Sniper");
				itemmeta.setLore(Arrays.asList("This is a Paintball Sniper Rifle!"));
				itemmeta.setCustomModelData(6);
				gunItem.setItemMeta(itemmeta);
				return gunItem;
			}
			ItemStack gunItem = new ItemStack((Material.DIAMOND_HORSE_ARMOR), 1);
			ItemMeta itemmeta = gunItem.getItemMeta();
			itemmeta.setDisplayName("Paintball gun - Sniper");
			itemmeta.setLore(Arrays.asList("This is a Paintball Sniper Rifle!"));
			itemmeta.setCustomModelData(3);
			gunItem.setItemMeta(itemmeta);
			return gunItem;
		}
		
		else if (item.equalsIgnoreCase("grenade")) {
			if (teamColor == "blue") {
				ItemStack grenadeItem = new ItemStack((Material.TNT), 1);
				ItemMeta itemmeta = grenadeItem.getItemMeta();
				itemmeta.setDisplayName("Paintgrenade");
				itemmeta.setLore(Arrays.asList("This is a paintgrenade which you can throw!"));
				itemmeta.setCustomModelData(4);
				grenadeItem.setItemMeta(itemmeta);
				return grenadeItem;
			} else if (teamColor == "red") {
				ItemStack grenadeItem = new ItemStack((Material.TNT), 1);
				ItemMeta itemmeta = grenadeItem.getItemMeta();
				itemmeta.setDisplayName("Paintgrenade");
				itemmeta.setLore(Arrays.asList("This is a paintgrenade which you can throw!"));
				itemmeta.setCustomModelData(5);
				grenadeItem.setItemMeta(itemmeta);
				return grenadeItem;
			} 
			ItemStack grenadeItem = new ItemStack((Material.TNT), 1);
			ItemMeta itemmeta = grenadeItem.getItemMeta();
			itemmeta.setDisplayName("Paintgrenade");
			itemmeta.setLore(Arrays.asList("This is a paintgrenade which you can throw!"));
			itemmeta.setCustomModelData(4);
			grenadeItem.setItemMeta(itemmeta);
			return grenadeItem;
		}
		
		else {
			return (new ItemStack((Material.IRON_HORSE_ARMOR), 1));
		}
	}
}
