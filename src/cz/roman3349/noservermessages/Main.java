package cz.roman3349.noservermessages;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        logger.log(Level.INFO, "[NoServerMessages] Enabled join messages:{0}", getConfig().getBoolean("joinmsg.enabled"));
        logger.log(Level.INFO, "[NoServerMessages] Enabled quit messages:{0}", getConfig().getBoolean("quitmsg.enabled"));
        logger.log(Level.INFO, "[NoServerMessages] Enabled death messages:{0}", getConfig().getBoolean("deathmsg.enabled"));
        logger.log(Level.INFO, "[NoServerMessages] Plugin enabled succesfuly!");

    }

    @Override
    public void onDisable() {
        saveConfig();
        logger.log(Level.INFO, "[NoServerMessages] Plugin disabled succesfuly!");

    }

    @EventHandler
    public void PlayerJoinMsg(PlayerJoinEvent e) {
        if (getConfig().getBoolean("joinmsg.enabled", false)) {
            e.setJoinMessage(null);
        }
    }

    @EventHandler
    public void PlayerQuitMsg(PlayerQuitEvent e) {
        if (getConfig().getBoolean("quitmsg.enabled", false)) {
            e.setQuitMessage(null);
        }
    }

    @EventHandler
    public void PlayerDeathMsg(PlayerDeathEvent e) {
        if (getConfig().getBoolean("deathmsg.enabled", false)) {
            e.setDeathMessage(null);
        }
    }
}
