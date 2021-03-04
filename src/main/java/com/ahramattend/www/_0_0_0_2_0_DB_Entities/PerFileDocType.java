package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerFileDocType generated by hbm2java
 */
@Entity
@Table(name="PER_FILE_DOC_TYPE"
    ,schema="SHAMS"
)
public class PerFileDocType  implements java.io.Serializable {


     private String docTypeCode;
     private String docTypeName;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set<PerEmpFile> perEmpFiles = new HashSet<PerEmpFile>(0);

    public PerFileDocType() {
    }

	
    public PerFileDocType(String docTypeCode, String docTypeName) {
        this.docTypeCode = docTypeCode;
        this.docTypeName = docTypeName;
    }
    public PerFileDocType(String docTypeCode, String docTypeName, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set<PerEmpFile> perEmpFiles) {
       this.docTypeCode = docTypeCode;
       this.docTypeName = docTypeName;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.perEmpFiles = perEmpFiles;
    }
   
     @Id 

    
    @Column(name="DOC_TYPE_CODE", unique=true, nullable=false, length=5)
    public String getDocTypeCode() {
        return this.docTypeCode;
    }
    
    public void setDocTypeCode(String docTypeCode) {
        this.docTypeCode = docTypeCode;
    }

    
    @Column(name="DOC_TYPE_NAME", nullable=false, length=100)
    public String getDocTypeName() {
        return this.docTypeName;
    }
    
    public void setDocTypeName(String docTypeName) {
        this.docTypeName = docTypeName;
    }

    
    @Column(name="RECORD_CREATE_USER", length=15)
    public String getRecordCreateUser() {
        return this.recordCreateUser;
    }
    
    public void setRecordCreateUser(String recordCreateUser) {
        this.recordCreateUser = recordCreateUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_CREATE_DATE", length=7)
    public Date getRecordCreateDate() {
        return this.recordCreateDate;
    }
    
    public void setRecordCreateDate(Date recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }

    
    @Column(name="RECORD_UPDATE_USER", length=15)
    public String getRecordUpdateUser() {
        return this.recordUpdateUser;
    }
    
    public void setRecordUpdateUser(String recordUpdateUser) {
        this.recordUpdateUser = recordUpdateUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_UPDATE_DATE", length=7)
    public Date getRecordUpdateDate() {
        return this.recordUpdateDate;
    }
    
    public void setRecordUpdateDate(Date recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perFileDocType")
    public Set<PerEmpFile> getPerEmpFiles() {
        return this.perEmpFiles;
    }
    
    public void setPerEmpFiles(Set<PerEmpFile> perEmpFiles) {
        this.perEmpFiles = perEmpFiles;
    }




}

