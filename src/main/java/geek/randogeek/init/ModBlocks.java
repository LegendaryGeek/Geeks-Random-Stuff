package geek.randogeek.init;

import geek.randogeek.RandoGeek;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 *
 */
@GameRegistry.ObjectHolder(RandoGeek.MODID)
public final class ModBlocks {

	/**
	 *
	 */
	private ModBlocks() {
		//
	}

	@ObjectHolder("randogeek:blockplastic")
	public static final Block BlockPlastic = new Block(Material.CLAY).setHardness(0.3f);
	
	@ObjectHolder("randogeek:coffeeore")
	public static final Block CoffeeOre = new Block(Material.ROCK);

	/**
	 *fluid blocks
	 */
	
	@ObjectHolder("randogeek:coffee")
	public static final Block COFFEE = new Block(Material.WATER);
}
