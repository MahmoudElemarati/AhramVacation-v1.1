package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PayFinancialCode generated by hbm2java
 */
@Entity
@Table(name="PAY_FINANCIAL_CODE"
    ,schema="SHAMS"
)
public class PayFinancialCode  implements java.io.Serializable {


     private String financialCode;
     private String financialName;
     private Set<PayBandCode> payBandCodes = new HashSet<PayBandCode>(0);

    public PayFinancialCode() {
    }

	
    public PayFinancialCode(String financialCode, String financialName) {
        this.financialCode = financialCode;
        this.financialName = financialName;
    }
    public PayFinancialCode(String financialCode, String financialName, Set<PayBandCode> payBandCodes) {
       this.financialCode = financialCode;
       this.financialName = financialName;
       this.payBandCodes = payBandCodes;
    }
   
     @Id 

    
    @Column(name="FINANCIAL_CODE", unique=true, nullable=false, length=13)
    public String getFinancialCode() {
        return this.financialCode;
    }
    
    public void setFinancialCode(String financialCode) {
        this.financialCode = financialCode;
    }

    
    @Column(name="FINANCIAL_NAME", nullable=false, length=100)
    public String getFinancialName() {
        return this.financialName;
    }
    
    public void setFinancialName(String financialName) {
        this.financialName = financialName;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="payFinancialCode")
    public Set<PayBandCode> getPayBandCodes() {
        return this.payBandCodes;
    }
    
    public void setPayBandCodes(Set<PayBandCode> payBandCodes) {
        this.payBandCodes = payBandCodes;
    }




}


