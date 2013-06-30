package nicba1010.chemistryzation.common.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nicba1010.chemistryzation.common.Chemistryzation;

public class NaClInBucketMelted extends Item
{
       public NaClInBucketMelted(int id)
       {
             super(id);
       }
       
       public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Chemistryzation.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
       @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list,
			boolean i) {
		list.add("In bucket");
		list.add("Melted");
	}
}