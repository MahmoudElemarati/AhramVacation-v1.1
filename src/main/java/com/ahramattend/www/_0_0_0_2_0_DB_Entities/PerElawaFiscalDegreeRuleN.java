package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PerElawaFiscalDegreeRuleN generated by hbm2java
 */
@Entity
@Table(name="PER_ELAWA_FISCAL_DEGREE_RULE_N"
    ,schema="SHAMS"
)
public class PerElawaFiscalDegreeRuleN  implements java.io.Serializable {


     private PerElawaFiscalDegreeRuleNId id;
     private PerFiscalDegreeCodeNew perFiscalDegreeCodeNew;

    public PerElawaFiscalDegreeRuleN() {
    }

    public PerElawaFiscalDegreeRuleN(PerElawaFiscalDegreeRuleNId id, PerFiscalDegreeCodeNew perFiscalDegreeCodeNew) {
       this.id = id;
       this.perFiscalDegreeCodeNew = perFiscalDegreeCodeNew;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="elawaDate", column=@Column(name="ELAWA_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="elawaTypeCode", column=@Column(name="ELAWA_TYPE_CODE", nullable=false, length=2) ), 
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="fiscalDegreeCodeNew", column=@Column(name="FISCAL_DEGREE_CODE_NEW", nullable=false, length=3) ) } )
    public PerElawaFiscalDegreeRuleNId getId() {
        return this.id;
    }
    
    public void setId(PerElawaFiscalDegreeRuleNId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FISCAL_DEGREE_CODE_NEW", nullable=false, insertable=false, updatable=false)
    public PerFiscalDegreeCodeNew getPerFiscalDegreeCodeNew() {
        return this.perFiscalDegreeCodeNew;
    }
    
    public void setPerFiscalDegreeCodeNew(PerFiscalDegreeCodeNew perFiscalDegreeCodeNew) {
        this.perFiscalDegreeCodeNew = perFiscalDegreeCodeNew;
    }




}


