package com.quac.quactils.Gui.Screens;

import com.quac.quactils.Main;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class MainScreen extends GuiScreen {
    GuiButton configButton;
    GuiButton editPosButton;

    @Override
    public void initGui() {
        super.initGui();

        this.buttonList.add(this.configButton = new GuiButton(0, this.width / 2 - 100, this.height / 2 - 50, "Config"));
        this.buttonList.add(this.editPosButton = new GuiButton(1, this.width / 2 - 100, this.height / 2 - 26, "COMING SOON!"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(button == this.configButton) {
            Main.setGui(Main.config.gui());
        }
    }
}
