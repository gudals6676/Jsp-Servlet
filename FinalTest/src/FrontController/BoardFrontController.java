package FrontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginDAOMybatis;
import web.Controller;


@WebServlet("*.go") //전체 매핑
// FrontController 패턴
public class BoardFrontController extends HttpServlet {	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1.클라이언트가 어떤요청을 했는지 알아보는 것
		request.setCharacterEncoding("utf-8");
		String reqUrl = request.getRequestURI();
		System.out.println(reqUrl);
		String reqPath = request.getContextPath(); // /MVC02
		System.out.println(reqPath);
		
		String command = reqUrl.substring(reqPath.length()); // 앞에 MVC02 점프하고 뒷부분만 출력
		System.out.println(command);
		// 2.요청에따른 분기작업(if~ else if~)
		LoginDAOMybatis dao = new LoginDAOMybatis();
		
		String view = null;
		Controller controller = null;
		// HandlerMapping(핸들러매핑)
	     HandlerMapping mappings = new HandlerMapping();
	    controller = mappings.getController(command);
		 //------------------분기작업-------------------------
		view = controller.requestHandler(request, response);
		if (view!=null) {
			if(view.indexOf("redirect:/")!=-1) { //-1은 없는것
				response.sendRedirect(view.split(":/")[1]);	//redirect:/list.do		
				//System.out.println(view.split(":/")[1]+1);
		   }else {   //                                                   ViewResolver
			//RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeUrl(view));//"/WEB-INF/views/Boardlist.jsp";
			//rd.forward(request, response);			
		}		
	}
  }
}
