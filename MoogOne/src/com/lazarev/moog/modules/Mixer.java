package com.lazarev.moog.modules;

import com.lazarev.moog.parameters.BooleanParameter;
import com.lazarev.moog.parameters.DoubleParameter;
import com.lazarev.moog.parameters.Parameter;

public class Mixer extends RootModule
{

	private static final DoubleParameter gain = new DoubleParameter("Gain", "g", 0.0, 1.0, 0.6658121347427368);

	/* Filter Routing */
	private static final BooleanParameter filterSVF = new BooleanParameter("Filter SVF", "fa", false);
	private static final BooleanParameter filterLadder = new BooleanParameter("Filter Ladder", "fb", false);
	
	
	public static Parameter getGain(int synthNumber, int oscNumber)
	{
		return getParameter(gain, synthNumber, oscNumber);
	}

	
	public static Parameter getFilterSVF(int synthNumber, int oscNumber)
	{
		return getParameter(filterSVF, synthNumber, oscNumber);
	}
	

	public static Parameter getFilterLadder(int synthNumber, int oscNumber)
	{
		return getParameter(filterLadder, synthNumber, oscNumber);
	}
	
	
	private static Parameter getParameter(Parameter parameter, int synthNumber, int oscNumber) {
		String key = buildOscParameterKey(parameter, synthNumber, oscNumber);
		parameter.setKey(key);
		return parameter;
	}
	
	
	public static String buildOscParameterKey(Parameter parameter, int synthNumber, int oscNumber) 
	{
		StringBuilder sb = buildRoot(synthNumber, oscNumber).append(parameter.getSuffix());
		
		return sb.toString();
	}
	
	
	private static StringBuilder buildRoot(int synthNumber, int oscNumber) 
	{
		StringBuilder sb = buildCommonRoot();
		
		sb	.append("/t").append("/").append(synthNumber)
			.append("/p").append("/mix").append("/o").append(oscNumber)
			.append("/");
		
		return sb;
	}
	
}
