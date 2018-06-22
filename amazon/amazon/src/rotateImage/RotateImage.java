package rotateImage;

public class RotateImage {
	public static int[][] rotate(int[][] image, int flag) {
		int m = image.length;
		int n = image[0].length;
		int[][] rotateimage = new int[n][m];
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				rotateimage[j][i] = image[i][j];
			}
		}
		
		if(flag == 0) {
			for (int i=0; i<m; i++) {
				for (int j=0; j< n/2; j++) {
					int tmp = rotateimage[j][i];
					rotateimage[j][i] = rotateimage[n - j - 1][i];
					rotateimage[n-j-1][i] = tmp;
				}
			}
		}
		else {
			for (int i=0; i<n; i++) {
				for (int j=0; j<n/2; j++) {
					int tmp = rotateimage[i][j];
					rotateimage[i][j] = rotateimage[i][m - j - 1];
					rotateimage[i][m-j-1] = tmp;
				}
			}
		}
		return rotateimage;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a= {{1,5,9},
				    {2,6,10},
				    {3,7,11}
				    };
		
		int[][] b = rotate(a,0);
		int[][] c = rotate(a,1);
		
		for (int i=0; i< b.length; i++) {
			for (int j=0; j<b[0].length; j++) {
				System.out.print(b[i][j]);
			}
			System.out.println("");
		}
		for (int i=0; i< c.length; i++) {
			for (int j=0; j<c[0].length; j++) {
				System.out.print(c[i][j]);
			}
			System.out.println("");
		}
	}

}
