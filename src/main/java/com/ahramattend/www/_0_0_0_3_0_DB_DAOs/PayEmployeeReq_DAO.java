/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayEmployeeReq;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpVacationReqJava;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class PayEmployeeReq_DAO<T> extends AbstractDao<T> {

    public long getMaxPayEmployeeReq() {
        Query query = session.createQuery("SELECT nvl(max(p.reqSp),0)+1 FROM PayEmployeeReq p  "); //HQL
        List<Long> pList = query.getResultList();
        long number = 0;
        for (Long num : pList) {
            number = num;
        }
        return number;
    }

    public List<PayEmployeeReq> getAll_PayEmployeeReqByEmp(String employeeId) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeReq p where p.chkView IN(1,0) AND p.perEmploymentMasters.employeeId=" + employeeId + " ORDER BY p.reqSp desc "); //HQL
        List<PayEmployeeReq> pList = query.getResultList();
        return pList;
    }

    public List<PayEmployeeReq> getLastActiveReqDone(String employeeId) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeReq p where p.perEmploymentMasters.employeeId=" + employeeId + " AND p.reqSp=(SELECT nvl(max(c.reqSp),0) FROM PayEmployeeReq c where c.perEmploymentMasters.employeeId=" + employeeId + " and c.chkView=2 ) "); //HQL
        List<PayEmployeeReq> pList = query.getResultList();
        return pList;
    }

    public List<PayEmployeeReq> getAll_PayEmployeeReq() {
        Query query = session.createQuery("SELECT p FROM PayEmployeeReq p where p.chkView!=2 ORDER BY p.reqSp desc "); //HQL
        List<PayEmployeeReq> pList = query.getResultList();
        return pList;
    }

    public List<PayEmployeeReq> getPayEmployeeReqID(String ReqSp) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeReq p where p.reqSp =" + ReqSp + " "); //HQL
        List<PayEmployeeReq> pList = query.getResultList();
        return pList;
    }

    public List<PayEmployeeReq> getEmployeeReqActive(String employeeId) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeReq p where  p.perEmploymentMasters.employeeId=" + employeeId + " and  p.chkView IN(0,1)"); //HQL
        List<PayEmployeeReq> pList = query.getResultList();
        return pList;
    }

}
