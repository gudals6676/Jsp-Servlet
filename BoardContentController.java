package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

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

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			              throws ServletException, IOException {
		int idx = Integer.parseInt(req.getParameter("idx")); // String->int로 받기 위함

		BoardDAO dao = new BoardDAO();
		try {
			BoardVO vo = dao.boardContent(idx);
			// 클라이언트에게 상세보기 페이지를 만들어서 응답
			res.setContentType("text/html;charset = euc-kr");// 한글 안깨지게
			PrintWriter out = res.getWriter();// 응답
			out.println("<html>");
			out.println("<body>");
			out.println("<form action = /MVC01/update.do method = post>");
			//                  번호는 수정할 필요 없고, 안보이게끔 파라메터 설정
			out.println("<input type = hidden name = idx value = "+vo.getIdx()+">");
			out.println("<table border = 1 width = 600px>");
			out.println("<tr>");
			out.println("<td width = 100px>번호</td>");
			out.println("<td>" + vo.getIdx() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>제목</td>");
			out.println("<td><input type = text name = title value = " + vo.getTitle() + " size = 50></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>내용</td>");         //replaceAll 치환
			out.println("<td><textarea rows=8 cols=52 name = contents>"+ vo.getContents()+"</textarea></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>작성자</td>");
			out.println("<td>" + vo.getWriter() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>작성일</td>");
			out.println("<td>" + vo.getIndate() + "</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td colspan = 2>");
			out.println("<input type = submit value = 수정>");  // submit,reset사용하기위해 form을 만든다
			out.println("<input type = reset value = 취소>");
			out.println("<input type = button onclick=\"location.href = 'list.do'\" value = 목록>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
