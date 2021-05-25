package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;


@WebServlet("/list.do")//서블릿 매핑
public class BoardlistController extends HttpServlet {	
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			                                throws ServletException, IOException {
	    // 1. Model을 시켜먹어야 함.
		BoardDAO dao = new BoardDAO();
		try {
			List<BoardVO> list = dao.boardList();
			// 요청한 클라이언트로 게시판 목록을 응답하기(JSP)
			//System.out.println(list.toString());
			res.setContentType("text/html;charset = euc-kr");//한글 안깨지게
			PrintWriter out = res.getWriter();//응답
			out.println("<html>");
			out.println("<body>");
		      out.println("<table border = 1 width = 600px>");		      
		            out.println("<tr>");
		            out.println("<td>번호</td>");
		            out.println("<td>제목</td>");
		            out.println("<td>조회수</td>");
		            out.println("<td>작성자</td>");
		            out.println("<td>작성일</td>");
		            out.println("<td>삭제</td>");
		            out.println("</tr>");
		            for (BoardVO vo : list) {
		            	out.println("<tr>");
			            out.println("<td>"+vo.getIdx()+"</td>");
			            out.println("<td><a href='/MVC01/content.do?idx="+vo.getIdx()+"'>"+vo.getTitle()+"</a></td>");
			            out.println("<td>"+vo.getCount()+"</td>");
			            out.println("<td>"+vo.getWriter()+"</td>");
			            out.println("<td>"+vo.getIndate()+"</td>");			            
			            out.println("<td><a href = '/MVC01/delete.do?idx="+vo.getIdx()+"'>삭제</a></td>");			            
			            out.println("</tr>");
					}
		            out.println("<tr>");
		            out.println("<td colspan = 6>");
		            out.println("<input type='button' onclick=\"location.href='boardForm.html'\" value='글쓰기'>");
		            out.println("</td>");
		            out.println("</tr>");
		            out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}
