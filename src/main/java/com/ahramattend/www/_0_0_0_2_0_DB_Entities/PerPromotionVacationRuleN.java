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
 * PerPromotionVacationRuleN generated by hbm2java
 */
@Entity
@Table(name="PER_PROMOTION_VACATION_RULE_N"
    ,schema="SHAMS"
)
public class PerPromotionVacationRuleN  implements java.io.Serializable {


     private PerPromotionVacationRuleNId id;
     private PerVacationCode perVacationCode;
     private PerPromotionTransNew perPromotionTransNew;
     private int maxBalance;

    public PerPromotionVacationRuleN() {
    }

    public PerPromotionVacationRuleN(PerPromotionVacationRuleNId id, PerVacationCode perVacationCode, PerPromotionTransNew perPromotionTransNew, int maxBalance) {
       this.id = id;
       this.perVacationCode = perVacationCode;
       this.perPromotionTransNew = perPromotionTransNew;
       this.maxBalance = maxBalance;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="transId", column=@Column(name="TRANS_ID", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="promotionType", column=@Column(name="PROMOTION_TYPE", nullable=false, length=5) ), 
        @AttributeOverride(name="vacationCode", column=@Column(name="VACATION_CODE", nullable=false, length=2) ) } )
    public PerPromotionVacationRuleNId getId() {
        return this.id;
    }
    
    public void setId(PerPromotionVacationRuleNId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="VACATION_CODE", nullable=false, insertable=false, updatable=false)
    public PerVacationCode getPerVacationCode() {
        return this.perVacationCode;
    }
    
    public void setPerVacationCode(PerVacationCode perVacationCode) {
        this.perVacationCode = perVacationCode;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="PROMOTION_TYPE", referencedColumnName="PROMOTION_TYPE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="TRANS_ID", referencedColumnName="TRANS_ID", nullable=false, insertable=false, updatable=false) } )
    public PerPromotionTransNew getPerPromotionTransNew() {
        return this.perPromotionTransNew;
    }
    
    public void setPerPromotionTransNew(PerPromotionTransNew perPromotionTransNew) {
        this.perPromotionTransNew = perPromotionTransNew;
    }

    
    @Column(name="MAX_BALANCE", nullable=false, precision=5, scale=0)
    public int getMaxBalance() {
        return this.maxBalance;
    }
    
    public void setMaxBalance(int maxBalance) {
        this.maxBalance = maxBalance;
    }




}


