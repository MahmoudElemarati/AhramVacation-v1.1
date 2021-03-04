package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerEmpVacationReqJava generated by hbm2java
 */
@Entity
@Table(name="PER_EMP_VACATION_REQ_JAVA"
    ,schema="SHAMS"
)
public class PerEmpVacationReqJava  implements java.io.Serializable {


     private int vacTransSp;
     private PerVacationCode perVacationCode;
     private PerEmploymentMasters perEmploymentMastersByEmployeeIdBoss;
     private PerEmploymentMasters perEmploymentMastersByEmployeeId;
     private Date vacStartDate;
     private Date vacEndDate;
     private BigDecimal period;
     private Byte spcPeriodMn;
     private Byte spcPeriodDay;
     private Byte spcPeriodYr;
     private BigDecimal balBeforeVac;
     private String militaryCardNo;
     private String vacNote;
     private Boolean directBossAprove;
     private Date directBossDate;
     private String directBossReason;
     private String vacStatus;
     private Date vacEditDate;

    public PerEmpVacationReqJava() {
    }

	
    public PerEmpVacationReqJava(int vacTransSp, PerVacationCode perVacationCode, PerEmploymentMasters perEmploymentMastersByEmployeeId, BigDecimal period, Date vacEditDate) {
        this.vacTransSp = vacTransSp;
        this.perVacationCode = perVacationCode;
        this.perEmploymentMastersByEmployeeId = perEmploymentMastersByEmployeeId;
        this.period = period;
        this.vacEditDate = vacEditDate;
    }
    public PerEmpVacationReqJava(int vacTransSp, PerVacationCode perVacationCode, PerEmploymentMasters perEmploymentMastersByEmployeeIdBoss, PerEmploymentMasters perEmploymentMastersByEmployeeId, Date vacStartDate, Date vacEndDate, BigDecimal period, Byte spcPeriodMn, Byte spcPeriodDay, Byte spcPeriodYr, BigDecimal balBeforeVac, String militaryCardNo, String vacNote, Boolean directBossAprove, Date directBossDate, String directBossReason, String vacStatus, Date vacEditDate) {
       this.vacTransSp = vacTransSp;
       this.perVacationCode = perVacationCode;
       this.perEmploymentMastersByEmployeeIdBoss = perEmploymentMastersByEmployeeIdBoss;
       this.perEmploymentMastersByEmployeeId = perEmploymentMastersByEmployeeId;
       this.vacStartDate = vacStartDate;
       this.vacEndDate = vacEndDate;
       this.period = period;
       this.spcPeriodMn = spcPeriodMn;
       this.spcPeriodDay = spcPeriodDay;
       this.spcPeriodYr = spcPeriodYr;
       this.balBeforeVac = balBeforeVac;
       this.militaryCardNo = militaryCardNo;
       this.vacNote = vacNote;
       this.directBossAprove = directBossAprove;
       this.directBossDate = directBossDate;
       this.directBossReason = directBossReason;
       this.vacStatus = vacStatus;
       this.vacEditDate = vacEditDate;
    }
   
     @Id 

    
    @Column(name="VAC_TRANS_SP", unique=true, nullable=false, precision=9, scale=0)
    public int getVacTransSp() {
        return this.vacTransSp;
    }
    
