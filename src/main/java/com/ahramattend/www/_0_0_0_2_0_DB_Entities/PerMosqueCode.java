package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerMosqueCode generated by hbm2java
 */
@Entity
@Table(name="PER_MOSQUE_CODE"
    ,schema="SHAMS"
)
public class PerMosqueCode  implements java.io.Serializable {


     private String mosqueCode;
     private PerLocationCodeDepartment perLocationCodeDepartment;
     private PerMosqueGehaCode perMosqueGehaCode;
     private PerMosqueKindCode perMosqueKindCode;
     private String mosqueName;
     private Date receivingDate;
     private String mosqueAddress;
     private String telephoneNo;
     private Boolean mosqueType;
     private Boolean mosquePlace;
     private Boolean mosqueKind;
     private BigDecimal mosqueArea;
     private BigDecimal prayArea;
     private String mosqueLimits;
     private String desicionNumber;
     private Date decisionDate;
     private Set<PerEmploymentMasters> perEmploymentMasterses = new HashSet<PerEmploymentMasters>(0);
     private Set<PerEmpHistory> perEmpHistories = new HashSet<PerEmpHistory>(0);

    public PerMosqueCode() {
    }

	
    public PerMosqueCode(String mosqueCode, PerLocationCodeDepartment perLocationCodeDepartment, PerMosqueKindCode perMosqueKindCode, String mosqueName) {
        this.mosqueCode = mosqueCode;
        this.perLocationCodeDepartment = perLocationCodeDepartment;
        this.perMosqueKindCode = perMosqueKindCode;
        this.mosqueName = mosqueName;
    }
    public PerMosqueCode(String mosqueCode, PerLocationCodeDepartment perLocationCodeDepartment, PerMosqueGehaCode perMosqueGehaCode, PerMosqueKindCode perMosqueKindCode, String mosqueName, Date receivingDate, String mosqueAddress, String telephoneNo, Boolean mosqueType, Boolean mosquePlace, Boolean mosqueKind, BigDecimal mosqueArea, BigDecimal prayArea, String mosqueLimits, String desicionNumber, Date decisionDate, Set<PerEmploymentMasters> perEmploymentMasterses, Set<PerEmpHistory> perEmpHistories) {
       this.mosqueCode = mosqueCode;
       this.perLocationCodeDepartment = perLocationCodeDepartment;
       this.perMosqueGehaCode = perMosqueGehaCode;
       this.perMosqueKindCode = perMosqueKindCode;
       this.mosqueName = mosqueName;
       this.receivingDate = receivingDate;
       this.mosqueAddress = mosqueAddress;
       this.telephoneNo = telephoneNo;
       this.mosqueType = mosqueType;
       this.mosquePlace = mosquePlace;
       this.mosqueKind = mosqueKind;
       this.mosqueArea = mosqueArea;
       this.prayArea = prayArea;
       this.mosqueLimits = mosqueLimits;
       this.desicionNumber = desicionNumber;
       this.decisionDate = decisionDate;
       this.perEmploymentMasterses = perEmploymentMasterses;
       this.perEmpHistories = perEmpHistories;
    }
   
     @Id 

    
    @Column(name="MOSQUE_CODE", unique=true, nullable=false, length=10)
    public String getMosqueCode() {
        return this.mosqueCode;
    }
    
