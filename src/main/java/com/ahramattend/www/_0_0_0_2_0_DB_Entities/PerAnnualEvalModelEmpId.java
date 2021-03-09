package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerAnnualEvalModelEmpId generated by hbm2java
 */
@Embeddable
public class PerAnnualEvalModelEmpId  implements java.io.Serializable {


     private String annualId;
     private String serialNo;
     private String locationCode;
     private String employeeId;

    public PerAnnualEvalModelEmpId() {
    }

    public PerAnnualEvalModelEmpId(String annualId, String serialNo, String locationCode, String employeeId) {
       this.annualId = annualId;
       this.serialNo = serialNo;
       this.locationCode = locationCode;
       this.employeeId = employeeId;
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


    @Column(name="LOCATION_CODE", nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
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
		 if ( !(other instanceof PerAnnualEvalModelEmpId) ) return false;
		 PerAnnualEvalModelEmpId castOther = ( PerAnnualEvalModelEmpId ) other; 
         
		 return ( (this.getAnnualId()==castOther.getAnnualId()) || ( this.getAnnualId()!=null && castOther.getAnnualId()!=null && this.getAnnualId().equals(castOther.getAnnualId()) ) )
 && ( (this.getSerialNo()==castOther.getSerialNo()) || ( this.getSerialNo()!=null && castOther.getSerialNo()!=null && this.getSerialNo().equals(castOther.getSerialNo()) ) )
 && ( (this.getLocationCode()==castOther.getLocationCode()) || ( this.getLocationCode()!=null && castOther.getLocationCode()!=null && this.getLocationCode().equals(castOther.getLocationCode()) ) )
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAnnualId() == null ? 0 : this.getAnnualId().hashCode() );
         result = 37 * result + ( getSerialNo() == null ? 0 : this.getSerialNo().hashCode() );
         result = 37 * result + ( getLocationCode() == null ? 0 : this.getLocationCode().hashCode() );
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         return result;
   }   


}


