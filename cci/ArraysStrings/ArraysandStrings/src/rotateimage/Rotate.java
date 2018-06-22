package rotateimage;

public class Rotate {
	public static int[][] rotate(int[][] image) {
		int row = image.length;
		int col = image[0].length;
		int[][] rotateimage = new int[col][row];
		for (int i=0; i<col; i++) {
			for (int j=0; j<row; j++) {
				rotateimage[i][j] = image[j][i];
			}
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col/2; j++) {
				int tmp = rotateimage[i][j];
				rotateimage[i][j] = rotateimage[i][col - j - 1];
				rotateimage[i][col -j - 1] = tmp;
			}
		}
		
		return rotateimage;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,2,3},
					 {4,5,6},
					 {7,8,9}};
		a = rotate(a);
		for(int i=0; i< a.length; i++) {
			for (int j=0; j< a[0].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println("");
		}
	}

}
