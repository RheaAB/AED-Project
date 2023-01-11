/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Distributors;

import Business.ESystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.QualityCheckEnterprise;
import Business.Network.Network;
import Business.Organization.DistributorOrganization;
import Business.Organization.Organization;
import Business.Organization.QualityOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoodRequirementRequest;
import Business.WorkQueue.Inventory;
import Business.WorkQueue.InventoryDirectory;
import Business.WorkQueue.Products;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gandh
 */
public class DistributorAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DistributorAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private DistributorOrganization distributorOrganization;
    private Enterprise enterprise;
    private ESystem business;

    public DistributorAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, DistributorOrganization distributorOrganization, Enterprise enterprise, ESystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.business = business;
        this.enterprise = enterprise;
        this.distributorOrganization = (DistributorOrganization) distributorOrganization;

        populateTable();
    }

    public void populateTable() {

        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : distributorOrganization.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();

            model.addRow(row);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        btnSendtoQualityCheck = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setForeground(new java.awt.Color(255, 255, 255));

        assignJButton.setBackground(new java.awt.Color(0, 0, 0));
        assignJButton.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        assignJButton.setForeground(new java.awt.Color(255, 255, 255));
        assignJButton.setText("Assign Work Request");
        assignJButton.setBorderPainted(false);
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        processJButton.setBackground(new java.awt.Color(0, 0, 0));
        processJButton.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        processJButton.setForeground(new java.awt.Color(255, 255, 255));
        processJButton.setText("Process Work Request");
        processJButton.setBorderPainted(false);
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setBackground(new java.awt.Color(0, 0, 0));
        refreshJButton.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        refreshJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshJButton.setText("Refresh");
        refreshJButton.setBorderPainted(false);
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        btnSendtoQualityCheck.setBackground(new java.awt.Color(0, 0, 0));
        btnSendtoQualityCheck.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnSendtoQualityCheck.setForeground(new java.awt.Color(255, 255, 255));
        btnSendtoQualityCheck.setText("Send for Quality Check");
        btnSendtoQualityCheck.setBorderPainted(false);
        btnSendtoQualityCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendtoQualityCheckActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel1.setText("Work Request");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(assignJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(processJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSendtoQualityCheck)
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(processJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendtoQualityCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);

        if (request.getStatus().equalsIgnoreCase("Sent to Distributor")) {
            request.setReceiver(userAccount);
            request.setStatus("Pending");
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Request cannot be assigned by " + userAccount, "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Boolean flag = false;
        ArrayList<Boolean> booleanList = new ArrayList<>();
        ArrayList<Products> reqProduct = new ArrayList<>();
        HashMap<String, Integer> reqProductMap = new HashMap<>();

        FoodRequirementRequest request = (FoodRequirementRequest) workRequestJTable.getValueAt(selectedRow, 0);

        if (request.getStatus().equalsIgnoreCase("Sent to Distributor")) {
            JOptionPane.showMessageDialog(null, "Please assign the request", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (request.getStatus().equalsIgnoreCase("Sent to Quality")) {
            JOptionPane.showMessageDialog(null, "Cannot Process the Request!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        System.out.println(InventoryDirectory.inventoryList+"inventory");
        for (Inventory inSupp : InventoryDirectory.getInventoryList()) {
            
            for (Products prod : request.getProductList()) {
                if (prod.getProductName().equalsIgnoreCase(inSupp.getProductName())) {
                    System.out.println(prod.getProductName() + "   " + inSupp.getProductName());
                    if (prod.getQuantity() < inSupp.getQuantity()) {
//                        suppCount=inSupp.getQuantity();
//                        reqCount=prod.getQuantity();
//                        suppCount=-reqCount;
//                        inSupp.setQuantity(suppCount);
                        booleanList.add(true);
                        //    flag = true;
                        //  break;

                    } else {
                        reqProductMap.put(prod.getProductName(), prod.getQuantity());
                        System.out.println(reqProductMap + "Request Map");
                        booleanList.add(false);
//   flag = false;
//                        JOptionPane.showMessageDialog(null, "Insufficient Quantity for "+prod.getProductName());
                        //  break;
                    }
                }
            }
        }
        if (booleanList.contains(false)) {
            flag = false;
        } else {
            flag = true;
        }
        System.out.println(flag + "FLAG KA VALUE");
        request.setStatus("Processing");

        ProcessAreaJPanel processWorkRequestJPanel = new ProcessAreaJPanel(userProcessContainer, userAccount, request, flag, reqProductMap, enterprise, business);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
        JOptionPane.showMessageDialog(null, "Requests Updated!");
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void btnSendtoQualityCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendtoQualityCheckActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request");
            return;
        }

        FoodRequirementRequest quaRequest = (FoodRequirementRequest) workRequestJTable.getValueAt(selectedRow, 0);
        
        if (quaRequest.getStatus().equalsIgnoreCase("Sent to Supplier")) {
            JOptionPane.showMessageDialog(null, "Request pending with Supplier!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (quaRequest.getStatus().equalsIgnoreCase("Sent to Quality")) {
            JOptionPane.showMessageDialog(null, "Request already sent for Quality Check!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (!(quaRequest.getStatus().equalsIgnoreCase("Completed"))) {
            JOptionPane.showMessageDialog(null, "Request yet to be approved by Distributer");
            return;
        }
        if(quaRequest.getReceiver()==userAccount)
        {
            quaRequest.setReceiver(null);
        }
        //String message = messageJTextField.getText();
        //FoodRequirementRequest request = new FoodRequirementRequest();
        quaRequest.setMessage(quaRequest.getMessage());
        quaRequest.setSender(userAccount);
        quaRequest.setStatus("Sent to Quality");

        for (Network n : business.getNetworkList()) {

            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {

                //   e.setEnterpriseType(Enterprise.EnterpriseType.QualityCheck);
                //if(e.getEnterpriseType().getValue().equals("Quality Check"))
                if (e instanceof QualityCheckEnterprise) {

                    Organization org = null;
                    for (Organization organization : e.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof QualityOrganization) { //changed from shlter to ngo organization
                            org = organization;
                            break;
                        }
                    }
                    if (org != null) {

                        org.getWorkQueue().getWorkRequestList().add(quaRequest);
                        userAccount.getWorkQueue().getWorkRequestList().add(quaRequest);
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Request Successfully Sent for Quality Check!");
    }//GEN-LAST:event_btnSendtoQualityCheckActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton btnSendtoQualityCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
