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
 * PerComplaintCode generated by hbm2java
 */
@Entity
@Table(name="PER_COMPLAINT_CODE"
    ,schema="SHAMS"
)
public class PerComplaintCode  implements java.io.Serializable {


     private String complaintCode;
     private String complaintName;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set<PerComplaintData> perComplaintDatas = new HashSet<PerComplaintData>(0);

    public PerComplaintCode() {
    }

	
    public PerComplaintCode(String complaintCode, String complaintName) {
        this.complaintCode = complaintCode;
        this.complaintName = complaintName;
    }
    public PerComplaintCode(String complaintCode, String complaintName, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set<PerComplaintData> perComplaintDatas) {
       this.complaintCode = complaintCode;
       this.complaintName = complaintName;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.perComplaintDatas = perComplaintDatas;
    }
   
     @Id 

    
    @Column(name="COMPLAINT_CODE", unique=true, nullable=false, length=5)
    public String getComplaintCode() {
        return this.complaintCode;
    }
    
    public void setComplaintCode(String complaintCode) {
        this.complaintCode = complaintCode;
    }

    
    @Column(name="COMPLAINT_NAME", nullable=false, length=100)
    public String getComplaintName() {
        return this.complaintName;
    }
    
    public void setComplaintName(String complaintName) {
        this.complaintName = complaintName;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="perComplaintCode")
    public Set<PerComplaintData> getPerComplaintDatas() {
        return this.perComplaintDatas;
    }
    
    public void setPerComplaintDatas(Set<PerComplaintData> perComplaintDatas) {
        this.perComplaintDatas = perComplaintDatas;
    }




}


