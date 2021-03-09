package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerAttendanceExistZkId generated by hbm2java
 */
@Embeddable
public class PerAttendanceExistZkId  implements java.io.Serializable {


     private Date attendanceDate;
     private String employeeNo;
     private String timeHh;
     private String timeMm;
     private String timeSs;
     private boolean transKind;

    public PerAttendanceExistZkId() {
    }

    public PerAttendanceExistZkId(Date attendanceDate, String employeeNo, String timeHh, String timeMm, String timeSs, boolean transKind) {
       this.attendanceDate = attendanceDate;
       this.employeeNo = employeeNo;
       this.timeHh = timeHh;
       this.timeMm = timeMm;
       this.timeSs = timeSs;
       this.transKind = transKind;
    }
   


    @Column(name="ATTENDANCE_DATE", nullable=false, length=7)
    public Date getAttendanceDate() {
        return this.attendanceDate;
    }
    
    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }


    @Column(name="EMPLOYEE_NO", nullable=false, length=10)
    public String getEmployeeNo() {
        return this.employeeNo;
    }
    
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }


    @Column(name="TIME_HH", nullable=false, length=2)
    public String getTimeHh() {
        return this.timeHh;
    }
    
    public void setTimeHh(String timeHh) {
        this.timeHh = timeHh;
    }


    @Column(name="TIME_MM", nullable=false, length=2)
    public String getTimeMm() {
        return this.timeMm;
    }
    
    public void setTimeMm(String timeMm) {
        this.timeMm = timeMm;
    }


    @Column(name="TIME_SS", nullable=false, length=2)
    public String getTimeSs() {
        return this.timeSs;
    }
    
    public void setTimeSs(String timeSs) {
        this.timeSs = timeSs;
    }


    @Column(name="TRANS_KIND", nullable=false, precision=1, scale=0)
    public boolean isTransKind() {
        return this.transKind;
    }
    
    public void setTransKind(boolean transKind) {
        this.transKind = transKind;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerAttendanceExistZkId) ) return false;
		 PerAttendanceExistZkId castOther = ( PerAttendanceExistZkId ) other; 
         
		 return ( (this.getAttendanceDate()==castOther.getAttendanceDate()) || ( this.getAttendanceDate()!=null && castOther.getAttendanceDate()!=null && this.getAttendanceDate().equals(castOther.getAttendanceDate()) ) )
 && ( (this.getEmployeeNo()==castOther.getEmployeeNo()) || ( this.getEmployeeNo()!=null && castOther.getEmployeeNo()!=null && this.getEmployeeNo().equals(castOther.getEmployeeNo()) ) )
 && ( (this.getTimeHh()==castOther.getTimeHh()) || ( this.getTimeHh()!=null && castOther.getTimeHh()!=null && this.getTimeHh().equals(castOther.getTimeHh()) ) )
 && ( (this.getTimeMm()==castOther.getTimeMm()) || ( this.getTimeMm()!=null && castOther.getTimeMm()!=null && this.getTimeMm().equals(castOther.getTimeMm()) ) )
 && ( (this.getTimeSs()==castOther.getTimeSs()) || ( this.getTimeSs()!=null && castOther.getTimeSs()!=null && this.getTimeSs().equals(castOther.getTimeSs()) ) )
 && (this.isTransKind()==castOther.isTransKind());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAttendanceDate() == null ? 0 : this.getAttendanceDate().hashCode() );
         result = 37 * result + ( getEmployeeNo() == null ? 0 : this.getEmployeeNo().hashCode() );
         result = 37 * result + ( getTimeHh() == null ? 0 : this.getTimeHh().hashCode() );
         result = 37 * result + ( getTimeMm() == null ? 0 : this.getTimeMm().hashCode() );
         result = 37 * result + ( getTimeSs() == null ? 0 : this.getTimeSs().hashCode() );
         result = 37 * result + (this.isTransKind()?1:0);
         return result;
   }   


}


