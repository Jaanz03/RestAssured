package Strings;

public class Sringassignments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//palindrome
//		String s = "MadaM";
//		String reverse = "";
//		for(int i = s.length()-1;i>=0;i--) {
//			reverse = reverse+ s.charAt(i);
//			if (s.equals(reverse)) {
//				System.out.println("It is a palindrome");
//			}
//
//		}		
//		
	
		
	


//Remove special chars in an string

	String str = "wel&&^^%%*())*come";
	
	String newstr = str.replaceAll("[&&^^%%*())*]", "");
	
	System.out.println(newstr);
	

	//remove white spaces
	
	String	str1= "we l co m e";
	
	String newstr1 = str1.replaceAll(" ", "");
	System.out.println(newstr1);
	
	//count occurrences of a character in a string
	
	String  characters = "aahuwwqqaaa";
			int count = 0;
	
	for(int i =0;i<characters.length();i++) {
		
		if (characters.charAt(i) == 'a') {
			 count ++;
//			System.out.println(count);
		}
		
		
	}
	
		System.out.println(count);
		
		
//Count Words in a String
		
		String  sentence = "Hi Hello How are you";
		int totalcount = sentence.split("\\s").length;
		
		System.out.println(totalcount);
				
		
	}
}
	
	


