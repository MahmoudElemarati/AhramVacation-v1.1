package com.ahramattend.www._0_0_0_2_0_DB_Entities;
// Generated Mar 9, 2021 2:52:01 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * PayEmployeeMaster generated by hbm2java
 */
@Entity
@Table(name="PAY_EMPLOYEE_MASTER"
    ,schema="SHAMS"
)
public class PayEmployeeMaster  implements java.io.Serializable {


     private String employeeId;
     private PayFinancialGroupType payFinancialGroupType;
     private PerEmploymentMasters perEmploymentMasters;
     private String locationCode;
     private String employeeNo;
     private String empAname;
     private String groupTypeCode;
     private Boolean deserveType;
     private String generalCode;
     private Date contractDate;
     private Date degreeDate;
     private String fiscalDegreeCode;
     private Date degreePriorityDate;
     private Integer degreePriority;
     private Date contractEnddate;
     private String jobCode;
     private String qualCode;
     private Boolean empState;
     private Short empRatio;
     private String EFinEmp;
     private Integer costCode;
     private Byte factoryCode;
     private Set<PayDeserveEmpFileDtlRuf> payDeserveEmpFileDtlRufs = new HashSet<PayDeserveEmpFileDtlRuf>(0);
     private Set<PayDeserveEmp> payDeserveEmps = new HashSet<PayDeserveEmp>(0);
     private Set<PayDeserveEmpFileStop> payDeserveEmpFileStops = new HashSet<PayDeserveEmpFileStop>(0);
     private Set<PaySarfCodeEmp> paySarfCodeEmps = new HashSet<PaySarfCodeEmp>(0);
     private Set<PayDeserveEmpFileDtl> payDeserveEmpFileDtlsForEmployeeId = new HashSet<PayDeserveEmpFileDtl>(0);
     private Set<PayExecutionSpecificEmp> payExecutionSpecificEmps = new HashSet<PayExecutionSpecificEmp>(0);
     private Set<PayDeserveEmpFile> payDeserveEmpFilesForEmployeeIdSent = new HashSet<PayDeserveEmpFile>(0);
     private Set<PayDeserveEmpFileDtl> payDeserveEmpFileDtlsForEmployeeIdUser = new HashSet<PayDeserveEmpFileDtl>(0);
     private Set<PayDeserveEmpFile> payDeserveEmpFilesForEmployeeId = new HashSet<PayDeserveEmpFile>(0);

