<%-- 
    Document   : region_list
    Created on : Mar 12, 2017, 1:40:39 PM
    Author     : cijo
--%>
<script type="text/javascript">
 function get_result( id ){
  
    $.post("count_votes.jsp",
    {
        region_code : id
    },
    function(data, status){
        $("#showdata").html(data);
    });    
  }  
</script>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean class="bean.candidate_list" id="can" />
<table class="table">
    <tr>
        <th>
            Region Code
        </th>
        <th>
            View Result
        </th>
    </tr>
<%
Iterator it=can.getData(2).iterator();
while(it.hasNext()){
    Vector v=(Vector)it.next();
%>
<tr>
    <td>
        <%=v.get(0).toString()%>
    </td>
     <td>
         <button onclick="get_result(<%=v.get(0).toString()%>)">View Results</button>
    </td>
</tr>
<%
}
%>
</table>

<div id="showdata">
    
</div>