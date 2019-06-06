package geek.randogeek.init;

import geek.randogeek.RandoGeek;
import geek.randogeek.item.*;
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

	/**
	 *
 	 */
	@ObjectHolder("randogeek:plastic")
	public static final Item Plastic = new Plastic();
	
	@ObjectHolder("randogeek:plastick")
	public static final Item plaStick = new plaStick();
	
	@ObjectHolder("randogeek:coffeebean")
	public static final Item CoffeeBean = new CoffeeBean();
	
	@ObjectHolder("randogeek:fork")
	public static final Item Fork = new Item();
	
	@ObjectHolder("randogeek:forkedapple")
	public static final Item ForkedApple = new Item();
	
}
