package geek.randogeek.init;

import geek.randogeek.RandoGeek;
import geek.randogeek.item.*;
import geek.randogeek.item.CoffeeBean;
import geek.randogeek.item.armour.*;
import geek.randogeek.item.tool.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 *
 */
@GameRegistry.ObjectHolder(RandoGeek.MODID)
public final class ModItems {

	// TODO: hot fudge, cherries, whipped cream

	@ObjectHolder("randogeek:caramel")
	public static final Item Caramel = new ItemFood(3, 1.5f, false);

	@ObjectHolder("randogeek:caramelpopcorn")
	public static final Item CaramelPopcorn = new CaramelPopcorn(4, "original");

	@ObjectHolder("randogeek:coffeebean")
	public static final Item CoffeeBean = new CoffeeBean();

	@ObjectHolder("randogeek:emptybigcup")
	public static final Item EmptyBigCup = new EmptyBigCup(Blocks.AIR);

	@ObjectHolder("randogeek:emptycup")
	public static final Item Emptycup = new EmptyCup(Blocks.AIR);

	@ObjectHolder("randogeek:emptypot")
	public static final Item EmptyPot = new EmptyPot(Blocks.AIR);

	@ObjectHolder("randogeek:coffeebigcup")
	public static final Item CoffeeBigcup = new EmptyBigCup(ModBlocks.COFFEE, "coffee").setContainerItem(EmptyBigCup);

	@ObjectHolder("randogeek:coffeecaramelpopcorn")
	public static final Item CoffeeCaramelPopcorn = new CaramelPopcorn(4, "coffee");

	@ObjectHolder("randogeek:coffeecup")
	public static final Item Coffeecup = new EmptyCup(ModBlocks.COFFEE, "coffee").setContainerItem(Emptycup);

	@ObjectHolder("randogeek:coffeepot")
	public static final Item CoffeePot = new EmptyPot(ModBlocks.COFFEE).setContainerItem(EmptyPot);

	@ObjectHolder("randogeek:fork")
	public static final Item Fork = new Item();

	@ObjectHolder("randogeek:forkedapple")
	public static final Item ForkedApple = new Item();

	@ObjectHolder("randogeek:forkedwindow")
	public static final Item ForkedWindow = new Item();

	@ObjectHolder("randogeek:goldcaramelpopcorn")
	public static final Item GoldCaramelPopcorn = new CaramelPopcorn(4, "gold");

	@ObjectHolder("randogeek:iceaxe")
	public static final Item IceAxe = new IceAxe();

	@ObjectHolder("randogeek:iceboots")
	public static final Item IceBooties = new IceBooties();

	@ObjectHolder("randogeek:icechestplate")
	public static final Item IceChestplate = new IceChestplate();

	@ObjectHolder("randogeek:icehelm")
	public static final Item IceHelm = new IceHelm();

	@ObjectHolder("randogeek:icehoe")
	public static final Item IceHoe = new IceHoe();

	@ObjectHolder("randogeek:iceleggings")
	public static final Item IceLegs = new IceLeggings();

	@ObjectHolder("randogeek:icepickaxe")
	public static final Item IcePickaxe = new IcePickaxe();

	@ObjectHolder("randogeek:iceshovel")
	public static final Item IceShovel = new IceShovel();

	@ObjectHolder("randogeek:icesword")
	public static final Item IceSword = new IceSword();

	@ObjectHolder("randogeek:lavabigcup")
	public static final Item LavaBigcup = new EmptyBigCup(Blocks.LAVA, "lava").setContainerItem(EmptyBigCup);

	@ObjectHolder("randogeek:lavacaramelpopcorn")
	public static final Item LavaCaramelPopcorn = new CaramelPopcorn(4, "lava");

	@ObjectHolder("randogeek:lavacup")
	public static final Item Lavacup = new EmptyCup(Blocks.LAVA, "lava").setContainerItem(Emptycup);

	@ObjectHolder("randogeek:lavapot")
	public static final Item LavaPot = new EmptyPot(Blocks.LAVA).setContainerItem(EmptyPot);

	@ObjectHolder("randogeek:plastic")
	public static final Item Plastic = new Plastic();

	@ObjectHolder("randogeek:plastick")
	public static final Item plaStick = new plaStick();

	@ObjectHolder("randogeek:popcorn")
	public static final Item Popcorn = new ItemFood(3, 1.5f, false);

	@ObjectHolder("randogeek:potbase")
	public static final Item PotBase = new Item();

	@ObjectHolder("randogeek:pothandle")
	public static final Item PotHandle = new Item();

	@ObjectHolder("randogeek:potlid")
	public static final Item PotLid = new Item();

	@ObjectHolder("randogeek:icecreamsandwhich")
	public static final Item IceCreamSandwhich = new ItemFood(1, 1.5f, false);

	@ObjectHolder("randogeek:friedchicken")
	public static final Item FriedChicken = new ItemFood(1, 1.5f, false);

	@ObjectHolder("randogeek:frostedcookie")
	public static final Item FrostedCookie = new ItemFood(1, 1.5f, false);

	@ObjectHolder("randogeek:waffle")
	public static final Item waffle = new Item();
	
	@ObjectHolder("randogeek:dirtaxe")
	public static final Item DirtAxe = new DirtAxe();
	
	@ObjectHolder("randogeek:dirtpickaxe")
	public static final Item DirtPickaxe = new DirtPickaxe();
	
	@ObjectHolder("randogeek:dirtshovel")
	public static final Item DirtShovel = new DirtSpade();
	
	@ObjectHolder("randogeek:dirthoe")
	public static final Item DirtHoe = new DirtHoe();
	
	@ObjectHolder("randogeek:dirtsword")
	public static final Item DirtSword = new DirtSword();
	
	@ObjectHolder("randogeek:dirthelmet")
	public static final Item DirtHelmet = new DirtHelm();
	
	@ObjectHolder("randogeek:dirtchestplate")
	public static final Item DirtChestplate = new DirtChestplate();
	
	@ObjectHolder("randogeek:dirtlegs")
	public static final Item Dirtlegs = new DirtLegs();
	
	@ObjectHolder("randogeek:dirtboots")
	public static final Item DirtBoots = new DirtBoots();
	

	/**
	 *
	 */
	private ModItems() {
		//
	}

}
