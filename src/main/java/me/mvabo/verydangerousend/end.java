package me.mvabo.verydangerousend;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.Particle.DustOptions;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Openable;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.craftbukkit.libs.org.apache.commons.codec.binary.Base64;
//import org.bukkit.craftbukkit.v1_14_R1.entity.CraftEnderDragon;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EnderDragon.Phase;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Husk;
import org.bukkit.entity.Illager;
import org.bukkit.entity.Item;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Llama;
import org.bukkit.entity.LlamaSpit;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Raider;
import org.bukkit.entity.Shulker;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.SkeletonHorse;
import org.bukkit.entity.Slime;
import org.bukkit.entity.SmallFireball;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Stray;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTransformEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.wrappers.WrappedServerPing;
//import com.mojang.authlib.GameProfile;
//import com.mojang.authlib.properties.Property;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
//import net.minecraft.server.v1_14_R1.LootTableInfo.EntityTarget;

import static org.bukkit.Bukkit.getServer;

public class end implements Listener {

    Plugin plugin = VeryDangerousEnd.getPlugin(VeryDangerousEnd.class);
    BukkitScheduler scheduler = null;
    FileConfiguration config = plugin.getConfig();
    public ConsoleCommandSender console = getServer().getConsoleSender();
    Random randor = new Random();

    //

    public List<String> witherworlds = new ArrayList<String>();
    public List<String> dragonworlds = new ArrayList<String>();

    //

    @EventHandler
    public void getEndConfigs(WorldInitEvent event) {
        witherworlds = config.getStringList("wither_worlds");
        dragonworlds = config.getStringList("enderDragon_worlds");

    }

