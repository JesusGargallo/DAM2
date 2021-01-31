/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5_damas;

import entity.Movimiento;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Usuario
 */
public class Damas_repeticion extends javax.swing.JFrame {
Session session;
List resultList;
int numero = 0;


    public Damas_repeticion() {
        initComponents();
        session = NewHibernateUtil.getSessionFactory().openSession();
        CarregaMoviment();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbTableroR = new javax.swing.JTable();
        bCarrega = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbTableroR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"O", null, "O", null, "O", null, "O", null},
                {null, "O", null, "O", null, "O", null, "O"},
                {"O", null, "O", null, "O", "", "O", null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {"", "X", null, "X", null, "X", null, "X"},
                {"X", null, "X", null, "X", null, "X", null},
                {null, "X", null, "X", null, "X", null, "X"}
            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7", "8"
            }
        ));
        tbTableroR.setMinimumSize(new java.awt.Dimension(120, 240));
        tbTableroR.setPreferredSize(new java.awt.Dimension(600, 240));
        tbTableroR.setRowHeight(30);
        jScrollPane1.setViewportView(tbTableroR);

        bCarrega.setText("Repetició Carrega");
        bCarrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCarregaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(bCarrega)
                .addGap(137, 137, 137))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(bCarrega)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCarregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCarregaActionPerformed
    
        ClickRepetir(numero);
        numero++;
        
    }//GEN-LAST:event_bCarregaActionPerformed
    
    
    public void CarregaMoviment(){
        try {
            
            session.beginTransaction();
            Query q = session.createQuery("from Movimiento movimiento where movimiento.partida.idPartida = (select max(mov.partida.idPartida) from Movimiento mov)");
            resultList = q.list();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    
    public void ClickRepetir(int numero) {
        
        if(numero < resultList.size()){
            Movimiento movimiento = (Movimiento) resultList.get(numero);
            tbTableroR.setValueAt(tbTableroR.getValueAt(movimiento.getFilaOrigen(), movimiento.getColumnaOrigen()), movimiento.getFilaDesti(), movimiento.getColumnaDesti());
            tbTableroR.setValueAt(null, movimiento.getFilaOrigen(), movimiento.getColumnaOrigen());  
        }else {
            Damas_inicio damas_inicio = new Damas_inicio();
            damas_inicio.setVisible(true);
            dispose();
        }
        
        
        
    }
    
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
            java.util.logging.Logger.getLogger(Damas_repeticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Damas_repeticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Damas_repeticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Damas_repeticion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Damas_repeticion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCarrega;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTableroR;
    // End of variables declaration//GEN-END:variables
}
