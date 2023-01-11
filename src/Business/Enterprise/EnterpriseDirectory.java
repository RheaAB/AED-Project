/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author ektab
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseListArray;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseListArray;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseListArray = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseListArray=new ArrayList<Enterprise>();
    }
    
    //creating enterprise for each type
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprises=null;
        if(type==Enterprise.EnterpriseType.NGO){
            enterprises=new NGOEnterprise(name);
            enterpriseListArray.add(enterprises);
        }
        else if(type==Enterprise.EnterpriseType.QualityCheck){
            enterprises=new QualityCheckEnterprise(name);
            enterpriseListArray.add(enterprises);
        }
        else if(type==Enterprise.EnterpriseType.Distributor){
            enterprises=new DistributorEnterprise(name);
            enterpriseListArray.add(enterprises);
        }
        else if(type==Enterprise.EnterpriseType.Shelter){
            enterprises=new ShelterEnterprise(name);
            enterpriseListArray.add(enterprises);
        }
        else if(type==Enterprise.EnterpriseType.Supplier){
            enterprises=new SupplierEnterprise(name);
            enterpriseListArray.add(enterprises);
        }
        
        return enterprises;
    }
    
    
}
