package compressstring;

import java.util.HashMap;

public class Compress {
	public static String compressString(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		StringBuilder cs = new StringBuilder();
		
		for (int i=0; i<s.length(); i++) {
			if (map.get(s.charAt(i)) == null) {
				map.put(s.charAt(i), 1);
			} else {
				int num = map.get(s.charAt(i)) + 1;
				map.put(s.charAt(i), num);
			}
		}
		
		for (char c : map.keySet()) {
			cs.append(c);
			cs.append(map.get(c));
		}
		if (cs.length() < s.length()) {
			return cs.toString();
		}
		return s;
	}
	
	public static String compressTry(String s) {
		int length = countCompress(s);
		if (length > s.length()) {
			return s;
		}
		StringBuilder cs = new StringBuilder(length);
		int count = 0;
		for (int i=0; i < s.length(); i++) {
			count++;
			if (i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
				cs.append(s.charAt(i));
				cs.append(count);
				count = 0;
			}
		}
		return cs.toString();
	}
	
	public static int countCompress(String s) {
		int sum = 0, count = 0;
		for (int i=0; i < s.length(); i++) {
			count++;
			if ( i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1) ) {
				sum += 1 + String.valueOf(count).length();
				count = 0;
			}
				
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compressString("aaabbcccdd"));
		System.out.println(compressTry("aaabbcccdd"));
	}

}
