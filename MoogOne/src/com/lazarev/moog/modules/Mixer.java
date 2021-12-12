package com.lazarev.moog.modules;

import com.lazarev.moog.parameters.BooleanParameter;
import com.lazarev.moog.parameters.DoubleParameter;
import com.lazarev.moog.parameters.Parameter;

public class Mixer extends RootModule
{
	
	/* Individual Sources */
	public final static String SOURCE_OSC1 		= "o1";
	public final static String SOURCE_OSC2 		= "o2";
	public final static String SOURCE_OSC3 		= "o3";
	public final static String SOURCE_NOISE 	= "n";
	public final static String SOURCE_RINGMOD 	= "rm";
	
	/* All Sources in Array */
	public final static String[] SOURCES = new String[] { SOURCE_OSC1, SOURCE_OSC2, SOURCE_OSC3, SOURCE_NOISE, SOURCE_RINGMOD };	

	/* Gain value for each of the Sources */
	private static final DoubleParameter gain 			= new DoubleParameter("Gain", "g", 0.0, 1.0, 0.6658121347427368);

	/* Filter Routing */
	private static final BooleanParameter filterSVF 	= new BooleanParameter("Filter SVF", "fa", false);
	private static final BooleanParameter filterLadder 	= new BooleanParameter("Filter Ladder", "fb", false);
	
	
	/* Interestingly Pulse Balance appears as a sub property of three oscillators */
	private static final DoubleParameter pulseBalance 	= new DoubleParameter("Pulse Balance", "plsbal", 0.0, 1.0, 0.0);

	
	
	/** --- GETTERS ---------------------------------------------- **/
	
	public static Parameter getGain(int synthNumber, String source) {
		return getParameter(gain, synthNumber, source);
	}

	public static Parameter getPulseBalance(int synthNumber, String source) {
		return getParameter(pulseBalance, synthNumber, source);
	}
	
	public static Parameter getFilterSVF(int synthNumber, String source) {
		return getParameter(filterSVF, synthNumber, source);
	}
	
	public static Parameter getFilterLadder(int synthNumber, String source)	{
		return getParameter(filterLadder, synthNumber, source);
	}
	

	
	/** --- ABSTRACT BUILDERS --------------------------------------- **/

	static Parameter getParameter(Parameter parameter, int synthNumber, String source) 
	{
		if (!isValidSynth(synthNumber)) return null;

		String key = buildParameterKey(parameter, synthNumber, source);
		parameter.setKey(key);
		return parameter;
	}
	
	
	static String buildParameterKey(Parameter parameter, int synthNumber, String source) {
		return buildMixerRoot(synthNumber, source).append(parameter.getSuffix()).toString();
	}
	
	
	private static StringBuilder buildMixerRoot(int synthNumber, String partName) 
	{
		StringBuilder sb = buildCommonRoot();
		
		sb	.append("/t").append("/").append(synthNumber)
			.append("/p").append("/mix")
			.append("/").append(partName)
			.append("/");
		
		return sb;
	}
	
}
