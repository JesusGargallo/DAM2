/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act7_m9;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumne
 */


public class NauEspaial extends javax.swing.JFrame {    
    
    public NauEspaial() {
        initComponents();
        }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGap(0, 300, Short.MAX_VALUE));
        pack();
        }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    }
                }
            }
        catch (Exception ex) {
            java.util.logging.Logger.getLogger(NauEspaial.class.getName()).log(
                java.util.logging.Level.SEVERE, null, ex);
            }       
        NauEspaial f = new NauEspaial();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Naus Espaials");
        f.setContentPane(new PanelNau());
        f.setSize(480, 580);
        f.setVisible(true);
        }
    }


class PanelNau extends JPanel implements Runnable, KeyListener{      
    Nau[] nau;
    int comprueba = 0;
    Nau minave;
    Random rand;
    Shot balas[] = new Shot[5];
    double distancia = 0, contacto = 1000;
    
    public static int numB = 5,numNaus = 6;  
    
    public PanelNau(){        
        nau = new Nau[numNaus];
        for (int i=0;i<nau.length;i++) {
            rand = new Random();
            int velocitat=(rand.nextInt(3)+5)*10;
            int posX=rand.nextInt(100)+30;
            int posY=rand.nextInt(100)+30;
            int dX=rand.nextInt(3)+1;
            int dY=rand.nextInt(3)+1;
            nau[i]= new Nau(i,posX,posY,dX,dY,velocitat);
            }
        minave = new Nau(numNaus+9999, 240, 430, 0, 0,5/*rand.nextInt(rand.nextInt(3)+5)*10*/);
        Thread n = new Thread(this);
        n.start();
        
        addKeyListener(this);
        setFocusable(true);
        }

    public void run() {
        System.out.println("Inici fil repintar");
        while(true) {
            try { Thread.sleep(1);} catch(Exception e) {} // espero 0,1 segons
            System.out.println("Repintant");
            repaint();            
            }                   
        }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        for(int i=0; i<nau.length;++i) {
                if(nau[i] != null){
                    nau[i].pinta(g);
                    
                    if(minave != null) {
                        
                        minave.pinta(g);
                        contacto = Math.floor(Math.sqrt((minave.getX() - nau[i].getX()) * (minave.getX() - nau[i].getX()) + (minave.getY() - nau[i].getY()) * 
                                        (minave.getY() - nau[i].getY())));
                    }
                
                }
            if (minave != null ) {  
                minave.pinta(g);
                System.out.println(i);
                
                for(int j=0; j < minave.shots.size() ;j++) {
                    
                    if((minave.shots.get(j) != null) && (nau[i] != null)) {
                        
                        if(minave.shots.get(j).getY() <= 0) {
                            minave.shots.set(j, null);
                            
                        } else {
                            
                            minave.shots.get(j).pinta(g);
                            distancia = Math.floor(Math.sqrt((minave.shots.get(j).getX() - nau[i].getX()) * (minave.shots.get(j).getX() - nau[i].getX()) + (minave.shots.get(j).getY() - nau[i].getY()) * 
                                    (minave.shots.get(j).getY() - nau[i].getY())) );

                            if(minave != null) {
                                System.out.println(contacto);
                                if(contacto < 20) {
                                    if (comprueba == 1) {
                                        minave = null;
                                        JOptionPane.showMessageDialog(null,"HAS PERDIDO ERES MALISIMO");
                                        comprueba = 0;
                                        System.exit(0);

                                    }
                                }
                            }
                            if (distancia < 60) {
                                nau[i] = null;
                                minave.shots.set(j, null);
                                numNaus--;
                                if (numNaus == 0) {
                                    JOptionPane.showMessageDialog(null,"HAS GANADO ERES EL MEJOR");
                                    System.exit(0);   
                                }
                            }
                        }
                    }

                }
            }
            if (minave != null && contacto < 50) {
                System.out.println(contacto);
                if (contacto < 20) {
                    if (comprueba == 0) {
                        minave = null;
                                
                        comprueba = 0;
                        JOptionPane.showMessageDialog(null, "HAS PERDIDO");
                        System.exit(0);
                    }
                }
            }
        }
    }
  
        

    @Override
    public void keyTyped(KeyEvent e) {
         
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int tecla = e.getKeyCode();
        
        if(tecla == 68){
            minave.moureR();
        } else if (tecla == 65) {
            minave.moureL();
        }else if (tecla == 32) {
            minave.disparar();
        }   
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        minave.moureNull();
    }
    
    public int getNumNaus(){
        return numNaus;
    }
    
    }



