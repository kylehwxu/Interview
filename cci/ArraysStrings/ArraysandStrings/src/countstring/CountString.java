package countstring;

public class CountString {
    public static int countSubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        
        if (s.length() == 1) {
            return 1;
        }
        
        int res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            res += helper(s, i, i);
            System.out.println("odd " + i + ":" + helper(s, i, i));
            res += helper(s, i, i + 1);
            System.out.println("even" + i + ":" + helper(s, i, i + 1));
            System.out.println("res" + i + ":" + res);
        }
        
        return res;
    }
    
    private static int helper(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                count++;
                start--;
                end++;
            } else {
            	break;
            }
           
        }
        
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSubstrings("aaa"));
	}

}
