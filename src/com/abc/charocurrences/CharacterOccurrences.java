package com.abc.charocurrences;
import java.util.HashMap;

public class CharacterOccurrences {

	public void calRepeatChar() {
		HashMap<Character, Integer> map = new HashMap<>();

		String str = "IAMANANTA";
		char[] a = str.toCharArray();
		
		for (char c : a) {
			System.out.print(c);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		System.out.println();
		map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CharacterOccurrences c1 = new CharacterOccurrences();
		c1.calRepeatChar();
	}

}
