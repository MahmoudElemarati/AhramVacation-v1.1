/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFileType;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerGradePercentage;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class PerGradePercentage_DAO <T> extends AbstractDao<T> {
    
    public List<PerGradePercentage> getAllPerGradePercentage() {
        Query query = session.createQuery("SELECT p FROM PerGradePercentage p order BY p.gradeCode "); //HQL
        List<PerGradePercentage> pList = query.getResultList();
        return pList;
    }
    
    
}
