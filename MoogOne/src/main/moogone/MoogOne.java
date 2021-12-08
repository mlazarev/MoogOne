package main.moogone;

public class MoogOne {

	public static void main(String[] args) {
		
		/* For local testing */
		args = new String[2]; 
		
		String currentDir = System.getProperty("user.dir");
		String inFile = currentDir + "\\bin\\patches\\WHERE IS THE BASS -LAZ.m1p";
		String outFile = currentDir + "\\bin\\patches\\NEW PATCH.m1p";
		
		args[0] = inFile;
		
		Patch patch = new Patch();
		
		/* ------------------ */
		
		if (args.length==0) {
			printHelp();
			System.exit(0);
		}
		
		if (args[0] != null) {
			PatchIO.readPatchFile(args[0], patch);
		}
		
		System.out.println("Patch has " + patch.size() + " attributes.");

		PatchIO.writePatchFile(outFile, patch);
		
	}

	private static void printHelp() {
		System.out.println("Usage: MoogOne <patch.m1p>");
	}
	
	
}
