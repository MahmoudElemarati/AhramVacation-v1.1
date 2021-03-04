/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionTypeCode;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Support
 */
public class PerDecisionTypeCode_DAO<T> extends AbstractDao<T> {

    public List<PerDecisionTypeCode> getallPerDecisionTypeCode() {
        Query query = session.createQuery("SELECT p FROM PerDecisionTypeCode p order by p.decisionTypeName "); //HQL
        List<PerDecisionTypeCode> pList = query.getResultList();
        return pList;
    }

    public List<PerDecisionTypeCode> getallPerDecisionTypeCodeById(String decisionTypeCode) {
        Query query = session.createQuery("SELECT p FROM PerDecisionTypeCode p where p.decisionTypeCode=" + decisionTypeCode + " "); //HQL
        List<PerDecisionTypeCode> pList = query.getResultList();
        return pList;
    }

}
