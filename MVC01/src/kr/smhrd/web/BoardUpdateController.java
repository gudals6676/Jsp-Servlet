package kr.smhrd.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/update.do")
public class BoardUpdateController extends HttpServlet {	
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			     throws ServletException, IOException {
		//0. 요청객체에 한글을 인코딩처리(한글 안깨지게 해주기 위함)
	    req.setCharacterEncoding("utf-8");
		//1. 파라메터 수집(VO)
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		int idx = Integer.parseInt(req.getParameter("idx")); //String->int로 받기 위함
		BoardVO vo = new BoardVO();
        vo.setTitle(title);
        vo.setContents(contents);
        vo.setIdx(idx);

		BoardDAO dao = new BoardDAO();		
		try {
			int cnt = dao.boardUpdate(vo);
			if(cnt > 0) {
				res.sendRedirect("list.do");
			}else {
				  throw new ServletException("error"); 
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
