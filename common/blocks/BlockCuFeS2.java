package nicba1010.chemistryzation.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import nicba1010.chemistryzation.common.Chemistryzation;
import nicba1010.chemistryzation.common.NBTManager;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class BlockCuFeS2 extends Block {
	public static NBTTagCompound nbt;

	public BlockCuFeS2(int id, Material par2Material) {
		super(id, par2Material);
		this.setHardness(5);
		this.setResistance(1);

	}

	public int quantityDropped(Random par1Random) {
		return 1;
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID;
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister
				.registerIcon("chemistryzation:CuFeS2");
	}
}