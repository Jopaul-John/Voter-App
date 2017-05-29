<%-- 
    Document   : count_votes
    Created on : Mar 12, 2017, 1:14:26 PM
    Author     : cijo
--%>
<%@page import="java.util.Arrays"%>
<%@page import="utility.AESCrypto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean class="bean.candidate_list" id="can" />
<jsp:setProperty name="can" property="region_code"/>
<jsp:useBean class="bean.Election" id="ele" />
<jsp:setProperty name="ele"property="region_code"/>
<%
int total_votes=0;    
List<String> de_can_ids =new ArrayList();    
Iterator it0=can.getData(3).iterator();
Vector v=(Vector)it0.next();
int cand_count=Integer.parseInt(v.get(0).toString());
int[] vote_count=new int[cand_count];
    
Iterator it2=ele.getData(1).iterator();
while(it2.hasNext()){
    Vector v1=(Vector)it2.next();
    String s=AESCrypto.decrypt(v1.get(0).toString(), v1.get(2).toString());
    System.out.println("decrypt "+s);
    de_can_ids.add(s);
    total_votes++;
}
Iterator it1=can.getData(1).iterator();
it1.next();
for(int count=0 ;count<cand_count;count++){ 
 Vector v2=(Vector)it1.next();   
 String can_id=v2.get(0).toString();
 can_id=can_id.trim();
 //for(int i=0;i<de_can_ids.size();i++){
 for(String id : de_can_ids ){
    // String id=de_can_ids.get(i);
     id=id.trim();
     System.out.println("can_id "+can_id);
     System.out.println("id "+id);
   if(can_id.equals(id)){
       vote_count[count]++;
   }  
 }
}

out.print(Arrays.toString(vote_count));
%>
<table class="table">
    <tr>
        <th colspan="4">
            Region Code : <%= request.getParameter("region_code") %>
        </th>
    </tr>
    <tr>
        <th>
            Candidate ID
        </th>
        <th>
            Candidate Name
        </th>
        <th>
            Party Name
        </th>
        <th>
          Votes
        </th>
    </tr>
    <%
    int j=0;
    Iterator itnew=can.getData(1).iterator();
    itnew.next();
    while(itnew.hasNext() && j<cand_count){
    Vector candidatedata=(Vector)itnew.next();
    
    %>
    <tr>
        <td>
            <%=candidatedata.get(0).toString()%>
        </td>
        <td>
            <%=candidatedata.get(1).toString()%>
        </td>
        <td>
            <%=candidatedata.get(2).toString()%>
        </td>
        <td>
            <%=vote_count[j++]%>
        </td>
    </tr>
    <%
    }
    %>
    <tr>
        <td  colspan="3"> Total Votes</td>
        <td>
            <%= total_votes %>
        </td>
    </tr>
</table>

