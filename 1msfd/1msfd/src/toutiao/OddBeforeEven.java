package toutiao;

import java.util.PriorityQueue;

public class OddBeforeEven {
	
	public void solution(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		while (start < end) {
			if (start % 2 == 0 && end % 2 != 0) {
				int tmp = arr[end];
				arr[end--] = arr[start];
				arr[start++] = tmp;
			} else if (end % 2 == 0) {
				end--;
			} else if (start % 2 != 0){
				start++;
			} else {
				start++;
				end--;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddBeforeEven test = new OddBeforeEven();  
        int[] arr= {0,1,2,0,4,0,6,7,8,9};  
        test.solution(arr);  
//        for(int i = 0; i < arr.length; i++){  
//            System.out.print(arr[i]+",");  
//        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] == 0) {
                queue.add(i);
            }else if(!queue.isEmpty()){
                int key = queue.poll();
                arr[key] = arr[i];
                arr[i] = 0;
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
        	System.out.println(queue.poll());
        }

	}
}
