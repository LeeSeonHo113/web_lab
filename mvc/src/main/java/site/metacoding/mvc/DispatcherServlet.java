package site.metacoding.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.metacoding.mvc.web.MyUserController;

// http://localhost:8000/
// http://localhost:8000/myuser
// http://localhost:8000/mypost
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String domain = request.getRequestURI();	
		System.out.println("domain : " + domain);
		if(domain.equals("/myuser")) {
			MyUserController controller = new MyUserController(request, response);
			
			String idStr = request.getParameter("id"); // null
			
			if(idStr == null) {
				controller.getAll();
			} else {
				int id = Integer.parseInt(idStr);
				controller.getOne(id);
			}
		}
	} // Dispatcher 스레드가 종료(1. 클라이언트에게 연결된 response 선 짤림, 2. request 메모리영역 삭제, DB connection 반납)

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	} // Dispatcher 스레드가 종료
}