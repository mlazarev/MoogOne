package com.lazarev.moog;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lazarev.moog.modules.Oscillator;
import com.lazarev.moog.parameters.Parameter;

public class PresetRandomizerTest
{

	@Before
	public void setup() 
	{
		MoogOne.isDebug = false;
	}
	
	
	@Test
	public void randomizeDouble()
	{
		Parameter waveAngle = Oscillator.getWaveAngle(1, 2);
		final String value = "0.4334131204246354";
		
		Preset preset = new Preset();
		
		preset.orderedAdd(waveAngle, value);
		
		// run 1000 times just in case.
		for (int i = 0; i < 1000; i++ )
		{
			String oldValue = preset.getValue(waveAngle);
					
			PresetRandomizer.randomizeWaveAngle(preset, 1, 2);
			
			String newValue = preset.getValue(waveAngle);
			
			Assert.assertTrue(!oldValue.equalsIgnoreCase(newValue));
		}
			

	}

}
