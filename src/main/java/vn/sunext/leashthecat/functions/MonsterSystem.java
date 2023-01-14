package vn.sunext.leashthecat.functions;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.event.entity.EntityDeathEvent;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.managers.PathManager;

public class MonsterSystem {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    public void onKillMonster(EntityDeathEvent event) {
        LivingEntity livingEntity = event.getEntity();

        if (PathManager.MUST_BE_PLAYER_KILL)
            if (livingEntity.getKiller() == null)
                return;

        if (livingEntity instanceof Monster) {
            if (plugin.getDropSystem().canDropLeashCat())
                event.getDrops().add(plugin.getItemManager().getLeashCat());

            if (plugin.getDropSystem().canDropLeashMaterial())
                event.getDrops().add(plugin.getItemManager().getLeashMaterial());
        }
    }

}
