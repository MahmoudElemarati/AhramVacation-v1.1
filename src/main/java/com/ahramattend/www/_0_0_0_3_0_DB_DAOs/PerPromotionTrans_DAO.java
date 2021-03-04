/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerPromotionRule;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerPromotionTrans;
import java.util.Date;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author amac
 */
public class PerPromotionTrans_DAO<T> extends AbstractDao<T> {

    public List<PerPromotionTrans> getAllPerPromotionTrans() {
        Query query = session.createQuery("SELECT p FROM PerPromotionTrans p where p.postDate is not null order by p.promotionDate desc"); //HQL
        List<PerPromotionTrans> pList = query.getResultList();
        return pList;
    }
    
    public List<Date> getAllPerPromotionTrans1() {
        Query query = session.createQuery("SELECT DISTINCT(to_date(p.promotionDate, 'yyyy')) FROM PerPromotionTrans p where p.postDate is not null order by p.promotionDate desc"); //HQL
        List<Date> pList = query.getResultList();
        return pList;
    }

}
