import java.io.IOException;
import java.util.ArrayList;

public class ExcersiseTestMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExerciseTest  ex = new ExerciseTest();
		ArrayList arr = ex.getDetails("Arun");
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println(arr.get(3));
		System.out.println(arr.get(4));
		
		
	}

}
