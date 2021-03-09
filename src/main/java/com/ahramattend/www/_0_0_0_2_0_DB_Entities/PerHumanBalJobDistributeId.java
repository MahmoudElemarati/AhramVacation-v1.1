package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerHumanBalJobDistributeId generated by hbm2java
 */
@Embeddable
public class PerHumanBalJobDistributeId  implements java.io.Serializable {


     private String locationCode;
     private String humanBalId;
     private String distributeSerial;

    public PerHumanBalJobDistributeId() {
    }

    public PerHumanBalJobDistributeId(String locationCode, String humanBalId, String distributeSerial) {
       this.locationCode = locationCode;
       this.humanBalId = humanBalId;
       this.distributeSerial = distributeSerial;
    }
   


    @Column(name="LOCATION_CODE", nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }


    @Column(name="HUMAN_BAL_ID", nullable=false, length=5)
    public String getHumanBalId() {
        return this.humanBalId;
    }
    
    public void setHumanBalId(String humanBalId) {
        this.humanBalId = humanBalId;
    }


    @Column(name="DISTRIBUTE_SERIAL", nullable=false, length=5)
    public String getDistributeSerial() {
        return this.distributeSerial;
    }
    
    public void setDistributeSerial(String distributeSerial) {
        this.distributeSerial = distributeSerial;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerHumanBalJobDistributeId) ) return false;
		 PerHumanBalJobDistributeId castOther = ( PerHumanBalJobDistributeId ) other; 
         
		 return ( (this.getLocationCode()==castOther.getLocationCode()) || ( this.getLocationCode()!=null && castOther.getLocationCode()!=null && this.getLocationCode().equals(castOther.getLocationCode()) ) )
 && ( (this.getHumanBalId()==castOther.getHumanBalId()) || ( this.getHumanBalId()!=null && castOther.getHumanBalId()!=null && this.getHumanBalId().equals(castOther.getHumanBalId()) ) )
 && ( (this.getDistributeSerial()==castOther.getDistributeSerial()) || ( this.getDistributeSerial()!=null && castOther.getDistributeSerial()!=null && this.getDistributeSerial().equals(castOther.getDistributeSerial()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocationCode() == null ? 0 : this.getLocationCode().hashCode() );
         result = 37 * result + ( getHumanBalId() == null ? 0 : this.getHumanBalId().hashCode() );
         result = 37 * result + ( getDistributeSerial() == null ? 0 : this.getDistributeSerial().hashCode() );
         return result;
   }   


}


