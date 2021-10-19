package com.quac.quactils.config;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

import javax.swing.text.JTextComponent;
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

    @Property(
            type = PropertyType.SWITCH,
            name = "Feature Backgrounds",
            category = "! General",
            description = "Toggle the background (shadows) of features in game."
    )
    public static boolean featureBackgrounds = true;

    //region <RandomStuff>

    @Property(
            type = PropertyType.SWITCH,
            name = "Dreamerman (REQUIRES RESTART!)",
            description = "Turns endermen into dream.",
            category = "I Dont Know anymore"
    )
    public static boolean dreamermanFeature = false;

    //endregion


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
            type = PropertyType.SWITCH,
            name = "Compact Coordinates",
            category = "Coordinates"
    )
    public static boolean compactCoordinates = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "Pitch And Yaw",
            category = "Coordinates"
    )
    public static boolean pitchAndYaw = false;

    @Property(
            type = PropertyType.COLOR,
            name = "Color",
            category = "Coordinates"
    )
    public static Color coordinatesColor = Color.WHITE;
    //endregion

    //region <BlockOverlay>
    /*@Property(
            type = PropertyType.SWITCH,
            name = "! Enabled",
            category = "LookInfo"
    )*/
    public static boolean lookInfo = false;

    /*@Property(
            type = PropertyType.COLOR,
            name = "Main Color",
            category = "LookInfo"
    )*/
    public static Color lookInfoColor = Color.WHITE;
    //endregion

    //region <Quality Of Life>
    //endregion

    //region <SkyBlock>
    @Property(
            type = PropertyType.SWITCH,
            name = "Worm Warning",
            category = "Skyblock"
    )
    public static boolean skyblockWormWarning = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Glacite Armor Warning",
            category = "Skyblock"
    )
    public static boolean skyblockGlaciteArmorWarning = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Ender Armor Warning",
            category = "Skyblock"
    )
    public static boolean skyblockEnderArmorWarning = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Special Zealot Warning",
            category = "Skyblock"
    )
    public static boolean skyblockSpecialZealotWarning = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Lobby Day",
            category = "Skyblock"
    )
    public static boolean skyblockLobbyDay = true;

    //endregion


    public Config(File file) {
        super(file);
        initialize();
    }
}
