package geek.randogeek.item.recipes;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class InfuserRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

	private Ingredient input1;
	private Ingredient input2;
	private ItemStack output;
	
	public InfuserRecipe(Ingredient input1, Ingredient input2, ItemStack output) {
		this.input1 = input1;
		this.input2 = input2;
		this.output = output;
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		// TODO Auto-generated method stub
		return this.output;
	}

	@Override
	public boolean canFit(int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getRecipeOutput() {
		// TODO Auto-generated method stub
		return this.output;
	}

}
