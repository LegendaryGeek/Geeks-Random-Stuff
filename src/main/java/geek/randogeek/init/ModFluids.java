package geek.randogeek.init;

import geek.randogeek.RandoGeek;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 *
 */
public final class ModFluids {

	/**
	 *
	 */
	private ModFluids() {
		//
	}

	/**
	 *
	 */
	public final static Fluid COFFEE = new Fluid("coffee",
			new ResourceLocation(RandoGeek.MODID, "blocks/coffee_still"),
			new ResourceLocation(RandoGeek.MODID, "blocks/coffee_flow"));

	/**
	 *
	 */
	public static void init() {
		
		
		//COFFEE.setBlock(ModBlocks.COFFEE);
	 	COFFEE.setDensity(1);
		COFFEE.setViscosity(1);
		COFFEE.setTemperature(-300);
		COFFEE.setLuminosity(1);
		COFFEE.setUnlocalizedName(RandoGeek.MODID + "." + "coffee");
	
		FluidRegistry.registerFluid(COFFEE);
		FluidRegistry.addBucketForFluid(COFFEE);
	}
}
