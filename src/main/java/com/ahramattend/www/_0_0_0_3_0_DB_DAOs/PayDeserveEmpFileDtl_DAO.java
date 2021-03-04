/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFileDtl;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Support
 */
public class PayDeserveEmpFileDtl_DAO<T> extends AbstractDao<T> {

    public Integer getMaxID(String openMm, String openYyyy, String bandCode, String bandType, String locationCode, String locCode) {
        Query query = session.createQuery("SELECT nvl(max(p.id.accessSp),0)+1 FROM PayDeserveEmpFileDtl p where p.id.locationCode=" + locationCode + " and p.id.locCode=" + locCode + " and p.id.bandCode=" + bandCode + " and p.id.bandType=" + bandType + " and p.id.openMm=" + openMm + " and p.id.openYyyy=" + openYyyy + " "); //HQL
        List<Integer> pList = query.getResultList();
        int number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return number;
    }

    public List<PayDeserveEmpFileDtl> getPayEmployeeMasterByRewardId(String accessSp, String openMm, String openYyyy, String bandCode, String bandType, String locationCode, String locCode) {
        Query query = session.createQuery("SELECT f FROM PayDeserveEmpFileDtl f where f.id.accessSp=" + accessSp + " and f.id.bandCode=" + bandCode + " and f.id.bandType=" + bandType + " and f.id.locCode=" + locCode + " and f.id.locationCode=" + locationCode + " and f.id.openMm=" + openMm + " and f.id.openYyyy=" + openYyyy + ""); //HQL
        List<PayDeserveEmpFileDtl> pList = query.getResultList();
        return pList;
    }
    public List<PayDeserveEmpFileDtl> getPayEmployeeMasterBy(String openMm, String openYyyy, String bandCode, String bandType, String locationCode, String locCode) {
        Query query = session.createQuery("SELECT f FROM PayDeserveEmpFileDtl f where f.id.bandCode=" + bandCode + " and f.id.bandType=" + bandType + " and f.id.locCode=" + locCode + " and f.id.locationCode=" + locationCode + " and f.id.openMm=" + openMm + " and f.id.openYyyy=" + openYyyy + ""); //HQL
        List<PayDeserveEmpFileDtl> pList = query.getResultList();
        return pList;
    }
    public List<PayDeserveEmpFileDtl> getPayEmployeeMasterWithoutLocationsPrameter(String openMm, String openYyyy, String bandCode, String bandType) {
        Query query = session.createQuery("SELECT f FROM PayDeserveEmpFileDtl f where f.id.bandCode=" + bandCode + " and f.id.bandType=" + bandType + " and f.id.openMm=" + openMm + " and f.id.openYyyy=" + openYyyy + ""); //HQL
        List<PayDeserveEmpFileDtl> pList = query.getResultList();
        return pList;
    }

}
