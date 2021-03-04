/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionSheet;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Support
 */
public class PerDecisionSheet_DAO<T> extends AbstractDao<T> {

    public int getMaxPerDecisionSheet(String locationCode) {
        
        Query query = session.createQuery("SELECT nvl(max(to_number(p.id.decisionId)),0)+1 FROM PerDecisionSheet p where p.id.locationCode='"+locationCode+"' "); //HQL
        List<Integer> pList = query.getResultList();
        int number = 0;
        for (int num : pList) {
            number = num;
        }
        return number;
    }
    public List<PerDecisionSheet> getPerDecisionSheetByDecisionNo(String decisionNo) {
        Query query = session.createQuery("SELECT p FROM PerDecisionSheet p where p.decisionNo='"+decisionNo+"'"); //HQL
        List<PerDecisionSheet> pList = query.getResultList();
        return pList;
    }
}
