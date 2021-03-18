package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerPunishmentCode generated by hbm2java
 */
@Entity
@Table(name="PER_PUNISHMENT_CODE"
    ,schema="SHAMS"
)
public class PerPunishmentCode  implements java.io.Serializable {


     private String punishCode;
     private PayBandCode payBandCode;
     private String punishName;
     private Short suppressPeriod;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set<PerPromotionPunishRuleN> perPromotionPunishRuleNs = new HashSet<PerPromotionPunishRuleN>(0);
     private Set<PerElawaPunishRule> perElawaPunishRules = new HashSet<PerElawaPunishRule>(0);

    public PerPunishmentCode() {
    }

	
    public PerPunishmentCode(String punishCode, String punishName) {
        this.punishCode = punishCode;
        this.punishName = punishName;
    }
    public PerPunishmentCode(String punishCode, PayBandCode payBandCode, String punishName, Short suppressPeriod, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set<PerPromotionPunishRuleN> perPromotionPunishRuleNs, Set<PerElawaPunishRule> perElawaPunishRules) {
       this.punishCode = punishCode;
       this.payBandCode = payBandCode;
       this.punishName = punishName;
       this.suppressPeriod = suppressPeriod;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.perPromotionPunishRuleNs = perPromotionPunishRuleNs;
       this.perElawaPunishRules = perElawaPunishRules;
    }
   
     @Id 

    
    @Column(name="PUNISH_CODE", unique=true, nullable=false, length=3)
    public String getPunishCode() {
        return this.punishCode;
    }
    
    public void setPunishCode(String punishCode) {
        this.punishCode = punishCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="BAND_TYPE", referencedColumnName="BAND_TYPE"), 
        @JoinColumn(name="BAND_CODE", referencedColumnName="BAND_CODE") } )
    public PayBandCode getPayBandCode() {
        return this.payBandCode;
    }
    
    public void setPayBandCode(PayBandCode payBandCode) {
        this.payBandCode = payBandCode;
    }

    
    @Column(name="PUNISH_NAME", nullable=false, length=50)
    public String getPunishName() {
        return this.punishName;
    }
    
    public void setPunishName(String punishName) {
        this.punishName = punishName;
    }

    
    @Column(name="SUPPRESS_PERIOD", precision=3, scale=0)
    public Short getSuppressPeriod() {
        return this.suppressPeriod;
    }
    
    public void setSuppressPeriod(Short suppressPeriod) {
        this.suppressPeriod = suppressPeriod;
    }

    
    @Column(name="RECORD_CREATE_USER", length=15)
    public String getRecordCreateUser() {
        return this.recordCreateUser;
    }
    
    public void setRecordCreateUser(String recordCreateUser) {
        this.recordCreateUser = recordCreateUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_CREATE_DATE", length=7)
    public Date getRecordCreateDate() {
        return this.recordCreateDate;
    }
    
    public void setRecordCreateDate(Date recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }

    
    @Column(name="RECORD_UPDATE_USER", length=15)
    public String getRecordUpdateUser() {
        return this.recordUpdateUser;
    }
    
    public void setRecordUpdateUser(String recordUpdateUser) {
        this.recordUpdateUser = recordUpdateUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_UPDATE_DATE", length=7)
    public Date getRecordUpdateDate() {
        return this.recordUpdateDate;
    }
    
    public void setRecordUpdateDate(Date recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perPunishmentCode")
    public Set<PerPromotionPunishRuleN> getPerPromotionPunishRuleNs() {
        return this.perPromotionPunishRuleNs;
    }
    
    public void setPerPromotionPunishRuleNs(Set<PerPromotionPunishRuleN> perPromotionPunishRuleNs) {
        this.perPromotionPunishRuleNs = perPromotionPunishRuleNs;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perPunishmentCode")
    public Set<PerElawaPunishRule> getPerElawaPunishRules() {
        return this.perElawaPunishRules;
    }
    
    public void setPerElawaPunishRules(Set<PerElawaPunishRule> perElawaPunishRules) {
        this.perElawaPunishRules = perElawaPunishRules;
    }




}


