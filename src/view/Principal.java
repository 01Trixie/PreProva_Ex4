package view;

import controller.ClassController;
import java.util.concurrent.Semaphore;

public class Principal {

	public static void main(String[] args) {
		
		int permissaoRec = 1;
		int permissaoFunc = 1;
		int N = 5;
		Semaphore semaforoRec = new Semaphore(permissaoRec);
		Semaphore semaforoFunc = new Semaphore(permissaoFunc);
		
		
		
		for(int idThread = 0; idThread < 2; idThread++) {
			Thread tfatorial = new ClassController(idThread, N, semaforoRec, semaforoFunc);
			tfatorial.start();
		}
	}

}
