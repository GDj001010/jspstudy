package test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.BbsDTO;
import repository.BbsDAO;

public class BbsTest {

	// BbsDAO의 메소드 단위로 테스트를 진행한다.
	// BbsDAO는 singleoton이기 떄문에 new를 통해 객체생성이 안 된다.
	private BbsDAO dao = BbsDAO.getInstance();
	
	// @Test
	public void 목록테스트() {
		assertEquals(2, dao.selectAllBbsList().size());	// 2개를 기대하고 리스트의 값이 과연 몇일까
		
	}
	
	// @Test
	public void 상세테스트() {
		assertNotNull(dao.selectBbsByNo(1));

	}

	// 삽입을 한 뒤 다시 모두 테스트를 돌린다면 목록엔 3개가 되기 때문에 2랑 맞지 않아 테스트 실패가 나온다
	// 테스트 한 번은 한 뒤 @Test 에너테이션을 주석처리하며 코드 테스트를 한다.
	@Test
	public void 삽입테스트() {
		BbsDTO bbs = new BbsDTO();
		
		bbs.setTitle("테스트제목");
		bbs.setContent("테스트내용");
		
		assertEquals(1, dao.insertBbs(bbs));
		
	}
	
	@Test
	public void 수정테스트() {
		
		
	}
	
}
