package geek.randogeek.item.armour;

import javax.annotation.Nonnull;

import geek.randogeek.RandoGeek;
import geek.randogeek.util.GeekTab;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IceHorseArmour extends Item {

	public IceHorseArmour() {
		this.setMaxStackSize(1);
		this.setCreativeTab(GeekTab.instance);
	}

	@Override
	@Nonnull
	public HorseArmorType getHorseArmorType(final ItemStack stack) {
		return RandoGeek.ICE_HORSE_ARMOR;
	}

	@Override
	public void onHorseArmorTick(final World world, final EntityLiving horse, final ItemStack armor) {
		// TODO: maybe a freezing enchantment for the horse?
		super.onHorseArmorTick(world, horse, armor);
	}

}
