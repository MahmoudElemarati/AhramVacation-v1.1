/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_1_0_MainDAOs;

import static com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon.*;
import java.io.Serializable;

/**
 *
 * @author Mahmoud
 * @param <T>
 */
public abstract class AbstractDao<T> {
    //private Session session;
    /*public AbstractDao() {
               // Original Class . Static Methode     .
               // .............  .  that used to      .
               // .............  . only one object    .
               // .............  . that return Object .
               // .............  .  of original class .
               // .............  . (SessionProvider)  . it is the method inside (SessionProvider) object to get session with DB
        session = SessionProvider.getSessionProvider().getSession();
    }*/
    public void insert(T s) {
        INSERT(s);
        //CommitTrans();
        //session.beginTransaction();
        //session.persist(s);
        //session.getTransaction().commit();

    }
    
    public void saveOrUpdate(T s) {
        SAVEorUPDATE(s);
        //CommitTrans();
        //session.beginTransaction();
        //session.persist(s);
        //session.getTransaction().commit();

    }

    public void save(T s) {
        SAVE(s);
        //CommitTrans();
        //session.beginTransaction();
        //session.persist(s);
        //session.getTransaction().commit();

    }

    public void update(T s) {
        UPDATE(s);
        //CommitTrans();
    }

    public void merge(T s) {
        MERGE(s);
        //CommitTrans();
    }

    public void delete(T s) {
        DELETE(s);
        //CommitTrans();
    }

    public T select(Class<T> T, Serializable id) {
        //Class<T> T = null;
        return session.load(T, id);
    }

}
