/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpHistory;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpVacationBalance;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class PerEmpHistory_DAO <T> extends AbstractDao<T> {

    public List<PerEmpHistory> get_Employees_EmpHistory(String Emp_id) {
        Query query = session.createQuery("SELECT p FROM PerEmpHistory p where p.perGeneralCode.generalType not in (12,13,17,50,60) and p.perEmploymentMasters.employeeId="+Emp_id+" order by p.transDate desc"); //HQL
        List<PerEmpHistory> pList = query.getResultList();
        return pList;
    }
}
