package Interface;

public class MainmethodInterface implements Trafficinterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trafficinterface  tr = new MainmethodInterface();
		tr.Green();
		tr.Red();
		tr.Yellow();
		MainmethodInterface  Intr = new MainmethodInterface();
		Intr.pedestriancrossing();
		

	}

	@Override
	public void Green() {
		// TODO Auto-generated method stub
		System.out.println("Green means Go");
		
	}
	
	public void  pedestriancrossing() {
		System.out.println("pedestrian cross");
	}

	@Override
	public void Red() {
		// TODO Auto-generated method stub
		System.out.println("red means stop");
		
	}

	@Override
	public void Yellow() {
		// TODO Auto-generated method stub
		System.out.println("yellow means wait");
		
	}

}
