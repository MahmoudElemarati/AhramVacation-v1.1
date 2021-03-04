/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Adam
 */
public class PerEmploymentMasters_DAO<T> extends AbstractDao<T> {

    final private String General_HQL = " p.perGeneralCodeByGeneralCode.generalCode!=20";

    public List<PerEmploymentMasters> getAll_Employees() {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p " + General_HQL + " where  ORDER BY p.empAname "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public long getGenderCountPerOrgId(String sexFlag, String orgId, String locationCode, String generalCode) {
        Query query = session.createQuery("SELECT count(*) FROM PerEmploymentMasters p where p.perLocationCodes.id.locationCode=" + locationCode + " and " + generalCode + " p.perOrganizationStructureByOrgId.orgId=" + orgId + " and p.sexFlag=" + sexFlag + " "); //HQL
        List<Long> pList = query.getResultList();
        return pList.get(0);
    }

    public long getGenderCountPerCadreDegreeCode(String sexFlag, String fiscalDegreeCode, String locationCode, String generalCode) {
        Query query = session.createQuery("SELECT count(*) FROM PerEmploymentMasters p where p.perLocationCodes.id.locationCode=" + locationCode + " and " + generalCode + " p.perFiscalDegreeCode.fiscalDegreeCode=" + fiscalDegreeCode + " and p.sexFlag=" + sexFlag + " "); //HQL
        List<Long> pList = query.getResultList();
        return pList.get(0);
    }

    public long getGenderCountPerFesicalAndOrg(String sexFlag, String fiscalDegreeCode, String OrgId, String locationCode, String generalCode) {
        Query query = session.createQuery("SELECT count(*) FROM PerEmploymentMasters p where p.perLocationCodes.id.locationCode=" + locationCode + " and " + generalCode + " p.perFiscalDegreeCode.fiscalDegreeCode=" + fiscalDegreeCode + " and p.perOrganizationStructureByOrgId.orgId=" + OrgId + " and p.sexFlag=" + sexFlag + " "); //HQL
        List<Long> pList = query.getResultList();
        return pList.get(0);
    }

    public long getGenderCountPerFacultyAndQualClass(String sexFlag, String facultyCode, String QualClassCode, String locationCode, String generalCode) {
        Query query = session.createQuery("SELECT count(*) FROM PerEmploymentMasters p INNER JOIN p.perQualCodeByQualCode.perQualFaculties c where c.id.facultyCode=" + facultyCode + " and p.perQualCodeByQualCode.perQualClass.qualClassCode=" + QualClassCode + " and p.perLocationCodes.id.locationCode=" + locationCode + " and " + generalCode + " p.sexFlag=" + sexFlag + " "); //HQL
        List<Long> pList = query.getResultList();
        return pList.get(0);
    }

