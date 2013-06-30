package nicba1010.chemistryzation.common;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {

		if (packet.channel.equals("Chemistryzation")) {
			handleLevel(packet);
		}
		if (packet.channel.equals("Chemistryzation1")) {
			handleCExp(packet);
		}
	}

	private void handleLevel(Packet250CustomPayload packet) {
		DataInputStream inputStream = new DataInputStream(
				new ByteArrayInputStream(packet.data));

		int level;

		try {
			level = inputStream.readInt();
			tempVars.leveltemp = level;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

	}

	private void handleCExp(Packet250CustomPayload packet) {
		DataInputStream inputStream = new DataInputStream(
				new ByteArrayInputStream(packet.data));

		int CExp;

		try {
			CExp = inputStream.readInt();
			tempVars.CExptemp = CExp;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

	}

}