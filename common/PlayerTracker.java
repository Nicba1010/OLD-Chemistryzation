package nicba1010.chemistryzation.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.relauncher.Side;

public class PlayerTracker implements IPlayerTracker {

	@Override
	public void onPlayerLogin(EntityPlayer player) {
		NBTTagCompound nbt = player.getEntityData();
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.SERVER) {
			nbt.setInteger("level", NBTManager.getLevel(nbt,player));
			System.out.println(Integer.toString(NBTManager.getLevel(nbt,player)));
		} else if (side == Side.CLIENT) {
		} else {
		}
		if (side == Side.SERVER) {
			nbt.setInteger("CExp", NBTManager.getCExp(nbt,player));
		} else if (side == Side.CLIENT) {
		} else {
		}
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {
		// TODO Auto-generated method stub

	}

}
