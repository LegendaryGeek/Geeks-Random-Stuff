package geek.randogeek.client.gui;

import geek.randogeek.inventory.ContainerFoodInfuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public GuiHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos infuserPos = new BlockPos(x, y, z);
		
		return new ContainerFoodInfuser(player.inventory, (IInventory) world.getTileEntity(infuserPos));
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos infuserPos = new BlockPos(x, y, z);
		return new GUIFoodInfuser(player.inventory, (IInventory) world.getTileEntity(infuserPos));
	}

}
