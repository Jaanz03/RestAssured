
public class Stringhandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String	s="paymentpaid $1 successfully";
		System.out.println(s.charAt(8));
		System.out.println(s.indexOf("$"));
		
		//print string in reverse:
		String	str="jansi";
		for(int i=str.length()-1;i>=0;i--) {
			System.out.println(str.charAt(i));
		}
		
		//palindrome:
		String st="MADAM";
		String st1="";
		for(int i=st.length()-1;i>=0;i--) {
			st1 = st1 + st.charAt(i);	
		}
		System.out.println(st1);
		
		if (st==st1) {
			System.out.println("It is a palindrome");
		}
	}

}
