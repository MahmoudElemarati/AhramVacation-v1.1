/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpQualification;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class PerEmpQualification_DAO<T> extends AbstractDao<T> {
    public List<PerEmpQualification> get_Employees_PerEmpQualification(String employeeId) {
        Query query = session.createQuery("SELECT p FROM PerEmpQualification p where p.id.employeeId="+employeeId+""); //HQL
        List<PerEmpQualification> pList = query.getResultList();
        return pList;
    }
}
