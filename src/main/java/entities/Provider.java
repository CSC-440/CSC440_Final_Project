package entities;

import org.springframework.data.annotation.Id;

public class Provider extends Validable{    

    private String entityProviderIdNumber;
    private String entityProviderEmailAddress;
    private String providerName;
    private String providerStreetAddress;
    private String providerCity;
    private String providerState;
    private long providerZip;
    private boolean isDietitian;
    private boolean isExerciseExpert;
    private boolean isInternist;
    
    public String getEntityProviderIdNumber() {
        return entityProviderIdNumber;
    }
    
    public void setEntityProviderIdNumber(String entityProviderIdNumber) {
        this.entityProviderIdNumber = entityProviderIdNumber;
    }
    
    public String getEntityProviderEmailAddress() {
        return entityProviderEmailAddress;
    }
    
    public void setEntityProviderEmailAddress(String entityProviderEmailAddress) {
        this.entityProviderEmailAddress = entityProviderEmailAddress;
    }
    
    public String getProviderName() {
        return providerName;
    }
    
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    
    public String getProviderStreetAddress() {
        return providerStreetAddress;
    }
    
    public void setProviderStreetAddress(String providerStreetAddress) {
        this.providerStreetAddress = providerStreetAddress;
    }
    
    public String getProviderCity() {
        return providerCity;
    }
    
    public void setProviderCity(String providerCity) {
        this.providerCity = providerCity;
    }
    
    public String getProviderState() {
        return providerState;
    }
    
    public void setProviderState(String providerState) {
        this.providerState = providerState;
    }
    
    public long getProviderZip() {
        return providerZip;
    }
    
    public void setProviderZip(long providerZip) {
        this.providerZip = providerZip;
    }
    
    public boolean getIsDietitian() {
        return isDietitian;
    }
    
    public void setIsDietitian(boolean isDietitian) {
        this.isDietitian = isDietitian;
    }
    
    public boolean getIsExerciseExpert() {
        return isExerciseExpert;
    }
    
    public void setIsExerciseExpert(boolean isExerciseExpert) {
        this.isExerciseExpert = isExerciseExpert;
    }
    
    public boolean getIsInternist() {
        return isInternist;
    }
    
    public void setIsInternist(boolean isInternist) {
        this.isInternist = isInternist;
    }
    
} // Class generated by : Benjamin Haos
