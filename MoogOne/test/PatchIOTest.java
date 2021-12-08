import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.moogone.Patch;
import main.moogone.PatchIO;

public class PatchIOTest {

	Patch patch;
	String patchFile;
	String currentDir;
	
	@Before
	public void makePatch() {
		patch = new Patch();
		
		currentDir = System.getProperty("user.dir");
		patchFile = currentDir + "\\bin\\patches\\WHERE IS THE BASS -LAZ.m1p";
	}
	
	@Test
	public void testReadNullFiles() {
		PatchIO.readPatchFile(null, null);
	}

	@Test
	public void testReadNonExistingFile() {
		
		String nonExistingFile = currentDir + "\\bin\\BAD PATCH.m1p";
		
		PatchIO.readPatchFile(nonExistingFile, patch);
		Assert.assertTrue(patch.size() == 0);
	}

	@Test
	public void testReadKnownPatch() {
		PatchIO.readPatchFile(patchFile, patch);
		
		// This Patch has exactly 3198 Attributes
		Assert.assertTrue(patch.size() == 3198);
	}

	
	@Test
	public void testReadWriteIdentical() {
		String testFile = currentDir + "\\bin\\patches\\Test.m1p";
		
		PatchIO.readPatchFile(patchFile, patch);
		
		PatchIO.writePatchFile(testFile, patch);
		
		File original = new File(patchFile);
		File generated = new File(testFile);

		try {
			
			FileInputStream fis1 = new FileInputStream(original);
			FileInputStream fis2 = new FileInputStream(generated);
			
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(fis1));
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(fis2));
			
			String line1, line2;
			
			while ((line1 = reader1.readLine()) != null ) {
				line2 = reader2.readLine();
				
				Assert.assertTrue(line1.contentEquals(line2));
			}
			
			reader1.close();
			fis1.close();
			
			// Is there more data at the end of File2?
			Assert.assertTrue(reader2.readLine() == null);

			reader2.close();
			fis2.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		generated.delete();
	}
	
	
}
