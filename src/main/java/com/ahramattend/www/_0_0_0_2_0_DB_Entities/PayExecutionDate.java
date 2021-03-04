package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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
 * PayExecutionDate generated by hbm2java
 */
@Entity
@Table(name="PAY_EXECUTION_DATE"
    ,schema="SHAMS"
)
public class PayExecutionDate  implements java.io.Serializable {


     private PayExecutionDateId id;
     private PayExecutionOpen payExecutionOpen;
     private PayMethodType payMethodType;
     private Date startDate;
     private Date endDate;
     private Short dayNo;
     private String rmrk;
     private Boolean chkLock;
     private Byte methodTypePrv;
     private Date execMmPrv;
     private Boolean chkSalary;
     private Boolean absentStatus;
     private Boolean punishStatus;
     private Boolean sickStatus;
     private Boolean injuryStatus;
     private Boolean holidayStatus;
     private Byte dayNoParameter;
     private Date insLawDate;
     private Date stampLawDate;
     private Date taxLawDate;
     private Date taxEndDate;
     private Date taxStartDate;
     private Date insEndDate;
     private Date insStartDate;
     private Byte openDd;
     private Integer methodSeqPrv;
     private Integer methodOrder;
     private BigDecimal insMaxBasicLaw;
     private BigDecimal insMaxVarLaw;
     private Set<PayExecutionSpecificEmp> payExecutionSpecificEmps = new HashSet<PayExecutionSpecificEmp>(0);

    public PayExecutionDate() {
    }

	
    public PayExecutionDate(PayExecutionDateId id, PayMethodType payMethodType) {
        this.id = id;
        this.payMethodType = payMethodType;
    }
    public PayExecutionDate(PayExecutionDateId id, PayExecutionOpen payExecutionOpen, PayMethodType payMethodType, Date startDate, Date endDate, Short dayNo, String rmrk, Boolean chkLock, Byte methodTypePrv, Date execMmPrv, Boolean chkSalary, Boolean absentStatus, Boolean punishStatus, Boolean sickStatus, Boolean injuryStatus, Boolean holidayStatus, Byte dayNoParameter, Date insLawDate, Date stampLawDate, Date taxLawDate, Date taxEndDate, Date taxStartDate, Date insEndDate, Date insStartDate, Byte openDd, Integer methodSeqPrv, Integer methodOrder, BigDecimal insMaxBasicLaw, BigDecimal insMaxVarLaw, Set<PayExecutionSpecificEmp> payExecutionSpecificEmps) {
       this.id = id;
       this.payExecutionOpen = payExecutionOpen;
       this.payMethodType = payMethodType;
       this.startDate = startDate;
       this.endDate = endDate;
       this.dayNo = dayNo;
       this.rmrk = rmrk;
       this.chkLock = chkLock;
       this.methodTypePrv = methodTypePrv;
       this.execMmPrv = execMmPrv;
       this.chkSalary = chkSalary;
       this.absentStatus = absentStatus;
       this.punishStatus = punishStatus;
       this.sickStatus = sickStatus;
       this.injuryStatus = injuryStatus;
       this.holidayStatus = holidayStatus;
       this.dayNoParameter = dayNoParameter;
       this.insLawDate = insLawDate;
       this.stampLawDate = stampLawDate;
       this.taxLawDate = taxLawDate;
       this.taxEndDate = taxEndDate;
       this.taxStartDate = taxStartDate;
       this.insEndDate = insEndDate;
       this.insStartDate = insStartDate;
       this.openDd = openDd;
       this.methodSeqPrv = methodSeqPrv;
       this.methodOrder = methodOrder;
       this.insMaxBasicLaw = insMaxBasicLaw;
       this.insMaxVarLaw = insMaxVarLaw;
       this.payExecutionSpecificEmps = payExecutionSpecificEmps;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="methodType", column=@Column(name="METHOD_TYPE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="execMm", column=@Column(name="EXEC_MM", nullable=false, length=7) ), 
        @AttributeOverride(name="methodSeq", column=@Column(name="METHOD_SEQ", nullable=false, precision=5, scale=0) ) } )
    public PayExecutionDateId getId() {
        return this.id;
    }
    
