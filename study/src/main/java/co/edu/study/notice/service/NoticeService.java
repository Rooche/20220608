package co.edu.study.notice.service;

import java.util.List;

import co.edu.study.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList(); // 전체리스트
	List<NoticeVO> noticeSearchtList(String key, String val); // 메소드 오버로딩(재정의) 할거라서 위에랑 같아도 괜찮음
	NoticeVO noticeSelect(NoticeVO vo); // 한건조회
	int noticeInsert(NoticeVO vo); // 추가
	int noticeUpdate(NoticeVO vo); // 변경
	int noticeDelete(NoticeVO vo); // 삭제
	int noticeHitUpdate(int id); //조회수증가 메소드
	
}
