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
 * PerElawaFiscalDegreeRule generated by hbm2java
 */
@Entity
@Table(name="PER_ELAWA_FISCAL_DEGREE_RULE"
    ,schema="SHAMS"
)
public class PerElawaFiscalDegreeRule  implements java.io.Serializable {


     private PerElawaFiscalDegreeRuleId id;
     private PerFiscalDegreeCode perFiscalDegreeCode;

    public PerElawaFiscalDegreeRule() {
    }

    public PerElawaFiscalDegreeRule(PerElawaFiscalDegreeRuleId id, PerFiscalDegreeCode perFiscalDegreeCode) {
       this.id = id;
       this.perFiscalDegreeCode = perFiscalDegreeCode;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="elawaTypeCode", column=@Column(name="ELAWA_TYPE_CODE", nullable=false, length=2) ), 
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="elawaDate", column=@Column(name="ELAWA_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="fiscalDegreeCode", column=@Column(name="FISCAL_DEGREE_CODE", nullable=false, length=3) ) } )
    public PerElawaFiscalDegreeRuleId getId() {
        return this.id;
    }
    
    public void setId(PerElawaFiscalDegreeRuleId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FISCAL_DEGREE_CODE", nullable=false, insertable=false, updatable=false)
    public PerFiscalDegreeCode getPerFiscalDegreeCode() {
        return this.perFiscalDegreeCode;
    }
    
    public void setPerFiscalDegreeCode(PerFiscalDegreeCode perFiscalDegreeCode) {
        this.perFiscalDegreeCode = perFiscalDegreeCode;
    }




}


