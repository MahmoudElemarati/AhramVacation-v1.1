/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubElem;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Support
 */
public class AppSubElem_DAO<T> extends AbstractDao<T> {

    public Integer getMaxID(String applicationId, String tabId, String subTabId) {
        Query query = session.createQuery("SELECT nvl(max(p.id.elementId),0)+1 FROM AppSubElem p where p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " "); //HQL
        List<Integer> pList = query.getResultList();
        Integer number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return number;
    }

    public List<AppSubElem> getAll_ApplicationNameElementBySubTab(String applicationId, String tabId, String subTabId) {
        Query query = session.createQuery("SELECT p FROM AppSubElem p where p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " ORDER BY p.id.elementId "); //HQL
        List<AppSubElem> pList = query.getResultList();
        return pList;
    }

    public List<AppSubElem> getAll_ApplicationNameElementById(String applicationId, String tabId, String subTabId, String elementId) {
        Query query = session.createQuery("SELECT p FROM AppSubElem p where p.id.elementId=" + elementId + " and p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " ORDER BY p.id.elementId "); //HQL
        List<AppSubElem> pList = query.getResultList();
        return pList;
    }
    
    public List<AppSubElem> getApplicationNameElementByNameInSubTab(String applicationId, String tabId, String subTabId, String elementName) {
        Query query = session.createQuery("SELECT p FROM AppSubElem p where p.elementName='" + elementName + "' and p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " ORDER BY p.id.elementId "); //HQL
        List<AppSubElem> pList = query.getResultList();
        return pList;
    }
}
