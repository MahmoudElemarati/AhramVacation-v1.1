package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


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
 * PerLocationCodeDepartment generated by hbm2java
 */
@Entity
@Table(name="PER_LOCATION_CODE_DEPARTMENT"
    ,schema="SHAMS"
)
public class PerLocationCodeDepartment  implements java.io.Serializable {


     private PerLocationCodeDepartmentId id;
     private PerLocationCodes perLocationCodes;
     private String departmentCode;
     private String departmentName;
     private Set<PerMosqueCode> perMosqueCodes = new HashSet<PerMosqueCode>(0);

    public PerLocationCodeDepartment() {
    }

	
    public PerLocationCodeDepartment(PerLocationCodeDepartmentId id, PerLocationCodes perLocationCodes, String departmentCode, String departmentName) {
        this.id = id;
        this.perLocationCodes = perLocationCodes;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
    }
    public PerLocationCodeDepartment(PerLocationCodeDepartmentId id, PerLocationCodes perLocationCodes, String departmentCode, String departmentName, Set<PerMosqueCode> perMosqueCodes) {
       this.id = id;
       this.perLocationCodes = perLocationCodes;
       this.departmentCode = departmentCode;
       this.departmentName = departmentName;
       this.perMosqueCodes = perMosqueCodes;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="locCode", column=@Column(name="LOC_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="departmentSeq", column=@Column(name="DEPARTMENT_SEQ", nullable=false, length=3) ) } )
    public PerLocationCodeDepartmentId getId() {
        return this.id;
    }
    
    public void setId(PerLocationCodeDepartmentId id) {
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

    
    @Column(name="DEPARTMENT_CODE", nullable=false, length=3)
    public String getDepartmentCode() {
        return this.departmentCode;
    }
    
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    
    @Column(name="DEPARTMENT_NAME", nullable=false, length=75)
    public String getDepartmentName() {
        return this.departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perLocationCodeDepartment")
    public Set<PerMosqueCode> getPerMosqueCodes() {
        return this.perMosqueCodes;
    }
    
    public void setPerMosqueCodes(Set<PerMosqueCode> perMosqueCodes) {
        this.perMosqueCodes = perMosqueCodes;
    }




}

