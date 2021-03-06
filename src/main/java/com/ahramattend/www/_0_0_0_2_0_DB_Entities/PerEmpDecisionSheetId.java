package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerEmpDecisionSheetId generated by hbm2java
 */
@Embeddable
public class PerEmpDecisionSheetId  implements java.io.Serializable {


     private String locationCode;
     private String decisionId;
     private String employeeId;

    public PerEmpDecisionSheetId() {
    }

    public PerEmpDecisionSheetId(String locationCode, String decisionId, String employeeId) {
       this.locationCode = locationCode;
       this.decisionId = decisionId;
       this.employeeId = employeeId;
    }
   


    @Column(name="LOCATION_CODE", nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }


    @Column(name="DECISION_ID", nullable=false, length=10)
    public String getDecisionId() {
        return this.decisionId;
    }
    
    public void setDecisionId(String decisionId) {
        this.decisionId = decisionId;
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
		 if ( !(other instanceof PerEmpDecisionSheetId) ) return false;
		 PerEmpDecisionSheetId castOther = ( PerEmpDecisionSheetId ) other; 
         
		 return ( (this.getLocationCode()==castOther.getLocationCode()) || ( this.getLocationCode()!=null && castOther.getLocationCode()!=null && this.getLocationCode().equals(castOther.getLocationCode()) ) )
 && ( (this.getDecisionId()==castOther.getDecisionId()) || ( this.getDecisionId()!=null && castOther.getDecisionId()!=null && this.getDecisionId().equals(castOther.getDecisionId()) ) )
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocationCode() == null ? 0 : this.getLocationCode().hashCode() );
         result = 37 * result + ( getDecisionId() == null ? 0 : this.getDecisionId().hashCode() );
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         return result;
   }   


}


