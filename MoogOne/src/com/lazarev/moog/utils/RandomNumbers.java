package com.lazarev.moog.utils;

import java.util.Random;

public class RandomNumbers
{

	public static double makeRandomDouble(double rangeMin, double rangeMax)
	{
		Random random = new Random();
		double randomValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
		return randomValue;
	}
	
	public static int makeRandomInt(int rangeMin, int rangeMax)
	{
	    Random random = new Random();
	    int randomValue = random.nextInt(rangeMax + 1 - rangeMin) + rangeMin;
		return randomValue;
	}
	
}
