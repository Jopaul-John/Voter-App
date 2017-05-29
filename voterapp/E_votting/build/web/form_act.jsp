<%-- 
    Document   : form_act
    Created on : Mar 12, 2017, 11:54:28 AM
    Author     : cijo
--%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean class="bean.login" id="log"/>
<%
String user=request.getParameter("aadhar");
String pass=request.getParameter("key");
if(user.equals("admin") && pass.equals("admin")){
    session.setAttribute("userid", "admin");
    session.setAttribute("usernm", "admin");
%>
<script>
    alert("Admin home");
    location.href="admin.jsp";
</script>
<%
}else{
  log.setUnique_key(pass);
  log.setAdhar_no(user);
  Iterator it=log.getData(3).iterator();
  if(it.hasNext()){
      Vector v=(Vector)it.next();
          session.setAttribute("userid",v.get(0));
    session.setAttribute("usernm", v.get(2));
        session.setAttribute("aadhar", v.get(1));
         session.setAttribute("ukey", v.get(9));
  %>
<script>
    alert("User home");
    location.href="user.jsp";
</script>
<%
  }else{
     %>
<script>
    alert("Sorry Not User");
    location.href="index.jsp";
</script>
<%   
  }
}
%>