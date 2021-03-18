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
 * PerAnnualEvalEmp generated by hbm2java
 */
@Entity
@Table(name="PER_ANNUAL_EVAL_EMP"
    ,schema="SHAMS"
)
public class PerAnnualEvalEmp  implements java.io.Serializable {


     private PerAnnualEvalEmpId id;
     private PerGroupDegreeNew perGroupDegreeNew;
     private PerAnnualEval perAnnualEval;
     private PerEmploymentMasters perEmploymentMasters;
     private PerEvalPercentage perEvalPercentageByGradeCodeBigboss;
     private PerEvalPercentage perEvalPercentageByGradeCode;
     private PerEvalPercentage perEvalPercentageByGradeCodeFinal;
     private PerEvalPercentage perEvalPercentageByGradeCodeComm;
     private PerGroupDegree perGroupDegree;
     private PerJobCode perJobCode;
     private Set<PerAnnualEvalEmpDetail> perAnnualEvalEmpDetails = new HashSet<PerAnnualEvalEmpDetail>(0);

    public PerAnnualEvalEmp() {
    }

	
    public PerAnnualEvalEmp(PerAnnualEvalEmpId id, PerAnnualEval perAnnualEval, PerEmploymentMasters perEmploymentMasters) {
        this.id = id;
        this.perAnnualEval = perAnnualEval;
        this.perEmploymentMasters = perEmploymentMasters;
    }
    public PerAnnualEvalEmp(PerAnnualEvalEmpId id, PerGroupDegreeNew perGroupDegreeNew, PerAnnualEval perAnnualEval, PerEmploymentMasters perEmploymentMasters, PerEvalPercentage perEvalPercentageByGradeCodeBigboss, PerEvalPercentage perEvalPercentageByGradeCode, PerEvalPercentage perEvalPercentageByGradeCodeFinal, PerEvalPercentage perEvalPercentageByGradeCodeComm, PerGroupDegree perGroupDegree, PerJobCode perJobCode, Set<PerAnnualEvalEmpDetail> perAnnualEvalEmpDetails) {
       this.id = id;
       this.perGroupDegreeNew = perGroupDegreeNew;
       this.perAnnualEval = perAnnualEval;
       this.perEmploymentMasters = perEmploymentMasters;
       this.perEvalPercentageByGradeCodeBigboss = perEvalPercentageByGradeCodeBigboss;
       this.perEvalPercentageByGradeCode = perEvalPercentageByGradeCode;
       this.perEvalPercentageByGradeCodeFinal = perEvalPercentageByGradeCodeFinal;
       this.perEvalPercentageByGradeCodeComm = perEvalPercentageByGradeCodeComm;
       this.perGroupDegree = perGroupDegree;
       this.perJobCode = perJobCode;
       this.perAnnualEvalEmpDetails = perAnnualEvalEmpDetails;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="serialNo", column=@Column(name="SERIAL_NO", nullable=false, length=5) ), 
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="annualId", column=@Column(name="ANNUAL_ID", nullable=false, length=5) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ) } )
    public PerAnnualEvalEmpId getId() {
        return this.id;
    }
    
    public void setId(PerAnnualEvalEmpId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="FISCAL_DEGREE_CODE_NEW", referencedColumnName="FISCAL_DEGREE_CODE_NEW"), 
        @JoinColumn(name="GROUP_TYPE_CODE_DESCRIBED_BY", referencedColumnName="GROUP_TYPE_CODE") } )
    public PerGroupDegreeNew getPerGroupDegreeNew() {
        return this.perGroupDegreeNew;
    }
    
    public void setPerGroupDegreeNew(PerGroupDegreeNew perGroupDegreeNew) {
        this.perGroupDegreeNew = perGroupDegreeNew;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="ANNUAL_ID", referencedColumnName="ANNUAL_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="SERIAL_NO", referencedColumnName="SERIAL_NO", nullable=false, insertable=false, updatable=false) } )
    public PerAnnualEval getPerAnnualEval() {
        return this.perAnnualEval;
    }
    
    public void setPerAnnualEval(PerAnnualEval perAnnualEval) {
        this.perAnnualEval = perAnnualEval;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public PerEmploymentMasters getPerEmploymentMasters() {
        return this.perEmploymentMasters;
    }
    
    public void setPerEmploymentMasters(PerEmploymentMasters perEmploymentMasters) {
        this.perEmploymentMasters = perEmploymentMasters;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GRADE_CODE_BIGBOSS")
    public PerEvalPercentage getPerEvalPercentageByGradeCodeBigboss() {
        return this.perEvalPercentageByGradeCodeBigboss;
    }
    
    public void setPerEvalPercentageByGradeCodeBigboss(PerEvalPercentage perEvalPercentageByGradeCodeBigboss) {
        this.perEvalPercentageByGradeCodeBigboss = perEvalPercentageByGradeCodeBigboss;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GRADE_CODE")
    public PerEvalPercentage getPerEvalPercentageByGradeCode() {
        return this.perEvalPercentageByGradeCode;
    }
    
    public void setPerEvalPercentageByGradeCode(PerEvalPercentage perEvalPercentageByGradeCode) {
        this.perEvalPercentageByGradeCode = perEvalPercentageByGradeCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GRADE_CODE_FINAL")
    public PerEvalPercentage getPerEvalPercentageByGradeCodeFinal() {
        return this.perEvalPercentageByGradeCodeFinal;
    }
    
    public void setPerEvalPercentageByGradeCodeFinal(PerEvalPercentage perEvalPercentageByGradeCodeFinal) {
        this.perEvalPercentageByGradeCodeFinal = perEvalPercentageByGradeCodeFinal;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GRADE_CODE_COMM")
    public PerEvalPercentage getPerEvalPercentageByGradeCodeComm() {
        return this.perEvalPercentageByGradeCodeComm;
    }
    
    public void setPerEvalPercentageByGradeCodeComm(PerEvalPercentage perEvalPercentageByGradeCodeComm) {
        this.perEvalPercentageByGradeCodeComm = perEvalPercentageByGradeCodeComm;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="GROUP_TYPE_CODE", referencedColumnName="GROUP_TYPE_CODE"), 
        @JoinColumn(name="FISCAL_DEGREE_CODE", referencedColumnName="FISCAL_DEGREE_CODE") } )
    public PerGroupDegree getPerGroupDegree() {
        return this.perGroupDegree;
    }
    
    public void setPerGroupDegree(PerGroupDegree perGroupDegree) {
        this.perGroupDegree = perGroupDegree;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="JOB_CODE")
    public PerJobCode getPerJobCode() {
        return this.perJobCode;
    }
    
    public void setPerJobCode(PerJobCode perJobCode) {
        this.perJobCode = perJobCode;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perAnnualEvalEmp")
    public Set<PerAnnualEvalEmpDetail> getPerAnnualEvalEmpDetails() {
        return this.perAnnualEvalEmpDetails;
    }
    
    public void setPerAnnualEvalEmpDetails(Set<PerAnnualEvalEmpDetail> perAnnualEvalEmpDetails) {
        this.perAnnualEvalEmpDetails = perAnnualEvalEmpDetails;
    }




}


