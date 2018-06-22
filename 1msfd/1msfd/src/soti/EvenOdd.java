package soti;

import java.util.HashSet;
import java.util.Set;

public class EvenOdd {
	public int solution(int[] list) {
		if (list == null || list.length == 0) {
			return 0;
		}
		int[][] dp = new int[list.length][2];

		for (int i = 0; i < dp.length; i++) {
			if (list[i] % 2 != 0) {
				dp[0][1]++;
			}
		}
		
		for (int i = 1; i < dp.length; i++) {
			if(list[i - 1] % 2 == 0) {
				dp[i][0] = dp[i - 1][0] + 1;
				dp[i][1] = dp[i - 1][1];
			} else {
				dp[i][0] = dp[i - 1][0];
				dp[i][1] = dp[i - 1][1] - 1;
			}
			if (dp[i][0] == dp[i][1]) {
				return i - 1;
			}
		}
		return -1;
	}
	
	public int solution2(String S) {
		  if (S == null || S.length() == 0) {
	            return -1;
	        }
	        int[] f = new int[S.length() + 1];
	        boolean[] isValid = new boolean[S.length() + 1];
	        f[0] = -1;
	        isValid[0] = false;
	        for (int i = 0; i < S.length(); i++) {
	            Character c = S.charAt(i);
	            if (!Character.isLetter(c)) {
	                f[i + 1] = -1;
	                isValid[i + 1] = false;
	                continue;
	            } else {
	                if (Character.isUpperCase(c)) {
	                    isValid[i + 1] = true;
	                } else {
	                    isValid[i + 1] = isValid[i];
	                }
	                f[i + 1] = Math.max(0, f[i]) + 1;
	            }
	        }
	        int res = -1;
	        for (int i = 0; i <= S.length(); i++) {
	            if (isValid[i]) {
	                res = Math.max(res, f[i]);
	            }
	        }
	        return res;
	    }

	public int solution3(int[] A, int[] B, int M, int X, int Y) {
		  if (A == null || B == null || A.length == 0 || A.length != B.length) {
	            return 0;
	        }
	        int index = 0;
	        int res = 0;
	        while (true) {
	            Set<Integer> set = new HashSet<>();
	            int num = 0;
	            int weight = 0;
	            while (num + 1 <= X && index < A.length && weight + A[index] <= Y) {
	                num++;
	                weight += A[index];
	                set.add(B[index]);
	                index++;
	            }
	            if (index >= A.length) {
	                return (res + set.size() + 1);
	            }
	            //System.out.println(index);
	            res = res + set.size() + 1;
	            //System.out.println(res);
	        }
	    

	}
	
	public static void main(String[] args) {
		EvenOdd s = new EvenOdd();
		int[] A = new int[] {60,80,40};
		int[] B = new int[] {2,3,5};
		System.out.println(s.solution3(A,B,5,1,50));
	}
}
