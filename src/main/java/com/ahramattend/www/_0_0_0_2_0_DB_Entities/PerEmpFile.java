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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PerEmpFile generated by hbm2java
 */
@Entity
@Table(name="PER_EMP_FILE"
    ,schema="SHAMS"
)
public class PerEmpFile  implements java.io.Serializable {


     private PerEmpFileId id;
     private PerEmploymentMasters perEmploymentMasters;
     private PerFileDocType perFileDocType;
     private PerFileType perFileType;
     private Set<PerEmpFileDoc> perEmpFileDocs = new HashSet<PerEmpFileDoc>(0);

    public PerEmpFile() {
    }

	
    public PerEmpFile(PerEmpFileId id, PerEmploymentMasters perEmploymentMasters, PerFileDocType perFileDocType, PerFileType perFileType) {
        this.id = id;
        this.perEmploymentMasters = perEmploymentMasters;
        this.perFileDocType = perFileDocType;
        this.perFileType = perFileType;
    }
    public PerEmpFile(PerEmpFileId id, PerEmploymentMasters perEmploymentMasters, PerFileDocType perFileDocType, PerFileType perFileType, Set<PerEmpFileDoc> perEmpFileDocs) {
       this.id = id;
       this.perEmploymentMasters = perEmploymentMasters;
       this.perFileDocType = perFileDocType;
       this.perFileType = perFileType;
       this.perEmpFileDocs = perEmpFileDocs;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ), 
        @AttributeOverride(name="fileSerial", column=@Column(name="FILE_SERIAL", nullable=false, length=2) ) } )
    public PerEmpFileId getId() {
        return this.id;
    }
    
    public void setId(PerEmpFileId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public PerEmploymentMasters getPerEmploymentMasters() {
        return this.perEmploymentMasters;
    }
    
    public void setPerEmploymentMasters(PerEmploymentMasters perEmploymentMasters) {
        this.perEmploymentMasters = perEmploymentMasters;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DOC_TYPE_CODE", nullable=false)
    public PerFileDocType getPerFileDocType() {
        return this.perFileDocType;
    }
    
    public void setPerFileDocType(PerFileDocType perFileDocType) {
        this.perFileDocType = perFileDocType;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FILE_TYPE_CODE", nullable=false)
    public PerFileType getPerFileType() {
        return this.perFileType;
    }
    
    public void setPerFileType(PerFileType perFileType) {
        this.perFileType = perFileType;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="perEmpFile")
    public Set<PerEmpFileDoc> getPerEmpFileDocs() {
        return this.perEmpFileDocs;
    }
    
    public void setPerEmpFileDocs(Set<PerEmpFileDoc> perEmpFileDocs) {
        this.perEmpFileDocs = perEmpFileDocs;
    }




}


