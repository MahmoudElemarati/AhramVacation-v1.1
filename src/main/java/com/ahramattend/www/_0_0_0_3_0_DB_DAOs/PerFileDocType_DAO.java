/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFileDocType;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFileType;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class PerFileDocType_DAO<T> extends AbstractDao<T> {
    
    public List<PerFileDocType> getAllPerFileDocType() {
        Query query = session.createQuery("SELECT p FROM PerFileDocType p order BY p.docTypeCode "); //HQL
        List<PerFileDocType> pList = query.getResultList();
        return pList;
    }
    
}