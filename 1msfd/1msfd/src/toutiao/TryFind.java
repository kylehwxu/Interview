package toutiao;

public class TryFind {
	
	public int check(String s) {
		int left = 0;
		int right = s.length() - 1;
		int leftCount = 0;
		int rightCount = 0;
		int ex = 0;
		while (left < right) {
			while (s.charAt(left) =='0') {
				left++;
			}
			if (left < right && s.charAt(left) == '1') {
				leftCount++;
			}
			
			while (s.charAt(right) == '1') {
				right--;
			}
			if (right > left && s.charAt(right) == '0') {
				rightCount++;
			}
			
			if (left++ < right--) {
				ex++;
			}
			

		}
		return Math.min(Math.min(leftCount, rightCount), ex);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TryFind tf = new TryFind();
		String a = "01000101";
		System.out.println(tf.check(a));
	}

}
