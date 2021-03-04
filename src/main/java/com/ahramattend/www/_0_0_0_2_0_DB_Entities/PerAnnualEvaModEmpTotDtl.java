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
 * PerAnnualEvaModEmpTotDtl generated by hbm2java
 */
@Entity
@Table(name="PER_ANNUAL_EVA_MOD_EMP_TOT_DTL"
    ,schema="SHAMS"
)
public class PerAnnualEvaModEmpTotDtl  implements java.io.Serializable {


     private PerAnnualEvaModEmpTotDtlId id;
     private PerAnnualEvalModEmpTot perAnnualEvalModEmpTot;
     private String serialNo;

    public PerAnnualEvaModEmpTotDtl() {
    }

	
    public PerAnnualEvaModEmpTotDtl(PerAnnualEvaModEmpTotDtlId id, PerAnnualEvalModEmpTot perAnnualEvalModEmpTot) {
        this.id = id;
        this.perAnnualEvalModEmpTot = perAnnualEvalModEmpTot;
    }
    public PerAnnualEvaModEmpTotDtl(PerAnnualEvaModEmpTotDtlId id, PerAnnualEvalModEmpTot perAnnualEvalModEmpTot, String serialNo) {
       this.id = id;
       this.perAnnualEvalModEmpTot = perAnnualEvalModEmpTot;
       this.serialNo = serialNo;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, length=10) ), 
        @AttributeOverride(name="empSerial", column=@Column(name="EMP_SERIAL", nullable=false, length=5) ), 
        @AttributeOverride(name="serialNoTotDetail", column=@Column(name="SERIAL_NO_TOT_DETAIL", nullable=false, length=5) ) } )
    public PerAnnualEvaModEmpTotDtlId getId() {
        return this.id;
    }
    
    public void setId(PerAnnualEvaModEmpTotDtlId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="EMPLOYEE_ID", referencedColumnName="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="EMP_SERIAL", referencedColumnName="EMP_SERIAL", nullable=false, insertable=false, updatable=false) } )
    public PerAnnualEvalModEmpTot getPerAnnualEvalModEmpTot() {
        return this.perAnnualEvalModEmpTot;
    }
    
    public void setPerAnnualEvalModEmpTot(PerAnnualEvalModEmpTot perAnnualEvalModEmpTot) {
        this.perAnnualEvalModEmpTot = perAnnualEvalModEmpTot;
    }

    
    @Column(name="SERIAL_NO", length=5)
    public String getSerialNo() {
        return this.serialNo;
    }
    
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }




}

