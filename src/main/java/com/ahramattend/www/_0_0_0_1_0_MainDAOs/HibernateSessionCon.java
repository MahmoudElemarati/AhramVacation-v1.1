/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_1_0_MainDAOs;

import java.io.Serializable;
import org.hibernate.Session;

/**
 * @author Mahmoud
 */
public class HibernateSessionCon {

    public static Session session = SessionProvider.getSessionProvider().getSession();

    public static void OpenCon() {
        session = SessionProvider.getSessionProvider().getSession();
    }

    /**
     * Start Transaction to DB
     */
    public static void beginTrans() {
        session.beginTransaction();
    }

    /**
     * End Transaction to DB
     */
    public static void CommitTrans() {
        session.getTransaction().commit();
    }

    /**
     * End Transaction to DB
     */
    public static void RollBack() {
        session.getTransaction().rollback();
    }

    /**
     * Start Connection And END Session with DB
     */
    public static void closeConn() {
        session.close();
    }

    /**
     * INSERT To DB
     *
     * @param T is General Object of Entities
     */
    public static void INSERT(Object T) {
        session.persist(T);
    }

    /**
     * SAVE To DB
     *
     * @param T is General Object of Entities
     */
    public static void SAVE(Object T) {
        session.save(T);
    }

    public static void SAVEorUPDATE(Object T) {
        session.saveOrUpdate(T);
    }

    /**
     * UPDATE To DB
     *
     * @param T is General Object of Entities
     */
    public static void UPDATE(Object T) {
        session.merge(T);
    }

    /**
     * MERGE To DB
     *
     * @param T is General Object of Entities
     */
    public static void MERGE(Object T) {
        session.merge(T);
    }

    /**
     * DELETE From DB
     *
     * @param T is General Object of Entities
     */
    public static void DELETE(Object T) {
        session.delete(T);
    }

    public static <T> T QUERY(Class<T> type, Serializable srlzbl) {
        return session.load(type, srlzbl);
    }
}
