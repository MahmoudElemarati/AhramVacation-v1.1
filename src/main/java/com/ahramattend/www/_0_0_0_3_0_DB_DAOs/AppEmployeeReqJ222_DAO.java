/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppEmployeeReqJ222;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class AppEmployeeReqJ222_DAO<T> extends AbstractDao<T> {

    public long getMaxAppEmployeeReq() {
        Query query = session.createQuery("SELECT nvl(max(p.reqSp),0)+1 FROM AppEmployeeReqJ222 p  "); //HQL
        List<Long> pList = query.getResultList();
        long number = 0;
        for (Long num : pList) {
            number = num;
        }
        return number;
    }

    public List<AppEmployeeReqJ222> getAppEmployeeReqJ222ByEmployeeNo(String employeeNo) {
        Query query = session.createQuery("SELECT p FROM AppEmployeeReqJ222 p where p.employeeNo= :employeeNo ORDER BY p.reqSp DESC"); //HQL
        query.setString("employeeNo", employeeNo);
        List<AppEmployeeReqJ222> pList = query.getResultList();
        return pList;
    }
    
    public List<AppEmployeeReqJ222> AppEmployeeReqJ222BySp(String ReqSp) {
        Query query = session.createQuery("SELECT p FROM AppEmployeeReqJ444 p where p.appEmployeeReqJ222.reqSp =:ReqSp order by p.id.reqSp "); //HQL
        query.setString("ReqSp", ReqSp);
        List<AppEmployeeReqJ222> pList = query.getResultList();
        return pList;
    }

}
