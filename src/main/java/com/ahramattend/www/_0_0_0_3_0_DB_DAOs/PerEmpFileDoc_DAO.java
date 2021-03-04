/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpFileDoc;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class PerEmpFileDoc_DAO<T> extends AbstractDao<T> {

    public List<PerEmpFileDoc> getEmpDocPhoto(String Emp_id) {

        Query query = session.createQuery("SELECT p FROM PerEmpFileDoc p where p.id.employeeId=" + Emp_id + " order by p.id.fileDocSerial "); //HQL
        List<PerEmpFileDoc> pList = query.getResultList();
        return pList;
    }
    
    public List<PerEmpFileDoc> getDocPhotoByID(String fileSerial, String fileDocSerial, String emp_id) {

        Query query = session.createQuery("SELECT p FROM PerEmpFileDoc p where p.id.fileSerial="+ fileSerial +" and p.id.employeeId=" + emp_id + " and p.id.fileDocSerial=" + fileDocSerial + " "); //HQL
        List<PerEmpFileDoc> pList = query.getResultList();
        return pList;
    }

}
