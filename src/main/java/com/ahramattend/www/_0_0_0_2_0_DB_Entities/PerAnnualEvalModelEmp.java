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
 * PerAnnualEvalModelEmp generated by hbm2java
 */
@Entity
@Table(name="PER_ANNUAL_EVAL_MODEL_EMP"
    ,schema="SHAMS"
)
public class PerAnnualEvalModelEmp  implements java.io.Serializable {


     private PerAnnualEvalModelEmpId id;
     private PerAnnualEvalModel perAnnualEvalModel;
     private PerEmploymentMasters perEmploymentMasters;
     private PerEvalPercentage perEvalPercentageByGradeCodeDirectboss;
     private PerEvalPercentage perEvalPercentageByGradeCodeFinal;
     private PerEvalPercentage perEvalPercentageByGradeCode;
     private PerEvalPercentage perEvalPercentageByGradeCodeComm;
     private PerGroupDegree perGroupDegree;
     private PerJobCode perJobCode;
     private Set<PerAnnualEvalModelEmpDtl> perAnnualEvalModelEmpDtls = new HashSet<PerAnnualEvalModelEmpDtl>(0);

    public PerAnnualEvalModelEmp() {
    }

	
    public PerAnnualEvalModelEmp(PerAnnualEvalModelEmpId id, PerAnnualEvalModel perAnnualEvalModel, PerEmploymentMasters perEmploymentMasters) {
        this.id = id;
        this.perAnnualEvalModel = perAnnualEvalModel;
        this.perEmploymentMasters = perEmploymentMasters;
    }
    public PerAnnualEvalModelEmp(PerAnnualEvalModelEmpId id, PerAnnualEvalModel perAnnualEvalModel, PerEmploymentMasters perEmploymentMasters, PerEvalPercentage perEvalPercentageByGradeCodeDirectboss, PerEvalPercentage perEvalPercentageByGradeCodeFinal, PerEvalPercentage perEvalPercentageByGradeCode, PerEvalPercentage perEvalPercentageByGradeCodeComm, PerGroupDegree perGroupDegree, PerJobCode perJobCode, Set<PerAnnualEvalModelEmpDtl> perAnnualEvalModelEmpDtls) {
       this.id = id;
       this.perAnnualEvalModel = perAnnualEvalModel;
       this.perEmploymentMasters = perEmploymentMasters;
       this.perEvalPercentageByGradeCodeDirectboss = perEvalPercentageByGradeCodeDirectboss;
       this.perEvalPercentageByGradeCodeFinal = perEvalPercentageByGradeCodeFinal;
       this.perEvalPercentageByGradeCode = perEvalPercentageByGradeCode;
       this.perEvalPercentageByGradeCodeComm = perEvalPercentageByGradeCodeComm;
       this.perGroupDegree = perGroupDegree;
       this.perJobCode = perJobCode;
       this.perAnnualEvalModelEmpDtls = perAnnualEvalModelEmpDtls;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="annualId", column=@Column(name="ANNUAL_ID", nullable=false, length=5) ), 
        @AttributeOverride(name="serialNo", column=@Column(name="SERIAL_NO", nullable=false, length=5) ), 
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ) } )
    public PerAnnualEvalModelEmpId getId() {
        return this.id;
    }
    
    public void setId(PerAnnualEvalModelEmpId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ANNUAL_ID", referencedColumnName="ANNUAL_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="SERIAL_NO", referencedColumnName="SERIAL_NO", nullable=false, insertable=false, updatable=false) } )
    public PerAnnualEvalModel getPerAnnualEvalModel() {
        return this.perAnnualEvalModel;
    }
    
    public void setPerAnnualEvalModel(PerAnnualEvalModel perAnnualEvalModel) {
        this.perAnnualEvalModel = perAnnualEvalModel;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public PerEmploymentMasters getPerEmploymentMasters() {
        return this.perEmploymentMasters;
    }
    
    public void setPerEmploymentMasters(PerEmploymentMasters perEmploymentMasters) {
        this.perEmploymentMasters = perEmploymentMasters;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="GRADE_CODE_DIRECTBOSS")
    public PerEvalPercentage getPerEvalPercentageByGradeCodeDirectboss() {
        return this.perEvalPercentageByGradeCodeDirectboss;
    }
    
    public void setPerEvalPercentageByGradeCodeDirectboss(PerEvalPercentage perEvalPercentageByGradeCodeDirectboss) {
        this.perEvalPercentageByGradeCodeDirectboss = perEvalPercentageByGradeCodeDirectboss;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="GRADE_CODE_FINAL")
    public PerEvalPercentage getPerEvalPercentageByGradeCodeFinal() {
        return this.perEvalPercentageByGradeCodeFinal;
    }
    
    public void setPerEvalPercentageByGradeCodeFinal(PerEvalPercentage perEvalPercentageByGradeCodeFinal) {
        this.perEvalPercentageByGradeCodeFinal = perEvalPercentageByGradeCodeFinal;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="GRADE_CODE")
    public PerEvalPercentage getPerEvalPercentageByGradeCode() {
        return this.perEvalPercentageByGradeCode;
    }
    
    public void setPerEvalPercentageByGradeCode(PerEvalPercentage perEvalPercentageByGradeCode) {
        this.perEvalPercentageByGradeCode = perEvalPercentageByGradeCode;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="GRADE_CODE_COMM")
    public PerEvalPercentage getPerEvalPercentageByGradeCodeComm() {
        return this.perEvalPercentageByGradeCodeComm;
    }
    
    public void setPerEvalPercentageByGradeCodeComm(PerEvalPercentage perEvalPercentageByGradeCodeComm) {
        this.perEvalPercentageByGradeCodeComm = perEvalPercentageByGradeCodeComm;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="GROUP_TYPE_CODE", referencedColumnName="GROUP_TYPE_CODE"), 
        @JoinColumn(name="FISCAL_DEGREE_CODE", referencedColumnName="FISCAL_DEGREE_CODE") } )
    public PerGroupDegree getPerGroupDegree() {
        return this.perGroupDegree;
    }
    
    public void setPerGroupDegree(PerGroupDegree perGroupDegree) {
        this.perGroupDegree = perGroupDegree;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="JOB_CODE")
    public PerJobCode getPerJobCode() {
        return this.perJobCode;
    }
    
    public void setPerJobCode(PerJobCode perJobCode) {
        this.perJobCode = perJobCode;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="perAnnualEvalModelEmp")
    public Set<PerAnnualEvalModelEmpDtl> getPerAnnualEvalModelEmpDtls() {
        return this.perAnnualEvalModelEmpDtls;
    }
    
    public void setPerAnnualEvalModelEmpDtls(Set<PerAnnualEvalModelEmpDtl> perAnnualEvalModelEmpDtls) {
        this.perAnnualEvalModelEmpDtls = perAnnualEvalModelEmpDtls;
    }




}


