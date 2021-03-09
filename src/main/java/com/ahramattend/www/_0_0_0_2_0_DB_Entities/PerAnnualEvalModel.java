package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerAnnualEvalModel generated by hbm2java
 */
@Entity
@Table(name="PER_ANNUAL_EVAL_MODEL"
    ,schema="SHAMS"
)
public class PerAnnualEvalModel  implements java.io.Serializable {


     private PerAnnualEvalModelId id;
     private PerAnnualEvalType perAnnualEvalType;
     private PerAnnualEvalYear perAnnualEvalYear;
     private PerOrganizationStructure perOrganizationStructure;
     private PerOrgunitCode perOrgunitCode;
     private BudProjectSub budProjectSub;
     private String empDirectBoss;
     private String commityNo;
     private Date evalDate;
     private String empBigBoss;
     private Set<PerAnnualEvalModelEmp> perAnnualEvalModelEmps = new HashSet<PerAnnualEvalModelEmp>(0);

    public PerAnnualEvalModel() {
    }

	
    public PerAnnualEvalModel(PerAnnualEvalModelId id, PerAnnualEvalType perAnnualEvalType, PerAnnualEvalYear perAnnualEvalYear, Date evalDate) {
        this.id = id;
        this.perAnnualEvalType = perAnnualEvalType;
        this.perAnnualEvalYear = perAnnualEvalYear;
        this.evalDate = evalDate;
    }
    public PerAnnualEvalModel(PerAnnualEvalModelId id, PerAnnualEvalType perAnnualEvalType, PerAnnualEvalYear perAnnualEvalYear, PerOrganizationStructure perOrganizationStructure, PerOrgunitCode perOrgunitCode, BudProjectSub budProjectSub, String empDirectBoss, String commityNo, Date evalDate, String empBigBoss, Set<PerAnnualEvalModelEmp> perAnnualEvalModelEmps) {
       this.id = id;
       this.perAnnualEvalType = perAnnualEvalType;
       this.perAnnualEvalYear = perAnnualEvalYear;
       this.perOrganizationStructure = perOrganizationStructure;
       this.perOrgunitCode = perOrgunitCode;
       this.budProjectSub = budProjectSub;
       this.empDirectBoss = empDirectBoss;
       this.commityNo = commityNo;
       this.evalDate = evalDate;
       this.empBigBoss = empBigBoss;
       this.perAnnualEvalModelEmps = perAnnualEvalModelEmps;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="annualId", column=@Column(name="ANNUAL_ID", nullable=false, length=5) ), 
        @AttributeOverride(name="serialNo", column=@Column(name="SERIAL_NO", nullable=false, length=5) ) } )
    public PerAnnualEvalModelId getId() {
        return this.id;
    }
    
    public void setId(PerAnnualEvalModelId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EVAL_TYPE_SERIAL", nullable=false)
    public PerAnnualEvalType getPerAnnualEvalType() {
        return this.perAnnualEvalType;
    }
    
    public void setPerAnnualEvalType(PerAnnualEvalType perAnnualEvalType) {
        this.perAnnualEvalType = perAnnualEvalType;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ANNUAL_ID", referencedColumnName="ANNUAL_ID", nullable=false, insertable=false, updatable=false) } )
    public PerAnnualEvalYear getPerAnnualEvalYear() {
        return this.perAnnualEvalYear;
    }
    
    public void setPerAnnualEvalYear(PerAnnualEvalYear perAnnualEvalYear) {
        this.perAnnualEvalYear = perAnnualEvalYear;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_ID")
    public PerOrganizationStructure getPerOrganizationStructure() {
        return this.perOrganizationStructure;
    }
    
    public void setPerOrganizationStructure(PerOrganizationStructure perOrganizationStructure) {
        this.perOrganizationStructure = perOrganizationStructure;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORGUNIT_CODE")
    public PerOrgunitCode getPerOrgunitCode() {
        return this.perOrgunitCode;
    }
    
    public void setPerOrgunitCode(PerOrgunitCode perOrgunitCode) {
        this.perOrgunitCode = perOrgunitCode;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="PROJECT_CODE", referencedColumnName="PROJECT_CODE"), 
        @JoinColumn(name="PROJECT_SUB_CODE", referencedColumnName="PROJECT_SUB_CODE") } )
    public BudProjectSub getBudProjectSub() {
        return this.budProjectSub;
    }
    
    public void setBudProjectSub(BudProjectSub budProjectSub) {
        this.budProjectSub = budProjectSub;
    }

    
    @Column(name="EMP_DIRECT_BOSS", length=10)
    public String getEmpDirectBoss() {
        return this.empDirectBoss;
    }
    
    public void setEmpDirectBoss(String empDirectBoss) {
        this.empDirectBoss = empDirectBoss;
    }

    
    @Column(name="COMMITY_NO", length=10)
    public String getCommityNo() {
        return this.commityNo;
    }
    
    public void setCommityNo(String commityNo) {
        this.commityNo = commityNo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="EVAL_DATE", nullable=false, length=7)
    public Date getEvalDate() {
        return this.evalDate;
    }
    
    public void setEvalDate(Date evalDate) {
        this.evalDate = evalDate;
    }

    
    @Column(name="EMP_BIG_BOSS", length=10)
    public String getEmpBigBoss() {
        return this.empBigBoss;
    }
    
    public void setEmpBigBoss(String empBigBoss) {
        this.empBigBoss = empBigBoss;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="perAnnualEvalModel")
    public Set<PerAnnualEvalModelEmp> getPerAnnualEvalModelEmps() {
        return this.perAnnualEvalModelEmps;
    }
    
    public void setPerAnnualEvalModelEmps(Set<PerAnnualEvalModelEmp> perAnnualEvalModelEmps) {
        this.perAnnualEvalModelEmps = perAnnualEvalModelEmps;
    }




}


