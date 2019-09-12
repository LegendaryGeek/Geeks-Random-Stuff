package geek.randogeek.item.armour;

import geek.randogeek.RandoGeek;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IceHelm extends ItemArmor {

	int air;
	int ticks = 15;
	
	public IceHelm() {
		super(RandoGeek.ICE_ARMOR_MATERIAL, 3, EntityEquipmentSlot.HEAD);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if(player.isInWater()) {
			air =  player.getAir();
			if(ticks == 1) {
				player.setAir(air + 3);
				ticks = 27;
			} else {
				ticks--;
			}
		}
	}
}
