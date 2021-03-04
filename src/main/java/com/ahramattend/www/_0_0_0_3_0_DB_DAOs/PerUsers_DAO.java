/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerUsers;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class PerUsers_DAO<T> extends AbstractDao<T> {

    public List<PerUsers> getUserAndPwById(String emp_id,String userPwd) {
        Query query = session.createQuery("SELECT p FROM PerUsers p where p.perEmploymentMasters.employeeId="+emp_id+" and p.userPwd="+userPwd+" "); //HQL
        List<PerUsers> pList = query.getResultList();
        return pList;
    }
    
    public List<PerUsers> getAllUsers() {
        Query query = session.createQuery("SELECT p FROM PerUsers p where p.perEmploymentMasters.perGeneralCodeByGeneralCode.generalType!=20 order by p.employeeNo"); //HQL
        List<PerUsers> pList = query.getResultList();
        return pList;
    }
    
    public List<PerUsers> getAllUsersByEmpId(String emp_id) {
        Query query = session.createQuery("SELECT p FROM PerUsers p where p.employeeId="+ emp_id +" "); //HQL
        List<PerUsers> pList = query.getResultList();
        return pList;
    }
    
}
