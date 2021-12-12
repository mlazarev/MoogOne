package com.lazarev.moog.modules;

import com.lazarev.moog.parameters.Parameter;
import com.lazarev.moog.parameters.DoubleParameter;
import com.lazarev.moog.parameters.IntParameter;
import com.lazarev.moog.parameters.StringParameter;


/** 
 * Oscillator Module Parameters 
 *  
 * Notes: 
 * -- Pulse Balance is actually located in the Mixer Module
 * -- Pulse Width appears to be its own Module
 * 
 * **/
public final class Oscillator extends RootModule 
{

	/* This parameter controls two separate values depending on the Wave Type */
	private static final DoubleParameter waveAngle 		= new DoubleParameter("Wave Angle", "d", 0.0, 1.0, 0.0);

	/* The octave is set at 0 for 8' (knob at 0 o'clock) going down to -2 and +2 respectively */
	private static final IntParameter octave 			= new IntParameter("Octave", "oct", -2, 2, 0);
	
	/* This is the WaveType button (only two options) : "v" = Triangle; "F" = Saw     */
	private static final StringParameter waveType 		= new StringParameter("Wave Type", "m", new String[] { "v", "F"}, "v" ); 
	
	
	
	/** --- GETTERS ---------------------------------------------- **/
	
	public static Parameter getWaveAngle(int synthNumber, int oscNumber) {
		return getParameter(waveAngle, synthNumber, oscNumber);
	}

	public static Parameter getOctave(int synthNumber, int oscNumber) {
		return getParameter(octave, synthNumber, oscNumber);
	}
	
	public static Parameter getWaveType(int synthNumber, int oscNumber)	{
		return getParameter(waveType, synthNumber, oscNumber);
	}
	
	
	/** --- ABSTRACT BUILDERS --------------------------------------- **/
	
	private static Parameter getParameter(Parameter parameter, int synthNumber, int oscNumber) {
		
		if (!isValidSynth(synthNumber)) return null;
		if (!isValidOsc(oscNumber)) return null;
		
		String key = buildParameterKey(parameter, synthNumber, oscNumber);
		parameter.setKey(key);
		return parameter;
	}
	

	public static String buildParameterKey(Parameter parameter, int synthNumber, int oscNumber) 
	{
		return buildOscillatorRoot(synthNumber, oscNumber).append(parameter.getSuffix()).toString();
	}
	
	
	private static StringBuilder buildOscillatorRoot(int synthNumber, int oscNumber) 
	{
		StringBuilder sb = buildCommonRoot();
		
		sb	.append("/t").append("/").append(synthNumber)
			.append("/p").append("/o").append(oscNumber)
			.append("/");
		
		return sb;
	}
	

}
