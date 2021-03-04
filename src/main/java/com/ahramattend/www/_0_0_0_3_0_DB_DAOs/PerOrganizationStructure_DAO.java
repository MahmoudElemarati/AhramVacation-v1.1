/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerOrganizationStructure;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class PerOrganizationStructure_DAO<T> extends AbstractDao<T> {

    public List<PerOrganizationStructure> getAllOrganizations() {
        Query query = session.createQuery("SELECT p FROM PerOrganizationStructure p order by p.orgName "); //HQL
        List<PerOrganizationStructure> pList = query.getResultList();
        return pList;
    }
    public List<PerOrganizationStructure> getPerOrganizationByOrgID(String OrgID) {
        Query query = session.createQuery("SELECT p FROM PerOrganizationStructure p where p.orgId=" + OrgID + " "); //HQL
        List<PerOrganizationStructure> pList = query.getResultList();
        return pList;
    }
    public List<PerOrganizationStructure> getPerOrganizationStructureBossID(String employeeId) {
        Query query = session.createQuery("SELECT p FROM PerOrganizationStructure p where p.empDirectBoss =" + employeeId + " "); //HQL
        List<PerOrganizationStructure> pList = query.getResultList();
        return pList;
    }

    public List<PerOrganizationStructure> getPerOrganizationStructureBigBossID(String employeeId) {
        Query query = session.createQuery("SELECT p FROM PerOrganizationStructure p where p.empBigBoss =" + employeeId + " "); //HQL
        List<PerOrganizationStructure> pList = query.getResultList();
        return pList;
    }

    public List<PerOrganizationStructure> getPerOrganizationStructureBigBossID2(String employeeId) {
        Query query = session.createQuery("SELECT p FROM PerOrganizationStructure p where p.empDirectBoss=" + employeeId + " Or p.empBigBoss =" + employeeId + " "); //HQL
        List<PerOrganizationStructure> pList = query.getResultList();
        return pList;
    }

}
