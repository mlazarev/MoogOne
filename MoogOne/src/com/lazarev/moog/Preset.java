package com.lazarev.moog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

/**
 * Backed by a key/value map and an ordered list, this class provides access to
 * the Parameters and Values in the Preset. In order to write out a Preset in
 * the correct order, use the {@link #iterator()} method to loop over Parameters
 * in a sequence and call {@link #getValue(String)} for each one. I'm not sure
 * if a proper order is required, but all of the Moog One Presets appear to be
 * saved in the same one
 * 
 * @author Mike Lazarev
 */
public class Preset
{

	/* A map of Key to Value Preset parameters */
	private final Map<String, String> map;

	/* We want to be safe and maintain the order of keys */
	private final List<String> orderedKeyList;

	public Preset()
	{
		map = new HashMap<String, String>(89);
		orderedKeyList = new ArrayList<String>();
	}

	/**
	 * This method expects to be called in order, as each line of a preset is read
	 * at a time. We can then write out an identical file with different values,
	 * maintaining the order.
	 * 
	 * @param parameter MoogOne Preset Parameter name
	 * @param value     for the parameter
	 */
	public void orderedAdd(String parameter, String value)
	{
		map.put(parameter, value);
		orderedKeyList.add(parameter);
	}

	public String getValue(String parameter)
	{
		return map.get(parameter);
	}

	public boolean setValue(String parameter, String value)
	{
		if (!map.containsKey(parameter))
		{
			return false;
		}
		map.put(parameter, value);
		return true;
	}

	/**
	 * @return an iterator over the Preset Parameters in proper sequence
	 */
	public Iterator<String> iterator()
	{
		return orderedKeyList.iterator();
	}

	public int size()
	{
		return map.size();
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		for (String key : orderedKeyList)
		{
			String value = map.get(key);

			sb.append(key).append(" ").append(value).append('\n');
		}

		return sb.toString();
	}
}
