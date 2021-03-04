/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_1_0_MainDAOs;

import com.ahramattend.www._0_0_0_0_2_AhramLib.dbInit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Mahmoud
 */
public class SessionProvider {
    //??????????????????????????????????????????????????????????????????????????

    SessionFactory factory;
    private static SessionProvider provider; // Objct of self class 

    // Static method to direct invoke it from other classes to block creating new object from it out side this class
    // why ? beacause class constructor is private
    // So Only way to create new object from it by writing the creation here in it self class
    public static synchronized SessionProvider getSessionProvider() {
        // to ensure that there is only one object created in all Application
        if (provider == null) {
            try {
                dbInit d = new dbInit();
                d.RunHibernate();
                provider = new SessionProvider();
            } catch (Exception e) {
                if (!e.getMessage().equals("x")) {
                    e.printStackTrace();
                }
            }
        }

        return provider;
    }

    // to Apply the Congiguration of Database exsist in "hibernate.cfg.xml" file
    private SessionProvider() {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");//hibernate.cfg.vehiclemysql.xml //hibernate.cfg.vehicle.xml
        factory = config.buildSessionFactory();
    }

    //open session from SessionProvider Object 
    public Session getSession() {
        return factory.openSession();
    }

}
