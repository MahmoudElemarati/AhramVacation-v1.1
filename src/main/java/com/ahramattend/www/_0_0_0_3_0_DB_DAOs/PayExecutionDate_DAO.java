/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayExecutionDate;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Support
 */
public class PayExecutionDate_DAO<T> extends AbstractDao<T> {

    public List<PayExecutionDate> getAllExecutionDateBy(String execM, String bandCode, String bandType, String locationCode, String locCode) {
        /*System.out.println(" >>>> SELECT p FROM PayExecutionDate as p "
                + " INNER JOIN p.payMethodType.payLocationBandFiles as f "
                + " WHERE f.perLocationCodes.id.locationCode=" + locationCode + " "
                + " AND f.perLocationCodes.id.locCode=" + locCode + " "
                + " AND f.payBandCode.id.bandType=" + bandType + " "
                + " AND f.id.bandCode=" + bandCode + " "
                + " AND p.id.execMm=to_date('" + execM + "','dd-MM-yyyy')");*/
        Query query = session.createQuery("SELECT p FROM PayExecutionDate as p INNER JOIN p.payMethodType.payLocationBandFiles as f where f.perLocationCodes.id.locationCode=" + locationCode + " and f.perLocationCodes.id.locCode=" + locCode + " and f.payBandCode.id.bandType=" + bandType + " and f.id.bandCode=" + bandCode + " and p.id.execMm=to_date('" + execM + "','dd-MM-yyyy') "); //HQL
        List<PayExecutionDate> pList = query.getResultList();
        return pList;
    }

    public List<PayExecutionDate> getAllExecutionDate(String bandCode, String bandType, String locationCode, String locCode) {
        Query query = session.createQuery("SELECT p FROM PayExecutionDate as p INNER JOIN p.payMethodType.payLocationBandFiles as f where f.perLocationCodes.id.locationCode=" + locationCode + " and f.perLocationCodes.id.locCode=" + locCode + " and f.payBandCode.id.bandType=" + bandType + " and f.id.bandCode=" + bandCode + " and ROWNUM <= 2 order by p.id.execMm desc  "); //HQL
        List<PayExecutionDate> pList = query.getResultList();
        return pList;
    }
}
