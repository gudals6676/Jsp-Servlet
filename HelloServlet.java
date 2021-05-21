package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Servlet(서블릿) : 100%자바로 된 웹프로그래밍
@WebServlet("/hs.do") // mapping -> Tomcat
public class HelloServlet extends HttpServlet{
	//                                요청객체                              응답객체	
	public void service(HttpServletRequest req,HttpServletResponse res) 
		throws ServletException, IOException{ 
		
		//HelloServlet 이라는 문자열을 출력해보자
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("HelloServlet");
		out.println("</body>");
		out.println("</html>");
	}
	
}
