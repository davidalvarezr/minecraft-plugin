package me.devdav.insultplayers.helpers;

import java.util.Random;

public class InsultGenerator {

    private static InsultGenerator instance = null;

    private final String[] insults = new String[]{
            "le FDP",
            "l'enculé de sa mère",
            "l'enculé de ses morts",
            "le fils de pute",
            "la petite pute",
            "le bâtard",
            "le fils de chien",
            "le gros branleur",
            "le lâche",
            "le disciple préféré d'Hitler",
            "le nazi",
            "le SS",
    };

    // private ctor
    private InsultGenerator() {}

    public static InsultGenerator getInstance() {
        if (instance == null) {
            instance = new InsultGenerator();
        }
        return instance;
    }

    public String getRandomInsult() {
        return insults[new Random().nextInt(insults.length)];
    }

    public String getRandomInsultWithoutArticle() {
        return removeArticle(getRandomInsult());
    }

    private String removeArticle(String insultWithArticle) {
        return insultWithArticle.replaceFirst("^(l'|le( )+|la( )+)", "");
    }
}
