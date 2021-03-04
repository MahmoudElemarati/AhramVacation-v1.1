/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author amac
 */
public class PerEmpPromotion_DAO<T> extends AbstractDao<T> {

    public List<T> getAllPerEmpPromotion(String jobLaw, String PromotionType, String PostDate) {
        String DateFrom = PostDate + "-01-01";
        String DateTo = PostDate + "-12-31";
        List<T> pList = null;
        if (jobLaw.equals("1")) {
            Query query = session.createQuery("SELECT p FROM PerEmpPromotion p where p.perPromotionTrans.perPromotionRule.promotionType=" + PromotionType + " and p.perPromotionTrans.postDate is not null and p.perPromotionTrans.promotionDate between to_date('" + DateFrom + "', 'yyyy-MM-dd') and to_date('" + DateTo + "', 'yyyy-MM-dd') "); //HQL
            pList = query.getResultList();
        }else if (jobLaw.equals("2")) {
            Query query = session.createQuery("SELECT p FROM PerEmpPromotionNew p where p.perPromotionTransNew.perPromotionRule.promotionType=" + PromotionType + " and p.perPromotionTransNew.postDate is not null and p.perPromotionTransNew.promotionDate between to_date('" + DateFrom + "', 'yyyy-MM-dd') and to_date('" + DateTo + "', 'yyyy-MM-dd') "); //HQL
            pList = query.getResultList();
        }
        return pList;
    }
       

}
