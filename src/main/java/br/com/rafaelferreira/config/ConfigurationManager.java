package br.com.rafaelferreira.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

	public static Configuration getConfiguration() {
		return ConfigCache.getOrCreate(Configuration.class);
	}
}
