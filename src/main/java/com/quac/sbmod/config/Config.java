package com.quac.sbmod.config;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class Config extends Vigilant {
    @Property(
            type = PropertyType.TEXT, name = "Api Key",
            protectedText = true,
            description = "Api Key used for certain functions",
            category = "General"
    )
    public static String apiKey = "";

    @Property(
            type = PropertyType.SWITCH,
            name = "Switch",
            description = "This is a switch, contains boolean",
            category = "Property overview"
    )
    public static boolean fpsCounter = true;

    public Config(File file) {
        super(file);
        initialize();
    }
}
