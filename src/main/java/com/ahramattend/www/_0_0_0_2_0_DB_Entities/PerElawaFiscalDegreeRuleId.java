package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerElawaFiscalDegreeRuleId generated by hbm2java
 */
@Embeddable
public class PerElawaFiscalDegreeRuleId  implements java.io.Serializable {


     private String elawaTypeCode;
     private String locationCode;
     private Date elawaDate;
     private String fiscalDegreeCode;

    public PerElawaFiscalDegreeRuleId() {
    }

    public PerElawaFiscalDegreeRuleId(String elawaTypeCode, String locationCode, Date elawaDate, String fiscalDegreeCode) {
       this.elawaTypeCode = elawaTypeCode;
       this.locationCode = locationCode;
       this.elawaDate = elawaDate;
       this.fiscalDegreeCode = fiscalDegreeCode;
    }
   


    @Column(name="ELAWA_TYPE_CODE", nullable=false, length=2)
    public String getElawaTypeCode() {
        return this.elawaTypeCode;
    }
    
    public void setElawaTypeCode(String elawaTypeCode) {
        this.elawaTypeCode = elawaTypeCode;
    }


    @Column(name="LOCATION_CODE", nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }


    @Column(name="ELAWA_DATE", nullable=false, length=7)
    public Date getElawaDate() {
        return this.elawaDate;
    }
    
    public void setElawaDate(Date elawaDate) {
        this.elawaDate = elawaDate;
    }


    @Column(name="FISCAL_DEGREE_CODE", nullable=false, length=3)
    public String getFiscalDegreeCode() {
        return this.fiscalDegreeCode;
    }
    
    public void setFiscalDegreeCode(String fiscalDegreeCode) {
        this.fiscalDegreeCode = fiscalDegreeCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerElawaFiscalDegreeRuleId) ) return false;
		 PerElawaFiscalDegreeRuleId castOther = ( PerElawaFiscalDegreeRuleId ) other; 
         
		 return ( (this.getElawaTypeCode()==castOther.getElawaTypeCode()) || ( this.getElawaTypeCode()!=null && castOther.getElawaTypeCode()!=null && this.getElawaTypeCode().equals(castOther.getElawaTypeCode()) ) )
 && ( (this.getLocationCode()==castOther.getLocationCode()) || ( this.getLocationCode()!=null && castOther.getLocationCode()!=null && this.getLocationCode().equals(castOther.getLocationCode()) ) )
 && ( (this.getElawaDate()==castOther.getElawaDate()) || ( this.getElawaDate()!=null && castOther.getElawaDate()!=null && this.getElawaDate().equals(castOther.getElawaDate()) ) )
 && ( (this.getFiscalDegreeCode()==castOther.getFiscalDegreeCode()) || ( this.getFiscalDegreeCode()!=null && castOther.getFiscalDegreeCode()!=null && this.getFiscalDegreeCode().equals(castOther.getFiscalDegreeCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getElawaTypeCode() == null ? 0 : this.getElawaTypeCode().hashCode() );
         result = 37 * result + ( getLocationCode() == null ? 0 : this.getLocationCode().hashCode() );
         result = 37 * result + ( getElawaDate() == null ? 0 : this.getElawaDate().hashCode() );
         result = 37 * result + ( getFiscalDegreeCode() == null ? 0 : this.getFiscalDegreeCode().hashCode() );
         return result;
   }   


}


