package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerGroupDegreeNew generated by hbm2java
 */
@Entity
@Table(name="PER_GROUP_DEGREE_NEW"
    ,schema="SHAMS"
)
public class PerGroupDegreeNew  implements java.io.Serializable {


     private PerGroupDegreeNewId id;
     private PerFiscalDegreeCodeNew perFiscalDegreeCodeNew;
     private PerGroupTypeCode perGroupTypeCode;
     private Boolean specialEvalFlg;
     private String notes;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date reordUpdateDate;
     private Set<PerHumanBalJobNew> perHumanBalJobNews = new HashSet<PerHumanBalJobNew>(0);
     private Set<PerHumanBalJobDistributeN> perHumanBalJobDistributeNs = new HashSet<PerHumanBalJobDistributeN>(0);
     private Set<PerAnnualEvalEmp> perAnnualEvalEmps = new HashSet<PerAnnualEvalEmp>(0);

    public PerGroupDegreeNew() {
    }

	
    public PerGroupDegreeNew(PerGroupDegreeNewId id, PerFiscalDegreeCodeNew perFiscalDegreeCodeNew, PerGroupTypeCode perGroupTypeCode) {
        this.id = id;
        this.perFiscalDegreeCodeNew = perFiscalDegreeCodeNew;
        this.perGroupTypeCode = perGroupTypeCode;
    }
    public PerGroupDegreeNew(PerGroupDegreeNewId id, PerFiscalDegreeCodeNew perFiscalDegreeCodeNew, PerGroupTypeCode perGroupTypeCode, Boolean specialEvalFlg, String notes, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date reordUpdateDate, Set<PerHumanBalJobNew> perHumanBalJobNews, Set<PerHumanBalJobDistributeN> perHumanBalJobDistributeNs, Set<PerAnnualEvalEmp> perAnnualEvalEmps) {
       this.id = id;
       this.perFiscalDegreeCodeNew = perFiscalDegreeCodeNew;
       this.perGroupTypeCode = perGroupTypeCode;
       this.specialEvalFlg = specialEvalFlg;
       this.notes = notes;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.reordUpdateDate = reordUpdateDate;
       this.perHumanBalJobNews = perHumanBalJobNews;
       this.perHumanBalJobDistributeNs = perHumanBalJobDistributeNs;
       this.perAnnualEvalEmps = perAnnualEvalEmps;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="fiscalDegreeCodeNew", column=@Column(name="FISCAL_DEGREE_CODE_NEW", nullable=false, length=3) ), 
        @AttributeOverride(name="groupTypeCode", column=@Column(name="GROUP_TYPE_CODE", nullable=false, length=3) ) } )
    public PerGroupDegreeNewId getId() {
        return this.id;
    }
    
    public void setId(PerGroupDegreeNewId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FISCAL_DEGREE_CODE_NEW", nullable=false, insertable=false, updatable=false)
    public PerFiscalDegreeCodeNew getPerFiscalDegreeCodeNew() {
        return this.perFiscalDegreeCodeNew;
    }
    
    public void setPerFiscalDegreeCodeNew(PerFiscalDegreeCodeNew perFiscalDegreeCodeNew) {
        this.perFiscalDegreeCodeNew = perFiscalDegreeCodeNew;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GROUP_TYPE_CODE", nullable=false, insertable=false, updatable=false)
    public PerGroupTypeCode getPerGroupTypeCode() {
        return this.perGroupTypeCode;
    }
    
    public void setPerGroupTypeCode(PerGroupTypeCode perGroupTypeCode) {
        this.perGroupTypeCode = perGroupTypeCode;
    }

    
    @Column(name="SPECIAL_EVAL_FLG", precision=1, scale=0)
    public Boolean getSpecialEvalFlg() {
        return this.specialEvalFlg;
    }
    
    public void setSpecialEvalFlg(Boolean specialEvalFlg) {
        this.specialEvalFlg = specialEvalFlg;
    }

    
    @Column(name="NOTES", length=100)
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
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
    @Column(name="REORD_UPDATE_DATE", length=7)
    public Date getReordUpdateDate() {
        return this.reordUpdateDate;
    }
    
    public void setReordUpdateDate(Date reordUpdateDate) {
        this.reordUpdateDate = reordUpdateDate;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGroupDegreeNew")
    public Set<PerHumanBalJobNew> getPerHumanBalJobNews() {
        return this.perHumanBalJobNews;
    }
    
    public void setPerHumanBalJobNews(Set<PerHumanBalJobNew> perHumanBalJobNews) {
        this.perHumanBalJobNews = perHumanBalJobNews;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGroupDegreeNew")
    public Set<PerHumanBalJobDistributeN> getPerHumanBalJobDistributeNs() {
        return this.perHumanBalJobDistributeNs;
    }
    
    public void setPerHumanBalJobDistributeNs(Set<PerHumanBalJobDistributeN> perHumanBalJobDistributeNs) {
        this.perHumanBalJobDistributeNs = perHumanBalJobDistributeNs;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGroupDegreeNew")
    public Set<PerAnnualEvalEmp> getPerAnnualEvalEmps() {
        return this.perAnnualEvalEmps;
    }
    
    public void setPerAnnualEvalEmps(Set<PerAnnualEvalEmp> perAnnualEvalEmps) {
        this.perAnnualEvalEmps = perAnnualEvalEmps;
    }




}

