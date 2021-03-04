/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionSheetImageDtl;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Support
 */
public class PerDecisionSheetImageDtl_DAO<T> extends AbstractDao<T> {

    public long getMaxPerDecisionSheetImageDtl(String decisionId, String locationCode) {

        Query query = session.createQuery("SELECT nvl(max(p.id.imageSp),0)+1 FROM PerDecisionSheetImageDtl p where p.id.decisionId='" + decisionId + "' and p.id.locationCode='" + locationCode + "' "); //HQL
        List<Long> pList = query.getResultList();
        long number = 0;
        for (long num : pList) {
            number = num;
        }
        return number;
    }

    public List<PerDecisionSheetImageDtl> getImageByID(String locationCode, String decisionId, String imageSp) {
        Query query = session.createQuery("SELECT p FROM PerDecisionSheetImageDtl p where p.id.locationCode =" + locationCode + " and p.id.decisionId =" + decisionId + " and p.id.imageSp =" + imageSp + " "); //HQL
        List<PerDecisionSheetImageDtl> pList = query.getResultList();
        return pList;
    }
}
