package vn.sunext.leashthecat.functions;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ColorSystem {
    public String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public List<String> color(List<String> text) {
        List<String> result = new ArrayList<>();

        for (String s : text) {
            result.add(ChatColor.translateAlternateColorCodes('&', s));
        }

        return result;
    }

}
