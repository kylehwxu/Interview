package commonlongeststring;

public class CommonLongest {
	public static String common(String[] str) {
		if (str.length == 0 || str == null) {
			return "";
		}
		String s = str[0];
		for (int i = 1; i < str.length; i++) {
			while(str[i].indexOf(s) != 0) {
				s = s.substring(0, s.length() - 1);
			}
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"abccccc", "abcdefc", "abcccccd"};
		System.out.println(common(a));
	}

}
