package com.quac.quactils.Utils;

import net.minecraft.util.ChatComponentTranslationFormatException;
import net.minecraft.util.EnumChatFormatting;

public class Color {
    public static String translate(String s) {
        //return s.replaceAll("&[^0-9a-fklmnor]", "\u00A7");
        return EnumChatFormatting.getTextWithoutFormattingCodes(s).replaceAll("&", "\u00A7");
        //return s.replaceAll("&", "\u00A7");
        //return s.replaceAll("&", "§");
    }
}
