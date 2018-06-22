package gh;

public class CheckCharArray {
	public boolean checkCharArray(char[] fir, char[] sec) {
		if (fir == null && sec == null) {
			return true;
		}
		boolean[][] dp = new boolean[fir.length + 1][sec.length + 1];
		int i = fir.length - 1;
		int j = sec.length - 1;
		int countFir = 0;
		int countSec = 0;
		
		
		while (i >= 0 && j >= 0) {
			if (fir[i] == '\b') {
				countFir++;
				i--;
				continue;
			}
			if (countFir != 0) {
				i--;
				countFir--;
				continue;
			}

			if (sec[j] == '\b') {
				countSec++;
				j--;
				continue;
			}
			if (countSec != 0) {
				j--;
				countSec--;
				continue;
			}

			if (i < 0 || j < 0) {
				return false;
			}
			if (fir[i--] == sec[j--]) {
				continue;
			} else {
				return false;
			}
		}
		while (i >= 0) {
			if (fir[i] == '\b') {
				countFir++;
				i--;
				continue;
			}
			if (fir[i] != '\b' && countFir <= 0) {
				return false;
			}
			i--;
		}
		while (j >= 0) {
			if (sec[i] == '\b') {
				countSec++;
				j--;
				continue;
			}
			if (fir[j] != '\b' && countSec <= 0) {
				return false;
			}
			j--;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckCharArray a = new CheckCharArray();
		char[] fir = new char[] {'\b', 'b', 'd', '\b'};
		char[] sec = new char[] {'\b', 'b'};
		fir = new char[] {'a', 'b', '\b', 'd', 'c'};
		sec = new char[] {'a', 'd', 'c'};
		fir = new char[] {'a', 'b', '\b', '\b', '\b', 'd', 'c'};
		sec = new char[] {'d', 'c'};
		fir = new char[] {'a', 'b', 'd', '\b'};
		sec = new char[] {'a', 'd'};
		boolean check = a.checkCharArray(fir, sec);
		System.out.print(check);
	}

}
