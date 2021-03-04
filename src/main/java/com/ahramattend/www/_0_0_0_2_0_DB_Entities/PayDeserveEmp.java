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
 * PayDeserveEmp generated by hbm2java
 */
@Entity
@Table(name="PAY_DESERVE_EMP"
    ,schema="SHAMS"
)
public class PayDeserveEmp  implements java.io.Serializable {


     private PayDeserveEmpId id;
     private PerLocationCodes perLocationCodes;
     private PayBandCode payBandCode;
     private PayEmployeeMaster payEmployeeMaster;
     private PayExecutionOpen payExecutionOpen;
     private PayMethodType payMethodType;
     private String employeeNo;
     private boolean bandStatus;
     private BigDecimal val;
     private Date startDate;
     private Date endDate;
     private String rmrk;
     private String orgIdFrom;
     private Date execMm;
     private byte statusCode;
     private short statusGroup;
     private Integer methodSeq;
     private BigDecimal valFile;

    public PayDeserveEmp() {
    }

	
    public PayDeserveEmp(PayDeserveEmpId id, PerLocationCodes perLocationCodes, PayBandCode payBandCode, PayEmployeeMaster payEmployeeMaster, PayMethodType payMethodType, String employeeNo, boolean bandStatus, byte statusCode, short statusGroup) {
        this.id = id;
        this.perLocationCodes = perLocationCodes;
        this.payBandCode = payBandCode;
        this.payEmployeeMaster = payEmployeeMaster;
        this.payMethodType = payMethodType;
        this.employeeNo = employeeNo;
        this.bandStatus = bandStatus;
        this.statusCode = statusCode;
        this.statusGroup = statusGroup;
    }
    public PayDeserveEmp(PayDeserveEmpId id, PerLocationCodes perLocationCodes, PayBandCode payBandCode, PayEmployeeMaster payEmployeeMaster, PayExecutionOpen payExecutionOpen, PayMethodType payMethodType, String employeeNo, boolean bandStatus, BigDecimal val, Date startDate, Date endDate, String rmrk, String orgIdFrom, Date execMm, byte statusCode, short statusGroup, Integer methodSeq, BigDecimal valFile) {
       this.id = id;
       this.perLocationCodes = perLocationCodes;
       this.payBandCode = payBandCode;
       this.payEmployeeMaster = payEmployeeMaster;
       this.payExecutionOpen = payExecutionOpen;
       this.payMethodType = payMethodType;
       this.employeeNo = employeeNo;
       this.bandStatus = bandStatus;
       this.val = val;
       this.startDate = startDate;
       this.endDate = endDate;
       this.rmrk = rmrk;
       this.orgIdFrom = orgIdFrom;
       this.execMm = execMm;
       this.statusCode = statusCode;
       this.statusGroup = statusGroup;
       this.methodSeq = methodSeq;
       this.valFile = valFile;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="bandType", column=@Column(name="BAND_TYPE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="bandCode", column=@Column(name="BAND_CODE", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ), 
        @AttributeOverride(name="methodType", column=@Column(name="METHOD_TYPE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="deserveSp", column=@Column(name="DESERVE_SP", nullable=false, precision=7, scale=0) ) } )
    public PayDeserveEmpId getId() {
        return this.id;
    }
    
    public void setId(PayDeserveEmpId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="LOC_CODE", referencedColumnName="LOC_CODE"), 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false) } )
    public PerLocationCodes getPerLocationCodes() {
        return this.perLocationCodes;
    }
    
    public void setPerLocationCodes(PerLocationCodes perLocationCodes) {
        this.perLocationCodes = perLocationCodes;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="BAND_TYPE", referencedColumnName="BAND_TYPE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="BAND_CODE", referencedColumnName="BAND_CODE", nullable=false, insertable=false, updatable=false) } )
    public PayBandCode getPayBandCode() {
        return this.payBandCode;
    }
    
    public void setPayBandCode(PayBandCode payBandCode) {
        this.payBandCode = payBandCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public PayEmployeeMaster getPayEmployeeMaster() {
        return this.payEmployeeMaster;
    }
    
    public void setPayEmployeeMaster(PayEmployeeMaster payEmployeeMaster) {
        this.payEmployeeMaster = payEmployeeMaster;
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

    
    @Column(name="EMPLOYEE_NO", nullable=false, length=10)
    public String getEmployeeNo() {
        return this.employeeNo;
    }
    
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    
    @Column(name="BAND_STATUS", nullable=false, precision=1, scale=0)
    public boolean isBandStatus() {
        return this.bandStatus;
    }
    
    public void setBandStatus(boolean bandStatus) {
        this.bandStatus = bandStatus;
    }

    
    @Column(name="VAL", precision=11)
    public BigDecimal getVal() {
        return this.val;
    }
    
    public void setVal(BigDecimal val) {
        this.val = val;
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

    
    @Column(name="RMRK", length=100)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    
    @Column(name="ORG_ID_FROM", length=5)
    public String getOrgIdFrom() {
        return this.orgIdFrom;
    }
    
    public void setOrgIdFrom(String orgIdFrom) {
        this.orgIdFrom = orgIdFrom;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="EXEC_MM", length=7)
    public Date getExecMm() {
        return this.execMm;
    }
    
    public void setExecMm(Date execMm) {
        this.execMm = execMm;
    }

    
    @Column(name="STATUS_CODE", nullable=false, precision=2, scale=0)
    public byte getStatusCode() {
        return this.statusCode;
    }
    
    public void setStatusCode(byte statusCode) {
        this.statusCode = statusCode;
    }

    
    @Column(name="STATUS_GROUP", nullable=false, precision=4, scale=0)
    public short getStatusGroup() {
        return this.statusGroup;
    }
    
    public void setStatusGroup(short statusGroup) {
        this.statusGroup = statusGroup;
    }

    
    @Column(name="METHOD_SEQ", precision=5, scale=0)
    public Integer getMethodSeq() {
        return this.methodSeq;
    }
    
    public void setMethodSeq(Integer methodSeq) {
        this.methodSeq = methodSeq;
    }

    
    @Column(name="VAL_FILE", precision=11)
    public BigDecimal getValFile() {
        return this.valFile;
    }
    
    public void setValFile(BigDecimal valFile) {
        this.valFile = valFile;
    }




}