    public void setVacTransSp(int vacTransSp) {
        this.vacTransSp = vacTransSp;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VACATION_CODE", nullable=false)
    public PerVacationCode getPerVacationCode() {
        return this.perVacationCode;
    }
    
    public void setPerVacationCode(PerVacationCode perVacationCode) {
        this.perVacationCode = perVacationCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID_BOSS")
    public PerEmploymentMasters getPerEmploymentMastersByEmployeeIdBoss() {
        return this.perEmploymentMastersByEmployeeIdBoss;
    }
    
    public void setPerEmploymentMastersByEmployeeIdBoss(PerEmploymentMasters perEmploymentMastersByEmployeeIdBoss) {
        this.perEmploymentMastersByEmployeeIdBoss = perEmploymentMastersByEmployeeIdBoss;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false)
    public PerEmploymentMasters getPerEmploymentMastersByEmployeeId() {
        return this.perEmploymentMastersByEmployeeId;
    }
    
    public void setPerEmploymentMastersByEmployeeId(PerEmploymentMasters perEmploymentMastersByEmployeeId) {
        this.perEmploymentMastersByEmployeeId = perEmploymentMastersByEmployeeId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="VAC_START_DATE", length=7)
    public Date getVacStartDate() {
        return this.vacStartDate;
    }
    
    public void setVacStartDate(Date vacStartDate) {
        this.vacStartDate = vacStartDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="VAC_END_DATE", length=7)
    public Date getVacEndDate() {
        return this.vacEndDate;
    }
    
    public void setVacEndDate(Date vacEndDate) {
        this.vacEndDate = vacEndDate;
    }

    
    @Column(name="PERIOD", nullable=false, precision=7)
    public BigDecimal getPeriod() {
        return this.period;
    }
    
    public void setPeriod(BigDecimal period) {
        this.period = period;
    }

    
    @Column(name="SPC_PERIOD_MN", precision=2, scale=0)
    public Byte getSpcPeriodMn() {
        return this.spcPeriodMn;
    }
    
    public void setSpcPeriodMn(Byte spcPeriodMn) {
        this.spcPeriodMn = spcPeriodMn;
    }

    
    @Column(name="SPC_PERIOD_DAY", precision=2, scale=0)
    public Byte getSpcPeriodDay() {
        return this.spcPeriodDay;
    }
    
    public void setSpcPeriodDay(Byte spcPeriodDay) {
        this.spcPeriodDay = spcPeriodDay;
    }

    
    @Column(name="SPC_PERIOD_YR", precision=2, scale=0)
    public Byte getSpcPeriodYr() {
        return this.spcPeriodYr;
    }
    
    public void setSpcPeriodYr(Byte spcPeriodYr) {
        this.spcPeriodYr = spcPeriodYr;
    }

    
    @Column(name="BAL_BEFORE_VAC", precision=5)
    public BigDecimal getBalBeforeVac() {
        return this.balBeforeVac;
    }
    
    public void setBalBeforeVac(BigDecimal balBeforeVac) {
        this.balBeforeVac = balBeforeVac;
    }

    
    @Column(name="MILITARY_CARD_NO", length=240)
    public String getMilitaryCardNo() {
        return this.militaryCardNo;
    }
    
    public void setMilitaryCardNo(String militaryCardNo) {
        this.militaryCardNo = militaryCardNo;
    }

    
    @Column(name="VAC_NOTE", length=100)
    public String getVacNote() {
        return this.vacNote;
    }
    
    public void setVacNote(String vacNote) {
        this.vacNote = vacNote;
    }

    
    @Column(name="DIRECT_BOSS_APROVE", precision=1, scale=0)
    public Boolean getDirectBossAprove() {
        return this.directBossAprove;
    }
    
    public void setDirectBossAprove(Boolean directBossAprove) {
        this.directBossAprove = directBossAprove;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DIRECT_BOSS_DATE", length=7)
    public Date getDirectBossDate() {
        return this.directBossDate;
    }
    
    public void setDirectBossDate(Date directBossDate) {
        this.directBossDate = directBossDate;
    }

    
    @Column(name="DIRECT_BOSS_REASON", length=100)
    public String getDirectBossReason() {
        return this.directBossReason;
    }
    
    public void setDirectBossReason(String directBossReason) {
        this.directBossReason = directBossReason;
    }

    
    @Column(name="VAC_STATUS", length=1)
    public String getVacStatus() {
        return this.vacStatus;
    }
    
    public void setVacStatus(String vacStatus) {
        this.vacStatus = vacStatus;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="VAC_EDIT_DATE", nullable=false, length=7)
    public Date getVacEditDate() {
        return this.vacEditDate;
    }
    
    public void setVacEditDate(Date vacEditDate) {
        this.vacEditDate = vacEditDate;
    }




}

