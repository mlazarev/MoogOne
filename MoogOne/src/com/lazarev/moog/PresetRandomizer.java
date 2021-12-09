package com.lazarev.moog;

import java.util.Random;

import com.lazarev.moog.attributes.Oscillator;

public class PresetRandomizer {

	/**
	 * This is the very first method, which gives an example on how to randomize Wave Angle (I think)
	 */
	public static void randomizeAllOscillators(Preset preset) 
	{
		for (int synth = 1; synth < 4; synth++ ) {
			for (int oscillator = 1; oscillator < 4; oscillator++) {
				Parameter waveAngle = Oscillator.getWaveAngle(synth, oscillator);
				if (waveAngle == null) continue;
				
				String key = waveAngle.getKey();
				String value = preset.getValue(key);
				
				double random = getRandom(waveAngle.getMinValue(), waveAngle.getMaxValue());
				
				if (MoogOne.isDebug) System.out.println("Key=[" + key + "]" + " Old=[" + value + "]" + " New=[" + random + "]" );
				
				preset.setValue(key, String.valueOf(random));
			}
		}
		
	}
	

	private static double getRandom(double rangeMin, double rangeMax) {
		Random r = new Random();
		double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		return randomValue;
	}
	
	
}
