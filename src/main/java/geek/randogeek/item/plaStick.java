package geek.randogeek.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class plaStick extends Item {
	
	public plaStick() {
		super();
	}
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
		 ItemStack itemstack = playerIn.getHeldItem(handIn);
		 playerIn.setHealth(playerIn.getHealth() - 3);
		 return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	 }
}
