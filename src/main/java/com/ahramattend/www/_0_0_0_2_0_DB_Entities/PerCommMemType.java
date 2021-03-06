package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerCommMemType generated by hbm2java
 */
@Entity
@Table(name="PER_COMM_MEM_TYPE"
    ,schema="SHAMS"
)
public class PerCommMemType  implements java.io.Serializable {


     private PerCommMemTypeId id;
     private PerCommMemTypeCode perCommMemTypeCode;
     private PerCommTypeCode perCommTypeCode;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;

    public PerCommMemType() {
    }

	
    public PerCommMemType(PerCommMemTypeId id, PerCommMemTypeCode perCommMemTypeCode, PerCommTypeCode perCommTypeCode) {
        this.id = id;
        this.perCommMemTypeCode = perCommMemTypeCode;
        this.perCommTypeCode = perCommTypeCode;
    }
    public PerCommMemType(PerCommMemTypeId id, PerCommMemTypeCode perCommMemTypeCode, PerCommTypeCode perCommTypeCode, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate) {
       this.id = id;
       this.perCommMemTypeCode = perCommMemTypeCode;
       this.perCommTypeCode = perCommTypeCode;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="commTypeCode", column=@Column(name="COMM_TYPE_CODE", nullable=false, length=5) ), 
        @AttributeOverride(name="commMemTypeCode", column=@Column(name="COMM_MEM_TYPE_CODE", nullable=false, length=5) ) } )
    public PerCommMemTypeId getId() {
        return this.id;
    }
    
    public void setId(PerCommMemTypeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="COMM_MEM_TYPE_CODE", nullable=false, insertable=false, updatable=false)
    public PerCommMemTypeCode getPerCommMemTypeCode() {
        return this.perCommMemTypeCode;
    }
    
    public void setPerCommMemTypeCode(PerCommMemTypeCode perCommMemTypeCode) {
        this.perCommMemTypeCode = perCommMemTypeCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="COMM_TYPE_CODE", nullable=false, insertable=false, updatable=false)
    public PerCommTypeCode getPerCommTypeCode() {
        return this.perCommTypeCode;
    }
    
    public void setPerCommTypeCode(PerCommTypeCode perCommTypeCode) {
        this.perCommTypeCode = perCommTypeCode;
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


