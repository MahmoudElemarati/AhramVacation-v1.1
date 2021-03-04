/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFacultyCode;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author MSaeed
 */
public class PerFacultyCode_DAO<T> extends AbstractDao<T> {

    public List<PerFacultyCode> getAllPerFacultyCode() {
        Query query = session.createQuery("SELECT p FROM PerFacultyCode p order by p.facultyName"); //HQL
        List<PerFacultyCode> pList = query.getResultList();
        return pList;
    }

    public List<PerFacultyCode> getPerFacultyCodeByID(String facultyCode) {
        Query query = session.createQuery("SELECT p FROM PerFacultyCode p where p.facultyCode=" + facultyCode + " "); //HQL
        List<PerFacultyCode> pList = query.getResultList();
        return pList;
    }

}
