package com.quac.sbmod.Utils;

import com.sun.org.apache.xml.internal.serialize.TextSerializer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.client.config.GuiConfigEntries;

import java.awt.*;

public class C {
    public static String C(String s) {
        return EnumChatFormatting.getTextWithoutFormattingCodes(s).replaceAll("&", "\u00A7");
    }
}
