package cz.romanondracek.noservermessages;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	private Logger logger = Logger.getLogger("Minecraft");
	private FileConfiguration cfg = getConfig();

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
		logger.log(Level.INFO, "[NoServerMessages] Enabled join messages:{0}", cfg.getBoolean("joinmsg.enabled"));
		logger.log(Level.INFO, "[NoServerMessages] Enabled quit messages:{0}", cfg.getBoolean("quitmsg.enabled"));
		logger.log(Level.INFO, "[NoServerMessages] Enabled death messages:{0}", cfg.getBoolean("deathmsg.enabled"));
		logger.log(Level.INFO, "[NoServerMessages] Plugin enabled succesfuly!");
	}

	@Override
	public void onDisable() {
		saveConfig();
		logger.log(Level.INFO, "[NoServerMessages] Plugin disabled succesfuly!");
	}

	@EventHandler
	public void PlayerJoinMsg(PlayerJoinEvent e) {
		if (cfg.getBoolean("joinmsg.enabled", false)) {
			e.setJoinMessage(null);
		}
	}

	@EventHandler
	public void PlayerQuitMsg(PlayerQuitEvent e) {
		if (cfg.getBoolean("quitmsg.enabled", false)) {
			e.setQuitMessage(null);
		}
	}

	@EventHandler
	public void PlayerDeathMsg(PlayerDeathEvent e) {
		if (cfg.getBoolean("deathmsg.enabled", false)) {
			e.setDeathMessage(null);
		}
	}
}
