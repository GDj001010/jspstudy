package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.BbsDTO;

public class BbsDAO {
	
	// 필드
	private SqlSessionFactory factory;
	
	// Singleton Pattern
	private static BbsDAO dao = new BbsDAO();
	
	private BbsDAO() {
		
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static BbsDAO getInstance() {
		return dao;
	}
	
	
	// 메소드명과 쿼리문의 id를 맞추자.
	
	// mapper의 namespace
	private final String NS = "mybatis.mapper.bbs.";
	
	// 1. 목록
	public List<BbsDTO> selectAllBbsList() {
		
		// mapper에 쿼리문을 돌리기 위해 공장에서 SqlSession을 만든다.
		SqlSession ss = factory.openSession();	
		
		// 쿼리문 돌리기
		// 실행할 쿼리문의 id를 적는다. (앞에 mapper 이름까지 적어준다.)
		List<BbsDTO> bbsList = ss.selectList(NS + "selectAllBbsList");	
		
		// 자원 반납
		ss.close();
		return bbsList;
	}
	
	// 2. 상세
	public BbsDTO selectBbsByNo(int bbsNo) {
		// mapper에 쿼리를 돌릴 수 있게 factory에서 Sqlsession 객체를 만든다.
		SqlSession ss = factory.openSession();
		
		// 쿼리문 돌리기
		// 실행할 쿼리문의 mapper 이름과 id를 .으로 구분해서 입력한다.
		// 쿼리문으로 보낼 인수가 있다면 , 후에 넘긴다
		BbsDTO bbs = ss.selectOne(NS + "selectBbsByNo", bbsNo);
		
		// 자원 반납
		ss.close();
		
		return bbs;
		
	}
	
	// 3. 삽입
	public int insertBbs(BbsDTO bbs) {
		// autoCommit을 하지 않고, 직접 commit을 한다.
		SqlSession ss = factory.openSession(false);	
		
		// 쿼리문 실행
		int insertResult = ss.insert(NS + "insertBbs", bbs);
		
		// 삽입 성공시 커밋을 한다.
		if(insertResult == 1) {
			ss.commit();
		}
		
		ss.close();
		return insertResult;
		
	}
	
	// 4. 수정
	public int updateBbs(BbsDTO bbs) {
		
		SqlSession ss = factory.openSession(false);
		
		int updateResult = ss.update(NS + "updateBbs", bbs);
		
		if(updateResult == 1) {
			ss.commit();
		}
		
		ss.close();
		
		return updateResult;
	}
	
	// 5. 삭제
	public int deleteBbs(int bbsNo) {
		
		SqlSession ss = factory.openSession(false);
		
		int deleteResult = ss.delete(NS + "deleteBbs", bbsNo);
		
		if(deleteResult == 1) {
			ss.commit();
		}
		ss.close();
		
		return deleteResult;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
