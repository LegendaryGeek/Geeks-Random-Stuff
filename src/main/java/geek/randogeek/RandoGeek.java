package geek.randogeek;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import geek.randogeek.proxy.Proxy;
import geek.randogeek.util.GeekTab;
import geek.randogeek.world.OreGenerator;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 *
 */
@Mod(modid = RandoGeek.MODID, name = RandoGeek.NAME, version = RandoGeek.VERSION, dependencies = "required-after:forge@[14.23.4.2705,)", useMetadata = false, clientSideOnly = false, serverSideOnly = false, acceptedMinecraftVersions = "[1.12.2]", canBeDeactivated = false)
public final class RandoGeek {

	/* The Mod's Instance. */
	// @Mod.Instance
	// private static ExampleMod instance = null

	/** ID of this Mod. */
	public static final String MODID = "randogeek";

	/** Display name of this Mod. */
	public static final String NAME = "Geek's Random Stuff";

	/** Version of this Mod. */
	public static final String VERSION = "2.0.3";

	public static final Item.ToolMaterial ICE_TOOL_MATERIAL;
	public static final Item.ToolMaterial DIRT_TOOL_MATERIAL;
	public static final ItemArmor.ArmorMaterial ICE_ARMOR_MATERIAL;
	public static final ItemArmor.ArmorMaterial DIRT_ARMOR_MATERIAL;
	public static final HorseArmorType ICE_HORSE_ARMOR;

	static {
		ICE_TOOL_MATERIAL = EnumHelper.addToolMaterial(new ResourceLocation(MODID, "ice").toString(),
				// DIAMOND(3, 1561, 8.0F, 3.0F, 10),
				4, 1561, 12F, 4.0F, 30);
		DIRT_TOOL_MATERIAL = EnumHelper.addToolMaterial(new ResourceLocation(MODID, "dirt").toString(),
				// DIAMOND(3, 1561, 8.0F, 3.0F, 10),
				10, 1, 100F, 999999.1F, 3000);
		ICE_ARMOR_MATERIAL = EnumHelper.addArmorMaterial(new ResourceLocation(MODID, "ice").toString(),
				new ResourceLocation(MODID, "ice").toString(),
				// DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10,
				// SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
				33, new int[] { 3, 6, 8, 3 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
		DIRT_ARMOR_MATERIAL = EnumHelper.addArmorMaterial(new ResourceLocation(MODID, "dirt").toString(),
				new ResourceLocation(MODID, "dirt").toString(),
				// DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10,
				// SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
				1, new int[] { 1, 1, 1, 1 }, 30000, SoundEvents.BLOCK_GRASS_STEP, 9999.0F);
		ICE_HORSE_ARMOR = EnumHelper.addHorseArmor(new ResourceLocation(MODID, "ice").toString(),
				// DIAMOND(11, "diamond", "dio");
				new ResourceLocation(MODID, "textures/entities/horse/armor/horse_armor_ice.png").toString(), 12);
	}

	/**
	 *
	 */
	public static final Logger LOGGER = LogManager.getLogger(RandoGeek.MODID);

	/**
	 *
	 */
	private static final class InstanceHolder {

		/**
		 * The Instance.
		 */
		private static final RandoGeek INSTANCE = new RandoGeek();
	}

	/**
	 *
	 * @return The Mod's Instance.
	 */
	@Mod.InstanceFactory
	public static RandoGeek instance() {
		return InstanceHolder.INSTANCE;

	}

	/**
	 *
	 */
	@SidedProxy(clientSide = "geek.randogeek.proxy.ClientProxy", serverSide = "geek.randogeek.proxy.ServerProxy")
	private static Proxy proxy = null;

	/**
	 *
	 * @param event The Event.
	 */
	@Mod.EventHandler
	public static void preInit(final FMLPreInitializationEvent event) {
		FluidRegistry.enableUniversalBucket();
		proxy.preInit(event);
		GameRegistry.registerWorldGenerator(new OreGenerator(), 3);
		GeekTab.init();
	}

	/**
	 *
	 * @param event The Event.
	 */
	@Mod.EventHandler
	public static void init(final FMLInitializationEvent event) {
		proxy.init(event);
	}

	/**
	 *
	 * @param event The Event.
	 */
	@Mod.EventHandler
	public static void receiveIMC(final IMCEvent event) {
		proxy.receiveIMC(event);
	}

	/**
	 *
	 * @param event The Event.
	 */
	@Mod.EventHandler
	public static void postInit(final FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

	public static World getWorld() {
		return proxy.getWorld();
	}

}
