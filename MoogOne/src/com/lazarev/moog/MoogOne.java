package com.lazarev.moog;

/**
 * START HERE
 * 
 * @author Mike Lazarev
 *
 * TODO : Need to change the Preset Name before writing
 * TODO : Enable all Synths
 *
 */

public class MoogOne {

	public static boolean isDebug = true;
	
	public static void main(String[] args) {
		
		/* For local testing */
		args = new String[2]; 
		
		String currentDir = System.getProperty("user.dir");
		String inFile = currentDir + "\\src\\presets\\INIT0.m1p";
		String outFile = currentDir + "\\src\\presets\\";
		
		args[0] = inFile;
		
		Preset preset = new Preset();
		
		/* ----------------------------------------------------------------------- */
		
		if (args.length==0) {
			printHelp();
			System.exit(0);
		}
		
		if (args[0] != null) {
			PresetIO.readPresetFile(args[0], preset);
			System.out.println("Preset has " + preset.size() + " attributes.");
		}
		
		
		int newPresets = 5;
		System.out.println("Generating " + newPresets + " new Presets");
		
		for (int i = 1; i <= newPresets; i++)
		{
			String newFile = outFile + "A RANDOM PRESET " + i + ".m1p";

			PresetRandomizer.randomizeAllOscillators(preset);
			
			PresetIO.writePresetFile(newFile, preset);
 		}
		
		
	}

	private static void printHelp() {
		System.out.println("Usage: MoogOne <preset.m1p>");
	}
	
	
}
