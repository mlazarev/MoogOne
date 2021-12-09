package com.lazarev.moog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PresetIOTest {

	Preset preset;
	String presetFile;
	String currentDir;
	
	@Before
	public void makePreset() {
		preset = new Preset();
		
		currentDir = System.getProperty("user.dir");
		presetFile = currentDir + "\\bin\\presets\\WHERE IS THE BASS -LAZ.m1p";
	}
	
	@Test
	public void testReadNullFile() {
		PresetIO.readPresetFile(null, null);
	}

	@Test
	public void testReadNonExistingFile() {
		
		String nonExistingFile = currentDir + "\\bin\\BAD PRESET.m1p";
		
		PresetIO.readPresetFile(nonExistingFile, preset);
		Assert.assertTrue(preset.size() == 0);
	}

	@Test
	public void testReadKnownPreset() {
		PresetIO.readPresetFile(presetFile, preset);
		
		// This Preset has exactly 3198 Attributes
		Assert.assertTrue(preset.size() == 3198);
	}

	
	@Test
	public void testReadWriteIdentical() {
		String testFile = currentDir + "\\bin\\presets\\Test.m1p";
		
		PresetIO.readPresetFile(presetFile, preset);
		
		PresetIO.writePresetFile(testFile, preset);
		
		File original = new File(presetFile);
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
