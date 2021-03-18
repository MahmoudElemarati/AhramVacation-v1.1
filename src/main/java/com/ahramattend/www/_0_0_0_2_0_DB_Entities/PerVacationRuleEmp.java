package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerVacationRuleEmp generated by hbm2java
 */
@Entity
@Table(name="PER_VACATION_RULE_EMP"
    ,schema="SHAMS"
)
public class PerVacationRuleEmp  implements java.io.Serializable {


     private PerVacationRuleEmpId id;
     private PerVacationCode perVacationCode;
     private PerEmploymentParameter perEmploymentParameter;
     private Boolean vacTestPeriod;
     private String remarks;
     private Boolean sexFlag;
     private Boolean vacAgeFlag;
     private Integer balForEmp;
     private Short maxNumber;
     private BigDecimal femaleRatio;
     private Short periodNotAllowed;
     private Boolean balNeedDecision;
     private Short vacDaysConstant;
     private Short maxPeriod;
     private Short vacMaxDaysContinue;
     private Boolean medVacStartFlag;
     private Date medVacStartDate;
     private Short medVacMonPeriod;
     private Boolean medVacDoc;
     private Byte totDayPMon;
     private String vacCodRasid;
     private Integer balFirstYear;
     private Integer balForFirst10yr;
     private Integer balAfter10yr;
     private Integer balAgeGreater50;

