package geek.randogeek.init;

import geek.randogeek.RandoGeek;
import geek.randogeek.item.CaramelPopcorn;
import geek.randogeek.item.CoffeeBean;
import geek.randogeek.item.EmptyBigCup;
import geek.randogeek.item.EmptyCup;
import geek.randogeek.item.EmptyPot;
import geek.randogeek.item.Plastic;
import geek.randogeek.item.plaStick;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 *
 */
@GameRegistry.ObjectHolder(RandoGeek.MODID)
public final class ModItems {

	/**
	 *
	 */
	private ModItems() {
		//
	}

	// Plastic

	@ObjectHolder("randogeek:plastic")
	public static final Item Plastic = new Plastic();

	@ObjectHolder("randogeek:plastick")
	public static final Item plaStick = new plaStick();

	// Coffee Stuffs

	@ObjectHolder("randogeek:coffeebean")
	public static final Item CoffeeBean = new CoffeeBean();

	@ObjectHolder("randogeek:emptypot")
	public static final Item EmptyPot = new EmptyPot(Blocks.AIR);

	@ObjectHolder("randogeek:emptybigcup")
	public static final Item EmptyBigCup = new EmptyBigCup(Blocks.AIR);

	@ObjectHolder("randogeek:coffeebigcup")
	public static final Item CoffeeBigcup = new EmptyBigCup(ModBlocks.COFFEE, "coffee").setContainerItem(EmptyBigCup);

	@ObjectHolder("randogeek:lavabigcup")
	public static final Item LavaBigcup = new EmptyBigCup(Blocks.LAVA, "lava").setContainerItem(EmptyBigCup);

	@ObjectHolder("randogeek:coffeepot")
	public static final Item CoffeePot = new EmptyPot(ModBlocks.COFFEE).setContainerItem(EmptyPot);

	@ObjectHolder("randogeek:lavapot")
	public static final Item LavaPot = new EmptyPot(Blocks.LAVA).setContainerItem(EmptyPot);

	@ObjectHolder("randogeek:emptycup")
	public static final Item Emptycup = new EmptyCup(Blocks.AIR);

	@ObjectHolder("randogeek:coffeecup")
	public static final Item Coffeecup = new EmptyCup(ModBlocks.COFFEE, "coffee").setContainerItem(Emptycup);

	@ObjectHolder("randogeek:lavacup")
	public static final Item Lavacup = new EmptyCup(Blocks.LAVA, "lava").setContainerItem(Emptycup);

	@ObjectHolder("randogeek:potlid")
	public static final Item PotLid = new Item();

	@ObjectHolder("randogeek:potbase")
	public static final Item PotBase = new Item();

	@ObjectHolder("randogeek:pothandle")
	public static final Item PotHandle = new Item();

	// 4 types of caramel popcorn

	@ObjectHolder("randogeek:caramelpopcorn")
	public static final Item CaramelPopcorn = new CaramelPopcorn(4, "original");

	@ObjectHolder("randogeek:goldcaramelpopcorn")
	public static final Item GoldCaramelPopcorn = new CaramelPopcorn(4, "gold");

	@ObjectHolder("randogeek:coffeecaramelpopcorn")
	public static final Item CoffeeCaramelPopcorn = new CaramelPopcorn(4, "coffee");

	@ObjectHolder("randogeek:lavacaramelpopcorn")
	public static final Item LavaCaramelPopcorn = new CaramelPopcorn(4, "lava");

	// Forked OSes

	@ObjectHolder("randogeek:fork")
	public static final Item Fork = new Item();

	@ObjectHolder("randogeek:forkedapple")
	public static final Item ForkedApple = new Item();

	@ObjectHolder("randogeek:forkedwindow")
	public static final Item ForkedWindow = new Item();

}
