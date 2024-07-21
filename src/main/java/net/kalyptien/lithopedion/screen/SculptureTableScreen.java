package net.kalyptien.lithopedion.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.kalyptien.lithopedion.LithopedionMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SculptureTableScreen extends AbstractContainerScreen<SculptureTableMenu> {

    private static final ResourceLocation SCULPTURE_LOCATION =
            new ResourceLocation(LithopedionMod.MODID, "textures/gui/sculpture_table_gui.png");
    private GuiGraphics guiGraphics;

    public SculptureTableScreen(SculptureTableMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 118;
        this.titleLabelY = 8;

        this.imageWidth = 230;
        this.imageHeight = 219;
    }

    public void containerTick() {
        super.containerTick();
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        this.guiGraphics = guiGraphics;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, SCULPTURE_LOCATION);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(SCULPTURE_LOCATION, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
        renderInfuseRArrow(guiGraphics, x, y);
        renderInfuseLArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(SCULPTURE_LOCATION, x + 112, y + 83, 230, 0, 8, menu.getScaledProgress());
        }
    }

    private void renderInfuseRArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(SCULPTURE_LOCATION, x + 55, y + 52, 0, 219, 32, menu.getInfuseRProgress());
        }
    }

    private void renderInfuseLArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(SCULPTURE_LOCATION, x + 145, y + 52, 0, 225, 32, menu.getInfuseLProgress());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}