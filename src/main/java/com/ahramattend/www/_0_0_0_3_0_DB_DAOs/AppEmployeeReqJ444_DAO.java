/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppEmployeeReqJ444;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class AppEmployeeReqJ444_DAO<T> extends AbstractDao<T> {

    public List<AppEmployeeReqJ444> getAppEmployeeReqJ444ByReqSp(String reqSp) {
        Query query = session.createQuery("SELECT p FROM AppEmployeeReqJ444 p where p.id.reqSp=:reqSp ORDER BY p.employeeNo"); //HQL
        query.setString("reqSp", reqSp);
        List<AppEmployeeReqJ444> pList = query.getResultList();
        return pList;
    }

    public List<AppEmployeeReqJ444> getAppEmployeeReqJ444BySpAndEmpNo(String ReqSp, String employeeNo) {
        Query query = session.createQuery("SELECT p FROM AppEmployeeReqJ444 p where p.perEmploymentMasters.employeeNo=:employeeNo and p.appEmployeeReqJ222.reqSp =:ReqSp order by p.id.reqSp "); //HQL
        query.setString("ReqSp", ReqSp);
        query.setString("employeeNo", employeeNo);
        List<AppEmployeeReqJ444> pList = query.getResultList();
        return pList;
    }
    
    

}
