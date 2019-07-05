package geek.randogeek.events;



import geek.randogeek.RandoGeek;
import geek.randogeek.init.ModBlocks;
import geek.randogeek.init.ModFluids;
import geek.randogeek.init.ModItems;
import geek.randogeek.util.GeekTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
@Mod.EventBusSubscriber(value = { Side.CLIENT, Side.SERVER }, modid = RandoGeek.MODID)
public final class CommonEventHandler {
	protected static java.util.Random RANDOM = new java.util.Random();
	/**
	 *
	 */
	private CommonEventHandler() {
		//
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void onRemapBlock(final RegistryEvent.MissingMappings<Block> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getMappings()) {
			mapping.ignore();
		}
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void onRemapItem(final RegistryEvent.MissingMappings<Item> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getMappings()) {
			mapping.ignore();
		}
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(setupBlock(ModBlocks.BlockPlastic, "blockplastic"));
		event.getRegistry().register(setupBlock(ModBlocks.CoffeeOre, "coffeeore"));
		event.getRegistry().register(setupBlock(new BlockFluidClassic(ModFluids.COFFEE, Material.WATER), "coffee"));
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(setupItemBlock(ModBlocks.BlockPlastic));
		event.getRegistry().register(setupItemBlock(ModBlocks.CoffeeOre));
		// event.getRegistry().register(setupItemBlock(ModBlocks.COFFEE));
		event.getRegistry().register(setupItem(ModItems.Plastic, "plastic"));
		event.getRegistry().register(setupItem(ModItems.CoffeePot, "coffeepot"));
		event.getRegistry().register(setupItem(ModItems.EmptyPot, "emptypot"));
		event.getRegistry().register(setupItem(ModItems.Emptycup, "emptycup"));
		event.getRegistry().register(setupItem(ModItems.EmptyBigCup, "emptybigcup"));
		event.getRegistry().register(setupItem(ModItems.Coffeecup, "coffeecup"));
		event.getRegistry().register(setupItem(ModItems.Lavacup, "lavacup"));
		event.getRegistry().register(setupItem(ModItems.CoffeeBigcup, "bigcoffeecup"));
		event.getRegistry().register(setupItem(ModItems.LavaBigcup, "biglavacup"));
		event.getRegistry().register(setupItem(ModItems.LavaPot, "lavapot"));
		event.getRegistry().register(setupItem(ModItems.plaStick, "plastick"));
		event.getRegistry().register(setupItem(ModItems.CoffeeBean, "coffeebean"));
		event.getRegistry().register(setupItem(ModItems.Fork, "fork"));
		event.getRegistry().register(setupItem(ModItems.ForkedApple, "forkedapple"));
		event.getRegistry().register(setupItem(ModItems.PotBase, "potbase"));
		event.getRegistry().register(setupItem(ModItems.PotHandle, "pothandle"));
		event.getRegistry().register(setupItem(ModItems.PotLid, "potlid"));
		event.getRegistry().register(setupItem(ModItems.CaramelPopcorn, "caramelpopcorn"));
		event.getRegistry().register(setupItem(ModItems.GoldCaramelPopcorn, "goldcaramelpopcorn"));
		event.getRegistry().register(setupItem(ModItems.CoffeeCaramelPopcorn, "coffeecaramelpopcorn"));
		event.getRegistry().register(setupItem(ModItems.LavaCaramelPopcorn, "lavacaramelpopcorn"));

	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
		//
	}

	/**
	 *
	 * @param block The Block.
	 * @param name  The Name.
	 * @return The Block
	 */
	private static Block setupBlock(final Block block, final String name) {
		block.setRegistryName(name);
		block.setTranslationKey(RandoGeek.MODID + "." + name);

		return block;
	}

	/**
	 *
	 * @param block The Block.
	 * @return The ItemBlock.
	 */
	private static ItemBlock setupItemBlock(final Block block) {
		final ItemBlock itemBlock = new ItemBlock(block);
		final ResourceLocation name = block.getRegistryName();
		itemBlock.setRegistryName(name);
		block.setCreativeTab(GeekTab.instance);

		return itemBlock;
	}

	/**
	 *
	 * @param item The Item.
	 * @param name The Name.
	 * @return The Item.
	 */
	private static Item setupItem(final Item item, final String name) {
		item.setRegistryName(name);
		item.setTranslationKey(RandoGeek.MODID + "." + name);
		item.setCreativeTab(GeekTab.instance);

		return item;
	}
}
