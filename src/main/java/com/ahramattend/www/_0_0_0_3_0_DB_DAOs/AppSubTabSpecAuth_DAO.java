/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTabSpecAuth;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Support
 */
public class AppSubTabSpecAuth_DAO<T> extends AbstractDao<T> {

    public synchronized List<AppSubTabSpecAuth> getEmpSubTabSpecAuth(String employeeId, String applicationId, String tabId, String subTabId) {
        Query query = session.createQuery("SELECT p FROM AppSubTabSpecAuth p where p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " and p.id.applicationId=" + applicationId + " and p.id.employeeId=" + employeeId + " "); //HQL
        List<AppSubTabSpecAuth> pList = query.getResultList();
        return pList;
    }

    public List<AppSubTabSpecAuth> getEmpSubTabSpecAuth(String employeeId) {
        Query query = session.createQuery("SELECT p FROM AppSubTabSpecAuth p where p.id.employeeId=" + employeeId + " "); //HQL
        List<AppSubTabSpecAuth> pList = query.getResultList();
        return pList;
    }
    
    public List<AppSubTabSpecAuth> getEmpSubTabSpecAuthAvailableToGive(String employeeId) {
        Query query = session.createQuery("SELECT p FROM AppSubTabSpecAuth p where p.primaryAuthPass=2 and p.id.employeeId=" + employeeId + " "); //HQL
        List<AppSubTabSpecAuth> pList = query.getResultList();
        return pList;
    }

}
