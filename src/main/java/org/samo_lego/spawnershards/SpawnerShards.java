package org.samo_lego.spawnershards;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpawnerShards implements ModInitializer {
	private static final Logger LOGGER = LogManager.getLogger();
	@Override
	public void onInitialize() {
		LOGGER.info("[SpawnerShards] Loading Spawner Shards.");
	}
}