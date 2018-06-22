package toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hotel {
	
	public List<Integer> solution(int[] arr) {
		List<Integer> list = new ArrayList<>();
		
//		int[] hotel = arr;
		int[] bestpath = new int[arr.length];
		int[] stop = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			bestpath[i] = (int) (Math.pow((200 - arr[i]), 2));
			stop[i] = 0;
			for (int j = 0; j < i; j++) {
				if (bestpath[j] + Math.pow((200 - (arr[i] - arr[j])), 2) < bestpath[i]) {
					bestpath[i] = (int) (bestpath[j] + Math.pow((200 - (arr[i] - arr[j])), 2));
					stop[i] = j;
				}
			}
		}

		// Print the output
		System.out.println("Minimal Penalty :"+bestpath[arr.length - 1]);
		
//		String finalPath = "";
		int index = stop.length-1;
		while(index > 0){
			list.add(0, index);
			index = stop[index];
		}
//		System.out.println(Arrays.toString(stop));
//		System.out.println("Stop at: "+finalPath);
		
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel h = new Hotel();
		int[] arr = {1,53,77,153,243,366,467,641};
		List<Integer> list = h.solution(arr);
		for(int i : list) {
			System.out.println(i);
		}
	}

}
