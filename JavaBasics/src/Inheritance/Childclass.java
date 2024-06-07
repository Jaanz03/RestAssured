package Inheritance;

public class Childclass extends Parentclass{
	
	public void engine() {
		System.out.println("engine");
				
	}
	public void colour() {
		System.out.println(color);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Childclass  ch = new Childclass();
		ch.colour();
		ch.engine();
		ch.Audio();
		ch.Brakes();

	}
}
