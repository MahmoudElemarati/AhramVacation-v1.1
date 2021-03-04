package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerAnnualEvalModelId generated by hbm2java
 */
@Embeddable
public class PerAnnualEvalModelId  implements java.io.Serializable {


     private String locationCode;
     private String annualId;
     private String serialNo;

    public PerAnnualEvalModelId() {
    }

    public PerAnnualEvalModelId(String locationCode, String annualId, String serialNo) {
       this.locationCode = locationCode;
       this.annualId = annualId;
       this.serialNo = serialNo;
    }
   


    @Column(name="LOCATION_CODE", nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }


    @Column(name="ANNUAL_ID", nullable=false, length=5)
    public String getAnnualId() {
        return this.annualId;
    }
    
    public void setAnnualId(String annualId) {
        this.annualId = annualId;
    }


    @Column(name="SERIAL_NO", nullable=false, length=5)
    public String getSerialNo() {
        return this.serialNo;
    }
    
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerAnnualEvalModelId) ) return false;
		 PerAnnualEvalModelId castOther = ( PerAnnualEvalModelId ) other; 
         
		 return ( (this.getLocationCode()==castOther.getLocationCode()) || ( this.getLocationCode()!=null && castOther.getLocationCode()!=null && this.getLocationCode().equals(castOther.getLocationCode()) ) )
 && ( (this.getAnnualId()==castOther.getAnnualId()) || ( this.getAnnualId()!=null && castOther.getAnnualId()!=null && this.getAnnualId().equals(castOther.getAnnualId()) ) )
 && ( (this.getSerialNo()==castOther.getSerialNo()) || ( this.getSerialNo()!=null && castOther.getSerialNo()!=null && this.getSerialNo().equals(castOther.getSerialNo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocationCode() == null ? 0 : this.getLocationCode().hashCode() );
         result = 37 * result + ( getAnnualId() == null ? 0 : this.getAnnualId().hashCode() );
         result = 37 * result + ( getSerialNo() == null ? 0 : this.getSerialNo().hashCode() );
         return result;
   }   


}


