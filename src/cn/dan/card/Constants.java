package cn.dan.card;

import java.util.*;

public class Constants {

	private Constants() {} // not allowed to be instantiated
	
	public static String[] POKER_NAME = {"3","4","5","6","7","8","9","10","J","Q","K","A","2","B","R"};
	public static Map<String, Integer> POKER_MAP = new HashMap<String, Integer>();
	
	static {
		Integer index = 0;
		
		for(String s: POKER_NAME)
			POKER_MAP.put(s, index++);
	}
}

