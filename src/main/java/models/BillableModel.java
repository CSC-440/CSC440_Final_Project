package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BillableModel {
    private Map<String, Object> billable;

    /**
     * Constructor
     */
    public BillableModel() {
        this.billable = new HashMap<>();
    }
    
    public int createBillable(String chocoServiceProvidedIdNumber, String memberNumberService, String providerNumberServicing, String dateServiced, String dateServicedRecorded, String serviceComment){
        
        BillableTable usr = new BillableTable();

        usr.setChocoServiceProvidedIdNumber(chocoServiceProvidedIdNumber);
        usr.setMemberNumberService(memberNumberService);
        usr.setProviderNumberServicing(providerNumberServicing);
        usr.setDateServiced(dateServiced);
        usr.setDateServicedRecorded(dateServicedRecorded);
        usr.setServiceComment(serviceComment);
        billable.put(chocoServiceProvidedIdNumber, usr);
    
        return 1;
    }
    
    /**
     * Check to find if a user is available
     * @param id
     * @return
     */
    public boolean checkBillable(String id) {
        Iterator it = billable.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            BillableTable u = (BillableTable)pair.getValue();
            if((u.getChocoServiceProvidedIdNumber().equals(id)))
                return false;
        }
        return true;
    }
    
    public int updateBillable(String chocoServiceProvidedIdNumber, String memberNumberService, String providerNumberServicing, String dateServiced, String dateServicedRecorded, String serviceComment){

        BillableTable usr = (BillableTable)billable.get(chocoServiceProvidedIdNumber);

        usr.setMemberNumberService(memberNumberService);
        usr.setProviderNumberServicing(providerNumberServicing);
        usr.setDateServiced(dateServiced);
        usr.setDateServicedRecorded(dateServicedRecorded);
        usr.setServiceComment(serviceComment);
        billable.put(chocoServiceProvidedIdNumber, usr);
    
        return 1;
    }
    
    public boolean removeBillable(String id) {
        if(!checkBillable(id)) {
            billable.remove(id);
            return true;    
        }
        return false;
    }
    public List sendElements() {
        List<Object> ret = new ArrayList<>(billable.values());
        return ret;
    }

    public List sendBillablesId() {
        List<Object> ret = new ArrayList<>(billable.keySet());
        return ret;
    }

} // Class generated by : Benjamin Haos
