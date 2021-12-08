package main.moogone;

public class MoogOne {

	public static void main(String[] args) {
		
		args = new String[10]; 
		args[0] = "C:\\Users\\Mike\\git\\MoogOne\\MoogOne\\src\\patches\\WHERE IS THE BASS -LAZ.m1p";
		
		Patch patch = new Patch();
		
		
		if (args.length==0) {
			printHelp();
			System.exit(0);
		}
		
		if (args[0] != null) {
			PatchIO.readPatchFile(args[0], patch);
		}
		
		System.out.println("Patch has " + patch.size() + " attributes.");

		PatchIO.writePatchFile("D:\\temp\\testOut.m1p", patch);
		
	}

	private static void printHelp() {
		System.out.println("Usage: MoogOne <patch.m1p>");
	}
	
	
}