    public void setMosqueCode(String mosqueCode) {
        this.mosqueCode = mosqueCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false), 
        @JoinColumn(name="LOC_CODE", referencedColumnName="LOC_CODE", nullable=false), 
        @JoinColumn(name="DEPARTMENT_SEQ", referencedColumnName="DEPARTMENT_SEQ", nullable=false) } )
    public PerLocationCodeDepartment getPerLocationCodeDepartment() {
        return this.perLocationCodeDepartment;
    }
    
    public void setPerLocationCodeDepartment(PerLocationCodeDepartment perLocationCodeDepartment) {
        this.perLocationCodeDepartment = perLocationCodeDepartment;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GEHA_CODE")
    public PerMosqueGehaCode getPerMosqueGehaCode() {
        return this.perMosqueGehaCode;
    }
    
    public void setPerMosqueGehaCode(PerMosqueGehaCode perMosqueGehaCode) {
        this.perMosqueGehaCode = perMosqueGehaCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="KIND_CODE", nullable=false)
    public PerMosqueKindCode getPerMosqueKindCode() {
        return this.perMosqueKindCode;
    }
    
    public void setPerMosqueKindCode(PerMosqueKindCode perMosqueKindCode) {
        this.perMosqueKindCode = perMosqueKindCode;
    }

    
    @Column(name="MOSQUE_NAME", nullable=false, length=100)
    public String getMosqueName() {
        return this.mosqueName;
    }
    
    public void setMosqueName(String mosqueName) {
        this.mosqueName = mosqueName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECEIVING_DATE", length=7)
    public Date getReceivingDate() {
        return this.receivingDate;
    }
    
    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    
    @Column(name="MOSQUE_ADDRESS", length=300)
    public String getMosqueAddress() {
        return this.mosqueAddress;
    }
    
    public void setMosqueAddress(String mosqueAddress) {
        this.mosqueAddress = mosqueAddress;
    }

    
    @Column(name="TELEPHONE_NO", length=9)
    public String getTelephoneNo() {
        return this.telephoneNo;
    }
    
    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    
    @Column(name="MOSQUE_TYPE", precision=1, scale=0)
    public Boolean getMosqueType() {
        return this.mosqueType;
    }
    
    public void setMosqueType(Boolean mosqueType) {
        this.mosqueType = mosqueType;
    }

    
    @Column(name="MOSQUE_PLACE", precision=1, scale=0)
    public Boolean getMosquePlace() {
        return this.mosquePlace;
    }
    
    public void setMosquePlace(Boolean mosquePlace) {
        this.mosquePlace = mosquePlace;
    }

    
    @Column(name="MOSQUE_KIND", precision=1, scale=0)
    public Boolean getMosqueKind() {
        return this.mosqueKind;
    }
    
    public void setMosqueKind(Boolean mosqueKind) {
        this.mosqueKind = mosqueKind;
    }

    
    @Column(name="MOSQUE_AREA", precision=12, scale=4)
    public BigDecimal getMosqueArea() {
        return this.mosqueArea;
    }
    
    public void setMosqueArea(BigDecimal mosqueArea) {
        this.mosqueArea = mosqueArea;
    }

    
    @Column(name="PRAY_AREA", precision=12, scale=4)
    public BigDecimal getPrayArea() {
        return this.prayArea;
    }
    
    public void setPrayArea(BigDecimal prayArea) {
        this.prayArea = prayArea;
    }

    
    @Column(name="MOSQUE_LIMITS")
    public String getMosqueLimits() {
        return this.mosqueLimits;
    }
    
    public void setMosqueLimits(String mosqueLimits) {
        this.mosqueLimits = mosqueLimits;
    }

    
    @Column(name="DESICION_NUMBER", length=15)
    public String getDesicionNumber() {
        return this.desicionNumber;
    }
    
    public void setDesicionNumber(String desicionNumber) {
        this.desicionNumber = desicionNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DECISION_DATE", length=7)
    public Date getDecisionDate() {
        return this.decisionDate;
    }
    
    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perMosqueCode")
    public Set<PerEmploymentMasters> getPerEmploymentMasterses() {
        return this.perEmploymentMasterses;
    }
    
    public void setPerEmploymentMasterses(Set<PerEmploymentMasters> perEmploymentMasterses) {
        this.perEmploymentMasterses = perEmploymentMasterses;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perMosqueCode")
    public Set<PerEmpHistory> getPerEmpHistories() {
        return this.perEmpHistories;
    }
    
    public void setPerEmpHistories(Set<PerEmpHistory> perEmpHistories) {
        this.perEmpHistories = perEmpHistories;
    }




}


