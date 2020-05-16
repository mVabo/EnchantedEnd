package me.mvabo.verydangerousend.utils;

import org.bukkit.ChatColor;
import org.bukkit.Location;

import java.util.Random;

public class utils {

    Random randint = new Random();

    public static String chat (String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public Location getRandLoc(Location l, int radi) {
        if(l != null) {
            double radius = radi;
            double x0 = l.getX();
            double y0 = l.getY();
            double z0 = l.getZ();
            double u = Math.random();
            double v = Math.random();
            double theta = 2 * Math.PI * u;
            double phi = Math.acos(2 * v - 1);
            double x = x0 + (radius * Math.sin(phi) * Math.cos(theta));
            double y = y0;
            double z = z0 + (radius * Math.cos(phi));
            return new Location(l.getWorld(), x, y, z, randint.nextInt(360), randint.nextInt(360));
        }
        return null;
    }
}

