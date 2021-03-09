package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AppEmployeeReqJ2221Id generated by hbm2java
 */
@Embeddable
public class AppEmployeeReqJ2221Id  implements java.io.Serializable {


     private short bandCode;
     private byte bandType;
     private long reqSp;
     private String employeeId;

    public AppEmployeeReqJ2221Id() {
    }

    public AppEmployeeReqJ2221Id(short bandCode, byte bandType, long reqSp, String employeeId) {
       this.bandCode = bandCode;
       this.bandType = bandType;
       this.reqSp = reqSp;
       this.employeeId = employeeId;
    }
   


    @Column(name="BAND_CODE", nullable=false, precision=4, scale=0)
    public short getBandCode() {
        return this.bandCode;
    }
    
    public void setBandCode(short bandCode) {
        this.bandCode = bandCode;
    }


    @Column(name="BAND_TYPE", nullable=false, precision=2, scale=0)
    public byte getBandType() {
        return this.bandType;
    }
    
    public void setBandType(byte bandType) {
        this.bandType = bandType;
    }


    @Column(name="REQ_SP", nullable=false, precision=16, scale=0)
    public long getReqSp() {
        return this.reqSp;
    }
    
    public void setReqSp(long reqSp) {
        this.reqSp = reqSp;
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
		 if ( !(other instanceof AppEmployeeReqJ2221Id) ) return false;
		 AppEmployeeReqJ2221Id castOther = ( AppEmployeeReqJ2221Id ) other; 
         
		 return (this.getBandCode()==castOther.getBandCode())
 && (this.getBandType()==castOther.getBandType())
 && (this.getReqSp()==castOther.getReqSp())
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getBandCode();
         result = 37 * result + this.getBandType();
         result = 37 * result + (int) this.getReqSp();
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         return result;
   }   


}


