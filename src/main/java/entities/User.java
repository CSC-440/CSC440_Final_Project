package entities;
    
public class User implements Validable{    
    
    private String memberNumber;
    private String memberName;
    private String memberStreetAddress;
    private String memberCity;
    private String memberState;
    private long memberZip;
    
    public String getMemberNumber() {
        return memberNumber;
    }
    
    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }
    
    public String getMemberName() {
        return memberName;
    }
    
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    
    public String getMemberStreetAddress() {
        return memberStreetAddress;
    }
    
    public void setMemberStreetAddress(String memberStreetAddress) {
        this.memberStreetAddress = memberStreetAddress;
    }
    
    public String getMemberCity() {
        return memberCity;
    }
    
    public void setMemberCity(String memberCity) {
        this.memberCity = memberCity;
    }
    
    public String getMemberState() {
        return memberState;
    }
    
    public void setMemberState(String memberState) {
        this.memberState = memberState;
    }
    
    public long getMemberZip() {
        return memberZip;
    }
    
    public void setMemberZip(long memberZip) {
        this.memberZip = memberZip;
    }
    
    @Override
    public boolean isValid() {
        if(this.memberNumber == null || this.memberNumber.length() != 9) return false;
        for(int i = 0; i < this.memberNumber.length(); i++){
            if(!Character.isDigit(this.memberNumber.charAt(i)))
                return false;
        }
        if(this.memberName == null || this.memberName.length() > 25)
            return false;
        if(this.memberStreetAddress == null || this.memberStreetAddress.length() > 25)
            return false;
        if(this.memberCity == null || this.memberCity.length() > 14)
            return false;
        if(this.memberState == null || this.memberState.length() > 2)
            return false;
        if(this.memberZip == 0 || (String.valueOf(this.memberZip)).length() != 5)
            return false;
        for(int i = 0; i < (String.valueOf(this.memberZip)).length(); i++){
            if(!Character.isDigit((String.valueOf(this.memberZip)).charAt(i)))
                return false;
        }
        return true;
    }
}
// Class generated by : Benjamin Haos
// isValid method by : Zachary Brunette
