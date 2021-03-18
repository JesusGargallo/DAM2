package ex1_nf2_m3;

import java.util.Scanner;

public class Ex1_nf2_m3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int res = 0;
        int lados;

        lados = sc.nextInt();

        res += calcul(lados);

        System.out.println(res);

    }

    public static int calcul(int n) {
        if (n == 1) {
            return 4;
        } else {
            return 4 * n + 4 * calcul(n/2);
        }
    }
    
}
