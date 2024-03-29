package geek.randogeek.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerFoodInfuser extends Container {
	private final IInventory tileFoodInfuser;
	private int fuseTime;
	private int totalFuseTime;
	private int infuserFusionTime;
	private int currentItemFusionTime;

	public ContainerFoodInfuser(InventoryPlayer playerInventory, IInventory infuserInventory) {
		this.tileFoodInfuser = infuserInventory;
		this.addSlotToContainer(new Slot(infuserInventory, 0, 56, 17));
		this.addSlotToContainer(new Slot(infuserInventory, 1, 22, 17));
		this.addSlotToContainer(new SlotFoodInfuserFuel(infuserInventory, 2, 56, 53));
		this.addSlotToContainer(new SlotFoodInfuserOutput(playerInventory.player, infuserInventory, 3, 116, 35));

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}

	public void addListener(IContainerListener listener) {
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tileFoodInfuser);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); ++i) {
			IContainerListener icontainerlistener = this.listeners.get(i);

			if (this.fuseTime != this.tileFoodInfuser.getField(2) ) {
				icontainerlistener.sendWindowProperty(this, 2, this.tileFoodInfuser.getField(2));
			}

			if (this.infuserFusionTime != this.tileFoodInfuser.getField(0)) {
				icontainerlistener.sendWindowProperty(this, 0, this.tileFoodInfuser.getField(0));
			}

			if (this.currentItemFusionTime != this.tileFoodInfuser.getField(1)) {
				icontainerlistener.sendWindowProperty(this, 1, this.tileFoodInfuser.getField(1));
			}

			if (this.totalFuseTime != this.tileFoodInfuser.getField(3)) {
				icontainerlistener.sendWindowProperty(this, 3, this.tileFoodInfuser.getField(3));
			}
		}

		this.fuseTime = this.tileFoodInfuser.getField(2);
		this.infuserFusionTime = this.tileFoodInfuser.getField(0);
		this.currentItemFusionTime = this.tileFoodInfuser.getField(1);
		this.totalFuseTime = this.tileFoodInfuser.getField(3);
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		this.tileFoodInfuser.setField(id, data);
	}

	/**
	 * Determines whether supplied player can use this container
	 */
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tileFoodInfuser.isUsableByPlayer(playerIn);
	}

	/**
	 * Handle when the stack in slot {@code index} is shift-clicked. Normally this
	 * moves the stack between the player inventory and the other inventory(s).
	 */
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		return ContainerUtil.transferStackInSlot(playerIn, index, this);
	}
}
