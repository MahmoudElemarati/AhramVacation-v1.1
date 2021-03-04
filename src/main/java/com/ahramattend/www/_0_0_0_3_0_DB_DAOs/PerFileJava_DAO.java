/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFileJava;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class PerFileJava_DAO<T> extends AbstractDao<T> {
    
    public List<PerFileJava> getAllPerFileJavaSP(String fileSp) {
        Query query = session.createQuery("SELECT p FROM PerFileJava p where p.fileSp="+ fileSp +" order by p.fileDate desc "); //HQL
        List<PerFileJava> pList = query.getResultList();
        return pList;
    }
    
    public List<PerFileJava> getAllPerFileJava() {
        Query query = session.createQuery("SELECT p FROM PerFileJava p order by p.fileDate desc "); //HQL
        List<PerFileJava> pList = query.getResultList();
        return pList;
    }
    
}
