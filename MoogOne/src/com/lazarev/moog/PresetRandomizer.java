package com.lazarev.moog;

import com.lazarev.moog.modules.Mixer;
import com.lazarev.moog.modules.Oscillator;
import com.lazarev.moog.modules.Pulse;
import com.lazarev.moog.parameters.Parameter;

public class PresetRandomizer
{

	/* MAIN RANDOMIZATION IS HERE */
	public static void randomizeAllOscillators(Preset preset)
	{

		// Synths 1 through 3
		for (int synth = 1; synth < 4; synth++)
		{

			// Oscillators 1 through 3
			for (int oscillator = 1; oscillator < 4; oscillator++)
			{
				if (MoogOne.isDebug) System.out.println("Randomizing Oscillators. Synth=[" + synth + "] Oscillator=[" + oscillator + "]" );
				
				randomizeWaveType(preset, synth, oscillator);
				randomizeWaveAngle(preset, synth, oscillator);
				randomizeOctave(preset, synth, oscillator);
				randomizePulseWidth(preset, synth, oscillator);
				randomizePulseBalance(preset, synth, oscillator);
			}
			

			// Mix Sources
			for (int i = 0; i < Mixer.SOURCES.length; i++)
			{
				String source = Mixer.SOURCES[i];
				if (MoogOne.isDebug) System.out.println("Randomizing Mix Sources. Synth=[" + synth + "] Source=[" + source + "]" );
				
				randomizeGain(preset, synth, source);
				randomizeFilterRouting(preset, synth, source);	
			}
			
		}
	}
	
	
	public static void randomizeWaveType(Preset preset, int synth, int oscillator)
	{
		Parameter waveType = Oscillator.getWaveType(synth, oscillator);
		setRandomValue(preset, waveType);
	}
	
	public static void randomizeWaveAngle(Preset preset, int synth, int oscillator)
	{
		Parameter waveAngle = Oscillator.getWaveAngle(synth, oscillator);
		setRandomValue(preset, waveAngle);
	}

	public static void randomizeOctave(Preset preset, int synth, int oscillator)
	{
		Parameter octave = Oscillator.getOctave(synth, oscillator);
		setRandomValue(preset, octave);
	}
	
	public static void randomizePulseWidth(Preset preset, int synth, int oscillator)
	{
		Parameter octave = Pulse.getPulseWidth(synth, oscillator);
		setRandomValue(preset, octave);
	}

	public static void randomizePulseBalance(Preset preset, int synth, int oscillator)
	{
		String source = Mixer.SOURCES[ oscillator - 1 ];
		Parameter octave = Mixer.getPulseBalance(synth, source);
		setRandomValue(preset, octave);
	}
	
	public static void randomizeFilterRouting(Preset preset, int synth, String source) 
	{
		Parameter filterSVF = Mixer.getFilterSVF(synth, source);
		Parameter filterLadder = Mixer.getFilterLadder(synth, source);
		
		setRandomValue(preset, filterSVF);
		setRandomValue(preset, filterLadder);
		
		// If both filters are set to Off we will not hear this Oscillator at all. Turn SVF On.
		if (preset.getValue(filterSVF).equals("false") && preset.getValue(filterLadder).equals("false"))
		{
			preset.setValue(filterSVF.getKey(), filterSVF.getMaxValue());
			printDebug(preset, filterSVF, "false", true);
		}
	}
	
	
	
	public static void randomizeGain(Preset preset, int synth, String source)
	{
		Parameter gain = Mixer.getGain(synth, source);
		setRandomValue(preset, gain);
	}
	
	
	private static void setRandomValue(Preset preset, Parameter parameter) 
	{
		String key = parameter.getKey();
		String oldValue = preset.getValue(key);
		
		boolean success = preset.setValue(key, parameter.getRandomValue());
		
		printDebug(preset, parameter, oldValue, success);
	}
	
	
	private static void printDebug(Preset preset, Parameter parameter, String oldValue, boolean success) 
	{
		if (!MoogOne.isDebug) return;
		
		// Pretty Print
		System.out.println(
			" \t Name=[" + String.format("%-" + 16 + "s", parameter.getName()) + "]"	
			+ " \t Key=[" + String.format("%-" + 24 + "s", parameter.getKey()) + "]" 
		    + " \t Old=[" + String.format("%-" + 24 + "s", oldValue) + "]"
			+ " \t New=[" + String.format("%-" + 24 + "s", preset.getValue(parameter)) + "]"  
		    //+ " \t success=" + success 
			);
	}
	
	
}
