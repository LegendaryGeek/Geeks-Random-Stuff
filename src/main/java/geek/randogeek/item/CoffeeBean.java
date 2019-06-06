package geek.randogeek.item;

import geek.randogeek.init.ModFluids;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.BlockFluidBase;

public class CoffeeBean extends Item {

	public CoffeeBean() {
		super();

	}

	@Override
	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {
		if (entityItem.isInsideOfMaterial(Material.WATER)) {
			BlockPos pos = entityItem.getPosition().down();
			entityItem.world.setBlockState(pos, ModFluids.COFFEE.getBlock().getDefaultState().withProperty(BlockFluidBase.LEVEL, 15));
			entityItem.setDead();
		}
		return false;
	}
}
