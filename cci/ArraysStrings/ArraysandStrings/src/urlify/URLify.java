package urlify;

public class URLify {
	static String urLify(String s, int len) {
		char[] c = s.toCharArray();
		int i = 0;
		char[] p =new char[s.length()];
		
		for(int j=0; j<len; j++) {
			if(c[j] == ' ') {
				p[i++] = '%';
				p[i++] = '2';
				p[i++] = '0';
			}else{
				p[i++] = c[j];
			}
		}
		return new String(p);
	}
	
	static String changeSpace(char[] s, int len) {
		int tl, numz = 0;
		for(int i = 0; i < len; i++) {
			if(s[i] == ' ') {
				numz++;
			}
		}
		tl = len + numz * 2;
		if(len < s.length) {
			s[len] = '\0';
		}
		for(int i = len - 1; i >= 0; i-- ) {
			if(s[i] == ' ') {
				s[tl - 1] = '0';
				s[tl - 2] = '2';
				s[tl - 3] = '%';
				tl -= 3;
			}else {
				s[tl - 1] = s[i];
				tl--;
			}
		}
		return new String(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(urLify("  Mr John Smith        ",15));
		System.out.println(changeSpace("  Mr John Smith        ".toCharArray(),15));

	}

}
