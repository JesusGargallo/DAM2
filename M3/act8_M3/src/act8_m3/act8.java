/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act8_m3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumne
 */
public class act8 extends javax.swing.JFrame {
    
    String[] arrayPanells = new String[] {"X","W","X","W","W","0","0","0","0","0","0","0","0","0","0","0"};
    int i = 0;
    List<String> strList = Arrays.asList(arrayPanells);

    /**
     * Creates new form act8
     */
    public act8() {
        initComponents();
        jTable1.setEnabled(false);
        jTextPuntos.setEditable(false);
        Collections.shuffle(strList);
        arrayPanells = strList.toArray(new String[strList.size()]);
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
        jSortir = new javax.swing.JButton();
        jReiniciar = new javax.swing.JButton();
        jTextPuntos = new javax.swing.JTextField();
        jpuntoslabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jrecordpuntos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jTable1.setRowHeight(50);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jSortir.setText("Sortir");
        jSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSortirActionPerformed(evt);
            }
        });

        jReiniciar.setText("Començar");
        jReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jReiniciarActionPerformed(evt);
            }
        });

        jTextPuntos.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jTextPuntos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPuntosActionPerformed(evt);
            }
        });

        jpuntoslabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jpuntoslabel.setText("Punts :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Rècord :");

        jrecordpuntos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jrecordpuntos.setText("0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("punts");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpuntoslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jrecordpuntos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jSortir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jReiniciar))
                        .addComponent(jTextPuntos, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jrecordpuntos)
                            .addComponent(jLabel2))
                        .addGap(25, 25, 25)
                        .addComponent(jpuntoslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSortir)
                            .addComponent(jReiniciar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSortirActionPerformed
        JOptionPane.showMessageDialog(null, "Has perdut, has fet " + jTextPuntos.getText() + " punt", "Game Over", 
        JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }//GEN-LAST:event_jSortirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.isEnabled()== true) {
        
        if (jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()) == ("?")) {
        jTable1.setValueAt(arrayPanells[i], jTable1.getSelectedRow(), jTable1.getSelectedColumn());
        i++;
        if (jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()) == ("0")) {
            
            String myString = jTextPuntos.getText();
            int punts = Integer.parseInt(myString);
            punts = punts + 1;
            
            jTextPuntos.setText(String.valueOf(punts));
            
            String myString2 = jrecordpuntos.getText();
            
            int puntsRecord = Integer.parseInt(myString2);
                if (puntsRecord < punts) {
                jrecordpuntos.setText(jTextPuntos.getText());
                }
        } else if (jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()) == ("W")) {
            
            String myString = jTextPuntos.getText();
            int punts = Integer.parseInt(myString);
            
            punts = punts * 2;
            jTextPuntos.setText(String.valueOf(punts));
            
            String myString2 = jrecordpuntos.getText();
            
            int puntsRecord = Integer.parseInt(myString2);
            
            if (puntsRecord < punts) {
                jrecordpuntos.setText(jTextPuntos.getText());
              }
        } else {
            jocAcabat();
        }
    } else {
        mostraError();
    }
    } else {
        JOptionPane.showMessageDialog(null, "Comença la partida primer! ", "Start game", 
        JOptionPane.ERROR_MESSAGE); 
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jReiniciarActionPerformed
        i=0;
        jTextPuntos.setText("0");
        if(jReiniciar.getText().equalsIgnoreCase("començar")) {
            jReiniciar.setText("Reinicia pantalla");
        } else {
            jReiniciar.setText("Començar");
        }
        
        jTable1.setEnabled(true);
        arrayPanells = new String[] {"X","W","X","W","W","0","0","0","0","0","0","0","0","0","0","0"};
        strList = Arrays.asList(arrayPanells);
        Collections.shuffle(strList);
        arrayPanells = strList.toArray(new String[strList.size()]);
        for (int i = 0; i<jTable1.getRowCount(); i++) {
            jTable1.setValueAt("?", 0, i);
            jTable1.setValueAt("?", 1, i);
            jTable1.setValueAt("?", 2, i);
            jTable1.setValueAt("?", 3, i);

        }
    }//GEN-LAST:event_jReiniciarActionPerformed

    private void jTextPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPuntosActionPerformed

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
            java.util.logging.Logger.getLogger(act8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(act8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(act8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(act8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new act8().setVisible(true);
            }
        });
    }
    
    private boolean esBuit() {
     return arrayPanells.equals("X");
    }
    
    private void mostraError() {
        JOptionPane.showMessageDialog(null, "Error, no pitjis un panel revelat", "Error Act8", 
                JOptionPane.ERROR_MESSAGE);
    }
    
    private void jocAcabat() {
        String myString = jTextPuntos.getText();
        int punts = Integer.parseInt(myString);
        String myString2 = jrecordpuntos.getText();
        int puntsRecord = Integer.parseInt(myString2);
        if (puntsRecord < punts) {
        jrecordpuntos.setText(jTextPuntos.getText());
        }
        JOptionPane.showMessageDialog(null, "Has perdut, has fet " + jTextPuntos.getText() + " punt", "Game Over", 
                JOptionPane.ERROR_MESSAGE);
                jTable1.setEnabled(false);
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jReiniciar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSortir;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextPuntos;
    private javax.swing.JLabel jpuntoslabel;
    private javax.swing.JLabel jrecordpuntos;
    // End of variables declaration//GEN-END:variables
    
}


