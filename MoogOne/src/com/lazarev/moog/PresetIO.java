package com.lazarev.moog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;


/**
 * Static I/O utilities to read and write Moog One Preset files
 */
class PresetIO {

	private final static String SEPARATOR = " ";
	
	public static void readPresetFile(String path, Preset preset) {
		
		if (path == null || preset == null)
		{
			return;
		}
		
		File presetFile = new File(path);
		
		if (!presetFile.exists()) {
			System.out.println("Preset not found at [" + presetFile.getAbsolutePath() + "]");
			return;
		}
		
		System.out.println("Reading Preset at [" + presetFile.getAbsolutePath() + "]");
		
		try {
			FileInputStream fis = new FileInputStream(presetFile);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			
			String line;
			while ((line = reader.readLine()) != null) {
				
				// A very primitive yet effective split
				String[] tokens = line.split(SEPARATOR, 2);
				String parameter = tokens[0];
				String value = tokens[1];

				preset.orderedAdd(parameter, value);
			}
			
			reader.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// TODO: Need to change the Preset Name before writing
	public static void writePresetFile(String path, Preset preset) {
		
		File presetFile = new File(path);
		
		if (presetFile.exists()) {
			System.out.println("Overwriting Preset at [" + presetFile.getAbsolutePath() + "]");
		}
		
		try {
			
			FileOutputStream fos = new FileOutputStream(presetFile);
			BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(fos));
			

			Iterator<String> it = preset.iterator();
			
			while (it.hasNext()) {
				String parameter = it.next();
				String value = preset.getValue(parameter);
				
				writer.write(parameter);
				writer.write(SEPARATOR);
				writer.write(value);
				writer.write('\n');
			}
			
			writer.flush();
			fos.flush();
			writer.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
