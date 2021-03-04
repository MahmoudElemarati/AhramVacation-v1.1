/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppEmployeeReqJ2221;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class AppEmployeeReqJ2221_DAO<T> extends AbstractDao<T> {

    public List<AppEmployeeReqJ2221> getAppEmployeeReqJ2221ByEst7qaqatForSelf(String ReqSp, String employeeNo) {
        Query query = session.createQuery("SELECT p FROM AppEmployeeReqJ2221 p where p.appEmployeeReqJ222.employeeNo=:employeeNo and p.id.bandCode IN(1,5,31) and p.appEmployeeReqJ222.reqSp =:ReqSp order by p.id.bandType  "); //HQL
        query.setString("ReqSp", ReqSp);
        query.setString("employeeNo", employeeNo);
        List<AppEmployeeReqJ2221> pList = query.getResultList();
        return pList;
    }

    public List<AppEmployeeReqJ2221> getAppEmployeeReqJ2221ByEst7qaqatForOther(String ReqSp, String employeeNo) {
        Query query = session.createQuery("SELECT p FROM AppEmployeeReqJ2221 p where p.appEmployeeReqJ222.appEmployeeReqJ444s.employeeNo=:employeeNo and p.id.bandCode IN(1,5,31) and p.appEmployeeReqJ222.reqSp =:ReqSp order by p.id.bandType  "); //HQL
        query.setString("ReqSp", ReqSp);
        query.setString("employeeNo", employeeNo);
        List<AppEmployeeReqJ2221> pList = query.getResultList();
        return pList;
    }

}
