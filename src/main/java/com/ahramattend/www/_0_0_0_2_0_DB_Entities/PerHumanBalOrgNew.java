package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PerHumanBalOrgNew generated by hbm2java
 */
@Entity
@Table(name="PER_HUMAN_BAL_ORG_NEW"
    ,schema="SHAMS"
)
public class PerHumanBalOrgNew  implements java.io.Serializable {


     private PerHumanBalOrgNewId id;
     private PerOrganizationStructure perOrganizationStructure;
     private PerOrgunitCode perOrgunitCode;
     private PerHumanBalJobNew perHumanBalJobNew;
     private int jobFund;
     private int jobExist;
     private int jobEmpty;
     private int jobNewRequired;
     private int jobTotalBalance;
     private int jobAdded;
     private int jobTerminations;
     private Integer jobPlaned;

    public PerHumanBalOrgNew() {
    }

	
    public PerHumanBalOrgNew(PerHumanBalOrgNewId id, PerOrganizationStructure perOrganizationStructure, PerOrgunitCode perOrgunitCode, PerHumanBalJobNew perHumanBalJobNew, int jobFund, int jobExist, int jobEmpty, int jobNewRequired, int jobTotalBalance, int jobAdded, int jobTerminations) {
        this.id = id;
        this.perOrganizationStructure = perOrganizationStructure;
        this.perOrgunitCode = perOrgunitCode;
        this.perHumanBalJobNew = perHumanBalJobNew;
        this.jobFund = jobFund;
        this.jobExist = jobExist;
        this.jobEmpty = jobEmpty;
        this.jobNewRequired = jobNewRequired;
        this.jobTotalBalance = jobTotalBalance;
        this.jobAdded = jobAdded;
        this.jobTerminations = jobTerminations;
    }
    public PerHumanBalOrgNew(PerHumanBalOrgNewId id, PerOrganizationStructure perOrganizationStructure, PerOrgunitCode perOrgunitCode, PerHumanBalJobNew perHumanBalJobNew, int jobFund, int jobExist, int jobEmpty, int jobNewRequired, int jobTotalBalance, int jobAdded, int jobTerminations, Integer jobPlaned) {
       this.id = id;
       this.perOrganizationStructure = perOrganizationStructure;
       this.perOrgunitCode = perOrgunitCode;
       this.perHumanBalJobNew = perHumanBalJobNew;
       this.jobFund = jobFund;
       this.jobExist = jobExist;
       this.jobEmpty = jobEmpty;
       this.jobNewRequired = jobNewRequired;
       this.jobTotalBalance = jobTotalBalance;
       this.jobAdded = jobAdded;
       this.jobTerminations = jobTerminations;
       this.jobPlaned = jobPlaned;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="humanBalId", column=@Column(name="HUMAN_BAL_ID", nullable=false, length=5) ), 
        @AttributeOverride(name="groupTypeCode", column=@Column(name="GROUP_TYPE_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="jobCode", column=@Column(name="JOB_CODE", nullable=false, length=5) ), 
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="fiscalDegreeCodeNew", column=@Column(name="FISCAL_DEGREE_CODE_NEW", nullable=false, length=3) ), 
        @AttributeOverride(name="orgId", column=@Column(name="ORG_ID", nullable=false, length=5) ) } )
    public PerHumanBalOrgNewId getId() {
        return this.id;
    }
    
    public void setId(PerHumanBalOrgNewId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ORG_ID", nullable=false, insertable=false, updatable=false)
    public PerOrganizationStructure getPerOrganizationStructure() {
        return this.perOrganizationStructure;
    }
    
    public void setPerOrganizationStructure(PerOrganizationStructure perOrganizationStructure) {
        this.perOrganizationStructure = perOrganizationStructure;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ORGUNIT_CODE", nullable=false)
    public PerOrgunitCode getPerOrgunitCode() {
        return this.perOrgunitCode;
    }
    
    public void setPerOrgunitCode(PerOrgunitCode perOrgunitCode) {
        this.perOrgunitCode = perOrgunitCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="HUMAN_BAL_ID", referencedColumnName="HUMAN_BAL_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="GROUP_TYPE_CODE", referencedColumnName="GROUP_TYPE_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="FISCAL_DEGREE_CODE_NEW", referencedColumnName="FISCAL_DEGREE_CODE_NEW", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="JOB_CODE", referencedColumnName="JOB_CODE", nullable=false, insertable=false, updatable=false) } )
    public PerHumanBalJobNew getPerHumanBalJobNew() {
        return this.perHumanBalJobNew;
    }
    
    public void setPerHumanBalJobNew(PerHumanBalJobNew perHumanBalJobNew) {
        this.perHumanBalJobNew = perHumanBalJobNew;
    }

    
    @Column(name="JOB_FUND", nullable=false, precision=5, scale=0)
    public int getJobFund() {
        return this.jobFund;
    }
    
    public void setJobFund(int jobFund) {
        this.jobFund = jobFund;
    }

    
    @Column(name="JOB_EXIST", nullable=false, precision=5, scale=0)
    public int getJobExist() {
        return this.jobExist;
    }
    
    public void setJobExist(int jobExist) {
        this.jobExist = jobExist;
    }

    
    @Column(name="JOB_EMPTY", nullable=false, precision=5, scale=0)
    public int getJobEmpty() {
        return this.jobEmpty;
    }
    
    public void setJobEmpty(int jobEmpty) {
        this.jobEmpty = jobEmpty;
    }

    
    @Column(name="JOB_NEW_REQUIRED", nullable=false, precision=5, scale=0)
    public int getJobNewRequired() {
        return this.jobNewRequired;
    }
    
    public void setJobNewRequired(int jobNewRequired) {
        this.jobNewRequired = jobNewRequired;
    }

    
    @Column(name="JOB_TOTAL_BALANCE", nullable=false, precision=5, scale=0)
    public int getJobTotalBalance() {
        return this.jobTotalBalance;
    }
    
    public void setJobTotalBalance(int jobTotalBalance) {
        this.jobTotalBalance = jobTotalBalance;
    }

    
    @Column(name="JOB_ADDED", nullable=false, precision=5, scale=0)
    public int getJobAdded() {
        return this.jobAdded;
    }
    
    public void setJobAdded(int jobAdded) {
        this.jobAdded = jobAdded;
    }

    
    @Column(name="JOB_TERMINATIONS", nullable=false, precision=5, scale=0)
    public int getJobTerminations() {
        return this.jobTerminations;
    }
    
    public void setJobTerminations(int jobTerminations) {
        this.jobTerminations = jobTerminations;
    }

    
    @Column(name="JOB_PLANED", precision=5, scale=0)
    public Integer getJobPlaned() {
        return this.jobPlaned;
    }
    
    public void setJobPlaned(Integer jobPlaned) {
        this.jobPlaned = jobPlaned;
    }




}


