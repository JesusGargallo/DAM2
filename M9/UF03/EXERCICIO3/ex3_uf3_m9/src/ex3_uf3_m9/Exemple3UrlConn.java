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

                for (int j = 1; j <= Integer.valueOf(args[1]); j++) {
                    System.out.println(j + " " + conn.getHeaderField(j));
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
