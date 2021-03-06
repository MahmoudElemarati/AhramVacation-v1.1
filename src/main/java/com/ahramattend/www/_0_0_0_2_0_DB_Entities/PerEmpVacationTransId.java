package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerEmpVacationTransId generated by hbm2java
 */
@Embeddable
public class PerEmpVacationTransId  implements java.io.Serializable {


     private String employeeId;
     private String vacationCode;
     private String transSerialNo;

    public PerEmpVacationTransId() {
    }

    public PerEmpVacationTransId(String employeeId, String vacationCode, String transSerialNo) {
       this.employeeId = employeeId;
       this.vacationCode = vacationCode;
       this.transSerialNo = transSerialNo;
    }
   


    @Column(name="EMPLOYEE_ID", nullable=false, length=10)
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    @Column(name="VACATION_CODE", nullable=false, length=2)
    public String getVacationCode() {
        return this.vacationCode;
    }
    
    public void setVacationCode(String vacationCode) {
        this.vacationCode = vacationCode;
    }


    @Column(name="TRANS_SERIAL_NO", nullable=false, length=5)
    public String getTransSerialNo() {
        return this.transSerialNo;
    }
    
    public void setTransSerialNo(String transSerialNo) {
        this.transSerialNo = transSerialNo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerEmpVacationTransId) ) return false;
		 PerEmpVacationTransId castOther = ( PerEmpVacationTransId ) other; 
         
		 return ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) )
 && ( (this.getVacationCode()==castOther.getVacationCode()) || ( this.getVacationCode()!=null && castOther.getVacationCode()!=null && this.getVacationCode().equals(castOther.getVacationCode()) ) )
 && ( (this.getTransSerialNo()==castOther.getTransSerialNo()) || ( this.getTransSerialNo()!=null && castOther.getTransSerialNo()!=null && this.getTransSerialNo().equals(castOther.getTransSerialNo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         result = 37 * result + ( getVacationCode() == null ? 0 : this.getVacationCode().hashCode() );
         result = 37 * result + ( getTransSerialNo() == null ? 0 : this.getTransSerialNo().hashCode() );
         return result;
   }   


}


