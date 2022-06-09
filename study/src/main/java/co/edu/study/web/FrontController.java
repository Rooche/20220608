package co.edu.study.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.study.comm.Command;
import co.edu.study.home.HomeCommand;
import co.edu.study.notice.command.NoticeSelect;
import co.edu.study.notice.command.NoticeSelectList;
import co.edu.study.student.command.Login;
import co.edu.study.student.command.LoginForm;
import co.edu.study.student.command.Logout;

//바깥에서 들어오는 모든것은 *.do가 처리함
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Command를 import시킬때는 내가 만든 서블릿으로 import 시킬것
	private HashMap<String, Command> map = new HashMap<String, Command>();
    

    public FrontController() {
        super();
    }

    
	 //요청과 처리 명령어를 연결하는 부분
	public void init(ServletConfig config) throws ServletException { // init은 초기화한다는 뜻이다.
		map.put("/home.do", new HomeCommand()); // 첫번재 페이지. 홈페이지 || home.do를 불러온다는건 homecommand라는 자식객체를 불러온다는것
		// new 다음에 적는 커맨드는 안만들어져있어서 만들어줘야함
		// new 다음에 적는 커맨드의 앞자리는 항상 대문자로 만들어야함
		map.put("/noticeSelectList.do", new NoticeSelectList()); // 공지사항목록보는곳
		map.put("/noticeSelect.do", new NoticeSelect()); // 세부내역보기
		map.put("/loginForm.do", new LoginForm()); // 로그인폼
		map.put("/login.do", new Login()); // 로그인처리
		map.put("/logout.do", new Logout()); // 로그아웃처리
	}

	
	//요청을 분석하는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글깨짐 방지
		String uri = request.getRequestURI(); // 요청 URI 구함
		String contextPath = request.getContextPath(); // 루트 디렉토리 정보
		String page = uri.substring(contextPath.length());; // contextPath.length()(<-이걸빼면) 이 다음부터는 들어가는게 페이지다. ,, 실제 요청 명령을 받음
		
		Command command = map.get(page); //맵에서 키를 던져주니 나한테 던져주는건 밸류(커맨드)를 돌아온다 즉 커맨드를 구한다
		String viewPage = command.exec(request, response); // exec를 찾을때 맨끝에 String이 붙어서 나오는데 돌려받는값이 스트링인걸 알수있다.
	
		if(!viewPage.endsWith(".do")) { // viewResolve
//			viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; // 중앙에 viewPage를 넣는 이유는 돌아오는 페이지가 viewPage라서 .. 보여줄 페이지를 구한다
			viewPage = viewPage + ".tiles";
		
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // Dispatcher은 권한위임.
		dispatcher.forward(request, response);
	}
}
