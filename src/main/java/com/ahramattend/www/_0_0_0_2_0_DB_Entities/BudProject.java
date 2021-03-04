package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BudProject generated by hbm2java
 */
@Entity
@Table(name="BUD_PROJECT"
    ,schema="SHAMS"
)
public class BudProject  implements java.io.Serializable {


     private String projectCode;
     private String projectName;
     private String filterProjectName;
     private Date projectStartDate;
     private BigDecimal projectPeriod;
     private String remarks;
     private String recordCreationUser;
     private Date recordCreationDate;
     private String lastUpdateUser;
     private Date lastUpdateDate;
     private String lastUpdateTransaction;
     private String planningCode;
     private String parentProjectCode;
     private Boolean mainProj;
     private Set<BudProjectSub> budProjectSubs = new HashSet<BudProjectSub>(0);

    public BudProject() {
    }

	
    public BudProject(String projectCode) {
        this.projectCode = projectCode;
    }
    public BudProject(String projectCode, String projectName, String filterProjectName, Date projectStartDate, BigDecimal projectPeriod, String remarks, String recordCreationUser, Date recordCreationDate, String lastUpdateUser, Date lastUpdateDate, String lastUpdateTransaction, String planningCode, String parentProjectCode, Boolean mainProj, Set<BudProjectSub> budProjectSubs) {
       this.projectCode = projectCode;
       this.projectName = projectName;
       this.filterProjectName = filterProjectName;
       this.projectStartDate = projectStartDate;
       this.projectPeriod = projectPeriod;
       this.remarks = remarks;
       this.recordCreationUser = recordCreationUser;
       this.recordCreationDate = recordCreationDate;
       this.lastUpdateUser = lastUpdateUser;
       this.lastUpdateDate = lastUpdateDate;
       this.lastUpdateTransaction = lastUpdateTransaction;
       this.planningCode = planningCode;
       this.parentProjectCode = parentProjectCode;
       this.mainProj = mainProj;
       this.budProjectSubs = budProjectSubs;
    }
   
     @Id 

    
    @Column(name="PROJECT_CODE", unique=true, nullable=false, length=10)
    public String getProjectCode() {
        return this.projectCode;
    }
    
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    
    @Column(name="PROJECT_NAME", length=150)
    public String getProjectName() {
        return this.projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    
    @Column(name="FILTER_PROJECT_NAME", length=150)
    public String getFilterProjectName() {
        return this.filterProjectName;
    }
    
    public void setFilterProjectName(String filterProjectName) {
        this.filterProjectName = filterProjectName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PROJECT_START_DATE", length=7)
    public Date getProjectStartDate() {
        return this.projectStartDate;
    }
    
    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    
    @Column(name="PROJECT_PERIOD", precision=5)
    public BigDecimal getProjectPeriod() {
        return this.projectPeriod;
    }
    
    public void setProjectPeriod(BigDecimal projectPeriod) {
        this.projectPeriod = projectPeriod;
    }

    
    @Column(name="REMARKS", length=100)
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    
    @Column(name="RECORD_CREATION_USER", length=10)
    public String getRecordCreationUser() {
        return this.recordCreationUser;
    }
    
    public void setRecordCreationUser(String recordCreationUser) {
        this.recordCreationUser = recordCreationUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_CREATION_DATE", length=7)
    public Date getRecordCreationDate() {
        return this.recordCreationDate;
    }
    
    public void setRecordCreationDate(Date recordCreationDate) {
        this.recordCreationDate = recordCreationDate;
    }

    
    @Column(name="LAST_UPDATE_USER", length=10)
    public String getLastUpdateUser() {
        return this.lastUpdateUser;
    }
    
    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LAST_UPDATE_DATE", length=7)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }
    
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    
    @Column(name="LAST_UPDATE_TRANSACTION", length=1)
    public String getLastUpdateTransaction() {
        return this.lastUpdateTransaction;
    }
    
    public void setLastUpdateTransaction(String lastUpdateTransaction) {
        this.lastUpdateTransaction = lastUpdateTransaction;
    }

    
    @Column(name="PLANNING_CODE", length=15)
    public String getPlanningCode() {
        return this.planningCode;
    }
    
    public void setPlanningCode(String planningCode) {
        this.planningCode = planningCode;
    }

    
    @Column(name="PARENT_PROJECT_CODE", length=10)
    public String getParentProjectCode() {
        return this.parentProjectCode;
    }
    
    public void setParentProjectCode(String parentProjectCode) {
        this.parentProjectCode = parentProjectCode;
    }

    
    @Column(name="MAIN_PROJ", precision=1, scale=0)
    public Boolean getMainProj() {
        return this.mainProj;
    }
    
    public void setMainProj(Boolean mainProj) {
        this.mainProj = mainProj;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budProject")
    public Set<BudProjectSub> getBudProjectSubs() {
        return this.budProjectSubs;
    }
    
    public void setBudProjectSubs(Set<BudProjectSub> budProjectSubs) {
        this.budProjectSubs = budProjectSubs;
    }




}


