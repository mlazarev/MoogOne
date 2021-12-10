package com.lazarev.moog;

import java.util.Random;

import com.lazarev.moog.modules.Oscillator;

public class PresetRandomizer
{

	public static void randomizeAllOscillators(Preset preset)
	{
		for (int synth = 1; synth < 4; synth++)
		{
			for (int oscillator = 1; oscillator < 4; oscillator++)
			{
				randomizeWaveAngle(preset, synth, oscillator);
				randomizeOctave(preset, synth, oscillator);
				randomizeWaveType(preset, synth, oscillator);
			}
		}
	}
	
	
	private static void randomizeWaveAngle(Preset preset, int synth, int oscillator) {
		Parameter waveAngle = Oscillator.getWaveAngle(synth, oscillator);
		setRandomValue(preset, waveAngle);
	}		
	
	private static void randomizeOctave(Preset preset, int synth, int oscillator) {
		Parameter octave = Oscillator.getOctave(synth, oscillator);
		setRandomValue(preset, octave);
	}
	
	private static void randomizeWaveType(Preset preset, int synth, int oscillator) {
		Parameter waveType = Oscillator.getWaveType(synth, oscillator);
		setRandomValue(preset, waveType);
	}

	
	/**
	 * Random Value generator based on Type of Parameter
	 */
	private static void setRandomValue(Preset preset, Parameter parameter) 
	{
		if (parameter == null) 
		{
			System.out.println("Error: Could not locate Parameter for the specified inputs");
			return;
		}
		
		boolean success = false;
	
		String key = parameter.getStringKey();
		String oldValue = preset.getValue(key);

		switch(parameter.getType()) 
		{
			case INTEGER:
			{
				int randomInt = makeRandomInt(parameter.getMinIntValue(), parameter.getMaxIntValue());
				success = preset.setValue(key, String.valueOf(randomInt));
				break;
			}
			case DOUBLE:
			{
				double randomDouble = makeRandomDouble(parameter.getMinDoubleValue(), parameter.getMaxDoubleValue());
				success = preset.setValue(key, String.valueOf(randomDouble));
				break;
			}
			case STRING:
			{
				String[] possibleValues = parameter.getPossibleStringValues();
				int randomInt = makeRandomInt(0, possibleValues.length - 1);
				String randomString = possibleValues[ randomInt ];
				
				// The String needs to be written with double quotes 
				success = preset.setValue(key, "\"" + randomString + "\"");
				break;
			}
		default:
			break;
		}
		
		String newValue = preset.getValue(key);
		String paramName = parameter.getName();
		
		if (MoogOne.isDebug) { 
			System.out.println(
				" Name=[" + paramName + "]" +	
				" Key=[" + key + "]" + 
			    " Old=[" + oldValue + "]" + 
				" New=[" + newValue + "]" + 
			    " success=" + success );
		}
	}
	
	
	/** ---------- RANDOM NUMBER GENERATORS -------------- **/
	
	private static int makeRandomInt(int rangeMin, int rangeMax)
	{
	    Random random = new Random();
	    int randomValue = random.nextInt(rangeMax + 1 - rangeMin) + rangeMin;
		return randomValue;
	}
	
	private static double makeRandomDouble(double rangeMin, double rangeMax)
	{
		Random random = new Random();
		double randomValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
		return randomValue;
	}
	
	
}
