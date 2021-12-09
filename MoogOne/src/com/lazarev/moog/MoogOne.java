package com.lazarev.moog;

public class MoogOne {

	public static void main(String[] args) {
		
		/* For local testing */
		args = new String[2]; 
		
		String currentDir = System.getProperty("user.dir");
		String inFile = currentDir + "\\bin\\presets\\WHERE IS THE BASS -LAZ.m1p";
		String outFile = currentDir + "\\bin\\presets\\NEW PRESET.m1p";
		
		args[0] = inFile;
		
		Preset preset = new Preset();
		
		/* ------------------ */
		
		if (args.length==0) {
			printHelp();
			System.exit(0);
		}
		
		if (args[0] != null) {
			PresetIO.readPresetFile(args[0], preset);
		}
		
		System.out.println("Preset has " + preset.size() + " attributes.");

		PresetIO.writePresetFile(outFile, preset);
		
	}

	private static void printHelp() {
		System.out.println("Usage: MoogOne <preset.m1p>");
	}
	
	
}