    public PerVacationRuleEmp() {
    }

	
    public PerVacationRuleEmp(PerVacationRuleEmpId id, PerVacationCode perVacationCode, PerEmploymentParameter perEmploymentParameter) {
        this.id = id;
        this.perVacationCode = perVacationCode;
        this.perEmploymentParameter = perEmploymentParameter;
    }
    public PerVacationRuleEmp(PerVacationRuleEmpId id, PerVacationCode perVacationCode, PerEmploymentParameter perEmploymentParameter, Boolean vacTestPeriod, String remarks, Boolean sexFlag, Boolean vacAgeFlag, Integer balForEmp, Short maxNumber, BigDecimal femaleRatio, Short periodNotAllowed, Boolean balNeedDecision, Short vacDaysConstant, Short maxPeriod, Short vacMaxDaysContinue, Boolean medVacStartFlag, Date medVacStartDate, Short medVacMonPeriod, Boolean medVacDoc, Byte totDayPMon, String vacCodRasid, Integer balFirstYear, Integer balForFirst10yr, Integer balAfter10yr, Integer balAgeGreater50) {
       this.id = id;
       this.perVacationCode = perVacationCode;
       this.perEmploymentParameter = perEmploymentParameter;
       this.vacTestPeriod = vacTestPeriod;
       this.remarks = remarks;
       this.sexFlag = sexFlag;
       this.vacAgeFlag = vacAgeFlag;
       this.balForEmp = balForEmp;
       this.maxNumber = maxNumber;
       this.femaleRatio = femaleRatio;
       this.periodNotAllowed = periodNotAllowed;
       this.balNeedDecision = balNeedDecision;
       this.vacDaysConstant = vacDaysConstant;
       this.maxPeriod = maxPeriod;
       this.vacMaxDaysContinue = vacMaxDaysContinue;
       this.medVacStartFlag = medVacStartFlag;
       this.medVacStartDate = medVacStartDate;
       this.medVacMonPeriod = medVacMonPeriod;
       this.medVacDoc = medVacDoc;
       this.totDayPMon = totDayPMon;
       this.vacCodRasid = vacCodRasid;
       this.balFirstYear = balFirstYear;
       this.balForFirst10yr = balForFirst10yr;
       this.balAfter10yr = balAfter10yr;
       this.balAgeGreater50 = balAgeGreater50;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="vacationCode", column=@Column(name="VACATION_CODE", nullable=false, length=2) ), 
        @AttributeOverride(name="employmentSourceCode", column=@Column(name="EMPLOYMENT_SOURCE_CODE", nullable=false, length=5) ) } )
    public PerVacationRuleEmpId getId() {
        return this.id;
    }
    
    public void setId(PerVacationRuleEmpId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VACATION_CODE", nullable=false, insertable=false, updatable=false)
    public PerVacationCode getPerVacationCode() {
        return this.perVacationCode;
    }
    
    public void setPerVacationCode(PerVacationCode perVacationCode) {
        this.perVacationCode = perVacationCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYMENT_SOURCE_CODE", nullable=false, insertable=false, updatable=false)
    public PerEmploymentParameter getPerEmploymentParameter() {
        return this.perEmploymentParameter;
    }
    
    public void setPerEmploymentParameter(PerEmploymentParameter perEmploymentParameter) {
        this.perEmploymentParameter = perEmploymentParameter;
    }

    
    @Column(name="VAC_TEST_PERIOD", precision=1, scale=0)
    public Boolean getVacTestPeriod() {
        return this.vacTestPeriod;
    }
    
    public void setVacTestPeriod(Boolean vacTestPeriod) {
        this.vacTestPeriod = vacTestPeriod;
    }

    
    @Column(name="REMARKS", length=100)
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    
    @Column(name="SEX_FLAG", precision=1, scale=0)
    public Boolean getSexFlag() {
        return this.sexFlag;
    }
    
    public void setSexFlag(Boolean sexFlag) {
        this.sexFlag = sexFlag;
    }

    
    @Column(name="VAC_AGE_FLAG", precision=1, scale=0)
    public Boolean getVacAgeFlag() {
        return this.vacAgeFlag;
    }
    
    public void setVacAgeFlag(Boolean vacAgeFlag) {
        this.vacAgeFlag = vacAgeFlag;
    }

    
    @Column(name="BAL_FOR_EMP", precision=5, scale=0)
    public Integer getBalForEmp() {
        return this.balForEmp;
    }
    
    public void setBalForEmp(Integer balForEmp) {
        this.balForEmp = balForEmp;
    }

    
    @Column(name="MAX_NUMBER", precision=3, scale=0)
    public Short getMaxNumber() {
        return this.maxNumber;
    }
    
    public void setMaxNumber(Short maxNumber) {
        this.maxNumber = maxNumber;
    }

    
    @Column(name="FEMALE_RATIO", precision=5)
    public BigDecimal getFemaleRatio() {
        return this.femaleRatio;
    }
    
    public void setFemaleRatio(BigDecimal femaleRatio) {
        this.femaleRatio = femaleRatio;
    }

    
    @Column(name="PERIOD_NOT_ALLOWED", precision=3, scale=0)
    public Short getPeriodNotAllowed() {
        return this.periodNotAllowed;
    }
    
    public void setPeriodNotAllowed(Short periodNotAllowed) {
        this.periodNotAllowed = periodNotAllowed;
    }

    
    @Column(name="BAL_NEED_DECISION", precision=1, scale=0)
    public Boolean getBalNeedDecision() {
        return this.balNeedDecision;
    }
    
    public void setBalNeedDecision(Boolean balNeedDecision) {
        this.balNeedDecision = balNeedDecision;
    }

    
    @Column(name="VAC_DAYS_CONSTANT", precision=3, scale=0)
    public Short getVacDaysConstant() {
        return this.vacDaysConstant;
    }
    
    public void setVacDaysConstant(Short vacDaysConstant) {
        this.vacDaysConstant = vacDaysConstant;
    }

    
    @Column(name="MAX_PERIOD", precision=3, scale=0)
    public Short getMaxPeriod() {
        return this.maxPeriod;
    }
    
    public void setMaxPeriod(Short maxPeriod) {
        this.maxPeriod = maxPeriod;
    }

    
    @Column(name="VAC_MAX_DAYS_CONTINUE", precision=3, scale=0)
    public Short getVacMaxDaysContinue() {
        return this.vacMaxDaysContinue;
    }
    
    public void setVacMaxDaysContinue(Short vacMaxDaysContinue) {
        this.vacMaxDaysContinue = vacMaxDaysContinue;
    }

    
    @Column(name="MED_VAC_START_FLAG", precision=1, scale=0)
    public Boolean getMedVacStartFlag() {
        return this.medVacStartFlag;
    }
    
    public void setMedVacStartFlag(Boolean medVacStartFlag) {
        this.medVacStartFlag = medVacStartFlag;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="MED_VAC_START_DATE", length=7)
    public Date getMedVacStartDate() {
        return this.medVacStartDate;
    }
    
    public void setMedVacStartDate(Date medVacStartDate) {
        this.medVacStartDate = medVacStartDate;
    }

    
    @Column(name="MED_VAC_MON_PERIOD", precision=3, scale=0)
    public Short getMedVacMonPeriod() {
        return this.medVacMonPeriod;
    }
    
    public void setMedVacMonPeriod(Short medVacMonPeriod) {
        this.medVacMonPeriod = medVacMonPeriod;
    }

    
    @Column(name="MED_VAC_DOC", precision=1, scale=0)
    public Boolean getMedVacDoc() {
        return this.medVacDoc;
    }
    
    public void setMedVacDoc(Boolean medVacDoc) {
        this.medVacDoc = medVacDoc;
    }

    
    @Column(name="TOT_DAY_P_MON", precision=2, scale=0)
    public Byte getTotDayPMon() {
        return this.totDayPMon;
    }
    
    public void setTotDayPMon(Byte totDayPMon) {
        this.totDayPMon = totDayPMon;
    }

    
    @Column(name="VAC_COD_RASID", length=2)
    public String getVacCodRasid() {
        return this.vacCodRasid;
    }
    
    public void setVacCodRasid(String vacCodRasid) {
        this.vacCodRasid = vacCodRasid;
    }

    
    @Column(name="BAL_FIRST_YEAR", precision=5, scale=0)
    public Integer getBalFirstYear() {
        return this.balFirstYear;
    }
    
    public void setBalFirstYear(Integer balFirstYear) {
        this.balFirstYear = balFirstYear;
    }

    
    @Column(name="BAL_FOR_FIRST_10YR", precision=5, scale=0)
    public Integer getBalForFirst10yr() {
        return this.balForFirst10yr;
    }
    
    public void setBalForFirst10yr(Integer balForFirst10yr) {
        this.balForFirst10yr = balForFirst10yr;
    }

    
    @Column(name="BAL_AFTER_10YR", precision=5, scale=0)
    public Integer getBalAfter10yr() {
        return this.balAfter10yr;
    }
    
    public void setBalAfter10yr(Integer balAfter10yr) {
        this.balAfter10yr = balAfter10yr;
    }

    
    @Column(name="BAL_AGE_GREATER_50", precision=5, scale=0)
    public Integer getBalAgeGreater50() {
        return this.balAgeGreater50;
    }
    
    public void setBalAgeGreater50(Integer balAgeGreater50) {
        this.balAgeGreater50 = balAgeGreater50;
    }




}


