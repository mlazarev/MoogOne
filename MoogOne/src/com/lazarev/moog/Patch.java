package com.lazarev.moog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Backed by a key/value map and an ordered list, this class provides access to the 
 * Parameters and Values in the Patch. In order to write out a patch in the correct
 * order, use the {@link #iterator()} method to loop over Parameters in a sequence
 * and call {@link #getValue(String)} for each one. I'm not sure if a proper order
 * is required, but all of the Moog One Patches appear to be saved in the same one
 * 
 * @author Mike Lazarev
 *
 */
public class Patch {

	/* A map of Key to Value Patch parameters  */
	private final HashMap<String, String> map;
	
	/* We want to be safe and maintain the order of keys */
	private final ArrayList<String> orderedKeyList;
	
	public Patch() {
		map = new HashMap<String,String>(89);
		orderedKeyList = new ArrayList<String>();
	}
	
	/**
	 * This method expects to be called in order, as each line of a patch is read at a time.
	 * We can then write out an identical file with different values, maintaining the order. 
	 * @param parameter MoogOne patch parameter name
	 * @param value for the parameter
	 */
	public void orderedAdd(String parameter, String value) {
		map.put(parameter, value);
		orderedKeyList.add(parameter);
	}

	
	public String getValue(String parameter) {
		return map.get(parameter);
	}
	
	
	/**
	 * @return an iterator over the Parameters in proper sequence
	 */
	public Iterator<String> iterator() {
		return orderedKeyList.iterator();
	}
	
	
	public int size() {
		return map.size();
	}
	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Iterator<String> it = orderedKeyList.iterator();
		
		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			
			sb.append(key).append(" ").append(value).append('\n');
		}

		return sb.toString();
	}
}
