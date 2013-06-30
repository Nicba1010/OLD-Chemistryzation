package nicba1010.chemistryzation.common.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemNaClItem extends Item {
	public ItemNaClItem(int id) {
		super(id);
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("chemistryzation:NaClItem");
	}
}