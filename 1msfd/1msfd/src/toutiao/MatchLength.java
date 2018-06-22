package toutiao;

public class MatchLength {
	
	public int indexOf(String source, String pattern) {
        int i = 0, j = 0;
        int sLen = source.length(), pLen = pattern.length();
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();
        while (i < sLen && j < pLen) {
            if (src[i] == ptn[j]) {
                // 如果当前字符匹配成功,则将两者各自增1,继续比较后面的字符
                i++;
                j++;
            } else {
                // 如果当前字符匹配不成功,则i回溯到此次匹配最开始的位置+1处,也就是i = i - j + 1
                // (因为i,j是同步增长的), j = 0;
                i = i - j + 1;
                j = 0;
            }
        }
        // 匹配成功,则返回模式字符串在原字符串中首次出现的位置;否则返回-1
        if (j == pLen)
            return i - j;
        else
            return -1;
    }

    void getNext(String pattern, int next[]) {  
        int j = 0;  
        int k = -1;  
        int len = pattern.length();  
        next[0] = -1;  
  
        while (j < len - 1) {  
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {  
  
                j++;  
                k++;  
                next[j] = k;  
            } else {  
  
                // 比较到第K个字符，说明p[0——k-1]字符串和p[j-k——j-1]字符串相等，而next[k]表示  
                // p[0——k-1]的前缀和后缀的最长共有长度，所接下来可以直接比较p[next[k]]和p[j]  
                k = next[k];  
            }  
        }  
  
    }  
  
    int kmp(String s, String pattern) {  
        int i = 0;  
        int j = 0;  
        int slen = s.length();  
        int plen = pattern.length();  
  
        int[] next = new int[plen];  
  
        getNext(pattern, next);  
  
        while (i < slen && j < plen) {  
  
            if (s.charAt(i) == pattern.charAt(j)) {  
                i++;  
                j++;  
            } else {  
                if (next[j] == -1) {  
                    i++;  
                    j = 0;  
                } else {  
                    j = next[j];  
                }  
  
            }  
  
            if (j == plen) {  
                return i - j;  
            }  
        }  
        return -1;  
    }  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
    	MatchLength kmp = new MatchLength();  
        String str = "abababdafdasabcfdfeaba";  
        String pattern = "abc";  
//        System.out.println(kmp.indexOf(str, pattern));  
        System.out.println(Integer.valueOf("4e9iAk"));
    }  

}
