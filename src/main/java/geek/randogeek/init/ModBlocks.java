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
	
	// ORES
	
	@ObjectHolder("randogeek:coffeeore")
	public static final Block CoffeeOre = new Block(Material.ROCK);
	
	@ObjectHolder("randogeek:cakeore")
	public static final Block CakeOre = new Block(Material.ROCK);
	
	@ObjectHolder("randogeek:iceore")
	public static final Block IceOre = new Block(Material.ROCK);
	
	@ObjectHolder("randogeek:cookieore")
	public static final Block CookieOre = new Block(Material.ROCK);
	
	@ObjectHolder("randogeek:frostedcookieore")
	public static final Block FrostedCookieOre = new Block(Material.ROCK);
	
	@ObjectHolder("randogeek:icecreamsandwichore")
	public static final Block IcecreamSandwichOre = new Block(Material.ROCK);
	
	@ObjectHolder("randogeek:friedchickenore")
	public static final Block FriedChickenOre = new Block(Material.ROCK);
	
	@ObjectHolder("randogeek:popcornore")
	public static final Block PopcornOre = new Block(Material.ROCK);

	@ObjectHolder("randogeek:caramelore")
	public static final Block CaramelOre = new Block(Material.ROCK);

	@ObjectHolder("randogeek:waffleore")
	public static final Block WaffleOre = new Block(Material.ROCK);

	/**
	 *fluid blocks
	 */
	
	@ObjectHolder("randogeek:coffee")
	public static final Block COFFEE = new Block(Material.WATER);
}