    public void setId(PayExecutionDateId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="OPEN_MM", referencedColumnName="OPEN_MM"), 
        @JoinColumn(name="OPEN_YYYY", referencedColumnName="OPEN_YYYY") } )
    public PayExecutionOpen getPayExecutionOpen() {
        return this.payExecutionOpen;
    }
    
    public void setPayExecutionOpen(PayExecutionOpen payExecutionOpen) {
        this.payExecutionOpen = payExecutionOpen;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="METHOD_TYPE", nullable=false, insertable=false, updatable=false)
    public PayMethodType getPayMethodType() {
        return this.payMethodType;
    }
    
    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
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

    
    @Column(name="RMRK", length=200)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    
    @Column(name="CHK_LOCK", precision=1, scale=0)
    public Boolean getChkLock() {
        return this.chkLock;
    }
    
    public void setChkLock(Boolean chkLock) {
        this.chkLock = chkLock;
    }

    
    @Column(name="METHOD_TYPE_PRV", precision=2, scale=0)
    public Byte getMethodTypePrv() {
        return this.methodTypePrv;
    }
    
    public void setMethodTypePrv(Byte methodTypePrv) {
        this.methodTypePrv = methodTypePrv;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="EXEC_MM_PRV", length=7)
    public Date getExecMmPrv() {
        return this.execMmPrv;
    }
    
    public void setExecMmPrv(Date execMmPrv) {
        this.execMmPrv = execMmPrv;
    }

    
    @Column(name="CHK_SALARY", precision=1, scale=0)
    public Boolean getChkSalary() {
        return this.chkSalary;
    }
    
    public void setChkSalary(Boolean chkSalary) {
        this.chkSalary = chkSalary;
    }

    
    @Column(name="ABSENT_STATUS", precision=1, scale=0)
    public Boolean getAbsentStatus() {
        return this.absentStatus;
    }
    
    public void setAbsentStatus(Boolean absentStatus) {
        this.absentStatus = absentStatus;
    }

    
    @Column(name="PUNISH_STATUS", precision=1, scale=0)
    public Boolean getPunishStatus() {
        return this.punishStatus;
    }
    
    public void setPunishStatus(Boolean punishStatus) {
        this.punishStatus = punishStatus;
    }

    
    @Column(name="SICK_STATUS", precision=1, scale=0)
    public Boolean getSickStatus() {
        return this.sickStatus;
    }
    
    public void setSickStatus(Boolean sickStatus) {
        this.sickStatus = sickStatus;
    }

    
    @Column(name="INJURY_STATUS", precision=1, scale=0)
    public Boolean getInjuryStatus() {
        return this.injuryStatus;
    }
    
    public void setInjuryStatus(Boolean injuryStatus) {
        this.injuryStatus = injuryStatus;
    }

    
    @Column(name="HOLIDAY_STATUS", precision=1, scale=0)
    public Boolean getHolidayStatus() {
        return this.holidayStatus;
    }
    
    public void setHolidayStatus(Boolean holidayStatus) {
        this.holidayStatus = holidayStatus;
    }

    
    @Column(name="DAY_NO_PARAMETER", precision=2, scale=0)
    public Byte getDayNoParameter() {
        return this.dayNoParameter;
    }
    
    public void setDayNoParameter(Byte dayNoParameter) {
        this.dayNoParameter = dayNoParameter;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="INS_LAW_DATE", length=7)
    public Date getInsLawDate() {
        return this.insLawDate;
    }
    
    public void setInsLawDate(Date insLawDate) {
        this.insLawDate = insLawDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="STAMP_LAW_DATE", length=7)
    public Date getStampLawDate() {
        return this.stampLawDate;
    }
    
    public void setStampLawDate(Date stampLawDate) {
        this.stampLawDate = stampLawDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="TAX_LAW_DATE", length=7)
    public Date getTaxLawDate() {
        return this.taxLawDate;
    }
    
    public void setTaxLawDate(Date taxLawDate) {
        this.taxLawDate = taxLawDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="TAX_END_DATE", length=7)
    public Date getTaxEndDate() {
        return this.taxEndDate;
    }
    
    public void setTaxEndDate(Date taxEndDate) {
        this.taxEndDate = taxEndDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="TAX_START_DATE", length=7)
    public Date getTaxStartDate() {
        return this.taxStartDate;
    }
    
    public void setTaxStartDate(Date taxStartDate) {
        this.taxStartDate = taxStartDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="INS_END_DATE", length=7)
    public Date getInsEndDate() {
        return this.insEndDate;
    }
    
    public void setInsEndDate(Date insEndDate) {
        this.insEndDate = insEndDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="INS_START_DATE", length=7)
    public Date getInsStartDate() {
        return this.insStartDate;
    }
    
    public void setInsStartDate(Date insStartDate) {
        this.insStartDate = insStartDate;
    }

    
    @Column(name="OPEN_DD", precision=2, scale=0)
    public Byte getOpenDd() {
        return this.openDd;
    }
    
    public void setOpenDd(Byte openDd) {
        this.openDd = openDd;
    }

    
    @Column(name="METHOD_SEQ_PRV", precision=5, scale=0)
    public Integer getMethodSeqPrv() {
        return this.methodSeqPrv;
    }
    
    public void setMethodSeqPrv(Integer methodSeqPrv) {
        this.methodSeqPrv = methodSeqPrv;
    }

    
    @Column(name="METHOD_ORDER", precision=5, scale=0)
    public Integer getMethodOrder() {
        return this.methodOrder;
    }
    
    public void setMethodOrder(Integer methodOrder) {
        this.methodOrder = methodOrder;
    }

    
    @Column(name="INS_MAX_BASIC_LAW", precision=11)
    public BigDecimal getInsMaxBasicLaw() {
        return this.insMaxBasicLaw;
    }
    
    public void setInsMaxBasicLaw(BigDecimal insMaxBasicLaw) {
        this.insMaxBasicLaw = insMaxBasicLaw;
    }

    
    @Column(name="INS_MAX_VAR_LAW", precision=11)
    public BigDecimal getInsMaxVarLaw() {
        return this.insMaxVarLaw;
    }
    
    public void setInsMaxVarLaw(BigDecimal insMaxVarLaw) {
        this.insMaxVarLaw = insMaxVarLaw;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="payExecutionDate")
    public Set<PayExecutionSpecificEmp> getPayExecutionSpecificEmps() {
        return this.payExecutionSpecificEmps;
    }
    
    public void setPayExecutionSpecificEmps(Set<PayExecutionSpecificEmp> payExecutionSpecificEmps) {
        this.payExecutionSpecificEmps = payExecutionSpecificEmps;
    }




}


