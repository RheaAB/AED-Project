/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.SystemAdminWorkArea;

import Business.ESystem;
import Business.Network.Network;
import java.awt.CardLayout;
import java.awt.Component;
import static java.time.Clock.system;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rheab
 */
public class ManageNetworkDashBoardJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageNetworkDashBoardJPanel
     */
    private JPanel userProcessContainer;
    private ESystem ecosystem;

    public ManageNetworkDashBoardJPanel(JPanel userProcessContainer, ESystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        populateNetworkTable();
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
        networkJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        submitJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));

        networkJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(networkJTable);

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        jLabel1.setText("Name");

        submitJButton.setBackground(new java.awt.Color(0, 0, 0));
        submitJButton.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        submitJButton.setForeground(new java.awt.Color(255, 255, 255));
        submitJButton.setText("Submit");
        submitJButton.setBorderPainted(false);
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        backJButton.setBackground(new java.awt.Color(0, 0, 0));
        backJButton.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("Back");
        backJButton.setBorderPainted(false);
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel4.setText("Manage Network");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(backJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(submitJButton)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(227, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed

        String netName = nameJTextField.getText();

        if (netName.equalsIgnoreCase("")) {

            JOptionPane.showMessageDialog(null, "Network Name Cannot Be Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = nameJTextField.getText();

        Network network = ecosystem.createAndAddNetwork();
        network.setName(name);

        populateNetworkTable();
        JOptionPane.showMessageDialog(null, "Network Added Successfully!");
        nameJTextField.setText("");
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void populateNetworkTable() {
        DefaultTableModel model = (DefaultTableModel) networkJTable.getModel();

        model.setRowCount(0);
        for (Network network : ecosystem.getNetworkList()) {
            Object[] row = new Object[1];
            row[0] = network.getName();
            model.addRow(row);
        }
    }

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkDashBoardJPanel sysAdminwjp = (SystemAdminWorkDashBoardJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTable networkJTable;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
