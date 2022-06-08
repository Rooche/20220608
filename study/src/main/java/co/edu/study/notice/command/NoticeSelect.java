package co.edu.study.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.study.comm.Command;
import co.edu.study.notice.service.NoticeService;
import co.edu.study.notice.serviceImpl.NoticeServiceImpl;
import co.edu.study.notice.vo.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 세부목록보기
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.valueOf(request.getParameter("id"))); // 읽을 아이디 값을 담음
		vo = dao.noticeSelect(vo);
		request.setAttribute("notice", vo); // " " 안에는 그냥 notice라고 담을꺼라고 해둔것 vo객체를 notice라는곳에 담는거니 "notice", vo의 notice도 결국 vo인것이다
		return "notice/noticeSelect";
	}

}
