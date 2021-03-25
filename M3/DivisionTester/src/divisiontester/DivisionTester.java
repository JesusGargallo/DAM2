/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divisiontester;

import java.util.Scanner;

/**
 *
 * @author Alumne
 */
public class DivisionTester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0, num1 = 0, result = 0;
        String numerator = "", divisor = "";
        boolean salir = true;

        
        while (salir) {
            
           try {
               
                 
                System.out.println("Enter the numerator: ");
                numerator = sc.nextLine();
                
                if (numerator.charAt(0) == 'q' || numerator.charAt(0) == 'Q'){
                    salir = false;
                } else {
                    num = Integer.parseInt(numerator);
                
                
                    System.out.println("Enter the divisor: ");
                    divisor = sc.nextLine();
            
                    num1 = Integer.parseInt(divisor);

                     result = num / num1;

                    System.out.println(num + " / " + num1 + " is: " + result); 
                }
                
            } catch (ArithmeticException e) {
                System.out.println("You can't divide 12 by 0");
            } catch (NumberFormatException a) {
                System.out.println("You entered bad data.\n"
                    + "Please try again.");
            } 
        }
         

    }

}
