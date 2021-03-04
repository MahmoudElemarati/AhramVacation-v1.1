/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionSheet;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionSheetImageDtl;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerDecisionSheet_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _0_0_0_4_0_1_document_query_Ajax_2_GetLeftDiv_AjaxServlet extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        HibernateSessionCon.OpenCon();
        try {
            String decisionNoSearch = request.getParameter("decisionNoSearch");
            List<PerDecisionSheet> pList = new PerDecisionSheet_DAO().getPerDecisionSheetByDecisionNo(decisionNoSearch);
            if (pList.isEmpty()) {
                throw new Exception();
            }
            PerDecisionSheet p = pList.get(0);
            String HTML_TEXT = "";
            int i = 1;
            for (PerDecisionSheetImageDtl pdsid : p.getPerDecisionSheetImageDtls()) {                
                HTML_TEXT += "<div class=\"col-md-6\" style=\"direction: rtl;float: right;\">\n"
                        + "                                                    <div class=\"thumbnail\">\n"
                        + "                                                        <div class=\"image view view-first\">\n"
                        + "                                                            <img style=\"width: 100%; display: block;\" src=\"" + pdsid.getImageBase64() + "\" alt=\"image\" />\n"
                        + "                                                            <div class=\"mask\">\n"
                        + "                                                                <p>الصورة رقم " + i + "</p><!--Title-->\n"
                        + "                                                                <div class=\"tools tools-bottom\">\n"
                        + "                                                                    <a href='#' onclick=\" window.open('_0_0_0_4_0_1_document_query_photo_Show.jsp?ImageSp="+pdsid.getId().getImageSp()+"&DecisionId="+pdsid.getId().getDecisionId()+"&LocationCode="+pdsid.getId().getLocationCode()+"', '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no'); \"><i class=\"fa fa-search-plus\"></i></a>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                        </div>\n"
                        + "                                                        <div class=\"caption\" style=\"text-align: center;\">\n"
                        + "                                                            <p><strong>عنوان</strong></p><!--Title-->\n"
                        + "                                                            <p>تفاصيل</p>\n"
                        + "                                                        </div>\n"
                        + "                                                    </div> \n"
                        + "                                                </div>";
            }

            response.getWriter().write(HTML_TEXT);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
        }

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
