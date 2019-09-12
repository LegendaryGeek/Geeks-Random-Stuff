package geek.randogeek.item.armour;

import geek.randogeek.RandoGeek;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IceBooties extends ItemArmor {

	public IceBooties() {
		super(RandoGeek.ICE_ARMOR_MATERIAL, 3, EntityEquipmentSlot.FEET);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		BlockPos position = player.getPosition();
		Block freezable = world.getBlockState(position.down()).getBlock();
		if(freezable == Blocks.WATER) {
			world.setBlockState(position.down(), Blocks.ICE.getDefaultState());
		} else if(freezable == Blocks.LAVA) {
			world.setBlockState(position.down(), Blocks.MAGMA.getDefaultState());
		}
	}
}
