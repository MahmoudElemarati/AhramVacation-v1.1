package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PayDeserveEmpId generated by hbm2java
 */
@Embeddable
public class PayDeserveEmpId  implements java.io.Serializable {


     private byte bandType;
     private short bandCode;
     private String employeeId;
     private byte methodType;
     private int deserveSp;

    public PayDeserveEmpId() {
    }

    public PayDeserveEmpId(byte bandType, short bandCode, String employeeId, byte methodType, int deserveSp) {
       this.bandType = bandType;
       this.bandCode = bandCode;
       this.employeeId = employeeId;
       this.methodType = methodType;
       this.deserveSp = deserveSp;
    }
   


    @Column(name="BAND_TYPE", nullable=false, precision=2, scale=0)
    public byte getBandType() {
        return this.bandType;
    }
    
    public void setBandType(byte bandType) {
        this.bandType = bandType;
    }


    @Column(name="BAND_CODE", nullable=false, precision=4, scale=0)
    public short getBandCode() {
        return this.bandCode;
    }
    
    public void setBandCode(short bandCode) {
        this.bandCode = bandCode;
    }


    @Column(name="EMPLOYEE_ID", nullable=false, length=10)
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    @Column(name="METHOD_TYPE", nullable=false, precision=2, scale=0)
    public byte getMethodType() {
        return this.methodType;
    }
    
    public void setMethodType(byte methodType) {
        this.methodType = methodType;
    }


    @Column(name="DESERVE_SP", nullable=false, precision=7, scale=0)
    public int getDeserveSp() {
        return this.deserveSp;
    }
    
    public void setDeserveSp(int deserveSp) {
        this.deserveSp = deserveSp;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PayDeserveEmpId) ) return false;
		 PayDeserveEmpId castOther = ( PayDeserveEmpId ) other; 
         
		 return (this.getBandType()==castOther.getBandType())
 && (this.getBandCode()==castOther.getBandCode())
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) )
 && (this.getMethodType()==castOther.getMethodType())
 && (this.getDeserveSp()==castOther.getDeserveSp());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getBandType();
         result = 37 * result + this.getBandCode();
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         result = 37 * result + this.getMethodType();
         result = 37 * result + this.getDeserveSp();
         return result;
   }   


}

