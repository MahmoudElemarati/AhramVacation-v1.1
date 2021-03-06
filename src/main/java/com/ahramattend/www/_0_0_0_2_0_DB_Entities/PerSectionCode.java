package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PerSectionCode generated by hbm2java
 */
@Entity
@Table(name="PER_SECTION_CODE"
    ,schema="SHAMS"
)
public class PerSectionCode  implements java.io.Serializable {


     private PerSectionCodeId id;
     private PerLocationCodes perLocationCodes;
     private String secName;
     private String secFloor;
     private Set<PerDeptCode> perDeptCodes = new HashSet<PerDeptCode>(0);

    public PerSectionCode() {
    }

	
    public PerSectionCode(PerSectionCodeId id, PerLocationCodes perLocationCodes) {
        this.id = id;
        this.perLocationCodes = perLocationCodes;
    }
    public PerSectionCode(PerSectionCodeId id, PerLocationCodes perLocationCodes, String secName, String secFloor, Set<PerDeptCode> perDeptCodes) {
       this.id = id;
       this.perLocationCodes = perLocationCodes;
       this.secName = secName;
       this.secFloor = secFloor;
       this.perDeptCodes = perDeptCodes;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="secCode", column=@Column(name="SEC_CODE", nullable=false, precision=3, scale=0) ), 
        @AttributeOverride(name="locCode", column=@Column(name="LOC_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ) } )
    public PerSectionCodeId getId() {
        return this.id;
    }
    
    public void setId(PerSectionCodeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="LOC_CODE", referencedColumnName="LOC_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false) } )
    public PerLocationCodes getPerLocationCodes() {
        return this.perLocationCodes;
    }
    
    public void setPerLocationCodes(PerLocationCodes perLocationCodes) {
        this.perLocationCodes = perLocationCodes;
    }

    
    @Column(name="SEC_NAME", length=100)
    public String getSecName() {
        return this.secName;
    }
    
    public void setSecName(String secName) {
        this.secName = secName;
    }

    
    @Column(name="SEC_FLOOR", length=100)
    public String getSecFloor() {
        return this.secFloor;
    }
    
    public void setSecFloor(String secFloor) {
        this.secFloor = secFloor;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perSectionCode")
    public Set<PerDeptCode> getPerDeptCodes() {
        return this.perDeptCodes;
    }
    
    public void setPerDeptCodes(Set<PerDeptCode> perDeptCodes) {
        this.perDeptCodes = perDeptCodes;
    }




}


