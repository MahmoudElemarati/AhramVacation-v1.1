package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerAttendanceWrkTypeDetailId generated by hbm2java
 */
@Embeddable
public class PerAttendanceWrkTypeDetailId  implements java.io.Serializable {


     private String workTypeCode;
     private String workTypeSeq;

    public PerAttendanceWrkTypeDetailId() {
    }

    public PerAttendanceWrkTypeDetailId(String workTypeCode, String workTypeSeq) {
       this.workTypeCode = workTypeCode;
       this.workTypeSeq = workTypeSeq;
    }
   


    @Column(name="WORK_TYPE_CODE", nullable=false, length=3)
    public String getWorkTypeCode() {
        return this.workTypeCode;
    }
    
    public void setWorkTypeCode(String workTypeCode) {
        this.workTypeCode = workTypeCode;
    }


    @Column(name="WORK_TYPE_SEQ", nullable=false, length=3)
    public String getWorkTypeSeq() {
        return this.workTypeSeq;
    }
    
    public void setWorkTypeSeq(String workTypeSeq) {
        this.workTypeSeq = workTypeSeq;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerAttendanceWrkTypeDetailId) ) return false;
		 PerAttendanceWrkTypeDetailId castOther = ( PerAttendanceWrkTypeDetailId ) other; 
         
		 return ( (this.getWorkTypeCode()==castOther.getWorkTypeCode()) || ( this.getWorkTypeCode()!=null && castOther.getWorkTypeCode()!=null && this.getWorkTypeCode().equals(castOther.getWorkTypeCode()) ) )
 && ( (this.getWorkTypeSeq()==castOther.getWorkTypeSeq()) || ( this.getWorkTypeSeq()!=null && castOther.getWorkTypeSeq()!=null && this.getWorkTypeSeq().equals(castOther.getWorkTypeSeq()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getWorkTypeCode() == null ? 0 : this.getWorkTypeCode().hashCode() );
         result = 37 * result + ( getWorkTypeSeq() == null ? 0 : this.getWorkTypeSeq().hashCode() );
         return result;
   }   


}


