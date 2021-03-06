package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * PerFiscalDegreeDetailNew generated by hbm2java
 */
@Entity
@Table(name="PER_FISCAL_DEGREE_DETAIL_NEW"
    ,schema="SHAMS"
)
public class PerFiscalDegreeDetailNew  implements java.io.Serializable {


     private String fiscalDegreeCodeNew;
     private PerFiscalDegreeCodeNew perFiscalDegreeCodeNew;
     private BigDecimal startSalary;
     private BigDecimal endSalary;
     private String degreePeriodicElawa;
     private String degreeEncouragElawa;
     private BigDecimal avgSalary;
     private BigDecimal elawaVal1;
     private BigDecimal elawaVal2;
     private BigDecimal salForElawa2;
     private BigDecimal constantElawa;
     private BigDecimal salForConstantElawa;
     private Byte maxNoForConstantElawa;
     private BigDecimal uniBadal;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private BigDecimal elawaVal3;

    public PerFiscalDegreeDetailNew() {
    }

	
    public PerFiscalDegreeDetailNew(PerFiscalDegreeCodeNew perFiscalDegreeCodeNew, BigDecimal startSalary, BigDecimal endSalary, String degreePeriodicElawa, String degreeEncouragElawa) {
        this.perFiscalDegreeCodeNew = perFiscalDegreeCodeNew;
        this.startSalary = startSalary;
        this.endSalary = endSalary;
        this.degreePeriodicElawa = degreePeriodicElawa;
        this.degreeEncouragElawa = degreeEncouragElawa;
    }
    public PerFiscalDegreeDetailNew(PerFiscalDegreeCodeNew perFiscalDegreeCodeNew, BigDecimal startSalary, BigDecimal endSalary, String degreePeriodicElawa, String degreeEncouragElawa, BigDecimal avgSalary, BigDecimal elawaVal1, BigDecimal elawaVal2, BigDecimal salForElawa2, BigDecimal constantElawa, BigDecimal salForConstantElawa, Byte maxNoForConstantElawa, BigDecimal uniBadal, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, BigDecimal elawaVal3) {
       this.perFiscalDegreeCodeNew = perFiscalDegreeCodeNew;
       this.startSalary = startSalary;
       this.endSalary = endSalary;
       this.degreePeriodicElawa = degreePeriodicElawa;
       this.degreeEncouragElawa = degreeEncouragElawa;
       this.avgSalary = avgSalary;
       this.elawaVal1 = elawaVal1;
       this.elawaVal2 = elawaVal2;
       this.salForElawa2 = salForElawa2;
       this.constantElawa = constantElawa;
       this.salForConstantElawa = salForConstantElawa;
       this.maxNoForConstantElawa = maxNoForConstantElawa;
       this.uniBadal = uniBadal;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.elawaVal3 = elawaVal3;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="perFiscalDegreeCodeNew"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="FISCAL_DEGREE_CODE_NEW", nullable=false, length=3)
    public String getFiscalDegreeCodeNew() {
        return this.fiscalDegreeCodeNew;
    }
    
    public void setFiscalDegreeCodeNew(String fiscalDegreeCodeNew) {
        this.fiscalDegreeCodeNew = fiscalDegreeCodeNew;
    }

@OneToOne(fetch=FetchType.EAGER)@PrimaryKeyJoinColumn
    public PerFiscalDegreeCodeNew getPerFiscalDegreeCodeNew() {
        return this.perFiscalDegreeCodeNew;
    }
    
    public void setPerFiscalDegreeCodeNew(PerFiscalDegreeCodeNew perFiscalDegreeCodeNew) {
        this.perFiscalDegreeCodeNew = perFiscalDegreeCodeNew;
    }

    
    @Column(name="START_SALARY", nullable=false, precision=9)
    public BigDecimal getStartSalary() {
        return this.startSalary;
    }
    
    public void setStartSalary(BigDecimal startSalary) {
        this.startSalary = startSalary;
    }

    
    @Column(name="END_SALARY", nullable=false, precision=9)
    public BigDecimal getEndSalary() {
        return this.endSalary;
    }
    
    public void setEndSalary(BigDecimal endSalary) {
        this.endSalary = endSalary;
    }

    
    @Column(name="DEGREE_PERIODIC_ELAWA", nullable=false, length=3)
    public String getDegreePeriodicElawa() {
        return this.degreePeriodicElawa;
    }
    
    public void setDegreePeriodicElawa(String degreePeriodicElawa) {
        this.degreePeriodicElawa = degreePeriodicElawa;
    }

    
    @Column(name="DEGREE_ENCOURAG_ELAWA", nullable=false, length=3)
    public String getDegreeEncouragElawa() {
        return this.degreeEncouragElawa;
    }
    
    public void setDegreeEncouragElawa(String degreeEncouragElawa) {
        this.degreeEncouragElawa = degreeEncouragElawa;
    }

    
    @Column(name="AVG_SALARY", precision=9)
    public BigDecimal getAvgSalary() {
        return this.avgSalary;
    }
    
    public void setAvgSalary(BigDecimal avgSalary) {
        this.avgSalary = avgSalary;
    }

    
    @Column(name="ELAWA_VAL1", precision=9)
    public BigDecimal getElawaVal1() {
        return this.elawaVal1;
    }
    
    public void setElawaVal1(BigDecimal elawaVal1) {
        this.elawaVal1 = elawaVal1;
    }

    
    @Column(name="ELAWA_VAL2", precision=9)
    public BigDecimal getElawaVal2() {
        return this.elawaVal2;
    }
    
    public void setElawaVal2(BigDecimal elawaVal2) {
        this.elawaVal2 = elawaVal2;
    }

    
    @Column(name="SAL_FOR_ELAWA2", precision=9)
    public BigDecimal getSalForElawa2() {
        return this.salForElawa2;
    }
    
    public void setSalForElawa2(BigDecimal salForElawa2) {
        this.salForElawa2 = salForElawa2;
    }

    
    @Column(name="CONSTANT_ELAWA", precision=9)
    public BigDecimal getConstantElawa() {
        return this.constantElawa;
    }
    
    public void setConstantElawa(BigDecimal constantElawa) {
        this.constantElawa = constantElawa;
    }

    
    @Column(name="SAL_FOR_CONSTANT_ELAWA", precision=9)
    public BigDecimal getSalForConstantElawa() {
        return this.salForConstantElawa;
    }
    
    public void setSalForConstantElawa(BigDecimal salForConstantElawa) {
        this.salForConstantElawa = salForConstantElawa;
    }

    
    @Column(name="MAX_NO_FOR_CONSTANT_ELAWA", precision=2, scale=0)
    public Byte getMaxNoForConstantElawa() {
        return this.maxNoForConstantElawa;
    }
    
    public void setMaxNoForConstantElawa(Byte maxNoForConstantElawa) {
        this.maxNoForConstantElawa = maxNoForConstantElawa;
    }

    
    @Column(name="UNI_BADAL", precision=9)
    public BigDecimal getUniBadal() {
        return this.uniBadal;
    }
    
    public void setUniBadal(BigDecimal uniBadal) {
        this.uniBadal = uniBadal;
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

    
    @Column(name="ELAWA_VAL3", precision=9)
    public BigDecimal getElawaVal3() {
        return this.elawaVal3;
    }
    
    public void setElawaVal3(BigDecimal elawaVal3) {
        this.elawaVal3 = elawaVal3;
    }




}


