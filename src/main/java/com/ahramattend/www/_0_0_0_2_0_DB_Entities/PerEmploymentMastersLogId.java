package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerEmploymentMastersLogId generated by hbm2java
 */
@Embeddable
public class PerEmploymentMastersLogId  implements java.io.Serializable {


     private String employeeId;
     private String employeeSeq;

    public PerEmploymentMastersLogId() {
    }

    public PerEmploymentMastersLogId(String employeeId, String employeeSeq) {
       this.employeeId = employeeId;
       this.employeeSeq = employeeSeq;
    }
   


    @Column(name="EMPLOYEE_ID", nullable=false, length=10)
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    @Column(name="EMPLOYEE_SEQ", nullable=false, length=5)
    public String getEmployeeSeq() {
        return this.employeeSeq;
    }
    
    public void setEmployeeSeq(String employeeSeq) {
        this.employeeSeq = employeeSeq;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerEmploymentMastersLogId) ) return false;
		 PerEmploymentMastersLogId castOther = ( PerEmploymentMastersLogId ) other; 
         
		 return ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) )
 && ( (this.getEmployeeSeq()==castOther.getEmployeeSeq()) || ( this.getEmployeeSeq()!=null && castOther.getEmployeeSeq()!=null && this.getEmployeeSeq().equals(castOther.getEmployeeSeq()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         result = 37 * result + ( getEmployeeSeq() == null ? 0 : this.getEmployeeSeq().hashCode() );
         return result;
   }   


}


