/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5_damas;

import javax.swing.JOptionPane;

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

    
    /**
     * Creates new form damas_Npartida
     */
    public Damas_Npartida() {
        initComponents();
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
                {"O", "O", "O", "", "O", "", "O", ""},
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
       if(noHiHaOrigen()) {
           if(jugaX && EsX(obtenirFilaClicada(), obtenirColumnaClicada())){
               ActualitzaNouOrigen(obtenirFilaClicada(), obtenirColumnaClicada());
           } else if (jugaO && EsO(obtenirFilaClicada(), obtenirColumnaClicada())) {
               ActualitzaNouOrigen(obtenirFilaClicada(), obtenirColumnaClicada());
           } else {
               mostrarError();
           }
       } else {
           if (movimentValid(obtenirFilaClicada(), obtenirColumnaClicada())) {
               if (esBuit(obtenirFilaClicada(), obtenirColumnaClicada()) 
                       || OcupatContrari(obtenirFilaClicada(), obtenirColumnaClicada())) {
                   mou(obtenirFilaClicada(), obtenirColumnaClicada());
                   filaOrigen = -1;
                   columnaOrigen = -1;
               } else if (OcupatContrari(obtenirFilaClicada(), obtenirColumnaClicada())) {
                   ActualitzaNouOrigen(obtenirFilaClicada(), obtenirColumnaClicada());
               } else {
                   mostrarErrorMoviment();
               }
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
        if(tbTablero.getValueAt(fila, columna).equals("X")){
            esx = true;
        }
        
        
        return esx;
    }
    
    public boolean EsO(int fila,int columna){
        boolean eso = false;
        if(tbTablero.getValueAt(fila, columna).equals("O")){
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
    }
    
    public boolean movimentValid(int fila, int columna){
        boolean esmovimentvalid = false;
        
        filaDesti = fila;
        columnaDesti = columna;
        int columnacalcul = columnaDesti - columnaOrigen;
        int filacalcul = filaDesti - filaOrigen;
        
        if(EsX(fila, columna) && (columnacalcul == 1) && (filacalcul == 1) || 
                (filacalcul == -1)){
            esmovimentvalid = true;
        } else if (EsO (fila, columna) && (columnacalcul == 1) && (filacalcul == 1) 
                || (filacalcul == -1)){
            esmovimentvalid = true;
        
        }
        return esmovimentvalid;
    }
    
    public boolean esBuit (int fila, int columna) {
        boolean esbuit = false;
        if(tbTablero.getValueAt(fila, columna).equals("")){
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
        tbTablero.setValueAt("", filaOrigen, columnaOrigen);
        if(jugaO){
            tbTablero.setValueAt("O", fila, columna);
        } else {
            tbTablero.setValueAt("X", fila, columna);
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
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Damas_Npartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Damas_Npartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Damas_Npartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Damas_Npartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
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

}
