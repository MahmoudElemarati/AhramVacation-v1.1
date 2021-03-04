package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PayExecutionSpecificEmpId generated by hbm2java
 */
@Embeddable
public class PayExecutionSpecificEmpId  implements java.io.Serializable {


     private byte methodType;
     private Date execMm;
     private int methodSeq;
     private String employeeId;

    public PayExecutionSpecificEmpId() {
    }

    public PayExecutionSpecificEmpId(byte methodType, Date execMm, int methodSeq, String employeeId) {
       this.methodType = methodType;
       this.execMm = execMm;
       this.methodSeq = methodSeq;
       this.employeeId = employeeId;
    }
   


    @Column(name="METHOD_TYPE", nullable=false, precision=2, scale=0)
    public byte getMethodType() {
        return this.methodType;
    }
    
    public void setMethodType(byte methodType) {
        this.methodType = methodType;
    }


    @Column(name="EXEC_MM", nullable=false, length=7)
    public Date getExecMm() {
        return this.execMm;
    }
    
    public void setExecMm(Date execMm) {
        this.execMm = execMm;
    }


    @Column(name="METHOD_SEQ", nullable=false, precision=5, scale=0)
    public int getMethodSeq() {
        return this.methodSeq;
    }
    
    public void setMethodSeq(int methodSeq) {
        this.methodSeq = methodSeq;
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
		 if ( !(other instanceof PayExecutionSpecificEmpId) ) return false;
		 PayExecutionSpecificEmpId castOther = ( PayExecutionSpecificEmpId ) other; 
         
		 return (this.getMethodType()==castOther.getMethodType())
 && ( (this.getExecMm()==castOther.getExecMm()) || ( this.getExecMm()!=null && castOther.getExecMm()!=null && this.getExecMm().equals(castOther.getExecMm()) ) )
 && (this.getMethodSeq()==castOther.getMethodSeq())
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getMethodType();
         result = 37 * result + ( getExecMm() == null ? 0 : this.getExecMm().hashCode() );
         result = 37 * result + this.getMethodSeq();
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         return result;
   }   


}


