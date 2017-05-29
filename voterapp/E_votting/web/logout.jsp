<%-- 
    Document   : logout
    Created on : Mar 12, 2017, 7:04:30 PM
    Author     : cijo
--%>

<%
    
session.invalidate();
response.sendRedirect("index.jsp");

%>
