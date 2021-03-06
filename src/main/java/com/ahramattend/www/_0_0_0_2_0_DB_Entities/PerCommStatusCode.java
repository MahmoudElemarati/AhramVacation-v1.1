package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerCommStatusCode generated by hbm2java
 */
@Entity
@Table(name="PER_COMM_STATUS_CODE"
    ,schema="SHAMS"
)
public class PerCommStatusCode  implements java.io.Serializable {


     private String commStatusCode;
     private String commStatusName;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;

    public PerCommStatusCode() {
    }

	
    public PerCommStatusCode(String commStatusCode, String commStatusName) {
        this.commStatusCode = commStatusCode;
        this.commStatusName = commStatusName;
    }
    public PerCommStatusCode(String commStatusCode, String commStatusName, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate) {
       this.commStatusCode = commStatusCode;
       this.commStatusName = commStatusName;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
    }
   
     @Id 

    
    @Column(name="COMM_STATUS_CODE", unique=true, nullable=false, length=3)
    public String getCommStatusCode() {
        return this.commStatusCode;
    }
    
    public void setCommStatusCode(String commStatusCode) {
        this.commStatusCode = commStatusCode;
    }

    
    @Column(name="COMM_STATUS_NAME", nullable=false, length=50)
    public String getCommStatusName() {
        return this.commStatusName;
    }
    
    public void setCommStatusName(String commStatusName) {
        this.commStatusName = commStatusName;
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




}


