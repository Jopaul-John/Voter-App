<%--<%@page import="java.util.Iterator"%>
<%
    String candidate_id=request.getParameter("candidate_id");
    String cname=request.getParameter("cname");
    String party_name=request.getParameter("party_name");
    String region_code=request.getParameter("region_code");
    dbconnection.connection con=new dbconnection.connection();
    String str="SELECT `candidate_id`,`candidate_name`,`party_name` FROM`candidate_list` WHERE `region_code`='"+region_code+"'";
    Iterator it=con.getData(str).iterator();
    con.getData(str).iterator();
    

%>--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Candidate"%>
<%--<%@page import="com.google.gson.Gson"%>--%>
<%@page import="bean.register"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean class="bean.candidate_list" id="use"/>
<jsp:setProperty name="use" property="*"/>
<%
    List<Candidate> ls = new ArrayList();
    String cid="";
         String   cname="";
               String  pname="";
    Iterator itr = use.getData(1).iterator();
    if (itr.hasNext()) {
        
        while (itr.hasNext()) {
            Vector v = (Vector) itr.next();
//        String user_id=v.get(0).toString();
//        String name=v.get(2).toString();
//        out.println("TRUE::"+user_id+"::"+name);
//            Candidate clist = new Candidate();
System.out.println(v.get(0)+""+v.get(1)+""+v.get(2));
            cid=cid+v.get(0) + "---";
              cname=cname+v.get(1) + "---";
                pname=pname+v.get(2) + "---";

           
///clist.setCandidate_name(v.get(1).toString());
///clist.setParty_name(v.get(2).toString());
///clist.setRegion_code(v.get(3).toString());
//String cid=request.getParameter(name)
            //ls.add(clist);
        } out.println(cid + ":" + cname + ":" + pname);

//        Gson gson = new Gson();
//        String str = gson.toJson(ls);
//        out.print(str);
    } else {
        out.println("fail");
    }


%>