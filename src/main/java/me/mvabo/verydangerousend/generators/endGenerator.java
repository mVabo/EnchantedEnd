package me.mvabo.verydangerousend.generators;

import me.mvabo.verydangerousend.VeryDangerousEnd;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class endGenerator extends BlockPopulator {

    Random randor = new Random();

    int[][][] rock1 = { { {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 1}, {1, 1, 1}, {0, 1, 1}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0} },
            { {1, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} } };
    int[][][] rock2 = { { {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {0, 1, 0}, {0, 1, 0} },
            { {0, 1, 1}, {0, 1, 1}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} } };
    int[][][] rock3 = { { {1, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 0}, {1, 1, 0}, {0, 1, 0}, {0, 1, 0}},
            { {0, 1, 1}, {0, 1, 1}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0} } };
    int[][][] rock4 = { { {1, 1, 1}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 1}, {1, 1, 1}, {0, 1, 1}, {0, 1, 0}, {0, 1, 0} },
            { {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} } };

    int[][][] rock5 = { { {0, 1, 1}, {0, 1, 1}, {0, 1, 0}, {0, 0, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0} },
            { {1, 1, 0}, {1, 1, 0}, {1, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0} } };

    int[][][] rock6 = { { {1, 1, 1}, {0, 1, 1}, {0, 1, 1}, {0, 1, 1}, {0, 1, 1}, {0, 0, 1}, {0, 0, 1} },
            { {1, 1, 1}, {1, 1, 1}, {1, 1, 0}, {1, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} } };
    int[][][] rock7 = { { {1, 1, 0}, {1, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} },
            { {1, 1, 1}, {1, 1, 1}, {1, 1, 0}, {1, 1, 0}, {0, 1, 0} },
            { {1, 1, 1}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} } };
    int[][][] rock8 = { { {0, 1, 1}, {0, 1, 1}, {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0} },
            {     {1, 1, 1}, {1, 1, 1}, {1, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0} },
            {     {0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0} } };

    int[][][] boulder1 = { { {0, 0, 0, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 0, 0, 0} },
            { {0, 2, 2, 0}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {0, 2, 2, 0} },
            { {0, 2, 2, 0}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {0, 2, 2, 0} },
            { {0, 0, 0, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 0, 0, 0} } };
    int[][][] boulder2 =  { { {0, 0, 0, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 0, 0}, {0, 0, 0, 0} },
            { {0, 2, 2, 0}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {0, 2, 2, 0} },
            { {0, 2, 2, 0}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {0, 0, 2, 0} },
            { {0, 0, 0, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 0, 0, 0} } };
    int[][][] boulder3 =  { { {0, 0, 0, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 0, 0, 0} },
            { {0, 2, 2, 0}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {0, 2, 2, 0} },
            { {0, 2, 2, 0}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {0, 2, 2, 0} },
            { {0, 0, 0, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 0, 0, 0} } };
    int[][][] boulder4 =  { { {0, 0, 0, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 0, 0, 0} },
            { {0, 2, 2, 0}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {0, 2, 2, 0} },
            { {0, 2, 2, 0}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {0, 2, 2, 0} },
            { {0, 0, 0, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 2, 2, 0}, {0, 0, 0, 0} } };

    Plugin plugin = VeryDangerousEnd.getPlugin(VeryDangerousEnd.class);

    @Override
    public void populate(World wor, Random rand, Chunk chnk) {
        int typeC = rand.nextInt(1);
        int cX = chnk.getX() * 16;
        int cZ = chnk.getZ() * 16;
        int cXOff = cX;
        int cZOff = cZ;
        int type = randor.nextInt(4);
        if(randor.nextDouble() < plugin.getConfig().getDouble("coralGrass_chance")) {
            createCoralGrass(cXOff + rand.nextInt(2) + 6, cZOff + rand.nextInt(2) + 6, wor);
            createCoralGrass(cXOff + rand.nextInt(2) + 6, cZOff + rand.nextInt(2) + 6, wor);
        }
        if(randor.nextDouble() < plugin.getConfig().getDouble("boulder_chance") && type==3) {
            createBoulder(cXOff + rand.nextInt(3) + 6, cZOff + rand.nextInt(3) + 6, wor);
        }
        if(randor.nextDouble() < plugin.getConfig().getDouble("spike_chance") && (type==0 || type==2 || type==3)) {
            createSpike2(cXOff + 7, cZOff + 7, wor);
        }
        if(randor.nextDouble() < plugin.getConfig().getDouble("randomShape_chance") && type==1) {
            randomShape(cXOff + rand.nextInt(7) + 3, cZOff + rand.nextInt(7) + 3, wor);
        }
        if(randor.nextDouble() < plugin.getConfig().getDouble("wall_chance") && type==2) {
            createWall(cXOff + 7, cZOff + 7, wor);
        }
    }

    public List<Integer> getClosestAirB(int cXOff, int cZOff, World w) {
        List<Integer> yvals = new ArrayList<Integer>();
        try {
            Location loc = new Location(w, cXOff, 20, cZOff);
            while(loc.getY()<120) {
                loc.add(0, 1, 0);
                if(loc.getBlock()!=null) {
                    if(loc.getBlock().getType().name().toLowerCase().contains("air")) {
                        Location loc2 = new Location(w, loc.getX(), loc.getY() - 1, loc.getZ());
                        if(loc2.getBlock().getType()==Material.END_STONE) {
                            yvals.add((int) loc.clone().getY());
                        }
                    }
                }
            }
            return yvals;
        }
        catch(Exception error) {
            return null;
        }
    }

    public int getClosestAirBS(int cXOff, int cZOff, World w) {
        try {
            Location loc = new Location(w, cXOff, 20, cZOff);
            while(loc.getY()<120) {
                loc.add(0, 1, 0);
                if(loc.getBlock()!=null) {
                    if(loc.getBlock().getType().name().toLowerCase().contains("air") || loc.getBlock().getType().name().toLowerCase().contains("coral")) {
                        Location loc2 = new Location(w, loc.getX(), loc.getY() - 1, loc.getZ());
                        if(loc2.getBlock().getType()==Material.END_STONE) {
                            return (int) loc.clone().getY();
                        }
                    }
                }
            }
            return 120;
        }
        catch(Exception error) {
            return 120;
        }
    }

    public void createCoralGrass(int cXOff, int cZOff, World w) {
        try {
            List<Integer> yvals = getClosestAirB(cXOff, cZOff, w);
            if(yvals!=null) {
                for(int y : yvals) {
                    if(randor.nextInt(3)!=0) {
                        for(int count = 0; count < 16; count++) {
                            if(randor.nextInt(4)!=0) {
                                Location org = new Location(w, cXOff, y, cZOff);
                                Location l = getRandLoc(new Location(w, cXOff, y, cZOff), 6);
                                if(outsideChunk(l, org.getChunk())) {
                                }
                                else {if(l.getBlock().getType() == Material.AIR && (!l.clone().subtract(0, 1, 0).getBlock().isPassable())) {
                                    if(randor.nextBoolean()==true) {
                                        l.getBlock().setType(Material.BUBBLE_CORAL, false);
                                    }
                                    else {
                                        l.getBlock().setType(Material.BUBBLE_CORAL_FAN, false);
                                    }
                                    Waterlogged wl = (Waterlogged) l.getBlock().getBlockData();
                                    wl.setWaterlogged(false);
                                    l.getBlock().setBlockData(wl, false);
                                }
                                }
                            }
                        }
                    }
                }
            }
        }
        catch(Exception error) {

        }
    }

    public Location getRandLoc(Location l, int radi) {
        if(l!=null) {
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
            return new Location(l.getWorld(), x, y, z, randor.nextInt(360), randor.nextInt(360));
        }
        return null;
    }

    public Location getRandLocSquare(Location l, int radi) {
        if(l!=null) {
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
            return new Location(l.getWorld(), x, y, z, randor.nextInt(360), randor.nextInt(360));
        }
        return null;
    }

    public void createBoulder(int cXOff, int cZOff, World w) {
        try {
            List<Integer> yvals = getClosestAirB(cXOff, cZOff, w);
            if(yvals!=null) {
                for(int y : yvals) {
                    Location l = new Location(w, cXOff, y-1, cZOff);
                    if(nextToEdge(l)) {
                        return;
                    }
                    int type = randor.nextInt(4);
                    if(type==0) {
                        generateBoulder2(boulder1, l);
                    }
                    else if(type==1) {
                        generateBoulder2(boulder2, l);
                    }
                    else if(type==2) {
                        generateBoulder2(boulder3, l);
                    }
                    else if(type==3) {
                        generateBoulder2(boulder4, l);
                    }
                }
            }
        }
        catch(Exception error) {

        }
    }

    public void createBase(Location l) {
        Location l2 = l.clone().subtract(0, 1, 0);
        Block b = l2.getBlock();
        b.getRelative(BlockFace.EAST).setType(Material.END_STONE, false);
        b.getRelative(BlockFace.NORTH).setType(Material.END_STONE, false);
        b.getRelative(BlockFace.SOUTH).setType(Material.END_STONE, false);
        b.getRelative(BlockFace.SELF).setType(Material.END_STONE, false);
        b.getRelative(BlockFace.WEST).setType(Material.END_STONE, false);
        b.getRelative(BlockFace.NORTH_EAST).setType(Material.END_STONE, false);
        b.getRelative(BlockFace.SOUTH_EAST).setType(Material.END_STONE, false);
        b.getRelative(BlockFace.SOUTH_WEST).setType(Material.END_STONE, false);
        b.getRelative(BlockFace.NORTH_WEST).setType(Material.END_STONE, false);
    }

    public void createSpike2(int cXOff, int cZOff, World w) {
        try {
            List<Integer> yvals = getClosestAirB(cXOff, cZOff, w);
            if(yvals!=null) {
                for(int y : yvals) {
                    int ammount = randor.nextInt(6)+12;
                    for(int count = 0; count < ammount; count++) {
                        Location l = getRandLoc(new Location(w, cXOff, y, cZOff), 6);
                        if(!nextToEdge(l)) {
                            if(l.getBlock().getType() == Material.AIR && (l.clone().subtract(0, 1, 0).getBlock().getType() == Material.END_STONE)) {
                                createBase(l);
                                int type = randor.nextInt(8);
                                if(type==0) {
                                    generateBoulder(rock1, l);
                                }
                                else if(type==1) {
                                    generateBoulder(rock2, l);
                                }
                                else if(type==2) {
                                    generateBoulder(rock3, l);
                                }
                                else if(type==3) {
                                    generateBoulder(rock4, l);
                                }
                                else if(type==4) {
                                    generateBoulder(rock5, l);
                                }
                                else if(type==5) {
                                    generateBoulder(rock6, l);
                                }
                                else if(type==6) {
                                    generateBoulder(rock7, l);
                                }
                                else if(type==7) {
                                    generateBoulder(rock8, l);
                                }
                            }
                        }
                    }
                }
            }
        }
        catch(Exception error) {

        }
    }

    public BlockFace gb() {
        int num = randor.nextInt(8);
        if(num == 0) {
            return BlockFace.EAST;
        }
        if(num == 1) {
            return BlockFace.SOUTH;
        }
        if(num == 2) {
            return BlockFace.WEST;
        }
        if(num == 3) {
            return BlockFace.NORTH;
        }
        if(num == 4) {
            return BlockFace.NORTH_EAST;
        }
        if(num == 5) {
            return BlockFace.SOUTH_EAST;
        }
        if(num == 6) {
            return BlockFace.NORTH_WEST;
        }
        if(num == 7) {
            return BlockFace.SOUTH_WEST;
        }
        return null;
    }

    public boolean nextToEdge(Location l) {
        Chunk c = l.getChunk();
        int cX = c.getX() * 16;
        int cZ = c.getZ() * 16;
        if((cX) >= l.getBlockX()) {
            return true;
        }
        else if((cX+15) <= l.getBlockX()) {
            return true;
        }
        if((cZ) >= l.getBlockZ()) {
            return true;
        }
        else if((cZ+15) <= l.getBlockZ()) {
            return true;
        }
        return false;
    }

    public boolean outsideChunk(Location l, Chunk org) {
        Chunk c = org;
        int cX = c.getX() * 16;
        int cZ = c.getZ() * 16;
        int x = ((int) l.getX());
        int z = ((int) l.getZ());
        if((cX+1) > x) {
            return true;
        }
        else if((cX+14) < x) {
            return true;
        }
        if((cZ+1) > z) {
            return true;
        }
        else if((cZ+14) < z) {
            return true;
        }
        return false;
    }

    public void createWall(int cXOff, int cZOff, World w) {
        try {
            List<Integer> yvals = getClosestAirB(cXOff, cZOff, w);
            if(yvals!=null) {
                for(int y : yvals) {
                    int ammount = randor.nextInt(3)+7;
                    Location next = new Location(w, cXOff, y, cZOff);
                    for(int count = 0; count < ammount; count++) {
                        Location l = next.getBlock().getRelative(gb()).getLocation();
                        if(l.getBlock().getType() == Material.AIR && (l.clone().subtract(0, 1, 0).getBlock().getType() == Material.END_STONE)) {
                            if(nextToEdge(l)) {
                                return;
                            }
                            int height = randor.nextInt(6)+6;
                            for(int time = 0; time < height; time++) {
                                if(l.clone().add(0, time, 0).getBlock().isPassable()) {
                                    if(randor.nextBoolean()) {
                                        l.clone().add(0, time, 0).getBlock().setType(Material.PURPUR_PILLAR);
                                    }
                                    else {
                                        l.clone().add(0, time, 0).getBlock().setType(Material.PURPUR_BLOCK);
                                    }
                                }
                                next = l;
                            }
                        }
                    }
                }
            }
        }
        catch(Exception error) {

        }
    }

    public void generateBoulder(int[][][] rock, Location loc) {
        try {
            int randDirection = randor.nextInt(4);
            if(randDirection==0) {
                for(int y = 0; y < rock[0].length; y++) {
                    for(int x = -1; x < rock.length-1; x++) {
                        for(int z = -1; z < rock[0][0].length-1; z++) {
                            if(rock[x+1][y][z+1]==1) {
                                Location loc2 = new Location(loc.getWorld(), loc.getX()+x, loc.getY()+y, loc.getZ()+z);
                                if(!outsideChunk(loc2, loc.getChunk())) {
                                    loc2.getBlock().setType(Material.END_STONE, false);
                                }
                            }
                        }
                    }
                }
            }
            else if(randDirection==1) {
                for(int y = 0; y < rock[0].length; y++) {
                    for(int x = -1; x < rock.length-1; x++) {
                        for(int z = -1; z < rock[0][0].length-1; z++) {
                            if(rock[x+1][y][z+1]==1) {
                                Location loc2 = new Location(loc.getWorld(), loc.getX()-x, loc.getY()+y, loc.getZ()+z);
                                if(!outsideChunk(loc2, loc.getChunk())) {
                                    loc2.getBlock().setType(Material.END_STONE, false);
                                }
                            }
                        }
                    }
                }
            }
            else if(randDirection==2) {
                for(int y = 0; y < rock[0].length; y++) {
                    for(int x = -1; x < rock.length-1; x++) {
                        for(int z = -1; z < rock[0][0].length-1; z++) {
                            if(rock[x+1][y][z+1]==1) {
                                Location loc2 = new Location(loc.getWorld(), loc.getX()+x, loc.getY()+y, loc.getZ()-z);
                                if(!outsideChunk(loc2, loc.getChunk())) {
                                    loc2.getBlock().setType(Material.END_STONE, false);
                                }
                            }
                        }
                    }
                }
            }
            else if(randDirection==3) {
                for(int y = 0; y < rock[0].length; y++) {
                    for(int x = -1; x < rock.length-1; x++) {
                        for(int z = -1; z < rock[0][0].length-1; z++) {
                            if(rock[x+1][y][z+1]==1) {
                                Location loc2 = new Location(loc.getWorld(), loc.getX()-x, loc.getY()+y, loc.getZ()-z);
                                if(!outsideChunk(loc2, loc.getChunk())) {
                                    loc2.getBlock().setType(Material.END_STONE, false);
                                }
                            }
                        }
                    }
                }
            }
        }
        catch(Exception error) {
        }
    }

    public void generateBoulder2(int[][][] rock, Location loc) {
        loc.subtract(0, 2, 0);
        try {
            int randDirection = 0;
            if(randDirection==0) {
                for(int y = 0; y < rock[0].length; y++) {
                    for(int x = -1; x < rock.length-1; x++) {
                        for(int z = -1; z < rock[0][0].length-1; z++) {
                            if(rock[x+1][y][z+1]==2) {
                                Location loc2 = new Location(loc.getWorld(), loc.getX()+x, loc.getY()+y, loc.getZ()+z);
                                if(!outsideChunk(loc2, loc.getChunk())) {
                                    if(randor.nextInt(8)!=0) {
                                        loc2.getBlock().setType(Material.OBSIDIAN, false);
                                    }
                                    else {
                                        loc2.getBlock().setType(Material.COAL_BLOCK, false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        catch(Exception error) {
        }
    }

    public int getClosestAir(int cXOff, int cZOff, World w) {
        try {
            Location loc = new Location(w, cXOff, 20, cZOff);
            while(loc.getY()<120) {
                loc.add(0, 1, 0);
                if(loc.getBlock().getType().name().toLowerCase().contains("air")) {
                    Location loc2 = new Location(w, loc.getX(), loc.getY() - 1, loc.getZ());
                    if(loc2.getBlock().getType() == Material.END_STONE) {
                        Location loc3 = new Location(w, loc.getX(), loc.getY() + 1, loc.getZ());
                        if(loc3.getBlock().getType().name().toLowerCase().contains("air")) {
                            break;
                        }
                    }
                }
            }
            return (int) loc.getY();
        }
        catch(Exception error) {
            return 1;
        }
    }

    public void randomShape(int cXOff, int cZOff, World w) {
        try {
            int yVal = getClosestAirBS(cXOff, cZOff, w);
            if(yVal == 120) {
                return;
            }
            else {
                Location loc = new Location(w, cXOff, yVal, cZOff);
                if(nextToEdge(loc)) {
                    return;
                }
                int type = randor.nextInt(8);
                if(type==0) {
                    loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_SLAB, false);
                }
                else if(type==1) {
                    loc.getBlock().setType(Material.PURPUR_BLOCK, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_SLAB, false);
                }
                else if(type==2) {
                    loc.getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    Location loc2 = new Location(loc.getWorld(), loc.getX()+randor.nextInt(2), loc.getY(), loc.getZ()+1);
                    loc2.getBlock().setType(Material.PURPUR_SLAB, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_SLAB, false);
                }
                else if(type==3) {
                    loc.getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    Location loc2 = new Location(loc.getWorld(), loc.getX()+1, loc.getY(), loc.getZ()+randor.nextInt(2));
                    loc2.getBlock().setType(Material.PURPUR_SLAB, false);
                }
                else if(type==4) {
                    loc.getBlock().setType(Material.PURPUR_BLOCK, false);
                    Location loc2 = new Location(loc.getWorld(), loc.getX()+randor.nextInt(2), loc.getY(), loc.getZ()+1);
                    loc2.getBlock().setType(Material.PURPUR_SLAB, false);
                    loc.add(0,1,0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    Location loc22 = new Location(loc.getWorld(), loc.getX()-1, loc.getY(), loc.getZ()+randor.nextInt(2));
                    loc22.getBlock().setType(Material.PURPUR_SLAB, false);
                }
                else if(type==5) {
                    loc.getBlock().setType(Material.PURPUR_BLOCK, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    Location loc2 = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()+1);
                    loc2.getBlock().setType(Material.PURPUR_SLAB, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    Location loc22 = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()-1);
                    loc22.getBlock().setType(Material.PURPUR_SLAB, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_SLAB, false);
                }
                else if(type==6) {
                    loc.getBlock().setType(Material.PURPUR_BLOCK, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    Location loc2 = new Location(loc.getWorld(), loc.getX()+randor.nextInt(2), loc.getY(), loc.getZ()+1);
                    loc2.getBlock().setType(Material.PURPUR_SLAB, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    Location loc22 = new Location(loc.getWorld(), loc.getX()+1, loc.getY(), loc.getZ());
                    loc22.getBlock().setType(Material.PURPUR_SLAB, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    Location loc222 = new Location(loc.getWorld(), loc.getX()+1, loc.getY(), loc.getZ());
                    loc222.getBlock().setType(Material.PURPUR_SLAB, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_BLOCK, false);
                    if(randor.nextBoolean()==true) {
                        loc.getBlock().setType(Material.PURPUR_PILLAR, false);
                    }
                    Location loc2222 = new Location(loc.getWorld(), loc.getX()-1, loc.getY(), loc.getZ());
                    loc2222.getBlock().setType(Material.PURPUR_SLAB, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_SLAB, false);
                    Location loc22222 = new Location(loc.getWorld(), loc.getX()+1, loc.getY(), loc.getZ());
                    loc22222.getBlock().setType(Material.PURPUR_SLAB, false);
                }
                else if(type==7) {
                    loc.getBlock().setType(Material.PURPUR_BLOCK, false);
                    loc.add(0, 1, 0).getBlock().setType(Material.PURPUR_STAIRS, false);
                }
            }
        }
        catch(Exception error) {

        }
    }

}

