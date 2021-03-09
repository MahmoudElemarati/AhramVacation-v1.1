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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PayExecutionSpecificEmp generated by hbm2java
 */
@Entity
@Table(name="PAY_EXECUTION_SPECIFIC_EMP"
    ,schema="SHAMS"
)
public class PayExecutionSpecificEmp  implements java.io.Serializable {


     private PayExecutionSpecificEmpId id;
     private PayBankCode payBankCode;
     private PayEmployeeMaster payEmployeeMaster;
     private PayExecutionDate payExecutionDate;
     private PayFinancialGroupType payFinancialGroupType;
     private PaySarfCode paySarfCode;
     private PerEmploymentParameter perEmploymentParameter;
     private PerFiscalDegreeCode perFiscalDegreeCode;
     private PerQualCode perQualCode;
     private String locationCode;
     private String employeeNo;
     private String locCode;
     private Boolean deserveType;
     private Boolean statusType;
     private String maritalCode;
     private Boolean sexFlag;
     private String groupTypeCode;
     private String jobCode;
     private String orgunitCode;
     private String orgId;
     private Integer degreePriority;
     private Date degreePriorityDate;
     private Short ratioTime;
     private BigDecimal salaryValue;
     private BigDecimal basicSalaryValue;
     private String accountNo;
     private Date contractDate;
     private Date contractEnddate;
     private Date startDate;
     private Date endDate;
     private Short dayNo;
     private Boolean chkInsGov;
     private Boolean chkInsEmp;
     private Boolean chkStamp;
     private Boolean chkTax;
     private Boolean chkExec;
     private String generalCode;
     private Byte generalType;
     private Byte vacationDay;
     private BigDecimal absentDay;
     private BigDecimal punishDay;
     private BigDecimal workInjuryDay;
     private Integer injuryBalance;
     private Integer sickBalance;
     private BigDecimal injuryRate;
     private BigDecimal sickDay;
     private Date userInsDate;
     private Integer userId;
     private Date returnDate;
     private Boolean chkTaxFree;
     private Date sickFactDate;
     private Date absentFactDate;
     private Date punishFactDate;
     private Date holidayFactDate;
     private Date injuryFactDate;
     private Byte holidayDay;
     private Boolean chkPunish;
     private Integer punishMethodSeq;
     private Integer sickMethodSeq;
     private Integer absentMethodSeq;
     private Boolean chkRev;
     private String EFinEmp;
     private Integer userIdRev;
     private BigDecimal insMaxBasicEmp;
     private BigDecimal insMaxVarEmp;
     private Boolean chkStop;
     private Boolean chkFinEmp;
     private Short formRepSp;
     private Byte empOld;
     private String formDocNoReal;
     private Date formDocDate;
     private Short formFiscalYear;
     private BigDecimal val30;
     private BigDecimal val65;
     private BigDecimal val70;
     private Date revSendDate;
     private BigDecimal jobSalaryValue;
     private Integer costCode;
     private Byte factoryCode;
     private Boolean empLawType;

