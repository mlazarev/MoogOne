package com.lazarev.moog.modules;

import com.lazarev.moog.Parameter;

public final class Oscillator extends RootModule 
{
	/** Here's where the actual parameters are defined with appropriate value boundaries **/
	private static final Parameter waveangle 	= new Parameter("Wave Angle", "d", Parameter.Type.DOUBLE, 0.0, 1.0);

	/* The octave is set at 0 for 8' (knob at 0 o'clock) going down to -2 and +2 respectively */
	private static final Parameter octave 		= new Parameter("Octave", "oct", Parameter.Type.INTEGER, -2, 2);
	
	/* This is the WaveType button (only two options) : "v" = Triangle; "F" = Saw     */
	private static final Parameter waveType		= new Parameter("Wave Type", "m", Parameter.Type.STRING, new String[] { "v", "F"} ); 
	
	
	public static Parameter getWaveAngle(int synthNumber, int oscNumber)
	{
		if (!isValidSynth(synthNumber)) return null;
		if (!isValidOsc(oscNumber)) return null;

		String key = buildOscParameterKey(waveangle, synthNumber, oscNumber);
		waveangle.setKey(key);
		return waveangle;
	}

	
	public static Parameter getOctave(int synthNumber, int oscNumber)
	{
		if (!isValidSynth(synthNumber)) return null;
		if (!isValidOsc(oscNumber)) return null;
		
		String key = buildOscParameterKey(octave, synthNumber, oscNumber);
		octave.setKey(key);
		return octave;
	}
	
	
	public static Parameter getWaveType(int synthNumber, int oscNumber)
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
