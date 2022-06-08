package co.edu.study.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.edu.study.comm.DataSource;
import co.edu.study.notice.service.NoticeMapper;
import co.edu.study.notice.service.NoticeService;
import co.edu.study.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	//ServiceImpl 클래스를 만들때 미리 noticeservice를 add했다
	
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); // 데이터소스에서 getinstance를 들고올때 오픈세션에서 트루를 안하면 자동커밋을 안해줌
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class); // map에 sqlSession의 getMapper를 담는다 실제로는 mybatis가 NoticeMapper다

	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	@Override
	public List<NoticeVO> noticeSearchtList(String key, String val) {
		return map.noticeSearchtList(key, val);
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

	@Override
	public int noticeHitUpdate(int id) {
		return map.noticeHitUpdate(id);
	}

}
