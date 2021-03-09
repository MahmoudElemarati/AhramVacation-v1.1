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
 * PayFinancialGroupType generated by hbm2java
 */
@Entity
@Table(name="PAY_FINANCIAL_GROUP_TYPE"
    ,schema="SHAMS"
)
public class PayFinancialGroupType  implements java.io.Serializable {


     private PayFinancialGroupTypeId id;
     private PayFinancialStatusCode payFinancialStatusCode;
     private PerGroupTypeCode perGroupTypeCode;
     private String groupName;
     private Short ratio;
     private Set<PayFinancialGroupBand> payFinancialGroupBands = new HashSet<PayFinancialGroupBand>(0);
     private Set<PayExecutionSpecificEmp> payExecutionSpecificEmps = new HashSet<PayExecutionSpecificEmp>(0);
     private Set<PayEmployeeMaster> payEmployeeMasters = new HashSet<PayEmployeeMaster>(0);

    public PayFinancialGroupType() {
    }

	
    public PayFinancialGroupType(PayFinancialGroupTypeId id, PayFinancialStatusCode payFinancialStatusCode) {
        this.id = id;
        this.payFinancialStatusCode = payFinancialStatusCode;
    }
    public PayFinancialGroupType(PayFinancialGroupTypeId id, PayFinancialStatusCode payFinancialStatusCode, PerGroupTypeCode perGroupTypeCode, String groupName, Short ratio, Set<PayFinancialGroupBand> payFinancialGroupBands, Set<PayExecutionSpecificEmp> payExecutionSpecificEmps, Set<PayEmployeeMaster> payEmployeeMasters) {
       this.id = id;
       this.payFinancialStatusCode = payFinancialStatusCode;
       this.perGroupTypeCode = perGroupTypeCode;
       this.groupName = groupName;
       this.ratio = ratio;
       this.payFinancialGroupBands = payFinancialGroupBands;
       this.payExecutionSpecificEmps = payExecutionSpecificEmps;
       this.payEmployeeMasters = payEmployeeMasters;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="statusCode", column=@Column(name="STATUS_CODE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="statusGroup", column=@Column(name="STATUS_GROUP", nullable=false, precision=4, scale=0) ) } )
    public PayFinancialGroupTypeId getId() {
        return this.id;
    }
    
    public void setId(PayFinancialGroupTypeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="STATUS_CODE", nullable=false, insertable=false, updatable=false)
    public PayFinancialStatusCode getPayFinancialStatusCode() {
        return this.payFinancialStatusCode;
    }
    
    public void setPayFinancialStatusCode(PayFinancialStatusCode payFinancialStatusCode) {
        this.payFinancialStatusCode = payFinancialStatusCode;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="GROUP_TYPE_CODE")
    public PerGroupTypeCode getPerGroupTypeCode() {
        return this.perGroupTypeCode;
    }
    
    public void setPerGroupTypeCode(PerGroupTypeCode perGroupTypeCode) {
        this.perGroupTypeCode = perGroupTypeCode;
    }

    
    @Column(name="GROUP_NAME", length=100)
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    
    @Column(name="RATIO", precision=3, scale=0)
    public Short getRatio() {
        return this.ratio;
    }
    
    public void setRatio(Short ratio) {
        this.ratio = ratio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payFinancialGroupType")
    public Set<PayFinancialGroupBand> getPayFinancialGroupBands() {
        return this.payFinancialGroupBands;
    }
    
    public void setPayFinancialGroupBands(Set<PayFinancialGroupBand> payFinancialGroupBands) {
        this.payFinancialGroupBands = payFinancialGroupBands;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payFinancialGroupType")
    public Set<PayExecutionSpecificEmp> getPayExecutionSpecificEmps() {
        return this.payExecutionSpecificEmps;
    }
    
    public void setPayExecutionSpecificEmps(Set<PayExecutionSpecificEmp> payExecutionSpecificEmps) {
        this.payExecutionSpecificEmps = payExecutionSpecificEmps;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payFinancialGroupType")
    public Set<PayEmployeeMaster> getPayEmployeeMasters() {
        return this.payEmployeeMasters;
    }
    
    public void setPayEmployeeMasters(Set<PayEmployeeMaster> payEmployeeMasters) {
        this.payEmployeeMasters = payEmployeeMasters;
    }




}


