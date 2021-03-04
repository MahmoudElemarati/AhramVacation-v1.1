/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFileDtlRuf;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Support
 */
public class PayDeserveEmpFileDtlRuf_DAO <T> extends AbstractDao<T> {

    public List<PayDeserveEmpFileDtlRuf> getPayDeserveEmpFileDtlRufByID(String openMm, String openYyyy, String bandCode, String bandType, String locationCode, String locCode) {
        Query query = session.createQuery("SELECT p FROM PayDeserveEmpFileDtlRuf p where p.payDeserveEmpFile.id.locationCode=" + locationCode + " and p.payDeserveEmpFile.id.locCode=" + locCode + " and p.payDeserveEmpFile.id.bandType=" + bandType + " and p.payDeserveEmpFile.id.bandCode=" + bandCode + " and p.payDeserveEmpFile.id.openYyyy=" + openYyyy + " and p.payDeserveEmpFile.id.openMm=" + openMm + " "); //HQL
        List<PayDeserveEmpFileDtlRuf> pList = query.getResultList();
        return pList;
    }
    
}
