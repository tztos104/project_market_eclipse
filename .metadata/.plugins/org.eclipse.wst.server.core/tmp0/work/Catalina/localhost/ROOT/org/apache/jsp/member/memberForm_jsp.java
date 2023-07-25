/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.75
 * Generated at: 2023-07-24 05:50:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class memberForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1689560285225L));
    _jspx_dependants.put("jar:file:/C:/ak/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/market/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>회원 가입</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/bootstrap.css\">\n");
      out.write("<script src=\"resources/js/bootstrap.js\"></script>\n");
      out.write("<script src=\"resources/js/validation.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../header.jsp", out, false);
      out.write("\n");
      out.write("	<div class=\"container my-4\">\n");
      out.write("		<h2 class=\"text-left mx-4 my-4\">회원 가입</h2>\n");
      out.write("		<div class=\"row mx-5\">\n");
      out.write("			<form action=\"/addMember.do\" method=\"post\">\n");
      out.write("				<div class=\"form-group row\">\n");
      out.write("					<label class=\"col-sm-2\">아이디</label>\n");
      out.write("					<div class=\"col-sm-3 my-2\">\n");
      out.write("						<input type=\"text\" name=\"mid\" id=\"mid\" class=\"form-control\">\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("				<div class=\"form-group row\">\n");
      out.write("					<label class=\"col-sm-2\">비밀번호</label>\n");
      out.write("					<div class=\"col-sm-3 my-2\">\n");
      out.write("						<input type=\"password\" name=\"passwd1\" id=\"passwd1\" class=\"form-control\">\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("				<div class=\"form-group row\">\n");
      out.write("					<label class=\"col-sm-2\">비밀번호 확인</label>\n");
      out.write("					<div class=\"col-sm-3 my-2\">\n");
      out.write("						<input type=\"password\" name=\"passwd2\" id=\"passwd2\" class=\"form-control\">\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("				<div class=\"form-group row\">\n");
      out.write("					<label class=\"col-sm-2\">성명</label>\n");
      out.write("					<div class=\"col-sm-3 my-2\">\n");
      out.write("						<input type=\"text\" name=\"mname\" id=\"mname\" class=\"form-control\">\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("				<div class=\"form-group row\">\n");
      out.write("					<label class=\"col-sm-2\">성별</label>\n");
      out.write("					<div class=\"col-sm-5 my-2\">\n");
      out.write("						<label><input type=\"radio\" name=\"gender\" value=\"male\" checked>남</label>\n");
      out.write("						<label><input type=\"radio\" name=\"gender\" value=\"female\">여</label>\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("				<div class=\"form-group row\">\n");
      out.write("					<label class=\"col-sm-2\">생일</label>\n");
      out.write("					<div class=\"col-sm-3 my-2\">\n");
      out.write("						<input type=\"text\" name=\"birthyy\" placeholder=\"년(4자)\" maxlength=\"4\" size=\"6\">\n");
      out.write("						<select name=\"birthmm\">\n");
      out.write("							<option>월</option>\n");
      out.write("							<option value=\"1\">1</option>\n");
      out.write("							<option value=\"2\">2</option>\n");
      out.write("							<option value=\"3\">3</option>\n");
      out.write("							<option value=\"4\">4</option>\n");
      out.write("							<option value=\"5\">5</option>\n");
      out.write("							<option value=\"6\">6</option>\n");
      out.write("							<option value=\"7\">7</option>\n");
      out.write("							<option value=\"8\">8</option>\n");
      out.write("							<option value=\"9\">9</option>\n");
      out.write("							<option value=\"10\">10</option>\n");
      out.write("							<option value=\"11\">11</option>\n");
      out.write("							<option value=\"12\">12</option>\n");
      out.write("						</select>\n");
      out.write("						<input type=\"text\" name=\"birthdd\" placeholder=\"일\" maxlength=\"2\" size=\"4\">\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("				<div class=\"form-group row\">\n");
      out.write("					<label class=\"col-sm-2\">전화번호</label>\n");
      out.write("					<div class=\"col-sm-3 my-2\">\n");
      out.write("						<input type=\"text\" name=\"phone\" id=\"phone\" class=\"form-control\">\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("				<div class=\"form-group row\">\n");
      out.write("					<label class=\"col-sm-2\">이메일</label>\n");
      out.write("					<div class=\"col-sm-4 my-2\">\n");
      out.write("						<input type=\"text\" name=\"email1\" maxlength=\"30\">@\n");
      out.write("						<select name=\"email2\">\n");
      out.write("							<option value=\"naver.com\">naver.com</option>\n");
      out.write("							<option value=\"daum.net\">daum.net</option>\n");
      out.write("							<option value=\"gmail.com\">gmail.com</option>\n");
      out.write("						</select>\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("				<div class=\"form-group row\">\n");
      out.write("					<label class=\"col-sm-2\">주소</label>\n");
      out.write("					<div class=\"col-sm-3 my-2\">\n");
      out.write("						<input type=\"text\" name=\"address\" id=\"address\" class=\"form-control\">\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("				\n");
      out.write("				<div class=\"form-group row\">\n");
      out.write("					<div class=\"col-sm-3 my-2\">\n");
      out.write("						<input type=\"submit\" value=\"가입\" \n");
      out.write("							class=\"btn btn-primary\" onclick=\"checkAddMember()\">\n");
      out.write("						<input type=\"reset\" value=\"취소\" class=\"btn btn-secondary\">\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("			</form>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../footer.jsp", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
