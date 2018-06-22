package isunique;

public class Isunique {
	
	public static boolean checkUnique(String s) {
		
		if(s.length() > 128) {
			return false;
		}
		
		boolean map[] = new boolean[128];
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(map[c]) {
				return false;
			}
			
			map[c] = true;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkUnique("abcdd"));
	}

}
