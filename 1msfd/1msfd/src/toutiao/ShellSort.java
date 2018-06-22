package toutiao;

public class ShellSort {
	public int[] sort(int[] arr) {
		//shell
		for(int d = arr.length / 2; d > 0; d /= 2) {
			
			for (int i = d; i < arr.length ; i++) {
				
				for (int j = i - d; j >= 0; j-=d) {
					if (arr[j] > arr[j + d]) {
						int tmp = arr[j];
						arr[j] = arr[j + d];
						arr[j + d] = tmp;
					}
				}
			}
		}
		
		return arr;
	}
	
	public int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int tmp = arr[i];
			int j = i - 1;
			for (; j >= 0 && arr[j] > tmp; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = tmp;
		}
		return arr;
	}
	
	public int[] bubSort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					int tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShellSort ss = new ShellSort();
		int[] arr = {5,7753,32,563,25,8,899,7,41,3};
		arr = ss.bubSort(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

}
