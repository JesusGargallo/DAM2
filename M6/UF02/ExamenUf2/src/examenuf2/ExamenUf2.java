
package examenuf2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ExamenUf2 {
    
    
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner teclado = new Scanner(System.in);
        
        Connection connection = null;
        Statement stmt = null;
        Statement selectStmt = null;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/examenuf2", "root", "");
        
        try {
            
            
            System.out.println("1- CREAR | 2- LOGIN | 3- RESET | 4- Salir)");
            int eleccio = teclado.nextInt();
            teclado.nextLine();
            while(eleccio != 4){
                if(eleccio == 1){
                    System.out.println("Usuari ?");
                    String usuari = teclado.next();
                    System.out.println("Password ?");
                    String password = teclado.next();
                    System.out.println("Pregunta ?");
                    String pregunta = teclado.next();
                    System.out.println("Resposta ?");
                    String resposta = teclado.next();
                    teclado.nextLine();
                    
                    
                    
                    try{
                        
			stmt = connection.createStatement();
			stmt.execute("INSERT INTO usuaris VALUES ('" + usuari.trim() + "','" + password.trim() + "','" + pregunta.trim() + "','" + resposta.trim() + "')");
                        System.out.println("Usuari Creat");
                        

                    } catch (Exception e) {
                        System.out.println("Error " + e);
                    }
                    
                    
                    
                } else if (eleccio == 2){
                    
                    System.out.println("usuari ?");
                    String usuari = teclado.next();
                    System.out.println("password ?");
                    String password = teclado.next();
                    
                } else if (eleccio == 3){
                    
                }
                System.out.println("1- CREAR | 2- LOGIN | 3- RESET | 4- Salir)");
                eleccio = teclado.nextInt();
                teclado.nextLine();
            }
            
            
        }catch (Exception e) {
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
