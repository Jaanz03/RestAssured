package Strings;

import java.util.Arrays;

public class reverse_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Method 1
		
		String  s = "selenium";
		
		String reverse = "";
		
			for(int i=s.length()-1;i>=0;i--) {
				reverse = reverse + s.charAt(i) ;
				System.out.println(reverse);
				
			}

	// Method 2
	String  w = "welcome";
	
	String rev = "";
	
	char a[]= w.toCharArray();
	
	for (int i=a.length-1;i>=0;i--) 
	{
		rev = rev + a[i];
		System.out.println(Arrays.toString(a));
	}
	System.out.println(rev);
	
	//Method 3
	String  d = "hello";
	StringBuffer str = new StringBuffer(d);
	System.out.println(str.reverse());
	
	//Method 4
	StringBuilder  strb = new StringBuilder(d);
	strb.reverse();
	
	
}
	
}
