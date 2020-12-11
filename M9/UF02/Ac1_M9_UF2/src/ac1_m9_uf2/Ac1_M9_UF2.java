package ac1_m9_uf2;

import java.util.*;
import java.util.concurrent.*;

public class Ac1_M9_UF2 {
	static class Sumar implements Callable<Integer> {
		private int operador1;
		private int operador2;
		
		public Sumar(int operador1, int operador2) {
			this.operador1 = operador1;
			this.operador2 = operador2;
			}
			
		@Override
		public Integer call() throws Exception {
			return operador1 + operador2;
			}
		}

	public static void main(String[] args) throws
		InterruptedException, ExecutionException {
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
			List<Sumar> llistaTasques= new ArrayList<Sumar>();
			for (int i = 0; i < 10; i++) {
				Sumar calcula = new Sumar((int)(Math.random()*10), (int)(Math.random()*10));
				llistaTasques.add(calcula);
				}
			List <Future<Integer>> llistaResultats;
			llistaResultats = executor.invokeAll(llistaTasques);
			
			executor.shutdown();
			
			for (int i = 0; i < llistaResultats.size(); i++) {
				Future<Integer> resultat = llistaResultats.get(i);
				try {
					System.out.println("Resultat tasca "+i+ " és:" +
					resultat.get());
				}
				catch (InterruptedException | ExecutionException e)
					{
					}
				}
		}
	}





