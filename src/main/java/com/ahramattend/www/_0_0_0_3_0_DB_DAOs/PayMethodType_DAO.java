/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayMethodType;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Support
 */
public class PayMethodType_DAO<T> extends AbstractDao<T> {

    public List<PayMethodType> getPayMethodTypeExcept() {
        Query query = session.createQuery("SELECT p FROM PayMethodType as p INNER JOIN p.payMethodFileDtls as f where f.id.fileSp=37 ORDER BY p.methodName"); //HQL
        List<PayMethodType> pList = query.getResultList();
        return pList;
    }

}
