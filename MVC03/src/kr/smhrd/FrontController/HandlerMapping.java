package kr.smhrd.FrontController;

import java.util.HashMap;

import kr.smhrd.web.BoardContentController;
import kr.smhrd.web.BoardDeleteController;
import kr.smhrd.web.BoardRegisterController;
import kr.smhrd.web.BoardRegisterFormController;
import kr.smhrd.web.BoardUpdateController;
import kr.smhrd.web.BoardlistController;
import kr.smhrd.web.Controller;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/list.do", new BoardlistController());
		mappings.put("/register.do", new BoardRegisterController());
		mappings.put("/registerForm.do", new BoardRegisterFormController());
		mappings.put("/update.do", new BoardUpdateController());
		mappings.put("/content.do", new BoardContentController());
		mappings.put("/delete.do", new BoardDeleteController());
		// 새로운 요청을 추가하고 -> POJO를 새롭게 만든다.
		// mappings.put("/login.do", new BoardLoginController());
	}
	public Controller getController(String command) {
		return mappings.get(command);
	}
}
/*
if(command.equals("/list.do")) {			
			controller = new BoardlistController();							
		}else if(command.equals("/register.do")){
			controller = new BoardRegisterController();					   
		}else if(command.equals("/registerForm.do")) {
			controller = new BoardRegisterFormController();						
		}else if(command.equals("/update.do")) {
		   controller = new BoardUpdateController();	 		    		   
		}else if(command.equals("/content.do")) {
			controller = new BoardContentController();						
		}else if(command.equals("/delete.do")) {
			controller = new BoardDeleteController();				
		}
*/