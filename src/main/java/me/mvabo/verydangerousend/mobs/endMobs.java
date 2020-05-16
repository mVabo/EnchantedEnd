package me.mvabo.verydangerousend.mobs;

import me.mvabo.verydangerousend.VeryDangerousEnd;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class endMobs implements Listener {

    Plugin plugin = VeryDangerousEnd.getPlugin(VeryDangerousEnd.class);
    Random randint = new Random();

    @EventHandler
    public void triggerMobSpawn(CreatureSpawnEvent event) {
        Entity e = event.getEntity();
        if(e instanceof Monster && (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL
                && event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.REINFORCEMENTS)) {
            doMobSpawns(e);
        }
    }

    public void doMobSpawns(Entity entitye) {
        LivingEntity e = (LivingEntity) entitye;
        String name = mobTypes();
        World world = entitye.getWorld();

        if(e != null && !e.isDead() && world.getName().endsWith("_end")) {
            if (name.equals(plugin.getConfig().getString("void_guardian"))
                    && (randint.nextDouble() < plugin.getConfig().getDouble("void_guardian_chance"))) {
                if (e.getType() != EntityType.SKELETON) {
                    Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.SKELETON);
                    e.remove();
                    e = (LivingEntity) e2;
                }
                EntityEquipment ee = (e).getEquipment();
                e.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 100, false, false));
                ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                LeatherArmorMeta lch6 = (LeatherArmorMeta) lchest.getItemMeta();
                lch6.setColor(Color.fromRGB(255, 255, 255));
                lchest.setItemMeta(lch6);
                ItemStack lchest2 = new ItemStack(Material.LEATHER_BOOTS, 1);
                LeatherArmorMeta lch61 = (LeatherArmorMeta) lchest2.getItemMeta();
                lch61.setColor(Color.fromRGB(255, 255, 255));
                lchest2.setItemMeta(lch61);
                ItemStack lchest3 = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                LeatherArmorMeta lch62 = (LeatherArmorMeta) lchest3.getItemMeta();
                lch62.setColor(Color.fromRGB(255, 255, 255));
                lchest3.setItemMeta(lch62);
                ee.setItemInMainHand(new ItemStack(Material.FIRE, 1));
                ee.setItemInOffHand(new ItemStack(Material.FIRE, 1));
                ee.setChestplate(lchest);
                ee.setLeggings(lchest3);
                ee.setBoots(lchest2);
                e.setCustomName(name);
                e.setSilent(true);
                e.setMetadata(name, new FixedMetadataValue(plugin, 0));
                e.setMetadata("R", new FixedMetadataValue(plugin, 0));
                e.setMetadata("endm", new FixedMetadataValue(plugin, 0));
                e.setCanPickupItems(false);
            }
        }
    }

    public String mobTypes() {
        int choice = randint.nextInt(1);

        if (choice == 0) {
            if (plugin.getConfig().getBoolean("spawn_void_guardian")) {
                return plugin.getConfig().getString("void_guardian");
            } else {
                return "";
            }
        }
        return "";
    }
}
