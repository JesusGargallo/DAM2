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
public class exemple2 {
    public static void main (String[] args){
        int height = 100, width = 200;
    JFrame master = new JFrame("Click to close everything");
    JFrame temp = new JFrame("Click to close Just this");
    
    master.setVisible(true);
    master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    master.setSize(400, 300);
    
    temp.setVisible(true);
    temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    temp.setSize(300,200);
    }
    
    
    
}