    public List<PerEmploymentMasters> getAll_EmployeesOrderByNo() {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where " + General_HQL + " ORDER BY p.employeeNo "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMasters> getEmployeesByEmployeeID(String employeeId) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where p.employeeId=" + employeeId + " and " + General_HQL + " "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMasters> getEmployeesByEmployeeNo(String employeeNo) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where p.employeeNo=" + employeeNo + " and " + General_HQL + " "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }
    

    public List<PerEmploymentMasters> getEmployeesByEmployeeName(String employeeName) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where p.empAname LIKE %" + employeeName + "% and " + General_HQL + " "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMasters> getEmployeesByEmployeeNameAll(String employeeName) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where p.empAname LIKE '%" + employeeName + "%' "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMasters> getEmployeesByEmployeeNoAll(String employeeNo) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where p.employeeNo=" + employeeNo + " "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMasters> getEmployeesByEmployeeNoAndLoc(String employeeNo, String LocCode, String LocationCode) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where p.perLocationCodes.id.locationCode=" + LocationCode + " and p.perLocationCodes.id.locCode=" + LocCode + " and p.employeeNo=" + employeeNo + " and " + General_HQL + " "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMasters> getEmployeesByEmployeeByOrganization(String orgId) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where " + General_HQL + " and p.perOrganizationStructureByOrgId =" + orgId + " order by p.empAname  "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMasters> getEmployeesByUserNameAndPassword(String emp_username, String emp_password) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters as p where p.employeeNo=" + emp_username + " and p.perUsers.userPwd=" + emp_password + " and " + General_HQL + " "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMasters> getEmployeesByMaleEmployeeByLocationCode(String locCode, String FiscalDegreeCode, String LocationCode, String generalCode, String cadreDegreeCode) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where " + generalCode + " p.perFiscalDegreeCode.fiscalDegreeCode||p.perGroupTypeCode.groupTypeCode in (SELECT G.id.fiscalDegreeCode||G.id.groupTypeCode FROM PerGroupDegree G) and p.perJobLaw.lawSeq is not null and p.perEmploymentParameter.equpyFinancedDegree=1 and p.perFiscalDegreeCode.perCadreDegreeCode.cadreKind=" + cadreDegreeCode + " and p.perLocationCodes.id.locationCode=" + LocationCode + " and p.perLocationCodes.id.locCode =" + locCode + " and p.perFiscalDegreeCode.fiscalDegreeCode=" + FiscalDegreeCode + " and p.sexFlag=1 "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMasters> getEmployeesByFemaleEmployeeByLocationCode(String locCode, String FiscalDegreeCode, String LocationCode, String generalCode, String cadreDegreeCode) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where " + generalCode + " p.perFiscalDegreeCode.fiscalDegreeCode||p.perGroupTypeCode.groupTypeCode in (SELECT G.id.fiscalDegreeCode||G.id.groupTypeCode FROM PerGroupDegree G) and p.perJobLaw.lawSeq is not null and p.perEmploymentParameter.equpyFinancedDegree=1 and p.perFiscalDegreeCode.perCadreDegreeCode.cadreKind=" + cadreDegreeCode + " and p.perLocationCodes.id.locationCode=" + LocationCode + " and p.perLocationCodes.id.locCode =" + locCode + " and p.perFiscalDegreeCode.fiscalDegreeCode=" + FiscalDegreeCode + " and p.sexFlag=2 "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMasters> getEmployeesByMaleEmployeeByFiscalDegree(String FiscalDegreeCode, String LocationCode, String generalCode, String cadreDegreeCode) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where " + generalCode + " p.perFiscalDegreeCode.fiscalDegreeCode||p.perGroupTypeCode.groupTypeCode in (SELECT G.id.fiscalDegreeCode||G.id.groupTypeCode FROM PerGroupDegree G) and p.perJobLaw.lawSeq is not null and p.perEmploymentParameter.equpyFinancedDegree=1 and p.perFiscalDegreeCode.perCadreDegreeCode.cadreKind=" + cadreDegreeCode + " and p.perLocationCodes.id.locationCode=" + LocationCode + " and p.perFiscalDegreeCode.fiscalDegreeCode=" + FiscalDegreeCode + " and p.sexFlag=1 "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMasters> getEmployeesByFemaleEmployeeByFiscalDegree(String FiscalDegreeCode, String LocationCode, String generalCode, String cadreDegreeCode) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where " + generalCode + " p.perFiscalDegreeCode.fiscalDegreeCode||p.perGroupTypeCode.groupTypeCode in (SELECT G.id.fiscalDegreeCode||G.id.groupTypeCode FROM PerGroupDegree G) and p.perJobLaw.lawSeq is not null and p.perEmploymentParameter.equpyFinancedDegree=1 and p.perFiscalDegreeCode.perCadreDegreeCode.cadreKind =" + cadreDegreeCode + " and p.perLocationCodes.id.locationCode=" + LocationCode + " and p.perFiscalDegreeCode.fiscalDegreeCode=" + FiscalDegreeCode + " and p.sexFlag=2 "); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMasters> getEmployeesByWrkTypeCodeAndWrkTypeSeq(String wrkTypeCode, String wrkTypeSeq) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMasters p where p.perAttendanceWrkTypeDetail.id.workTypeSeq=" + wrkTypeSeq + " and p.perAttendanceWrkTypeDetail.id.workTypeCode=" + wrkTypeCode + " and " + General_HQL + " ORDER BY to_number(p.employeeNo)"); //HQL
        List<PerEmploymentMasters> pList = query.getResultList();
        return pList;
    }

}
