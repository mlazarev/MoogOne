package com.lazarev.moog;

import com.lazarev.moog.modules.Oscillator;
import com.lazarev.moog.parameters.Parameter;

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
	
		String key = parameter.getKey();
		String oldValue = preset.getValue(key);
		
		
		success = preset.setValue(key, parameter.getRandomValue());
		
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
	
	
	
}
