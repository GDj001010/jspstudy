package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Member;
import repository.MemberDAO;

public class MemberUnitTest {
					// 클래스 객체가 만들어지기 전에 미리 만들어놓고 처리하는게 static이다.
	@BeforeClass	// MemberUnitTest 클래스(테스트 파일) 실행 이전에 한 번 먼저 실행된다.(static 처리가 필수로 되어있어야 한다.)
	public static void 삽입테스트() {
		Member member = new Member(0, "admin", "관리자", "M", "서울");
		assertEquals(1, MemberDAO.getInstance().insertMember(member));
	}
	
	@Test
	public void 목록테스트() {
		assertEquals(1, MemberDAO.getInstance().selectAllMembers().size());
	}
	
	@Test
	public void 전체회원수테스트() {
		assertEquals(1, MemberDAO.getInstance().getMemberCount());
	}
	
	@Test
	public void 상세테스트() {
		Member member = new Member(1, "admin", "관리자", "M", "서울");
		assertEquals(member, MemberDAO.getInstance().selectMemberByNo(1)); 
	}
	
	@Test
	public void 수정테스트() {
		Member member = new Member(1, null, "new관리자", "F", "new서울");
		assertEquals(1, MemberDAO.getInstance().updateMember(member));
	}
	
	// MemberUnitTest 클래스(테스트 파일) 실행 이후에 한 번 실행된다.(static 처리가 필수로 되어있어야 한다.)
	@AfterClass	
	public static void 삭제테스트() {
		assertEquals(1, MemberDAO.getInstance().deleteMember(1));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
