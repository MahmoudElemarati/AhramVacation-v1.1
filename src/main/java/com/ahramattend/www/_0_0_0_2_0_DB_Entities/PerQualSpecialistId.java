package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerQualSpecialistId generated by hbm2java
 */
@Embeddable
public class PerQualSpecialistId  implements java.io.Serializable {


     private String qualCode;
     private String specialistCode;

    public PerQualSpecialistId() {
    }

    public PerQualSpecialistId(String qualCode, String specialistCode) {
       this.qualCode = qualCode;
       this.specialistCode = specialistCode;
    }
   


    @Column(name="QUAL_CODE", nullable=false, length=5)
    public String getQualCode() {
        return this.qualCode;
    }
    
    public void setQualCode(String qualCode) {
        this.qualCode = qualCode;
    }


    @Column(name="SPECIALIST_CODE", nullable=false, length=5)
    public String getSpecialistCode() {
        return this.specialistCode;
    }
    
    public void setSpecialistCode(String specialistCode) {
        this.specialistCode = specialistCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerQualSpecialistId) ) return false;
		 PerQualSpecialistId castOther = ( PerQualSpecialistId ) other; 
         
		 return ( (this.getQualCode()==castOther.getQualCode()) || ( this.getQualCode()!=null && castOther.getQualCode()!=null && this.getQualCode().equals(castOther.getQualCode()) ) )
 && ( (this.getSpecialistCode()==castOther.getSpecialistCode()) || ( this.getSpecialistCode()!=null && castOther.getSpecialistCode()!=null && this.getSpecialistCode().equals(castOther.getSpecialistCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getQualCode() == null ? 0 : this.getQualCode().hashCode() );
         result = 37 * result + ( getSpecialistCode() == null ? 0 : this.getSpecialistCode().hashCode() );
         return result;
   }   


}


