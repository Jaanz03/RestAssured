import java.io.IOException;
import java.util.ArrayList;

public class Testmain {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		dataDriven d = new dataDriven();
		ArrayList	 arr = d.getData("Purchase");		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println(arr.get(3));
		
		
	}

}


