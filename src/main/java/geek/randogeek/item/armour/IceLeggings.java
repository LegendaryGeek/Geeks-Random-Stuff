package geek.randogeek.item.armour;

import java.util.List;

import javax.annotation.Nullable;

import geek.randogeek.RandoGeek;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IceLeggings extends ItemArmor {

	public IceLeggings() {
		super(RandoGeek.ICE_ARMOR_MATERIAL, 3, EntityEquipmentSlot.LEGS);
		// TODO Auto-generated constructor stub
	}

	/**
	 * allows items to add custom lines of information to the mouseover description
	 */
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		
	}
}
