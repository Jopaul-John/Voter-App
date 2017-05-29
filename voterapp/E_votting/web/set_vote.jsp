<%-- 
    Document   : set_vote
    Created on : Mar 5, 2017, 4:26:32 PM
    Author     : admin
--%>
<%@page import="utility.RandomString"%>
<jsp:useBean class="bean.login" id="log"/>
<jsp:setProperty name="log" property="*"/>
<jsp:useBean class="bean.Election" id="ele"/>
<jsp:setProperty name="ele" property="*"/>
<%
RandomString rand=new RandomString(10);
String token=rand.nextString();
ele.setUnique_token(token);
log.setUnique_key(token);
if(log.putData(2)>0){
   
if(ele.putData(1)>0){
    
} 
}    


%>
