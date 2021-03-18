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
 * AppSubElemSpecAuth generated by hbm2java
 */
@Entity
@Table(name="APP_SUB_ELEM_SPEC_AUTH"
    ,schema="SHAMS"
)
public class AppSubElemSpecAuth  implements java.io.Serializable {


     private AppSubElemSpecAuthId id;
     private AppSubElem appSubElem;
     private PerEmploymentMasters perEmploymentMastersByEmployeeId;
     private PerEmploymentMasters perEmploymentMastersByEmployeeIdAction;
     private Date actionDate;
     private String actionDateDetails;
     private Byte primaryAuthPass;

    public AppSubElemSpecAuth() {
    }

	
    public AppSubElemSpecAuth(AppSubElemSpecAuthId id, AppSubElem appSubElem, PerEmploymentMasters perEmploymentMastersByEmployeeId) {
        this.id = id;
        this.appSubElem = appSubElem;
        this.perEmploymentMastersByEmployeeId = perEmploymentMastersByEmployeeId;
    }
    public AppSubElemSpecAuth(AppSubElemSpecAuthId id, AppSubElem appSubElem, PerEmploymentMasters perEmploymentMastersByEmployeeId, PerEmploymentMasters perEmploymentMastersByEmployeeIdAction, Date actionDate, String actionDateDetails, Byte primaryAuthPass) {
       this.id = id;
       this.appSubElem = appSubElem;
       this.perEmploymentMastersByEmployeeId = perEmploymentMastersByEmployeeId;
       this.perEmploymentMastersByEmployeeIdAction = perEmploymentMastersByEmployeeIdAction;
       this.actionDate = actionDate;
       this.actionDateDetails = actionDateDetails;
       this.primaryAuthPass = primaryAuthPass;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="applicationId", column=@Column(name="APPLICATION_ID", nullable=false, precision=3, scale=0) ), 
        @AttributeOverride(name="tabId", column=@Column(name="TAB_ID", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="subTabId", column=@Column(name="SUB_TAB_ID", nullable=false, precision=8, scale=0) ), 
        @AttributeOverride(name="elementId", column=@Column(name="ELEMENT_ID", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ) } )
    public AppSubElemSpecAuthId getId() {
        return this.id;
    }
    
    public void setId(AppSubElemSpecAuthId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="APPLICATION_ID", referencedColumnName="APPLICATION_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="TAB_ID", referencedColumnName="TAB_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="SUB_TAB_ID", referencedColumnName="SUB_TAB_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ELEMENT_ID", referencedColumnName="ELEMENT_ID", nullable=false, insertable=false, updatable=false) } )
    public AppSubElem getAppSubElem() {
        return this.appSubElem;
    }
    
    public void setAppSubElem(AppSubElem appSubElem) {
        this.appSubElem = appSubElem;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public PerEmploymentMasters getPerEmploymentMastersByEmployeeId() {
        return this.perEmploymentMastersByEmployeeId;
    }
    
    public void setPerEmploymentMastersByEmployeeId(PerEmploymentMasters perEmploymentMastersByEmployeeId) {
        this.perEmploymentMastersByEmployeeId = perEmploymentMastersByEmployeeId;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID_ACTION")
    public PerEmploymentMasters getPerEmploymentMastersByEmployeeIdAction() {
        return this.perEmploymentMastersByEmployeeIdAction;
    }
    
    public void setPerEmploymentMastersByEmployeeIdAction(PerEmploymentMasters perEmploymentMastersByEmployeeIdAction) {
        this.perEmploymentMastersByEmployeeIdAction = perEmploymentMastersByEmployeeIdAction;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ACTION_DATE", length=7)
    public Date getActionDate() {
        return this.actionDate;
    }
    
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    
    @Column(name="ACTION_DATE_DETAILS", length=25)
    public String getActionDateDetails() {
        return this.actionDateDetails;
    }
    
    public void setActionDateDetails(String actionDateDetails) {
        this.actionDateDetails = actionDateDetails;
    }

    
    @Column(name="PRIMARY_AUTH_PASS", precision=2, scale=0)
    public Byte getPrimaryAuthPass() {
        return this.primaryAuthPass;
    }
    
    public void setPrimaryAuthPass(Byte primaryAuthPass) {
        this.primaryAuthPass = primaryAuthPass;
    }




}


