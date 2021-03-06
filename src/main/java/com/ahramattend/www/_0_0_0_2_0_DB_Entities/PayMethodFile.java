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
 * PayMethodFile generated by hbm2java
 */
@Entity
@Table(name="PAY_METHOD_FILE"
    ,schema="SHAMS"
)
public class PayMethodFile  implements java.io.Serializable {


     private short fileSp;
     private String fileNameArb;
     private String fileNameEng;
     private Set<PayMethodFileType> payMethodFileTypes = new HashSet<PayMethodFileType>(0);
     private Set<PayMethodFileDtl> payMethodFileDtls = new HashSet<PayMethodFileDtl>(0);

    public PayMethodFile() {
    }

	
    public PayMethodFile(short fileSp) {
        this.fileSp = fileSp;
    }
    public PayMethodFile(short fileSp, String fileNameArb, String fileNameEng, Set<PayMethodFileType> payMethodFileTypes, Set<PayMethodFileDtl> payMethodFileDtls) {
       this.fileSp = fileSp;
       this.fileNameArb = fileNameArb;
       this.fileNameEng = fileNameEng;
       this.payMethodFileTypes = payMethodFileTypes;
       this.payMethodFileDtls = payMethodFileDtls;
    }
   
     @Id 

    
    @Column(name="FILE_SP", unique=true, nullable=false, precision=3, scale=0)
    public short getFileSp() {
        return this.fileSp;
    }
    
    public void setFileSp(short fileSp) {
        this.fileSp = fileSp;
    }

    
    @Column(name="FILE_NAME_ARB", length=100)
    public String getFileNameArb() {
        return this.fileNameArb;
    }
    
    public void setFileNameArb(String fileNameArb) {
        this.fileNameArb = fileNameArb;
    }

    
    @Column(name="FILE_NAME_ENG", length=50)
    public String getFileNameEng() {
        return this.fileNameEng;
    }
    
    public void setFileNameEng(String fileNameEng) {
        this.fileNameEng = fileNameEng;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="payMethodFile")
    public Set<PayMethodFileType> getPayMethodFileTypes() {
        return this.payMethodFileTypes;
    }
    
    public void setPayMethodFileTypes(Set<PayMethodFileType> payMethodFileTypes) {
        this.payMethodFileTypes = payMethodFileTypes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="payMethodFile")
    public Set<PayMethodFileDtl> getPayMethodFileDtls() {
        return this.payMethodFileDtls;
    }
    
    public void setPayMethodFileDtls(Set<PayMethodFileDtl> payMethodFileDtls) {
        this.payMethodFileDtls = payMethodFileDtls;
    }




}


