package ac1_m9_uf2;

import java.util.*;
import java.util.concurrent.*;

public class Ac1_M9_UF2 {
	static class Sumar implements Callable<Integer> {
		private int operador1;
		private int operador2;
		
                //constructor de la clase Sumar
		public Sumar(int operador1, int operador2) {
			this.operador1 = operador1;
			this.operador2 = operador2;
			}
			
                //metodo para hacer la suma
		@Override
		public Integer call() throws Exception {
			return operador1 + operador2;
			}
		}

	public static void main(String[] args) throws
		InterruptedException, ExecutionException {
                        
                        //executara 5 files
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
                        
                        //creas un arraylist
			List<Sumar> llistaTasques= new ArrayList<Sumar>();
                        
                        //lanzara 25 sumas aleatoria con numeros aleatorios
			for (int i = 0; i < 25  ; i++) {
				Sumar calcula = new Sumar((int)(Math.random()*10), (int)(Math.random()*10));
				llistaTasques.add(calcula);
				}
                        
                        //crea una array de lista para ejecutar la lista con las tascas
                        //donde se han guardado las sumas
			List <Future<Integer>> llistaResultats;
			llistaResultats = executor.invokeAll(llistaTasques);
			
                        
                        //espara a que acaben los hilos
			executor.shutdown();
			
                        //mostrar los resultados
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





