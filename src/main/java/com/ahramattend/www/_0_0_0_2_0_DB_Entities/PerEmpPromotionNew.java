package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerEmpPromotionNew generated by hbm2java
 */
@Entity
@Table(name="PER_EMP_PROMOTION_NEW"
    ,schema="SHAMS"
)
public class PerEmpPromotionNew  implements java.io.Serializable {


     private PerEmpPromotionNewId id;
     private PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNew;
     private PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew;
     private PerGroupTypeCode perGroupTypeCodeByGroupTypeCodeNew;
     private PerGroupTypeCode perGroupTypeCodeByGroupTypeCode;
     private PerJobCode perJobCodeByJobCodeNew;
     private PerJobCode perJobCodeByJobCode;
     private PerPromotionTransNew perPromotionTransNew;
     private PerEmploymentMasters perEmploymentMasters;
     private Date degreeDate;
     private Date degreePriorityDate;
     private Date jobDate;
     private Boolean empJobFlag;
     private BigDecimal basicSal;
     private BigDecimal sal;
     private Date degreeDateNew;
     private Date jobDateNew;
     private Boolean empJobFlagNew;
     private BigDecimal elawaVal;
     private BigDecimal basicSalAfter;
     private BigDecimal salAfter;
     private BigDecimal calcVal;
     private Date degreePriorityDateNew;

