package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerQualFaculty generated by hbm2java
 */
@Entity
@Table(name="PER_QUAL_FACULTY"
    ,schema="SHAMS"
)
public class PerQualFaculty  implements java.io.Serializable {


     private PerQualFacultyId id;
     private PerFacultyCode perFacultyCode;
     private PerQualCode perQualCode;
     private String notes;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set<PerEmpQualification> perEmpQualifications = new HashSet<PerEmpQualification>(0);

    public PerQualFaculty() {
    }

	
    public PerQualFaculty(PerQualFacultyId id, PerFacultyCode perFacultyCode, PerQualCode perQualCode) {
        this.id = id;
        this.perFacultyCode = perFacultyCode;
        this.perQualCode = perQualCode;
    }
    public PerQualFaculty(PerQualFacultyId id, PerFacultyCode perFacultyCode, PerQualCode perQualCode, String notes, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set<PerEmpQualification> perEmpQualifications) {
       this.id = id;
       this.perFacultyCode = perFacultyCode;
       this.perQualCode = perQualCode;
       this.notes = notes;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.perEmpQualifications = perEmpQualifications;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="qualCode", column=@Column(name="QUAL_CODE", nullable=false, length=5) ), 
        @AttributeOverride(name="facultyCode", column=@Column(name="FACULTY_CODE", nullable=false, length=3) ) } )
    public PerQualFacultyId getId() {
        return this.id;
    }
    
    public void setId(PerQualFacultyId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FACULTY_CODE", nullable=false, insertable=false, updatable=false)
    public PerFacultyCode getPerFacultyCode() {
        return this.perFacultyCode;
    }
    
    public void setPerFacultyCode(PerFacultyCode perFacultyCode) {
        this.perFacultyCode = perFacultyCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="QUAL_CODE", nullable=false, insertable=false, updatable=false)
    public PerQualCode getPerQualCode() {
        return this.perQualCode;
    }
    
    public void setPerQualCode(PerQualCode perQualCode) {
        this.perQualCode = perQualCode;
    }

    
    @Column(name="NOTES", length=100)
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
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

@OneToMany(fetch=FetchType.EAGER, mappedBy="perQualFaculty")
    public Set<PerEmpQualification> getPerEmpQualifications() {
        return this.perEmpQualifications;
    }
    
    public void setPerEmpQualifications(Set<PerEmpQualification> perEmpQualifications) {
        this.perEmpQualifications = perEmpQualifications;
    }




}


