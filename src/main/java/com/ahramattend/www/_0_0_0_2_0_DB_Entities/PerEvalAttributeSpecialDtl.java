package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PerEvalAttributeSpecialDtl generated by hbm2java
 */
@Entity
@Table(name="PER_EVAL_ATTRIBUTE_SPECIAL_DTL"
    ,schema="SHAMS"
)
public class PerEvalAttributeSpecialDtl  implements java.io.Serializable {


     private String serial;
     private PerEvalAttribute perEvalAttribute;
     private Integer evalDegree1;
     private Integer evalDegree2;
     private Set<PerAnnualEvalEmpDetail> perAnnualEvalEmpDetails = new HashSet<PerAnnualEvalEmpDetail>(0);

    public PerEvalAttributeSpecialDtl() {
    }

	
    public PerEvalAttributeSpecialDtl(String serial, PerEvalAttribute perEvalAttribute) {
        this.serial = serial;
        this.perEvalAttribute = perEvalAttribute;
    }
    public PerEvalAttributeSpecialDtl(String serial, PerEvalAttribute perEvalAttribute, Integer evalDegree1, Integer evalDegree2, Set<PerAnnualEvalEmpDetail> perAnnualEvalEmpDetails) {
       this.serial = serial;
       this.perEvalAttribute = perEvalAttribute;
       this.evalDegree1 = evalDegree1;
       this.evalDegree2 = evalDegree2;
       this.perAnnualEvalEmpDetails = perAnnualEvalEmpDetails;
    }
   
     @Id 

    
    @Column(name="SERIAL", unique=true, nullable=false, length=5)
    public String getSerial() {
        return this.serial;
    }
    
    public void setSerial(String serial) {
        this.serial = serial;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ATTRIBUTE_NO", nullable=false)
    public PerEvalAttribute getPerEvalAttribute() {
        return this.perEvalAttribute;
    }
    
    public void setPerEvalAttribute(PerEvalAttribute perEvalAttribute) {
        this.perEvalAttribute = perEvalAttribute;
    }

    
    @Column(name="EVAL_DEGREE_1", precision=5, scale=0)
    public Integer getEvalDegree1() {
        return this.evalDegree1;
    }
    
    public void setEvalDegree1(Integer evalDegree1) {
        this.evalDegree1 = evalDegree1;
    }

    
    @Column(name="EVAL_DEGREE_2", precision=5, scale=0)
    public Integer getEvalDegree2() {
        return this.evalDegree2;
    }
    
    public void setEvalDegree2(Integer evalDegree2) {
        this.evalDegree2 = evalDegree2;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perEvalAttributeSpecialDtl")
    public Set<PerAnnualEvalEmpDetail> getPerAnnualEvalEmpDetails() {
        return this.perAnnualEvalEmpDetails;
    }
    
    public void setPerAnnualEvalEmpDetails(Set<PerAnnualEvalEmpDetail> perAnnualEvalEmpDetails) {
        this.perAnnualEvalEmpDetails = perAnnualEvalEmpDetails;
    }




}


