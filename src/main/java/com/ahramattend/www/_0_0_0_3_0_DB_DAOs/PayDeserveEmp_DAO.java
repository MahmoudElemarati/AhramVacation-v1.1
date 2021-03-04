/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmp;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Support
 */
public class PayDeserveEmp_DAO<T> extends AbstractDao<T> {

    public List<PayDeserveEmp> getPayDeserveEmpByID(String openMm, String openYyyy, String bandCode, String bandType, String locationCode, String locCode) {
        Query query = session.createQuery("SELECT p FROM PayDeserveEmp p where p.perLocationCodes.id.locationCode=" + locationCode + " and p.perLocationCodes.id.locCode=" + locCode + " and p.payBandCode.id.bandType=" + bandType + " and p.payBandCode.id.bandCode=" + bandCode + " and p.payExecutionOpen.id.openYyyy=" + openYyyy + " and p.payExecutionOpen.id.openMm=" + openMm + " "); //HQL
        List<PayDeserveEmp> pList = query.getResultList();
        return pList;
    }

    public List<Object> getPayDeserveEmpFromToDateByLocCode(String ExeMmFrom, String ExeMmTo, String locCode, String locationCode) {
        Query query = session.createQuery("SELECT DISTINCT "
                + "p.perLocationCodes.id.locCode,"
                + "p.perLocationCodes.id.locationCode,"
                + "p.id.bandCode,"
                + "p.id.bandType,"
                + "p.payExecutionOpen.id.openMm,"
                + "p.payExecutionOpen.id.openYyyy "
                + "FROM PayDeserveEmp p where p.execMm BETWEEN to_date('" + ExeMmFrom + "','YYYY-MM') and to_date('" + ExeMmTo + "','YYYY-MM') and p.perLocationCodes.id.locationCode=" + locationCode + " and p.perLocationCodes.id.locCode=" + locCode + " "); //HQL
        List<Object> pList = query.getResultList();

        return pList;
        //DISTINCT agent_code,ord_amount
    }

    public List<Object> getPayDeserveEmpByDateByLocCode(String date, String locCode, String locationCode) {
        Query query = session.createQuery("SELECT DISTINCT "
                + "p.perLocationCodes.id.locCode,"
                + "p.perLocationCodes.id.locationCode,"
                + "p.id.bandCode,"
                + "p.id.bandType,"
                + "p.payExecutionOpen.id.openMm,"
                + "p.payExecutionOpen.id.openYyyy "
                + "FROM PayDeserveEmp p where p.execMm=to_date('" + date + "','YYYY-MM') and p.perLocationCodes.id.locationCode=" + locationCode + " and p.perLocationCodes.id.locCode=" + locCode + " "); //HQL
        List<Object> pList = query.getResultList();

        return pList;
        //DISTINCT agent_code,ord_amount
    }

    public List<Object> getPayDeserveEmpByDateByLocCodeAndBandCode(String date, String locCode, String locationCode, String bandCode, String bandType) {
        Query query = session.createQuery("SELECT DISTINCT "
                + " p.perLocationCodes.id.locCode,"
                + " p.perLocationCodes.id.locationCode,"
                + " p.id.bandCode,"
                + " p.id.bandType,"
                + " p.payExecutionOpen.id.openMm,"
                + " p.payExecutionOpen.id.openYyyy "
                + " FROM PayDeserveEmp p where p.execMm=to_date('" + date + "','YYYY-MM') and p.perLocationCodes.id.locationCode=" + locationCode + " "
                + " and p.perLocationCodes.id.locCode=" + locCode + " "
                + " and p.payBandCode.id.bandType=" + bandType + " and p.payBandCode.id.bandCode=" + bandCode + ""); //HQL
        List<Object> pList = query.getResultList();

        return pList;
        //DISTINCT agent_code,ord_amount
    }

}
