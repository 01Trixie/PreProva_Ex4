package view;
import controller.ClassController;
public class Principal {

	public static void main(String[] args) {
		
		
		int N = (int)((Math.random()*10)+1);
	
		
		
		
		for(int idThread = 0; idThread < 2; idThread++) {
			Thread tfatorial = new ClassController(idThread, N);
			tfatorial.start();
		}
	}

}
