package geek.randogeek.proxy;

import geek.randogeek.init.ModBlocks;
import geek.randogeek.init.ModFluids;
import geek.randogeek.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
//import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 *
 */
public abstract class Proxy {

	/**
	 *
	 * @param event The Event.
	 */
	public void preInit(final FMLPreInitializationEvent event) {
		ModFluids.init();
	}

	/**
	 *
	 * @param event The Event.
	 */
	public void init(final FMLInitializationEvent event) {
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(Items.COAL, 1, 1), new ItemStack(ModItems.Plastic),
				0.4F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.CoffeeOre, new ItemStack(ModItems.CoffeeBean),
				0.4F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.CakeOre, new ItemStack(Items.CAKE), 0.4F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.IceOre, new ItemStack(Blocks.ICE), 0.4F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.CookieOre, new ItemStack(Items.COOKIE), 0.4F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.FrostedCookieOre,
				new ItemStack(ModItems.FrostedCookie), 0.4F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.IcecreamSandwichOre,
				new ItemStack(ModItems.IceCreamSandwhich), 0.4F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.FriedChickenOre,
				new ItemStack(ModItems.FriedChicken), 0.4F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.PopcornOre, new ItemStack(ModItems.Popcorn),
				0.4F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.CaramelOre, new ItemStack(ModItems.Caramel),
				0.4F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.WaffleOre, new ItemStack(ModItems.waffle), 0.4F);

	}

	/**
	 *
	 * @param event The Event.
	 */
	public void receiveIMC(final IMCEvent event) {
		//
	}

	/**
	 *
	 * @param event The Event.
	 */
	public void postInit(final FMLPostInitializationEvent event) {
		//
	}

	public World getWorld() {
		return null;
	}

}
