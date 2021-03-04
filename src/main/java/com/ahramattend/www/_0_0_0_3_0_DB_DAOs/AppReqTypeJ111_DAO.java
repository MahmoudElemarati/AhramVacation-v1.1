/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppReqTypeJ111;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class AppReqTypeJ111_DAO<T> extends AbstractDao<T> {

    public List<AppReqTypeJ111> getAppReqTypeByApplicationId(String applicationId) {
        Query query = session.createQuery("SELECT p FROM AppReqTypeJ111 p where p.appName.applicationId=" + applicationId + " ORDER BY p.appReqName"); //HQL
        List<AppReqTypeJ111> pList = query.getResultList();
        return pList;
    }

    public List<AppReqTypeJ111> getAppReqTypeByAppReqSeq(String appReqSeq) {
        Query query = session.createQuery("SELECT p FROM AppReqTypeJ111 p where p.appReqSeq=:appReqSeq ORDER BY p.appReqName"); //HQL
        query.setString("appReqSeq", appReqSeq);
        List<AppReqTypeJ111> pList = query.getResultList();
        return pList;
    }

}
