package geek.randogeek.item.recipes;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FoodInfuser_Recipes {
	private static final FoodInfuser_Recipes INFUSING_BASE = new FoodInfuser_Recipes();
	/** The list of infusing results. */
	private final Map<ItemStack, ItemStack> infuserList = Maps.<ItemStack, ItemStack>newHashMap();
	/**
	 * A list which contains how many experience points each recipe output will
	 * give.
	 */
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
//	private Ingredient input1;
//	private Ingredient input2;
//	private ItemStack output;

	public static FoodInfuser_Recipes instance() {
		return INFUSING_BASE;
	}

	private FoodInfuser_Recipes() {

	}

	/**
	 * Adds a infusing recipe, where the input item is an instance of Block.
	 */
	public void addInfusingRecipeForBlock(Block input, ItemStack stack, float experience) {
		this.addInfuse(Item.getItemFromBlock(input), stack, experience);
	}

	/**
	 * Adds a infusing recipe using an Item as the input item.
	 */
	public void addInfuse(Item input, ItemStack stack, float experience) {
		this.addInfusingRecipe(new ItemStack(input, 1, 32767), stack, experience);
	}

	/**
	 * Adds a infusing recipe using an ItemStack as the input for the recipe.
	 */
	public void addInfusingRecipe(ItemStack input, ItemStack stack, float experience) {
		if (getInfusingResult(input) != ItemStack.EMPTY) {
			net.minecraftforge.fml.common.FMLLog.log.info("Ignored Freezing recipe with conflicting input: {} = {}",
					input, stack);
			return;
		}
		this.infuserList.put(input, stack);
		this.experienceList.put(stack, Float.valueOf(experience));
	}

	/**
	 * Returns the infusing result of an item.
	 */
	public ItemStack getInfusingResult(ItemStack stack) {
		for (Entry<ItemStack, ItemStack> entry : this.infuserList.entrySet()) {
			if (this.compareItemStacks(stack, entry.getKey())) {
				return entry.getValue();
			}
		}

		return ItemStack.EMPTY;
	}

	/**
	 * Compares two itemstacks to ensure that they are the same. This checks both
	 * the item and the metadata of the item.
	 */
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
		return stack2.getItem() == stack1.getItem()
				&& (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}

	public Map<ItemStack, ItemStack> getInfusingList() {
		return this.infuserList;
	}

	public float getInfusingExperience(ItemStack stack) {
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1)
			return ret;

		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
			if (this.compareItemStacks(stack, entry.getKey())) {
				return ((Float) entry.getValue()).floatValue();
			}
		}

		return 0.0F;
	}
}
