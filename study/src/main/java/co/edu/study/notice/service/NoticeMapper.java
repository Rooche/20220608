package co.edu.study.notice.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.edu.study.notice.vo.NoticeVO;

//NoticeMapper와 mybatis로 만든 notice-map이랑은 큰 연관이 있다
public interface NoticeMapper {
	List<NoticeVO> noticeSelectList(); // 전체리스트
	// Mapper interface에서는 전달인자가 2개 이상일때 @Param(타입)을 해줘야함
	List<NoticeVO> noticeSearchtList(@Param("key")String key,@Param("val")String val);
	NoticeVO noticeSelect(NoticeVO vo); // 한건조회
	int noticeInsert(NoticeVO vo); // 추가
	int noticeUpdate(NoticeVO vo); // 변경
	int noticeDelete(NoticeVO vo); // 삭제
	int noticeHitUpdate(int id); //조회수증가 메소드

}
