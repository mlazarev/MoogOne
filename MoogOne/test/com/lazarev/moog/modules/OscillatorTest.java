package com.lazarev.moog.modules;

import org.junit.Assert;
import org.junit.Test;

import com.lazarev.moog.Parameter;

public class OscillatorTest
{

	@Test
	public void buildParameterKeysTest()
	{
		Parameter waveAngle = new Parameter("Wave", "d", Parameter.Type.DOUBLE, 0.0F, 1.0F);
		
		String expected = "/p/part/t/1/p/o3/d";
		String returned = Oscillator.buildOscParameterKey(waveAngle, 1, 3);
		
		Assert.assertTrue( expected.equals(returned));
		
		
		expected = "/p/part/t/2/p/o1/d";
		returned = Oscillator.buildOscParameterKey(waveAngle, 2, 1);
		Assert.assertTrue( expected.equals(returned));
	}

	
	@Test
	public void getWaveAngleTest()
	{
		Parameter waveAngle = Oscillator.getWaveAngle(3, 1);
		
		String expected = "/p/part/t/3/p/o1/d";
		String returned = waveAngle.getKey();
		
		Assert.assertTrue( expected.equals(returned));
	}
	
	
	@Test
	public void getWrongOscillatorTest() 
	{
		Parameter waveAngle = Oscillator.getWaveAngle(1, 4);
		Assert.assertNull(waveAngle);
		
		waveAngle = Oscillator.getWaveAngle(1, 0);
		Assert.assertNull(waveAngle);
	}
	
	
	@Test
	public void getWrongSynthTest() 
	{
		Parameter waveAngle = Oscillator.getWaveAngle(5, 2);
		Assert.assertNull(waveAngle);
		
		waveAngle = Oscillator.getWaveAngle(0, 2);
		Assert.assertNull(waveAngle);
	}
	
	
}
