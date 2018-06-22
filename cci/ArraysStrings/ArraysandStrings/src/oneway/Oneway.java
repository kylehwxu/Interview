package oneway;

public class Oneway {
	public static boolean oneWay(String s1, String s2) {
		int[] num = new int[128];
		for(char c : s1.toCharArray()) {
			num[c]++;
		}
		for(char c : s2.toCharArray()) {
			num[c]--;
		}
		int count = 0;
		for(int i=0; i<num.length; i++) {
			if(num[i] != 0) {
				count++;
			}
		}
		if(count > 1) {
			if(count != 2 || s1.length() != s2.length())
				return false;
		}
		return true;
	}
	
	public static boolean oneWays1(String s1, String s2) {
		if(s1.length() - s2.length() == 1) {
			return checkOneinsert(s1, s2);
		}else if(s2.length() - s1.length() == 1) {
			return checkOneinsert(s2, s1);
		}else if(s1.length() == s2.length()) {
			return checkOnechange(s1,s2);
		}
		
		return false;
	}
	
	public static boolean checkOneinsert(String s1, String s2) {
		int index1=0, index2=0;
		
		while(index1 < s1.length() && index2 < s2.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) {
				if(index1 != index2) {
					return false;
				}
				index1 ++;
			}else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	public static boolean checkOnechange(String s1, String s2) {
		boolean firsttime = false;
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(firsttime) {
					return false;
				}
				firsttime = true;
			}
		}
		return true;
	}
	
	public static boolean oneWays2(String s1, String s2) {
		if(Math.abs(s1.length() - s2.length()) > 1) {
			return false;
		}
		
		String str1 = s1.length()>s2.length()?s1:s2;
		String str2 = s1.length()>s2.length()?s2:s1;
		
		int index1 = 0, index2 = 0;
		boolean firsttime = false;
		
		while(index1 < str1.length() && index2 < str2.length()) {
			if(str1.charAt(index1) != str2.charAt(index2)) {
				if(firsttime) {
					return false;
				}
				firsttime = true;
				if(str1.length() == str2.length()) {
					index2++;
				}
			}else {
				index2++;
			}
			index1++;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(oneWays2("pale", "ple"));
		System.out.println(oneWays2("pales", "pale"));
		System.out.println(oneWays2("pale", "bale"));
		System.out.println(oneWays2("pale", "bake"));
	}

}
