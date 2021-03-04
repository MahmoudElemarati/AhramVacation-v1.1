/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTabAuthType;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class AppSubTabAuthType_DAO <T> extends AbstractDao<T> {

    public List<AppSubTabAuthType> getAllApplicationSubTabAuthType() {
        Query query = session.createQuery("SELECT p FROM AppSubTabAuthType p "); //HQL
        List<AppSubTabAuthType> pList = query.getResultList();
        return pList;
    }
    
    public List<AppSubTabAuthType> getApplicationSubTabAuthTypeById(String authTypeId) {
        Query query = session.createQuery("SELECT p FROM AppSubTabAuthType p where p.authTypeId="+authTypeId+""); //HQL
        List<AppSubTabAuthType> pList = query.getResultList();
        return pList;
    }
    
}
