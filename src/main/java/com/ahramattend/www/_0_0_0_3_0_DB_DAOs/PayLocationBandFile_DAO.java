/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayLocationBandFile;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Support
 */
public class PayLocationBandFile_DAO <T> extends AbstractDao<T> {

    public List<PayLocationBandFile> getPayLocationBandFileByID(String bandCode, String bandType, String locationCode, String locCode) {
        Query query = session.createQuery("SELECT p FROM PayLocationBandFile p where p.id.locationCode="+locationCode+" and p.id.locCode="+locCode+" and p.id.bandType="+bandType+" and p.id.bandCode="+bandCode+" "); //HQL
        List<PayLocationBandFile> pList = query.getResultList();
        return pList;
    }
    
}
