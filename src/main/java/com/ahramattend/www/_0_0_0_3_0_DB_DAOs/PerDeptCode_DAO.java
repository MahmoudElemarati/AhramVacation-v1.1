/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDeptCode;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author MSaeed
 */
public class PerDeptCode_DAO<T> extends AbstractDao<T> {

    public List<PerDeptCode> getAllPerDeptCode() {
        Query query = session.createQuery("SELECT p FROM PerDeptCode p where p.perSectionCode.perLocationCodes.budLocation.locationCode=0 order by p.id.deptCode desc"); //HQL
        List<PerDeptCode> pList = query.getResultList();
        return pList;
    }

    public List<PerDeptCode> getAllPerDeptCodeBySecCode(String secCode) {
        Query query = session.createQuery("SELECT p FROM PerDeptCode p where p.id.secCode=" + secCode + " and p.perSectionCode.perLocationCodes.budLocation.locationCode=0 order by p.id.deptCode desc"); //HQL
        List<PerDeptCode> pList = query.getResultList();
        return pList;
    }

    public short getMaxPerDeptCode() {
        javax.persistence.Query query = session.createQuery("SELECT nvl(max(p.id.deptCode),0)+1 FROM PerDeptCode p  "); //HQL
        List<Integer> pList = query.getResultList();
        int number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return (short) number;
    }

    public List<PerDeptCode> getPerDeptCodeById(String DeptCode) {
        Query query = session.createQuery("SELECT p FROM PerDeptCode p where p.id.deptCode=" + DeptCode + " "); //HQL
        List<PerDeptCode> pList = query.getResultList();
        return pList;
    }

}
