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
 * PerOrgunitCode generated by hbm2java
 */
@Entity
@Table(name="PER_ORGUNIT_CODE"
    ,schema="SHAMS"
)
public class PerOrgunitCode  implements java.io.Serializable {


     private String orgunitCode;
     private String orgunitName;
     private byte orgunitOrder;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set<PerHumanBalJobDistribute> perHumanBalJobDistributesForOrgunitCodeMinus = new HashSet<PerHumanBalJobDistribute>(0);
     private Set<PerHumanBalOrg> perHumanBalOrgs = new HashSet<PerHumanBalOrg>(0);
     private Set<PerComplaintData> perComplaintDatasForOrgunitCodeExec = new HashSet<PerComplaintData>(0);
     private Set<PerEmpHistory> perEmpHistoriesForOrgunitCodeFrom = new HashSet<PerEmpHistory>(0);
     private Set<PerHumanBalOrgNew> perHumanBalOrgNews = new HashSet<PerHumanBalOrgNew>(0);
     private Set<PerHumanPlan> perHumanPlans = new HashSet<PerHumanPlan>(0);
     private Set<PerAnnualEval> perAnnualEvals = new HashSet<PerAnnualEval>(0);
     private Set<PerAnnualEvalModel> perAnnualEvalModels = new HashSet<PerAnnualEvalModel>(0);
     private Set<PerHumanBalJobDistributeN> perHumanBalJobDistributeNsForOrgunitCodeMinus = new HashSet<PerHumanBalJobDistributeN>(0);
     private Set<PerOrganizationStructure> perOrganizationStructures = new HashSet<PerOrganizationStructure>(0);
     private Set<PerComplaintData> perComplaintDatasForOrgunitCode = new HashSet<PerComplaintData>(0);
     private Set<PerEmploymentMasters> perEmploymentMastersesForOrgunitCode = new HashSet<PerEmploymentMasters>(0);
     private Set<PerEmpHistory> perEmpHistoriesForOrgunitCode = new HashSet<PerEmpHistory>(0);
     private Set<PerHumanBalJobDistributeN> perHumanBalJobDistributeNsForOrgunitCode = new HashSet<PerHumanBalJobDistributeN>(0);
     private Set<PerHumanBalJobDistribute> perHumanBalJobDistributesForOrgunitCode = new HashSet<PerHumanBalJobDistribute>(0);
     private Set<PerEmploymentMasters> perEmploymentMastersesForOrgunitCodeFrom = new HashSet<PerEmploymentMasters>(0);

    public PerOrgunitCode() {
    }

	
    public PerOrgunitCode(String orgunitCode, String orgunitName, byte orgunitOrder) {
        this.orgunitCode = orgunitCode;
        this.orgunitName = orgunitName;
        this.orgunitOrder = orgunitOrder;
    }
    public PerOrgunitCode(String orgunitCode, String orgunitName, byte orgunitOrder, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set<PerHumanBalJobDistribute> perHumanBalJobDistributesForOrgunitCodeMinus, Set<PerHumanBalOrg> perHumanBalOrgs, Set<PerComplaintData> perComplaintDatasForOrgunitCodeExec, Set<PerEmpHistory> perEmpHistoriesForOrgunitCodeFrom, Set<PerHumanBalOrgNew> perHumanBalOrgNews, Set<PerHumanPlan> perHumanPlans, Set<PerAnnualEval> perAnnualEvals, Set<PerAnnualEvalModel> perAnnualEvalModels, Set<PerHumanBalJobDistributeN> perHumanBalJobDistributeNsForOrgunitCodeMinus, Set<PerOrganizationStructure> perOrganizationStructures, Set<PerComplaintData> perComplaintDatasForOrgunitCode, Set<PerEmploymentMasters> perEmploymentMastersesForOrgunitCode, Set<PerEmpHistory> perEmpHistoriesForOrgunitCode, Set<PerHumanBalJobDistributeN> perHumanBalJobDistributeNsForOrgunitCode, Set<PerHumanBalJobDistribute> perHumanBalJobDistributesForOrgunitCode, Set<PerEmploymentMasters> perEmploymentMastersesForOrgunitCodeFrom) {
       this.orgunitCode = orgunitCode;
       this.orgunitName = orgunitName;
       this.orgunitOrder = orgunitOrder;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.perHumanBalJobDistributesForOrgunitCodeMinus = perHumanBalJobDistributesForOrgunitCodeMinus;
       this.perHumanBalOrgs = perHumanBalOrgs;
       this.perComplaintDatasForOrgunitCodeExec = perComplaintDatasForOrgunitCodeExec;
       this.perEmpHistoriesForOrgunitCodeFrom = perEmpHistoriesForOrgunitCodeFrom;
       this.perHumanBalOrgNews = perHumanBalOrgNews;
       this.perHumanPlans = perHumanPlans;
       this.perAnnualEvals = perAnnualEvals;
       this.perAnnualEvalModels = perAnnualEvalModels;
       this.perHumanBalJobDistributeNsForOrgunitCodeMinus = perHumanBalJobDistributeNsForOrgunitCodeMinus;
       this.perOrganizationStructures = perOrganizationStructures;
       this.perComplaintDatasForOrgunitCode = perComplaintDatasForOrgunitCode;
       this.perEmploymentMastersesForOrgunitCode = perEmploymentMastersesForOrgunitCode;
       this.perEmpHistoriesForOrgunitCode = perEmpHistoriesForOrgunitCode;
       this.perHumanBalJobDistributeNsForOrgunitCode = perHumanBalJobDistributeNsForOrgunitCode;
       this.perHumanBalJobDistributesForOrgunitCode = perHumanBalJobDistributesForOrgunitCode;
       this.perEmploymentMastersesForOrgunitCodeFrom = perEmploymentMastersesForOrgunitCodeFrom;
    }
   
