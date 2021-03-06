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
 * PerElawaGeneralRule generated by hbm2java
 */
@Entity
@Table(name="PER_ELAWA_GENERAL_RULE"
    ,schema="SHAMS"
)
public class PerElawaGeneralRule  implements java.io.Serializable {


     private PerElawaGeneralRuleId id;
     private PerGeneralCode perGeneralCode;

    public PerElawaGeneralRule() {
    }

    public PerElawaGeneralRule(PerElawaGeneralRuleId id, PerGeneralCode perGeneralCode) {
       this.id = id;
       this.perGeneralCode = perGeneralCode;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="elawaTypeCode", column=@Column(name="ELAWA_TYPE_CODE", nullable=false, length=2) ), 
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="elawaDate", column=@Column(name="ELAWA_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="generalCode", column=@Column(name="GENERAL_CODE", nullable=false, length=3) ) } )
    public PerElawaGeneralRuleId getId() {
        return this.id;
    }
    
    public void setId(PerElawaGeneralRuleId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GENERAL_CODE", nullable=false, insertable=false, updatable=false)
    public PerGeneralCode getPerGeneralCode() {
        return this.perGeneralCode;
    }
    
    public void setPerGeneralCode(PerGeneralCode perGeneralCode) {
        this.perGeneralCode = perGeneralCode;
    }




}


