/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerSectionCode;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author MSaeed
 */
public class PerSectionCode_DAO<T> extends AbstractDao<T> {

    public List<PerSectionCode> getAllPerSectionCode() {
        Query query = session.createQuery("SELECT p FROM PerSectionCode p where p.perLocationCodes.budLocation.locationCode=0 order by p.id.secCode desc"); //HQL
        List<PerSectionCode> pList = query.getResultList();
        return pList;
    }

    public List<PerSectionCode> getAllPerSectionCodeBylocCode(String locCode) {
        Query query = session.createQuery("SELECT p FROM PerSectionCode p where p.id.locCode =" + locCode + " and p.perLocationCodes.budLocation.locationCode=0 order by p.id.secCode desc"); //HQL
        List<PerSectionCode> pList = query.getResultList();
        return pList;
    }

    public short getMaxPerSectionCode() {
        javax.persistence.Query query = session.createQuery("SELECT nvl(max(p.id.secCode),0)+1 FROM PerSectionCode p  "); //HQL
        List<Integer> pList = query.getResultList();
        int number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return (short) number;
    }

    public List<PerSectionCode> getPerSectionCodeById(String SecCode) {
        Query query = session.createQuery("SELECT p FROM PerSectionCode p where p.id.secCode=" + SecCode + " "); //HQL
        List<PerSectionCode> pList = query.getResultList();
        return pList;
    }

    public List<PerSectionCode> getPerSectionCodeByLocCodeandLocationCode(String LocCode, String LocationCode) {
        Query query = session.createQuery("SELECT p FROM PerSectionCode p where p.id.locationCode=" + LocationCode + " and p.id.locCode=" + LocCode + " order by p.secName "); //HQL
        List<PerSectionCode> pList = query.getResultList();
        return pList;
    }

}