     @Id 

    
    @Column(name="ORGUNIT_CODE", unique=true, nullable=false, length=3)
    public String getOrgunitCode() {
        return this.orgunitCode;
    }
    
    public void setOrgunitCode(String orgunitCode) {
        this.orgunitCode = orgunitCode;
    }

    
    @Column(name="ORGUNIT_NAME", nullable=false, length=50)
    public String getOrgunitName() {
        return this.orgunitName;
    }
    
    public void setOrgunitName(String orgunitName) {
        this.orgunitName = orgunitName;
    }

    
    @Column(name="ORGUNIT_ORDER", nullable=false, precision=2, scale=0)
    public byte getOrgunitOrder() {
        return this.orgunitOrder;
    }
    
    public void setOrgunitOrder(byte orgunitOrder) {
        this.orgunitOrder = orgunitOrder;
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

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCodeByOrgunitCodeMinus")
    public Set<PerHumanBalJobDistribute> getPerHumanBalJobDistributesForOrgunitCodeMinus() {
        return this.perHumanBalJobDistributesForOrgunitCodeMinus;
    }
    
    public void setPerHumanBalJobDistributesForOrgunitCodeMinus(Set<PerHumanBalJobDistribute> perHumanBalJobDistributesForOrgunitCodeMinus) {
        this.perHumanBalJobDistributesForOrgunitCodeMinus = perHumanBalJobDistributesForOrgunitCodeMinus;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCode")
    public Set<PerHumanBalOrg> getPerHumanBalOrgs() {
        return this.perHumanBalOrgs;
    }
    
    public void setPerHumanBalOrgs(Set<PerHumanBalOrg> perHumanBalOrgs) {
        this.perHumanBalOrgs = perHumanBalOrgs;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCodeByOrgunitCodeExec")
    public Set<PerComplaintData> getPerComplaintDatasForOrgunitCodeExec() {
        return this.perComplaintDatasForOrgunitCodeExec;
    }
    
    public void setPerComplaintDatasForOrgunitCodeExec(Set<PerComplaintData> perComplaintDatasForOrgunitCodeExec) {
        this.perComplaintDatasForOrgunitCodeExec = perComplaintDatasForOrgunitCodeExec;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCodeByOrgunitCodeFrom")
    public Set<PerEmpHistory> getPerEmpHistoriesForOrgunitCodeFrom() {
        return this.perEmpHistoriesForOrgunitCodeFrom;
    }
    
    public void setPerEmpHistoriesForOrgunitCodeFrom(Set<PerEmpHistory> perEmpHistoriesForOrgunitCodeFrom) {
        this.perEmpHistoriesForOrgunitCodeFrom = perEmpHistoriesForOrgunitCodeFrom;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCode")
    public Set<PerHumanBalOrgNew> getPerHumanBalOrgNews() {
        return this.perHumanBalOrgNews;
    }
    
    public void setPerHumanBalOrgNews(Set<PerHumanBalOrgNew> perHumanBalOrgNews) {
        this.perHumanBalOrgNews = perHumanBalOrgNews;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCode")
    public Set<PerHumanPlan> getPerHumanPlans() {
        return this.perHumanPlans;
    }
    
    public void setPerHumanPlans(Set<PerHumanPlan> perHumanPlans) {
        this.perHumanPlans = perHumanPlans;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCode")
    public Set<PerAnnualEval> getPerAnnualEvals() {
        return this.perAnnualEvals;
    }
    
    public void setPerAnnualEvals(Set<PerAnnualEval> perAnnualEvals) {
        this.perAnnualEvals = perAnnualEvals;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCode")
    public Set<PerAnnualEvalModel> getPerAnnualEvalModels() {
        return this.perAnnualEvalModels;
    }
    
    public void setPerAnnualEvalModels(Set<PerAnnualEvalModel> perAnnualEvalModels) {
        this.perAnnualEvalModels = perAnnualEvalModels;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCodeByOrgunitCodeMinus")
    public Set<PerHumanBalJobDistributeN> getPerHumanBalJobDistributeNsForOrgunitCodeMinus() {
        return this.perHumanBalJobDistributeNsForOrgunitCodeMinus;
    }
    
    public void setPerHumanBalJobDistributeNsForOrgunitCodeMinus(Set<PerHumanBalJobDistributeN> perHumanBalJobDistributeNsForOrgunitCodeMinus) {
        this.perHumanBalJobDistributeNsForOrgunitCodeMinus = perHumanBalJobDistributeNsForOrgunitCodeMinus;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCode")
    public Set<PerOrganizationStructure> getPerOrganizationStructures() {
        return this.perOrganizationStructures;
    }
    
    public void setPerOrganizationStructures(Set<PerOrganizationStructure> perOrganizationStructures) {
        this.perOrganizationStructures = perOrganizationStructures;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCodeByOrgunitCode")
    public Set<PerComplaintData> getPerComplaintDatasForOrgunitCode() {
        return this.perComplaintDatasForOrgunitCode;
    }
    
    public void setPerComplaintDatasForOrgunitCode(Set<PerComplaintData> perComplaintDatasForOrgunitCode) {
        this.perComplaintDatasForOrgunitCode = perComplaintDatasForOrgunitCode;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCodeByOrgunitCode")
    public Set<PerEmploymentMasters> getPerEmploymentMastersesForOrgunitCode() {
        return this.perEmploymentMastersesForOrgunitCode;
    }
    
    public void setPerEmploymentMastersesForOrgunitCode(Set<PerEmploymentMasters> perEmploymentMastersesForOrgunitCode) {
        this.perEmploymentMastersesForOrgunitCode = perEmploymentMastersesForOrgunitCode;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCodeByOrgunitCode")
    public Set<PerEmpHistory> getPerEmpHistoriesForOrgunitCode() {
        return this.perEmpHistoriesForOrgunitCode;
    }
    
    public void setPerEmpHistoriesForOrgunitCode(Set<PerEmpHistory> perEmpHistoriesForOrgunitCode) {
        this.perEmpHistoriesForOrgunitCode = perEmpHistoriesForOrgunitCode;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCodeByOrgunitCode")
    public Set<PerHumanBalJobDistributeN> getPerHumanBalJobDistributeNsForOrgunitCode() {
        return this.perHumanBalJobDistributeNsForOrgunitCode;
    }
    
    public void setPerHumanBalJobDistributeNsForOrgunitCode(Set<PerHumanBalJobDistributeN> perHumanBalJobDistributeNsForOrgunitCode) {
        this.perHumanBalJobDistributeNsForOrgunitCode = perHumanBalJobDistributeNsForOrgunitCode;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCodeByOrgunitCode")
    public Set<PerHumanBalJobDistribute> getPerHumanBalJobDistributesForOrgunitCode() {
        return this.perHumanBalJobDistributesForOrgunitCode;
    }
    
    public void setPerHumanBalJobDistributesForOrgunitCode(Set<PerHumanBalJobDistribute> perHumanBalJobDistributesForOrgunitCode) {
        this.perHumanBalJobDistributesForOrgunitCode = perHumanBalJobDistributesForOrgunitCode;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perOrgunitCodeByOrgunitCodeFrom")
    public Set<PerEmploymentMasters> getPerEmploymentMastersesForOrgunitCodeFrom() {
        return this.perEmploymentMastersesForOrgunitCodeFrom;
    }
    
    public void setPerEmploymentMastersesForOrgunitCodeFrom(Set<PerEmploymentMasters> perEmploymentMastersesForOrgunitCodeFrom) {
        this.perEmploymentMastersesForOrgunitCodeFrom = perEmploymentMastersesForOrgunitCodeFrom;
    }




}


