/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InventoryDirectory;

/**
 *
 * @author gandh
 */
public class SystemConfiguration {
    
    public static ESystem configure(){
    
     ESystem systemfunc = ESystem.getInstance();
        //3 system admins
        //admin manan
        // adding data to user account employee dir
        Employee employeemanan = systemfunc.getEmployeeDirectory().createEmployee("sysadmin");
        // adding data to user account dir
        UserAccount manan = systemfunc.getUserAccountDirectory().createUserAccount("gandhimanan1@gmail.com", "gandhimanan1", employeemanan, new SystemAdminRole());
        //admin rhea
        // adding data to user account employee dir
        Employee employeerhea = systemfunc.getEmployeeDirectory().createEmployee("sysadmin1");
        // adding data to user account dir
        UserAccount rhea = systemfunc.getUserAccountDirectory().createUserAccount("rhea.bajpai555@gmail.com", "rhea.bajpai555", employeerhea, new SystemAdminRole());
        // admin ekta
        // adding data to user account employee dir
        Employee employeeekta = systemfunc.getEmployeeDirectory().createEmployee("sysadmin2");
        // adding data to user account dir
        UserAccount ekta = systemfunc.getUserAccountDirectory().createUserAccount("ektabhatia@gmail.com", "ektabhatia", employeeekta, new SystemAdminRole());

        return systemfunc;

    }
    
}
