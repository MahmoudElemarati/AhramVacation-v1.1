/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppName;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Adam
 */
public class AppName_DAO<T> extends AbstractDao<T> {

    public Integer getMaxID() {
        Query query = session.createQuery("SELECT nvl(max(p.applicationId),0)+1 FROM AppName p  "); //HQL
        List<Integer> pList = query.getResultList();
        Integer number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return number;
    }

    public List<AppName> getAll_ApplicationName() {
        Query query = session.createQuery("SELECT p FROM AppName p ORDER BY p.applicationIndex "); //HQL
        List<AppName> pList = query.getResultList();
        return pList;
    }


    public List<AppName> getAll_ApplicationName_ById(String applicationId) {
        Query query = session.createQuery("SELECT p FROM AppName p where p.applicationId=" + applicationId + "  "); //HQL
        List<AppName> pList = query.getResultList();
        return pList;
    }

}
