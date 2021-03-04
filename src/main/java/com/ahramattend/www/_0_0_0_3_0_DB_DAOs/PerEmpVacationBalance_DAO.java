/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpVacationBalance;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class PerEmpVacationBalance_DAO<T> extends AbstractDao<T> {

    public List<PerEmpVacationBalance> get_Employees_Vacation_Balance_BY(String Emp_id, String vacationCode) {
        String MaxDate = "SELECT Max(c.id.balStartDate) FROM PerEmpVacationBalance c where c.perVacationCode.vacationCode=" + vacationCode + " and c.perEmploymentMasters.employeeId='" + Emp_id + "'   ";

        Query query = session.createQuery("SELECT p FROM PerEmpVacationBalance p where p.id.balStartDate=(" + MaxDate + ") and p.perVacationCode.vacationCode=" + vacationCode + " and p.perEmploymentMasters.employeeId='" + Emp_id + "'   "); //HQL
        List<PerEmpVacationBalance> pList = query.getResultList();
        return pList;
    }
    

}
