
package controller;

import java.util.concurrent.Semaphore;

public class ClassController extends Thread {
	private int idThread;
	private int N;
	private Semaphore semaforoRec;
	private Semaphore semaforoFunc;

	public ClassController(int idThread, int N, Semaphore semaforoRec, Semaphore semaforoFunc) {
		this.idThread = idThread;
		this.N = N;
		this.semaforoRec = semaforoRec;
		this.semaforoFunc = semaforoFunc;
	}

	public void run() {
		calculo();
	}

	private void calculo() {
		int cta = 0;
		int limite = 1;
		boolean ocupado = false;
		while (cta < limite) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(cta == 0 && ocupado == false ) {
				ocupado = true;
			try {
				semaforoRec.acquire();
				long startRec = System.nanoTime();
				long endtRec = System.nanoTime();
				long totalRec = System.nanoTime();
				totalRec = endtRec - startRec;
				System.out.println("A thread recursiva #" + idThread + " demorou " + totalRec 
						+ " nanossegundos para calcular o fat de " + N + " que foi: " + recFat(N));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoRec.release();
			}
			} 
			
			try {
				semaforoFunc.acquire();
				funcFat(N);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoFunc.release();

			}
			 
			cta++;
		}
	}
	
	private static int recFat(int N) {

		if (N > 0) {
			return N * recFat(N - 1);
		}
			return 1;

		}

	private void funcFat(int N) {
		int fat = 1;
		long startFunc = System.nanoTime();
		for (int i = 0; i < N; i++) {
			fat +=  i * fat;
		}
		long endFunc = System.nanoTime();
		long totalFunc = endFunc - startFunc;
		System.out.println("A Thread função  #" + idThread + "  demorou " + totalFunc
				+ " nanossegundos para calcular Fat de " + N + " que é: " + fat);
	}
}
