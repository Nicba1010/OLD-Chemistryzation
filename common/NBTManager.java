package nicba1010.chemistryzation.common;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

public class NBTManager {
	public static int currentlevel;

	public static int getLevel(NBTTagCompound nbt1, EntityPlayer player) {
		int level = 0;
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.SERVER) {
			level = nbt1.getInteger("level");
			ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
			DataOutputStream outputStream = new DataOutputStream(bos);
			try {
				outputStream.writeInt(level);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = "Chemistryzation";
			packet.data = bos.toByteArray();
			packet.length = bos.size();
			PacketDispatcher.sendPacketToPlayer(packet, (Player) player);
		} else if (side == Side.CLIENT) {

		} else {

		}
		return level;
	}

	public static int getCExp(NBTTagCompound nbt1, EntityPlayer player) {
		int CExp = 0;
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.SERVER) {
			CExp = nbt1.getInteger("CExp");
			ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
			DataOutputStream outputStream = new DataOutputStream(bos);
			try {
				outputStream.writeInt(CExp);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = "Chemistryzation1";
			packet.data = bos.toByteArray();
			packet.length = bos.size();
			PacketDispatcher.sendPacketToPlayer(packet, (Player) player);
		} else if (side == Side.CLIENT) {

		} else {

		}
		return CExp;
	}

	public static void handleLevelUp(NBTTagCompound nbt1, EntityPlayer player) {
		int CExp = 0;
		int level = 0;
		nbt1=player.getEntityData();
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.SERVER) {
			CExp = nbt1.getInteger("CExp");
			level = nbt1.getInteger("level");
			if (CExp >= ((level + 1) * 200)) {
				if (side == Side.SERVER) {
					nbt1.setInteger("level", getLevel(nbt1, player) + 1);
					nbt1.setInteger("CExp", 0);
					System.out.println(Integer.toString(NBTManager.getLevel(nbt1, player)));
					System.out.println(Integer.toString(NBTManager.getCExp(nbt1, player)));
				} else if (side == Side.CLIENT) {

				} else {

				}
			}
		} else if (side == Side.CLIENT) {} else {}
	}
}
