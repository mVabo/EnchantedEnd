package me.mvabo.verydangerousend;

import me.mvabo.verydangerousend.listeners.endGravity;
import me.mvabo.verydangerousend.listeners.endWIElistener;
import me.mvabo.verydangerousend.mobs.endMobs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class VeryDangerousEnd extends JavaPlugin implements Listener {

    boolean endEnabled = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        endEnabled = getConfig().getBoolean("ee-enabled");

        //Register general events
        Bukkit.getPluginManager().registerEvents(this, this);

        end e = new end();

        if (endEnabled) {
            Bukkit.getPluginManager().registerEvents(e, this);
            Bukkit.getPluginManager().registerEvents(new endWIElistener(), this);
            Bukkit.getPluginManager().registerEvents(new endMobs(), this);
            Bukkit.getPluginManager().registerEvents(new endGravity(), this);
        }

        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                e.loopDragons();
            }
        }, 0L, ((long) 20));
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                e.followPlayer();
                e.loopEyes();
            }
        }, 0L, ((long) 2));
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()) {
                    e.doSound(p);
                }
            }
        }, 0L, ((long) 10));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
