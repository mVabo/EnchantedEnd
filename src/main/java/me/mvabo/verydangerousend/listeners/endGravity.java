package me.mvabo.verydangerousend.listeners;

import me.mvabo.verydangerousend.VeryDangerousEnd;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class endGravity implements Listener {

    Plugin plugin = VeryDangerousEnd.getPlugin(VeryDangerousEnd.class);

    @EventHandler
    public void setGravity(PlayerTeleportEvent e) {
        Player p = e.getPlayer();
        Location f = e.getFrom();
        Location d = e.getTo();
        if(plugin.getConfig().getBoolean("enable_end_gravity")) {
            if (f.getWorld().getEnvironment().equals(World.Environment.NORMAL) && d.getWorld().getEnvironment().equals(World.Environment.THE_END)) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 3600, 1, true, true));
            }

            //if (f.getWorld().getEnvironment().equals(World.Environment.THE_END) && d.getWorld().getEnvironment().equals(World.Environment.NORMAL)) {
            //    p.setGravity(true);
            //}
        }
    }
}
