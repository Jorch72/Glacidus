package com.legacy.glacidus;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.config.Configuration;

public class ModConfig 
{

	public static int dimensionID;

	public static void initialization(File configFile)
	{
		if (!configFile.exists())
		{
			try 
			{
				configFile.createNewFile();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

		Configuration configuration = new Configuration(configFile);

		configuration.load();

		dimensionID = configuration.get("world configuration", "dimensionID", 84).getInt(84);

		configuration.save();
	}

}