    /*
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("nocommand")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                return true;
            }
        }
        return true;
    }

     */



    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
    }

    //EnderDragon

    public boolean outsideChunk(Location l, Chunk org) {
        Chunk c = org;
        int cX = c.getX() * 16;
        int cZ = c.getZ() * 16;
        int x = ((int) l.getX());
        int z = ((int) l.getZ());
        if((cX) > x) {
            return true;
        }
        else if((cX+15) < x) {
            return true;
        }
        if((cZ) > z) {
            return true;
        }
        else if((cZ+15) < z) {
            return true;
        }
        return false;
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

    @EventHandler
    public void endermanSpawn(CreatureSpawnEvent e) {
        if(!e.isCancelled()) {
            if(dragonworlds.contains(e.getEntity().getWorld().getName())) {
                if(e.getEntity() instanceof Enderman && e.getSpawnReason()==SpawnReason.NATURAL) {
                    Bukkit.getScheduler().runTaskLater(plugin, () -> spawnOther(e.getEntity()), 2);
                }
            }
        }
    }

    public void spawnOther(Entity e) {
        if(exists(e)) {
            Location l = e.getLocation().clone();
            boolean spawned = false;
            int choice = randor.nextInt(2);
            if(choice == 0) {
                if(randor.nextInt(5)==0) {
                    WitherSkeleton sk = (WitherSkeleton) l.getWorld().spawnEntity(l, EntityType.WITHER_SKELETON);
                    ItemStack myAwesomeSkull = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta myAwesomeSkullMeta = (SkullMeta) myAwesomeSkull.getItemMeta();
                    myAwesomeSkullMeta.setOwner("http://textures.minecraft.net/texture/9af7d6f6e0b05517bcb4cd2aac21a469b18b74db46c72a98dfb55ef7ad8c2898");
                    myAwesomeSkull.setItemMeta(myAwesomeSkullMeta);
                    sk.getEquipment().setHelmet(myAwesomeSkull);
                    //sk.getEquipment().setHelmet(getSkull("http://textures.minecraft.net/texture/9af7d6f6e0b05517bcb4cd2aac21a469b18b74db46c72a98dfb55ef7ad8c2898"));
                    sk.getEquipment().setHelmetDropChance(0);
                    sk.getEquipment().setItemInMainHand(new ItemStack(Material.BLACK_CONCRETE));
                    sk.getEquipment().setItemInOffHand(new ItemStack(Material.BLACK_CONCRETE));
                    ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                    LeatherArmorMeta lcm = (LeatherArmorMeta) lchest.getItemMeta();
                    lcm.setColor(Color.fromRGB(0, 0, 0));
                    lchest.setItemMeta(lcm);
                    sk.getEquipment().setChestplate(lchest);
                    addPotionEffectBetter(sk, PotionEffectType.INVISIBILITY, 999999, 1, false, false, false);
                    sk.setMetadata("eyeofdragon", new FixedMetadataValue(plugin, 0));
                    sk.setCustomName(ChatColor.WHITE + "Hiding Eye");
                    spawned = true;
                }
            }
            else if(choice == 1) {
                if(randor.nextInt(5)==0) {
                    l.getWorld().spawnEntity(l, EntityType.PHANTOM);
                    spawned = true;
                }
            }
            if(spawned) {
                e.remove();
            }
        }
        else {
            return;
        }
    }

    public boolean hasLore(ItemStack i, String loreinfo) {
        if(i == null) {
            return false;
        }
        if(i.getType() != Material.AIR) {
            if(i.hasItemMeta()) {
                if(i.getItemMeta().hasLore()) {
                    List<String> lore = i.getItemMeta().getLore();
                    if(lore.size()>0) {
                        for(String loreline : lore) {
                            String newline = ChatColor.stripColor(loreline);
                            if(newline.equals(loreinfo)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    List<LivingEntity> breaths = new ArrayList<LivingEntity>();
    List<LivingEntity> eyes = new ArrayList<LivingEntity>();

    public void loopEyes() {
        List<LivingEntity> eyesCopy = new ArrayList<LivingEntity>(eyes);
        for(LivingEntity le : eyesCopy) {
            if(existMonster(le)) {
                BoundingBox bb = le.getBoundingBox();
                double heightAdd = bb.getHeight() / 2.0;
                double width = (bb.getWidthX() + bb.getWidthZ()) / 2.0;
                if(randor.nextBoolean()) {
                    le.getWorld().spawnParticle(Particle.SQUID_INK, le.getLocation().add(0, heightAdd, 0), 1, width/4.0, heightAdd/2.0, width/4.0, 0.0005, null, true);
                }
                le.getWorld().spawnParticle(Particle.DRAGON_BREATH, le.getLocation().add(0, le.getEyeHeight(), 0), 1, 0.2, 0.2, 0.2, 0.0005, null, true);
            }
            else {
                eyes.remove(le);
            }
        }
    }

    @EventHandler
    public void entityTargetEvent(EntityTargetEvent e) {
        if(e.getEntity() instanceof Monster) {
            if(dragonworlds.contains(e.getEntity().getWorld().getName())) {
                Monster m = (Monster) e.getEntity();
                boolean curse = false;
                if(m.hasMetadata("eyeofdragon")) {
                    if(!eyes.contains(e.getEntity())) {
                        eyes.add((LivingEntity) e.getEntity());
                    }
                }
                else if(m instanceof WitherSkeleton) {
                    if(m.getEquipment().getItemInMainHand()!=null) {
                        if(m.getEquipment().getItemInMainHand().getType() == Material.BLACK_CONCRETE) {
                            if(!eyes.contains(e.getEntity())) {
                                eyes.add((LivingEntity) e.getEntity());
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean existMonster(Entity e) {
        if (e == null) {
            return false;
        }
        if (!(e instanceof Monster)) {
            return false;
        }
        Monster m = (Monster) e;
        if (m.isDead()) {
            return false;
        }
        if (m.getTarget() == null) {
            return false;
        }
        if (m.getTarget().isDead()) {
            return false;
        }
        return true;
    }

    public void loopBreaths(LivingEntity e, int time, int maxtime, int amp, LivingEntity damager) {
        if(exists(e) && time<maxtime) {
            if(randor.nextInt(6)==0) {
                e.damage(1 * amp);
            }

            BoundingBox bb = e.getBoundingBox();
            double heightAdd = bb.getHeight() / 2.0;
            double width = (bb.getWidthX() + bb.getWidthZ()) / 2.0;
            e.getWorld().spawnParticle(Particle.DRAGON_BREATH, e.getLocation().add(0, heightAdd, 0), 1, width/3.0, heightAdd/2.0, width/3.0, 0.0005, null, true);

            Bukkit.getScheduler().runTaskLater(plugin, () -> loopBreaths(e, time+1, maxtime, amp, damager), 2);
        }
        else {
            breaths.remove(e);
            return;
        }
    }

    @EventHandler
    public void onEnderPearlThrow(ProjectileLaunchEvent e) {
        if(!e.isCancelled()) {
            if(e.getEntity() instanceof EnderPearl) {
                if(e.getEntity().getShooter() instanceof Player) {
                    Player p = (Player) e.getEntity().getShooter();
                    if(hasLore(p.getInventory().getItemInMainHand(), "dragonpearl")) {
                        Bukkit.getScheduler().runTaskLater(plugin, () -> replacePearl(p, 0), 2);
                    }
                }
            }
        }
    }

    public void replacePearl(Player p, int threadcount) {
        if((!exists(p))) {
            return;
        }
        ItemStack dragonEye = new ItemStack(Material.ENDER_PEARL);
        ItemMeta im = dragonEye.getItemMeta();
        im.setDisplayName("§fDragon Pearl");
        im.setLore(Arrays.asList(ChatColor.BLACK + "dragonpearl"));
        dragonEye.setItemMeta(im);
        if(threadcount >= 100) {
            p.getWorld().dropItemNaturally(p.getLocation(), dragonEye);
            return;
        }
        if(p.getInventory().getItemInMainHand() == null) {
            p.getInventory().setItemInMainHand(dragonEye);
            return;
        }
        else {
            ItemStack i = p.getInventory().getItemInMainHand();
            if(i.getType() == Material.AIR) {
                p.getInventory().setItemInMainHand(dragonEye);
                return;
            }
            else if(i.getType() == Material.ENDER_PEARL) {
                Bukkit.getScheduler().runTaskLater(plugin, () -> replacePearl(p, threadcount+1), 2);
            }
            else {
                p.getWorld().dropItemNaturally(p.getLocation(), dragonEye);
                return;
            }
        }
    }

    @EventHandler
    public void playerHitMob(EntityDamageByEntityEvent e) {
        if(!e.isCancelled()) {
            if(e.getDamager() instanceof Player && e.getEntity() instanceof LivingEntity) {
                Player p = (Player) e.getDamager();
                LivingEntity le = (LivingEntity) e.getEntity();
                if(hasLore(p.getInventory().getItemInMainHand(), "Dragon's Breath I")) {
                    loopBreaths(le, 0, ((randor.nextInt(6)+5)*10), 1, p);
                }
                else if(hasLore(p.getInventory().getItemInMainHand(), "Dragon's Breath II")) {
                    loopBreaths(le, 0, ((randor.nextInt(6)+7)*10), 2, p);
                }
                else if(hasLore(p.getInventory().getItemInMainHand(), "Dragon's Breath III")) {
                    loopBreaths(le, 0, ((randor.nextInt(6)+9)*10), 3, p);
                }
                if(hasLore(p.getInventory().getItemInMainHand(), "Teleportation I")) {
                    if(randor.nextInt(5)==0) {
                        Location l = getRandLoc(le.getLocation().add(0, 1, 0), 1);
                        le.teleport(l);
                        le.getWorld().playSound(l, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                        le.getWorld().spawnParticle(Particle.SPELL_WITCH, l, 25, 0.4, 1, 0.4, 0.0001);
                    }
                }
                else if(hasLore(p.getInventory().getItemInMainHand(), "Teleportation II")) {
                    if(randor.nextInt(4)==0) {
                        Location l = getRandLoc(le.getLocation().add(0, 2, 0), 1);
                        le.teleport(l);
                        le.getWorld().playSound(l, Sound.ENTITY_ENDERMAN_TELEPORT, 1, (float) .5);
                        le.getWorld().spawnParticle(Particle.SPELL_WITCH, l, 25, 0.4, 1, 0.4, 0.0001);
                    }
                }
                else if(hasLore(p.getInventory().getItemInMainHand(), "Teleportation III")) {
                    if(randor.nextInt(3)==0) {
                        Location l = getRandLoc(le.getLocation().add(0, 4, 0), 2);
                        le.teleport(l);
                        le.getWorld().playSound(l, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 0);
                        le.getWorld().spawnParticle(Particle.SPELL_WITCH, l, 25, 0.4, 1, 0.4, 0.0001);
                    }
                }
            }
            else if(e.getDamager() instanceof Monster && e.getEntity() instanceof LivingEntity) {
                LivingEntity le = (LivingEntity) e.getEntity();
                Monster m = (Monster) e.getDamager();
                if(dragonworlds.contains(m.getWorld().getName())) {
                    boolean curse = false;
                    if(m.hasMetadata("eyeofdragon")) {
                        curse = true;
                    }
                    else if(m instanceof WitherSkeleton) {
                        if(m.getEquipment().getItemInMainHand()!=null) {
                            if(m.getEquipment().getItemInMainHand().getType() == Material.BLACK_CONCRETE) {
                                curse = true;
                            }
                        }
                    }
                    if(curse) {
                        loopBreaths(le, 0, ((randor.nextInt(6)+7)*10), 1, m);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onCoralFade(BlockFadeEvent e) {
        if (dragonworlds.contains(e.getBlock().getWorld().getName())) {
            if(e.getBlock().getType().name().toLowerCase().contains("coral")) {
                e.setCancelled(true);
            }
        }
    }

    public List<EnderDragon> enderdragons = new ArrayList<EnderDragon>();

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
            double y = y0 + (radius * Math.sin(phi) * Math.sin(theta));
            double z = z0 + (radius * Math.cos(phi));
            return new Location(l.getWorld(), x, y, z, randor.nextInt(360), randor.nextInt(360));
        }
        return null;
    }

    public boolean exists(Entity e) {
        if(e == null) {
            return false;
        }
        if(e.isDead()) {
            return false;
        }
        return true;
    }

    @EventHandler
    public void onEnderdragonTarget(EntityDamageByEntityEvent e) {
        if(dragonworlds.contains(e.getEntity().getWorld().getName())) {
            if(e.getEntity() instanceof EnderDragon || e.getDamager() instanceof EnderDragon) {
                if(e.getEntity() instanceof EnderDragon) {
                    if(!enderdragons.contains((EnderDragon) e.getEntity())) {
                        enderdragons.add(((EnderDragon) e.getEntity()));
                    }
                }
                else if(e.getDamager() instanceof EnderDragon) {
                    if(!enderdragons.contains((EnderDragon) e.getDamager())) {
                        enderdragons.add(((EnderDragon) e.getDamager()));
                    }
                    e.setDamage(e.getFinalDamage()*2);
                }
            }
        }
    }

    @EventHandler
    public void onEnderdragonTargeted(EntityTargetEvent e) {
        if(dragonworlds.contains(e.getEntity().getWorld().getName())) {
            if(e.getEntity() instanceof Enderman && e.getTarget() instanceof EnderDragon) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void wasHit(EntityDamageByEntityEvent e) {
        if(dragonworlds.contains(e.getEntity().getWorld().getName())) {
            if(e.getEntity() instanceof Player) {
                Player damaged = (Player) e.getEntity();
                if (e.getDamager() instanceof Enderman) {
                    Enderman attacker = (Enderman) e.getDamager();
                    if(attacker.getCustomName()!=null) {
                        return;
                    }
                    if (randor.nextInt(10) < 3) {
                        Location l = getRandLoc(damaged.getLocation().add(0, 1, 0), 1);
                        damaged.teleport(l);
                        damaged.getWorld().playSound(l, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                        damaged.getWorld().spawnParticle(Particle.SPELL_WITCH, l, 25, 0.4, 1, 0.4, 0.0001);
                    }
                }
            }
        }
    }

    HashMap<Entity, LivingEntity> crystals = new HashMap<Entity, LivingEntity>();

    public void loopDragons() {
        List<EnderDragon> enderdragonsCopy = new ArrayList<EnderDragon>(enderdragons);
        for(EnderDragon ed : enderdragonsCopy) {
            if(exists(ed)) {
                if(ed.getWorld().getPlayers().size() != 0) {
                    int stage = (int) ((ed.getHealth() / ed.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue()) * 10) + 1;
                    //11 == stage 1 , 1 == stage 10
                    doRandomGrowl(ed, true);
                    List<Player> players = ed.getWorld().getPlayers();
                    List<Player> playersNear = new ArrayList<Player>();
                    for(Player p : players) {
                        if(!playersNear.contains(p)) {
                            double dist = p.getLocation().distanceSquared(ed.getLocation());
                            if(dist<=14400) {
                                playersNear.add(p);
                                if(stage<4 && dist<=32) {
                                    if(!teleportes.contains(p)) {
                                        doTeleportSmoke(ed.getEyeLocation(), p, 0, randor.nextInt(2)+3);
                                    }
                                }
                            }
                        }
                    }
                    if(playersNear.size()>0) {
                        Player p = playersNear.get(randor.nextInt(playersNear.size()));
                        doEnderdragonEffect(p, ed, stage);
                    }
                }
                else {
                    enderdragons.remove(ed);
                }
            }
            else {
                enderdragons.remove(ed);
            }
        }
    }

    List<Player> teleportes = new ArrayList<Player>();

    public void doTeleportSmoke(Location l, Player p, int times, int maxTimes) {
        if(times == 0) {
            teleportes.add(p);
        }
        if((!exists(p)) || times >= maxTimes || (!teleportes.contains(p))) {
            if(teleportes.contains(p)) {
                teleportes.remove(p);
            }
            if(exists(p)) {
                Vector v = p.getLocation().toVector().subtract(l.toVector()).normalize().add(new Vector(0, 0.5, 0)).multiply(2.6);
                p.setVelocity(p.getVelocity().add(v));
            }
            return;
        }
        else {
            p.teleport(getRandLoc(l.clone(), 8));
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 2, 0);
            p.getWorld().spawnParticle(Particle.SPELL_WITCH, p.getLocation(), 25, 0.4, 1, 0.4, 0.0001);
            Bukkit.getScheduler().runTaskLater(plugin, () -> doTeleportSmoke(l, p, times+1, maxTimes), 5);
        }
    }

    public void followPlayer() {
        HashMap<Entity, LivingEntity> crystalsCopy = new HashMap<Entity, LivingEntity>(crystals);
        for(Entity e : crystalsCopy.keySet()) {
            if(exists(e)) {
                LivingEntity p = crystalsCopy.get(e);
                if(exists(p) && (e.getPassengers().size()!=0)) {
                    if(e.getLocation().distanceSquared(p.getLocation())<=4) {
                        e.getWorld().createExplosion(e.getLocation(), 4F, true);
                        e.getWorld().spawnParticle(Particle.SPELL_WITCH, e.getLocation(), 40, 3, 3, 3, 0.01);
                        crystals.remove(e);
                        e.remove();
                        p.damage(10);
                    }
                    Vector v = p.getLocation().toVector().subtract(e.getLocation().toVector()).normalize().multiply(.5);
                    e.setVelocity(v);
                    e.getWorld().spawnParticle(Particle.END_ROD, e.getLocation().clone().add(0, .7, 0), 1, 0.1, 0.1, 0.1, 0.0001);
                    e.getWorld().playSound(e.getLocation(), Sound.BLOCK_BELL_RESONATE, (float) 2.2, 2);
                }
                else {
                    crystals.remove(e);
                    e.remove();
                }
            }
            else {
                crystals.remove(e);
            }
        }
    }

    @EventHandler
    public void projectileHit(ProjectileHitEvent e) {
        if(e.getHitEntity() != null) {
            if(e.getHitEntity().hasMetadata("endercrystal")) {
                e.getHitEntity().getWorld().createExplosion(e.getHitEntity().getLocation(), 4F, true);
                e.getHitEntity().getWorld().spawnParticle(Particle.SPELL_WITCH, e.getHitEntity().getLocation(), 40, 3, 3, 3, 0.01);
                crystals.remove(e.getHitEntity());
                e.getHitEntity().remove();
            }
        }
    }

    @EventHandler
    public void playerDamaged(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            if(dragonworlds.contains(e.getEntity().getWorld().getName())) {
                if(enderdragons.size()>0) {
                    if(e.getCause() != DamageCause.ENTITY_ATTACK && e.getCause() != DamageCause.MAGIC && e.getCause() != DamageCause.FALL && e.getCause() != DamageCause.ENTITY_EXPLOSION && e.getCause() != DamageCause.BLOCK_EXPLOSION) {
                        e.setDamage(e.getDamage() * 5);
                    }
                    else if(e.getCause() == DamageCause.BLOCK_EXPLOSION || e.getCause() == DamageCause.ENTITY_EXPLOSION) {
                        e.setDamage(e.getDamage() * 7);
                    }
                    else if(e.getCause() == DamageCause.ENTITY_ATTACK) {
                        e.setDamage(e.getDamage() * 2);
                    }
                    else if(e.getCause() == DamageCause.FALL) {
                        e.setDamage(e.getDamage() / 2);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEnderdragonDamage(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof EnderDragon) {
            if(e.getCause() == DamageCause.ENTITY_ATTACK) {
                e.setDamage(e.getFinalDamage() * 12);
            }
        }
    }

    public void doEnderdragonEffect(Player p, EnderDragon ed, int stage) {
        int choice = randor.nextInt(8);
        int divider = 1;
        if(stage < 3) {
            divider = 2;
            createEndDragonMist(ed);
        }
        if(ed.getPhase() == Phase.LAND_ON_PORTAL) {
            if(randor.nextInt(10)==0) {
                ed.setPhase(Phase.LEAVE_PORTAL);
            }
        }
        if(stage < 11) {
            if(randor.nextInt(5/divider)==0 && choice==0) {
                for(Entity e : p.getNearbyEntities(55, 55, 55)) {
                    if(e instanceof Enderman) {
                        e.getWorld().spawnParticle(Particle.SPELL_WITCH, ((Enderman) e).getEyeLocation(), 18, 0.2, 0.2, 0.2, 0.0001, null, true);
                        e.getWorld().playSound(ed.getEyeLocation(), Sound.ENTITY_ENDER_DRAGON_AMBIENT, SoundCategory.HOSTILE, 8, (float) 1.5);
                        e.getWorld().playSound(ed.getEyeLocation(), Sound.ENTITY_ENDERMAN_STARE, SoundCategory.HOSTILE, 5, (float) 2);
                        ((Monster) e).setTarget(p);
                        break;
                    }
                }
            }
            if(stage < 9) {
                if(randor.nextInt(7/divider)==0 && choice==1) {
                    Entity e1 = ed.getWorld().spawnEntity(ed.getEyeLocation().add(0, 3, 0), EntityType.ENDER_CRYSTAL);
                    Entity e2 = ed.getWorld().spawnEntity(ed.getEyeLocation().add(0, 3, 0), EntityType.BAT);
                    e2.addPassenger(e1);
                    e2.setSilent(true);
                    e2.setInvulnerable(true);
                    ((EnderCrystal) e1).setShowingBottom(false);
                    e2.setMetadata("endercrystal", new FixedMetadataValue(plugin, 0));
                    ((LivingEntity) e2).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1, false, false));
                    crystals.put(e2, p);
                }
                if(randor.nextInt(8/divider)==0 && choice==2) {
                    ed.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, ed.getEyeLocation().add(0, 3, 0), 40, 2, 2, 2, 0.01, null, true);
                    Phantom e1 = (Phantom) ed.getWorld().spawnEntity(ed.getEyeLocation().add(0, 3, 0), EntityType.PHANTOM);
                    MobDisguise firstDisguise = new MobDisguise(DisguiseType.ENDER_DRAGON);
                    DisguiseAPI.disguiseEntity(e1, firstDisguise);
                    e1.setSize(20);
                    e1.setTarget(p);
                }
                if(randor.nextInt(8/divider)==0 && choice==3) {
                    if(p.isOnGround()) {
                        makeLightLine(p, ed);
                        Location l = p.getLocation().clone();
                        Bukkit.getScheduler().runTaskLater(plugin, () -> p.getWorld().playSound(l, Sound.ENTITY_ENDER_EYE_LAUNCH, 2, 0), 10);
                        Bukkit.getScheduler().runTaskLater(plugin, () -> p.getWorld().playSound(l, Sound.ENTITY_ENDER_EYE_LAUNCH, 2, 0), 20);
                        Bukkit.getScheduler().runTaskLater(plugin, () -> p.getWorld().playSound(l, Sound.ENTITY_ENDER_EYE_LAUNCH, 2, 0), 40);
                        Bukkit.getScheduler().runTaskLater(plugin, () -> p.getWorld().playSound(l, Sound.ENTITY_ENDER_EYE_LAUNCH, 2, 0), 60);
                        Bukkit.getScheduler().runTaskLater(plugin, () -> doRootSoon(l), 65);
                    }
                }
                if(stage < 8) {
                    if(randor.nextInt(4/divider)==0 && choice==4) {
                        makeFireballShoot(ed, p);
                    }
                    if(randor.nextInt(3/divider)==0) {
                        createLightning(p);
                    }
                    if(stage < 6) {
                        if(randor.nextInt(5/divider)==0 && choice==5) {
                            dropFire(ed, randor.nextInt(50)+50, 1, p);
                        }
                        if(randor.nextInt(6/divider)==0) {
                            createLightning(p);
                        }
                        if(randor.nextInt(4/divider)==0 && choice==6) {
                            dropMeteor(p.getLocation().clone().add(0, 100, 0));
                        }
                        if(stage < 6) {
                            createDragonMist(ed);
                            if(randor.nextInt(4/divider)==0 && choice==7) {
                                if(ed.getPhase() == Phase.CIRCLING) {
                                    Location l2 = getRandLoc(ed.getEyeLocation(), 12);
                                    if(l2.getBlock().isPassable()) {
                                        BoundingBox bb = ed.getBoundingBox();
                                        double heightAdd = bb.getHeight() / 2.0;
                                        double width = (bb.getWidthX() + bb.getWidthZ()) / 2.0;
                                        ed.getWorld().spawnParticle(Particle.SPELL_WITCH, ed.getLocation().add(0, heightAdd, 0), 65, width/3.0, heightAdd/2.0, width/3.0, 0.0005, null, true);
                                        ed.teleport(l2);
                                        ed.getWorld().playSound(ed.getEyeLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 10, 0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void createDragonMist(EnderDragon e) {
        int choice = randor.nextInt(3);
        BoundingBox bb = e.getBoundingBox();
        double heightAdd = bb.getHeight() / 2.0;
        double width = (bb.getWidthX() + bb.getWidthZ()) / 2.0;
        if(choice==0) {
            e.getWorld().spawnParticle(Particle.SPELL_WITCH, e.getLocation().add(0, heightAdd, 0), 5, width/3.0, heightAdd/2.0, width/3.0, 0.0005, null, true);
        }
        else if(choice==1) {
            e.getWorld().spawnParticle(Particle.SMOKE_LARGE, e.getLocation().add(0, heightAdd, 0), 5, width/3.0, heightAdd/2.0, width/3.0, 0.0005, null, true);
        }
        else if(choice==2) {
            e.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, e.getLocation().add(0, heightAdd, 0), 5, width/3.0, heightAdd/2.0, width/3.0, 0.0005, null, true);
        }
    }

    public void createEndDragonMist(EnderDragon e) {
        BoundingBox bb = e.getBoundingBox();
        double heightAdd = bb.getHeight() / 2.0;
        double width = (bb.getWidthX() + bb.getWidthZ()) / 2.0;
        e.getWorld().spawnParticle(Particle.SQUID_INK, e.getLocation().add(0, heightAdd, 0), 30, width/3.0, heightAdd/2.0, width/3.0, 0.0005, null, true);
    }

    @EventHandler
    public void dragonShootEvent(ProjectileLaunchEvent e) {
        if(e.getEntity().getShooter() instanceof EnderDragon) {
            EnderDragon ed = (EnderDragon) e.getEntity().getShooter();
            if(enderdragons.contains(ed)) {
                int stage = (int) ((ed.getHealth() / ed.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue()) * 10) + 1;
                if(stage < 4) {
                    if(e.getEntity() instanceof DragonFireball) {
                        Bukkit.getScheduler().runTaskLater(plugin, () -> ed.launchProjectile(LargeFireball.class, ed.getEyeLocation().getDirection().normalize()), 15);
                        Bukkit.getScheduler().runTaskLater(plugin, () -> ed.launchProjectile(LargeFireball.class, ed.getEyeLocation().getDirection().normalize()), 30);
                        Bukkit.getScheduler().runTaskLater(plugin, () -> ed.launchProjectile(LargeFireball.class, ed.getEyeLocation().getDirection().normalize()), 45);
                    }
                }
            }
        }
    }

    public void spawnInstantFirework(Location l, int power, Color c) {
        Location loc = l;
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        fwm.setPower(power);
        fwm.addEffect(FireworkEffect.builder().withColor(c).flicker(true).build());
        fw.setFireworkMeta(fwm);
        Bukkit.getScheduler().runTaskLater(plugin, () -> fw.detonate(), (long) 2);
    }

    public void spawnColorParticle(Location l, int ammount, int r, int g, int b) {
        for(int count = 0; count < ammount; count++) {
            DustOptions dustOptions = new DustOptions(Color.fromRGB(r, g, b), 1);
            l.getWorld().spawnParticle(Particle.REDSTONE, l, 1, dustOptions);
        }
    }

    public void dropMeteor(Location l) {
        if(l.getY() <= 0) {
            return;
        }
        else {
            if(l.getBlock().isPassable()) {
                l.getWorld().spawnParticle(Particle.LAVA, l, 1, 0, 0, 0, 0.0001, null, true);
                l.getWorld().spawnParticle(Particle.SPELL_WITCH, l, 3, 0, 0, 0, 0.01, null, true);
                l.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, l, 1, 0, 0, 0, 0.001, null, true);
                l.getWorld().playSound(l, Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 4, 0);
                if(randor.nextInt(3)==0) {
                    l.getWorld().playSound(l, Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 4, 0);
                    if(randor.nextInt(3)==0) {
                        l.getWorld().playSound(l, Sound.ENTITY_GENERIC_EXPLODE, 4, 0);
                    }
                }
                Bukkit.getScheduler().runTaskLater(plugin, () -> dropMeteor(l.clone().subtract(0, 1, 0)), 3);
            }
            else {
                makeMeteorImpact(l);
                return;
            }
        }
    }

    public void makeMeteorImpact(Location loc) {
        spawnInstantFirework(loc.clone().add(0, 1, 0), 1, Color.PURPLE);
        Location start = loc.clone().add(0, 1, 0);
        for(int count = 0; count < 25; count++) {
            Location end = getRandLoc(start.clone(), 4).clone().add(0, 1, 0);
            double step = 0.05D;

            Vector line = end.toVector().subtract(start.toVector());
            for (double d = 0; d < line.length()/2.0; d += step) {
                final double dd = d;
                Location l = start.clone().add(line.clone().multiply(dd));
                if(randor.nextBoolean()) {
                    Bukkit.getScheduler().runTaskLater(plugin, () ->  spawnColorParticle(l, 1, 102, 51, 153), (long) (1*(d*5)));
                }
                else {
                    Bukkit.getScheduler().runTaskLater(plugin, () ->  l.getWorld().spawnParticle(Particle.SPELL_WITCH, l, 1, 0, 0, 0, 0.0001, null, true), (long) (1*(d*5)));
                }
            }
            if(randor.nextInt(4)==0) {
                spawnInstantFirework(end, 1, Color.PURPLE);
            }
            if(randor.nextInt(4)==0) {
                loc.getWorld().strikeLightning(end);
            }
        }
        for(Entity e : loc.getWorld().getNearbyEntities(loc, 6.5, 6.5, 6.5)) {
            if((!(e instanceof EnderDragon)) && e instanceof LivingEntity) {
                ((LivingEntity) e).damage(15);
                addPotionEffectBetter(((LivingEntity) e), PotionEffectType.LEVITATION, 80, 1, false, false, false);
                addPotionEffectBetter(((LivingEntity) e), PotionEffectType.SLOW, 80, 1, false, false, false);
                addPotionEffectBetter(((LivingEntity) e), PotionEffectType.CONFUSION, 80, 1, false, false, false);
                addPotionEffectBetter(((LivingEntity) e), PotionEffectType.SLOW_DIGGING, 80, 1, false, false, false);
            }
            Vector v = e.getLocation().toVector().subtract(loc.toVector()).normalize().add(new Vector(0, 0.5, 0)).multiply(2.4);
            e.setVelocity(e.getVelocity().add(v));
        }
        loc.getWorld().playSound(loc, Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 8, (float) 1.8);
        loc.getWorld().createExplosion(loc, 5F);
    }

    public int coinFlip() {
        if(randor.nextBoolean()) {
            return -1;
        }
        return 1;
    }

    public void addPotionEffectBetter(LivingEntity e, PotionEffectType pt, int duration, int amp, boolean ambient, boolean hp, boolean additive) {
        if(e.hasPotionEffect(pt)) {
            int level = amp;
            if(additive == true) {
                level = e.getPotionEffect(pt).getAmplifier() + (amp+1);
            }
            if(level < 200) {
                e.removePotionEffect(pt);
                e.addPotionEffect(new PotionEffect(pt, duration, level, ambient, hp));
            }
            else {
                e.removePotionEffect(pt);
                e.addPotionEffect(new PotionEffect(pt, duration, 200, ambient, hp));
            }
        }
        else {
            e.addPotionEffect(new PotionEffect(pt, duration, amp, ambient, hp));
        }
    }

    public void createLightning(Player p) {
        Location l = p.getLocation().clone().add(coinFlip() * (randor.nextInt(45)), 5, coinFlip() * (randor.nextInt(45)));
        l.getWorld().strikeLightning(l);
    }

    public void doRandomGrowl(EnderDragon e, boolean first) {
        if(randor.nextInt(3)==0) {
            if(randor.nextInt(3)==0) {
                if(randor.nextInt(3)!=0) {
                    Bukkit.getScheduler().runTaskLater(plugin, () -> e.getWorld().playSound(e.getEyeLocation(), Sound.ENTITY_RAVAGER_ROAR, SoundCategory.HOSTILE, 8, 0), randor.nextInt(5)+9);
                }
                else {
                    Bukkit.getScheduler().runTaskLater(plugin, () -> e.getWorld().playSound(e.getEyeLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, SoundCategory.HOSTILE, 8, 0), randor.nextInt(5)+9);
                }
            }
        }
        else {
            if(randor.nextInt(3)==0) {
                if(randor.nextInt(3)!=0) {
                    e.getWorld().playSound(e.getEyeLocation(), Sound.ENTITY_RAVAGER_ROAR, SoundCategory.HOSTILE, 8, 0);
                }
                else {
                    e.getWorld().playSound(e.getEyeLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, SoundCategory.HOSTILE, 8, 0);
                }
            }
        }
    }

    public void makeFireballShoot(EnderDragon ed, Player p) {
        int number = randor.nextInt(5) + 4;
        Location l = ed.getEyeLocation().clone();
        for(int count = 0; count < number; count++) {
            Location newL = l.clone().add(coinFlip() * (randor.nextInt(40)+10), randor.nextInt(20), coinFlip() * (randor.nextInt(40)+10));
            Entity e = p.getWorld().spawnEntity(newL, EntityType.ENDERMAN);
            ((LivingEntity) e).setAI(false);
            ((LivingEntity) e).setInvulnerable(true);
            ((LivingEntity) e).getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
            addPotionEffectBetter(((LivingEntity) e), PotionEffectType.INVISIBILITY, 999999, 1, false, false, false);
            e.teleport(e.getLocation().setDirection(p.getLocation().toVector().subtract(e.getLocation().toVector()).normalize()));
            Bukkit.getScheduler().runTaskLater(plugin, () -> shoot(e), 40);
        }
    }

    public void shoot(Entity e) {
        e.getWorld().spawnParticle(Particle.FLAME,e.getLocation(), 20, 0, 0, 0, 0.1, null, true);
        e.getWorld().playSound(e.getLocation(), Sound.ITEM_BUCKET_FILL_LAVA, 8, 0);
        Entity proj = ((LivingEntity) e).launchProjectile(LargeFireball.class);
        proj.setVelocity(e.getLocation().getDirection().multiply(1.2));
        Bukkit.getScheduler().runTaskLater(plugin, () -> removeShooter(e), 500);
    }

    public void removeShooter(Entity e) {
        if(exists(e)) {
            e.remove();
        }
    }

    @EventHandler
    public void projHit(ProjectileHitEvent e) {
        if(e.getEntity() instanceof LargeFireball) {
            if(e.getEntity().getShooter() instanceof Enderman) {
                LivingEntity enderman = (LivingEntity) e.getEntity().getShooter();
                if(exists(enderman)) {
                    enderman.remove();
                }
            }
        }
    }

    public void dropFire(EnderDragon ed, int maxcount, int count, Player p) {
        if(count >= maxcount) {
            return;
        }
        if(!exists(ed)) {
            return;
        }
        if(randor.nextInt(3)==0) {
            Entity e = ed.getWorld().spawnFallingBlock(ed.getEyeLocation().add(coinFlip() * (randor.nextInt(4)), 0, coinFlip() * (randor.nextInt(4))), Material.FIRE.createBlockData());
            ed.getWorld().playSound(e.getLocation(), Sound.ITEM_FIRECHARGE_USE, 8, 0);
            e.setVelocity(p.getLocation().toVector().subtract(e.getLocation().toVector()).normalize().multiply(2.5));
        }
        Bukkit.getScheduler().runTaskLater(plugin, () -> dropFire(ed, maxcount, count+1, p), 1);
    }

    public void makeLightLine(Player p, EnderDragon ed) {
        Location start = p.getLocation().clone().add(0, 1, 0);
        start.getWorld().playSound(start, Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 2, (float) 0);
        Location end = ed.getEyeLocation().clone().add(0, 1, 0);
        double step = 0.1D;

        Vector line = end.toVector().subtract(start.toVector());
        for (double d = 0; d < line.length()/4.0; d += step) {
            final double dd = d;
            Bukkit.getScheduler().runTaskLater(plugin, () ->  p.getWorld().spawnParticle(Particle.END_ROD, start.clone().add(line.clone().multiply(dd)), 1, 0, 0, 0, 0.001), (long) (1*(d*10)));
        }
    }

    public void doRootSoon(Location l) {
        if(l.subtract(0, 1, 0).getBlock().getType().name().toLowerCase().contains("end")) {
            Location l2 = l.clone().subtract(0, 3, 0);
            for(int i = 0; i < randor.nextInt(6)+12; i++) {
                final int i2 = i;
                Bukkit.getScheduler().runTaskLater(plugin, () -> doRoot(l.add(0, 1, 0), i2), i*10);
            }
        }
    }

    public void doRoot(Location l, int i) {
        Location copy = l.clone();
        int size = 5-i/2;
        int radius = size;
        int cx = copy.getBlockX();
        int cy = copy.getBlockY();
        int cz = copy.getBlockZ();

        for (int x = cx - radius; x <= cx + radius; x++) {
            for (int z = cz - radius; z <= cz + radius; z++) {
                double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + (0);

                if (dist < radius * radius) {
                    Location l2 = new Location(copy.getWorld(), x, copy.getY(), z);
                    if(randor.nextInt(10)==2) {
                        l2.getWorld().playSound(l2, Sound.BLOCK_STONE_HIT, 1, 2);
                    }
                    else {
                        if(l2.getBlock().getType().name().toLowerCase().contains("air")) {
                            if(randor.nextBoolean()==true) {
                                l2.getBlock().setType(Material.END_STONE);
                                l2.getWorld().spawnParticle(Particle.BLOCK_CRACK, l2, 4, Material.END_STONE.createBlockData());
                            }
                            else {
                                l2.getBlock().setType(Material.END_STONE_BRICKS);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void dragonDeathEvent(EntityDeathEvent e) {
        if(e.getEntity() instanceof EnderDragon) {
            EnderDragon ed = (EnderDragon) e.getEntity();
            if(dragonworlds.contains(ed.getWorld().getName())) {
                List<ItemStack> loot = getDragonLoot();
                for(ItemStack item : loot) {
                    Location l = ed.getLocation().add(coinFlip() * (randor.nextInt(6)+6), 0, coinFlip() * (randor.nextInt(6)+6));
                    l.getWorld().dropItemNaturally(l, item).setGlowing(true);
                }
            }
        }
    }

    public PotionEffectType getRandPotion() {
        int choice = randor.nextInt(8);
        if(choice == 0) {
            return PotionEffectType.FAST_DIGGING;
        }
        else if(choice == 1) {
            return PotionEffectType.CONFUSION;
        }
        else if(choice == 2) {
            return PotionEffectType.BLINDNESS;
        }
        else if(choice == 3) {
            return PotionEffectType.DAMAGE_RESISTANCE;
        }
        else if(choice == 4) {
            return PotionEffectType.HUNGER;
        }
        else if(choice == 5) {
            return PotionEffectType.HEALTH_BOOST;
        }
        else if(choice == 6) {
            return PotionEffectType.SATURATION;
        }
        else if(choice == 7) {
            return PotionEffectType.SLOW_DIGGING;
        }
        return PotionEffectType.ABSORPTION;
    }

    public List<ItemStack> getDragonLoot(){
        List<ItemStack> loot = new ArrayList<ItemStack>();
        if(randor.nextInt(5)==0) {
            ItemStack dragonEye = new ItemStack(Material.ENDER_PEARL);
            ItemMeta im = dragonEye.getItemMeta();
            im.setDisplayName("§fDragon Pearl");
            im.setLore(Arrays.asList(ChatColor.BLACK + "dragonpearl"));
            dragonEye.setItemMeta(im);
            loot.add(dragonEye);
        }
        for(int count = 0; count < 3; count++) {
            int amp = randor.nextInt(2);
            int time = 1200;
            if(randor.nextBoolean()) {
                time = 2400;
            }
            PotionEffectType pt = getRandPotion();
            ItemStack item = null;
            int type = randor.nextInt(3);
            if(type == 0) {
                item = new ItemStack(Material.POTION);
            }
            else if(type == 1) {
                item = new ItemStack(Material.SPLASH_POTION);
            }
            else{
                item = new ItemStack(Material.LINGERING_POTION);
            }
            PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
            potionMeta.addCustomEffect(new PotionEffect(pt, time, amp), true);
            if(pt == PotionEffectType.FAST_DIGGING) {
                potionMeta.setColor(Color.YELLOW);
                potionMeta.setDisplayName("§fPotion of Haste");
            }
            else if(pt == PotionEffectType.CONFUSION) {
                potionMeta.setColor(Color.OLIVE);
                potionMeta.setDisplayName("§fPotion of Nausea");
            }
            else if(pt == PotionEffectType.BLINDNESS) {
                potionMeta.setColor(Color.BLACK);
                potionMeta.setDisplayName("§fPotion of Blindness");
            }
            else if(pt == PotionEffectType.DAMAGE_RESISTANCE) {
                potionMeta.setColor(Color.fromRGB(219, 78, 78));
                potionMeta.setDisplayName("§fPotion of Damage Resistance");
            }
            else if(pt == PotionEffectType.HUNGER) {
                potionMeta.setColor(Color.fromRGB(121, 96, 76));
                potionMeta.setDisplayName("§fPotion of Hunger");
            }
            else if(pt == PotionEffectType.HEALTH_BOOST) {
                potionMeta.setColor(Color.RED);
                potionMeta.setDisplayName("§fPotion of Health Boost");
            }
            else if(pt == PotionEffectType.SATURATION) {
                potionMeta.setColor(Color.fromRGB(11, 102, 35));
                potionMeta.setDisplayName("§fPotion of Saturation");
            }
            else if(pt == PotionEffectType.SLOW_DIGGING) {
                potionMeta.setColor(Color.SILVER);
                potionMeta.setDisplayName("§fPotion of Mining Fatigue");
            }
            item.setItemMeta(potionMeta);
            loot.add(item);
        }
        if(randor.nextInt(5)==0) {
            ItemStack dragonSword = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta im = dragonSword.getItemMeta();
            if(randor.nextBoolean()) {
                im.setLore(Arrays.asList(ChatColor.GRAY + "Dragon's Breath I"));
            }
            else {
                if(randor.nextBoolean()) {
                    im.setLore(Arrays.asList(ChatColor.GRAY + "Dragon's Breath II"));
                }
                else {
                    im.setLore(Arrays.asList(ChatColor.GRAY + "Dragon's Breath III"));
                }
            }
            dragonSword.setItemMeta(im);
            dragonSword.addUnsafeEnchantment(Enchantment.LURE, 200);
            ItemMeta itemmeta2 = dragonSword.getItemMeta();
            itemmeta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            dragonSword.setItemMeta(itemmeta2);
            loot.add(dragonSword);
        }
        else if(randor.nextInt(5)==0) {
            ItemStack dragonSword = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta im = dragonSword.getItemMeta();
            if(randor.nextBoolean()) {
                im.setLore(Arrays.asList(ChatColor.GRAY + "Teleportation I"));
            }
            else {
                if(randor.nextBoolean()) {
                    im.setLore(Arrays.asList(ChatColor.GRAY + "Teleportation II"));
                }
                else {
                    im.setLore(Arrays.asList(ChatColor.GRAY + "Teleportation III"));
                }
            }
            dragonSword.setItemMeta(im);
            dragonSword.addUnsafeEnchantment(Enchantment.LURE, 200);
            ItemMeta itemmeta2 = dragonSword.getItemMeta();
            itemmeta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            dragonSword.setItemMeta(itemmeta2);
            loot.add(dragonSword);
        }
        if(randor.nextInt(3)==0) {
            loot.add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, randor.nextInt(7)+3));
        }
        if(randor.nextInt(2)==0) {
            loot.add(new ItemStack(Material.DIAMOND, randor.nextInt(16)+5));
        }
        if(randor.nextInt(2)==0) {
            loot.add(new ItemStack(Material.OBSIDIAN, randor.nextInt(32)+32));
        }
        if(randor.nextInt(4)==0) {
            ItemStack i = null;
            int choice = randor.nextInt(5);
            if(choice == 0) {
                i = new ItemStack(Material.EMERALD, 1);
            }
            else if(choice == 1) {
                i = new ItemStack(Material.FIRE_CHARGE, 1);
            }
            else if(choice == 2) {
                i = new ItemStack(Material.CYAN_DYE, 1);
            }
            else if(choice == 3) {
                i = new ItemStack(Material.MAGMA_CREAM, 1);
            }
            else if(choice == 4) {
                i = new ItemStack(Material.POPPED_CHORUS_FRUIT, 1);
            }
            ItemMeta im = i.getItemMeta();
            List<String> lore = new ArrayList<String>();
            lore.add(ChatColor.BLACK + "Nether Artifact");
            if(choice == 0) {
                im.setDisplayName("§2Nether Artifact");
            }
            else if(choice == 1) {
                im.setDisplayName("§8Nether Artifact");
            }
            else if(choice == 2) {
                im.setDisplayName("§3Nether Artifact");
            }
            else if(choice == 3) {
                im.setDisplayName("§6Nether Artifact");
            }
            else if(choice == 4) {
                im.setDisplayName("§5Nether Artifact");
            }
            im.setLore(lore);
            i.setItemMeta(im);
            loot.add(i);
        }
        if(randor.nextInt(2)==0) {
            int toolAmmount = randor.nextInt(4) + 1;
            for(int count = 0; count < toolAmmount; count++) {
                loot.add(getHighLevelItem());
            }
        }
        return loot;
    }

    public ItemStack getHighLevelItem() {
        int materialChoice = randor.nextInt(3);
        int toolType = randor.nextInt(10);
        int enchantAmp1 = randor.nextInt(6)+1;
        int enchantAmp2 = randor.nextInt(3)+1;
        int enchantAmp3 = randor.nextInt(1)+1;
        int enchantAmp4 = randor.nextInt(7)+1;
        ItemStack item = null;
        if(materialChoice == 0) {
            if(toolType == 0) {
                item = new ItemStack(Material.IRON_AXE);
            }
            else if(toolType == 1){
                item = new ItemStack(Material.IRON_BOOTS);
            }
            else if(toolType == 2){
                item = new ItemStack(Material.IRON_CHESTPLATE);
            }
            else if(toolType == 3){
                item = new ItemStack(Material.IRON_HELMET);
            }
            else if(toolType == 4){
                item = new ItemStack(Material.IRON_LEGGINGS);
            }
            else if(toolType == 5){
                item = new ItemStack(Material.IRON_SWORD);
            }
            else if(toolType == 6){
                item = new ItemStack(Material.IRON_HOE);
            }
            else if(toolType == 7){
                item = new ItemStack(Material.IRON_PICKAXE);
            }
            else if(toolType == 8){
                item = new ItemStack(Material.IRON_SWORD);
            }
            else if(toolType == 9){
                item = new ItemStack(Material.IRON_SHOVEL);
            }
        }
        else if(materialChoice == 1) {
            if(toolType == 0) {
                item = new ItemStack(Material.GOLDEN_AXE);
            }
            else if(toolType == 1){
                item = new ItemStack(Material.GOLDEN_BOOTS);
            }
            else if(toolType == 2){
                item = new ItemStack(Material.GOLDEN_CHESTPLATE);
            }
            else if(toolType == 3){
                item = new ItemStack(Material.GOLDEN_HELMET);
            }
            else if(toolType == 4){
                item = new ItemStack(Material.GOLDEN_LEGGINGS);
            }
            else if(toolType == 5){
                item = new ItemStack(Material.GOLDEN_SWORD);
            }
            else if(toolType == 6){
                item = new ItemStack(Material.GOLDEN_HOE);
            }
            else if(toolType == 7){
                item = new ItemStack(Material.GOLDEN_PICKAXE);
            }
            else if(toolType == 8){
                item = new ItemStack(Material.GOLDEN_SWORD);
            }
            else if(toolType == 9){
                item = new ItemStack(Material.GOLDEN_SHOVEL);
            }
        }
        else if(materialChoice == 2) {
            if(toolType == 0) {
                item = new ItemStack(Material.DIAMOND_AXE);
            }
            else if(toolType == 1){
                item = new ItemStack(Material.DIAMOND_BOOTS);
            }
            else if(toolType == 2){
                item = new ItemStack(Material.DIAMOND_CHESTPLATE);
            }
            else if(toolType == 3){
                item = new ItemStack(Material.DIAMOND_HELMET);
            }
            else if(toolType == 4){
                item = new ItemStack(Material.DIAMOND_LEGGINGS);
            }
            else if(toolType == 5){
                item = new ItemStack(Material.DIAMOND_SWORD);
            }
            else if(toolType == 6){
                item = new ItemStack(Material.DIAMOND_HOE);
            }
            else if(toolType == 7){
                item = new ItemStack(Material.DIAMOND_PICKAXE);
            }
            else if(toolType == 8){
                item = new ItemStack(Material.DIAMOND_SWORD);
            }
            else if(toolType == 9){
                item = new ItemStack(Material.DIAMOND_SHOVEL);
            }
        }
        String itemname = item.getType().name().toLowerCase();
        int enchantAmmount = randor.nextInt(3)+1;
        if(randor.nextInt(5)==0) {
            enchantAmmount++;
        }
        if(itemname.contains("boot")||itemname.contains("helmet")||itemname.contains("chestplate")||itemname.contains("leg")) {
            for(int count = 0; count < enchantAmmount; count++) {
                int amp = 0;
                if(count == 0) {
                    amp = enchantAmp1;
                }
                else if(count == 1) {
                    amp = enchantAmp2;
                }
                else if(count == 2) {
                    amp = enchantAmp3;
                }
                else if(count == 3) {
                    amp = enchantAmp4;
                }
                int enchantNum = randor.nextInt(13);
                Enchantment enchant = null;
                if(enchantNum == 0) {
                    enchant = Enchantment.DURABILITY;
                }
                else if(enchantNum == 1) {
                    enchant = Enchantment.BINDING_CURSE;
                }
                else if(enchantNum == 2) {
                    enchant = Enchantment.VANISHING_CURSE;
                }
                else if(enchantNum == 3) {
                    enchant = Enchantment.PROTECTION_FIRE;
                }
                else if(enchantNum == 4) {
                    if(itemname.contains("boot")) {
                        enchant = Enchantment.DEPTH_STRIDER;
                    }
                }
                else if(enchantNum == 5) {
                    if(itemname.contains("boot")) {
                        enchant = Enchantment.FROST_WALKER;
                    }
                }
                else if(enchantNum == 6) {
                    if(itemname.contains("helmet")) {
                        enchant = Enchantment.OXYGEN;
                    }
                }
                else if(enchantNum == 7) {
                    enchant = Enchantment.PROTECTION_ENVIRONMENTAL;
                }
                else if(enchantNum == 8) {
                    enchant = Enchantment.PROTECTION_EXPLOSIONS;
                }
                else if(enchantNum == 9) {
                    enchant = Enchantment.PROTECTION_FALL;
                }
                else if(enchantNum == 10) {
                    enchant = Enchantment.PROTECTION_PROJECTILE;
                }
                else if(enchantNum == 11) {
                    enchant = Enchantment.THORNS;
                }
                else if(enchantNum == 12) {
                    if(itemname.contains("boot")) {
                        enchant = Enchantment.WATER_WORKER;
                    }
                }
                if(enchant != null) {
                    item.addUnsafeEnchantment(enchant, amp);
                }
            }
            return item;
        }
        else if(itemname.contains("pickaxe")) {
            for(int count = 0; count < enchantAmmount; count++) {
                int amp = 0;
                if(count == 0) {
                    amp = enchantAmp1;
                }
                else if(count == 1) {
                    amp = enchantAmp2;
                }
                else if(count == 2) {
                    amp = enchantAmp3;
                }
                else if(count == 3) {
                    amp = enchantAmp4;
                }
                int enchantNum = randor.nextInt(6);
                Enchantment enchant = null;
                if(enchantNum == 0) {
                    enchant = Enchantment.DIG_SPEED;
                }
                else if(enchantNum == 1) {
                    enchant = Enchantment.DURABILITY;
                }
                else if(enchantNum == 2) {
                    enchant = Enchantment.BINDING_CURSE;
                }
                else if(enchantNum == 3) {
                    enchant = Enchantment.LOOT_BONUS_BLOCKS;
                }
                else if(enchantNum == 4) {
                    enchant = Enchantment.VANISHING_CURSE;
                }
                else if(enchantNum == 5) {
                    enchant = Enchantment.SILK_TOUCH;
                }
                item.addUnsafeEnchantment(enchant, amp);
            }
            return item;
        }
        else if(itemname.contains("axe")) {
            for(int count = 0; count < enchantAmmount; count++) {
                int amp = 0;
                if(count == 0) {
                    amp = enchantAmp1;
                }
                else if(count == 1) {
                    amp = enchantAmp2;
                }
                else if(count == 2) {
                    amp = enchantAmp3;
                }
                else if(count == 3) {
                    amp = enchantAmp4;
                }
                int enchantNum = randor.nextInt(12);
                Enchantment enchant = null;
                if(enchantNum == 0) {
                    enchant = Enchantment.DIG_SPEED;
                }
                else if(enchantNum == 1) {
                    enchant = Enchantment.DURABILITY;
                }
                else if(enchantNum == 2) {
                    enchant = Enchantment.BINDING_CURSE;
                }
                else if(enchantNum == 3) {
                    enchant = Enchantment.LOOT_BONUS_BLOCKS;
                }
                else if(enchantNum == 4) {
                    enchant = Enchantment.VANISHING_CURSE;
                }
                else if(enchantNum == 5) {
                    enchant = Enchantment.SILK_TOUCH;
                }
                if(enchantNum == 6) {
                    enchant = Enchantment.DAMAGE_ALL;
                }
                else if(enchantNum == 7) {
                    enchant = Enchantment.DAMAGE_ARTHROPODS;
                }
                else if(enchantNum == 8) {
                    enchant = Enchantment.DAMAGE_UNDEAD;
                }
                else if(enchantNum == 9) {
                    enchant = Enchantment.FIRE_ASPECT;
                }
                else if(enchantNum == 10) {
                    enchant = Enchantment.KNOCKBACK;
                }
                else if(enchantNum == 11) {
                    enchant = Enchantment.LOOT_BONUS_MOBS;
                }
                item.addUnsafeEnchantment(enchant, amp);
            }
            return item;
        }
        else if(itemname.contains("shovel")) {
            for(int count = 0; count < enchantAmmount; count++) {
                int amp = 0;
                if(count == 0) {
                    amp = enchantAmp1;
                }
                else if(count == 1) {
                    amp = enchantAmp2;
                }
                else if(count == 2) {
                    amp = enchantAmp3;
                }
                else if(count == 3) {
                    amp = enchantAmp4;
                }
                int enchantNum = randor.nextInt(6);
                Enchantment enchant = null;
                if(enchantNum == 0) {
                    enchant = Enchantment.DIG_SPEED;
                }
                else if(enchantNum == 1) {
                    enchant = Enchantment.DURABILITY;
                }
                else if(enchantNum == 2) {
                    enchant = Enchantment.BINDING_CURSE;
                }
                else if(enchantNum == 3) {
                    enchant = Enchantment.LOOT_BONUS_BLOCKS;
                }
                else if(enchantNum == 4) {
                    enchant = Enchantment.VANISHING_CURSE;
                }
                else if(enchantNum == 5) {
                    enchant = Enchantment.SILK_TOUCH;
                }
                item.addUnsafeEnchantment(enchant, amp);
            }
            return item;
        }
        else if(itemname.contains("sword")) {
            for(int count = 0; count < enchantAmmount; count++) {
                int amp = 0;
                if(count == 0) {
                    amp = enchantAmp1;
                }
                else if(count == 1) {
                    amp = enchantAmp2;
                }
                else if(count == 2) {
                    amp = enchantAmp3;
                }
                else if(count == 3) {
                    amp = enchantAmp4;
                }
                int enchantNum = randor.nextInt(10);
                Enchantment enchant = null;
                if(enchantNum == 0) {
                    enchant = Enchantment.DAMAGE_ALL;
                }
                else if(enchantNum == 1) {
                    enchant = Enchantment.DAMAGE_ARTHROPODS;
                }
                else if(enchantNum == 2) {
                    enchant = Enchantment.BINDING_CURSE;
                }
                else if(enchantNum == 3) {
                    enchant = Enchantment.DAMAGE_UNDEAD;
                }
                else if(enchantNum == 4) {
                    enchant = Enchantment.DURABILITY;
                }
                else if(enchantNum == 5) {
                    enchant = Enchantment.FIRE_ASPECT;
                }
                else if(enchantNum == 6) {
                    enchant = Enchantment.KNOCKBACK;
                }
                else if(enchantNum == 7) {
                    enchant = Enchantment.LOOT_BONUS_MOBS;
                }
                else if(enchantNum == 8) {
                    enchant = Enchantment.SWEEPING_EDGE;
                }
                else if(enchantNum == 9) {
                    enchant = Enchantment.VANISHING_CURSE;
                }
                item.addUnsafeEnchantment(enchant, amp);
            }
            return item;
        }
        else if(itemname.contains("hoe")) {
            for(int count = 0; count < enchantAmmount; count++) {
                int amp = 0;
                if(count == 0) {
                    amp = enchantAmp1;
                }
                else if(count == 1) {
                    amp = enchantAmp2;
                }
                else if(count == 2) {
                    amp = enchantAmp3;
                }
                else if(count == 3) {
                    amp = enchantAmp4;
                }
                int enchantNum = randor.nextInt(4);
                Enchantment enchant = null;
                if(enchantNum == 0) {
                    enchant = Enchantment.DAMAGE_ALL;
                }
                else if(enchantNum == 1) {
                    enchant = Enchantment.DURABILITY;
                }
                else if(enchantNum == 2) {
                    enchant = Enchantment.FIRE_ASPECT;
                }
                else if(enchantNum == 3) {
                    enchant = Enchantment.KNOCKBACK;
                }
                item.addUnsafeEnchantment(enchant, amp);
            }
            return item;
        }
        return null;
    }

    /*
    public ItemStack getSkull(String url) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        if(url.isEmpty())return head;


        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

     */

    public boolean checkAbove(Location l) {
        Location full = l.clone().add(0, 1, 0);
        for(int count = 0; count < 10; count++) {
            if(!l.getBlock().isPassable()) {
                return false;
            }
            full.add(0, 1, 0);
        }
        return true;
    }

    public double getRandLowVolume() {
        int chose = randor.nextInt(4);
        if (chose == 0) {
            return .1;
        } else if (chose == 1) {
            return .2;
        } else if (chose == 2) {
            return .3;
        } else if (chose == 3) {
            return .4;
        } else {
            return .1;
        }
    }

    public void doSound(Player p) {
        if(dragonworlds.contains(p.getWorld().getName())) {
            if (p.getLocation().subtract(0, 1, 0).getBlock().getType() == Material.END_STONE && checkAbove(p.getLocation())) {
                if (randor.nextInt(5) == 0) {
                    if(randor.nextBoolean()) {
                        p.playSound(p.getLocation().add((coinFlip()*14), 0, 0), Sound.ENTITY_ENDERMAN_SCREAM, (float) 0.1, 0);
                    }
                    else {
                        p.playSound(p.getLocation().add(0, 0, (coinFlip()*14)), Sound.ENTITY_ENDERMAN_SCREAM, (float) 0.1, 0);
                    }
                }
                else if (randor.nextInt(5) == 0) {
                    p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_STARE, (float) 0.01, 0);
                }
                else if (randor.nextInt(15) == 0) {
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_IRON_GOLEM_HURT, (float) 0.01, 0), 3);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_IRON_GOLEM_HURT, (float) 0.01, 0), 9);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_IRON_GOLEM_HURT, (float) 0.01, 0), 24);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_IRON_GOLEM_HURT, (float) 0.001, 0), 38);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_IRON_GOLEM_HURT, (float) 0.01, 0), 50);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_IRON_GOLEM_HURT, (float) 0.01, 0), 67);
                }
                else if (randor.nextInt(15) == 0) {
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, (float) 0.01, 0), 3);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, (float) 0.01, 0), 15);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, (float) 0.01, 0), 25);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, (float) 0.01, 0),
                            35);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, (float) 0.01, 0), 45);
                    Bukkit.getScheduler().runTaskLater(plugin,
                            () -> p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, (float) 0.01, 0), 55);
                }
            }
        }
    }

}

