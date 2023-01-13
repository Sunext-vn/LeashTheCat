package vn.sunext.leashthecat.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import vn.sunext.leashthecat.LeashTheCat;

public class MonsterKillEvent implements Listener {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    @EventHandler
    public void onKillMonster(EntityDeathEvent event) {
        plugin.getMonsterSystem().onKillMonster(event);
    }

}
