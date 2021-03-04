/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDesicionSideCode;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Support
 */
public class PerDesicionSideCode_DAO<T> extends AbstractDao<T> {

    public List<PerDesicionSideCode> getallPerDesicionSideCode() {
        Query query = session.createQuery("SELECT p FROM PerDesicionSideCode p order by p.desicionSideName "); //HQL
        List<PerDesicionSideCode> pList = query.getResultList();
        return pList;
    }

    public List<PerDesicionSideCode> getallPerDesicionSideCodeById(String desicionSideCode) {
        Query query = session.createQuery("SELECT p FROM PerDesicionSideCode p where p.desicionSideCode=" + desicionSideCode + " "); //HQL
        List<PerDesicionSideCode> pList = query.getResultList();
        return pList;
    }

}
