package co.edu.study.student.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.edu.study.comm.DataSource;
import co.edu.study.student.service.StudentMapper;
import co.edu.study.student.service.StudentService;
import co.edu.study.student.vo.StudentVO;

public class StudentSerivceImpl implements StudentService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); // mybatis를 연결하기 위해서 sql세션을 얻고 2개가 하여튼 중요함
	private StudentMapper map = sqlSession.getMapper(StudentMapper.class); // 이렇게하면 DB연결 끝 다 불러온다고 함
	
	@Override
	public List<StudentVO> studentSelectList() {
		return map.studentSelectList(); // 이렇게 안하면 sqlSession.selectList(.......) 하면서 엄청나게 길게 나오지만 mapper가 있다면 이렇게 편하게 할수있다.
	}

	@Override
	public StudentVO studentSelect(StudentVO vo) {
		return map.studentSelect(vo);
	}

	@Override
	public int studentInsert(StudentVO vo) {
		return map.studentInsert(vo);
	}

	@Override
	public int studentUpdate(StudentVO vo) {
		return map.studentUpdate(vo);
	}

	@Override
	public int studentDelete(StudentVO vo) {
		return map.studentUpdate(vo);
	}

}
