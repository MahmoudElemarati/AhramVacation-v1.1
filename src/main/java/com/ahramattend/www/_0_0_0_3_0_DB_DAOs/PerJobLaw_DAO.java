/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFileType;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerJobLaw;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class PerJobLaw_DAO<T> extends AbstractDao<T> {
    
    public List<PerJobLaw> getPerJobLawById(String lawSeq) {
        Query query = session.createQuery("SELECT p FROM PerJobLaw p where p.lawSeq="+lawSeq+" order BY p.lawSeq "); //HQL
        List<PerJobLaw> pList = query.getResultList();
        return pList;
    }
    
    public List<PerJobLaw> getAllPerJobLaw1() {
        Query query = session.createQuery("SELECT p FROM PerJobLaw p order by p.lawType"); //HQL
        List<PerJobLaw> pList = query.getResultList();
        return pList;
    }
    
}
