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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerHumanActivity generated by hbm2java
 */
@Entity
@Table(name="PER_HUMAN_ACTIVITY"
    ,schema="SHAMS"
)
public class PerHumanActivity  implements java.io.Serializable {


     private PerHumanActivityId id;
     private PerHumanPlan perHumanPlan;
     private String actDescription;
     private Date planStartdate;
     private Date planEnddate;
     private Date actualStartdate;
     private Date actualEnddate;
     private String actNote;
     private Set<PerHumanActivityFollow> perHumanActivityFollows = new HashSet<PerHumanActivityFollow>(0);

    public PerHumanActivity() {
    }

	
    public PerHumanActivity(PerHumanActivityId id, PerHumanPlan perHumanPlan, String actDescription, Date planStartdate, Date planEnddate) {
        this.id = id;
        this.perHumanPlan = perHumanPlan;
        this.actDescription = actDescription;
        this.planStartdate = planStartdate;
        this.planEnddate = planEnddate;
    }
    public PerHumanActivity(PerHumanActivityId id, PerHumanPlan perHumanPlan, String actDescription, Date planStartdate, Date planEnddate, Date actualStartdate, Date actualEnddate, String actNote, Set<PerHumanActivityFollow> perHumanActivityFollows) {
       this.id = id;
       this.perHumanPlan = perHumanPlan;
       this.actDescription = actDescription;
       this.planStartdate = planStartdate;
       this.planEnddate = planEnddate;
       this.actualStartdate = actualStartdate;
       this.actualEnddate = actualEnddate;
       this.actNote = actNote;
       this.perHumanActivityFollows = perHumanActivityFollows;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="humanBalId", column=@Column(name="HUMAN_BAL_ID", nullable=false, length=5) ), 
        @AttributeOverride(name="orgId", column=@Column(name="ORG_ID", nullable=false, length=5) ), 
        @AttributeOverride(name="actSerialNo", column=@Column(name="ACT_SERIAL_NO", nullable=false, length=3) ) } )
    public PerHumanActivityId getId() {
        return this.id;
    }
    
    public void setId(PerHumanActivityId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="HUMAN_BAL_ID", referencedColumnName="HUMAN_BAL_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ORG_ID", referencedColumnName="ORG_ID", nullable=false, insertable=false, updatable=false) } )
    public PerHumanPlan getPerHumanPlan() {
        return this.perHumanPlan;
    }
    
    public void setPerHumanPlan(PerHumanPlan perHumanPlan) {
        this.perHumanPlan = perHumanPlan;
    }

    
    @Column(name="ACT_DESCRIPTION", nullable=false, length=150)
    public String getActDescription() {
        return this.actDescription;
    }
    
    public void setActDescription(String actDescription) {
        this.actDescription = actDescription;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PLAN_STARTDATE", nullable=false, length=7)
    public Date getPlanStartdate() {
        return this.planStartdate;
    }
    
    public void setPlanStartdate(Date planStartdate) {
        this.planStartdate = planStartdate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PLAN_ENDDATE", nullable=false, length=7)
    public Date getPlanEnddate() {
        return this.planEnddate;
    }
    
    public void setPlanEnddate(Date planEnddate) {
        this.planEnddate = planEnddate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ACTUAL_STARTDATE", length=7)
    public Date getActualStartdate() {
        return this.actualStartdate;
    }
    
    public void setActualStartdate(Date actualStartdate) {
        this.actualStartdate = actualStartdate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ACTUAL_ENDDATE", length=7)
    public Date getActualEnddate() {
        return this.actualEnddate;
    }
    
    public void setActualEnddate(Date actualEnddate) {
        this.actualEnddate = actualEnddate;
    }

    
    @Column(name="ACT_NOTE", length=50)
    public String getActNote() {
        return this.actNote;
    }
    
    public void setActNote(String actNote) {
        this.actNote = actNote;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perHumanActivity")
    public Set<PerHumanActivityFollow> getPerHumanActivityFollows() {
        return this.perHumanActivityFollows;
    }
    
    public void setPerHumanActivityFollows(Set<PerHumanActivityFollow> perHumanActivityFollows) {
        this.perHumanActivityFollows = perHumanActivityFollows;
    }




}


