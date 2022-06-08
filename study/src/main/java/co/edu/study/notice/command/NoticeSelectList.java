package co.edu.study.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.study.comm.Command;
import co.edu.study.notice.service.NoticeService;
import co.edu.study.notice.serviceImpl.NoticeServiceImpl;
import co.edu.study.notice.vo.NoticeVO;

public class NoticeSelectList implements Command { // 클래스명은 첫자는 대문자

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//공지사항 목록
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		notices = dao.noticeSelectList();
		request.setAttribute("notices", notices);
		return "notice/noticeSelectList"; // 돌려줄 페이지명을 일치시켜야한다.
	}

}
