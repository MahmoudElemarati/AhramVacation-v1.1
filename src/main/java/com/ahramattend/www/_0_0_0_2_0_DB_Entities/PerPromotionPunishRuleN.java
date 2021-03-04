package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


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
 * PerPromotionPunishRuleN generated by hbm2java
 */
@Entity
@Table(name="PER_PROMOTION_PUNISH_RULE_N"
    ,schema="SHAMS"
)
public class PerPromotionPunishRuleN  implements java.io.Serializable {


     private PerPromotionPunishRuleNId id;
     private PerPromotionTransNew perPromotionTransNew;
     private PerPunishmentCode perPunishmentCode;
     private byte punishRule;
     private short periodTo;

    public PerPromotionPunishRuleN() {
    }

    public PerPromotionPunishRuleN(PerPromotionPunishRuleNId id, PerPromotionTransNew perPromotionTransNew, PerPunishmentCode perPunishmentCode, byte punishRule, short periodTo) {
       this.id = id;
       this.perPromotionTransNew = perPromotionTransNew;
       this.perPunishmentCode = perPunishmentCode;
       this.punishRule = punishRule;
       this.periodTo = periodTo;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="promotionType", column=@Column(name="PROMOTION_TYPE", nullable=false, length=5) ), 
        @AttributeOverride(name="transId", column=@Column(name="TRANS_ID", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="punishCode", column=@Column(name="PUNISH_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="periodFrom", column=@Column(name="PERIOD_FROM", nullable=false, precision=3, scale=0) ) } )
    public PerPromotionPunishRuleNId getId() {
        return this.id;
    }
    
    public void setId(PerPromotionPunishRuleNId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
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

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PUNISH_CODE", nullable=false, insertable=false, updatable=false)
    public PerPunishmentCode getPerPunishmentCode() {
        return this.perPunishmentCode;
    }
    
    public void setPerPunishmentCode(PerPunishmentCode perPunishmentCode) {
        this.perPunishmentCode = perPunishmentCode;
    }

    
    @Column(name="PUNISH_RULE", nullable=false, precision=2, scale=0)
    public byte getPunishRule() {
        return this.punishRule;
    }
    
    public void setPunishRule(byte punishRule) {
        this.punishRule = punishRule;
    }

    
    @Column(name="PERIOD_TO", nullable=false, precision=3, scale=0)
    public short getPeriodTo() {
        return this.periodTo;
    }
    
    public void setPeriodTo(short periodTo) {
        this.periodTo = periodTo;
    }




}

