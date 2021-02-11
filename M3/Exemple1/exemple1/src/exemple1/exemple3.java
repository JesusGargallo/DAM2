/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemple1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alumne
 */
public class exemple3 {
    public static void main (String[] args){
        MyFrame frame = new MyFrame("Hello");
        frame.setVisible(true);
    }

    private static class MyFrame extends JFrame {
        JPanel panel;
        JButton label,label1,label2,label3,label4,label5;
        public MyFrame(String title) {
            super(title);
            setSize(500,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            setLayout(new GridLayout(3,2,2,2));
            label = new JButton("Hello Swing!");
            add(label);
            label2 = new JButton("Hello Swing!");
            add(label2);
            label3 = new JButton("Hello Swing!");
            add(label3);
            label4 = new JButton("Hello Swing!");
            add(label4);
            label5 = new JButton("Hello Swing!");
            add(label5);
            label1 = new JButton("Hello Swing!");
            add(label1);
            
        }
    }
}
