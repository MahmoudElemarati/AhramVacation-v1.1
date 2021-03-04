/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFiscalDegreeCode;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class PerFiscalDegreeCode_DAO<T> extends AbstractDao<T> {

    public List<PerFiscalDegreeCode> getAllPerFiscalDegreeCode(String cadreDegreeCode) {
        Query query = session.createQuery("SELECT p FROM PerFiscalDegreeCode p where p.perCadreDegreeCode.cadreDegreeCode=" + cadreDegreeCode + " order BY p.fiscalDegreeCode "); //HQL
        List<PerFiscalDegreeCode> pList = query.getResultList();
        return pList;
    }
    
    public List<PerFiscalDegreeCode> getPerFiscalDegreeCodeByfiscalDegreeCode(String fiscalDegreeCode) {
        Query query = session.createQuery("SELECT p FROM PerFiscalDegreeCode p where p.fiscalDegreeCode=" + fiscalDegreeCode + " order BY p.fiscalDegreeCode "); //HQL
        List<PerFiscalDegreeCode> pList = query.getResultList();
        return pList;
    }

}
