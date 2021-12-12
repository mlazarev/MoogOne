package com.lazarev.moog.modules;


abstract class RootModule
{
	
	private static final StringBuilder sb = new StringBuilder();

	
	static StringBuilder buildCommonRoot()
	{
		sb.setLength(0);
		sb.append("/p").append("/part"); // We will learn what all this means later. Maybe...
		return sb;
	}

	
	/** --- Some validation utilities --- */

	public static boolean isValidSynth(int synthNumber)
	{
		return (synthNumber >= 1 && synthNumber <= 3);
	}

	public static boolean isValidOsc(int oscNumber)
	{
		return (oscNumber >= 1 && oscNumber <= 3);
	}
}
