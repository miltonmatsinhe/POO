/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

import controler.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class FrmListSindicatoFilter extends javax.swing.JDialog {
    DefaultTableModel model;
    /* Array para receber os dados do ficheiro de texto e manuseamento de dados
       no programa java */
    private Sindicato sindicatos[] = new Sindicato[100];
    private int nrElem = 0;
    private int estado = 1;
    
    public FrmListSindicatoFilter(java.awt.Frame parent, boolean modal, int estado) {
        super(parent, modal);
        initComponents();
        model = (DefaultTableModel)tbDados.getModel();
        loadSindicatos();
        preencheTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA DE SINDICATOS/ASSOCIAÇÕES REGISTADAS NO SISTEMA DE GESTÃO DE SINDICATOS");

        tbDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "SIGLA", "DESIGNAÇÃO", "ENDERECO", "CONTACTO", "DATAINSCRICAO", "REPRESENTANTE", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDados);
        if (tbDados.getColumnModel().getColumnCount() > 0) {
            tbDados.getColumnModel().getColumn(0).setMinWidth(25);
            tbDados.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbDados.getColumnModel().getColumn(0).setMaxWidth(70);
            tbDados.getColumnModel().getColumn(1).setMinWidth(30);
            tbDados.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbDados.getColumnModel().getColumn(1).setMaxWidth(100);
            tbDados.getColumnModel().getColumn(2).setMinWidth(150);
            tbDados.getColumnModel().getColumn(2).setPreferredWidth(250);
            tbDados.getColumnModel().getColumn(2).setMaxWidth(400);
            tbDados.getColumnModel().getColumn(3).setMinWidth(100);
            tbDados.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbDados.getColumnModel().getColumn(3).setMaxWidth(300);
            tbDados.getColumnModel().getColumn(4).setMinWidth(60);
            tbDados.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbDados.getColumnModel().getColumn(4).setMaxWidth(120);
            tbDados.getColumnModel().getColumn(5).setMinWidth(50);
            tbDados.getColumnModel().getColumn(5).setPreferredWidth(70);
            tbDados.getColumnModel().getColumn(5).setMaxWidth(120);
            tbDados.getColumnModel().getColumn(6).setMinWidth(100);
            tbDados.getColumnModel().getColumn(6).setPreferredWidth(125);
            tbDados.getColumnModel().getColumn(6).setMaxWidth(200);
            tbDados.getColumnModel().getColumn(7).setMinWidth(50);
            tbDados.getColumnModel().getColumn(7).setPreferredWidth(65);
            tbDados.getColumnModel().getColumn(7).setMaxWidth(125);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1295, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDadosMouseClicked
        if(evt.getClickCount() == 2){
            int linha = (int)tbDados.getSelectedRow();
            if(linha >= 0){
                int cod = (int)model.getValueAt(linha, 0);
                Sindicato sind = new Sindicato().findSindicato(cod);
                FrmDetalhesSindicato view = new FrmDetalhesSindicato(null, true, sind);
                view.setLocationRelativeTo(null);
                view.setVisible(true);
            };
        }
    }//GEN-LAST:event_tbDadosMouseClicked

    private void incrementaArry(){
        //verifica se o array está cheio, caso sim duplica a capacidade
        if(nrElem >= sindicatos.length){
            Sindicato aux[]= sindicatos;
            sindicatos = new Sindicato[aux.length * 2];
            for(int i = 0; i<aux.length; i++){
                sindicatos[i] = aux[i];
            }
        }
    }
    
    //Leitura do ficheiro de texto e insercão do seu conteudo no array de objecto empresa
    private void loadSindicatos(){ 
        Object regs[][] = new Sindicato().loadSindicatos();
        sindicatos = (Sindicato[])regs[0][0];
        nrElem = (int)regs[0][1];
    }
    
    private void preencheTabela(){
        for(int i=0; i<nrElem; i++){
            if(sindicatos[i].getEstado() == estado){
                System.out.println(sindicatos[i].toString());
                Distrito distrito = new Distrito().findDistrito(sindicatos[i].getCodDist());
                EstadoSindicato estado = new EstadoSindicato().findEstado(sindicatos[i].getEstado());
                model.addRow(new Object[]{sindicatos[i].getCodigo(), sindicatos[i].getSigla(), sindicatos[i].getDesignacao(), sindicatos[i].getEndereco(), sindicatos[i].getContacto(), sindicatos[i].getData(), sindicatos[i].getRepresentante(), estado.getEstado()});
        
            }
        }
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
            java.util.logging.Logger.getLogger(FrmListSindicatoFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListSindicatoFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListSindicatoFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListSindicatoFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmListSindicatoFilter dialog = new FrmListSindicatoFilter(new javax.swing.JFrame(), true, 1);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDados;
    // End of variables declaration//GEN-END:variables
}
