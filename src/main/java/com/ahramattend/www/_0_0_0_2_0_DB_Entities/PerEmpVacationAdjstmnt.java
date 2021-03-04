package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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
 * PerEmpVacationAdjstmnt generated by hbm2java
 */
@Entity
@Table(name="PER_EMP_VACATION_ADJSTMNT"
    ,schema="SHAMS"
)
public class PerEmpVacationAdjstmnt  implements java.io.Serializable {


     private PerEmpVacationAdjstmntId id;
     private PerEmpVacationTrans perEmpVacationTrans;
     private boolean adjType;
     private Date adjStartDate;
     private Date adjEndDate;
     private Boolean directBossApprove;
     private Boolean bigBossApprove;
     private String decisionNo;
     private Date decisionDate;
     private Date adjPostDate;
     private BigDecimal period;
     private Byte spcPeriodDay;
     private Byte spcPeriodMn;
     private Byte spcPeriodYr;
     private String reportNotes;
     private Boolean chkRep;

    public PerEmpVacationAdjstmnt() {
    }

	
    public PerEmpVacationAdjstmnt(PerEmpVacationAdjstmntId id, PerEmpVacationTrans perEmpVacationTrans, boolean adjType) {
        this.id = id;
        this.perEmpVacationTrans = perEmpVacationTrans;
        this.adjType = adjType;
    }
    public PerEmpVacationAdjstmnt(PerEmpVacationAdjstmntId id, PerEmpVacationTrans perEmpVacationTrans, boolean adjType, Date adjStartDate, Date adjEndDate, Boolean directBossApprove, Boolean bigBossApprove, String decisionNo, Date decisionDate, Date adjPostDate, BigDecimal period, Byte spcPeriodDay, Byte spcPeriodMn, Byte spcPeriodYr, String reportNotes, Boolean chkRep) {
       this.id = id;
       this.perEmpVacationTrans = perEmpVacationTrans;
       this.adjType = adjType;
       this.adjStartDate = adjStartDate;
       this.adjEndDate = adjEndDate;
       this.directBossApprove = directBossApprove;
       this.bigBossApprove = bigBossApprove;
       this.decisionNo = decisionNo;
       this.decisionDate = decisionDate;
       this.adjPostDate = adjPostDate;
       this.period = period;
       this.spcPeriodDay = spcPeriodDay;
       this.spcPeriodMn = spcPeriodMn;
       this.spcPeriodYr = spcPeriodYr;
       this.reportNotes = reportNotes;
       this.chkRep = chkRep;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ), 
        @AttributeOverride(name="vacationCode", column=@Column(name="VACATION_CODE", nullable=false, length=2) ), 
        @AttributeOverride(name="transSerialNo", column=@Column(name="TRANS_SERIAL_NO", nullable=false, length=5) ), 
        @AttributeOverride(name="adjDate", column=@Column(name="ADJ_DATE", nullable=false, length=7) ) } )
    public PerEmpVacationAdjstmntId getId() {
        return this.id;
    }
    
    public void setId(PerEmpVacationAdjstmntId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="EMPLOYEE_ID", referencedColumnName="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="VACATION_CODE", referencedColumnName="VACATION_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="TRANS_SERIAL_NO", referencedColumnName="TRANS_SERIAL_NO", nullable=false, insertable=false, updatable=false) } )
    public PerEmpVacationTrans getPerEmpVacationTrans() {
        return this.perEmpVacationTrans;
    }
    
    public void setPerEmpVacationTrans(PerEmpVacationTrans perEmpVacationTrans) {
        this.perEmpVacationTrans = perEmpVacationTrans;
    }

    
    @Column(name="ADJ_TYPE", nullable=false, precision=1, scale=0)
    public boolean isAdjType() {
        return this.adjType;
    }
    
    public void setAdjType(boolean adjType) {
        this.adjType = adjType;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ADJ_START_DATE", length=7)
    public Date getAdjStartDate() {
        return this.adjStartDate;
    }
    
    public void setAdjStartDate(Date adjStartDate) {
        this.adjStartDate = adjStartDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ADJ_END_DATE", length=7)
    public Date getAdjEndDate() {
        return this.adjEndDate;
    }
    
    public void setAdjEndDate(Date adjEndDate) {
        this.adjEndDate = adjEndDate;
    }

    
    @Column(name="DIRECT_BOSS_APPROVE", precision=1, scale=0)
    public Boolean getDirectBossApprove() {
        return this.directBossApprove;
    }
    
    public void setDirectBossApprove(Boolean directBossApprove) {
        this.directBossApprove = directBossApprove;
    }

    
    @Column(name="BIG_BOSS_APPROVE", precision=1, scale=0)
    public Boolean getBigBossApprove() {
        return this.bigBossApprove;
    }
    
    public void setBigBossApprove(Boolean bigBossApprove) {
        this.bigBossApprove = bigBossApprove;
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

    @Temporal(TemporalType.DATE)
    @Column(name="ADJ_POST_DATE", length=7)
    public Date getAdjPostDate() {
        return this.adjPostDate;
    }
    
    public void setAdjPostDate(Date adjPostDate) {
        this.adjPostDate = adjPostDate;
    }

    
    @Column(name="PERIOD", precision=7)
    public BigDecimal getPeriod() {
        return this.period;
    }
    
    public void setPeriod(BigDecimal period) {
        this.period = period;
    }

    
    @Column(name="SPC_PERIOD_DAY", precision=2, scale=0)
    public Byte getSpcPeriodDay() {
        return this.spcPeriodDay;
    }
    
    public void setSpcPeriodDay(Byte spcPeriodDay) {
        this.spcPeriodDay = spcPeriodDay;
    }

    
    @Column(name="SPC_PERIOD_MN", precision=2, scale=0)
    public Byte getSpcPeriodMn() {
        return this.spcPeriodMn;
    }
    
    public void setSpcPeriodMn(Byte spcPeriodMn) {
        this.spcPeriodMn = spcPeriodMn;
    }

    
    @Column(name="SPC_PERIOD_YR", precision=2, scale=0)
    public Byte getSpcPeriodYr() {
        return this.spcPeriodYr;
    }
    
    public void setSpcPeriodYr(Byte spcPeriodYr) {
        this.spcPeriodYr = spcPeriodYr;
    }

    
    @Column(name="REPORT_NOTES", length=250)
    public String getReportNotes() {
        return this.reportNotes;
    }
    
    public void setReportNotes(String reportNotes) {
        this.reportNotes = reportNotes;
    }

    
    @Column(name="CHK_REP", precision=1, scale=0)
    public Boolean getChkRep() {
        return this.chkRep;
    }
    
    public void setChkRep(Boolean chkRep) {
        this.chkRep = chkRep;
    }




}

