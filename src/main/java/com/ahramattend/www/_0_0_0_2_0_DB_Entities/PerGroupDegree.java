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
 * PerGroupDegree generated by hbm2java
 */
@Entity
@Table(name="PER_GROUP_DEGREE"
    ,schema="SHAMS"
)
public class PerGroupDegree  implements java.io.Serializable {


     private PerGroupDegreeId id;
     private PerFiscalDegreeCode perFiscalDegreeCode;
     private PerGroupTypeCode perGroupTypeCode;
     private String notes;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Boolean specialEvalFlg;
     private Set<PerJobCode> perJobCodes = new HashSet<PerJobCode>(0);
     private Set<PerAnnualEvalEmp> perAnnualEvalEmps = new HashSet<PerAnnualEvalEmp>(0);
     private Set<PerAnnualEvalModelEmp> perAnnualEvalModelEmps = new HashSet<PerAnnualEvalModelEmp>(0);
     private Set<PerHumanBalJobDistribute> perHumanBalJobDistributes = new HashSet<PerHumanBalJobDistribute>(0);
     private Set<PerHumanBalJob> perHumanBalJobs = new HashSet<PerHumanBalJob>(0);
     private Set<PerEmpPromotion> perEmpPromotions = new HashSet<PerEmpPromotion>(0);
     private Set<PerAnnualEvalModEmpTot> perAnnualEvalModEmpTots = new HashSet<PerAnnualEvalModEmpTot>(0);

    public PerGroupDegree() {
    }

	
    public PerGroupDegree(PerGroupDegreeId id, PerFiscalDegreeCode perFiscalDegreeCode, PerGroupTypeCode perGroupTypeCode) {
        this.id = id;
        this.perFiscalDegreeCode = perFiscalDegreeCode;
        this.perGroupTypeCode = perGroupTypeCode;
    }
    public PerGroupDegree(PerGroupDegreeId id, PerFiscalDegreeCode perFiscalDegreeCode, PerGroupTypeCode perGroupTypeCode, String notes, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Boolean specialEvalFlg, Set<PerJobCode> perJobCodes, Set<PerAnnualEvalEmp> perAnnualEvalEmps, Set<PerAnnualEvalModelEmp> perAnnualEvalModelEmps, Set<PerHumanBalJobDistribute> perHumanBalJobDistributes, Set<PerHumanBalJob> perHumanBalJobs, Set<PerEmpPromotion> perEmpPromotions, Set<PerAnnualEvalModEmpTot> perAnnualEvalModEmpTots) {
       this.id = id;
       this.perFiscalDegreeCode = perFiscalDegreeCode;
       this.perGroupTypeCode = perGroupTypeCode;
       this.notes = notes;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.specialEvalFlg = specialEvalFlg;
       this.perJobCodes = perJobCodes;
       this.perAnnualEvalEmps = perAnnualEvalEmps;
       this.perAnnualEvalModelEmps = perAnnualEvalModelEmps;
       this.perHumanBalJobDistributes = perHumanBalJobDistributes;
       this.perHumanBalJobs = perHumanBalJobs;
       this.perEmpPromotions = perEmpPromotions;
       this.perAnnualEvalModEmpTots = perAnnualEvalModEmpTots;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="groupTypeCode", column=@Column(name="GROUP_TYPE_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="fiscalDegreeCode", column=@Column(name="FISCAL_DEGREE_CODE", nullable=false, length=3) ) } )
    public PerGroupDegreeId getId() {
        return this.id;
    }
    
    public void setId(PerGroupDegreeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FISCAL_DEGREE_CODE", nullable=false, insertable=false, updatable=false)
    public PerFiscalDegreeCode getPerFiscalDegreeCode() {
        return this.perFiscalDegreeCode;
    }
    
    public void setPerFiscalDegreeCode(PerFiscalDegreeCode perFiscalDegreeCode) {
        this.perFiscalDegreeCode = perFiscalDegreeCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GROUP_TYPE_CODE", nullable=false, insertable=false, updatable=false)
    public PerGroupTypeCode getPerGroupTypeCode() {
        return this.perGroupTypeCode;
    }
    
    public void setPerGroupTypeCode(PerGroupTypeCode perGroupTypeCode) {
        this.perGroupTypeCode = perGroupTypeCode;
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
    @Column(name="RECORD_UPDATE_DATE", length=7)
    public Date getRecordUpdateDate() {
        return this.recordUpdateDate;
    }
    
    public void setRecordUpdateDate(Date recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }

    
    @Column(name="SPECIAL_EVAL_FLG", precision=1, scale=0)
    public Boolean getSpecialEvalFlg() {
        return this.specialEvalFlg;
    }
    
    public void setSpecialEvalFlg(Boolean specialEvalFlg) {
        this.specialEvalFlg = specialEvalFlg;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGroupDegree")
    public Set<PerJobCode> getPerJobCodes() {
        return this.perJobCodes;
    }
    
    public void setPerJobCodes(Set<PerJobCode> perJobCodes) {
        this.perJobCodes = perJobCodes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGroupDegree")
    public Set<PerAnnualEvalEmp> getPerAnnualEvalEmps() {
        return this.perAnnualEvalEmps;
    }
    
    public void setPerAnnualEvalEmps(Set<PerAnnualEvalEmp> perAnnualEvalEmps) {
        this.perAnnualEvalEmps = perAnnualEvalEmps;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGroupDegree")
    public Set<PerAnnualEvalModelEmp> getPerAnnualEvalModelEmps() {
        return this.perAnnualEvalModelEmps;
    }
    
    public void setPerAnnualEvalModelEmps(Set<PerAnnualEvalModelEmp> perAnnualEvalModelEmps) {
        this.perAnnualEvalModelEmps = perAnnualEvalModelEmps;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGroupDegree")
    public Set<PerHumanBalJobDistribute> getPerHumanBalJobDistributes() {
        return this.perHumanBalJobDistributes;
    }
    
    public void setPerHumanBalJobDistributes(Set<PerHumanBalJobDistribute> perHumanBalJobDistributes) {
        this.perHumanBalJobDistributes = perHumanBalJobDistributes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGroupDegree")
    public Set<PerHumanBalJob> getPerHumanBalJobs() {
        return this.perHumanBalJobs;
    }
    
    public void setPerHumanBalJobs(Set<PerHumanBalJob> perHumanBalJobs) {
        this.perHumanBalJobs = perHumanBalJobs;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGroupDegree")
    public Set<PerEmpPromotion> getPerEmpPromotions() {
        return this.perEmpPromotions;
    }
    
    public void setPerEmpPromotions(Set<PerEmpPromotion> perEmpPromotions) {
        this.perEmpPromotions = perEmpPromotions;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGroupDegree")
    public Set<PerAnnualEvalModEmpTot> getPerAnnualEvalModEmpTots() {
        return this.perAnnualEvalModEmpTots;
    }
    
    public void setPerAnnualEvalModEmpTots(Set<PerAnnualEvalModEmpTot> perAnnualEvalModEmpTots) {
        this.perAnnualEvalModEmpTots = perAnnualEvalModEmpTots;
    }




}

