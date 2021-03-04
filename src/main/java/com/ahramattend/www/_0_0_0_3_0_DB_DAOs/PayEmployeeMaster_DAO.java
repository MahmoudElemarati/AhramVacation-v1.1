/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_3_0_DB_DAOs;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.AbstractDao;
import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.session;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayEmployeeMaster;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Support
 */
public class PayEmployeeMaster_DAO<T> extends AbstractDao<T> {
final private String General_HQL = " p.perEmploymentMasters.perGeneralCodeByGeneralCode.generalCode!=20";
    public List<PayEmployeeMaster> getPayEmployeeMasterByNoAndLoc(String employeeNo,String LocCode,String LocationCode) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeMaster p where p.perEmploymentMasters.perLocationCodes.id.locationCode="+LocationCode+" and p.perEmploymentMasters.perLocationCodes.id.locCode="+LocCode+" and p.employeeNo=" + employeeNo + " and "+General_HQL+" "); //HQL
        List<PayEmployeeMaster> pList = query.getResultList();
        return pList;
    }
    public List<PayEmployeeMaster> getPayEmployeeMasterByNo(String employeeNo) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeMaster p where p.employeeNo=" + employeeNo + " and "+General_HQL+" "); //HQL
        List<PayEmployeeMaster> pList = query.getResultList();
        return pList;
    }
    
    public List<PayEmployeeMaster> getPayEmployeeMasterByName(String empAname) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeMaster p where p.empAname Like '%" + empAname + "%'  and "+General_HQL+""); //HQL
        List<PayEmployeeMaster> pList = query.getResultList();
        return pList;
    }
    
    public List<PayEmployeeMaster> getPayEmployeeMasterByLocation(String locationCode , String locCode) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeMaster p where p.perEmploymentMasters.perLocationCodes.id.locationCode="+locationCode+"  and p.perEmploymentMasters.perLocationCodes.id.locCode="+locCode+"  and "+General_HQL+""); //HQL
        List<PayEmployeeMaster> pList = query.getResultList();
        return pList;
    }
    
    public List<PayEmployeeMaster> getPayEmployeeMasterByReward(String openMm, String openYyyy, String bandCode, String bandType, String locationCode, String locCode) {
        Query query = session.createQuery("SELECT p FROM PayEmployeeMaster as p INNER JOIN p.payDeserveEmpFileDtlsForEmployeeId as f where f.id.bandCode="+bandCode+" and f.id.bandType="+bandType+" and f.id.locCode="+locCode+" and f.id.locationCode="+locationCode+" and f.id.openMm="+openMm+" and f.id.openYyyy="+openYyyy+" and "+General_HQL+""); //HQL
        List<PayEmployeeMaster> pList = query.getResultList();
        return pList;
    }
    
    

}
