package com.lazarev.moog.modules;

import com.lazarev.moog.parameters.BooleanParameter;
import com.lazarev.moog.parameters.DoubleParameter;
import com.lazarev.moog.parameters.Parameter;

public class Envelope extends RootModule 
{

	private static final DoubleParameter attack 		= new DoubleParameter("Attack", 	"knobs/a", 	0.0, 1.0, 0.0);
	private static final DoubleParameter decay			= new DoubleParameter("Decay", 		"knobs/d", 	0.0, 1.0, 0.5);
	private static final DoubleParameter release		= new DoubleParameter("Release", 	"knobs/r", 	0.0, 1.0, 0.1);
	private static final DoubleParameter sustain		= new DoubleParameter("Sustain", 	"s", 		0.0, 1.0, 1.0);
	
	
	/* Envelope Buttons */
	private static final BooleanParameter multiTrig		= new BooleanParameter("Multi Trig", 	"multi-trig", 	false);
	private static final BooleanParameter sync			= new BooleanParameter("Sync", 			"sync", 		false);
	private static final BooleanParameter loop			= new BooleanParameter("Loop", 			"loop", 		false);
	private static final BooleanParameter latch			= new BooleanParameter("Latch", 		"latch", 		false);
	
	
	/** --- GETTERS ---------------------------------------------- **/
	
	public static Parameter getAttack(int synthNumber, int envNumber) {
		return getParameter(attack, synthNumber, envNumber);
	}
	
	public static Parameter getDecay(int synthNumber, int envNumber) {
		return getParameter(decay, synthNumber, envNumber);
	}

	public static Parameter getRelease(int synthNumber, int envNumber) {
		return getParameter(release, synthNumber, envNumber);
	}
	
	public static Parameter getSustain(int synthNumber, int envNumber) {
		return getParameter(sustain, synthNumber, envNumber);
	}

	public static Parameter getMultiTrig(int synthNumber, int envNumber) {
		return getParameter(multiTrig, synthNumber, envNumber);
	}
	
	public static Parameter getSync(int synthNumber, int envNumber) {
		return getParameter(sync, synthNumber, envNumber);
	}
	
	public static Parameter getLoop(int synthNumber, int envNumber) {
		return getParameter(loop, synthNumber, envNumber);
	}
	
	public static Parameter getLatch(int synthNumber, int envNumber) {
		return getParameter(latch, synthNumber, envNumber);
	}

	
/** --- ABSTRACT BUILDERS --------------------------------------- **/
	
	private static Parameter getParameter(Parameter parameter, int synthNumber, int envNumber) {
		
		if (!isValidSynth(synthNumber)) return null;
		if (!isValidEnv(envNumber)) return null;
		
		String key = buildParameterKey(parameter, synthNumber, envNumber);
		parameter.setKey(key);
		return parameter;
	}
	
	public static String buildParameterKey(Parameter parameter, int synthNumber, int envNumber) 
	{
		return buildOscillatorRoot(synthNumber, envNumber).append(parameter.getSuffix()).toString();
	}
	
	
	private static StringBuilder buildOscillatorRoot(int synthNumber, int envNumber) 
	{
		StringBuilder sb = buildCommonRoot();
		
		sb	.append("/t").append("/").append(synthNumber)
			.append("/p").append("/e").append(envNumber)
			.append("/");
		
		return sb;
	}
}
