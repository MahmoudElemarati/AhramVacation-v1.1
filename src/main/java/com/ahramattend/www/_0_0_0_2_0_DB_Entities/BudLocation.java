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
 * BudLocation generated by hbm2java
 */
@Entity
@Table(name="BUD_LOCATION"
    ,schema="SHAMS"
)
public class BudLocation  implements java.io.Serializable {


     private String locationCode;
     private String locationName;
     private String filterLocationName;
     private String recordCreationUser;
     private Date recordCreationDate;
     private String lastUpdateUser;
     private Date lastUpdateDate;
     private String lastUpdateTransaction;
     private String locationDatabaseName;
     private Set<PerEmpHistory> perEmpHistoriesForLocationCodeFrom = new HashSet<PerEmpHistory>(0);
     private Set<PerCommityMaster> perCommityMasters = new HashSet<PerCommityMaster>(0);
     private Set<PerHumanBalYear> perHumanBalYears = new HashSet<PerHumanBalYear>(0);
     private Set<PerLocationCodes> perLocationCodeses = new HashSet<PerLocationCodes>(0);
     private Set<PerOrganizationStructure> perOrganizationStructures = new HashSet<PerOrganizationStructure>(0);
     private Set<PerEmpHistory> perEmpHistoriesForLocationCode = new HashSet<PerEmpHistory>(0);
     private Set<PerSetup> perSetups = new HashSet<PerSetup>(0);
     private Set<PerPromotionTransNew> perPromotionTransNews = new HashSet<PerPromotionTransNew>(0);
     private Set<PerEmpDecisionSheet> perEmpDecisionSheets = new HashSet<PerEmpDecisionSheet>(0);
     private Set<PerAnnualEvalYear> perAnnualEvalYears = new HashSet<PerAnnualEvalYear>(0);
     private Set<PerComplaintData> perComplaintDatas = new HashSet<PerComplaintData>(0);
     private Set<PerDecisionSheet> perDecisionSheets = new HashSet<PerDecisionSheet>(0);
     private Set<PerPromotionTrans> perPromotionTranses = new HashSet<PerPromotionTrans>(0);

    public BudLocation() {
    }

	
    public BudLocation(String locationCode) {
        this.locationCode = locationCode;
    }
    public BudLocation(String locationCode, String locationName, String filterLocationName, String recordCreationUser, Date recordCreationDate, String lastUpdateUser, Date lastUpdateDate, String lastUpdateTransaction, String locationDatabaseName, Set<PerEmpHistory> perEmpHistoriesForLocationCodeFrom, Set<PerCommityMaster> perCommityMasters, Set<PerHumanBalYear> perHumanBalYears, Set<PerLocationCodes> perLocationCodeses, Set<PerOrganizationStructure> perOrganizationStructures, Set<PerEmpHistory> perEmpHistoriesForLocationCode, Set<PerSetup> perSetups, Set<PerPromotionTransNew> perPromotionTransNews, Set<PerEmpDecisionSheet> perEmpDecisionSheets, Set<PerAnnualEvalYear> perAnnualEvalYears, Set<PerComplaintData> perComplaintDatas, Set<PerDecisionSheet> perDecisionSheets, Set<PerPromotionTrans> perPromotionTranses) {
       this.locationCode = locationCode;
       this.locationName = locationName;
       this.filterLocationName = filterLocationName;
       this.recordCreationUser = recordCreationUser;
       this.recordCreationDate = recordCreationDate;
       this.lastUpdateUser = lastUpdateUser;
       this.lastUpdateDate = lastUpdateDate;
       this.lastUpdateTransaction = lastUpdateTransaction;
       this.locationDatabaseName = locationDatabaseName;
       this.perEmpHistoriesForLocationCodeFrom = perEmpHistoriesForLocationCodeFrom;
       this.perCommityMasters = perCommityMasters;
       this.perHumanBalYears = perHumanBalYears;
       this.perLocationCodeses = perLocationCodeses;
       this.perOrganizationStructures = perOrganizationStructures;
       this.perEmpHistoriesForLocationCode = perEmpHistoriesForLocationCode;
       this.perSetups = perSetups;
       this.perPromotionTransNews = perPromotionTransNews;
       this.perEmpDecisionSheets = perEmpDecisionSheets;
       this.perAnnualEvalYears = perAnnualEvalYears;
       this.perComplaintDatas = perComplaintDatas;
       this.perDecisionSheets = perDecisionSheets;
       this.perPromotionTranses = perPromotionTranses;
    }
   
