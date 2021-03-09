package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerElawaTransactionRejectId generated by hbm2java
 */
@Embeddable
public class PerElawaTransactionRejectId  implements java.io.Serializable {


     private String locationCode;
     private String elawaTypeCode;
     private Date elawaDate;
     private String employeeId;

    public PerElawaTransactionRejectId() {
    }

    public PerElawaTransactionRejectId(String locationCode, String elawaTypeCode, Date elawaDate, String employeeId) {
       this.locationCode = locationCode;
       this.elawaTypeCode = elawaTypeCode;
       this.elawaDate = elawaDate;
       this.employeeId = employeeId;
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


    @Column(name="EMPLOYEE_ID", nullable=false, length=10)
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerElawaTransactionRejectId) ) return false;
		 PerElawaTransactionRejectId castOther = ( PerElawaTransactionRejectId ) other; 
         
		 return ( (this.getLocationCode()==castOther.getLocationCode()) || ( this.getLocationCode()!=null && castOther.getLocationCode()!=null && this.getLocationCode().equals(castOther.getLocationCode()) ) )
 && ( (this.getElawaTypeCode()==castOther.getElawaTypeCode()) || ( this.getElawaTypeCode()!=null && castOther.getElawaTypeCode()!=null && this.getElawaTypeCode().equals(castOther.getElawaTypeCode()) ) )
 && ( (this.getElawaDate()==castOther.getElawaDate()) || ( this.getElawaDate()!=null && castOther.getElawaDate()!=null && this.getElawaDate().equals(castOther.getElawaDate()) ) )
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocationCode() == null ? 0 : this.getLocationCode().hashCode() );
         result = 37 * result + ( getElawaTypeCode() == null ? 0 : this.getElawaTypeCode().hashCode() );
         result = 37 * result + ( getElawaDate() == null ? 0 : this.getElawaDate().hashCode() );
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         return result;
   }   


}


