package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerEasementTrans generated by hbm2java
 */
@Entity
@Table(name="PER_EASEMENT_TRANS"
    ,schema="SHAMS"
)
public class PerEasementTrans  implements java.io.Serializable {


     private PerEasementTransId id;
     private PerFiscalDegreeCode perFiscalDegreeCode;
     private PerFiscalDegreeCodeNew perFiscalDegreeCodeNew;
     private PerGeneralCode perGeneralCode;
     private PerHumanBalYear perHumanBalYear;
     private Date transDate;
     private String desicionNo;
     private Date desicionDate;
     private Date postDate;
     private byte transType;

    public PerEasementTrans() {
    }

	
    public PerEasementTrans(PerEasementTransId id, PerGeneralCode perGeneralCode, PerHumanBalYear perHumanBalYear, Date transDate, byte transType) {
        this.id = id;
        this.perGeneralCode = perGeneralCode;
        this.perHumanBalYear = perHumanBalYear;
        this.transDate = transDate;
        this.transType = transType;
    }
    public PerEasementTrans(PerEasementTransId id, PerFiscalDegreeCode perFiscalDegreeCode, PerFiscalDegreeCodeNew perFiscalDegreeCodeNew, PerGeneralCode perGeneralCode, PerHumanBalYear perHumanBalYear, Date transDate, String desicionNo, Date desicionDate, Date postDate, byte transType) {
       this.id = id;
       this.perFiscalDegreeCode = perFiscalDegreeCode;
       this.perFiscalDegreeCodeNew = perFiscalDegreeCodeNew;
       this.perGeneralCode = perGeneralCode;
       this.perHumanBalYear = perHumanBalYear;
       this.transDate = transDate;
       this.desicionNo = desicionNo;
       this.desicionDate = desicionDate;
       this.postDate = postDate;
       this.transType = transType;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="humanBalId", column=@Column(name="HUMAN_BAL_ID", nullable=false, length=5) ), 
        @AttributeOverride(name="transId", column=@Column(name="TRANS_ID", nullable=false, length=5) ) } )
    public PerEasementTransId getId() {
        return this.id;
    }
    
    public void setId(PerEasementTransId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FISCAL_DEGREE_CODE")
    public PerFiscalDegreeCode getPerFiscalDegreeCode() {
        return this.perFiscalDegreeCode;
    }
    
    public void setPerFiscalDegreeCode(PerFiscalDegreeCode perFiscalDegreeCode) {
        this.perFiscalDegreeCode = perFiscalDegreeCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FISCAL_DEGREE_CODE_NEW")
    public PerFiscalDegreeCodeNew getPerFiscalDegreeCodeNew() {
        return this.perFiscalDegreeCodeNew;
    }
    
    public void setPerFiscalDegreeCodeNew(PerFiscalDegreeCodeNew perFiscalDegreeCodeNew) {
        this.perFiscalDegreeCodeNew = perFiscalDegreeCodeNew;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GENERAL_CODE", nullable=false)
    public PerGeneralCode getPerGeneralCode() {
        return this.perGeneralCode;
    }
    
    public void setPerGeneralCode(PerGeneralCode perGeneralCode) {
        this.perGeneralCode = perGeneralCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="HUMAN_BAL_ID", referencedColumnName="HUMAN_BAL_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false) } )
    public PerHumanBalYear getPerHumanBalYear() {
        return this.perHumanBalYear;
    }
    
    public void setPerHumanBalYear(PerHumanBalYear perHumanBalYear) {
        this.perHumanBalYear = perHumanBalYear;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="TRANS_DATE", nullable=false, length=7)
    public Date getTransDate() {
        return this.transDate;
    }
    
    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    
    @Column(name="DESICION_NO", length=10)
    public String getDesicionNo() {
        return this.desicionNo;
    }
    
    public void setDesicionNo(String desicionNo) {
        this.desicionNo = desicionNo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DESICION_DATE", length=7)
    public Date getDesicionDate() {
        return this.desicionDate;
    }
    
    public void setDesicionDate(Date desicionDate) {
        this.desicionDate = desicionDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="POST_DATE", length=7)
    public Date getPostDate() {
        return this.postDate;
    }
    
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    
    @Column(name="TRANS_TYPE", nullable=false, precision=2, scale=0)
    public byte getTransType() {
        return this.transType;
    }
    
    public void setTransType(byte transType) {
        this.transType = transType;
    }




}


