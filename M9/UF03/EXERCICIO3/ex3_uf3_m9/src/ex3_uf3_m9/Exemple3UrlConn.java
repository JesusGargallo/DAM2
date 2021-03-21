package ex3_uf3_m9;

import java.net.*;
import java.io.*;
import java.util.*;

public class Exemple3UrlConn {
	
	@SuppressWarnings("rawtypes")
	public static void main (String[] args) {
            
            Scanner sc = new Scanner(System.in);
            String c;

            try {
                URL url = new URL(args[0]);
                URLConnection conn = url.openConnection();
                
                System.out.println("Los campos de la capçelera");
                Map camps = conn.getHeaderFields();
                Iterator iterator = camps.entrySet().iterator();

                while (iterator.hasNext()) {
                    Map.Entry map = (Map.Entry) iterator.next();
                    System.out.println(map.getKey() + " con el valor " + map.getValue());
                }

                for (int i = 1; i <= Integer.valueOf(args[1]); i++) {
                    System.out.println(i + " " + conn.getHeaderField(i));
                }

                BufferedReader pagina
                        = new BufferedReader(new InputStreamReader(url.openStream()));

                while ((c = pagina.readLine()) != null) {
                    if (c.contains(args[2])) System.out.println(c);
                }

            } catch (IOException | NumberFormatException e) {
                System.out.println(e);
            }
	}

}
