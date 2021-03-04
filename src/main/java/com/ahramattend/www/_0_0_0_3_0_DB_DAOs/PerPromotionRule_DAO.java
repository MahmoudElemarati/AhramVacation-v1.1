/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerPromotionRule;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author amac
 */
public class PerPromotionRule_DAO<T> extends AbstractDao<T> {
    
    public List<PerPromotionRule> getAllPerPromotionRule() {
        Query query = session.createQuery("SELECT p FROM PerPromotionRule p order by p.promotionType "); //HQL
        List<PerPromotionRule> pList = query.getResultList();
        return pList;
    }
    
}
