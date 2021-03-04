/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayBandCode;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Support
 */
public class PayBandCode_DAO<T> extends AbstractDao<T> {

    public List<PayBandCode> getPayBandCodeByLocation(String locCode, String locationCode) {
        Query query = session.createQuery("SELECT p FROM PayBandCode as p INNER JOIN p.payLocationBandFiles as f WHERE f.id.locCode=" + locCode + " and f.id.locationCode=" + locationCode + " "); //HQL
        List<PayBandCode> pList = query.getResultList();
        return pList;
    }

    public List<PayBandCode> getPayBandCode() {
        Query query = session.createQuery("SELECT p FROM PayBandCode p ORDER BY p.bandName "); //HQL
        List<PayBandCode> pList = query.getResultList();
        return pList;
    }

}
