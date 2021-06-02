package kr.smhrd.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/delete.do")//서블릿 매핑
public class BoardDeleteController extends HttpServlet {
	//http://localhost:8081/MVC01/delete.do?idx=7
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			             throws ServletException, IOException {
		
		int idx = Integer.parseInt(req.getParameter("idx")); //String->int로 받기 위함
		
		BoardDAO dao = new BoardDAO();
		try {
			int cnt = dao.boardDelete(idx);
			//redirect
			if(cnt > 0) {
				res.sendRedirect("list.do"); // /MVC01/list.do
			}else {
				throw new ServletException("error");//WAS(Tomcat) 에러 던지기
			}
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}

}
