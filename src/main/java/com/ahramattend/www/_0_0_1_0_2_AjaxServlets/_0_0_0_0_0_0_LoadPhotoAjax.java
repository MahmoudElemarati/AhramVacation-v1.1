/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpFileDoc;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmpFileDoc_DAO;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Hibernate;

/**
 *
 * @author Mohamed
 */
public class _0_0_0_0_0_0_LoadPhotoAjax extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected synchronized void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HibernateSessionCon.OpenCon();
        try {
            
            //byte[] image1 = null;//RAW
            Blob image = null;//Blob
            String screenNum = request.getParameter("screenNum");
            switch (screenNum) {
                case "000061":
                    String emp_id = request.getParameter("emp_id");
                    String fileDocSerial = request.getParameter("fileDocSerial");
                    String fileSerial = request.getParameter("fileSerial");
                    List<PerEmpFileDoc> pefList1 = new PerEmpFileDoc_DAO().getDocPhotoByID(fileSerial,fileDocSerial,emp_id);
                    PerEmpFileDoc perEmpFileDoc1 = pefList1.get(0);
                    //image1 = perEmpFileDoc1.getDocImage();//RAW
                    image = perEmpFileDoc1.getDocImage();//Blob

            }
            byte[] imgData = image.getBytes(1, (int) image.length());//Blob
            response.setContentType("image/gif");
            OutputStream o = response.getOutputStream();
            o.write(imgData);
            o.flush();
            //o.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HibernateSessionCon.session.clear();
        HibernateSessionCon.closeConn();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