    public PayExecutionSpecificEmp() {
    }

	
    public PayExecutionSpecificEmp(PayExecutionSpecificEmpId id, PayEmployeeMaster payEmployeeMaster, PayExecutionDate payExecutionDate, String locationCode) {
        this.id = id;
        this.payEmployeeMaster = payEmployeeMaster;
        this.payExecutionDate = payExecutionDate;
        this.locationCode = locationCode;
    }
    public PayExecutionSpecificEmp(PayExecutionSpecificEmpId id, PayBankCode payBankCode, PayEmployeeMaster payEmployeeMaster, PayExecutionDate payExecutionDate, PayFinancialGroupType payFinancialGroupType, PaySarfCode paySarfCode, PerEmploymentParameter perEmploymentParameter, PerFiscalDegreeCode perFiscalDegreeCode, PerQualCode perQualCode, String locationCode, String employeeNo, String locCode, Boolean deserveType, Boolean statusType, String maritalCode, Boolean sexFlag, String groupTypeCode, String jobCode, String orgunitCode, String orgId, Integer degreePriority, Date degreePriorityDate, Short ratioTime, BigDecimal salaryValue, BigDecimal basicSalaryValue, String accountNo, Date contractDate, Date contractEnddate, Date startDate, Date endDate, Short dayNo, Boolean chkInsGov, Boolean chkInsEmp, Boolean chkStamp, Boolean chkTax, Boolean chkExec, String generalCode, Byte generalType, Byte vacationDay, BigDecimal absentDay, BigDecimal punishDay, BigDecimal workInjuryDay, Integer injuryBalance, Integer sickBalance, BigDecimal injuryRate, BigDecimal sickDay, Date userInsDate, Integer userId, Date returnDate, Boolean chkTaxFree, Date sickFactDate, Date absentFactDate, Date punishFactDate, Date holidayFactDate, Date injuryFactDate, Byte holidayDay, Boolean chkPunish, Integer punishMethodSeq, Integer sickMethodSeq, Integer absentMethodSeq, Boolean chkRev, String EFinEmp, Integer userIdRev, BigDecimal insMaxBasicEmp, BigDecimal insMaxVarEmp, Boolean chkStop, Boolean chkFinEmp, Short formRepSp, Byte empOld, String formDocNoReal, Date formDocDate, Short formFiscalYear, BigDecimal val30, BigDecimal val65, BigDecimal val70, Date revSendDate, BigDecimal jobSalaryValue, Integer costCode, Byte factoryCode, Boolean empLawType) {
       this.id = id;
       this.payBankCode = payBankCode;
       this.payEmployeeMaster = payEmployeeMaster;
       this.payExecutionDate = payExecutionDate;
       this.payFinancialGroupType = payFinancialGroupType;
       this.paySarfCode = paySarfCode;
       this.perEmploymentParameter = perEmploymentParameter;
       this.perFiscalDegreeCode = perFiscalDegreeCode;
       this.perQualCode = perQualCode;
       this.locationCode = locationCode;
       this.employeeNo = employeeNo;
       this.locCode = locCode;
       this.deserveType = deserveType;
       this.statusType = statusType;
       this.maritalCode = maritalCode;
       this.sexFlag = sexFlag;
       this.groupTypeCode = groupTypeCode;
       this.jobCode = jobCode;
       this.orgunitCode = orgunitCode;
       this.orgId = orgId;
       this.degreePriority = degreePriority;
       this.degreePriorityDate = degreePriorityDate;
       this.ratioTime = ratioTime;
       this.salaryValue = salaryValue;
       this.basicSalaryValue = basicSalaryValue;
       this.accountNo = accountNo;
       this.contractDate = contractDate;
       this.contractEnddate = contractEnddate;
       this.startDate = startDate;
       this.endDate = endDate;
       this.dayNo = dayNo;
       this.chkInsGov = chkInsGov;
       this.chkInsEmp = chkInsEmp;
       this.chkStamp = chkStamp;
       this.chkTax = chkTax;
       this.chkExec = chkExec;
       this.generalCode = generalCode;
       this.generalType = generalType;
       this.vacationDay = vacationDay;
       this.absentDay = absentDay;
       this.punishDay = punishDay;
       this.workInjuryDay = workInjuryDay;
       this.injuryBalance = injuryBalance;
       this.sickBalance = sickBalance;
       this.injuryRate = injuryRate;
       this.sickDay = sickDay;
       this.userInsDate = userInsDate;
       this.userId = userId;
       this.returnDate = returnDate;
       this.chkTaxFree = chkTaxFree;
       this.sickFactDate = sickFactDate;
       this.absentFactDate = absentFactDate;
       this.punishFactDate = punishFactDate;
       this.holidayFactDate = holidayFactDate;
       this.injuryFactDate = injuryFactDate;
       this.holidayDay = holidayDay;
       this.chkPunish = chkPunish;
       this.punishMethodSeq = punishMethodSeq;
       this.sickMethodSeq = sickMethodSeq;
       this.absentMethodSeq = absentMethodSeq;
       this.chkRev = chkRev;
       this.EFinEmp = EFinEmp;
       this.userIdRev = userIdRev;
       this.insMaxBasicEmp = insMaxBasicEmp;
       this.insMaxVarEmp = insMaxVarEmp;
       this.chkStop = chkStop;
       this.chkFinEmp = chkFinEmp;
       this.formRepSp = formRepSp;
       this.empOld = empOld;
       this.formDocNoReal = formDocNoReal;
       this.formDocDate = formDocDate;
       this.formFiscalYear = formFiscalYear;
       this.val30 = val30;
       this.val65 = val65;
       this.val70 = val70;
       this.revSendDate = revSendDate;
       this.jobSalaryValue = jobSalaryValue;
       this.costCode = costCode;
       this.factoryCode = factoryCode;
       this.empLawType = empLawType;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="methodType", column=@Column(name="METHOD_TYPE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="execMm", column=@Column(name="EXEC_MM", nullable=false, length=7) ), 
        @AttributeOverride(name="methodSeq", column=@Column(name="METHOD_SEQ", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ) } )
    public PayExecutionSpecificEmpId getId() {
        return this.id;
    }
    
    public void setId(PayExecutionSpecificEmpId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="BANK_CODE")
    public PayBankCode getPayBankCode() {
        return this.payBankCode;
    }
    
    public void setPayBankCode(PayBankCode payBankCode) {
        this.payBankCode = payBankCode;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public PayEmployeeMaster getPayEmployeeMaster() {
        return this.payEmployeeMaster;
    }
    
    public void setPayEmployeeMaster(PayEmployeeMaster payEmployeeMaster) {
        this.payEmployeeMaster = payEmployeeMaster;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="METHOD_TYPE", referencedColumnName="METHOD_TYPE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="EXEC_MM", referencedColumnName="EXEC_MM", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="METHOD_SEQ", referencedColumnName="METHOD_SEQ", nullable=false, insertable=false, updatable=false) } )
    public PayExecutionDate getPayExecutionDate() {
        return this.payExecutionDate;
    }
    
    public void setPayExecutionDate(PayExecutionDate payExecutionDate) {
        this.payExecutionDate = payExecutionDate;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="STATUS_CODE", referencedColumnName="STATUS_CODE"), 
        @JoinColumn(name="STATUS_GROUP", referencedColumnName="STATUS_GROUP") } )
    public PayFinancialGroupType getPayFinancialGroupType() {
        return this.payFinancialGroupType;
    }
    
    public void setPayFinancialGroupType(PayFinancialGroupType payFinancialGroupType) {
        this.payFinancialGroupType = payFinancialGroupType;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SARF_CODE")
    public PaySarfCode getPaySarfCode() {
        return this.paySarfCode;
    }
    
    public void setPaySarfCode(PaySarfCode paySarfCode) {
        this.paySarfCode = paySarfCode;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EMPLOYMENT_SOURCE_CODE")
    public PerEmploymentParameter getPerEmploymentParameter() {
        return this.perEmploymentParameter;
    }
    
    public void setPerEmploymentParameter(PerEmploymentParameter perEmploymentParameter) {
        this.perEmploymentParameter = perEmploymentParameter;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FISCAL_DEGREE_CODE")
    public PerFiscalDegreeCode getPerFiscalDegreeCode() {
        return this.perFiscalDegreeCode;
    }
    
    public void setPerFiscalDegreeCode(PerFiscalDegreeCode perFiscalDegreeCode) {
        this.perFiscalDegreeCode = perFiscalDegreeCode;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="QUAL_CODE")
    public PerQualCode getPerQualCode() {
        return this.perQualCode;
    }
    
    public void setPerQualCode(PerQualCode perQualCode) {
        this.perQualCode = perQualCode;
    }

    
    @Column(name="LOCATION_CODE", nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    
    @Column(name="EMPLOYEE_NO", length=10)
    public String getEmployeeNo() {
        return this.employeeNo;
    }
    
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    
    @Column(name="LOC_CODE", length=3)
    public String getLocCode() {
        return this.locCode;
    }
    
    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }

    
    @Column(name="DESERVE_TYPE", precision=1, scale=0)
    public Boolean getDeserveType() {
        return this.deserveType;
    }
    
    public void setDeserveType(Boolean deserveType) {
        this.deserveType = deserveType;
    }

    
    @Column(name="STATUS_TYPE", precision=1, scale=0)
    public Boolean getStatusType() {
        return this.statusType;
    }
    
    public void setStatusType(Boolean statusType) {
        this.statusType = statusType;
    }

    
    @Column(name="MARITAL_CODE", length=2)
    public String getMaritalCode() {
        return this.maritalCode;
    }
    
    public void setMaritalCode(String maritalCode) {
        this.maritalCode = maritalCode;
    }

    
    @Column(name="SEX_FLAG", precision=1, scale=0)
    public Boolean getSexFlag() {
        return this.sexFlag;
    }
    
    public void setSexFlag(Boolean sexFlag) {
        this.sexFlag = sexFlag;
    }

    
    @Column(name="GROUP_TYPE_CODE", length=3)
    public String getGroupTypeCode() {
        return this.groupTypeCode;
    }
    
    public void setGroupTypeCode(String groupTypeCode) {
        this.groupTypeCode = groupTypeCode;
    }

    
    @Column(name="JOB_CODE", length=5)
    public String getJobCode() {
        return this.jobCode;
    }
    
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    
    @Column(name="ORGUNIT_CODE", length=3)
    public String getOrgunitCode() {
        return this.orgunitCode;
    }
    
    public void setOrgunitCode(String orgunitCode) {
        this.orgunitCode = orgunitCode;
    }

    
    @Column(name="ORG_ID", length=5)
    public String getOrgId() {
        return this.orgId;
    }
    
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    
    @Column(name="DEGREE_PRIORITY", precision=5, scale=0)
    public Integer getDegreePriority() {
        return this.degreePriority;
    }
    
    public void setDegreePriority(Integer degreePriority) {
        this.degreePriority = degreePriority;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DEGREE_PRIORITY_DATE", length=7)
    public Date getDegreePriorityDate() {
        return this.degreePriorityDate;
    }
    
    public void setDegreePriorityDate(Date degreePriorityDate) {
        this.degreePriorityDate = degreePriorityDate;
    }

    
    @Column(name="RATIO_TIME", precision=3, scale=0)
    public Short getRatioTime() {
        return this.ratioTime;
    }
    
    public void setRatioTime(Short ratioTime) {
        this.ratioTime = ratioTime;
    }

    
    @Column(name="SALARY_VALUE", precision=9)
    public BigDecimal getSalaryValue() {
        return this.salaryValue;
    }
    
    public void setSalaryValue(BigDecimal salaryValue) {
        this.salaryValue = salaryValue;
    }

    
    @Column(name="BASIC_SALARY_VALUE", precision=9)
    public BigDecimal getBasicSalaryValue() {
        return this.basicSalaryValue;
    }
    
    public void setBasicSalaryValue(BigDecimal basicSalaryValue) {
        this.basicSalaryValue = basicSalaryValue;
    }

    
    @Column(name="ACCOUNT_NO", length=40)
    public String getAccountNo() {
        return this.accountNo;
    }
    
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CONTRACT_DATE", length=7)
    public Date getContractDate() {
        return this.contractDate;
    }
    
    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CONTRACT_ENDDATE", length=7)
    public Date getContractEnddate() {
        return this.contractEnddate;
    }
    
    public void setContractEnddate(Date contractEnddate) {
        this.contractEnddate = contractEnddate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE", length=7)
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="END_DATE", length=7)
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    @Column(name="DAY_NO", precision=3, scale=0)
    public Short getDayNo() {
        return this.dayNo;
    }
    
    public void setDayNo(Short dayNo) {
        this.dayNo = dayNo;
    }

    
    @Column(name="CHK_INS_GOV", precision=1, scale=0)
    public Boolean getChkInsGov() {
        return this.chkInsGov;
    }
    
    public void setChkInsGov(Boolean chkInsGov) {
        this.chkInsGov = chkInsGov;
    }

    
    @Column(name="CHK_INS_EMP", precision=1, scale=0)
    public Boolean getChkInsEmp() {
        return this.chkInsEmp;
    }
    
    public void setChkInsEmp(Boolean chkInsEmp) {
        this.chkInsEmp = chkInsEmp;
    }

    
    @Column(name="CHK_STAMP", precision=1, scale=0)
    public Boolean getChkStamp() {
        return this.chkStamp;
    }
    
    public void setChkStamp(Boolean chkStamp) {
        this.chkStamp = chkStamp;
    }

    
    @Column(name="CHK_TAX", precision=1, scale=0)
    public Boolean getChkTax() {
        return this.chkTax;
    }
    
    public void setChkTax(Boolean chkTax) {
        this.chkTax = chkTax;
    }

    
    @Column(name="CHK_EXEC", precision=1, scale=0)
    public Boolean getChkExec() {
        return this.chkExec;
    }
    
    public void setChkExec(Boolean chkExec) {
        this.chkExec = chkExec;
    }

    
    @Column(name="GENERAL_CODE", length=3)
    public String getGeneralCode() {
        return this.generalCode;
    }
    
    public void setGeneralCode(String generalCode) {
        this.generalCode = generalCode;
    }

    
    @Column(name="GENERAL_TYPE", precision=2, scale=0)
    public Byte getGeneralType() {
        return this.generalType;
    }
    
    public void setGeneralType(Byte generalType) {
        this.generalType = generalType;
    }

    
    @Column(name="VACATION_DAY", precision=2, scale=0)
    public Byte getVacationDay() {
        return this.vacationDay;
    }
    
    public void setVacationDay(Byte vacationDay) {
        this.vacationDay = vacationDay;
    }

    
    @Column(name="ABSENT_DAY", precision=5)
    public BigDecimal getAbsentDay() {
        return this.absentDay;
    }
    
    public void setAbsentDay(BigDecimal absentDay) {
        this.absentDay = absentDay;
    }

    
    @Column(name="PUNISH_DAY", precision=5)
    public BigDecimal getPunishDay() {
        return this.punishDay;
    }
    
    public void setPunishDay(BigDecimal punishDay) {
        this.punishDay = punishDay;
    }

    
    @Column(name="WORK_INJURY_DAY", precision=5)
    public BigDecimal getWorkInjuryDay() {
        return this.workInjuryDay;
    }
    
    public void setWorkInjuryDay(BigDecimal workInjuryDay) {
        this.workInjuryDay = workInjuryDay;
    }

    
    @Column(name="INJURY_BALANCE", precision=5, scale=0)
    public Integer getInjuryBalance() {
        return this.injuryBalance;
    }
    
    public void setInjuryBalance(Integer injuryBalance) {
        this.injuryBalance = injuryBalance;
    }

    
    @Column(name="SICK_BALANCE", precision=5, scale=0)
    public Integer getSickBalance() {
        return this.sickBalance;
    }
    
    public void setSickBalance(Integer sickBalance) {
        this.sickBalance = sickBalance;
    }

    
    @Column(name="INJURY_RATE", precision=5)
    public BigDecimal getInjuryRate() {
        return this.injuryRate;
    }
    
    public void setInjuryRate(BigDecimal injuryRate) {
        this.injuryRate = injuryRate;
    }

    
    @Column(name="SICK_DAY", precision=5)
    public BigDecimal getSickDay() {
        return this.sickDay;
    }
    
    public void setSickDay(BigDecimal sickDay) {
        this.sickDay = sickDay;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="USER_INS_DATE", length=7)
    public Date getUserInsDate() {
        return this.userInsDate;
    }
    
    public void setUserInsDate(Date userInsDate) {
        this.userInsDate = userInsDate;
    }

    
    @Column(name="USER_ID", precision=9, scale=0)
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RETURN_DATE", length=7)
    public Date getReturnDate() {
        return this.returnDate;
    }
    
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    
    @Column(name="CHK_TAX_FREE", precision=1, scale=0)
    public Boolean getChkTaxFree() {
        return this.chkTaxFree;
    }
    
    public void setChkTaxFree(Boolean chkTaxFree) {
        this.chkTaxFree = chkTaxFree;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="SICK_FACT_DATE", length=7)
    public Date getSickFactDate() {
        return this.sickFactDate;
    }
    
    public void setSickFactDate(Date sickFactDate) {
        this.sickFactDate = sickFactDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ABSENT_FACT_DATE", length=7)
    public Date getAbsentFactDate() {
        return this.absentFactDate;
    }
    
    public void setAbsentFactDate(Date absentFactDate) {
        this.absentFactDate = absentFactDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PUNISH_FACT_DATE", length=7)
    public Date getPunishFactDate() {
        return this.punishFactDate;
    }
    
    public void setPunishFactDate(Date punishFactDate) {
        this.punishFactDate = punishFactDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="HOLIDAY_FACT_DATE", length=7)
    public Date getHolidayFactDate() {
        return this.holidayFactDate;
    }
    
    public void setHolidayFactDate(Date holidayFactDate) {
        this.holidayFactDate = holidayFactDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="INJURY_FACT_DATE", length=7)
    public Date getInjuryFactDate() {
        return this.injuryFactDate;
    }
    
    public void setInjuryFactDate(Date injuryFactDate) {
        this.injuryFactDate = injuryFactDate;
    }

    
    @Column(name="HOLIDAY_DAY", precision=2, scale=0)
    public Byte getHolidayDay() {
        return this.holidayDay;
    }
    
    public void setHolidayDay(Byte holidayDay) {
        this.holidayDay = holidayDay;
    }

    
    @Column(name="CHK_PUNISH", precision=1, scale=0)
    public Boolean getChkPunish() {
        return this.chkPunish;
    }
    
    public void setChkPunish(Boolean chkPunish) {
        this.chkPunish = chkPunish;
    }

    
    @Column(name="PUNISH_METHOD_SEQ", precision=5, scale=0)
    public Integer getPunishMethodSeq() {
        return this.punishMethodSeq;
    }
    
    public void setPunishMethodSeq(Integer punishMethodSeq) {
        this.punishMethodSeq = punishMethodSeq;
    }

    
    @Column(name="SICK_METHOD_SEQ", precision=5, scale=0)
    public Integer getSickMethodSeq() {
        return this.sickMethodSeq;
    }
    
    public void setSickMethodSeq(Integer sickMethodSeq) {
        this.sickMethodSeq = sickMethodSeq;
    }

    
    @Column(name="ABSENT_METHOD_SEQ", precision=5, scale=0)
    public Integer getAbsentMethodSeq() {
        return this.absentMethodSeq;
    }
    
    public void setAbsentMethodSeq(Integer absentMethodSeq) {
        this.absentMethodSeq = absentMethodSeq;
    }

    
    @Column(name="CHK_REV", precision=1, scale=0)
    public Boolean getChkRev() {
        return this.chkRev;
    }
    
    public void setChkRev(Boolean chkRev) {
        this.chkRev = chkRev;
    }

    
    @Column(name="E_FIN_EMP", length=10)
    public String getEFinEmp() {
        return this.EFinEmp;
    }
    
    public void setEFinEmp(String EFinEmp) {
        this.EFinEmp = EFinEmp;
    }

    
    @Column(name="USER_ID_REV", precision=9, scale=0)
    public Integer getUserIdRev() {
        return this.userIdRev;
    }
    
    public void setUserIdRev(Integer userIdRev) {
        this.userIdRev = userIdRev;
    }

    
    @Column(name="INS_MAX_BASIC_EMP", precision=11)
    public BigDecimal getInsMaxBasicEmp() {
        return this.insMaxBasicEmp;
    }
    
    public void setInsMaxBasicEmp(BigDecimal insMaxBasicEmp) {
        this.insMaxBasicEmp = insMaxBasicEmp;
    }

    
    @Column(name="INS_MAX_VAR_EMP", precision=11)
    public BigDecimal getInsMaxVarEmp() {
        return this.insMaxVarEmp;
    }
    
    public void setInsMaxVarEmp(BigDecimal insMaxVarEmp) {
        this.insMaxVarEmp = insMaxVarEmp;
    }

    
    @Column(name="CHK_STOP", precision=1, scale=0)
    public Boolean getChkStop() {
        return this.chkStop;
    }
    
    public void setChkStop(Boolean chkStop) {
        this.chkStop = chkStop;
    }

    
    @Column(name="CHK_FIN_EMP", precision=1, scale=0)
    public Boolean getChkFinEmp() {
        return this.chkFinEmp;
    }
    
    public void setChkFinEmp(Boolean chkFinEmp) {
        this.chkFinEmp = chkFinEmp;
    }

    
    @Column(name="FORM_REP_SP", precision=4, scale=0)
    public Short getFormRepSp() {
        return this.formRepSp;
    }
    
    public void setFormRepSp(Short formRepSp) {
        this.formRepSp = formRepSp;
    }

    
    @Column(name="EMP_OLD", precision=2, scale=0)
    public Byte getEmpOld() {
        return this.empOld;
    }
    
    public void setEmpOld(Byte empOld) {
        this.empOld = empOld;
    }

    
    @Column(name="FORM_DOC_NO_REAL", length=10)
    public String getFormDocNoReal() {
        return this.formDocNoReal;
    }
    
    public void setFormDocNoReal(String formDocNoReal) {
        this.formDocNoReal = formDocNoReal;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FORM_DOC_DATE", length=7)
    public Date getFormDocDate() {
        return this.formDocDate;
    }
    
    public void setFormDocDate(Date formDocDate) {
        this.formDocDate = formDocDate;
    }

    
    @Column(name="FORM_FISCAL_YEAR", precision=4, scale=0)
    public Short getFormFiscalYear() {
        return this.formFiscalYear;
    }
    
    public void setFormFiscalYear(Short formFiscalYear) {
        this.formFiscalYear = formFiscalYear;
    }

    
    @Column(name="VAL_30", precision=11)
    public BigDecimal getVal30() {
        return this.val30;
    }
    
    public void setVal30(BigDecimal val30) {
        this.val30 = val30;
    }

    
    @Column(name="VAL_65", precision=11)
    public BigDecimal getVal65() {
        return this.val65;
    }
    
    public void setVal65(BigDecimal val65) {
        this.val65 = val65;
    }

    
    @Column(name="VAL_70", precision=11)
    public BigDecimal getVal70() {
        return this.val70;
    }
    
    public void setVal70(BigDecimal val70) {
        this.val70 = val70;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="REV_SEND_DATE", length=7)
    public Date getRevSendDate() {
        return this.revSendDate;
    }
    
    public void setRevSendDate(Date revSendDate) {
        this.revSendDate = revSendDate;
    }

    
    @Column(name="JOB_SALARY_VALUE", precision=9)
    public BigDecimal getJobSalaryValue() {
        return this.jobSalaryValue;
    }
    
    public void setJobSalaryValue(BigDecimal jobSalaryValue) {
        this.jobSalaryValue = jobSalaryValue;
    }

    
    @Column(name="COST_CODE", precision=6, scale=0)
    public Integer getCostCode() {
        return this.costCode;
    }
    
    public void setCostCode(Integer costCode) {
        this.costCode = costCode;
    }

    
    @Column(name="FACTORY_CODE", precision=2, scale=0)
    public Byte getFactoryCode() {
        return this.factoryCode;
    }
    
    public void setFactoryCode(Byte factoryCode) {
        this.factoryCode = factoryCode;
    }

    
    @Column(name="EMP_LAW_TYPE", precision=1, scale=0)
    public Boolean getEmpLawType() {
        return this.empLawType;
    }
    
    public void setEmpLawType(Boolean empLawType) {
        this.empLawType = empLawType;
    }




}


