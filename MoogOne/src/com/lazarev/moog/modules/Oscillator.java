package com.lazarev.moog.modules;

import com.lazarev.moog.Parameter;

public final class Oscillator extends RootModule 
{
	
	private static final Parameter waveangle 	= new Parameter("d", Parameter.Type.DOUBLE, 0.0, 1.0);
	private static final Parameter octave 		= new Parameter("oct", Parameter.Type.INTEGER, -1, 3);

	public static Parameter getWaveAngle(int synthNumber, int oscNumber)
	{
		if (!isValidSynth(synthNumber)) return null;
		if (!isValidOsc(oscNumber)) return null;

		String key = buildOscParameterKey(waveangle, synthNumber, oscNumber);
		waveangle.setStringKey(key);
		return waveangle;
	}

	
	public static Parameter getOctave(int synthNumber, int oscNumber)
	{
		if (!isValidSynth(synthNumber)) return null;
		if (!isValidOsc(oscNumber)) return null;
		
		String key = buildOscParameterKey(octave, synthNumber, oscNumber);
		octave.setStringKey(key);
		return octave;
	}
	
	
	
	/**
	 * This will build something like this: "/p/part/t/1/p/o1/... "
	 */
	public static String buildOscParameterKey(Parameter parameter, int synthNumber, int oscNumber) 
	{
		StringBuilder sb = buildRoot(synthNumber, oscNumber).append(parameter.getName());
		
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
