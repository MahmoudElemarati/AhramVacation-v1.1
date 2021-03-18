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
 * PerDeptCode generated by hbm2java
 */
@Entity
@Table(name="PER_DEPT_CODE"
    ,schema="SHAMS"
)
public class PerDeptCode  implements java.io.Serializable {


     private PerDeptCodeId id;
     private PerSectionCode perSectionCode;
     private String deptName;
     private String deptFloor;

    public PerDeptCode() {
    }

	
    public PerDeptCode(PerDeptCodeId id, PerSectionCode perSectionCode) {
        this.id = id;
        this.perSectionCode = perSectionCode;
    }
    public PerDeptCode(PerDeptCodeId id, PerSectionCode perSectionCode, String deptName, String deptFloor) {
       this.id = id;
       this.perSectionCode = perSectionCode;
       this.deptName = deptName;
       this.deptFloor = deptFloor;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="locCode", column=@Column(name="LOC_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="secCode", column=@Column(name="SEC_CODE", nullable=false, precision=3, scale=0) ), 
        @AttributeOverride(name="deptCode", column=@Column(name="DEPT_CODE", nullable=false, precision=3, scale=0) ) } )
    public PerDeptCodeId getId() {
        return this.id;
    }
    
    public void setId(PerDeptCodeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="SEC_CODE", referencedColumnName="SEC_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="LOC_CODE", referencedColumnName="LOC_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false) } )
    public PerSectionCode getPerSectionCode() {
        return this.perSectionCode;
    }
    
    public void setPerSectionCode(PerSectionCode perSectionCode) {
        this.perSectionCode = perSectionCode;
    }

    
    @Column(name="DEPT_NAME", length=100)
    public String getDeptName() {
        return this.deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    
    @Column(name="DEPT_FLOOR", length=100)
    public String getDeptFloor() {
        return this.deptFloor;
    }
    
    public void setDeptFloor(String deptFloor) {
        this.deptFloor = deptFloor;
    }




}


