package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerSetupId generated by hbm2java
 */
@Embeddable
public class PerSetupId  implements java.io.Serializable {


     private String locationCode;
     private Date setupDate;

    public PerSetupId() {
    }

    public PerSetupId(String locationCode, Date setupDate) {
       this.locationCode = locationCode;
       this.setupDate = setupDate;
    }
   


    @Column(name="LOCATION_CODE", nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }


    @Column(name="SETUP_DATE", nullable=false, length=7)
    public Date getSetupDate() {
        return this.setupDate;
    }
    
    public void setSetupDate(Date setupDate) {
        this.setupDate = setupDate;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerSetupId) ) return false;
		 PerSetupId castOther = ( PerSetupId ) other; 
         
		 return ( (this.getLocationCode()==castOther.getLocationCode()) || ( this.getLocationCode()!=null && castOther.getLocationCode()!=null && this.getLocationCode().equals(castOther.getLocationCode()) ) )
 && ( (this.getSetupDate()==castOther.getSetupDate()) || ( this.getSetupDate()!=null && castOther.getSetupDate()!=null && this.getSetupDate().equals(castOther.getSetupDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocationCode() == null ? 0 : this.getLocationCode().hashCode() );
         result = 37 * result + ( getSetupDate() == null ? 0 : this.getSetupDate().hashCode() );
         return result;
   }   


}


