package twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private Map<Integer, Integer> map = new HashMap<>(); 
    public void add(int number) {
        // write your code here
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
        
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int tmp = value - entry.getValue();
            System.out.println(value);
            if (map.containsKey(tmp) && map.get(tmp) > 0) {
                return true;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum ts = new TwoSum();
		ts.add(0);
		ts.add(0);
		System.out.println(ts.find(0));
	}

}
