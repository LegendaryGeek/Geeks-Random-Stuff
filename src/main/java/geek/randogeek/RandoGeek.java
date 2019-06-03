package geek.randogeek;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import geek.randogeek.proxy.Proxy;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
	public static final String VERSION = "0.0.0";
//	public static final String VERSION = "@MOD_VERSION@"

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
	@SidedProxy(clientSide = "geek.randogeek.proxy.ClientProxy", serverSide = "geek.randogeek.examplemod.proxy.ServerProxy")
	private static Proxy proxy = null;

	/**
	 *
	 * @param event The Event.
	 */
	@Mod.EventHandler
	public static void preInit(final FMLPreInitializationEvent event) {
		proxy.preInit(event);
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
