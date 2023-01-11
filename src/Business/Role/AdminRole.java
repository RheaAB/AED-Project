/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.ESystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UI.Admin.AdminJPanel;
import javax.swing.JPanel;

/**
 *
 * @author rheab
 */
public class AdminRole extends Role {
    
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, ESystem business) {
        return new AdminJPanel(userProcessContainer, enterprise);
    }
    
}
