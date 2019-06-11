package geek.randogeek.item;

import geek.randogeek.init.ModBlocks;
import geek.randogeek.init.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EmptyPot extends ItemBucket {
	/** field for checking if the bucket has been filled. */
	private final Block containedBlock;

	public EmptyPot(Block containedBlockIn) {
		super(containedBlockIn);
		this.containedBlock = containedBlockIn;
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.MISC);

	}

	/**
	 * Called when the equipped item is right clicked.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		boolean flag = this.containedBlock == Blocks.AIR;
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, flag);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn,
				itemstack, raytraceresult);
		if (ret != null)
			return ret;

		if (raytraceresult == null) {
			return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
		} else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK) {
			return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
		} else {
			BlockPos blockpos = raytraceresult.getBlockPos();

			if (!worldIn.isBlockModifiable(playerIn, blockpos)) {
				return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
			} else if (flag) {
				if (!playerIn.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit,
						itemstack)) {
					return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
				} else {
					IBlockState iblockstate = worldIn.getBlockState(blockpos);
					Block block = iblockstate.getBlock();
					//Material material = iblockstate.getMaterial();

					if (block == ModBlocks.COFFEE
							&& ((Integer) iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0) {
						worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 11);
						playerIn.addStat(StatList.getObjectUseStats(this));
						playerIn.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
						return new ActionResult<ItemStack>(EnumActionResult.SUCCESS,
								this.fillBucket(itemstack, playerIn, ModItems.CoffeePot));
					} else if (block == Blocks.LAVA
							&& ((Integer) iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0) {
						playerIn.playSound(SoundEvents.ITEM_BUCKET_FILL_LAVA, 1.0F, 1.0F);
						worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 11);
						playerIn.addStat(StatList.getObjectUseStats(this));
						return new ActionResult<ItemStack>(EnumActionResult.SUCCESS,
								this.fillBucket(itemstack, playerIn, ModItems.LavaPot));
					} else {
						return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
					}
				}
			} else {
				boolean flag1 = worldIn.getBlockState(blockpos).getBlock().isReplaceable(worldIn, blockpos);
				BlockPos blockpos1 = flag1 && raytraceresult.sideHit == EnumFacing.UP ? blockpos
						: blockpos.offset(raytraceresult.sideHit);

				if (!playerIn.canPlayerEdit(blockpos1, raytraceresult.sideHit, itemstack)) {
					return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
				} else if (this.tryPlaceContainedLiquid(playerIn, worldIn, blockpos1)) {
					if (playerIn instanceof EntityPlayerMP) {
						CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) playerIn, blockpos1, itemstack);
					}

					playerIn.addStat(StatList.getObjectUseStats(this));
					return !playerIn.capabilities.isCreativeMode
							? new ActionResult(EnumActionResult.SUCCESS, new ItemStack(ModItems.EmptyPot))
							: new ActionResult(EnumActionResult.SUCCESS, itemstack);
				} else {
					return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
				}
			}
		}
	}

	private ItemStack fillBucket(ItemStack emptyBuckets, EntityPlayer player, Item fullBucket) {
		if (player.capabilities.isCreativeMode) {
			return emptyBuckets;
		} else {
			emptyBuckets.shrink(1);

			if (emptyBuckets.isEmpty()) {
				return new ItemStack(fullBucket);
			} else {
				if (!player.inventory.addItemStackToInventory(new ItemStack(fullBucket))) {
					player.dropItem(new ItemStack(fullBucket), false);
				}

				return emptyBuckets;
			}
		}
	}
	 /**
     * allows items to add custom lines of information to the mouseover description
     */
   /* @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
    	tooltip.add(this.getTranslationKey());
    }*/
}
