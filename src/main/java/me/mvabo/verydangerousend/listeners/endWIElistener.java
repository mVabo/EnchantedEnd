package me.mvabo.verydangerousend.listeners;

import me.mvabo.verydangerousend.VeryDangerousEnd;
import me.mvabo.verydangerousend.generators.endGenerator;
import me.mvabo.verydangerousend.utils.utils;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.plugin.Plugin;

public class endWIElistener implements Listener {

    Plugin plugin = VeryDangerousEnd.getPlugin(VeryDangerousEnd.class);


    @EventHandler
    public void runNetherGenerator(WorldInitEvent event) {
        World w = event.getWorld();
        //System.out.println(utils.chat("&6checking if netherModule is enabled"));
        if(plugin.getConfig().getBoolean("ee-enabled")) {
            if(isEnd(w)) {
                event.getWorld().getPopulators().add(new endGenerator());
            }
        }
    }

    public boolean isEnd(World w) {
        if (w.getName().endsWith("_end")) {
            return true;
        }
        return false;
    }
}
