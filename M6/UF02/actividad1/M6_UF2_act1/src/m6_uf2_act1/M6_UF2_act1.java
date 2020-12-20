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

			System.out.println("1- Afegir columnes(alumnes) | 2- Modificar columnes | 3- Eliminar columnes | 4- Afegir columnes(poblacions | 5-Llistar un alumnes o poblacio | 6- Salir)");
			int eleccio = teclado.nextInt();
                        teclado.nextLine();
                        while(eleccio != 6){
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
                                
                                try{
                                    selectStmt = connection.createStatement();
                                    ResultSet rs = null;
                                    rs = selectStmt.executeQuery("SELECT * FROM alumnes");
                                    
                                    while(rs.next()==true){
                                        nom = rs.getString("Nom");
                                        dni = rs.getString("Dni");
                                        data = rs.getString("Naixement");
                                        carrer = rs.getString("Apostal");
                                        sexe = rs.getString("Sexe");
                                        codiPostal = rs.getInt("Cpostal");
                                        
                                        System.out.println("Nom [" + nom + "] DNI [" + dni + "] Naixement [" + data + "] Carrer [" + carrer + "] Sexe [" + sexe + "] Codi Postal [" + codiPostal + "]\n");
                                        
                                    }
                                    
                                }catch(Exception ex){
                                   System.out.println("Error al visualitzar els alumnes " + ex);
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
                                
                                try{
                                    selectStmt = connection.createStatement();
                                    ResultSet rs = null;
                                    rs = selectStmt.executeQuery("SELECT * FROM poblacions");
                                    
                                    while(rs.next()==true){
                                        nomPoblacio = rs.getString("Poblacio");
                                        codiPostalPoblacio = rs.getInt("Cpostal");
                                        
                                        System.out.println("Poblacio [" + nomPoblacio + "] Codi Postal [" + codiPostalPoblacio + "]\n");
                                        
                                    }
                                    
                                }catch(Exception ex){
                                   System.out.println("Error al visualitzar les poblacions " + ex);
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
                                    
                                    try{
                                    selectStmt = connection.createStatement();
                                    ResultSet rs = null;
                                    rs = selectStmt.executeQuery("SELECT * FROM alumnes");
                                    
                                    while(rs.next()==true){
                                        String nom = rs.getString("Nom");
                                        String dni = rs.getString("Dni");
                                        String data = rs.getString("Naixement");
                                        String carrer = rs.getString("Apostal");
                                        String sexe = rs.getString("Sexe");
                                        int codiPostal = rs.getInt("Cpostal");
                                        
                                        System.out.println("Nom [" + nom + "] DNI [" + dni + "] Naixement [" + data + "] Carrer [" + carrer + "] Sexe [" + sexe + "] Codi Postal [" + codiPostal + "]\n");
                                        
                                    }
                                    
                                }catch(Exception ex){
                                   System.out.println("Error al visualitzar els alumnes " + ex);
                                }
                                    
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
                                        try{
                                    selectStmt = connection.createStatement();
                                    ResultSet rs = null;
                                    rs = selectStmt.executeQuery("SELECT * FROM poblacions");
                                    
                                    while(rs.next()==true){
                                        String nomPoblacio = rs.getString("Poblacio");
                                        int codiPostalPoblacio = rs.getInt("Cpostal");
                                        
                                        System.out.println("Poblacio [" + nomPoblacio + "] Codi Postal [" + codiPostalPoblacio + "]\n");
                                        
                                    }
                                    
                                }catch(Exception ex){
                                   System.out.println("Error al visualitzar les poblacions " + ex);
                                }
                                        
                                    //ResultSet rs = (ResultSet) selectStmt.executeQuery
                                    
                                }
                                
                    
                                
                        } else if (eleccio == 3){
                            int conta = 0;
                            ResultSet rs = null;
                            ResultSet rs2 = null;
                            
				System.out.println("Elegeix una taula");
				String eleccioTaula = teclado.next();
				System.out.println("Elegeix la columna");
				String eleccioColumna = teclado.next();
				System.out.println("1- VARCHAR | 2- INT");
				int eleccioValor = teclado.nextInt();
                                
                                

				if(eleccioValor == 1){
                                    
					System.out.println("Afegeix el valor");
					String valorColumna = teclado.next();
                                        
                                              if(eleccioTaula.equalsIgnoreCase("alumnes")){

                                                  PreparedStatement pps = connection.prepareStatement("DELETE FROM " + eleccioTaula + " WHERE " + eleccioColumna + " = '" + valorColumna + "'");
                                                  pps.executeUpdate();

                                              } else {

                                              System.out.println("No pots borrar una poblaciÃ³ per el seu nom. ");
                                              
                                              }  
                                	
				} else if (eleccioValor == 2){
                                        System.out.println("Afegeix el valor");
					int valorColumna = teclado.nextInt();
                                        
                                        if(eleccioTaula.equalsIgnoreCase("poblacions")){
                                            
                                            try{
                                            selectStmt = connection.createStatement();
                                            
                                            rs = selectStmt.executeQuery("SELECT * FROM alumnes WHERE " + eleccioColumna + " = '" + valorColumna + "'");
                                            while(rs.next()){
                                                conta++;
                                            }
                                            
                                            System.out.println("Se borraran " + conta + " alumnes quieres continuar 1-SI / 2-NO");
                                            int opcio = teclado.nextInt();
                                            if(opcio == 1){
                                            
                                                PreparedStatement pps = connection.prepareStatement("DELETE FROM " + eleccioTaula + " WHERE " + eleccioColumna + " = " + valorColumna +" ");
                                                pps.executeUpdate();
                                            
                                            } else {
                                            
                                            System.out.println("Se ha cancelat");
                                        }
                                            
                                    
                                            }catch(SQLException ex){

                                            }
                                        }
                                        
                                        
					
				} 
			} else if (eleccio == 5){
                                    try{
                                    selectStmt = connection.createStatement();
                                    
                                    ResultSet rs1 = null;
                                    
                                    System.out.println("Elegeix una taula");
                                    String eleccioTaula = teclado.next();
                                    System.out.println("Elegeix la columna");
                                    String eleccioColumna = teclado.next();
                                    System.out.println("1- VARCHAR | 2- INT");
                                    int eleccioValor = teclado.nextInt();
                                    
                                    if(eleccioValor == 1){
                                       System.out.println("Afegeix el valor");
                                       String valorColumna = teclado.next(); 
                                       rs1 = selectStmt.executeQuery("SELECT * FROM " + eleccioTaula + " WHERE " + eleccioColumna + " ='" + valorColumna + "'");
                                    
                                    if(eleccioTaula.equalsIgnoreCase("alumnes")){
                                       while(rs1.next()==true){
                                            String nom = rs1.getString("Nom");
                                            String dni = rs1.getString("Dni");
                                            String data = rs1.getString("Naixement");
                                            String carrer = rs1.getString("Apostal");
                                            String sexe = rs1.getString("Sexe");
                                            int codiPostal = rs1.getInt("Cpostal");

                                        System.out.println("Nom [" + nom + "] DNI [" + dni + "] Naixement [" + data + "] Carrer [" + carrer + "] Sexe [" + sexe + "] Codi Postal [" + codiPostal + "]\n");
                                        
                                        } 
                                    }else {
                                       while(rs1.next()==true){
                                        String nomPoblacio = rs1.getString("Poblacio");
                                        int codiPostalPoblacio = rs1.getInt("Cpostal");
                                        
                                        System.out.println("Poblacio [" + nomPoblacio + "] Codi Postal [" + codiPostalPoblacio + "]\n");
                                        
                                        } 
                                    }   
                                    

                                    } else if (eleccioValor == 2){
                                        
                                        
                                        System.out.println("Afegeix el valor");
					int valorColumna = teclado.nextInt();
                                        rs1 = selectStmt.executeQuery("SELECT * FROM " + eleccioTaula + " WHERE " + eleccioColumna + " = " + valorColumna);
                                    
                                        if(eleccioTaula.equalsIgnoreCase("alumnes")){
                                            while(rs1.next()==true){
                                                 String nom = rs1.getString("Nom");
                                                 String dni = rs1.getString("Dni");
                                                 String data = rs1.getString("Naixement");
                                                 String carrer = rs1.getString("Apostal");
                                                 String sexe = rs1.getString("Sexe");
                                                 int codiPostal = rs1.getInt("Cpostal");

                                             System.out.println("Nom [" + nom + "] DNI [" + dni + "] Naixement [" + data + "] Carrer [" + carrer + "] Sexe [" + sexe + "] Codi Postal [" + codiPostal + "]\n");

                                             } 
                                         }else {
                                            while(rs1.next()==true){
                                             String nomPoblacio = rs1.getString("Poblacio");
                                             int codiPostalPoblacio = rs1.getInt("Cpostal");

                                             System.out.println("Poblacio [" + nomPoblacio + "] Codi Postal [" + codiPostalPoblacio + "]\n");

                                         } 
                                      
                                        } 
                                    }
                                      
                                    
                                    
                                }catch(Exception ex){
                                   System.out.println("Error al visualitzar els alumnes " + ex);
                                }
                                 
                                    
                                    
                                }
                           
                       System.out.println("1- Afegir columnes(alumnes) | 2- Modificar columnes | 3- Eliminar columnes | 4- Afegir columnes(poblacions | 5-Llistar un alumnes o poblacio | 6- Salir)");
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
    



