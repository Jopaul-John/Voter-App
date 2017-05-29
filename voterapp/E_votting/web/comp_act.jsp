<%-- 
    Document   : comp_act
    Created on : Mar 12, 2017, 8:19:44 PM
    Author     : cijo
--%>
<jsp:useBean class="dbconnection.connection" id="dbcon"/>
<%
String aadhar=session.getAttribute("aadhar").toString();
String comp=request.getParameter("complaint");
String user_nm=session.getAttribute("usernm").toString();

String qry="INSERT INTO `e-votting`.`comp_table` (`aadhar_no`,`user_nm`,`complaint`) VALUES('"+aadhar+"','"+user_nm+"','"+comp+"');";

if(dbcon.putData(qry)>0){
  %>
<script>
    alert("Success");
    location.href="user.jsp";
</script>
<%    
}else{
     %>
<script>
    alert("Failed");
    location.href="user.jsp";
</script>
<% 
}


%>