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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PayMethodFileDtl generated by hbm2java
 */
@Entity
@Table(name="PAY_METHOD_FILE_DTL"
    ,schema="SHAMS"
)
public class PayMethodFileDtl  implements java.io.Serializable {


     private PayMethodFileDtlId id;
     private PayMethodFile payMethodFile;
     private PayMethodType payMethodType;
     private Short fileSeq;
     private String fileSeqPass;
     private Set<PayBandClassificationFile> payBandClassificationFiles = new HashSet<PayBandClassificationFile>(0);

    public PayMethodFileDtl() {
    }

	
    public PayMethodFileDtl(PayMethodFileDtlId id, PayMethodFile payMethodFile, PayMethodType payMethodType) {
        this.id = id;
        this.payMethodFile = payMethodFile;
        this.payMethodType = payMethodType;
    }
    public PayMethodFileDtl(PayMethodFileDtlId id, PayMethodFile payMethodFile, PayMethodType payMethodType, Short fileSeq, String fileSeqPass, Set<PayBandClassificationFile> payBandClassificationFiles) {
       this.id = id;
       this.payMethodFile = payMethodFile;
       this.payMethodType = payMethodType;
       this.fileSeq = fileSeq;
       this.fileSeqPass = fileSeqPass;
       this.payBandClassificationFiles = payBandClassificationFiles;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="methodType", column=@Column(name="METHOD_TYPE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="fileSp", column=@Column(name="FILE_SP", nullable=false, precision=3, scale=0) ) } )
    public PayMethodFileDtlId getId() {
        return this.id;
    }
    
    public void setId(PayMethodFileDtlId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FILE_SP", nullable=false, insertable=false, updatable=false)
    public PayMethodFile getPayMethodFile() {
        return this.payMethodFile;
    }
    
    public void setPayMethodFile(PayMethodFile payMethodFile) {
        this.payMethodFile = payMethodFile;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="METHOD_TYPE", nullable=false, insertable=false, updatable=false)
    public PayMethodType getPayMethodType() {
        return this.payMethodType;
    }
    
    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }

    
    @Column(name="FILE_SEQ", precision=3, scale=0)
    public Short getFileSeq() {
        return this.fileSeq;
    }
    
    public void setFileSeq(Short fileSeq) {
        this.fileSeq = fileSeq;
    }

    
    @Column(name="FILE_SEQ_PASS", length=20)
    public String getFileSeqPass() {
        return this.fileSeqPass;
    }
    
    public void setFileSeqPass(String fileSeqPass) {
        this.fileSeqPass = fileSeqPass;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="payMethodFileDtl")
    public Set<PayBandClassificationFile> getPayBandClassificationFiles() {
        return this.payBandClassificationFiles;
    }
    
    public void setPayBandClassificationFiles(Set<PayBandClassificationFile> payBandClassificationFiles) {
        this.payBandClassificationFiles = payBandClassificationFiles;
    }




}


