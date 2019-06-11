package geek.randogeek.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class CaramelPopcorn extends ItemFood {
	String type;

	public CaramelPopcorn(int amount, String type) {
		super(amount, false);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		if (type.equals("original")) {
			entityLiving.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2400));
		} else if (type.equals("gold")) {
			entityLiving.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 400, 1));
			entityLiving.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 0));
			entityLiving.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
			entityLiving.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 3));
		} else if (type.equals("coffee")) {
			entityLiving.addPotionEffect(new PotionEffect(MobEffects.SPEED, 6000, 5));
			entityLiving.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 6000, 5));
		} else if (type.equals("lava")) {
			entityLiving.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
		}
		return stack;
	}
}
