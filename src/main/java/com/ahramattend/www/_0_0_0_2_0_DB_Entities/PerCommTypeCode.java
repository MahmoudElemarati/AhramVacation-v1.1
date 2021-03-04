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
 * PerCommTypeCode generated by hbm2java
 */
@Entity
@Table(name="PER_COMM_TYPE_CODE"
    ,schema="SHAMS"
)
public class PerCommTypeCode  implements java.io.Serializable {


     private String commTypeCode;
     private String commTypeName;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set<PerCommMemType> perCommMemTypes = new HashSet<PerCommMemType>(0);
     private Set<PerCommityMaster> perCommityMasters = new HashSet<PerCommityMaster>(0);

    public PerCommTypeCode() {
    }

	
    public PerCommTypeCode(String commTypeCode, String commTypeName) {
        this.commTypeCode = commTypeCode;
        this.commTypeName = commTypeName;
    }
    public PerCommTypeCode(String commTypeCode, String commTypeName, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set<PerCommMemType> perCommMemTypes, Set<PerCommityMaster> perCommityMasters) {
       this.commTypeCode = commTypeCode;
       this.commTypeName = commTypeName;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.perCommMemTypes = perCommMemTypes;
       this.perCommityMasters = perCommityMasters;
    }
   
     @Id 

    
    @Column(name="COMM_TYPE_CODE", unique=true, nullable=false, length=5)
    public String getCommTypeCode() {
        return this.commTypeCode;
    }
    
    public void setCommTypeCode(String commTypeCode) {
        this.commTypeCode = commTypeCode;
    }

    
    @Column(name="COMM_TYPE_NAME", nullable=false, length=100)
    public String getCommTypeName() {
        return this.commTypeName;
    }
    
    public void setCommTypeName(String commTypeName) {
        this.commTypeName = commTypeName;
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

@OneToMany(fetch=FetchType.EAGER, mappedBy="perCommTypeCode")
    public Set<PerCommMemType> getPerCommMemTypes() {
        return this.perCommMemTypes;
    }
    
    public void setPerCommMemTypes(Set<PerCommMemType> perCommMemTypes) {
        this.perCommMemTypes = perCommMemTypes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perCommTypeCode")
    public Set<PerCommityMaster> getPerCommityMasters() {
        return this.perCommityMasters;
    }
    
    public void setPerCommityMasters(Set<PerCommityMaster> perCommityMasters) {
        this.perCommityMasters = perCommityMasters;
    }




}

