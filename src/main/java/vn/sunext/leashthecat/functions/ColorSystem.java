package vn.sunext.leashthecat.functions;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorSystem {

    private final Pattern pattern = Pattern.compile("#[a-fA-F\\d]{6}");

    public String color(String text) {
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String color = text.substring(matcher.start(), matcher.end());
            text = text.replace(color, ChatColor.of(color) + "");
            matcher = pattern.matcher(text);
        }
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public List<String> color(List<String> text) {
        List<String> result = new ArrayList<>();

        for (String s : text) {
            Matcher matcher = pattern.matcher(s);

            while (matcher.find()) {
                String color = s.substring(matcher.start(), matcher.end());
                s = s.replace(color, ChatColor.of(color) + "");
                matcher = pattern.matcher(s);
            }
            result.add(ChatColor.translateAlternateColorCodes('&', s));
        }

        return result;
    }

}
