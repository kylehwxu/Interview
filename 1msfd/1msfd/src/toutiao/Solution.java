package toutiao;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> minTripCost(int[] miles) {
        List<Integer> list = new ArrayList<>();
        
        if (miles == null || miles.length == 0) {
            return list;
        }
        
        int[] dp = new int[miles.length];

        
        for (int i = 1; i < miles.length; i++) {
            int tmp_min = Integer.MAX_VALUE;
            int pos = -1;
            for (int j = 0; j < i; j++) {
                if (miles[j] - miles[i] > 200) {
                    continue;
                }
                int pen = (200 + miles[j] - miles[i])*(200 + miles[j] - miles[i]);
                if (tmp_min > pen) {
                	tmp_min = pen;
                    pos = j;
                }
            }
            if (pos != -1) {
        		if (list.size() != 0 &&list.get(list.size() - 1) != pos) {
            		list.remove(list.get(list.size() - 1));
            	}
            	
     
                list.add(pos);
                dp[i] = dp[pos] + tmp_min;
            }
            
            
        }
        
        
        return list;
    }
    
    public static void main(String[] args) {
    	Solution sl = new Solution();
    	int[] miles = {50, 100, 300, 400, 500};  
    	List<Integer> list = sl.minTripCost(miles);
    	for (int i = 0; i < list.size(); i++) {
    		System.out.println(list.get(i));
    	}
    }
}
