package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


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
 * PayLocationBandFile generated by hbm2java
 */
@Entity
@Table(name="PAY_LOCATION_BAND_FILE"
    ,schema="SHAMS"
)
public class PayLocationBandFile  implements java.io.Serializable {


     private PayLocationBandFileId id;
     private PerLocationCodes perLocationCodes;
     private PayBandCode payBandCode;
     private PayMethodType payMethodType;
     private String chkBand;
     private String rmrk;
     private Set<PayDeserveEmpFileStopDtl> payDeserveEmpFileStopDtls = new HashSet<PayDeserveEmpFileStopDtl>(0);
     private Set<PayDeserveEmpFile> payDeserveEmpFiles = new HashSet<PayDeserveEmpFile>(0);

    public PayLocationBandFile() {
    }

	
    public PayLocationBandFile(PayLocationBandFileId id, PerLocationCodes perLocationCodes, PayBandCode payBandCode) {
        this.id = id;
        this.perLocationCodes = perLocationCodes;
        this.payBandCode = payBandCode;
    }
    public PayLocationBandFile(PayLocationBandFileId id, PerLocationCodes perLocationCodes, PayBandCode payBandCode, PayMethodType payMethodType, String chkBand, String rmrk, Set<PayDeserveEmpFileStopDtl> payDeserveEmpFileStopDtls, Set<PayDeserveEmpFile> payDeserveEmpFiles) {
       this.id = id;
       this.perLocationCodes = perLocationCodes;
       this.payBandCode = payBandCode;
       this.payMethodType = payMethodType;
       this.chkBand = chkBand;
       this.rmrk = rmrk;
       this.payDeserveEmpFileStopDtls = payDeserveEmpFileStopDtls;
       this.payDeserveEmpFiles = payDeserveEmpFiles;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="bandType", column=@Column(name="BAND_TYPE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="bandCode", column=@Column(name="BAND_CODE", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="locCode", column=@Column(name="LOC_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ) } )
    public PayLocationBandFileId getId() {
        return this.id;
    }
    
    public void setId(PayLocationBandFileId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="LOC_CODE", referencedColumnName="LOC_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false) } )
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
    @JoinColumn(name="METHOD_TYPE")
    public PayMethodType getPayMethodType() {
        return this.payMethodType;
    }
    
    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }

    
    @Column(name="CHK_BAND", length=1)
    public String getChkBand() {
        return this.chkBand;
    }
    
    public void setChkBand(String chkBand) {
        this.chkBand = chkBand;
    }

    
    @Column(name="RMRK", length=100)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="payLocationBandFile")
    public Set<PayDeserveEmpFileStopDtl> getPayDeserveEmpFileStopDtls() {
        return this.payDeserveEmpFileStopDtls;
    }
    
    public void setPayDeserveEmpFileStopDtls(Set<PayDeserveEmpFileStopDtl> payDeserveEmpFileStopDtls) {
        this.payDeserveEmpFileStopDtls = payDeserveEmpFileStopDtls;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="payLocationBandFile")
    public Set<PayDeserveEmpFile> getPayDeserveEmpFiles() {
        return this.payDeserveEmpFiles;
    }
    
    public void setPayDeserveEmpFiles(Set<PayDeserveEmpFile> payDeserveEmpFiles) {
        this.payDeserveEmpFiles = payDeserveEmpFiles;
    }




}


