/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-12-16 02:23:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dangky_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Đăng Ký</title>\r\n");
      out.write("\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" id=\"bootstrap-css\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/bootstrap.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- Website CSS style -->\r\n");
      out.write("<style>\r\n");
      out.write("body, html {\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\tbackground-color: #d3d3d3;\r\n");
      out.write("\tfont-family: 'Oxygen', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".main {\r\n");
      out.write("\tmargin-top: 70px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1.title {\r\n");
      out.write("\tfont-size: 50px;\r\n");
      out.write("\tfont-family: 'Passion One', cursive;\r\n");
      out.write("\tfont-weight: 400;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("hr {\r\n");
      out.write("\twidth: 10%;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-group {\r\n");
      out.write("\tmargin-bottom: 15px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label {\r\n");
      out.write("\tmargin-bottom: 15px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input, input::-webkit-input-placeholder {\r\n");
      out.write("\tfont-size: 11px;\r\n");
      out.write("\tpadding-top: 3px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".main-login {\r\n");
      out.write("\tbackground-color: #fff;\r\n");
      out.write("\t/* shadows and rounded borders */\r\n");
      out.write("\t-moz-border-radius: 2px;\r\n");
      out.write("\t-webkit-border-radius: 2px;\r\n");
      out.write("\tborder-radius: 2px;\r\n");
      out.write("\t-moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);\r\n");
      out.write("\t-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);\r\n");
      out.write("\tbox-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".main-center {\r\n");
      out.write("\tmargin-top: 30px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tmax-width: 330px;\r\n");
      out.write("\tpadding: 40px 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login-button {\r\n");
      out.write("\tmargin-top: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login-register {\r\n");
      out.write("\tfont-size: 11px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<!-- Website Font style -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- Google Fonts -->\r\n");
      out.write("<link href='https://fonts.googleapis.com/css?family=Passion+One'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("<link href='https://fonts.googleapis.com/css?family=Oxygen'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"row main\">\r\n");
      out.write("\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t<div class=\"panel-title text-center\">\r\n");
      out.write("\t\t\t\t\t<h1 class=\"title\">Đăng Ký Tài khoản</h1>\r\n");
      out.write("\t\t\t\t\t<hr />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"main-login main-center\">\r\n");
      out.write("\t\t\t\t<form class=\"form-horizontal\" method=\"post\" action=\"DangKy\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"name\" class=\"cols-sm-2 control-label\">Họ và\r\n");
      out.write("\t\t\t\t\t\t\tTên*</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"cols-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"input-group-addon\"><i class=\"fa fa-user fa\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\taria-hidden=\"true\"></i></span> <input type=\"text\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"name_user\" id=\"name\" placeholder=\"Enter họ và tên\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"name\" class=\"cols-sm-2 control-label\">Địa chỉ*</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"cols-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"input-group-addon\"><i class=\"fa fa-user fa\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\taria-hidden=\"true\"></i></span> <input type=\"text\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"dc_user\" id=\"name\" placeholder=\"Enter Địa chỉ\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"name\" class=\"cols-sm-2 control-label\">Số điện\r\n");
      out.write("\t\t\t\t\t\t\tthoại*</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"cols-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"input-group-addon\"><i class=\"fa fa-user fa\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\taria-hidden=\"true\"></i></span> <input type=\"text\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"sdt_user\" id=\"name\" placeholder=\"Enter số điện thoại\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"email\" class=\"cols-sm-2 control-label\">Your\r\n");
      out.write("\t\t\t\t\t\t\tEmail*</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"cols-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"input-group-addon\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-envelope fa\" aria-hidden=\"true\"></i></span> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype=\"text\" class=\"form-control\" name=\"email_user\" id=\"email\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tplaceholder=\"Enter your Email\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"username\" class=\"cols-sm-2 control-label\">Tài\r\n");
      out.write("\t\t\t\t\t\t\tKhoản*</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"cols-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"input-group-addon\"><i class=\"fa fa-users fa\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\taria-hidden=\"true\"></i></span> <input type=\"text\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"tk_user\" id=\"username\" placeholder=\"Enter Tài Khoản\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"password\" class=\"cols-sm-2 control-label\">Password*</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"cols-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"input-group-addon\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-lock fa-lg\" aria-hidden=\"true\"></i></span> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype=\"password\" class=\"form-control\" name=\"pass_user1\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"password\" placeholder=\"Enter your Password\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"confirm\" class=\"cols-sm-2 control-label\">Nhập\r\n");
      out.write("\t\t\t\t\t\t\tlại Password*</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"cols-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"input-group-addon\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-lock fa-lg\" aria-hidden=\"true\"></i></span> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype=\"password\" class=\"form-control\" name=\"pass_user2\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"confirm\" placeholder=\"Enter your Password\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group \">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"btn btn-primary btn-lg btn-block login-button\">Đăng\r\n");
      out.write("\t\t\t\t\t\t\tký</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"login-register\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"Login_User\">Login</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"assets/js/bootstrap.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}