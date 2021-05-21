package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.util.MyUtil;

// JavaSE API(rt.jar)
// JavaEE API(웹용 API - servlet-api.jar)
//@ annotation - 어노테이션 : 전처리
@WebServlet("/web.do") // Servlet mapping -> Tomcat
public class HapController extends HttpServlet {// 웹용 API
	//                            요청객체                                           응답객체
	public void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException { // 오버라이드
		// 1.클라이언트로부터 넘어온 폼 파라메터(su1, su2)를 가져오기(파라메터 수집)
		int su1 = Integer.parseInt(req.getParameter("su1"));
		int su2 = Integer.parseInt(req.getParameter("su2"));
		//String -> int
		
		// 2.Model과 연동하자(비즈니스로직을 밖으로 빼자)
		MyUtil my = new MyUtil();
		int sum = my.hap(su1, su2);
		
		//MIME(마임타입) - 응답의 경우
		res.setContentType("text/html;charset = euc-kr"); //한글이 깨지기 때문에 안깨지게 해주는 방안
		// 3.요청한 클라이언트로 응답하기
		PrintWriter out = res.getWriter();

		out.println("<html>");		
		out.println("<body>");	
		out.println("<table border = 1>");
		out.println("<tr>");
		out.println("<td>총합</td>");
		out.println("<td>"+sum+"</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}