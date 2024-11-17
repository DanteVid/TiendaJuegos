package userInterface;

import userInterface.reembolsos.VentanaReembolsos;
import userInterface.ventas.InterfazVentas;

import javax.swing.*;

/**
 *
 * @author Daniel
 */
public class PanelVendedor extends javax.swing.JFrame {

    /**
     * Creates new form PanelAdmin
     */

    String loggedVendedor;
    public PanelVendedor(String loggedVendedor1) {
        initComponents();

        this.setVisible(true);
        this.setLocationRelativeTo(null);

        loggedVendedor = loggedVendedor1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        ventasBtn = new javax.swing.JButton();
        refundBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Bienvenido, seleccione una opción.");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 60, 570, 37);

        logoutBtn.setBackground(new java.awt.Color(0, 102, 102));
        logoutBtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Cerrar Sesión");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        jPanel1.add(logoutBtn);
        logoutBtn.setBounds(550, 410, 222, 34);

        ventasBtn.setBackground(new java.awt.Color(204, 204, 204));
        ventasBtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ventasBtn.setForeground(new java.awt.Color(0, 0, 0));
        ventasBtn.setText("Realizar Ventas");
        ventasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ventasBtn);
        ventasBtn.setBounds(250, 140, 260, 80);

        refundBtn.setBackground(new java.awt.Color(204, 204, 204));
        refundBtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        refundBtn.setForeground(new java.awt.Color(0, 0, 0));
        refundBtn.setText("Realizar Reembolsos");
        refundBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundBtnActionPerformed(evt);
            }
        });
        jPanel1.add(refundBtn);
        refundBtn.setBounds(250, 250, 260, 80);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 840, 500);

        pack();
    }// </editor-fold>

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            PestanaLogin pestanaLogin = new PestanaLogin();
            this.dispose();
        }
    }

    private void ventasBtnActionPerformed(java.awt.event.ActionEvent evt) {
        InterfazVentas interfazVentas = new InterfazVentas(loggedVendedor);
        this.dispose();
    }

    private void refundBtnActionPerformed(java.awt.event.ActionEvent evt) {
        VentanaReembolsos ventana = new VentanaReembolsos(loggedVendedor);
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton refundBtn;
    private javax.swing.JButton ventasBtn;
    // End of variables declaration
}
