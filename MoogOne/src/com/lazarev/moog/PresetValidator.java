package com.lazarev.moog;

import java.util.Iterator;

public class PresetValidator
{
	
	/** These keys are the only ones in the Preset that are initialized to null */
	private static final String chord1 = "/p/part/t/1/a/chord/ofs";
	private static final String chord2 = "/p/part/t/2/a/chord/ofs";
	private static final String chord3 = "/p/part/t/3/a/chord/ofs";
	
	private static final String[] nullExceptions = new String[] { chord1, chord2, chord3 };
	
	
	/**
	 * An extra step in the process before the final write, but it assures that 
	 * we don't accidentally write a corrupted file with [null] values. 
	 */
	public static boolean isValid(Preset preset) 
	{
		System.out.println("Running final validation checks.");
		
		Iterator<String> it = preset.iterator();
		
		while (it.hasNext()) 
		{
			String key = it.next();
			String value = preset.getValue(key);
			
			if (value == null)
			{
				System.out.println("Value not found for key=[" + key + "]");
				return false;
			}
			
			if (value.equalsIgnoreCase("null"))
			{
				// There may be a few exceptions worth checking
				boolean detected = false;
				for ( int i = 0; i < nullExceptions.length; i++ )
				{
					if (key.equals(nullExceptions[i])) {
						detected = true;
					}
				}
				
				if (!detected) {
					System.out.println("Value was written as [null] for key=[" + key + "]");
					return false;
				}
			}
		}
		
		return true;
	}
}
