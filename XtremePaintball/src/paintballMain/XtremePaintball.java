package paintballMain;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class XtremePaintball extends JavaPlugin {
	public static XtremePaintball plugin;
	
	//Fired when plugin is first enabled
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new PaintballThrow(), this);
		getServer().getPluginManager().registerEvents(new PaintGrenadeThrow(), this);
		getServer().getPluginManager().registerEvents(new BlockExplosionRegeneration(), this);
		getServer().getPluginManager().registerEvents(new PaintballCollision(), this);
		getServer().getPluginManager().registerEvents(new GetPlayerSpeed(), this);
		plugin = this;
	}
	
	//Fired when plugin is disabled
	@Override
	public void onDisable() {
		
	}
	
	@Override
	//This method will be called when a player issues a command, it will take in the players name, the command that was sent, the string version of it and any arguments the player specifies (via a string array)
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("xpb")) {
			//If no arguments were given for the command, send the player to the help menu
			if (args.length < 1) {
				sendHelp(sender);
				return true;
			} 
			
			//If the string list is greater than zero, the player must have inputed arguments
			else if ((args.length > 1) && (args[0].equalsIgnoreCase("givegun"))) {
				//Check if the player inputed the correct number of arguments
				if (args.length == 4) {
					//Get the player name to which will receive the item, cast it to a player type so it can be read by the game engine
					Player directedPlayer = (Player) Bukkit.getPlayer(args[1]);
					//Check if the player who issued the command, inputed the correct item
					if (args[2].equalsIgnoreCase("auto") || args[2].equalsIgnoreCase("shotgun") || args[2].equalsIgnoreCase("sniper")) {
						//Get the item to give to the specified player
						String itemToSpawn = args[2];
						//Check the team the player inputed
						if (args[3].equalsIgnoreCase("Blue")) {
							//Set the team color
							String teamColor = "blue";
							//Call method to spawn the item
							ItemData.giveItem(directedPlayer, itemToSpawn, sender, teamColor);
							//End the method
							return true;
						} else if (args[3].equalsIgnoreCase("Red")) {
							String teamColor = "red";
							ItemData.giveItem(directedPlayer, itemToSpawn, sender, teamColor);
							return true;
						} else {
							sendError(sender);
							return true;
						}
					} else {
						sendError(sender);
						return true;
					}
				} else {
					sendError(sender);
					return true;
				}
				//If the string list is greater than zero, the player must have inputed arguments (in this case, they want a paint grenade)
			} else if ((args.length > 1) && (args[0].equalsIgnoreCase("givegrenade"))) {
				//Check if the player inputed the correct number of arguments
				if (args.length == 4) {
					//Get the player name to which will receive the item, cast it to a player type so it can be read by the game engine
					Player directedPlayer = (Player) Bukkit.getPlayer(args[1]);
					//Check if the player who issued the command, inputed the correct item
					if (args[2].equalsIgnoreCase("grenade")) {
						//Set the item to spawn (grenade)
						String itemToSpawn = args[2];
						//Get which team was inputed
						if (args[3].equalsIgnoreCase("Blue")) {
							//Set the team color
							String teamColor = "blue";
							//Call method to spawn item
							ItemData.giveItem(directedPlayer, itemToSpawn, sender, teamColor);
						} else if (args[3].equalsIgnoreCase("Red")) {
							String teamColor = "red";
							ItemData.giveItem(directedPlayer, itemToSpawn, sender, teamColor);
						} else {
							sendError(sender);
						}
						return true;
					} else {
						sendError(sender);
						return true;
					}
				} else {
					sendError(sender);
					return true;
					}
				}
			}
			
			//If the player has entered in inappropriate values, tell them that the plugin does not know what they want to do
			else {
				//Call method to send message, pass the player
				sendError(sender);
				return true;
			}
		return true;
	}
	
	//Method sends the help menu to the player, takes in the player who issued a help command
	public void sendHelp(CommandSender sender) {
		//Send the message to the player with a specific color
		sender.sendMessage(ChatColor.BOLD + "||||| X-treme Paintball Help menu |||||");
		sender.sendMessage(ChatColor.BLUE + "/xpb givegun <player> <auto|shotgun|sniper>");
		sender.sendMessage(ChatColor.BLUE + "/xpb givegrenade <player> <grenade>");
	}
	
	//Method sends an error message to the player, takes in the player who issued an invalid command
	public void sendError(CommandSender sender) {
		//Send the message to the player with a specific color
		sender.sendMessage(ChatColor.RED + "Command Unknown!");
	}
	
}
