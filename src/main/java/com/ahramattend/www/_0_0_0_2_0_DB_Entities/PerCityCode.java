package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerCityCode generated by hbm2java
 */
@Entity
@Table(name="PER_CITY_CODE"
    ,schema="SHAMS"
)
public class PerCityCode  implements java.io.Serializable {


     private PerCityCodeId id;
     private PerGovernorateCode perGovernorateCode;
     private String ACityName;
     private boolean cityType;
     private String ECityName;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set<PerEmploymentMasters> perEmploymentMasterses = new HashSet<PerEmploymentMasters>(0);

    public PerCityCode() {
    }

	
    public PerCityCode(PerCityCodeId id, PerGovernorateCode perGovernorateCode, String ACityName, boolean cityType) {
        this.id = id;
        this.perGovernorateCode = perGovernorateCode;
        this.ACityName = ACityName;
        this.cityType = cityType;
    }
    public PerCityCode(PerCityCodeId id, PerGovernorateCode perGovernorateCode, String ACityName, boolean cityType, String ECityName, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set<PerEmploymentMasters> perEmploymentMasterses) {
       this.id = id;
       this.perGovernorateCode = perGovernorateCode;
       this.ACityName = ACityName;
       this.cityType = cityType;
       this.ECityName = ECityName;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.perEmploymentMasterses = perEmploymentMasterses;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="countryCode", column=@Column(name="COUNTRY_CODE", nullable=false, length=5) ), 
        @AttributeOverride(name="govCode", column=@Column(name="GOV_CODE", nullable=false, length=5) ), 
        @AttributeOverride(name="cityCode", column=@Column(name="CITY_CODE", nullable=false, length=5) ) } )
    public PerCityCodeId getId() {
        return this.id;
    }
    
    public void setId(PerCityCodeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="COUNTRY_CODE", referencedColumnName="COUNTRY_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="GOV_CODE", referencedColumnName="GOV_CODE", nullable=false, insertable=false, updatable=false) } )
    public PerGovernorateCode getPerGovernorateCode() {
        return this.perGovernorateCode;
    }
    
    public void setPerGovernorateCode(PerGovernorateCode perGovernorateCode) {
        this.perGovernorateCode = perGovernorateCode;
    }

    
    @Column(name="A_CITY_NAME", nullable=false, length=50)
    public String getACityName() {
        return this.ACityName;
    }
    
    public void setACityName(String ACityName) {
        this.ACityName = ACityName;
    }

    
    @Column(name="CITY_TYPE", nullable=false, precision=1, scale=0)
    public boolean isCityType() {
        return this.cityType;
    }
    
    public void setCityType(boolean cityType) {
        this.cityType = cityType;
    }

    
    @Column(name="E_CITY_NAME", length=50)
    public String getECityName() {
        return this.ECityName;
    }
    
    public void setECityName(String ECityName) {
        this.ECityName = ECityName;
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

@OneToMany(fetch=FetchType.EAGER, mappedBy="perCityCode")
    public Set<PerEmploymentMasters> getPerEmploymentMasterses() {
        return this.perEmploymentMasterses;
    }
    
    public void setPerEmploymentMasterses(Set<PerEmploymentMasters> perEmploymentMasterses) {
        this.perEmploymentMasterses = perEmploymentMasterses;
    }




}


