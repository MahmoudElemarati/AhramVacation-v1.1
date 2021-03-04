/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayEmployeeReqDtl;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class PayEmployeeReqDtl_DAO<T> extends AbstractDao<T> {

    public List<PayEmployeeReqDtl> getPayEmployeeReqDtlID(String ReqSp) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeReqDtl p where p.payEmployeeReq.reqSp =" + ReqSp + " order by p.id.bandType "); //HQL
        List<PayEmployeeReqDtl> pList = query.getResultList();
        return pList;
    }

    public List<PayEmployeeReqDtl> getPayEmployeeReqDtlByEst7qaqat(String ReqSp) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeReqDtl p where p.id.bandType IN(1,5,31) and p.payEmployeeReq.reqSp =" + ReqSp + " order by p.id.bandType  "); //HQL
        List<PayEmployeeReqDtl> pList = query.getResultList();
        return pList;
    }

    public List<PayEmployeeReqDtl> getPayEmployeeReqDtlByEstqta3at(String ReqSp) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeReqDtl p where p.id.bandType IN(2,20,21,22,31,32,33,34) and p.creditType is null and p.payEmployeeReq.reqSp =" + ReqSp + " order by p.id.bandType  "); //HQL
        List<PayEmployeeReqDtl> pList = query.getResultList();
        return pList;
    }
    
    public List<PayEmployeeReqDtl> getPayEmployeeReqDtlByRaseed(String ReqSp) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeReqDtl p where p.id.bandType IN(2) and p.creditType is not null and p.payEmployeeReq.reqSp =" + ReqSp + " order by p.id.bandType  "); //HQL
        List<PayEmployeeReqDtl> pList = query.getResultList();
        return pList;
    }
    
    public List<PayEmployeeReqDtl> getPayEmployeeReqDtlBySQ(String ReqSp) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeReqDtl p where p.payEmployeeReq.reqSp =" + ReqSp + " "); //HQL
        List<PayEmployeeReqDtl> pList = query.getResultList();
        return pList;
    }

}
