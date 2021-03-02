
package act1_m3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Act1_M3 extends JFrame implements ActionListener{
    JButton bChange;
    JButton bChange2;
    JButton bChange3;
    JButton bChange4;
    
    public Act1_M3(){
        setSize(500,500);
        bChange = new JButton("Vermell");
        bChange2 = new JButton("Verd");
        bChange3 = new JButton("Blau");
        bChange4 = new JButton("Gris");
        setLayout(new FlowLayout());
        add(bChange);
        add(bChange2);
        add(bChange3);
        add(bChange4);
        bChange.setBackground(Color.red);
        bChange2.setBackground(Color.green);
        bChange3.setBackground(Color.blue);
        bChange4.setBackground(Color.gray);
        bChange.addActionListener(this);
        bChange2.addActionListener(this);
        bChange3.addActionListener(this);
        bChange4.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Vermell")){
            getContentPane().setBackground(Color.red);
            repaint();
        } else if (e.getActionCommand().equals("Verd")){
            getContentPane().setBackground(Color.GREEN);
            repaint();
        } else if (e.getActionCommand().equals("Blau")){
            getContentPane().setBackground(Color.BLUE);
            repaint();
        } else if (e.getActionCommand().equals("Gris")){
            getContentPane().setBackground(Color.GRAY);
            repaint();
        }
    }
    
    public static void main(String[] args) {
        Act1_M3 frame = new Act1_M3();
        frame.setVisible(true);
    }

    
    
}
