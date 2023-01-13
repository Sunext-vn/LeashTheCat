package vn.sunext.leashthecat.functions;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.event.entity.EntityDeathEvent;
import vn.sunext.leashthecat.LeashTheCat;

public class MonsterSystem {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    public void onKillMonster(EntityDeathEvent event) {
        LivingEntity livingEntity = event.getEntity();

        if (livingEntity instanceof Monster) {
            if (plugin.getDropSystem().canDropLeashCat())
                event.getDrops().add(plugin.getItemManager().getLeashCat());

            if (plugin.getDropSystem().canDropLeashMaterial())
                event.getDrops().add(plugin.getItemManager().getLeashMaterial());
        }
    }

}
