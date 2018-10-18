package org.stopmodreposts.stopmodreposts;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StopModReposts.MODID, version = StopModReposts.VERSION, name = StopModReposts.NAME, acceptedMinecraftVersions = StopModReposts.ACCEPTEDVERSIONS, certificateFingerprint = "893c317856cf6819b3a8381c5664e4b06df7d1cc")
public class StopModReposts {

	public static final String MODID = "stopmodreposts";
	public static final String NAME = "Stop Mod Reposts";
	public static final String VERSION = "1.12.2-1.0.0-SNAPSHOT";
	public static final String ACCEPTEDVERSIONS = "[1.12.2,1.13)";
	public static final String UPDATE_JSON = "";
	public static final String URL = "http://stopmodreposts.org/";
	public static final String DEPENDECIES = "";
	public static final List<String> AUTHORS = Arrays.asList("JTK222");
	public static final String CREDITS = "Lead Programmer: JTK222";
	public static final String DESCRIPTION = "";


	private static boolean hasShown = false;
	public static File STOP_REPOST_FILE;

	public static Logger LOGGER = null;

	public static boolean shouldShowUp() {
		if(!hasShown) {
			hasShown = true;
			return true;
		}else {
			//Uncomment bottom one, to get this displayed in dev environment.
			return false;
			//return (Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");
		}

	}

	@EventHandler
	public void init(FMLPreInitializationEvent event) {
		LOGGER = LogManager.getLogger(MODID);

		STOP_REPOST_FILE = new File("./StopModReposts.info");
		hasShown = STOP_REPOST_FILE.exists();

		/**
		 * TODO Replace with mcmod.info file
		 * Initialize mcmod.info in code
		 */
		ModMetadata meta = event.getModMetadata();
		meta.autogenerated = false;
		meta.modId = MODID;
		meta.name = NAME;
		meta.authorList = AUTHORS;
		meta.credits = CREDITS;
		meta.description = DESCRIPTION;
		meta.version = VERSION;
		meta.updateJSON = UPDATE_JSON;
		meta.url = URL;
	}

}
