package geek.randogeek.events;

import geek.randogeek.RandoGeek;
import geek.randogeek.fluid.FluidStateMapper;
import geek.randogeek.init.ModBlocks;
import geek.randogeek.init.ModFluids;
import geek.randogeek.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 *
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = RandoGeek.MODID)
public final class ClientEventHandler {

	/**
	 *
	 */
	private ClientEventHandler() {
		//
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerModels(final ModelRegistryEvent event) {
		registerModel(Item.getItemFromBlock(ModBlocks.BlockPlastic));
		registerModel(Item.getItemFromBlock(ModBlocks.CoffeeOre));
		registerFluidRender(ModBlocks.COFFEE, ModFluids.COFFEE);
		registerModel(ModItems.CoffeeBean);
		registerModel(ModItems.CoffeePot);
		registerModel(ModItems.EmptyPot);
		registerModel(ModItems.LavaPot);
		registerModel(ModItems.Plastic);
		registerModel(ModItems.plaStick);
		registerModel(ModItems.Fork);
		registerModel(ModItems.ForkedApple);
		registerModel(ModItems.PotBase);
		registerModel(ModItems.PotHandle);
		registerModel(ModItems.PotLid);
		registerModel(ModItems.CaramelPopcorn);
		registerModel(ModItems.CoffeeCaramelPopcorn);
		registerModel(ModItems.GoldCaramelPopcorn);
		registerModel(ModItems.LavaCaramelPopcorn);
		registerModel(ModItems.Emptycup);
		registerModel(ModItems.EmptyBigCup);
		registerModel(ModItems.Coffeecup);
		registerModel(ModItems.CoffeeBigcup);
		registerModel(ModItems.Lavacup);
		registerModel(ModItems.LavaBigcup);

	}

	/**
	 *
	 * @param item The Item.
	 */
	private static void registerModel(final Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	/**
	 *
	 * @param block The Block.
	 * @param fluid The Fluid.
	 */
	@SideOnly(Side.CLIENT)
	private static void registerFluidRender(final Block block, final Fluid fluid) {
		final Item item = Item.getItemFromBlock(block);
		final ResourceLocation resourceLocation = new ResourceLocation(RandoGeek.MODID, fluid.getName());
		final FluidStateMapper mapper = new FluidStateMapper(resourceLocation.getNamespace() + ":" + fluid.getName());

		if (item != null) {
			ModelBakery.registerItemVariants(item);
			ModelLoader.setCustomMeshDefinition(item, mapper);
		}
		ModelLoader.setCustomStateMapper(block, mapper);
	}
}
