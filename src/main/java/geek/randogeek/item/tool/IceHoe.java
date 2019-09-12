package geek.randogeek.item.tool;

import geek.randogeek.RandoGeek;
import geek.randogeek.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IceHoe extends ItemHoe {
	
	private int tickCount = 10;

	public IceHoe() {
		super(RandoGeek.ICE_TOOL_MATERIAL);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Called each tick as long the item is on a player inventory. Uses by maps to
	 * check if is on a player hand and update it's contents.
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		Iterable<ItemStack> armour = entityIn.getArmorInventoryList();
		if (java.util.Arrays.asList(armour).contains(ModItems.IceLegs)
				&& java.util.Arrays.asList(armour).contains(ModItems.IceChestplate)) {
			tickCount--;
		} else if (entityIn.dimension == -1 || entityIn.isBurning()) {
			if (tickCount == 1) {
				stack.damageItem(3, (EntityLivingBase) entityIn);
				tickCount = 10;
			} else {
				tickCount--;
			}
		}
	}
}
