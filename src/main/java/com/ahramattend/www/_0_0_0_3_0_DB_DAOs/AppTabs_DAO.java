/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppTabs;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class AppTabs_DAO<T> extends AbstractDao<T> {

    public Integer getMaxID(String applicationId) {
        Query query = session.createQuery("SELECT nvl(max(p.id.tabId),0)+1 FROM AppTabs p where p.id.applicationId=" + applicationId + " "); //HQL
        List<Integer> pList = query.getResultList();
        Integer number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return number;
    }

    public List<AppTabs> get_AllApplicationTabs() {
        Query query = session.createQuery("SELECT p FROM AppTabs p ORDER BY p.tabIndex "); //HQL
        List<AppTabs> pList = query.getResultList();
        return pList;
    }

    public List<AppTabs> get_ApplicationTabsByApplicationId(String applicationId) {
        Query query = session.createQuery("SELECT p FROM AppTabs p where p.id.applicationId=" + applicationId + " ORDER BY p.tabIndex "); //HQL
        List<AppTabs> pList = query.getResultList();
        return pList;
    }

    public List<AppTabs> get_ApplicationTabsById(String applicationId, String tabId) {
        Query query = session.createQuery("SELECT p FROM AppTabs p where p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " "); //HQL
        List<AppTabs> pList = query.getResultList();
        return pList;
    }

}
