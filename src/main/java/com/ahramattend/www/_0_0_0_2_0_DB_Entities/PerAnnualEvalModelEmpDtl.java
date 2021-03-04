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
 * PerAnnualEvalModelEmpDtl generated by hbm2java
 */
@Entity
@Table(name="PER_ANNUAL_EVAL_MODEL_EMP_DTL"
    ,schema="SHAMS"
)
public class PerAnnualEvalModelEmpDtl  implements java.io.Serializable {


     private PerAnnualEvalModelEmpDtlId id;
     private PerEvalPercentage perEvalPercentageByGradeCodeDirectboss;
     private PerEvalPercentage perEvalPercentageByGradeCodeBigboss;
     private PerEvalPercentage perEvalPercentageByGradeCode;
     private PerAnnualEvalModelEmp perAnnualEvalModelEmp;
     private int directBossDegree;
     private String serialNoAttribute;
     private String directBossOpinion;
     private Integer bigBossDegree;
     private String bigBossOpinion;
     private Integer commityDegree;
     private String commityOpinion;

    public PerAnnualEvalModelEmpDtl() {
    }

	
    public PerAnnualEvalModelEmpDtl(PerAnnualEvalModelEmpDtlId id, PerAnnualEvalModelEmp perAnnualEvalModelEmp, int directBossDegree) {
        this.id = id;
        this.perAnnualEvalModelEmp = perAnnualEvalModelEmp;
        this.directBossDegree = directBossDegree;
    }
    public PerAnnualEvalModelEmpDtl(PerAnnualEvalModelEmpDtlId id, PerEvalPercentage perEvalPercentageByGradeCodeDirectboss, PerEvalPercentage perEvalPercentageByGradeCodeBigboss, PerEvalPercentage perEvalPercentageByGradeCode, PerAnnualEvalModelEmp perAnnualEvalModelEmp, int directBossDegree, String serialNoAttribute, String directBossOpinion, Integer bigBossDegree, String bigBossOpinion, Integer commityDegree, String commityOpinion) {
       this.id = id;
       this.perEvalPercentageByGradeCodeDirectboss = perEvalPercentageByGradeCodeDirectboss;
       this.perEvalPercentageByGradeCodeBigboss = perEvalPercentageByGradeCodeBigboss;
       this.perEvalPercentageByGradeCode = perEvalPercentageByGradeCode;
       this.perAnnualEvalModelEmp = perAnnualEvalModelEmp;
       this.directBossDegree = directBossDegree;
       this.serialNoAttribute = serialNoAttribute;
       this.directBossOpinion = directBossOpinion;
       this.bigBossDegree = bigBossDegree;
       this.bigBossOpinion = bigBossOpinion;
       this.commityDegree = commityDegree;
       this.commityOpinion = commityOpinion;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locationCode", column=@Column(name="LOCATION_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ), 
        @AttributeOverride(name="serialNo", column=@Column(name="SERIAL_NO", nullable=false, length=5) ), 
        @AttributeOverride(name="annualId", column=@Column(name="ANNUAL_ID", nullable=false, length=5) ), 
        @AttributeOverride(name="serialNoDetail", column=@Column(name="SERIAL_NO_DETAIL", nullable=false, length=5) ) } )
    public PerAnnualEvalModelEmpDtlId getId() {
        return this.id;
    }
    
    public void setId(PerAnnualEvalModelEmpDtlId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GRADE_CODE_DIRECTBOSS")
    public PerEvalPercentage getPerEvalPercentageByGradeCodeDirectboss() {
        return this.perEvalPercentageByGradeCodeDirectboss;
    }
    
    public void setPerEvalPercentageByGradeCodeDirectboss(PerEvalPercentage perEvalPercentageByGradeCodeDirectboss) {
        this.perEvalPercentageByGradeCodeDirectboss = perEvalPercentageByGradeCodeDirectboss;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GRADE_CODE_BIGBOSS")
    public PerEvalPercentage getPerEvalPercentageByGradeCodeBigboss() {
        return this.perEvalPercentageByGradeCodeBigboss;
    }
    
    public void setPerEvalPercentageByGradeCodeBigboss(PerEvalPercentage perEvalPercentageByGradeCodeBigboss) {
        this.perEvalPercentageByGradeCodeBigboss = perEvalPercentageByGradeCodeBigboss;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="GRADE_CODE")
    public PerEvalPercentage getPerEvalPercentageByGradeCode() {
        return this.perEvalPercentageByGradeCode;
    }
    
    public void setPerEvalPercentageByGradeCode(PerEvalPercentage perEvalPercentageByGradeCode) {
        this.perEvalPercentageByGradeCode = perEvalPercentageByGradeCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="ANNUAL_ID", referencedColumnName="ANNUAL_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="SERIAL_NO", referencedColumnName="SERIAL_NO", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="EMPLOYEE_ID", referencedColumnName="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false) } )
    public PerAnnualEvalModelEmp getPerAnnualEvalModelEmp() {
        return this.perAnnualEvalModelEmp;
    }
    
    public void setPerAnnualEvalModelEmp(PerAnnualEvalModelEmp perAnnualEvalModelEmp) {
        this.perAnnualEvalModelEmp = perAnnualEvalModelEmp;
    }

    
    @Column(name="DIRECT_BOSS_DEGREE", nullable=false, precision=5, scale=0)
    public int getDirectBossDegree() {
        return this.directBossDegree;
    }
    
    public void setDirectBossDegree(int directBossDegree) {
        this.directBossDegree = directBossDegree;
    }

    
    @Column(name="SERIAL_NO_ATTRIBUTE", length=5)
    public String getSerialNoAttribute() {
        return this.serialNoAttribute;
    }
    
    public void setSerialNoAttribute(String serialNoAttribute) {
        this.serialNoAttribute = serialNoAttribute;
    }

    
    @Column(name="DIRECT_BOSS_OPINION", length=50)
    public String getDirectBossOpinion() {
        return this.directBossOpinion;
    }
    
    public void setDirectBossOpinion(String directBossOpinion) {
        this.directBossOpinion = directBossOpinion;
    }

    
    @Column(name="BIG_BOSS_DEGREE", precision=5, scale=0)
    public Integer getBigBossDegree() {
        return this.bigBossDegree;
    }
    
    public void setBigBossDegree(Integer bigBossDegree) {
        this.bigBossDegree = bigBossDegree;
    }

    
    @Column(name="BIG_BOSS_OPINION", length=50)
    public String getBigBossOpinion() {
        return this.bigBossOpinion;
    }
    
    public void setBigBossOpinion(String bigBossOpinion) {
        this.bigBossOpinion = bigBossOpinion;
    }

    
    @Column(name="COMMITY_DEGREE", precision=5, scale=0)
    public Integer getCommityDegree() {
        return this.commityDegree;
    }
    
    public void setCommityDegree(Integer commityDegree) {
        this.commityDegree = commityDegree;
    }

    
    @Column(name="COMMITY_OPINION", length=50)
    public String getCommityOpinion() {
        return this.commityOpinion;
    }
    
    public void setCommityOpinion(String commityOpinion) {
        this.commityOpinion = commityOpinion;
    }




}

