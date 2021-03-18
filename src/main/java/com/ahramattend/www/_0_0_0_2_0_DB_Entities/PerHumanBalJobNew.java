package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PerHumanBalJobNew generated by hbm2java
 */
@Entity
@Table(name="PER_HUMAN_BAL_JOB_NEW"
    ,schema="SHAMS"
)
public class PerHumanBalJobNew  implements java.io.Serializable {


     private PerHumanBalJobNewId id;
     private PerGroupDegreeNew perGroupDegreeNew;
     private PerHumanBalYear perHumanBalYear;
     private PerJobCode perJobCode;
     private int jobTotalBalance;
     private int jobAdded;
     private int jobEmpty;
     private int jobNewRequired;
     private int jobTerminations;
     private int jobExist;
     private String humanNotes;
     private int jobFund;
     private Integer jobPlaned;
     private Set<PerHumanBalOrgNew> perHumanBalOrgNews = new HashSet<PerHumanBalOrgNew>(0);

    public PerHumanBalJobNew() {
    }

	
    public PerHumanBalJobNew(PerHumanBalJobNewId id, PerGroupDegreeNew perGroupDegreeNew, PerHumanBalYear perHumanBalYear, PerJobCode perJobCode, int jobTotalBalance, int jobAdded, int jobEmpty, int jobNewRequired, int jobTerminations, int jobExist, int jobFund) {
        this.id = id;
        this.perGroupDegreeNew = perGroupDegreeNew;
        this.perHumanBalYear = perHumanBalYear;
        this.perJobCode = perJobCode;
        this.jobTotalBalance = jobTotalBalance;
        this.jobAdded = jobAdded;
        this.jobEmpty = jobEmpty;
        this.jobNewRequired = jobNewRequired;
        this.jobTerminations = jobTerminations;
        this.jobExist = jobExist;
        this.jobFund = jobFund;
    }
    public PerHumanBalJobNew(PerHumanBalJobNewId id, PerGroupDegreeNew perGroupDegreeNew, PerHumanBalYear perHumanBalYear, PerJobCode perJobCode, int jobTotalBalance, int jobAdded, int jobEmpty, int jobNewRequired, int jobTerminations, int jobExist, String humanNotes, int jobFund, Integer jobPlaned, Set<PerHumanBalOrgNew> perHumanBalOrgNews) {
       this.id = id;
       this.perGroupDegreeNew = perGroupDegreeNew;
       this.perHumanBalYear = perHumanBalYear;
       this.perJobCode = perJobCode;
       this.jobTotalBalance = jobTotalBalance;
       this.jobAdded = jobAdded;
       this.jobEmpty = jobEmpty;
       this.jobNewRequired = jobNewRequired;
       this.jobTerminations = jobTerminations;
       this.jobExist = jobExist;
       this.humanNotes = humanNotes;
       this.jobFund = jobFund;
       this.jobPlaned = jobPlaned;
       this.perHumanBalOrgNews = perHumanBalOrgNews;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="humanBalId", column=@Column(name="HUMAN_BAL_ID", nullable=false, length=5) ), 
        @AttributeOverride(name="groupTypeCode", column=@Column(name="GROUP_TYPE_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="fiscalDegreeCodeNew", column=@Column(name="FISCAL_DEGREE_CODE_NEW", nullable=false, length=3) ), 
        @AttributeOverride(name="jobCode", column=@Column(name="JOB_CODE", nullable=false, length=5) ) } )
    public PerHumanBalJobNewId getId() {
        return this.id;
    }
    
    public void setId(PerHumanBalJobNewId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="FISCAL_DEGREE_CODE_NEW", referencedColumnName="FISCAL_DEGREE_CODE_NEW", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="GROUP_TYPE_CODE", referencedColumnName="GROUP_TYPE_CODE", nullable=false, insertable=false, updatable=false) } )
    public PerGroupDegreeNew getPerGroupDegreeNew() {
        return this.perGroupDegreeNew;
    }
    
    public void setPerGroupDegreeNew(PerGroupDegreeNew perGroupDegreeNew) {
        this.perGroupDegreeNew = perGroupDegreeNew;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="HUMAN_BAL_ID", referencedColumnName="HUMAN_BAL_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false) } )
    public PerHumanBalYear getPerHumanBalYear() {
        return this.perHumanBalYear;
    }
    
    public void setPerHumanBalYear(PerHumanBalYear perHumanBalYear) {
        this.perHumanBalYear = perHumanBalYear;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="JOB_CODE", nullable=false, insertable=false, updatable=false)
    public PerJobCode getPerJobCode() {
        return this.perJobCode;
    }
    
    public void setPerJobCode(PerJobCode perJobCode) {
        this.perJobCode = perJobCode;
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

    
    @Column(name="JOB_TERMINATIONS", nullable=false, precision=5, scale=0)
    public int getJobTerminations() {
        return this.jobTerminations;
    }
    
    public void setJobTerminations(int jobTerminations) {
        this.jobTerminations = jobTerminations;
    }

    
    @Column(name="JOB_EXIST", nullable=false, precision=5, scale=0)
    public int getJobExist() {
        return this.jobExist;
    }
    
    public void setJobExist(int jobExist) {
        this.jobExist = jobExist;
    }

    
    @Column(name="HUMAN_NOTES", length=100)
    public String getHumanNotes() {
        return this.humanNotes;
    }
    
    public void setHumanNotes(String humanNotes) {
        this.humanNotes = humanNotes;
    }

    
    @Column(name="JOB_FUND", nullable=false, precision=5, scale=0)
    public int getJobFund() {
        return this.jobFund;
    }
    
    public void setJobFund(int jobFund) {
        this.jobFund = jobFund;
    }

    
    @Column(name="JOB_PLANED", precision=5, scale=0)
    public Integer getJobPlaned() {
        return this.jobPlaned;
    }
    
    public void setJobPlaned(Integer jobPlaned) {
        this.jobPlaned = jobPlaned;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perHumanBalJobNew")
    public Set<PerHumanBalOrgNew> getPerHumanBalOrgNews() {
        return this.perHumanBalOrgNews;
    }
    
    public void setPerHumanBalOrgNews(Set<PerHumanBalOrgNew> perHumanBalOrgNews) {
        this.perHumanBalOrgNews = perHumanBalOrgNews;
    }




}


