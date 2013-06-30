package nicba1010.chemistryzation.common.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import nicba1010.chemistryzation.common.NBTManager;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NaClInTestTubeSolid extends Item {
	public NaClInTestTubeSolid(int id) {
		super(id);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list,
			boolean i) {
		list.add("In test tube");
		list.add("Solid");
	}
	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		NBTTagCompound nbt = par3EntityPlayer.getEntityData();
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.SERVER) {
			nbt.setInteger("CExp", NBTManager.getCExp(nbt,par3EntityPlayer) + 50);
			System.out.println(Integer.toString(NBTManager.getCExp(nbt,par3EntityPlayer)));
		} else if (side == Side.CLIENT) {

		} else {

		}	
		NBTManager.handleLevelUp(nbt, par3EntityPlayer);
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         this.itemIcon = iconRegister.registerIcon("chemistryzation:NaClInTestTubeSolid");
	}
}