     @Id 

    
    @Column(name="LOCATION_CODE", unique=true, nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    
    @Column(name="LOCATION_NAME", length=150)
    public String getLocationName() {
        return this.locationName;
    }
    
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    
    @Column(name="FILTER_LOCATION_NAME", length=150)
    public String getFilterLocationName() {
        return this.filterLocationName;
    }
    
    public void setFilterLocationName(String filterLocationName) {
        this.filterLocationName = filterLocationName;
    }

    
    @Column(name="RECORD_CREATION_USER", length=30)
    public String getRecordCreationUser() {
        return this.recordCreationUser;
    }
    
    public void setRecordCreationUser(String recordCreationUser) {
        this.recordCreationUser = recordCreationUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_CREATION_DATE", length=7)
    public Date getRecordCreationDate() {
        return this.recordCreationDate;
    }
    
    public void setRecordCreationDate(Date recordCreationDate) {
        this.recordCreationDate = recordCreationDate;
    }

    
    @Column(name="LAST_UPDATE_USER", length=30)
    public String getLastUpdateUser() {
        return this.lastUpdateUser;
    }
    
    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LAST_UPDATE_DATE", length=7)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }
    
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    
    @Column(name="LAST_UPDATE_TRANSACTION", length=1)
    public String getLastUpdateTransaction() {
        return this.lastUpdateTransaction;
    }
    
    public void setLastUpdateTransaction(String lastUpdateTransaction) {
        this.lastUpdateTransaction = lastUpdateTransaction;
    }

    
    @Column(name="LOCATION_DATABASE_NAME", length=30)
    public String getLocationDatabaseName() {
        return this.locationDatabaseName;
    }
    
    public void setLocationDatabaseName(String locationDatabaseName) {
        this.locationDatabaseName = locationDatabaseName;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocationByLocationCodeFrom")
    public Set<PerEmpHistory> getPerEmpHistoriesForLocationCodeFrom() {
        return this.perEmpHistoriesForLocationCodeFrom;
    }
    
    public void setPerEmpHistoriesForLocationCodeFrom(Set<PerEmpHistory> perEmpHistoriesForLocationCodeFrom) {
        this.perEmpHistoriesForLocationCodeFrom = perEmpHistoriesForLocationCodeFrom;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocation")
    public Set<PerCommityMaster> getPerCommityMasters() {
        return this.perCommityMasters;
    }
    
    public void setPerCommityMasters(Set<PerCommityMaster> perCommityMasters) {
        this.perCommityMasters = perCommityMasters;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocation")
    public Set<PerHumanBalYear> getPerHumanBalYears() {
        return this.perHumanBalYears;
    }
    
    public void setPerHumanBalYears(Set<PerHumanBalYear> perHumanBalYears) {
        this.perHumanBalYears = perHumanBalYears;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocation")
    public Set<PerLocationCodes> getPerLocationCodeses() {
        return this.perLocationCodeses;
    }
    
    public void setPerLocationCodeses(Set<PerLocationCodes> perLocationCodeses) {
        this.perLocationCodeses = perLocationCodeses;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocation")
    public Set<PerOrganizationStructure> getPerOrganizationStructures() {
        return this.perOrganizationStructures;
    }
    
    public void setPerOrganizationStructures(Set<PerOrganizationStructure> perOrganizationStructures) {
        this.perOrganizationStructures = perOrganizationStructures;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocationByLocationCode")
    public Set<PerEmpHistory> getPerEmpHistoriesForLocationCode() {
        return this.perEmpHistoriesForLocationCode;
    }
    
    public void setPerEmpHistoriesForLocationCode(Set<PerEmpHistory> perEmpHistoriesForLocationCode) {
        this.perEmpHistoriesForLocationCode = perEmpHistoriesForLocationCode;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocation")
    public Set<PerSetup> getPerSetups() {
        return this.perSetups;
    }
    
    public void setPerSetups(Set<PerSetup> perSetups) {
        this.perSetups = perSetups;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocation")
    public Set<PerPromotionTransNew> getPerPromotionTransNews() {
        return this.perPromotionTransNews;
    }
    
    public void setPerPromotionTransNews(Set<PerPromotionTransNew> perPromotionTransNews) {
        this.perPromotionTransNews = perPromotionTransNews;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocation")
    public Set<PerEmpDecisionSheet> getPerEmpDecisionSheets() {
        return this.perEmpDecisionSheets;
    }
    
    public void setPerEmpDecisionSheets(Set<PerEmpDecisionSheet> perEmpDecisionSheets) {
        this.perEmpDecisionSheets = perEmpDecisionSheets;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocation")
    public Set<PerAnnualEvalYear> getPerAnnualEvalYears() {
        return this.perAnnualEvalYears;
    }
    
    public void setPerAnnualEvalYears(Set<PerAnnualEvalYear> perAnnualEvalYears) {
        this.perAnnualEvalYears = perAnnualEvalYears;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocation")
    public Set<PerComplaintData> getPerComplaintDatas() {
        return this.perComplaintDatas;
    }
    
    public void setPerComplaintDatas(Set<PerComplaintData> perComplaintDatas) {
        this.perComplaintDatas = perComplaintDatas;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocation")
    public Set<PerDecisionSheet> getPerDecisionSheets() {
        return this.perDecisionSheets;
    }
    
    public void setPerDecisionSheets(Set<PerDecisionSheet> perDecisionSheets) {
        this.perDecisionSheets = perDecisionSheets;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="budLocation")
    public Set<PerPromotionTrans> getPerPromotionTranses() {
        return this.perPromotionTranses;
    }
    
    public void setPerPromotionTranses(Set<PerPromotionTrans> perPromotionTranses) {
        this.perPromotionTranses = perPromotionTranses;
    }




}


