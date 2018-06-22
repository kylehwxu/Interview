package checkpermutation;

public class checkPerm {
	
	public static boolean permutation(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		
		int[] numArray = new int[128];
		char[] charArray = s1.toCharArray();
		for(char c: charArray) {
			numArray[c]++;
		}
		
		for(int i=0; i<s2.length(); i++) {
			int t = (int)s2.charAt(i);
			numArray[t]--;
			
			if(numArray[t] < 0) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static String customSortString(String S, String T) {
        if (S == null || T == null) {
            return null;
        }
        int org = 0;
        for (int i = 0; i < S.length(); i++) {
            int pos = org;
            while (pos < T.length()) {
                if (S.charAt(i) == T.charAt(pos)) {
                    char tmp = T.charAt(org);
                    StringBuilder sb = new StringBuilder(T);
                    sb.setCharAt(org, T.charAt(pos));
                    sb.setCharAt(pos, tmp);
                    org++;
                    pos = org;
                    T = sb.toString();
                    System.out.println(T);
                } else {
                	pos++;
                }
            }
        }
        
        return T;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(permutation("aBcd","dcab"));
		System.out.println(customSortString("disqyr", "iwyrysqrdj"));
	}

}
