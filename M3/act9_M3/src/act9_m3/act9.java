/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act9_m3;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumne
 */
public class act9 extends javax.swing.JFrame {

    
    boolean movimentValid, turnoB;
    int fila = -1, col = -1, filadestino = -1, coldestino = -1, check = 0;
    Ficha ficha, fichadestino;
    
    
    public act9() {
        initComponents();
        llenarTabla();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "A", "B", "C", "D", "E", "F", "G", "H"
            }
        ));
        jTable1.setRowHeight(50);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Reiniciar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if ((fila == -1 && col == -1) || check == 0) {
            fila = filaTabla();
            col = colTabla();
            check = 1;
            ficha = new Ficha(fila,col,jTable1,turnoB);
            System.out.println("La letra es:" + ficha.getTipo());
            
        } else if (ficha.perteneceTurno()){
            filadestino = filaTabla();
            coldestino = colTabla();
            check = 0;
            fichadestino = new Ficha(filadestino,coldestino,jTable1,turnoB);
            System.out.println("La letra es:" + fichadestino.getTipo());
            if(!fichadestino.perteneceTurno() && ficha.movimientoValido(fichadestino, jTable1)) {
                jTable1.setValueAt(jTable1.getValueAt(fila, col), filadestino, coldestino);
                jTable1.setValueAt("·",fila,col);
                System.out.println("Haz algo");
                turnoB = !turnoB;
                        
                
            }
            
            
        } else {
            check = 0;
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        llenarTabla();
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(act9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(act9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(act9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(act9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new act9().setVisible(true);
            }
        });
    }
    
    public void llenarTabla() {
        turnoB = true;
        
        Object negras[] = {'t', 'c', 'a', 'q', 'k', 'a', 'c', 't'};
        Object PN[] = {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'};
        Object FilaBuit[] = {'·', '·', '·', '·', '·', '·', '·', '·'};
        Object blancas[] = {'T', 'C', 'A', 'Q', 'K', 'A', 'C', 'T'};
        Object PB[] = {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'};
        
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("A");
        model.addColumn("B");
        model.addColumn("C");
        model.addColumn("D");
        model.addColumn("E");
        model.addColumn("F");
        model.addColumn("G");
        model.addColumn("H");
        
        model.addRow(negras);
        model.addRow(PN);
        model.addRow(FilaBuit);
        model.addRow(FilaBuit);
        model.addRow(FilaBuit);
        model.addRow(FilaBuit);
        model.addRow(PB);
        model.addRow(blancas);
        
        
        
        
        jTable1.setModel(model);
        jTable1.setDefaultEditor(Object.class, null);
        fila = -1;
        col = -1;
        filadestino = -1;
        coldestino = -1;
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private int filaTabla() {
        return jTable1.getSelectedRow();
    }

    private int colTabla() {
        return jTable1.getSelectedColumn();
    }
}
