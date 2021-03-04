package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Feb 23, 2021 6:24:44 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerFacultyCode generated by hbm2java
 */
@Entity
@Table(name="PER_FACULTY_CODE"
    ,schema="SHAMS"
)
public class PerFacultyCode  implements java.io.Serializable {


     private String facultyCode;
     private String facultyName;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set<PerEmpQualification> perEmpQualifications = new HashSet<PerEmpQualification>(0);
     private Set<PerFacultyUniversity> perFacultyUniversities = new HashSet<PerFacultyUniversity>(0);
     private Set<PerQualFaculty> perQualFaculties = new HashSet<PerQualFaculty>(0);

    public PerFacultyCode() {
    }

	
    public PerFacultyCode(String facultyCode, String facultyName) {
        this.facultyCode = facultyCode;
        this.facultyName = facultyName;
    }
    public PerFacultyCode(String facultyCode, String facultyName, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set<PerEmpQualification> perEmpQualifications, Set<PerFacultyUniversity> perFacultyUniversities, Set<PerQualFaculty> perQualFaculties) {
       this.facultyCode = facultyCode;
       this.facultyName = facultyName;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.perEmpQualifications = perEmpQualifications;
       this.perFacultyUniversities = perFacultyUniversities;
       this.perQualFaculties = perQualFaculties;
    }
   
     @Id 

    
    @Column(name="FACULTY_CODE", unique=true, nullable=false, length=3)
    public String getFacultyCode() {
        return this.facultyCode;
    }
    
    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    
    @Column(name="FACULTY_NAME", nullable=false, length=50)
    public String getFacultyName() {
        return this.facultyName;
    }
    
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
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

@OneToMany(fetch=FetchType.EAGER, mappedBy="perFacultyCode")
    public Set<PerEmpQualification> getPerEmpQualifications() {
        return this.perEmpQualifications;
    }
    
    public void setPerEmpQualifications(Set<PerEmpQualification> perEmpQualifications) {
        this.perEmpQualifications = perEmpQualifications;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perFacultyCode")
    public Set<PerFacultyUniversity> getPerFacultyUniversities() {
        return this.perFacultyUniversities;
    }
    
    public void setPerFacultyUniversities(Set<PerFacultyUniversity> perFacultyUniversities) {
        this.perFacultyUniversities = perFacultyUniversities;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perFacultyCode")
    public Set<PerQualFaculty> getPerQualFaculties() {
        return this.perQualFaculties;
    }
    
    public void setPerQualFaculties(Set<PerQualFaculty> perQualFaculties) {
        this.perQualFaculties = perQualFaculties;
    }




}


