package com.heartstone.mod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeartstoneMod implements ModInitializer {
    public static final String MOD_ID = "heartstone";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Heartstone...");
        ModItems.registerModItems();
    }
}