/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerAttendanceExistZk;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerCadreDegreeCode;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Support
 */
public class PerAttendanceExistZk_DAO<T> extends AbstractDao<T> {

    public List<PerAttendanceExistZk> getAttendanceExistZkByEmpNo(String emp_Id, String SearchstartDate, String SearchEndDate) {
        Query query = session.createQuery("SELECT p FROM PerAttendanceExistZk p where p.id.attendanceDate between to_date('" + SearchstartDate + "','dd-MM-yyyy') and to_date('" + SearchEndDate + "','dd-MM-yyyy') and p.perEmploymentMasters.employeeId =" + emp_Id + " order by p.id.attendanceSp "); //HQL
        List<PerAttendanceExistZk> pList = query.getResultList();
        return pList;
    }
    
    public List<PerAttendanceExistZk> getAttendanceExistZkCustom(String HQL) {
        Query query = session.createQuery("SELECT p FROM PerAttendanceExistZk p where "+HQL+" order by p.id.attendanceSp "); //HQL
        List<PerAttendanceExistZk> pList = query.getResultList();
        return pList;
    }

    public List<PerAttendanceExistZk> getAttendanceExistZkByAttendanceSpAndAttendanceDate(String AttendanceSp, String AttendanceDate) {
        Query query = session.createQuery("SELECT p FROM PerAttendanceExistZk p where p.id.attendanceDate=to_date('" + AttendanceDate + "','yyyy-MM-dd') and p.id.attendanceSp=" + AttendanceSp + " "); //HQL
        List<PerAttendanceExistZk> pList = query.getResultList();
        return pList;
    }

}
