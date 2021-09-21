package com.quac.quactils.Utils;

import net.minecraft.util.EnumChatFormatting;

public class C {
    public static String C(String s) {
        return EnumChatFormatting.getTextWithoutFormattingCodes(s).replaceAll("&", "\u00A7");
    }
}
