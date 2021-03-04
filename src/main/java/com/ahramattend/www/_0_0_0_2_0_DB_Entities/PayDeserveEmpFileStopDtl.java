package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


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

/**
 * PayDeserveEmpFileStopDtl generated by hbm2java
 */
@Entity
@Table(name="PAY_DESERVE_EMP_FILE_STOP_DTL"
    ,schema="SHAMS"
)
public class PayDeserveEmpFileStopDtl  implements java.io.Serializable {


     private PayDeserveEmpFileStopDtlId id;
     private PayLocationBandFile payLocationBandFile;
     private PayDeserveEmpFileStop payDeserveEmpFileStop;
     private String rmrk;

    public PayDeserveEmpFileStopDtl() {
    }

	
    public PayDeserveEmpFileStopDtl(PayDeserveEmpFileStopDtlId id, PayLocationBandFile payLocationBandFile, PayDeserveEmpFileStop payDeserveEmpFileStop) {
        this.id = id;
        this.payLocationBandFile = payLocationBandFile;
        this.payDeserveEmpFileStop = payDeserveEmpFileStop;
    }
    public PayDeserveEmpFileStopDtl(PayDeserveEmpFileStopDtlId id, PayLocationBandFile payLocationBandFile, PayDeserveEmpFileStop payDeserveEmpFileStop, String rmrk) {
       this.id = id;
       this.payLocationBandFile = payLocationBandFile;
       this.payDeserveEmpFileStop = payDeserveEmpFileStop;
       this.rmrk = rmrk;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ), 
        @AttributeOverride(name="stopSp", column=@Column(name="STOP_SP", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="locCode", column=@Column(name="LOC_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="bandType", column=@Column(name="BAND_TYPE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="bandCode", column=@Column(name="BAND_CODE", nullable=false, precision=4, scale=0) ) } )
    public PayDeserveEmpFileStopDtlId getId() {
        return this.id;
    }
    
    public void setId(PayDeserveEmpFileStopDtlId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="BAND_TYPE", referencedColumnName="BAND_TYPE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="BAND_CODE", referencedColumnName="BAND_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="LOC_CODE", referencedColumnName="LOC_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false) } )
    public PayLocationBandFile getPayLocationBandFile() {
        return this.payLocationBandFile;
    }
    
    public void setPayLocationBandFile(PayLocationBandFile payLocationBandFile) {
        this.payLocationBandFile = payLocationBandFile;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="EMPLOYEE_ID", referencedColumnName="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="STOP_SP", referencedColumnName="STOP_SP", nullable=false, insertable=false, updatable=false) } )
    public PayDeserveEmpFileStop getPayDeserveEmpFileStop() {
        return this.payDeserveEmpFileStop;
    }
    
    public void setPayDeserveEmpFileStop(PayDeserveEmpFileStop payDeserveEmpFileStop) {
        this.payDeserveEmpFileStop = payDeserveEmpFileStop;
    }

    
    @Column(name="RMRK", length=200)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }




}


