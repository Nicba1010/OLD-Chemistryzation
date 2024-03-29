package nicba1010.chemistryzation.common.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import nicba1010.chemistryzation.common.containers.ContainerBunsenBurner;
import nicba1010.chemistryzation.common.tileEntitys.TileEntityBunsenBurner;

import org.lwjgl.opengl.GL11;

public class GuiBunsenBurner extends GuiContainer {
		public TileEntityBunsenBurner tileEntity1;
        public GuiBunsenBurner (InventoryPlayer inventoryPlayer,
                        TileEntityBunsenBurner tileEntity) {
        		
                super(new ContainerBunsenBurner(inventoryPlayer, tileEntity));
                tileEntity1=tileEntity;
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {
                //draw text and stuff here
                //the parameters for drawString are: string, x, y, color
                fontRenderer.drawString("Bunsen Burner", 8, 6, 4210752);
                //draws "Inventory" or your regional equivalent
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                        int par3) {
                //draw your Gui here, only thing you need to change is the path
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.mc.renderEngine.bindTexture("/mods/chemistryzation/textures/guis/bunsenburner.png");
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
                if (tileEntity1.isBurning())
                {
                    int i1 = this.tileEntity1.getBurnTimeRemainingScaled(10);
                    System.out.println(i1);
                    this.drawTexturedModalRect(x + 80, y + 35 , 176, 0 , 14, 14);
                }
        }

}