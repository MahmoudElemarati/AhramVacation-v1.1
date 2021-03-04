/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayExecutionOpen;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Support
 */
public class PayExecutionOpen_DAO<T> extends AbstractDao<T> {

    public List<PayExecutionOpen> getExecutionOpenByID(String openMm, String openYyyy) {
        Query query = session.createQuery("SELECT p FROM PayExecutionOpen p where p.id.openYyyy=" + openYyyy + "  and p.id.openMm=" + openMm + "  "); //HQL
        List<PayExecutionOpen> pList = query.getResultList();
        return pList;
    }
}
