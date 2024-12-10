package jeb.jjba;

import jeb.jjba.block.ModBlockEntityTypes;
import jeb.jjba.block.ModBlocks;
import jeb.jjba.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.math.random.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JebsJustBustedAdditions implements ModInitializer {
	public static final String MOD_ID = "jebs-just-busted-additions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		String[] messages = {"Your next line is... \"Is that a JoJo reference?!\"",
				"Committing heresy since 1997!",
				"opengl tutorial 2025 absolute beginner... wait this isn't google",
				"this is a funny message to inform you that the mod has loaded!",
				"when you're trying to make a minecraft mod but you're just a chill guy",
				"quaternion jumpscare",
				"I would NOT survive parkour civilization.",
				"not to get political or anything, but what the fuck is a UV texture????",
				"Mod successfully loaded! Deploying Remote Access Tools in 3... 2... 1... Just kidding!",
				"Locked and loaded! Let's bust it!.. oh, that came out wrong",
				"hi, are you looking through here 'cause the game crashed? my condolences"
		};

		LOGGER.info("[Jeb's Just Busted Additions] : " + messages[Random.create().nextBetween(0, messages.length-1)]);
		ModItems.initialize();
		ModBlocks.initialize();
		ModBlockEntityTypes.initialize();
	}
}