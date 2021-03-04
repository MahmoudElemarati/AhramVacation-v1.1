/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerAttendanceWrkTypeCode;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Moham
 */
public class PerAttendanceWrkTypeCode_DAO <T> extends AbstractDao<T> {

    public List<PerAttendanceWrkTypeCode> getAllPerAttendanceWrkTypeCode() {
        Query query = session.createQuery("SELECT p FROM PerAttendanceWrkTypeCode p order by p.workTypeCode "); //HQL
        List<PerAttendanceWrkTypeCode> pList = query.getResultList();
        return pList;
    }
    
}
