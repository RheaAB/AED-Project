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
import UI.SystemAdminWorkArea.SystemAdminWorkDashBoardJPanel;
import javax.swing.JPanel;

/**
 *
 * @author rheab
 */
public class SystemAdminRole extends Role{
    
    
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, ESystem system) {
        return new SystemAdminWorkDashBoardJPanel(userProcessContainer, system);
    }
    
}