class Nau extends Thread {
    private int numero;
    private int x,y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    private int dsx,dsy,v;
    private int tx = 10;
    private int ty = 10;
    ArrayList<Shot> shots = new ArrayList<Shot>();

    private String img = "/images/nau.jpg";

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDsx() {
        return dsx;
    }

    public void setDsx(int dsx) {
        this.dsx = dsx;
    }

    public int getDsy() {
        return dsy;
    }

    public void setDsy(int dsy) {
        this.dsy = dsy;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getTx() {
        return tx;
    }

    public void setTx(int tx) {
        this.tx = tx;
    }

    public int getTy() {
        return ty;
    }

    public void setTy(int ty) {
        this.ty = ty;
    }

    public ArrayList<Shot> getShots() {
        return shots;
    }

    public void setShots(ArrayList<Shot> shots) {
        this.shots = shots;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    private Image image;
    
    public Nau(int numero, int x, int y, int dsx, int dsy, int v ) {
        this.numero = numero;
        this.x=x;
        this.y=y;
        this.dsx=dsx;
        this.dsy=dsy;
        this.v=v;
        
        if (numero == (PanelNau.numNaus+9999)){
            image = new ImageIcon(Nau.class.getResource("nave.png")).getImage();
        } else {
            image = new ImageIcon(Nau.class.getResource("enemy.png")).getImage();
        }
        
        Thread t = new Thread(this);
        t.start();
        }
    
    public int velocitat (){
        return v;
        }
    
    public synchronized void moure (){
        x=x + dsx;
        y=y + dsy;
        // si arriva als marges ...
        if ( x>= 420 - tx || x<= tx) dsx = - dsx;
        if ( y >= 440 - ty || y<=ty ) dsy = - dsy;
        }
    
    public synchronized void pinta (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.image, x, y, null);
        }
    

    public void run() {
        while (true) {
            System.out.println("Movent nau numero " + this.numero);
            try { Thread.sleep(this.v); } catch (Exception e) {}
            moure();
            }
        }

    void moureL() {
        if(! (x<= 0 - tx)) {
            this.dsx = -2;
        }
        
    }

    void moureR() {
        if(!( x>= 420 - tx)) {
            this.dsx = 2;
        }
    }

    void moureNull() {
        this.dsx = 0;
    }
    
    public void disparar() {
        System.out.println("pium");
        
        shots.add(new Shot(this.x, this.y ,5));
    }
    
}

 
class Shot extends Thread {
    private int x,y,v;
    private int dsy = 1, dsx = 0;
    private Image image;
    
    public Shot(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
        
        Thread the = new Thread(this);
        image = new ImageIcon(Nau.class.getResource("shot.png")).getImage();
        this.start();
    }             

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getDsy() {
        return dsy;
    }

    public void setDsy(int dsy) {
        this.dsy = dsy;
    }

    public int getDsx() {
        return dsx;
    }

    public void setDsx(int dsx) {
        this.dsx = dsx;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public void run() {
        while (true) {
            System.out.println("Moviendo bala nau numero ");
            try { Thread.sleep(this.v); } catch (Exception e) {}
                moure();
            }
        }
    
    public synchronized void moure (){
        y=y - dsy;

    }
    
    public synchronized void pinta (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.image, x, y, null);
    }
    
}
    

