/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;

/**
 *
 * @author MSaeed
 */
public class SystemSettings_DAO<T> extends AbstractDao<T> {

    /*public List<PerVacationCode> getPerVacationCodeByvacationTypeEqualOne() {
        Query query = session.createQuery("SELECT p FROM PerVacationCode p where p.vacationType IN ('1') order BY p.vacationCode "); //HQL
        List<PerVacationCode> pList = query.getResultList();
        return pList;
    }*/
    public String getColor(){
        String color = "";
        return color;
    }
    
    
}
