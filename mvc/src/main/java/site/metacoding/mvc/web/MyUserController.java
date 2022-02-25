package site.metacoding.mvc.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.metacoding.mvc.domain.MyUser;
import site.metacoding.mvc.domain.MyUserRepository;

// 회원 관련 요청만 컨트롤함.
public class MyUserController {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private MyUserRepository repo;
	
	public MyUserController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		repo = new MyUserRepository();
	}
	
	// GET : http://localhost:8000/myuser
	public void getAll() {
		System.out.println("getAll 호출 됨.");
	}
	
	// GET : http://localhost:8000/myuser?id=1
	public void getOne(int id) {
		System.out.println("getOne 호출 됨.");
		MyUser myUser = repo.selectById(id);
		System.out.println("myUser : " + myUser.getUsername());
		request.setAttribute("myUser", myUser);
		try {
			//response.sendRedirect("/userInfo.jsp");
			RequestDispatcher dis = request.getRequestDispatcher("/userInfo.jsp");
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}