package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerPromotionTransNew generated by hbm2java
 */
@Entity
@Table(name="PER_PROMOTION_TRANS_NEW"
    ,schema="SHAMS"
)
public class PerPromotionTransNew  implements java.io.Serializable {


     private PerPromotionTransNewId id;
     private PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNew;
     private PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew;
     private PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNewEndsal;
     private PerGroupTypeCode perGroupTypeCode;
     private PerJobCode perJobCode;
     private PerPromotionRule perPromotionRule;
     private BudLocation budLocation;
     private Date promotionDate;
     private boolean elawaCalc;
     private boolean aprPromotion;
     private Byte promotionRateMain;
     private Byte promotionRate;
     private String commityNo;
     private BigDecimal elawaRatio;
     private Date salaryMonth;
     private Boolean degreeEndSalaryFlg;
     private String decisionNo;
     private Date decisionDate;
     private Date postDate;
     private Short VBandCode;
     private Byte VMethodType;
     private Byte addElawaType;
     private Set<PerPromotionPunishRuleN> perPromotionPunishRuleNs = new HashSet<PerPromotionPunishRuleN>(0);
     private Set<PerEmpPromotionRejectNew> perEmpPromotionRejectNews = new HashSet<PerEmpPromotionRejectNew>(0);
     private Set<PerPromotionVacationRuleN> perPromotionVacationRuleNs = new HashSet<PerPromotionVacationRuleN>(0);
     private Set<PerPromotionTrainRuleN> perPromotionTrainRuleNs = new HashSet<PerPromotionTrainRuleN>(0);
     private Set<PerEmpPromotionNew> perEmpPromotionNews = new HashSet<PerEmpPromotionNew>(0);
     private Set<PerPromotionGradeRuleN> perPromotionGradeRuleNs = new HashSet<PerPromotionGradeRuleN>(0);

