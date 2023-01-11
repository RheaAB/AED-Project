/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author gandh
 */
public class ESystem extends Organization{
    
    private static ESystem business;
    private ArrayList<Network> networkListArray;
    
    
    public static ESystem getInstance(){
        if(business==null){
            business=new ESystem();
        }
        return business;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkListArray.add(network);
        return network;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleListArray=new ArrayList<Role>();
        roleListArray.add(new SystemAdminRole());
        return roleListArray;
    }
    private ESystem(){
        super(null);
        networkListArray=new ArrayList<Network>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkListArray;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkListArray = networkList;
    }
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Network network:networkListArray){
            
        }
        return true;
    }
    
    
}
