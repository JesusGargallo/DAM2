package m6_uf2_act1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class M6_UF2_act1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Creacio del Scanner
		Scanner teclado = new Scanner(System.in);		

		Connection connection = null;
		Statement stmt = null;
		Statement selectStmt = null;
                
		try {
		
                    
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/m6_uf2_act1", "root", "");			

			System.out.println("1- Afegir columnes(alumnes) | 2- Modificar columnes | 3- Eliminar columnes | 4- Afegir columnes(poblacions | 5-Salir)");
			int eleccio = teclado.nextInt();
                        teclado.nextLine();
                        while(eleccio != 5){
                           if(eleccio == 1){
                               
                                System.out.println("Afegeix un NOM");
				String nom = teclado.next();
				System.out.println("Afegeix un DNI");
				String dni = teclado.next();
				System.out.println("Afegeix una data ->(1897-12-10)");
				String data = teclado.next();
				System.out.println("Afegeix una carrer");
                                String carrer = teclado.next();
                                teclado.nextLine();
                                System.out.println("Afegeix el sexe");
				String sexe = teclado.next();
                                teclado.nextLine();
				System.out.println("Afegeix un codi postal");
				int codiPostal = teclado.nextInt();
                                

				try{
					stmt = connection.createStatement();
					stmt.execute("INSERT INTO alumnes VALUES ('" + nom.trim() + "','" + dni.trim() + "','" + data + "','" + carrer + "','" + sexe + "'," + codiPostal + ")");

				} catch(Exception e){					
					System.out.println("Afegeix un codi postal a la taula poblacions");
				}
			} else if (eleccio == 4){
                            
				System.out.println("Afegeix un nom de poblacio");
				String nomPoblacio = teclado.next();
				System.out.println("Afegeix un codi postal");
				int codiPostalPoblacio = teclado.nextInt();
                                
                                try{
                                    stmt = connection.createStatement();
                                    stmt.execute("INSERT INTO poblacions VALUES (" + codiPostalPoblacio + ",'" + nomPoblacio + "')");
                                } catch (Exception e) {
                                    System.out.println("No es pot repetir el codi postal");
                                }	
                        } else if (eleccio == 2){
                            
                            
				System.out.println("Elegeix una taula");
				String eleccioTaula = teclado.next();
                                System.out.println("Elegeix columna");
				String eleccioColumna = teclado.next();
				System.out.println("Afegeix el valor");
				String valorColumna = teclado.next();
                                if(eleccioTaula.equalsIgnoreCase("alumnes")){
                                    
                                    System.out.println("Valor a modificar per DNI");
                                    String valorAnterior = teclado.next();
                                    
                                    selectStmt = connection.createStatement();
                                
                                    //ResultSet rs = (ResultSet) selectStmt.executeQuery
                                    PreparedStatement pps = connection.prepareStatement("UPDATE " + eleccioTaula + " SET " + eleccioColumna + " = '" + valorColumna + "' WHERE Dni = '" + valorAnterior +"' ");
                                    pps.executeUpdate();
                                    
                                } else {
                                    System.out.println("Valor a modificar per codigo Postal");
                                    int valorAnterior = teclado.nextInt();
                                    
                                    selectStmt = connection.createStatement();
                                
                                    System.out.println("Es posible que es modifiquin alumnes estas segur 1-SI / 2-NO");
                                    int opcio = teclado.nextInt();
                                        if(opcio == 1){
                                            
                                            PreparedStatement pps = connection.prepareStatement("UPDATE " + eleccioTaula + " SET " + eleccioColumna + " = '" + valorColumna + "' WHERE Cpostal = " + valorAnterior +" ");
                                            pps.executeUpdate();
                                            
                                        } else {
                                            
                                            System.out.println("Se ha cancelat");
                                        }
                                    //ResultSet rs = (ResultSet) selectStmt.executeQuery
                                    
                                }
                                
                    
                                
                        } else if (eleccio == 3){
				System.out.println("Elegeix una taula");
				String eleccioTaula = teclado.next();
				System.out.println("Elegeix la columna");
				String eleccioColumna = teclado.next();
				System.out.println("1- VARCHAR | 2- INT");
				int eleccioValor = teclado.nextInt();

				if(eleccioValor == 1){
                                    
					System.out.println("Afegeix el valor");
					String valorColumna = teclado.next();
                                        
                                        System.out.println("Es posible que es borrin alumnes estas segur 1-SI / 2-NO");
                                        int opcio = teclado.nextInt();
                                        
                                        if(opcio == 1){
                                            
                                            //PreparedStatement pps = connection.prepareStatement("DELETE FROM " + eleccioTaula + " WHERE " + eleccioColumna + ">= " + valorColumna +" ");
                                            //pps.executeUpdate();
                                            PreparedStatement pps = connection.prepareStatement("DELETE FROM " + eleccioTaula + " WHERE " + eleccioColumna + " = '" + valorColumna + "'");
                                            pps.executeUpdate();
                                            
                                        } else {
                                            
                                            System.out.println("Se ha cancelat");
                                        }
                                        
                                         
                                 	
				} else if (eleccioValor == 2){
                                        System.out.println("Afegeix el valor");
					int valorColumna = teclado.nextInt();
                                        
                                        
                                        System.out.println("Es posible que es borrin alumnes estas segur 1-SI / 2-NO");
                                        int opcio = teclado.nextInt();
                                        if(opcio == 1){
                                            
                                            PreparedStatement pps = connection.prepareStatement("DELETE FROM " + eleccioTaula + " WHERE " + eleccioColumna + " = " + valorColumna +" ");
                                            pps.executeUpdate();
                                            
                                        } else {
                                            
                                            System.out.println("Se ha cancelat");
                                        }
					
				}
			}
                           
                       System.out.println("1- Afegir columnes(alumnes) | 2- Modificar columnes | 3- Eliminar columnes | 4- Afegir columnes(poblacions | 5-Salir)");
                       eleccio = teclado.nextInt();    
                      }
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				//selectStmt.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
    



