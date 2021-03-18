package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


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
 * PerQualClass generated by hbm2java
 */
@Entity
@Table(name="PER_QUAL_CLASS"
    ,schema="SHAMS"
)
public class PerQualClass  implements java.io.Serializable {


     private String qualClassCode;
     private String qualClassName;
     private byte priorityFlag;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private boolean qualDateFormat;
     private Boolean qualClass;
     private Set<PerQualCode> perQualCodes = new HashSet<PerQualCode>(0);

    public PerQualClass() {
    }

	
    public PerQualClass(String qualClassCode, String qualClassName, byte priorityFlag, boolean qualDateFormat) {
        this.qualClassCode = qualClassCode;
        this.qualClassName = qualClassName;
        this.priorityFlag = priorityFlag;
        this.qualDateFormat = qualDateFormat;
    }
    public PerQualClass(String qualClassCode, String qualClassName, byte priorityFlag, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, boolean qualDateFormat, Boolean qualClass, Set<PerQualCode> perQualCodes) {
       this.qualClassCode = qualClassCode;
       this.qualClassName = qualClassName;
       this.priorityFlag = priorityFlag;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.qualDateFormat = qualDateFormat;
       this.qualClass = qualClass;
       this.perQualCodes = perQualCodes;
    }
   
     @Id 

    
    @Column(name="QUAL_CLASS_CODE", unique=true, nullable=false, length=2)
    public String getQualClassCode() {
        return this.qualClassCode;
    }
    
    public void setQualClassCode(String qualClassCode) {
        this.qualClassCode = qualClassCode;
    }

    
    @Column(name="QUAL_CLASS_NAME", nullable=false, length=30)
    public String getQualClassName() {
        return this.qualClassName;
    }
    
    public void setQualClassName(String qualClassName) {
        this.qualClassName = qualClassName;
    }

    
    @Column(name="PRIORITY_FLAG", nullable=false, precision=2, scale=0)
    public byte getPriorityFlag() {
        return this.priorityFlag;
    }
    
    public void setPriorityFlag(byte priorityFlag) {
        this.priorityFlag = priorityFlag;
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

    
    @Column(name="QUAL_DATE_FORMAT", nullable=false, precision=1, scale=0)
    public boolean isQualDateFormat() {
        return this.qualDateFormat;
    }
    
    public void setQualDateFormat(boolean qualDateFormat) {
        this.qualDateFormat = qualDateFormat;
    }

    
    @Column(name="QUAL_CLASS", precision=1, scale=0)
    public Boolean getQualClass() {
        return this.qualClass;
    }
    
    public void setQualClass(Boolean qualClass) {
        this.qualClass = qualClass;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perQualClass")
    public Set<PerQualCode> getPerQualCodes() {
        return this.perQualCodes;
    }
    
    public void setPerQualCodes(Set<PerQualCode> perQualCodes) {
        this.perQualCodes = perQualCodes;
    }




}


