package findpattern;

import java.util.*;

public class StringPattern {
	private static boolean pattern(String s, String pattern) {
		HashMap<Character, String> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		
		return helper(map, set, s, pattern);
		
	}
	
	private static boolean helper(HashMap<Character, String> map,
						   HashSet<String> set,
						   String s,
						   String pattern) {
		if (s.length() == 0) {
			if (pattern.length() == 0) {
				return true;
			}
			return false;
		}
		
		if (map.containsKey(pattern.charAt(0))) {
			if (!s.startsWith(map.get(pattern.charAt(0)))) {
				return false;
			}
			
			return helper(map, set, s.substring(map.get(pattern.charAt(0)).length()), pattern.substring(1));
		}
		
		for (int i = 0; i < s.length(); i++) {
			String text = s.substring(0, i + 1);
			if (set.contains(text)) {
				continue;
			}
			set.add(text);
			map.put(pattern.charAt(0), text);
			if (helper(map, set, s.substring(i + 1), pattern.substring(1))) {
				return true;
			}
			set.remove(text);
			map.remove(pattern.charAt(0));
		}
		
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pattern("redblueredblue", "abab"));
	}

}
