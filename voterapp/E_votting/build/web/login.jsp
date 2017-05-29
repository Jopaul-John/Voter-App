<%--<%@page import="com.google.gson.Gson"%>--%>
<%@page import="bean.register"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean class="bean.login" id="use"/>
<jsp:setProperty name="use" property="adhar_no"/>
<%
    Iterator itr = use.getData(1).iterator();
    if (itr.hasNext()) {
        Vector v = (Vector) itr.next();
//        String user_id=v.get(0).toString();
//        String name=v.get(2).toString();
//        out.println("TRUE::"+user_id+"::"+name);
        //register reg = new register();
        out.println((v.get(0).toString())+":"+(v.get(1).toString())+":"+(v.get(2).toString())+":"+(v.get(3).toString())+":"+(v.get(4).toString())+":"+(v.get(5).toString())+":"+(v.get(7).toString()));
//        reg.setUser_id(v.get(0).toString());
//        reg.setAdhar_no(v.get(1).toString());
//        reg.setName(v.get(2).toString());
//        reg.setAddress(v.get(3).toString());
//        reg.setDob(v.get(4).toString());
//        reg.setGender(v.get(5).toString());
//        reg.setRegion_code(v.get(7).toString());
//        Gson gson = new Gson();
//        String str = gson.toJson(reg);
//        out.print(str);
    } else {
        out.println("Aadhar no not registered!!!!");
    }


%>