    public PayEmployeeMaster() {
    }

	
    public PayEmployeeMaster(PerEmploymentMasters perEmploymentMasters, String locationCode) {
        this.perEmploymentMasters = perEmploymentMasters;
        this.locationCode = locationCode;
    }
    public PayEmployeeMaster(PayFinancialGroupType payFinancialGroupType, PerEmploymentMasters perEmploymentMasters, String locationCode, String employeeNo, String empAname, String groupTypeCode, Boolean deserveType, String generalCode, Date contractDate, Date degreeDate, String fiscalDegreeCode, Date degreePriorityDate, Integer degreePriority, Date contractEnddate, String jobCode, String qualCode, Boolean empState, Short empRatio, String EFinEmp, Integer costCode, Byte factoryCode, Set<PayDeserveEmpFileDtlRuf> payDeserveEmpFileDtlRufs, Set<PayDeserveEmp> payDeserveEmps, Set<PayDeserveEmpFileStop> payDeserveEmpFileStops, Set<PaySarfCodeEmp> paySarfCodeEmps, Set<PayDeserveEmpFileDtl> payDeserveEmpFileDtlsForEmployeeId, Set<PayExecutionSpecificEmp> payExecutionSpecificEmps, Set<PayDeserveEmpFile> payDeserveEmpFilesForEmployeeIdSent, Set<PayDeserveEmpFileDtl> payDeserveEmpFileDtlsForEmployeeIdUser, Set<PayDeserveEmpFile> payDeserveEmpFilesForEmployeeId) {
       this.payFinancialGroupType = payFinancialGroupType;
       this.perEmploymentMasters = perEmploymentMasters;
       this.locationCode = locationCode;
       this.employeeNo = employeeNo;
       this.empAname = empAname;
       this.groupTypeCode = groupTypeCode;
       this.deserveType = deserveType;
       this.generalCode = generalCode;
       this.contractDate = contractDate;
       this.degreeDate = degreeDate;
       this.fiscalDegreeCode = fiscalDegreeCode;
       this.degreePriorityDate = degreePriorityDate;
       this.degreePriority = degreePriority;
       this.contractEnddate = contractEnddate;
       this.jobCode = jobCode;
       this.qualCode = qualCode;
       this.empState = empState;
       this.empRatio = empRatio;
       this.EFinEmp = EFinEmp;
       this.costCode = costCode;
       this.factoryCode = factoryCode;
       this.payDeserveEmpFileDtlRufs = payDeserveEmpFileDtlRufs;
       this.payDeserveEmps = payDeserveEmps;
       this.payDeserveEmpFileStops = payDeserveEmpFileStops;
       this.paySarfCodeEmps = paySarfCodeEmps;
       this.payDeserveEmpFileDtlsForEmployeeId = payDeserveEmpFileDtlsForEmployeeId;
       this.payExecutionSpecificEmps = payExecutionSpecificEmps;
       this.payDeserveEmpFilesForEmployeeIdSent = payDeserveEmpFilesForEmployeeIdSent;
       this.payDeserveEmpFileDtlsForEmployeeIdUser = payDeserveEmpFileDtlsForEmployeeIdUser;
       this.payDeserveEmpFilesForEmployeeId = payDeserveEmpFilesForEmployeeId;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="perEmploymentMasters"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="EMPLOYEE_ID", nullable=false, length=10)
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="STATUS_CODE", referencedColumnName="STATUS_CODE"), 
        @JoinColumn(name="STATUS_GROUP", referencedColumnName="STATUS_GROUP") } )
    public PayFinancialGroupType getPayFinancialGroupType() {
        return this.payFinancialGroupType;
    }
    
    public void setPayFinancialGroupType(PayFinancialGroupType payFinancialGroupType) {
        this.payFinancialGroupType = payFinancialGroupType;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public PerEmploymentMasters getPerEmploymentMasters() {
        return this.perEmploymentMasters;
    }
    
    public void setPerEmploymentMasters(PerEmploymentMasters perEmploymentMasters) {
        this.perEmploymentMasters = perEmploymentMasters;
    }

    
    @Column(name="LOCATION_CODE", nullable=false, length=3)
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    
    @Column(name="EMPLOYEE_NO", length=10)
    public String getEmployeeNo() {
        return this.employeeNo;
    }
    
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    
    @Column(name="EMP_ANAME", length=75)
    public String getEmpAname() {
        return this.empAname;
    }
    
    public void setEmpAname(String empAname) {
        this.empAname = empAname;
    }

    
    @Column(name="GROUP_TYPE_CODE", length=3)
    public String getGroupTypeCode() {
        return this.groupTypeCode;
    }
    
    public void setGroupTypeCode(String groupTypeCode) {
        this.groupTypeCode = groupTypeCode;
    }

    
    @Column(name="DESERVE_TYPE", precision=1, scale=0)
    public Boolean getDeserveType() {
        return this.deserveType;
    }
    
    public void setDeserveType(Boolean deserveType) {
        this.deserveType = deserveType;
    }

    
    @Column(name="GENERAL_CODE", length=3)
    public String getGeneralCode() {
        return this.generalCode;
    }
    
    public void setGeneralCode(String generalCode) {
        this.generalCode = generalCode;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CONTRACT_DATE", length=7)
    public Date getContractDate() {
        return this.contractDate;
    }
    
    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DEGREE_DATE", length=7)
    public Date getDegreeDate() {
        return this.degreeDate;
    }
    
    public void setDegreeDate(Date degreeDate) {
        this.degreeDate = degreeDate;
    }

    
    @Column(name="FISCAL_DEGREE_CODE", length=3)
    public String getFiscalDegreeCode() {
        return this.fiscalDegreeCode;
    }
    
    public void setFiscalDegreeCode(String fiscalDegreeCode) {
        this.fiscalDegreeCode = fiscalDegreeCode;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DEGREE_PRIORITY_DATE", length=7)
    public Date getDegreePriorityDate() {
        return this.degreePriorityDate;
    }
    
    public void setDegreePriorityDate(Date degreePriorityDate) {
        this.degreePriorityDate = degreePriorityDate;
    }

    
    @Column(name="DEGREE_PRIORITY", precision=5, scale=0)
    public Integer getDegreePriority() {
        return this.degreePriority;
    }
    
    public void setDegreePriority(Integer degreePriority) {
        this.degreePriority = degreePriority;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CONTRACT_ENDDATE", length=7)
    public Date getContractEnddate() {
        return this.contractEnddate;
    }
    
    public void setContractEnddate(Date contractEnddate) {
        this.contractEnddate = contractEnddate;
    }

    
    @Column(name="JOB_CODE", length=5)
    public String getJobCode() {
        return this.jobCode;
    }
    
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    
    @Column(name="QUAL_CODE", length=5)
    public String getQualCode() {
        return this.qualCode;
    }
    
    public void setQualCode(String qualCode) {
        this.qualCode = qualCode;
    }

    
    @Column(name="EMP_STATE", precision=1, scale=0)
    public Boolean getEmpState() {
        return this.empState;
    }
    
    public void setEmpState(Boolean empState) {
        this.empState = empState;
    }

    
    @Column(name="EMP_RATIO", precision=3, scale=0)
    public Short getEmpRatio() {
        return this.empRatio;
    }
    
    public void setEmpRatio(Short empRatio) {
        this.empRatio = empRatio;
    }

    
    @Column(name="E_FIN_EMP", length=10)
    public String getEFinEmp() {
        return this.EFinEmp;
    }
    
    public void setEFinEmp(String EFinEmp) {
        this.EFinEmp = EFinEmp;
    }

    
    @Column(name="COST_CODE", precision=6, scale=0)
    public Integer getCostCode() {
        return this.costCode;
    }
    
    public void setCostCode(Integer costCode) {
        this.costCode = costCode;
    }

    
    @Column(name="FACTORY_CODE", precision=2, scale=0)
    public Byte getFactoryCode() {
        return this.factoryCode;
    }
    
    public void setFactoryCode(Byte factoryCode) {
        this.factoryCode = factoryCode;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payEmployeeMaster")
    public Set<PayDeserveEmpFileDtlRuf> getPayDeserveEmpFileDtlRufs() {
        return this.payDeserveEmpFileDtlRufs;
    }
    
    public void setPayDeserveEmpFileDtlRufs(Set<PayDeserveEmpFileDtlRuf> payDeserveEmpFileDtlRufs) {
        this.payDeserveEmpFileDtlRufs = payDeserveEmpFileDtlRufs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payEmployeeMaster")
    public Set<PayDeserveEmp> getPayDeserveEmps() {
        return this.payDeserveEmps;
    }
    
    public void setPayDeserveEmps(Set<PayDeserveEmp> payDeserveEmps) {
        this.payDeserveEmps = payDeserveEmps;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payEmployeeMaster")
    public Set<PayDeserveEmpFileStop> getPayDeserveEmpFileStops() {
        return this.payDeserveEmpFileStops;
    }
    
    public void setPayDeserveEmpFileStops(Set<PayDeserveEmpFileStop> payDeserveEmpFileStops) {
        this.payDeserveEmpFileStops = payDeserveEmpFileStops;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payEmployeeMaster")
    public Set<PaySarfCodeEmp> getPaySarfCodeEmps() {
        return this.paySarfCodeEmps;
    }
    
    public void setPaySarfCodeEmps(Set<PaySarfCodeEmp> paySarfCodeEmps) {
        this.paySarfCodeEmps = paySarfCodeEmps;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payEmployeeMasterByEmployeeId")
    public Set<PayDeserveEmpFileDtl> getPayDeserveEmpFileDtlsForEmployeeId() {
        return this.payDeserveEmpFileDtlsForEmployeeId;
    }
    
    public void setPayDeserveEmpFileDtlsForEmployeeId(Set<PayDeserveEmpFileDtl> payDeserveEmpFileDtlsForEmployeeId) {
        this.payDeserveEmpFileDtlsForEmployeeId = payDeserveEmpFileDtlsForEmployeeId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payEmployeeMaster")
    public Set<PayExecutionSpecificEmp> getPayExecutionSpecificEmps() {
        return this.payExecutionSpecificEmps;
    }
    
    public void setPayExecutionSpecificEmps(Set<PayExecutionSpecificEmp> payExecutionSpecificEmps) {
        this.payExecutionSpecificEmps = payExecutionSpecificEmps;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payEmployeeMasterByEmployeeIdSent")
    public Set<PayDeserveEmpFile> getPayDeserveEmpFilesForEmployeeIdSent() {
        return this.payDeserveEmpFilesForEmployeeIdSent;
    }
    
    public void setPayDeserveEmpFilesForEmployeeIdSent(Set<PayDeserveEmpFile> payDeserveEmpFilesForEmployeeIdSent) {
        this.payDeserveEmpFilesForEmployeeIdSent = payDeserveEmpFilesForEmployeeIdSent;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payEmployeeMasterByEmployeeIdUser")
    public Set<PayDeserveEmpFileDtl> getPayDeserveEmpFileDtlsForEmployeeIdUser() {
        return this.payDeserveEmpFileDtlsForEmployeeIdUser;
    }
    
    public void setPayDeserveEmpFileDtlsForEmployeeIdUser(Set<PayDeserveEmpFileDtl> payDeserveEmpFileDtlsForEmployeeIdUser) {
        this.payDeserveEmpFileDtlsForEmployeeIdUser = payDeserveEmpFileDtlsForEmployeeIdUser;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="payEmployeeMasterByEmployeeId")
    public Set<PayDeserveEmpFile> getPayDeserveEmpFilesForEmployeeId() {
        return this.payDeserveEmpFilesForEmployeeId;
    }
    
    public void setPayDeserveEmpFilesForEmployeeId(Set<PayDeserveEmpFile> payDeserveEmpFilesForEmployeeId) {
        this.payDeserveEmpFilesForEmployeeId = payDeserveEmpFilesForEmployeeId;
    }




}


