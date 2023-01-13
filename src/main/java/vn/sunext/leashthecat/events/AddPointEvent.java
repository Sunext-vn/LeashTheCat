package vn.sunext.leashthecat.events;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import vn.sunext.leashthecat.LeashTheCat;

@Getter
public class AddPointEvent extends Event implements Cancellable {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private static final HandlerList handlers = new HandlerList();

    private final Player player;

    private final Integer currentLeashPoints;
    private final Integer nextLeashPoints;

    private Boolean cancelled = false;

    public AddPointEvent(Player player, Integer currentLeashPoints, Integer nextLeashPoints) {
        this.player = player;
        this.currentLeashPoints = currentLeashPoints;
        this.nextLeashPoints = nextLeashPoints;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
