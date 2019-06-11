package geek.randogeek.item;

import geek.randogeek.init.ModFluids;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;

public class CoffeeBean extends Item {

	public CoffeeBean() {
		super();

	}

	@Override
	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {
		if (entityItem.isInsideOfMaterial(Material.WATER)) {
			BlockPos pos = entityItem.getPosition().down();
			entityItem.world.setBlockState(pos, ModFluids.COFFEE.getBlock().getDefaultState());
			entityItem.setDead();
		}
		return true;
	}
}
