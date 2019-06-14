package geek.randogeek.util;

import geek.randogeek.RandoGeek;
import geek.randogeek.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GeekTab extends CreativeTabs {

	public static GeekTab instance = null;
	public GeekTab() {
		super(RandoGeek.MODID);
	}
	
	public static void init()
	{
		instance = new GeekTab();
	}
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack createIcon() {
		// TODO Auto-generated method stub
		return new ItemStack(ModItems.CoffeePot);
	}
	
	public CreativeTabs getCTab() {
		return this;
	}

}
