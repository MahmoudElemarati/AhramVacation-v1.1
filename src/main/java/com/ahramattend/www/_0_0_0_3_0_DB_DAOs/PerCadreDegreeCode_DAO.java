/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PaySarfCode;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerCadreDegreeCode;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class PerCadreDegreeCode_DAO<T> extends AbstractDao<T> {

    public List<PerCadreDegreeCode> getِAllPerCadreDegreeCode() {
        Query query = session.createQuery("SELECT p FROM PerCadreDegreeCode p order by p.cadreDegreeCode "); //HQL
        List<PerCadreDegreeCode> pList = query.getResultList();
        return pList;
    }
    
}
