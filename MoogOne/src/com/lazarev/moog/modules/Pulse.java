package com.lazarev.moog.modules;

import com.lazarev.moog.parameters.DoubleParameter;
import com.lazarev.moog.parameters.Parameter;

/**
 * Pulse has the same suffix as the Oscillator but it appears under a different Root 
 * as if it was it was its own module. Interesting...
 */
public class Pulse extends RootModule 
{
	
	private static final DoubleParameter pulseWidth = new DoubleParameter("Pulse Width", "d", 0.0, 1.0, 0.5);


	public static Parameter getPulseWidth(int synthNumber, int oscNumber) {
		return getParameter(pulseWidth, synthNumber, oscNumber);
	}

	private static Parameter getParameter(Parameter parameter, int synthNumber, int oscNumber) 
	{
		if (!isValidSynth(synthNumber)) return null;
		if (!isValidOsc(oscNumber)) return null;
		
		String key = buildParameterKey(parameter, synthNumber, oscNumber);
		parameter.setKey(key);
		return parameter;
	}
	
	
	public static String buildParameterKey(Parameter parameter, int synthNumber, int oscNumber)	{
		return buildPulseRoot(synthNumber, oscNumber).append(parameter.getSuffix()).toString();
	}
	
	
	private static StringBuilder buildPulseRoot(int synthNumber, int oscNumber) 
	{
		StringBuilder sb = buildCommonRoot();
		
		sb	.append("/t").append("/").append(synthNumber)
			.append("/p").append("/p").append(oscNumber)
			.append("/");
		
		return sb;
	}
}
