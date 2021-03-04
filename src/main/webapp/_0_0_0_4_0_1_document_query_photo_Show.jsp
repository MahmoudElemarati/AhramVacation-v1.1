<%-- 
    Document   : _0_0_0_4_0_1_document_query_photo_Show
    Created on : Sep 21, 2020, 10:28:02 AM
    Author     : Support
--%>

<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionSheetImageDtl"%>
<%@page import="com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon"%>
<%@page import="java.util.List"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerDecisionSheetImageDtl_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HibernateSessionCon.OpenCon();
    HibernateSessionCon.session.clear();

    String ImageSp = request.getParameter("ImageSp");
    String DecisionId = request.getParameter("DecisionId");
    String LocationCode = request.getParameter("LocationCode");
    List<PerDecisionSheetImageDtl> pList = new PerDecisionSheetImageDtl_DAO().getImageByID(LocationCode, DecisionId, ImageSp);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>الصورة</title>
    </head>
    <body style="text-align: center;background-color: black;">
        <%
            try {
        %>
        <img src="<%=pList.get(0).getImageBase64()%>">
        <%
        } catch (Exception e) {
        %>
        <h1>لا توجد صورة</h1>
        <%
            }
            HibernateSessionCon.session.clear();
        %>
    </body>
</html>

