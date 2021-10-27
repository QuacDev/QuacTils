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
            name = "Endermen but person (REQUIRES RESTART!)",
            description = "Turns endermen into selected person.",
            category = "I Dont Know anymore", subcategory = "Endermen but person"
    )
    public static boolean endermenPerson = false;

    @Property(
            type = PropertyType.TEXT,
            name = "Enderman but person skin (REQUIRES RESTART!)",
            description = "Turns endermen into selected person (If Main feature is enabled).",
            category = "I Dont Know anymore", subcategory = "Endermen but person"
    )
    public static String endermenPersonName = "dream";

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

    @Property(
            type = PropertyType.SWITCH,
            name = "Friend join leave hider",
            category = "QOL", subcategory = "Spam"
    )
    public static boolean qolFriendJoinLeaveHider = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Guild join leave hider",
            category = "QOL", subcategory = "Spam"
    )
    public static boolean qolGuildJoinLeaveHider = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Guild exp hider",
            category = "QOL", subcategory = "Spam"
    )
    public static boolean qolGuildExpHider = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Tip Hider",
            category = "QOL", subcategory = "Spam"
    )
    public static boolean qolTipHider = false;

    //endregion

    //region <SkyBlock>
    @Property(
            type = PropertyType.SWITCH,
            name = "Ender Armor Warning",
            category = "Skyblock", subcategory = "Endermen"
    )
    public static boolean skyblockEnderArmorWarning = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Special Zealot Warning",
            category = "Skyblock", subcategory = "Endermen"
    )
    public static boolean skyblockSpecialZealotWarning = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Worm Warning",
            category = "Skyblock", subcategory = "Mining"
    )
    public static boolean skyblockWormWarning = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Lobby Day",
            category = "Skyblock", subcategory = "Mining"
    )
    public static boolean skyblockLobbyDay = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "Glacite Armor Warning",
            category = "Skyblock", subcategory = "Other"
    )
    public static boolean skyblockGlaciteArmorWarning = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Auto Copy RNG Drops", description = "Will automatically copy 'Crazy Rare' and 'Insane' drops to your clipboard",
            category = "Skyblock", subcategory = "Other"
    )
    public static boolean skyblockAutoCopyRng = false;

    /*@Property(
            type = PropertyType.SWITCH,
            name = "Atoned Horror Helper",
            description = "Makes screen red if standing inside explosive circle.",
            category = "Skyblock", subcategory = "Slayer"
    )
    public static boolean skyblockAtonedHorrorHelper = false;*/

    //endregion


    public Config(File file) {
        super(file);
        initialize();
    }
}
