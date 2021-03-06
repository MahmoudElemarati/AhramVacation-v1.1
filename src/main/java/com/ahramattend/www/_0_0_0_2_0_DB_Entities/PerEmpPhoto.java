package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * PerEmpPhoto generated by hbm2java
 */
@Entity
@Table(name="PER_EMP_PHOTO"
    ,schema="SHAMS"
)
public class PerEmpPhoto  implements java.io.Serializable {


     private String employeeId;
     private PerEmploymentMasters perEmploymentMasters;
     private int empPhotoSp;
     private Blob empPhotoBlob;
     private String empPhotoBase64;

    public PerEmpPhoto() {
    }

	
    public PerEmpPhoto(PerEmploymentMasters perEmploymentMasters, int empPhotoSp) {
        this.perEmploymentMasters = perEmploymentMasters;
        this.empPhotoSp = empPhotoSp;
    }
    public PerEmpPhoto(PerEmploymentMasters perEmploymentMasters, int empPhotoSp, Blob empPhotoBlob, String empPhotoBase64) {
       this.perEmploymentMasters = perEmploymentMasters;
       this.empPhotoSp = empPhotoSp;
       this.empPhotoBlob = empPhotoBlob;
       this.empPhotoBase64 = empPhotoBase64;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="perEmploymentMasters"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="EMPLOYEE_ID", unique=true, nullable=false, length=10)
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

@OneToOne(fetch=FetchType.EAGER)@PrimaryKeyJoinColumn
    public PerEmploymentMasters getPerEmploymentMasters() {
        return this.perEmploymentMasters;
    }
    
    public void setPerEmploymentMasters(PerEmploymentMasters perEmploymentMasters) {
        this.perEmploymentMasters = perEmploymentMasters;
    }

    
    @Column(name="EMP_PHOTO_SP", nullable=false, precision=5, scale=0)
    public int getEmpPhotoSp() {
        return this.empPhotoSp;
    }
    
    public void setEmpPhotoSp(int empPhotoSp) {
        this.empPhotoSp = empPhotoSp;
    }

    
    @Column(name="EMP_PHOTO_BLOB")
    public Blob getEmpPhotoBlob() {
        return this.empPhotoBlob;
    }
    
    public void setEmpPhotoBlob(Blob empPhotoBlob) {
        this.empPhotoBlob = empPhotoBlob;
    }

    
    @Column(name="EMP_PHOTO_BASE64", length=4000)
    public String getEmpPhotoBase64() {
        return this.empPhotoBase64;
    }
    
    public void setEmpPhotoBase64(String empPhotoBase64) {
        this.empPhotoBase64 = empPhotoBase64;
    }




}


