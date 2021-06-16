package FrontController;

import java.util.HashMap;

import web.Controller;
import web.LoginCheckController;
import web.LogoutCheckController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();		
		
		mappings.put("/login.go", new LoginCheckController());		
		mappings.put("/logout.go", new  LogoutCheckController());
		
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