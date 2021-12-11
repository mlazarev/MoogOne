package com.lazarev.moog.modules;

import com.lazarev.moog.parameters.Parameter;
import com.lazarev.moog.parameters.DoubleParameter;
import com.lazarev.moog.parameters.IntParameter;
import com.lazarev.moog.parameters.StringParameter;

public final class Oscillator extends RootModule 
{
	/** Here's where the actual parameters are defined with appropriate value boundaries **/
	
	/* This parameter controls two separate values depending on the Wave Type */
	private static final DoubleParameter waveAngle = new DoubleParameter("Wave Angle", "d", 0.0, 1.0);

	/* The octave is set at 0 for 8' (knob at 0 o'clock) going down to -2 and +2 respectively */
	private static final IntParameter octave = new IntParameter("Octave", "oct", -2, 2);
	
	/* This is the WaveType button (only two options) : "v" = Triangle; "F" = Saw     */
	private static final StringParameter waveType = new StringParameter("Wave Type", "m", new String[] { "v", "F"} ); 
	
	

	public static DoubleParameter getWaveAngle(int synthNumber, int oscNumber)
	{
		if (!isValidSynth(synthNumber)) return null;
		if (!isValidOsc(oscNumber)) return null;

		String key = buildOscParameterKey(waveAngle, synthNumber, oscNumber);
		waveAngle.setKey(key);
		return waveAngle;
	}

	
	public static IntParameter getOctave(int synthNumber, int oscNumber)
	{
		if (!isValidSynth(synthNumber)) return null;
		if (!isValidOsc(oscNumber)) return null;
		
		String key = buildOscParameterKey(octave, synthNumber, oscNumber);
		octave.setKey(key);
		return octave;
	}
	
	
	public static StringParameter getWaveType(int synthNumber, int oscNumber)
	{
		if (!isValidSynth(synthNumber)) return null;
		if (!isValidOsc(oscNumber)) return null;
		
		String key = buildOscParameterKey(waveType, synthNumber, oscNumber);
		waveType.setKey(key);
		return waveType;
	}
	
	
	/**
	 * This will build something like this: "/p/part/t/1/p/o1/... "
	 */
	public static String buildOscParameterKey(Parameter parameter, int synthNumber, int oscNumber) 
	{
		StringBuilder sb = buildRoot(synthNumber, oscNumber).append(parameter.getSuffix());
		
		return sb.toString();
	}
	
	
	private static StringBuilder buildRoot(int synthNumber, int oscNumber) 
	{
		StringBuilder sb = buildCommonRoot();
		
		sb	.append("/t").append("/").append(synthNumber)
			.append("/p").append("/o").append(oscNumber)
			.append("/");
		
		return sb;
	}
	
	

}
