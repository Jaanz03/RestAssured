package Arrays;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]=new int[10]; //declare array and allocate memory for the variable
		a[0]=1;
		a[1]=2;
		a[2]=3;
		a[3]=4;
		a[4]=5;
		a[5]=6;
		a[6]=7;
		a[7]=8;
		a[8]=9;
		a[9]=20;
		
		int b[]= {1,2,3,4,5}; //without allocating memory by creating object
		
		for (int i=0;i<b.length;i++) {
			System.out.print(b[i]);
			
		}
	}

}
