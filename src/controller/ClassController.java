
package controller;


public class ClassController extends Thread {
	private int idThread;
	private int N;


	public ClassController(int idThread, int N) {
		this.idThread = idThread;
		this.N = N;
		
	}

	public void run() {
		
		calculo();
	}

	private void calculo() {
		int respRec=0;
		int fat = 1;
		int tempo = 1000; // a thread fica 1000 milissegundos bloqueada
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		switch(idThread) {
			case 0:
				long startRec = System.nanoTime();
				respRec = recFat(N);
				long endtRec = System.nanoTime();
				long totalRec = endtRec - startRec;
				System.out.println("A thread recursiva #" + idThread + " demorou " + totalRec 
						+ " nanossegundos para calcular o fat de " + N + " que foi: " + respRec);
				break;
			case 1: 
				long startFunc = System.nanoTime();
				fat = funcFat(N);
				long endFunc = System.nanoTime();
				long totalFunc = endFunc - startFunc;
				System.out.println("A Thread função  #" + idThread + "  demorou " + totalFunc
						+ " nanossegundos para calcular Fat de " + N + " que é: " + fat);
				break;
				
		}
	}
			
	private static int recFat(int N) {

		if (N > 0) {
			return N * recFat(N - 1);
		}
			return 1;

		}

	private static int funcFat(int N) {
		int fat = 1;
		
		for (int i = 0; i < N; i++) {
			fat +=  i * fat;
		}
		return fat;
	}
}
