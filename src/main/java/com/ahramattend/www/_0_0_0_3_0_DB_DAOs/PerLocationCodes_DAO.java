/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFileType;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerLocationCodes;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class PerLocationCodes_DAO<T> extends AbstractDao<T> {

    public List<PerLocationCodes> getAllPerLocationCodesBylocationCode(String locationCode) {
        Query query = session.createQuery("SELECT p FROM PerLocationCodes p where p.id.locationCode=" + locationCode + " order BY p.id.locCode "); //HQL
        List<PerLocationCodes> pList = query.getResultList();
        return pList;
    }
    
    public List<PerLocationCodes> getAllPerLocationCodes() {
        Query query = session.createQuery("SELECT p FROM PerLocationCodes p where p.budLocation.locationCode =0 order BY p.id.locCode "); //HQL
        List<PerLocationCodes> pList = query.getResultList();
        return pList;
    }
    
    public List<PerLocationCodes> getAllPerLocationCodesByLocCode(String locCode) {
        Query query = session.createQuery("SELECT p FROM PerLocationCodes p where p.id.locCode="+locCode+"  "); //HQL
        List<PerLocationCodes> pList = query.getResultList();
        return pList;
    }

}
