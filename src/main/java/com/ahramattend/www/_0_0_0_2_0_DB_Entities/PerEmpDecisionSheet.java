package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


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

/**
 * PerEmpDecisionSheet generated by hbm2java
 */
@Entity
@Table(name="PER_EMP_DECISION_SHEET"
    ,schema="SHAMS"
)
public class PerEmpDecisionSheet  implements java.io.Serializable {


     private PerEmpDecisionSheetId id;
     private PerDecisionSheet perDecisionSheet;
     private PerEmploymentMasters perEmploymentMasters;
     private BudLocation budLocation;
     private String decisionSubject;
     private String decisionSummary;

    public PerEmpDecisionSheet() {
    }

	
    public PerEmpDecisionSheet(PerEmpDecisionSheetId id, PerDecisionSheet perDecisionSheet, PerEmploymentMasters perEmploymentMasters) {
        this.id = id;
        this.perDecisionSheet = perDecisionSheet;
        this.perEmploymentMasters = perEmploymentMasters;
    }
    public PerEmpDecisionSheet(PerEmpDecisionSheetId id, PerDecisionSheet perDecisionSheet, PerEmploymentMasters perEmploymentMasters, BudLocation budLocation, String decisionSubject, String decisionSummary) {
       this.id = id;
       this.perDecisionSheet = perDecisionSheet;
       this.perEmploymentMasters = perEmploymentMasters;
       this.budLocation = budLocation;
       this.decisionSubject = decisionSubject;
       this.decisionSummary = decisionSummary;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="decisionId", column=@Column(name="DECISION_ID", nullable=false, length=10) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ) } )
    public PerEmpDecisionSheetId getId() {
        return this.id;
    }
    
    public void setId(PerEmpDecisionSheetId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="DECISION_ID", referencedColumnName="DECISION_ID", nullable=false, insertable=false, updatable=false) } )
    public PerDecisionSheet getPerDecisionSheet() {
        return this.perDecisionSheet;
    }
    
    public void setPerDecisionSheet(PerDecisionSheet perDecisionSheet) {
        this.perDecisionSheet = perDecisionSheet;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public PerEmploymentMasters getPerEmploymentMasters() {
        return this.perEmploymentMasters;
    }
    
    public void setPerEmploymentMasters(PerEmploymentMasters perEmploymentMasters) {
        this.perEmploymentMasters = perEmploymentMasters;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="LOCATION_CODE_EMP")
    public BudLocation getBudLocation() {
        return this.budLocation;
    }
    
    public void setBudLocation(BudLocation budLocation) {
        this.budLocation = budLocation;
    }

    
    @Column(name="DECISION_SUBJECT", length=4000)
    public String getDecisionSubject() {
        return this.decisionSubject;
    }
    
    public void setDecisionSubject(String decisionSubject) {
        this.decisionSubject = decisionSubject;
    }

    
    @Column(name="DECISION_SUMMARY", length=2000)
    public String getDecisionSummary() {
        return this.decisionSummary;
    }
    
    public void setDecisionSummary(String decisionSummary) {
        this.decisionSummary = decisionSummary;
    }




}


