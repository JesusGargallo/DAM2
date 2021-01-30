/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5_damas;

import entity.Movimiento;
import entity.Partida;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Usuario
 */
public class Damas_Npartida extends javax.swing.JFrame {
    
    
    boolean jugaX = true;
    boolean jugaO = false;
    int filaOrigen = -1;
    int columnaOrigen = -1;
    int filaDesti = -1;
    int columnaDesti = -1;
    Partida partida = new Partida("");

    
    /**
     * Creates new form damas_Npartida
     */
    public Damas_Npartida() {
        initComponents();
        NewPartida("VS");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSortir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTablero = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btSortir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSortir.setText("SORTIR");
        btSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSortirActionPerformed(evt);
            }
        });

        tbTablero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"O", "", "O", "", "O", "", "O", ""},
                {"", "O", "", "O", "", "O", "", "O"},
                {"O", "", "O", "", "O", "", "O", ""},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {"", "X", "", "X", "", "X", "", "X"},
                {"X", "", "X", "", "X", "", "X", ""},
                {"", "X", "", "X", "", "X", "", "X"}
            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7", "8"
            }
        ));
        tbTablero.setRowHeight(30);
        tbTablero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTableroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTablero);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btSortir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btSortir)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSortirActionPerformed
        dispose();
    }//GEN-LAST:event_btSortirActionPerformed

    private void tbTableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTableroMouseClicked
        int fila = obtenirFilaClicada();
        int columna = obtenirColumnaClicada();
        
        if(noHiHaOrigen()) {
            
            if (jugaX && EsX(fila, columna)) {
                ActualitzaNouOrigen(fila, columna);
            } else if (jugaO && EsO(fila, columna)) { 
                ActualitzaNouOrigen(fila, columna);
            } else {
                mostrarError();
            }
        } else {
            if (movimentValid(fila, columna)) {
                if (esBuit(fila, columna) || OcupatContrari(fila, columna)) {
                    mou(fila, columna);
                    ganador(fila, columna);
                }  else if (OcupatPropi(fila, columna)) {
                    ActualitzaNouOrigen(fila, columna);
                } 
            } else {
                    mostrarErrorMoviment();
            }
        }
    }//GEN-LAST:event_tbTableroMouseClicked

    
    public int obtenirFilaClicada(){
        int fila = 0;
        fila = tbTablero.getSelectedRow();
        
        return fila;
    }
    
    public int obtenirColumnaClicada(){
        int columna = 0;
        columna = tbTablero.getSelectedColumn();
        
        return columna;
        
    }
    
    public boolean noHiHaOrigen (){
        boolean noOrigen = false;
        if(filaOrigen == -1 || columnaOrigen == -1){
            noOrigen = true;
        }
        return noOrigen;
    }
    
    public boolean EsX(int fila,int columna){
        boolean esx = false;
        if(tbTablero.getValueAt(fila, columna) == ("X")){
            esx = true;
        }
        
        
        return esx;
    }
    
    public boolean EsO(int fila,int columna){
        boolean eso = false;
        if(tbTablero.getValueAt(fila, columna) == ("O" )){
            eso = true;
        }
        
        
        return eso;
    }
    
    public void ActualitzaNouOrigen (int fila , int columna){
        filaOrigen = fila;
        columnaOrigen = columna;
        
    }
    
    public void mostrarError(){
        JOptionPane.showMessageDialog(null, "Error", "Damas",
                JOptionPane.ERROR_MESSAGE);
        
        filaOrigen = -1;
        columnaOrigen = -1;
    }
    
    public boolean movimentValid(int fila, int columna){
        boolean esmovimentvalid = false;
        
        filaDesti = fila;
        columnaDesti = columna;
        int columnacalcul = columnaDesti - columnaOrigen;
        int filacalcul = filaDesti - filaOrigen;
        
        if(jugaX && (filacalcul == -1) && ((columnacalcul == 1) || 
                (columnacalcul == -1))){
            esmovimentvalid = true;
        } else if (jugaO && (filacalcul == 1) && ((columnacalcul == 1) 
                || (columnacalcul == -1))){
            esmovimentvalid = true;
        
        }
        return esmovimentvalid;
    }
    
    public boolean esBuit (int fila, int columna) {
        boolean esbuit = false;
        if(tbTablero.getValueAt(fila, columna) == null){
            esbuit = true;
        }
        
        return esbuit;
    }
    
    public boolean OcupatContrari(int fila , int columna){
        boolean esocupat = false;
        if((jugaX == true && EsO(fila, columna) == true) || 
                (jugaO == true && EsX(fila,columna) == true)){
            esocupat = true;
        }
        
        
        return esocupat;
    }
    
    public void mou(int fila , int columna){
        int check = 0;
        tbTablero.setValueAt(null, filaOrigen, columnaOrigen);
        if(jugaX){
            tbTablero.setValueAt("X", fila, columna);
            filaOrigen = -1;
            columnaOrigen = -1;
            if(check == 0){
                jugaX = false;
                jugaO = true;
            }
        } else {
            tbTablero.setValueAt("O", fila, columna);
            filaOrigen = -1;
            columnaOrigen = -1;
            if(check == 0){
                jugaX = true;
                jugaO = false;
            }
        }
        
        
    }
    
    public boolean OcupatPropi(int fila, int columna){
        boolean esocupatpropi = false;
        if((jugaX == true && EsX(fila, columna) == true) || 
                (jugaO == true && EsO(fila,columna) == true)){
            esocupatpropi = true;
        }
        
        return esocupatpropi;
    }
    
    public void mostrarErrorMoviment(){
        JOptionPane.showMessageDialog(null, "Moviment erroni", "Damas",
                JOptionPane.ERROR_MESSAGE);
        
        filaOrigen = -1;
        columnaOrigen = -1;
        
    }
    
    public void ganador(int fila, int columna){
        
        if(EsX(fila, columna) && fila == 0) {
            jugaX = false; 
            jugaO = false;
            
            JOptionPane.showMessageDialog(null, "X Guanyen", "Damas", 
                JOptionPane.INFORMATION_MESSAGE);
            
            Damas_inicio damasI = new Damas_inicio();
            
            damasI.setVisible(true);
            dispose();
            
        } else if (EsO(fila, columna) && fila == 7) {
            jugaX = false; 
            jugaO = false;
            
            JOptionPane.showMessageDialog(null, "O Guanyen", "Damas", 
                JOptionPane.INFORMATION_MESSAGE);
            
            Damas_inicio damasI = new Damas_inicio();
            
            damasI.setVisible(true);
            dispose();
        }
        
        
    }
    
    public void NewMoviment(int filaOrigen, int columnaOrigen, int filaDesti, int columnaDesti){
        
        
        
    }
    
    public void NewPartida(String ganador){
        
        partida.setGanador(ganador);
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(partida);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        
    }
     
    
    
    public static void main(String args[]) {
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Damas_Npartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSortir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTablero;
    // End of variables declaration//GEN-END:variables

    private void displayResult(List resultList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
