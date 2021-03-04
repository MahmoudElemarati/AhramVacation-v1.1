/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpVacationReqJava;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class PerEmpVacationReqJava_DAO<T> extends AbstractDao<T> {
    
    public int getMaxPerEmpVacationReqJava() {
        Query query = session.createQuery("SELECT nvl(max(p.vacTransSp),0)+1 FROM PerEmpVacationReqJava p  "); //HQL
        List<Integer> pList = query.getResultList();
        int number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return number;
    }
    
    public List<PerEmpVacationReqJava> getAll_PerEmpVacationReqJavaByEmp( String employeeId) {
        Query query = session.createQuery("SELECT p FROM PerEmpVacationReqJava p where p.perVacationCode.vacationType IN ('1') and p.perEmploymentMastersByEmployeeId="+ employeeId +" ORDER BY p.vacTransSp desc "); //HQL
        List<PerEmpVacationReqJava> pList = query.getResultList();
        return pList;
    }
    
    public List<PerEmpVacationReqJava> getAll_PerEmpVacationReqJavaByBossId(String employeeId) {
        Query query = session.createQuery("SELECT p FROM PerEmpVacationReqJava p where p.vacStatus=0 and p.perVacationCode.vacationType IN ('1') and p.perEmploymentMastersByEmployeeIdBoss.employeeId="+ employeeId +" ORDER BY p.vacTransSp desc "); //HQL
        List<PerEmpVacationReqJava> pList = query.getResultList();
        return pList;
    }
    
    public List<PerEmpVacationReqJava> getAll_PerEmpVacationReq(String employeeId) {
        Query query = session.createQuery("SELECT p FROM PerEmpVacationReqJava p where p.perEmploymentMastersByEmployeeIdBoss.employeeId="+ employeeId +" ORDER BY p.vacTransSp desc "); //HQL
        List<PerEmpVacationReqJava> pList = query.getResultList();
        return pList;
    }
    
    public List<PerEmpVacationReqJava> getPerEmpVacationReqJavaID(String vacTransSp) {
        Query query = session.createQuery("SELECT p FROM PerEmpVacationReqJava p where p.vacTransSp =" + vacTransSp + " "); //HQL
        List<PerEmpVacationReqJava> pList = query.getResultList();
        return pList;
    }
    
    public List<PerEmpVacationReqJava> getPerEmpVacationReqCheckDate(String date , String employeeId) {
        Query query = session.createQuery("SELECT p FROM PerEmpVacationReqJava p where p.perEmploymentMastersByEmployeeId.employeeId="+employeeId+" and to_date('"+date+"','yyyy-MM-dd') between p.vacStartDate and p.vacEndDate "); //HQL
        List<PerEmpVacationReqJava> pList = query.getResultList();
        return pList;
    }
    public List<PerEmpVacationReqJava> getPerEmpVacationReqCheckDate2(String dateChecked,String Startdate , String Enddate , String employeeId) {
        Query query = session.createQuery("SELECT p FROM PerEmpVacationReqJava p where p.perEmploymentMastersByEmployeeId.employeeId="+employeeId+" and "+dateChecked+"  between to_date('"+Startdate+"','yyyy-MM-dd') and to_date('"+Enddate+"','yyyy-MM-dd') "); //HQL
        List<PerEmpVacationReqJava> pList = query.getResultList();
        return pList;
    }
    
}
