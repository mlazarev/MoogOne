package com.lazarev.moog.modules;

import org.junit.Assert;
import org.junit.Test;

import com.lazarev.moog.parameters.Parameter;

public class MixerTest
{

	@Test
	public void getGainTest()
	{
		Parameter gain = Mixer.getGain(1, Mixer.SOURCE_OSC3);
		
		String expected = "/p/part/t/1/p/mix/o3/g";
		String returned = gain.getKey();
		
		Assert.assertTrue( expected.equals(returned));
	}
	
	
}
