package com.lazarev.moog;

import java.util.Random;

import com.lazarev.moog.modules.Oscillator;

public class PresetRandomizer
{

	/**
	 * This is the very first method, which gives an example on how to randomize Wave Angle (I think)
	 */
	public static void randomizeAllOscillators(Preset preset)
	{
		for (int synth = 1; synth < 4; synth++)
		{
			for (int oscillator = 1; oscillator < 4; oscillator++)
			{
				randomizeWaveAngle(preset, synth, oscillator);
				randomizeOctave(preset, synth, oscillator);
			}
		}
	}
	
	
	private static void randomizeWaveAngle(Preset preset, int synth, int oscillator) {
		Parameter waveAngle = Oscillator.getWaveAngle(synth, oscillator);
		if (waveAngle == null) return;

		String key = waveAngle.getKey();
		String value = preset.getValue(key);

		double random = makeRandomDouble(waveAngle.getMinDoubleValue(), waveAngle.getMaxDoubleValue());

		boolean success = preset.setValue(key, String.valueOf(random));
		
		if (MoogOne.isDebug) { 
			System.out.println(
				 "Key=[" + key + "]" + 
			    " Old=[" + value + "]" + 
				" New=[" + random + "]" + 
			    " success=" + success );
		}
	}
	
	private static void randomizeOctave(Preset preset, int synth, int oscillator) {
		Parameter octave = Oscillator.getOctave(synth, oscillator);
		if (octave == null) return;

		String key = octave.getKey();
		String value = preset.getValue(key);

		int random = makeRandomInt(octave.getMinIntValue(), octave.getMaxIntValue());

		boolean success = preset.setValue(key, String.valueOf(random));
		
		if (MoogOne.isDebug) { 
			System.out.println(
				 "Key=[" + key + "]" + 
			    " Old=[" + value + "]" + 
				" New=[" + random + "]" + 
			    " success=" + success );
		}
	}
	
	
	
	private static int makeRandomInt(int rangeMin, int rangeMax)
	{
	    Random random = new Random();
	    int randomValue = random.nextInt(rangeMax - rangeMin) + rangeMin;
		return randomValue;
	}
	
	
	private static double makeRandomDouble(double rangeMin, double rangeMax)
	{
		Random random = new Random();
		double randomValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
		return randomValue;
	}
	
	
}
