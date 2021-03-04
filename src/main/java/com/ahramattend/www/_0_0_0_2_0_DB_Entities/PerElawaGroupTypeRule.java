package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


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
 * PerElawaGroupTypeRule generated by hbm2java
 */
@Entity
@Table(name="PER_ELAWA_GROUP_TYPE_RULE"
    ,schema="SHAMS"
)
public class PerElawaGroupTypeRule  implements java.io.Serializable {


     private PerElawaGroupTypeRuleId id;
     private PerGroupTypeCode perGroupTypeCode;

    public PerElawaGroupTypeRule() {
    }

    public PerElawaGroupTypeRule(PerElawaGroupTypeRuleId id, PerGroupTypeCode perGroupTypeCode) {
       this.id = id;
       this.perGroupTypeCode = perGroupTypeCode;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="elawaTypeCode", column=@Column(name="ELAWA_TYPE_CODE", nullable=false, length=2) ), 
        @AttributeOverride(name="elawaDate", column=@Column(name="ELAWA_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="groupTypeCode", column=@Column(name="GROUP_TYPE_CODE", nullable=false, length=3) ) } )
    public PerElawaGroupTypeRuleId getId() {
        return this.id;
    }
    
    public void setId(PerElawaGroupTypeRuleId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GROUP_TYPE_CODE", nullable=false, insertable=false, updatable=false)
    public PerGroupTypeCode getPerGroupTypeCode() {
        return this.perGroupTypeCode;
    }
    
    public void setPerGroupTypeCode(PerGroupTypeCode perGroupTypeCode) {
        this.perGroupTypeCode = perGroupTypeCode;
    }




}


