package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PayBandClassificationFileId generated by hbm2java
 */
@Embeddable
public class PayBandClassificationFileId  implements java.io.Serializable {


     private short fileSp;
     private byte methodType;
     private short bandCode;
     private byte bandType;

    public PayBandClassificationFileId() {
    }

    public PayBandClassificationFileId(short fileSp, byte methodType, short bandCode, byte bandType) {
       this.fileSp = fileSp;
       this.methodType = methodType;
       this.bandCode = bandCode;
       this.bandType = bandType;
    }
   


    @Column(name="FILE_SP", nullable=false, precision=3, scale=0)
    public short getFileSp() {
        return this.fileSp;
    }
    
    public void setFileSp(short fileSp) {
        this.fileSp = fileSp;
    }


    @Column(name="METHOD_TYPE", nullable=false, precision=2, scale=0)
    public byte getMethodType() {
        return this.methodType;
    }
    
    public void setMethodType(byte methodType) {
        this.methodType = methodType;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PayBandClassificationFileId) ) return false;
		 PayBandClassificationFileId castOther = ( PayBandClassificationFileId ) other; 
         
		 return (this.getFileSp()==castOther.getFileSp())
 && (this.getMethodType()==castOther.getMethodType())
 && (this.getBandCode()==castOther.getBandCode())
 && (this.getBandType()==castOther.getBandType());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getFileSp();
         result = 37 * result + this.getMethodType();
         result = 37 * result + this.getBandCode();
         result = 37 * result + this.getBandType();
         return result;
   }   


}

