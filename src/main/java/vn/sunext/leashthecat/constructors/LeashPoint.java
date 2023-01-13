package vn.sunext.leashthecat.constructors;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class LeashPoint implements Comparable<LeashPoint> {

    private final String playerName;

    private final Integer points;

    public LeashPoint(String playerName, Integer points) {
        this.playerName = playerName;
        this.points = points;
    }

    @Override
    public int compareTo(@NotNull LeashPoint leashPoint) {
        return points.compareTo(leashPoint.points);
    }
}
