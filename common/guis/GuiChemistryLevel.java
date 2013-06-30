package nicba1010.chemistryzation.common.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import nicba1010.chemistryzation.common.tempVars;

public class GuiChemistryLevel extends Gui {
	private Minecraft mc;
	FontRenderer fontrenderer;
	EntityPlayer p;
	NBTTagCompound nbt;
	public static int level;
	public GuiChemistryLevel(Minecraft mc) {
		super();
		fontrenderer = mc.fontRenderer;
		this.mc = mc;
	}

	@ForgeSubscribe(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE) {
			return;
		}
		fontrenderer.drawString("Level " + tempVars.leveltemp, 1, 1, 0xffffffff);
		fontrenderer.drawString("EXP " + tempVars.CExptemp + "/" +((tempVars.leveltemp+1)*200), 1, 10, 0xffffffff);
		this.mc.renderEngine.bindTexture("/gui/inventory.png");
	}

}