package co.edu.study.student.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.study.comm.Command;
import co.edu.study.student.service.StudentService;
import co.edu.study.student.serviceImpl.StudentSerivceImpl;
import co.edu.study.student.vo.StudentVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StudentService dao = new StudentSerivceImpl();
		HttpSession session = request.getSession();
		StudentVO vo = new StudentVO();
		vo.setStudentId(request.getParameter("studentId"));
		vo.setPassword(request.getParameter("password"));
		
		vo = dao.studentSelect(vo);
		if(vo != null) {
			session.setAttribute("id", vo.getStudentId()); //아이디
			session.setAttribute("name", vo.getName()); //사용자이름
			session.setAttribute("author", vo.getAuthor()); //사용자권한 , || session은 브라우저가 꺼져야 데이터가 사라지기에 로그인할때 사용한다.
			request.setAttribute("message", vo.getName()+"님 환영합니다."); // request는 페이지가 바뀌면 데이터가 사라지기때문에 이렇게 썼고
		} else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		}
		return "student/login";
	}

}
