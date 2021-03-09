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
 * AppEmployeeReqJ444 generated by hbm2java
 */
@Entity
@Table(name="APP_EMPLOYEE_REQ_J444"
    ,schema="SHAMS"
)
public class AppEmployeeReqJ444  implements java.io.Serializable {


     private AppEmployeeReqJ444Id id;
     private PerEmploymentMasters perEmploymentMasters;
     private AppEmployeeReqJ222 appEmployeeReqJ222;
     private String employeeNo;
     private String locationCode;
     private Byte statusCode;
     private Date sendDate;
     private Short dayNo;
     private String jobCode;
     private Short bankCode;
     private long sarfCode;
     private String locCode;
     private Short statusGroup;
     private String fiscalDegreeCode;
     private BigDecimal val30;
     private BigDecimal val65;
     private BigDecimal val70;
     private String tafkit;
     private String rmrkFrom;
     private String rmrkTo;
     private String chkRev;

    public AppEmployeeReqJ444() {
    }

	
    public AppEmployeeReqJ444(AppEmployeeReqJ444Id id, PerEmploymentMasters perEmploymentMasters, AppEmployeeReqJ222 appEmployeeReqJ222, String employeeNo, long sarfCode) {
        this.id = id;
        this.perEmploymentMasters = perEmploymentMasters;
        this.appEmployeeReqJ222 = appEmployeeReqJ222;
        this.employeeNo = employeeNo;
        this.sarfCode = sarfCode;
    }
    public AppEmployeeReqJ444(AppEmployeeReqJ444Id id, PerEmploymentMasters perEmploymentMasters, AppEmployeeReqJ222 appEmployeeReqJ222, String employeeNo, String locationCode, Byte statusCode, Date sendDate, Short dayNo, String jobCode, Short bankCode, long sarfCode, String locCode, Short statusGroup, String fiscalDegreeCode, BigDecimal val30, BigDecimal val65, BigDecimal val70, String tafkit, String rmrkFrom, String rmrkTo, String chkRev) {
       this.id = id;
       this.perEmploymentMasters = perEmploymentMasters;
       this.appEmployeeReqJ222 = appEmployeeReqJ222;
       this.employeeNo = employeeNo;
       this.locationCode = locationCode;
       this.statusCode = statusCode;
       this.sendDate = sendDate;
       this.dayNo = dayNo;
       this.jobCode = jobCode;
       this.bankCode = bankCode;
       this.sarfCode = sarfCode;
       this.locCode = locCode;
       this.statusGroup = statusGroup;
       this.fiscalDegreeCode = fiscalDegreeCode;
       this.val30 = val30;
       this.val65 = val65;
       this.val70 = val70;
       this.tafkit = tafkit;
       this.rmrkFrom = rmrkFrom;
       this.rmrkTo = rmrkTo;
       this.chkRev = chkRev;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="reqSp", column=@Column(name="REQ_SP", nullable=false, precision=16, scale=0) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ) } )
    public AppEmployeeReqJ444Id getId() {
        return this.id;
    }
    
    public void setId(AppEmployeeReqJ444Id id) {
        this.id = id;
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
    @JoinColumn(name="REQ_SP", nullable=false, insertable=false, updatable=false)
    public AppEmployeeReqJ222 getAppEmployeeReqJ222() {
        return this.appEmployeeReqJ222;
    }
    
    public void setAppEmployeeReqJ222(AppEmployeeReqJ222 appEmployeeReqJ222) {
        this.appEmployeeReqJ222 = appEmployeeReqJ222;
    }

    
    @Column(name="EMPLOYEE_NO", nullable=false, length=10)
    public String getEmployeeNo() {
        return this.employeeNo;
    }
    
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    
    @Column(name="LOCATION_CODE", length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    
    @Column(name="STATUS_CODE", precision=2, scale=0)
    public Byte getStatusCode() {
        return this.statusCode;
    }
    
    public void setStatusCode(Byte statusCode) {
        this.statusCode = statusCode;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="SEND_DATE", length=7)
    public Date getSendDate() {
        return this.sendDate;
    }
    
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    
    @Column(name="DAY_NO", precision=3, scale=0)
    public Short getDayNo() {
        return this.dayNo;
    }
    
    public void setDayNo(Short dayNo) {
        this.dayNo = dayNo;
    }

    
    @Column(name="JOB_CODE", length=5)
    public String getJobCode() {
        return this.jobCode;
    }
    
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    
    @Column(name="BANK_CODE", precision=4, scale=0)
    public Short getBankCode() {
        return this.bankCode;
    }
    
    public void setBankCode(Short bankCode) {
        this.bankCode = bankCode;
    }

    
    @Column(name="SARF_CODE", nullable=false, precision=10, scale=0)
    public long getSarfCode() {
        return this.sarfCode;
    }
    
    public void setSarfCode(long sarfCode) {
        this.sarfCode = sarfCode;
    }

    
    @Column(name="LOC_CODE", length=3)
    public String getLocCode() {
        return this.locCode;
    }
    
    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }

    
    @Column(name="STATUS_GROUP", precision=4, scale=0)
    public Short getStatusGroup() {
        return this.statusGroup;
    }
    
    public void setStatusGroup(Short statusGroup) {
        this.statusGroup = statusGroup;
    }

    
    @Column(name="FISCAL_DEGREE_CODE", length=3)
    public String getFiscalDegreeCode() {
        return this.fiscalDegreeCode;
    }
    
    public void setFiscalDegreeCode(String fiscalDegreeCode) {
        this.fiscalDegreeCode = fiscalDegreeCode;
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

    
    @Column(name="TAFKIT", length=200)
    public String getTafkit() {
        return this.tafkit;
    }
    
    public void setTafkit(String tafkit) {
        this.tafkit = tafkit;
    }

    
    @Column(name="RMRK_FROM", length=200)
    public String getRmrkFrom() {
        return this.rmrkFrom;
    }
    
    public void setRmrkFrom(String rmrkFrom) {
        this.rmrkFrom = rmrkFrom;
    }

    
    @Column(name="RMRK_TO", length=200)
    public String getRmrkTo() {
        return this.rmrkTo;
    }
    
    public void setRmrkTo(String rmrkTo) {
        this.rmrkTo = rmrkTo;
    }

    
    @Column(name="CHK_REV", length=2)
    public String getChkRev() {
        return this.chkRev;
    }
    
    public void setChkRev(String chkRev) {
        this.chkRev = chkRev;
    }




}


