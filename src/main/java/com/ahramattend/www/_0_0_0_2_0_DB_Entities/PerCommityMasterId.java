package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerCommityMasterId generated by hbm2java
 */
@Embeddable
public class PerCommityMasterId  implements java.io.Serializable {


     private String locationCode;
     private String commityNo;

    public PerCommityMasterId() {
    }

    public PerCommityMasterId(String locationCode, String commityNo) {
       this.locationCode = locationCode;
       this.commityNo = commityNo;
    }
   


    @Column(name="LOCATION_CODE", nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }


    @Column(name="COMMITY_NO", nullable=false, length=10)
    public String getCommityNo() {
        return this.commityNo;
    }
    
    public void setCommityNo(String commityNo) {
        this.commityNo = commityNo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerCommityMasterId) ) return false;
		 PerCommityMasterId castOther = ( PerCommityMasterId ) other; 
         
		 return ( (this.getLocationCode()==castOther.getLocationCode()) || ( this.getLocationCode()!=null && castOther.getLocationCode()!=null && this.getLocationCode().equals(castOther.getLocationCode()) ) )
 && ( (this.getCommityNo()==castOther.getCommityNo()) || ( this.getCommityNo()!=null && castOther.getCommityNo()!=null && this.getCommityNo().equals(castOther.getCommityNo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocationCode() == null ? 0 : this.getLocationCode().hashCode() );
         result = 37 * result + ( getCommityNo() == null ? 0 : this.getCommityNo().hashCode() );
         return result;
   }   


}