    public PerPromotionTransNew() {
    }

	
    public PerPromotionTransNew(PerPromotionTransNewId id, PerPromotionRule perPromotionRule, BudLocation budLocation, Date promotionDate, boolean elawaCalc, boolean aprPromotion) {
        this.id = id;
        this.perPromotionRule = perPromotionRule;
        this.budLocation = budLocation;
        this.promotionDate = promotionDate;
        this.elawaCalc = elawaCalc;
        this.aprPromotion = aprPromotion;
    }
    public PerPromotionTransNew(PerPromotionTransNewId id, PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNew, PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew, PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNewEndsal, PerGroupTypeCode perGroupTypeCode, PerJobCode perJobCode, PerPromotionRule perPromotionRule, BudLocation budLocation, Date promotionDate, boolean elawaCalc, boolean aprPromotion, Byte promotionRateMain, Byte promotionRate, String commityNo, BigDecimal elawaRatio, Date salaryMonth, Boolean degreeEndSalaryFlg, String decisionNo, Date decisionDate, Date postDate, Short VBandCode, Byte VMethodType, Byte addElawaType, Set<PerPromotionPunishRuleN> perPromotionPunishRuleNs, Set<PerEmpPromotionRejectNew> perEmpPromotionRejectNews, Set<PerPromotionVacationRuleN> perPromotionVacationRuleNs, Set<PerPromotionTrainRuleN> perPromotionTrainRuleNs, Set<PerEmpPromotionNew> perEmpPromotionNews, Set<PerPromotionGradeRuleN> perPromotionGradeRuleNs) {
       this.id = id;
       this.perFiscalDegreeCodeNewByFiscalDegreeCodeNew = perFiscalDegreeCodeNewByFiscalDegreeCodeNew;
       this.perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew = perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew;
       this.perFiscalDegreeCodeNewByFiscalDegreeCodeNewEndsal = perFiscalDegreeCodeNewByFiscalDegreeCodeNewEndsal;
       this.perGroupTypeCode = perGroupTypeCode;
       this.perJobCode = perJobCode;
       this.perPromotionRule = perPromotionRule;
       this.budLocation = budLocation;
       this.promotionDate = promotionDate;
       this.elawaCalc = elawaCalc;
       this.aprPromotion = aprPromotion;
       this.promotionRateMain = promotionRateMain;
       this.promotionRate = promotionRate;
       this.commityNo = commityNo;
       this.elawaRatio = elawaRatio;
       this.salaryMonth = salaryMonth;
       this.degreeEndSalaryFlg = degreeEndSalaryFlg;
       this.decisionNo = decisionNo;
       this.decisionDate = decisionDate;
       this.postDate = postDate;
       this.VBandCode = VBandCode;
       this.VMethodType = VMethodType;
       this.addElawaType = addElawaType;
       this.perPromotionPunishRuleNs = perPromotionPunishRuleNs;
       this.perEmpPromotionRejectNews = perEmpPromotionRejectNews;
       this.perPromotionVacationRuleNs = perPromotionVacationRuleNs;
       this.perPromotionTrainRuleNs = perPromotionTrainRuleNs;
       this.perEmpPromotionNews = perEmpPromotionNews;
       this.perPromotionGradeRuleNs = perPromotionGradeRuleNs;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="promotionType", column=@Column(name="PROMOTION_TYPE", nullable=false, length=5) ), 
        @AttributeOverride(name="transId", column=@Column(name="TRANS_ID", nullable=false, precision=10, scale=0) ) } )
    public PerPromotionTransNewId getId() {
        return this.id;
    }
    
    public void setId(PerPromotionTransNewId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FISCAL_DEGREE_CODE_NEW")
    public PerFiscalDegreeCodeNew getPerFiscalDegreeCodeNewByFiscalDegreeCodeNew() {
        return this.perFiscalDegreeCodeNewByFiscalDegreeCodeNew;
    }
    
    public void setPerFiscalDegreeCodeNewByFiscalDegreeCodeNew(PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNew) {
        this.perFiscalDegreeCodeNewByFiscalDegreeCodeNew = perFiscalDegreeCodeNewByFiscalDegreeCodeNew;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FISCAL_DEGREE_CODE_NEW_NEW")
    public PerFiscalDegreeCodeNew getPerFiscalDegreeCodeNewByFiscalDegreeCodeNewNew() {
        return this.perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew;
    }
    
    public void setPerFiscalDegreeCodeNewByFiscalDegreeCodeNewNew(PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew) {
        this.perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew = perFiscalDegreeCodeNewByFiscalDegreeCodeNewNew;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FISCAL_DEGREE_CODE_NEW_ENDSAL")
    public PerFiscalDegreeCodeNew getPerFiscalDegreeCodeNewByFiscalDegreeCodeNewEndsal() {
        return this.perFiscalDegreeCodeNewByFiscalDegreeCodeNewEndsal;
    }
    
    public void setPerFiscalDegreeCodeNewByFiscalDegreeCodeNewEndsal(PerFiscalDegreeCodeNew perFiscalDegreeCodeNewByFiscalDegreeCodeNewEndsal) {
        this.perFiscalDegreeCodeNewByFiscalDegreeCodeNewEndsal = perFiscalDegreeCodeNewByFiscalDegreeCodeNewEndsal;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GROUP_TYPE_CODE")
    public PerGroupTypeCode getPerGroupTypeCode() {
        return this.perGroupTypeCode;
    }
    
    public void setPerGroupTypeCode(PerGroupTypeCode perGroupTypeCode) {
        this.perGroupTypeCode = perGroupTypeCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="JOB_CODE")
    public PerJobCode getPerJobCode() {
        return this.perJobCode;
    }
    
    public void setPerJobCode(PerJobCode perJobCode) {
        this.perJobCode = perJobCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PROMOTION_TYPE", nullable=false, insertable=false, updatable=false)
    public PerPromotionRule getPerPromotionRule() {
        return this.perPromotionRule;
    }
    
    public void setPerPromotionRule(PerPromotionRule perPromotionRule) {
        this.perPromotionRule = perPromotionRule;
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
    @Column(name="PROMOTION_DATE", nullable=false, length=7)
    public Date getPromotionDate() {
        return this.promotionDate;
    }
    
    public void setPromotionDate(Date promotionDate) {
        this.promotionDate = promotionDate;
    }

    
    @Column(name="ELAWA_CALC", nullable=false, precision=1, scale=0)
    public boolean isElawaCalc() {
        return this.elawaCalc;
    }
    
    public void setElawaCalc(boolean elawaCalc) {
        this.elawaCalc = elawaCalc;
    }

    
    @Column(name="APR_PROMOTION", nullable=false, precision=1, scale=0)
    public boolean isAprPromotion() {
        return this.aprPromotion;
    }
    
    public void setAprPromotion(boolean aprPromotion) {
        this.aprPromotion = aprPromotion;
    }

    
    @Column(name="PROMOTION_RATE_MAIN", precision=2, scale=0)
    public Byte getPromotionRateMain() {
        return this.promotionRateMain;
    }
    
    public void setPromotionRateMain(Byte promotionRateMain) {
        this.promotionRateMain = promotionRateMain;
    }

    
    @Column(name="PROMOTION_RATE", precision=2, scale=0)
    public Byte getPromotionRate() {
        return this.promotionRate;
    }
    
    public void setPromotionRate(Byte promotionRate) {
        this.promotionRate = promotionRate;
    }

    
    @Column(name="COMMITY_NO", length=10)
    public String getCommityNo() {
        return this.commityNo;
    }
    
    public void setCommityNo(String commityNo) {
        this.commityNo = commityNo;
    }

    
    @Column(name="ELAWA_RATIO", precision=5)
    public BigDecimal getElawaRatio() {
        return this.elawaRatio;
    }
    
    public void setElawaRatio(BigDecimal elawaRatio) {
        this.elawaRatio = elawaRatio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="SALARY_MONTH", length=7)
    public Date getSalaryMonth() {
        return this.salaryMonth;
    }
    
    public void setSalaryMonth(Date salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    
    @Column(name="DEGREE_END_SALARY_FLG", precision=1, scale=0)
    public Boolean getDegreeEndSalaryFlg() {
        return this.degreeEndSalaryFlg;
    }
    
    public void setDegreeEndSalaryFlg(Boolean degreeEndSalaryFlg) {
        this.degreeEndSalaryFlg = degreeEndSalaryFlg;
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
    @Column(name="POST_DATE", length=7)
    public Date getPostDate() {
        return this.postDate;
    }
    
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    
    @Column(name="V_BAND_CODE", precision=4, scale=0)
    public Short getVBandCode() {
        return this.VBandCode;
    }
    
    public void setVBandCode(Short VBandCode) {
        this.VBandCode = VBandCode;
    }

    
    @Column(name="V_METHOD_TYPE", precision=2, scale=0)
    public Byte getVMethodType() {
        return this.VMethodType;
    }
    
    public void setVMethodType(Byte VMethodType) {
        this.VMethodType = VMethodType;
    }

    
    @Column(name="ADD_ELAWA_TYPE", precision=2, scale=0)
    public Byte getAddElawaType() {
        return this.addElawaType;
    }
    
    public void setAddElawaType(Byte addElawaType) {
        this.addElawaType = addElawaType;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perPromotionTransNew")
    public Set<PerPromotionPunishRuleN> getPerPromotionPunishRuleNs() {
        return this.perPromotionPunishRuleNs;
    }
    
    public void setPerPromotionPunishRuleNs(Set<PerPromotionPunishRuleN> perPromotionPunishRuleNs) {
        this.perPromotionPunishRuleNs = perPromotionPunishRuleNs;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perPromotionTransNew")
    public Set<PerEmpPromotionRejectNew> getPerEmpPromotionRejectNews() {
        return this.perEmpPromotionRejectNews;
    }
    
    public void setPerEmpPromotionRejectNews(Set<PerEmpPromotionRejectNew> perEmpPromotionRejectNews) {
        this.perEmpPromotionRejectNews = perEmpPromotionRejectNews;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perPromotionTransNew")
    public Set<PerPromotionVacationRuleN> getPerPromotionVacationRuleNs() {
        return this.perPromotionVacationRuleNs;
    }
    
    public void setPerPromotionVacationRuleNs(Set<PerPromotionVacationRuleN> perPromotionVacationRuleNs) {
        this.perPromotionVacationRuleNs = perPromotionVacationRuleNs;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perPromotionTransNew")
    public Set<PerPromotionTrainRuleN> getPerPromotionTrainRuleNs() {
        return this.perPromotionTrainRuleNs;
    }
    
    public void setPerPromotionTrainRuleNs(Set<PerPromotionTrainRuleN> perPromotionTrainRuleNs) {
        this.perPromotionTrainRuleNs = perPromotionTrainRuleNs;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perPromotionTransNew")
    public Set<PerEmpPromotionNew> getPerEmpPromotionNews() {
        return this.perEmpPromotionNews;
    }
    
    public void setPerEmpPromotionNews(Set<PerEmpPromotionNew> perEmpPromotionNews) {
        this.perEmpPromotionNews = perEmpPromotionNews;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perPromotionTransNew")
    public Set<PerPromotionGradeRuleN> getPerPromotionGradeRuleNs() {
        return this.perPromotionGradeRuleNs;
    }
    
    public void setPerPromotionGradeRuleNs(Set<PerPromotionGradeRuleN> perPromotionGradeRuleNs) {
        this.perPromotionGradeRuleNs = perPromotionGradeRuleNs;
    }




}


