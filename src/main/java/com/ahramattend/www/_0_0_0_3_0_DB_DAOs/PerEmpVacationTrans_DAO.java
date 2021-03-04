/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpVacationTrans;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class PerEmpVacationTrans_DAO<T> extends AbstractDao<T> {
    
    public int getMaxPerEmpVacationTrans() {
        Query query = session.createQuery("SELECT nvl(max(p.vacationCode),0)+1 FROM PerEmpVacationTrans p  "); //HQL
        List<Integer> pList = query.getResultList();
        int number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return number;
    }
    
    public List<PerEmpVacationTrans> getAll_PerEmpVacationTransByEmpId(String employeeId) {
        Query query = session.createQuery("SELECT p FROM PerEmpVacationTrans p where p.perEmploymentMasters.employeeId="+employeeId+" ORDER BY p.vacStartDate desc "); //HQL
        List<PerEmpVacationTrans> pList = query.getResultList();
        return pList;
    }
    
    public List<PerEmpVacationTrans> getPerEmpVacationTransByVacationCode(String vacationCode, String employeeId) {
        Query query = session.createQuery("SELECT p FROM PerEmpVacationTrans p where p.perEmploymentMasters.employeeId="+employeeId+" and p.id.vacationCode=" +vacationCode+ " ORDER BY p.vacStartDate desc "); //HQL
        List<PerEmpVacationTrans> pList = query.getResultList();
        return pList;
    }
    
    public List<PerEmpVacationTrans> All_PerEmpVacationTrans(String HQL) {
        Query query = session.createQuery("SELECT p FROM PerEmpVacationTrans p " + HQL + " "); //HQL
        List<PerEmpVacationTrans> pList = query.getResultList();
        return pList;
    }
    
}
