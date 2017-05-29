package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import bean.Candidate;
import com.google.gson.Gson;
import bean.register;
import java.util.Vector;
import java.util.Iterator;

public final class candidate_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      bean.candidate_list use = null;
      synchronized (_jspx_page_context) {
        use = (bean.candidate_list) _jspx_page_context.getAttribute("use", PageContext.PAGE_SCOPE);
        if (use == null){
          use = new bean.candidate_list();
          _jspx_page_context.setAttribute("use", use, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("use"), request);
      out.write('\n');

    List<Candidate> ls = new ArrayList();
    
    Iterator itr = use.getData(1).iterator();
    if (itr.hasNext()) {
        while (itr.hasNext()) {
            Vector v = (Vector) itr.next();
//        String user_id=v.get(0).toString();
//        String name=v.get(2).toString();
//        out.println("TRUE::"+user_id+"::"+name);
            Candidate clist = new Candidate();
            out.println((v.get(0).toString()) + ":" + (v.get(1).toString()) + ":" + (v.get(2).toString()) + ":" + (v.get(3).toString()));
///clist.setCandidate_name(v.get(1).toString());
///clist.setParty_name(v.get(2).toString());
///clist.setRegion_code(v.get(3).toString());
//String cid=request.getParameter(name)
            ls.add(clist);
        }

        Gson gson = new Gson();
        String str = gson.toJson(ls);
        out.print(str);
    } else {
        out.println("fail");
    }



    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
