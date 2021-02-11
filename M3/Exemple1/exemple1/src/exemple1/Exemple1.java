/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemple1;

import javax.swing.JFrame;

/**
 *
 * @author Alumne
 */
public class Exemple1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Frame 1");
        //frame.setSize(200,100);
        frame.setBounds(760 ,390,400,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setBounds(int x, int y, int width, int height){
        
    }
    
}
