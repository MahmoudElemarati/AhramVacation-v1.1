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
 * PerVacDocCode generated by hbm2java
 */
@Entity
@Table(name="PER_VAC_DOC_CODE"
    ,schema="SHAMS"
)
public class PerVacDocCode  implements java.io.Serializable {


     private String vacDocCode;
     private String vacDocName;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set<PerVacationRuleDoc> perVacationRuleDocs = new HashSet<PerVacationRuleDoc>(0);

    public PerVacDocCode() {
    }

	
    public PerVacDocCode(String vacDocCode, String vacDocName) {
        this.vacDocCode = vacDocCode;
        this.vacDocName = vacDocName;
    }
    public PerVacDocCode(String vacDocCode, String vacDocName, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set<PerVacationRuleDoc> perVacationRuleDocs) {
       this.vacDocCode = vacDocCode;
       this.vacDocName = vacDocName;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.perVacationRuleDocs = perVacationRuleDocs;
    }
   
     @Id 

    
    @Column(name="VAC_DOC_CODE", unique=true, nullable=false, length=3)
    public String getVacDocCode() {
        return this.vacDocCode;
    }
    
    public void setVacDocCode(String vacDocCode) {
        this.vacDocCode = vacDocCode;
    }

    
    @Column(name="VAC_DOC_NAME", nullable=false, length=50)
    public String getVacDocName() {
        return this.vacDocName;
    }
    
    public void setVacDocName(String vacDocName) {
        this.vacDocName = vacDocName;
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

@OneToMany(fetch=FetchType.EAGER, mappedBy="perVacDocCode")
    public Set<PerVacationRuleDoc> getPerVacationRuleDocs() {
        return this.perVacationRuleDocs;
    }
    
    public void setPerVacationRuleDocs(Set<PerVacationRuleDoc> perVacationRuleDocs) {
        this.perVacationRuleDocs = perVacationRuleDocs;
    }




}


