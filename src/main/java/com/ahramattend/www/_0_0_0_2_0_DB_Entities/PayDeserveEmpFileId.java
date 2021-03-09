package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PayDeserveEmpFileId generated by hbm2java
 */
@Embeddable
public class PayDeserveEmpFileId  implements java.io.Serializable {


     private byte openMm;
     private short openYyyy;
     private String locCode;
     private byte bandType;
     private String locationCode;
     private short bandCode;

    public PayDeserveEmpFileId() {
    }

    public PayDeserveEmpFileId(byte openMm, short openYyyy, String locCode, byte bandType, String locationCode, short bandCode) {
       this.openMm = openMm;
       this.openYyyy = openYyyy;
       this.locCode = locCode;
       this.bandType = bandType;
       this.locationCode = locationCode;
       this.bandCode = bandCode;
    }
   


    @Column(name="OPEN_MM", nullable=false, precision=2, scale=0)
    public byte getOpenMm() {
        return this.openMm;
    }
    
    public void setOpenMm(byte openMm) {
        this.openMm = openMm;
    }


    @Column(name="OPEN_YYYY", nullable=false, precision=4, scale=0)
    public short getOpenYyyy() {
        return this.openYyyy;
    }
    
    public void setOpenYyyy(short openYyyy) {
        this.openYyyy = openYyyy;
    }


    @Column(name="LOC_CODE", nullable=false, length=3)
    public String getLocCode() {
        return this.locCode;
    }
    
    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }


    @Column(name="BAND_TYPE", nullable=false, precision=2, scale=0)
    public byte getBandType() {
        return this.bandType;
    }
    
    public void setBandType(byte bandType) {
        this.bandType = bandType;
    }


    @Column(name="LOCATION_CODE", nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }


    @Column(name="BAND_CODE", nullable=false, precision=4, scale=0)
    public short getBandCode() {
        return this.bandCode;
    }
    
    public void setBandCode(short bandCode) {
        this.bandCode = bandCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PayDeserveEmpFileId) ) return false;
		 PayDeserveEmpFileId castOther = ( PayDeserveEmpFileId ) other; 
         
		 return (this.getOpenMm()==castOther.getOpenMm())
 && (this.getOpenYyyy()==castOther.getOpenYyyy())
 && ( (this.getLocCode()==castOther.getLocCode()) || ( this.getLocCode()!=null && castOther.getLocCode()!=null && this.getLocCode().equals(castOther.getLocCode()) ) )
 && (this.getBandType()==castOther.getBandType())
 && ( (this.getLocationCode()==castOther.getLocationCode()) || ( this.getLocationCode()!=null && castOther.getLocationCode()!=null && this.getLocationCode().equals(castOther.getLocationCode()) ) )
 && (this.getBandCode()==castOther.getBandCode());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getOpenMm();
         result = 37 * result + this.getOpenYyyy();
         result = 37 * result + ( getLocCode() == null ? 0 : this.getLocCode().hashCode() );
         result = 37 * result + this.getBandType();
         result = 37 * result + ( getLocationCode() == null ? 0 : this.getLocationCode().hashCode() );
         result = 37 * result + this.getBandCode();
         return result;
   }   


}


