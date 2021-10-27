package com.quac.quactils.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ImageUtils {
    public static Image getImageFromLink(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        return ImageIO.read(url);
    }

    public static ResourceLocation imageToResourceLocation(Image image) {
        BufferedImage buffered = (BufferedImage) image;
        DynamicTexture dynam = new DynamicTexture(buffered);
        return Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation(" ", dynam);
    }
}
