package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerEasementTransId generated by hbm2java
 */
@Embeddable
public class PerEasementTransId  implements java.io.Serializable {


     private String locationCode;
     private String humanBalId;
     private String transId;

    public PerEasementTransId() {
    }

    public PerEasementTransId(String locationCode, String humanBalId, String transId) {
       this.locationCode = locationCode;
       this.humanBalId = humanBalId;
       this.transId = transId;
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


    @Column(name="TRANS_ID", nullable=false, length=5)
    public String getTransId() {
        return this.transId;
    }
    
    public void setTransId(String transId) {
        this.transId = transId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerEasementTransId) ) return false;
		 PerEasementTransId castOther = ( PerEasementTransId ) other; 
         
		 return ( (this.getLocationCode()==castOther.getLocationCode()) || ( this.getLocationCode()!=null && castOther.getLocationCode()!=null && this.getLocationCode().equals(castOther.getLocationCode()) ) )
 && ( (this.getHumanBalId()==castOther.getHumanBalId()) || ( this.getHumanBalId()!=null && castOther.getHumanBalId()!=null && this.getHumanBalId().equals(castOther.getHumanBalId()) ) )
 && ( (this.getTransId()==castOther.getTransId()) || ( this.getTransId()!=null && castOther.getTransId()!=null && this.getTransId().equals(castOther.getTransId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocationCode() == null ? 0 : this.getLocationCode().hashCode() );
         result = 37 * result + ( getHumanBalId() == null ? 0 : this.getHumanBalId().hashCode() );
         result = 37 * result + ( getTransId() == null ? 0 : this.getTransId().hashCode() );
         return result;
   }   


}


