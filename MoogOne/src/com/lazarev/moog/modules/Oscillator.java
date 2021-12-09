package com.lazarev.moog.modules;

import com.lazarev.moog.Parameter;

public class Oscillator {

	private static final StringBuilder sb = new StringBuilder();
	
	public static Parameter getWaveAngle(int synthNumber, int oscNumber) {
		
		if (!isValidSynth(synthNumber)) return null;
		if (!isValidOsc(oscNumber)) return null;

		Parameter waveangle = new Parameter("d", Parameter.Type.FLOAT, 0.0F, 1.0F);

		String stringKey = buildCommonRoot(synthNumber, oscNumber).append(waveangle.getName()).toString();

		waveangle.setStringKey(stringKey);

		return waveangle;
	}

	
	private static StringBuilder buildCommonRoot(int synthNumber, int oscNumber) {
		sb.setLength(0);
		
		sb	.append("/p")
			.append("/part")
			.append("/t")
			.append("/").append(synthNumber)
			.append("/p")
			.append("/o").append(oscNumber)
			.append("/");
		
		return sb;
	}
	
	
	private static boolean isValidSynth(int synthNumber) {
		return (synthNumber >= 1 && synthNumber <= 3);
	}

	private static boolean isValidOsc(int oscNumber) {
		return (oscNumber >= 1 && oscNumber <= 3);
	}

}
