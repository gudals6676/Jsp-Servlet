package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;


@WebServlet("/register.do" )//서블릿 매핑
public class BoardRegisterController extends HttpServlet {	         
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		//0. 요청객체에 한글을 인코딩처리(한글 안깨지게 해주기 위함)
		req.setCharacterEncoding("utf-8");
		//1. 파라메터 수집(VO)
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		String writer = req.getParameter("writer");
		BoardVO vo = new BoardVO(); //객체만들기
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setWriter(writer);
		
		BoardDAO dao = new BoardDAO();
		try {
	         int cnt=dao.boardInsert(vo);
	         if (cnt>0) {
	              //저장성공후 -> 다시 리스트페이지로 가기(/list.do)
	        	  //redirect 기법(서버에서 전화돌리기 ->요청돌리기)
	        	 res.sendRedirect("list.do");
	         }else {
	            throw new ServletException("error"); //예외처리
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
//		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
//		list.add(vo);
//		list.add(vo);
//		list.add(vo);
//		
//		System.out.println(vo);//vo.toString()
//		//받은 데이터를 응답해보자
//		//MIME(마임타입) - 응답의 경우
//		res.setContentType("text/html;charset = euc-kr");//한글이 깨지기 때문에 안깨지게 해주는 방안
//		PrintWriter out = res.getWriter();
//		
//		out.println("<html>");
//		out.println("<body>");
//	      out.println("<table border = 1>");
//	      out.println("<thead>");
//	            out.println("<tr>");
//	            out.println("<th>제목</th>");
//	            out.println("<th>내용</th>");
//	            out.println("<th>작성자</th>");
//	            out.println("</tr>");
//	            out.println("</thead>");
//	            out.println("<tbody>");
//	            for (int i = 0; i < list.size(); i++) {
//	            	vo = list.get(i);
//	            	out.println("<tr>");
//	 	            out.println("<td>"+vo.getTitle()+"</td>");
//	 	            //                                  replaceAll 바꾸기
//	 	            out.println("<td>"+vo.getContents().replaceAll("\n", "<br>")+"</td>");
//	 	            out.println("<td>"+vo.getWriter()+"</td>");
//	 	            out.println("</tr>");
//				}
//	            out.println("</tbody>");
//	            out.println("</table>");
//		out.println("</body>");
//		out.println("</html>");
	}
}
