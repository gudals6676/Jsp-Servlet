package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;

/**
 * Servlet implementation class BoardContentController
 */
@WebServlet("/content.do")
public class BoardContentController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			              throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx")); // String->int로 받기 위함

		BoardDAO dao = new BoardDAO();
		try {
			BoardVO vo = dao.boardContent(idx);
			// 상세보기페이지로 이동 :boardContent.jsp
			request.setAttribute("vo", vo);//객체바인딩
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/boardContent.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
