package palindromPermutation;

public class Palindrom {
	public static boolean pPtf(String s) {
		int count = 0;
		int[] num = new int[128];
		s = s.toLowerCase();
		
		for(int i = 0; i < s.length(); i++) {
			if( s.charAt(i) == ' ') {
				continue;
			}
			count ++;
			if( ++num[s.charAt(i)] == 2) {
				num[s.charAt(i)] = 0;
				count -= 2;
			}
		}
		//System.out.println(count);
		if(count > 1) {
			return false;
		}
		return true;
	}
	
	public static boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }
	public static int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int start = 0;
        int end = A.length - k;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            if (Math.abs(target - A[mid]) < Math.abs(A[mid + k] - target)) {
                end = mid - 1; 
            } else {
                start = mid;
            }
        }
        
        int[] res = new int[k];
        end = start + k - 1;
        int pos = k - 1;
        while (start <= end && pos >= 0) {
            if (Math.abs(target - A[start]) > Math.abs(A[end] - target)) {
                res[pos] = A[start];
                start++;
            } else {
                res[pos] = A[end];
                end--;
            }
            pos--;
        }
        
        
        return res;
        
    }
	
	public static void pP(String s) {
		int[] num = new int[128];
		StringBuilder line = new StringBuilder();
		StringBuilder back = new StringBuilder();
		StringBuilder myline = new StringBuilder();
		String[] sp = s.split(" ");
		s = s.toLowerCase();
		
		for(int i=0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				continue;
			}
			if(++num[s.charAt(i)] == 2) {
				line.append(s.charAt(i));
				back.append(s.charAt(i));
				num[s.charAt(i)]--;
				num[s.charAt(i)]--;
			}
		}
		
		for(int i=0; i < s.length(); i++) {
			if(num[s.charAt(i)] == 1) {
				line.append(s.charAt(i));
			}
		}
		line.append(back.reverse());
		for(String a : sp) {
			myline.append(line.substring(0,a.length()));
			//System.out.println(line.substring(0,a.length()));
			myline.append(" ");
			line.delete(0, a.length());
		}
		System.out.println(myline.toString().toLowerCase());
	}

    public static boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.length() < 1) {
            return true;
        }
        
        int fir = 0;
        int sec = s.length() - 1;

        while (fir <= sec && fir < s.length() && sec >= 0) {

            if (s.charAt(fir) < 'A' || s.charAt(fir) > 'z') {
            	System.out.println('a');
                fir++;
                continue;
            }
            if (s.charAt(sec) < 'A' || s.charAt(sec) > 'z') {
                sec--;
                continue;
            }
            if (s.charAt(fir) == s.charAt(sec)) {

                continue;
            }
            return false;
        }
        
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(isPalindrome("ab"));
		int[] a = new int[]{1,4,6,10,20};
		System.out.println(kClosestNumbers(a,21,4));
//		long startTime = System.currentTimeMillis();
//		pP("aabbcc");
//		System.out.println(pPtf("Fb Ta baTt f"));
//		System.out.println(canPermutePalindrome("tactcoa"));
//		long endTime   = System.currentTimeMillis();
//		long totalTime = endTime - startTime;
//		System.out.println(totalTime);
	}

}
