package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerQualFacultyId generated by hbm2java
 */
@Embeddable
public class PerQualFacultyId  implements java.io.Serializable {


     private String qualCode;
     private String facultyCode;

    public PerQualFacultyId() {
    }

    public PerQualFacultyId(String qualCode, String facultyCode) {
       this.qualCode = qualCode;
       this.facultyCode = facultyCode;
    }
   


    @Column(name="QUAL_CODE", nullable=false, length=5)
    public String getQualCode() {
        return this.qualCode;
    }
    
    public void setQualCode(String qualCode) {
        this.qualCode = qualCode;
    }


    @Column(name="FACULTY_CODE", nullable=false, length=3)
    public String getFacultyCode() {
        return this.facultyCode;
    }
    
    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerQualFacultyId) ) return false;
		 PerQualFacultyId castOther = ( PerQualFacultyId ) other; 
         
		 return ( (this.getQualCode()==castOther.getQualCode()) || ( this.getQualCode()!=null && castOther.getQualCode()!=null && this.getQualCode().equals(castOther.getQualCode()) ) )
 && ( (this.getFacultyCode()==castOther.getFacultyCode()) || ( this.getFacultyCode()!=null && castOther.getFacultyCode()!=null && this.getFacultyCode().equals(castOther.getFacultyCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getQualCode() == null ? 0 : this.getQualCode().hashCode() );
         result = 37 * result + ( getFacultyCode() == null ? 0 : this.getFacultyCode().hashCode() );
         return result;
   }   


}


