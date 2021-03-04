/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.BudLocation;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerCadreDegreeCode;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class BudLocation_DAO<T> extends AbstractDao<T> {

    public List<BudLocation> getِAllBudLocation() {
        Query query = session.createQuery("SELECT p FROM BudLocation p order by p.locationCode "); //HQL
        List<BudLocation> pList = query.getResultList();
        return pList;
    }
    
    public List<BudLocation> getِAllBudLocationByID(String LocationCode) {
        Query query = session.createQuery("SELECT p FROM BudLocation p where p.locationCode="+LocationCode+" "); //HQL
        List<BudLocation> pList = query.getResultList();
        return pList;
    }
    
}