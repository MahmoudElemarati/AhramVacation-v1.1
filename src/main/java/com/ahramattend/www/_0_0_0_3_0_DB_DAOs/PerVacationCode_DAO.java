/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerVacationCode;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class PerVacationCode_DAO <T> extends AbstractDao<T> {

    public List<PerVacationCode> getPerVacationCodeByvacationTypeEqualOne() {
        Query query = session.createQuery("SELECT p FROM PerVacationCode p where p.vacationType IN ('1') order BY p.vacationCode "); //HQL
        List<PerVacationCode> pList = query.getResultList();
        return pList;
    }
    
    public List<PerVacationCode> getPerVacationCode() {
        Query query = session.createQuery("SELECT p FROM PerVacationCode p order BY p.vacationName "); //HQL
        List<PerVacationCode> pList = query.getResultList();
        return pList;
    }
    
    public List<PerVacationCode> getPerVacationCodeID(String vacationCode) {
        Query query = session.createQuery("SELECT p FROM PerVacationCode p where p.vacationCode=" + vacationCode + " ORDER BY p.vacationName "); //HQL
        List<PerVacationCode> pList = query.getResultList();
        return pList;
    }
    
}
