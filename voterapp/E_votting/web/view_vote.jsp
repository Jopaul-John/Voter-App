<%-- 
    Document   : view_vote
    Created on : Mar 12, 2017, 7:25:05 PM
    Author     : cijo
--%>

<%@page import="utility.AESCrypto"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean class="bean.Election" id="ele" />
<%
boolean flag=true;    
String vote_id,can_id,region_id,unique_key;
unique_key=session.getAttribute("ukey").toString();
 Iterator it = ele.getData(2).iterator();
while(it.hasNext()){
  Vector v=(Vector)it.next();
  String vote_key=AESCrypto.decrypt(v.get(3).toString(),v.get(4).toString());
  if(vote_key.equals(unique_key)){
      can_id=AESCrypto.decrypt(v.get(1).toString(), v.get(4).toString());
      %>
      <table class="table">
          <tr>
              <th>
                  vote id
              </th>
              <th>
                  Candidate id
              </th>
              <th>
                  Region code
              </th>
              <th>
                  Unique Key
              </th>
          </tr>
          <tr>
              <td>
                  <%= v.get(0).toString() %>
              </td>
               <td>
                  <%= can_id %>
              </td>
               <td>
                  <%= v.get(0).toString() %>
              </td>
               <td>
                  <%= vote_key %>
              </td>
          </tr>
      </table>

<%
    flag=false;  
  }
  
}

if(flag){
    out.print("<h1>NO VOTE DATA</h1>");
}
%>