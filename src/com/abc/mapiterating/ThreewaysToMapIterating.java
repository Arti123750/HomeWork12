package com.abc.mapiterating;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.omg.Messaging.SyncScopeHelper;

public class ThreewaysToMapIterating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Map<String, Integer>map=new HashMap<String, Integer>();
		
		map.put("one", 101);
		map.put("Two", 102);
		map.put("Three", 103);
		map.put("Four", 104);
		map.put("Five", 105);
		System.out.println(map);

		System.out.println("Using EntrySet");
		usingEntrySet(map);
		System.out.println("Using ForEach Method");
		usingForEachMethod(map);
		System.out.println("Using Iterator");
		usingIterator(map);
		
	}

	private static void usingIterator(Map<String, Integer> map) {
		
		Iterator<Map.Entry<String, Integer>>itr=map.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry<String, Integer>entry=itr.next();
			System.out.println("Key: "+entry.getKey()+"Value: "+entry.getValue());
			
		}
		
	}

	private static void usingForEachMethod(Map<String, Integer> map)
	{

		map.forEach((k,v)->System.out.println("Key: "+k+"Value: "+v));
		
	}

	private static void usingEntrySet(Map<String, Integer> map) {
		
		for(Map.Entry<String, Integer>entry:map.entrySet())
		{
			System.out.println("Key: "+entry.getKey()+"Value: "+entry.getValue());
		}
		
	}

}
