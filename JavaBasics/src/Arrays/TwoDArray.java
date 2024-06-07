package Arrays;

public class TwoDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int rows=3;
		int columns=3;
		int a[][] = new int[rows][columns];
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 3;
		a[1][0] = 1;
		a[1][1] = 2;
		a[1][2] = 3;
		a[2][0] = 1;
		a[2][1] = 2;
		a[2][2] = 3;
		for (int i=0; i<3;i++) 
			for (int j=0;j<3;j++) 
				System.out.println("a[" + i + "][" + j + "] = " + a[i][j]);		

	}

}
