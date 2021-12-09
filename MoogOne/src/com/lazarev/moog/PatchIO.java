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
 * Static I/O utilities to read and write Moog One Patch files
 */
class PatchIO {

	private final static String SEPARATOR = " ";
	
	public static void readPatchFile(String path, Patch patch) {
		
		if (path == null || patch == null)
		{
			return;
		}
		
		File patchFile = new File(path);
		
		if (!patchFile.exists()) {
			System.out.println("Patch not found at [" + patchFile.getAbsolutePath() + "]");
			return;
		}
		
		System.out.println("Reading Patch at [" + patchFile.getAbsolutePath() + "]");
		
		try {
			FileInputStream fis = new FileInputStream(patchFile);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			
			String line;
			while ((line = reader.readLine()) != null) {
				
				// A very primitive yet effective split
				String[] tokens = line.split(SEPARATOR, 2);
				String parameter = tokens[0];
				String value = tokens[1];

				patch.orderedAdd(parameter, value);
			}
			
			reader.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void writePatchFile(String path, Patch patch) {
		
		File patchFile = new File(path);
		
		if (patchFile.exists()) {
			System.out.println("Overwriting Patch at [" + patchFile.getAbsolutePath() + "]");
		}
		
		try {
			
			FileOutputStream fos = new FileOutputStream(patchFile);
			BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(fos));
			

			Iterator<String> it = patch.iterator();
			
			while (it.hasNext()) {
				String parameter = it.next();
				String value = patch.getValue(parameter);
				
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
