package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerHumanBalOrgId generated by hbm2java
 */
@Embeddable
public class PerHumanBalOrgId  implements java.io.Serializable {


     private String locationCode;
     private String humanBalId;
     private String groupTypeCode;
     private String fiscalDegreeCode;
     private String jobCode;
     private String orgId;

    public PerHumanBalOrgId() {
    }

    public PerHumanBalOrgId(String locationCode, String humanBalId, String groupTypeCode, String fiscalDegreeCode, String jobCode, String orgId) {
       this.locationCode = locationCode;
       this.humanBalId = humanBalId;
       this.groupTypeCode = groupTypeCode;
       this.fiscalDegreeCode = fiscalDegreeCode;
       this.jobCode = jobCode;
       this.orgId = orgId;
    }
   


    @Column(name="LOCATION_CODE", nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }


    @Column(name="HUMAN_BAL_ID", nullable=false, length=5)
    public String getHumanBalId() {
        return this.humanBalId;
    }
    
    public void setHumanBalId(String humanBalId) {
        this.humanBalId = humanBalId;
    }


    @Column(name="GROUP_TYPE_CODE", nullable=false, length=3)
    public String getGroupTypeCode() {
        return this.groupTypeCode;
    }
    
    public void setGroupTypeCode(String groupTypeCode) {
        this.groupTypeCode = groupTypeCode;
    }


    @Column(name="FISCAL_DEGREE_CODE", nullable=false, length=3)
    public String getFiscalDegreeCode() {
        return this.fiscalDegreeCode;
    }
    
    public void setFiscalDegreeCode(String fiscalDegreeCode) {
        this.fiscalDegreeCode = fiscalDegreeCode;
    }


    @Column(name="JOB_CODE", nullable=false, length=5)
    public String getJobCode() {
        return this.jobCode;
    }
    
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }


    @Column(name="ORG_ID", nullable=false, length=5)
    public String getOrgId() {
        return this.orgId;
    }
    
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerHumanBalOrgId) ) return false;
		 PerHumanBalOrgId castOther = ( PerHumanBalOrgId ) other; 
         
		 return ( (this.getLocationCode()==castOther.getLocationCode()) || ( this.getLocationCode()!=null && castOther.getLocationCode()!=null && this.getLocationCode().equals(castOther.getLocationCode()) ) )
 && ( (this.getHumanBalId()==castOther.getHumanBalId()) || ( this.getHumanBalId()!=null && castOther.getHumanBalId()!=null && this.getHumanBalId().equals(castOther.getHumanBalId()) ) )
 && ( (this.getGroupTypeCode()==castOther.getGroupTypeCode()) || ( this.getGroupTypeCode()!=null && castOther.getGroupTypeCode()!=null && this.getGroupTypeCode().equals(castOther.getGroupTypeCode()) ) )
 && ( (this.getFiscalDegreeCode()==castOther.getFiscalDegreeCode()) || ( this.getFiscalDegreeCode()!=null && castOther.getFiscalDegreeCode()!=null && this.getFiscalDegreeCode().equals(castOther.getFiscalDegreeCode()) ) )
 && ( (this.getJobCode()==castOther.getJobCode()) || ( this.getJobCode()!=null && castOther.getJobCode()!=null && this.getJobCode().equals(castOther.getJobCode()) ) )
 && ( (this.getOrgId()==castOther.getOrgId()) || ( this.getOrgId()!=null && castOther.getOrgId()!=null && this.getOrgId().equals(castOther.getOrgId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocationCode() == null ? 0 : this.getLocationCode().hashCode() );
         result = 37 * result + ( getHumanBalId() == null ? 0 : this.getHumanBalId().hashCode() );
         result = 37 * result + ( getGroupTypeCode() == null ? 0 : this.getGroupTypeCode().hashCode() );
         result = 37 * result + ( getFiscalDegreeCode() == null ? 0 : this.getFiscalDegreeCode().hashCode() );
         result = 37 * result + ( getJobCode() == null ? 0 : this.getJobCode().hashCode() );
         result = 37 * result + ( getOrgId() == null ? 0 : this.getOrgId().hashCode() );
         return result;
   }   


}