    public PerEmpPromotionNew() {
    }

	
    public PerEmpPromotionNew(PerEmpPromotionNewId id, PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNew, PerJobCode perJobCodeByJobCode, PerPromotionTransNew perPromotionTransNew, PerEmploymentMasters perEmploymentMasters) {
        this.id = id;
        this.perFiscalDegreeCodeNewByFiscalDegreeCodeNew = perFiscalDegreeCodeNewByFiscalDegreeCodeNew;
        this.perJobCodeByJobCode = perJobCodeByJobCode;
        this.perPromotionTransNew = perPromotionTransNew;
        this.perEmploymentMasters = perEmploymentMasters;
    }
    public PerEmpPromotionNew(PerEmpPromotionNewId id, PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNew, PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew, PerGroupTypeCode perGroupTypeCodeByGroupTypeCodeNew, PerGroupTypeCode perGroupTypeCodeByGroupTypeCode, PerJobCode perJobCodeByJobCodeNew, PerJobCode perJobCodeByJobCode, PerPromotionTransNew perPromotionTransNew, PerEmploymentMasters perEmploymentMasters, Date degreeDate, Date degreePriorityDate, Date jobDate, Boolean empJobFlag, BigDecimal basicSal, BigDecimal sal, Date degreeDateNew, Date jobDateNew, Boolean empJobFlagNew, BigDecimal elawaVal, BigDecimal basicSalAfter, BigDecimal salAfter, BigDecimal calcVal, Date degreePriorityDateNew) {
       this.id = id;
       this.perFiscalDegreeCodeNewByFiscalDegreeCodeNew = perFiscalDegreeCodeNewByFiscalDegreeCodeNew;
       this.perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew = perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew;
       this.perGroupTypeCodeByGroupTypeCodeNew = perGroupTypeCodeByGroupTypeCodeNew;
       this.perGroupTypeCodeByGroupTypeCode = perGroupTypeCodeByGroupTypeCode;
       this.perJobCodeByJobCodeNew = perJobCodeByJobCodeNew;
       this.perJobCodeByJobCode = perJobCodeByJobCode;
       this.perPromotionTransNew = perPromotionTransNew;
       this.perEmploymentMasters = perEmploymentMasters;
       this.degreeDate = degreeDate;
       this.degreePriorityDate = degreePriorityDate;
       this.jobDate = jobDate;
       this.empJobFlag = empJobFlag;
       this.basicSal = basicSal;
       this.sal = sal;
       this.degreeDateNew = degreeDateNew;
       this.jobDateNew = jobDateNew;
       this.empJobFlagNew = empJobFlagNew;
       this.elawaVal = elawaVal;
       this.basicSalAfter = basicSalAfter;
       this.salAfter = salAfter;
       this.calcVal = calcVal;
       this.degreePriorityDateNew = degreePriorityDateNew;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="promotionType", column=@Column(name="PROMOTION_TYPE", nullable=false, length=5) ), 
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="transId", column=@Column(name="TRANS_ID", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ) } )
    public PerEmpPromotionNewId getId() {
        return this.id;
    }
    
    public void setId(PerEmpPromotionNewId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FISCAL_DEGREE_CODE_NEW", nullable=false)
    public PerFiscalDegreeCodeNew getPerFiscalDegreeCodeNewByFiscalDegreeCodeNew() {
        return this.perFiscalDegreeCodeNewByFiscalDegreeCodeNew;
    }
    
    public void setPerFiscalDegreeCodeNewByFiscalDegreeCodeNew(PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNew) {
        this.perFiscalDegreeCodeNewByFiscalDegreeCodeNew = perFiscalDegreeCodeNewByFiscalDegreeCodeNew;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FISCAL_DEGREE_CODE_NEW_NEW")
    public PerFiscalDegreeCodeNew getPerFiscalDegreeCodeNewByFiscalDegreeCodeNewNew() {
        return this.perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew;
    }
    
    public void setPerFiscalDegreeCodeNewByFiscalDegreeCodeNewNew(PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew) {
        this.perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew = perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GROUP_TYPE_CODE_NEW")
    public PerGroupTypeCode getPerGroupTypeCodeByGroupTypeCodeNew() {
        return this.perGroupTypeCodeByGroupTypeCodeNew;
    }
    
    public void setPerGroupTypeCodeByGroupTypeCodeNew(PerGroupTypeCode perGroupTypeCodeByGroupTypeCodeNew) {
        this.perGroupTypeCodeByGroupTypeCodeNew = perGroupTypeCodeByGroupTypeCodeNew;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GROUP_TYPE_CODE")
    public PerGroupTypeCode getPerGroupTypeCodeByGroupTypeCode() {
        return this.perGroupTypeCodeByGroupTypeCode;
    }
    
    public void setPerGroupTypeCodeByGroupTypeCode(PerGroupTypeCode perGroupTypeCodeByGroupTypeCode) {
        this.perGroupTypeCodeByGroupTypeCode = perGroupTypeCodeByGroupTypeCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="JOB_CODE_NEW")
    public PerJobCode getPerJobCodeByJobCodeNew() {
        return this.perJobCodeByJobCodeNew;
    }
    
    public void setPerJobCodeByJobCodeNew(PerJobCode perJobCodeByJobCodeNew) {
        this.perJobCodeByJobCodeNew = perJobCodeByJobCodeNew;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="JOB_CODE", nullable=false)
    public PerJobCode getPerJobCodeByJobCode() {
        return this.perJobCodeByJobCode;
    }
    
    public void setPerJobCodeByJobCode(PerJobCode perJobCodeByJobCode) {
        this.perJobCodeByJobCode = perJobCodeByJobCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="PROMOTION_TYPE", referencedColumnName="PROMOTION_TYPE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="TRANS_ID", referencedColumnName="TRANS_ID", nullable=false, insertable=false, updatable=false) } )
    public PerPromotionTransNew getPerPromotionTransNew() {
        return this.perPromotionTransNew;
    }
    
    public void setPerPromotionTransNew(PerPromotionTransNew perPromotionTransNew) {
        this.perPromotionTransNew = perPromotionTransNew;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public PerEmploymentMasters getPerEmploymentMasters() {
        return this.perEmploymentMasters;
    }
    
    public void setPerEmploymentMasters(PerEmploymentMasters perEmploymentMasters) {
        this.perEmploymentMasters = perEmploymentMasters;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DEGREE_DATE", length=7)
    public Date getDegreeDate() {
        return this.degreeDate;
    }
    
    public void setDegreeDate(Date degreeDate) {
        this.degreeDate = degreeDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DEGREE_PRIORITY_DATE", length=7)
    public Date getDegreePriorityDate() {
        return this.degreePriorityDate;
    }
    
    public void setDegreePriorityDate(Date degreePriorityDate) {
        this.degreePriorityDate = degreePriorityDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="JOB_DATE", length=7)
    public Date getJobDate() {
        return this.jobDate;
    }
    
    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    
    @Column(name="EMP_JOB_FLAG", precision=1, scale=0)
    public Boolean getEmpJobFlag() {
        return this.empJobFlag;
    }
    
    public void setEmpJobFlag(Boolean empJobFlag) {
        this.empJobFlag = empJobFlag;
    }

    
    @Column(name="BASIC_SAL", precision=9)
    public BigDecimal getBasicSal() {
        return this.basicSal;
    }
    
    public void setBasicSal(BigDecimal basicSal) {
        this.basicSal = basicSal;
    }

    
    @Column(name="SAL", precision=9)
    public BigDecimal getSal() {
        return this.sal;
    }
    
    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DEGREE_DATE_NEW", length=7)
    public Date getDegreeDateNew() {
        return this.degreeDateNew;
    }
    
    public void setDegreeDateNew(Date degreeDateNew) {
        this.degreeDateNew = degreeDateNew;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="JOB_DATE_NEW", length=7)
    public Date getJobDateNew() {
        return this.jobDateNew;
    }
    
    public void setJobDateNew(Date jobDateNew) {
        this.jobDateNew = jobDateNew;
    }

    
    @Column(name="EMP_JOB_FLAG_NEW", precision=1, scale=0)
    public Boolean getEmpJobFlagNew() {
        return this.empJobFlagNew;
    }
    
    public void setEmpJobFlagNew(Boolean empJobFlagNew) {
        this.empJobFlagNew = empJobFlagNew;
    }

    
    @Column(name="ELAWA_VAL", precision=9)
    public BigDecimal getElawaVal() {
        return this.elawaVal;
    }
    
    public void setElawaVal(BigDecimal elawaVal) {
        this.elawaVal = elawaVal;
    }

    
    @Column(name="BASIC_SAL_AFTER", precision=9)
    public BigDecimal getBasicSalAfter() {
        return this.basicSalAfter;
    }
    
    public void setBasicSalAfter(BigDecimal basicSalAfter) {
        this.basicSalAfter = basicSalAfter;
    }

    
    @Column(name="SAL_AFTER", precision=9)
    public BigDecimal getSalAfter() {
        return this.salAfter;
    }
    
    public void setSalAfter(BigDecimal salAfter) {
        this.salAfter = salAfter;
    }

    
    @Column(name="CALC_VAL", precision=9)
    public BigDecimal getCalcVal() {
        return this.calcVal;
    }
    
    public void setCalcVal(BigDecimal calcVal) {
        this.calcVal = calcVal;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DEGREE_PRIORITY_DATE_NEW", length=7)
    public Date getDegreePriorityDateNew() {
        return this.degreePriorityDateNew;
    }
    
    public void setDegreePriorityDateNew(Date degreePriorityDateNew) {
        this.degreePriorityDateNew = degreePriorityDateNew;
    }




}

