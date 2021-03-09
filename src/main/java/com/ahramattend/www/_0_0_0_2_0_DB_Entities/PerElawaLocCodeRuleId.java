package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerElawaLocCodeRuleId generated by hbm2java
 */
@Embeddable
public class PerElawaLocCodeRuleId  implements java.io.Serializable {


     private String locationCode;
     private String elawaTypeCode;
     private Date elawaDate;
     private String locCode;

    public PerElawaLocCodeRuleId() {
    }

    public PerElawaLocCodeRuleId(String locationCode, String elawaTypeCode, Date elawaDate, String locCode) {
       this.locationCode = locationCode;
       this.elawaTypeCode = elawaTypeCode;
       this.elawaDate = elawaDate;
       this.locCode = locCode;
    }
   


    @Column(name="LOCATION_CODE", nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }


    @Column(name="ELAWA_TYPE_CODE", nullable=false, length=2)
    public String getElawaTypeCode() {
        return this.elawaTypeCode;
    }
    
    public void setElawaTypeCode(String elawaTypeCode) {
        this.elawaTypeCode = elawaTypeCode;
    }


    @Column(name="ELAWA_DATE", nullable=false, length=7)
    public Date getElawaDate() {
        return this.elawaDate;
    }
    
    public void setElawaDate(Date elawaDate) {
        this.elawaDate = elawaDate;
    }


    @Column(name="LOC_CODE", nullable=false, length=3)
    public String getLocCode() {
        return this.locCode;
    }
    
    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerElawaLocCodeRuleId) ) return false;
		 PerElawaLocCodeRuleId castOther = ( PerElawaLocCodeRuleId ) other; 
         
		 return ( (this.getLocationCode()==castOther.getLocationCode()) || ( this.getLocationCode()!=null && castOther.getLocationCode()!=null && this.getLocationCode().equals(castOther.getLocationCode()) ) )
 && ( (this.getElawaTypeCode()==castOther.getElawaTypeCode()) || ( this.getElawaTypeCode()!=null && castOther.getElawaTypeCode()!=null && this.getElawaTypeCode().equals(castOther.getElawaTypeCode()) ) )
 && ( (this.getElawaDate()==castOther.getElawaDate()) || ( this.getElawaDate()!=null && castOther.getElawaDate()!=null && this.getElawaDate().equals(castOther.getElawaDate()) ) )
 && ( (this.getLocCode()==castOther.getLocCode()) || ( this.getLocCode()!=null && castOther.getLocCode()!=null && this.getLocCode().equals(castOther.getLocCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocationCode() == null ? 0 : this.getLocationCode().hashCode() );
         result = 37 * result + ( getElawaTypeCode() == null ? 0 : this.getElawaTypeCode().hashCode() );
         result = 37 * result + ( getElawaDate() == null ? 0 : this.getElawaDate().hashCode() );
         result = 37 * result + ( getLocCode() == null ? 0 : this.getLocCode().hashCode() );
         return result;
   }   


}


