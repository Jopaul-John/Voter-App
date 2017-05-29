<%-- 
    Document   : view_compl
    Created on : Mar 12, 2017, 8:49:57 PM
    Author     : cijo
--%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean class="dbconnection.connection" id="dbcon"/>
<table class="table">
    <tr>
        <th>
            Complaint id
        </th>
        <th>
            Aadhar no
        </th><th>
            User name
        </th><th>
            Complaint
        </th>
    </tr>
<%
Iterator it=dbcon.getData("SELECT * FROM `comp_table`;").iterator();
while(it.hasNext()){
  Vector v=(Vector)it.next();
%>
<tr>
    <td>
        <%= v.get(0).toString()%>
    </td>
    <td>
        <%= v.get(1).toString()%>
    </td>
    <td>
        <%= v.get(2).toString()%>
    </td>
    <td>
        <pre><%= v.get(3).toString()%></pre>
    </td>
</tr>
<%
}
%>
</table>