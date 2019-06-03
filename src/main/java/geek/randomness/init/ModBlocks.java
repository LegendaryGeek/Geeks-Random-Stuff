package geek.randomness.init;

import geek.randomness.RandoGeek;
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

	/**
	 *
	 */
	@ObjectHolder("randogeek:geostone")
    public static final Block GeoStone = null;

	/**
	 *
	 */
    @ObjectHolder("randogeek:coffeeblock")
	public static final Block COFFEE = new Block(Material.WATER);
}
