package vn.sunext.leashthecat.functions;

import vn.sunext.leashthecat.managers.PathManager;

import java.util.Random;

public class DropSystem {

    public Boolean canDropLeashCat() {
        int rate = randomRate();

        return rate <= PathManager.LEASH_CAT_DROP_PERCENT;
    }

    public Boolean canDropLeashMaterial() {
        int rate = randomRate();

        return rate <= PathManager.LEASH_MATERIAL_DROP_PERCENT;
    }

    private Integer randomRate() {
        Random random = new Random();

        return random.nextInt(100) + 1;
    }

}
