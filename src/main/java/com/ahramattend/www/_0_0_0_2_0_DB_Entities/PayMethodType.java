package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PayMethodType generated by hbm2java
 */
@Entity
@Table(name="PAY_METHOD_TYPE"
    ,schema="SHAMS"
)
public class PayMethodType  implements java.io.Serializable {


     private byte methodType;
     private String methodName;
     private Boolean reqFlag;
     private Boolean annualFlag;
     private Boolean monthFlag;
     private Set<PayFinancialGroupBand> payFinancialGroupBands = new HashSet<PayFinancialGroupBand>(0);
     private Set<PayDeserveEmp> payDeserveEmps = new HashSet<PayDeserveEmp>(0);
     private Set<PayMethodFileDtl> payMethodFileDtls = new HashSet<PayMethodFileDtl>(0);
     private Set<PayLocationBandFile> payLocationBandFiles = new HashSet<PayLocationBandFile>(0);
     private Set<PayExecutionDate> payExecutionDates = new HashSet<PayExecutionDate>(0);

    public PayMethodType() {
    }

	
    public PayMethodType(byte methodType) {
        this.methodType = methodType;
    }
    public PayMethodType(byte methodType, String methodName, Boolean reqFlag, Boolean annualFlag, Boolean monthFlag, Set<PayFinancialGroupBand> payFinancialGroupBands, Set<PayDeserveEmp> payDeserveEmps, Set<PayMethodFileDtl> payMethodFileDtls, Set<PayLocationBandFile> payLocationBandFiles, Set<PayExecutionDate> payExecutionDates) {
       this.methodType = methodType;
       this.methodName = methodName;
       this.reqFlag = reqFlag;
       this.annualFlag = annualFlag;
       this.monthFlag = monthFlag;
       this.payFinancialGroupBands = payFinancialGroupBands;
       this.payDeserveEmps = payDeserveEmps;
       this.payMethodFileDtls = payMethodFileDtls;
       this.payLocationBandFiles = payLocationBandFiles;
       this.payExecutionDates = payExecutionDates;
    }
   
     @Id 

    
    @Column(name="METHOD_TYPE", unique=true, nullable=false, precision=2, scale=0)
    public byte getMethodType() {
        return this.methodType;
    }
    
    public void setMethodType(byte methodType) {
        this.methodType = methodType;
    }

    
    @Column(name="METHOD_NAME", length=50)
    public String getMethodName() {
        return this.methodName;
    }
    
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    
    @Column(name="REQ_FLAG", precision=1, scale=0)
    public Boolean getReqFlag() {
        return this.reqFlag;
    }
    
    public void setReqFlag(Boolean reqFlag) {
        this.reqFlag = reqFlag;
    }

    
    @Column(name="ANNUAL_FLAG", precision=1, scale=0)
    public Boolean getAnnualFlag() {
        return this.annualFlag;
    }
    
    public void setAnnualFlag(Boolean annualFlag) {
        this.annualFlag = annualFlag;
    }

    
    @Column(name="MONTH_FLAG", precision=1, scale=0)
    public Boolean getMonthFlag() {
        return this.monthFlag;
    }
    
    public void setMonthFlag(Boolean monthFlag) {
        this.monthFlag = monthFlag;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payMethodType")
    public Set<PayFinancialGroupBand> getPayFinancialGroupBands() {
        return this.payFinancialGroupBands;
    }
    
    public void setPayFinancialGroupBands(Set<PayFinancialGroupBand> payFinancialGroupBands) {
        this.payFinancialGroupBands = payFinancialGroupBands;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payMethodType")
    public Set<PayDeserveEmp> getPayDeserveEmps() {
        return this.payDeserveEmps;
    }
    
    public void setPayDeserveEmps(Set<PayDeserveEmp> payDeserveEmps) {
        this.payDeserveEmps = payDeserveEmps;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payMethodType")
    public Set<PayMethodFileDtl> getPayMethodFileDtls() {
        return this.payMethodFileDtls;
    }
    
    public void setPayMethodFileDtls(Set<PayMethodFileDtl> payMethodFileDtls) {
        this.payMethodFileDtls = payMethodFileDtls;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payMethodType")
    public Set<PayLocationBandFile> getPayLocationBandFiles() {
        return this.payLocationBandFiles;
    }
    
    public void setPayLocationBandFiles(Set<PayLocationBandFile> payLocationBandFiles) {
        this.payLocationBandFiles = payLocationBandFiles;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payMethodType")
    public Set<PayExecutionDate> getPayExecutionDates() {
        return this.payExecutionDates;
    }
    
    public void setPayExecutionDates(Set<PayExecutionDate> payExecutionDates) {
        this.payExecutionDates = payExecutionDates;
    }




}


