package geek.randogeek.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EmptyCup extends Item {
	private Block containedBlock;
	public EmptyCup(Block ContainedBlock) {
		this.containedBlock = ContainedBlock;
		this.setMaxStackSize(1);
	}
	 /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
    	tooltip.add("Contains " + this.containedBlock.getLocalizedName());
    }
	/**
	 * returns the action that specifies what animation to play when the items is
	 * being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}

	/**
	 * Called when the equipped item is right clicked.
	 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	/**
	 * Called when the player finishes using this Item (E.g. finishes eating.). Not
	 * called when the player stops using the Item before the action is complete.
	 */
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		EntityPlayer entityplayer = entityLiving instanceof EntityPlayer ? (EntityPlayer) entityLiving : null;

		if (entityplayer == null || !entityplayer.capabilities.isCreativeMode) {
			stack.shrink(1);
		}

		if (entityplayer instanceof EntityPlayerMP) {
			CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP) entityplayer, stack);
		}

		if (!worldIn.isRemote) {
			for (PotionEffect potioneffect : PotionUtils.getEffectsFromStack(stack)) {
				if (potioneffect.getPotion().isInstant()) {
					potioneffect.getPotion().affectEntity(entityplayer, entityplayer, entityLiving,
							potioneffect.getAmplifier(), 1.0D);
				} else {
					entityLiving.addPotionEffect(new PotionEffect(potioneffect));
				}
			}
		}

		if (entityplayer != null) {
			entityplayer.addStat(StatList.getObjectUseStats(this));
		}

		if (entityplayer == null || !entityplayer.capabilities.isCreativeMode) {
			if (stack.isEmpty()) {
				return new ItemStack(Items.GLASS_BOTTLE);
			}

			if (entityplayer != null) {
				entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
			}
		}

		return stack;
	}
}