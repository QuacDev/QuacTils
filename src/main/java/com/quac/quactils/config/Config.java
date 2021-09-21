package com.quac.quactils.config;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import net.minecraft.client.Minecraft;

import java.awt.*;
import java.io.File;

public class Config extends Vigilant {
    @Property(
            type = PropertyType.TEXT, name = "Api Key",
            protectedText = true,
            description = "Api Key used for certain functions",
            category = "! General",
            placeholder = "Not found"

    )
    public static String apiKey = "";

    //region <FPS Counter>
    @Property(
            type = PropertyType.SWITCH,
            name = "! Enabled",
            category = "Fps Counter"
    )
    public static boolean fpsCounter = true;

    @Property(
            type = PropertyType.COLOR,
            name = "Color",
            category = "Fps Counter"
    )
    public static Color fpsCounterColor = Color.WHITE;
    //endregion

    //region <Ping Counter>
    @Property(
            type = PropertyType.SWITCH,
            name = "! Enabled",
            category = "Ping Counter"
    )
    public static boolean pingCounter = true;

    @Property(
            type = PropertyType.COLOR,
            name = "Color",
            category = "Ping Counter"
    )
    public static Color pingCounterColor = Color.WHITE;
    //endregion

    //region <CPS Counter>
    @Property(
            type = PropertyType.SWITCH,
            name = "! Enabled",
            category = "CPS Counter"
    )
    public static boolean cpsCounter = true;

    @Property(
            type = PropertyType.COLOR,
            name = "Color",
            category = "CPS Counter"
    )
    public static Color cpsCounterColor = Color.WHITE;
    //endregion

    //region <Coordinates>
    @Property(
            type = PropertyType.SWITCH,
            name = "! Enabled",
            category = "Coordinates"
    )
    public static boolean coordinates = true;

    @Property(
            type = PropertyType.COLOR,
            name = "Color",
            category = "Coordinates"
    )
    public static Color coordinatesColor = Color.WHITE;
    //endregion

    public Config(File file) {
        super(file);
        initialize();
    }
}
