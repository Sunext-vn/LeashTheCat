package vn.sunext.leashthecat.managers;

import lombok.Getter;
import lombok.Setter;
import vn.sunext.leashthecat.LeashTheCat;
import vn.sunext.leashthecat.constructors.LeashPoint;
import vn.sunext.leashthecat.functions.MessageSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class TopManager {

    private final LeashTheCat plugin = LeashTheCat.getInstance();

    private final FileManager fileManager = plugin.getFileManager();
    private final MessageSystem messageSystem = plugin.getMessageSystem();

    private List<LeashPoint> topList = new ArrayList<>();

    public void register() {
        loadTop();

        autoRefreshTopList();
    }

    public void loadTop() {
        if (!fileManager.isDataInFileExist("database.yml", "list"))
            return;

        List<LeashPoint> temporaryPointData = new ArrayList<>();

        for (String playerName : fileManager.getListDataInFile("database.yml", "list")) {
            Integer points = (Integer) plugin.getFileManager().getDataInFile("database.yml", "list." + playerName);

            if (points != 0)
                temporaryPointData.add(new LeashPoint(playerName, points));
        }

        if (temporaryPointData.isEmpty())
            return;

        temporaryPointData.sort(Collections.reverseOrder());

        List<LeashPoint> limitPointData = temporaryPointData.stream().limit(PathManager.TOP_AMOUNT).collect(Collectors.toList());

        if (isNewTopOne(limitPointData.get(0)))
            messageSystem.broadcastMessage(PathManager.NEW_TOP_ONE_MESSAGE
                    .replace("{new-1st-name}", limitPointData.get(0).getPlayerName())
                    .replace("{old-1st-name}", topList.get(0).getPlayerName()));

        topList.clear();

        topList.addAll(limitPointData);
    }

    public void forceRefreshTop() {
        plugin.getDataSystem().saveAllTempData(false);

        loadTop();
    }

    private Boolean isNewTopOne(LeashPoint leashPoint) {
        if (topList.isEmpty()) return false;

        return !leashPoint.getPlayerName().equalsIgnoreCase(topList.get(0).getPlayerName());
    }

    private void autoRefreshTopList() {
        plugin.getTimerTask().refreshTop();
    }

}
