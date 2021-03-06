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
 * PerComplaintData generated by hbm2java
 */
@Entity
@Table(name="PER_COMPLAINT_DATA"
    ,schema="SHAMS"
)
public class PerComplaintData  implements java.io.Serializable {


     private PerComplaintDataId id;
     private PerComplaintCode perComplaintCode;
     private PerDesicionSideCode perDesicionSideCode;
     private PerEmploymentMasters perEmploymentMasters;
     private PerOrganizationStructure perOrganizationStructureByOrgIdExec;
     private PerOrganizationStructure perOrganizationStructureByOrgId;
     private PerOrgunitCode perOrgunitCodeByOrgunitCodeExec;
     private PerOrgunitCode perOrgunitCodeByOrgunitCode;
     private BudLocation budLocation;
     private Date complaintDate;
     private boolean complaintSide;
     private String complaintSubject;
     private String notebookNo;
     private Date notebookDate;
     private String notebookSubject;
     private String decisionNo;
     private Date decisionDate;
     private String decisionSubject;

    public PerComplaintData() {
    }

	
    public PerComplaintData(PerComplaintDataId id, PerComplaintCode perComplaintCode, BudLocation budLocation, Date complaintDate, boolean complaintSide) {
        this.id = id;
        this.perComplaintCode = perComplaintCode;
        this.budLocation = budLocation;
        this.complaintDate = complaintDate;
        this.complaintSide = complaintSide;
    }
    public PerComplaintData(PerComplaintDataId id, PerComplaintCode perComplaintCode, PerDesicionSideCode perDesicionSideCode, PerEmploymentMasters perEmploymentMasters, PerOrganizationStructure perOrganizationStructureByOrgIdExec, PerOrganizationStructure perOrganizationStructureByOrgId, PerOrgunitCode perOrgunitCodeByOrgunitCodeExec, PerOrgunitCode perOrgunitCodeByOrgunitCode, BudLocation budLocation, Date complaintDate, boolean complaintSide, String complaintSubject, String notebookNo, Date notebookDate, String notebookSubject, String decisionNo, Date decisionDate, String decisionSubject) {
       this.id = id;
       this.perComplaintCode = perComplaintCode;
       this.perDesicionSideCode = perDesicionSideCode;
       this.perEmploymentMasters = perEmploymentMasters;
       this.perOrganizationStructureByOrgIdExec = perOrganizationStructureByOrgIdExec;
       this.perOrganizationStructureByOrgId = perOrganizationStructureByOrgId;
       this.perOrgunitCodeByOrgunitCodeExec = perOrgunitCodeByOrgunitCodeExec;
       this.perOrgunitCodeByOrgunitCode = perOrgunitCodeByOrgunitCode;
       this.budLocation = budLocation;
       this.complaintDate = complaintDate;
       this.complaintSide = complaintSide;
       this.complaintSubject = complaintSubject;
       this.notebookNo = notebookNo;
       this.notebookDate = notebookDate;
       this.notebookSubject = notebookSubject;
       this.decisionNo = decisionNo;
       this.decisionDate = decisionDate;
       this.decisionSubject = decisionSubject;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="complaintId", column=@Column(name="COMPLAINT_ID", nullable=false, length=10) ) } )
    public PerComplaintDataId getId() {
        return this.id;
    }
    
    public void setId(PerComplaintDataId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="COMPLAINT_CODE", nullable=false)
    public PerComplaintCode getPerComplaintCode() {
        return this.perComplaintCode;
    }
    
    public void setPerComplaintCode(PerComplaintCode perComplaintCode) {
        this.perComplaintCode = perComplaintCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="DESICION_SIDE_CODE")
    public PerDesicionSideCode getPerDesicionSideCode() {
        return this.perDesicionSideCode;
    }
    
    public void setPerDesicionSideCode(PerDesicionSideCode perDesicionSideCode) {
        this.perDesicionSideCode = perDesicionSideCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID")
    public PerEmploymentMasters getPerEmploymentMasters() {
        return this.perEmploymentMasters;
    }
    
    public void setPerEmploymentMasters(PerEmploymentMasters perEmploymentMasters) {
        this.perEmploymentMasters = perEmploymentMasters;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ORG_ID_EXEC")
    public PerOrganizationStructure getPerOrganizationStructureByOrgIdExec() {
        return this.perOrganizationStructureByOrgIdExec;
    }
    
    public void setPerOrganizationStructureByOrgIdExec(PerOrganizationStructure perOrganizationStructureByOrgIdExec) {
        this.perOrganizationStructureByOrgIdExec = perOrganizationStructureByOrgIdExec;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ORG_ID")
    public PerOrganizationStructure getPerOrganizationStructureByOrgId() {
        return this.perOrganizationStructureByOrgId;
    }
    
    public void setPerOrganizationStructureByOrgId(PerOrganizationStructure perOrganizationStructureByOrgId) {
        this.perOrganizationStructureByOrgId = perOrganizationStructureByOrgId;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ORGUNIT_CODE_EXEC")
    public PerOrgunitCode getPerOrgunitCodeByOrgunitCodeExec() {
        return this.perOrgunitCodeByOrgunitCodeExec;
    }
    
    public void setPerOrgunitCodeByOrgunitCodeExec(PerOrgunitCode perOrgunitCodeByOrgunitCodeExec) {
        this.perOrgunitCodeByOrgunitCodeExec = perOrgunitCodeByOrgunitCodeExec;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ORGUNIT_CODE")
    public PerOrgunitCode getPerOrgunitCodeByOrgunitCode() {
        return this.perOrgunitCodeByOrgunitCode;
    }
    
    public void setPerOrgunitCodeByOrgunitCode(PerOrgunitCode perOrgunitCodeByOrgunitCode) {
        this.perOrgunitCodeByOrgunitCode = perOrgunitCodeByOrgunitCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="LOCATION_CODE", nullable=false, insertable=false, updatable=false)
    public BudLocation getBudLocation() {
        return this.budLocation;
    }
    
    public void setBudLocation(BudLocation budLocation) {
        this.budLocation = budLocation;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="COMPLAINT_DATE", nullable=false, length=7)
    public Date getComplaintDate() {
        return this.complaintDate;
    }
    
    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    
    @Column(name="COMPLAINT_SIDE", nullable=false, precision=1, scale=0)
    public boolean isComplaintSide() {
        return this.complaintSide;
    }
    
    public void setComplaintSide(boolean complaintSide) {
        this.complaintSide = complaintSide;
    }

    
    @Column(name="COMPLAINT_SUBJECT", length=250)
    public String getComplaintSubject() {
        return this.complaintSubject;
    }
    
    public void setComplaintSubject(String complaintSubject) {
        this.complaintSubject = complaintSubject;
    }

    
    @Column(name="NOTEBOOK_NO", length=10)
    public String getNotebookNo() {
        return this.notebookNo;
    }
    
    public void setNotebookNo(String notebookNo) {
        this.notebookNo = notebookNo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="NOTEBOOK_DATE", length=7)
    public Date getNotebookDate() {
        return this.notebookDate;
    }
    
    public void setNotebookDate(Date notebookDate) {
        this.notebookDate = notebookDate;
    }

    
    @Column(name="NOTEBOOK_SUBJECT", length=250)
    public String getNotebookSubject() {
        return this.notebookSubject;
    }
    
    public void setNotebookSubject(String notebookSubject) {
        this.notebookSubject = notebookSubject;
    }

    
    @Column(name="DECISION_NO", length=10)
    public String getDecisionNo() {
        return this.decisionNo;
    }
    
    public void setDecisionNo(String decisionNo) {
        this.decisionNo = decisionNo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DECISION_DATE", length=7)
    public Date getDecisionDate() {
        return this.decisionDate;
    }
    
    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

    
    @Column(name="DECISION_SUBJECT", length=250)
    public String getDecisionSubject() {
        return this.decisionSubject;
    }
    
    public void setDecisionSubject(String decisionSubject) {
        this.decisionSubject = decisionSubject;
    }




}


