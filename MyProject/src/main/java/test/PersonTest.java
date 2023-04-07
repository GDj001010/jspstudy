package test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Person;
import repository.PersonDAO;

public class PersonTest {

	private PersonDAO dao = PersonDAO.getInstance();
	
	@Test
	public void 목록테스트() {
		assertEquals(1, dao.selectAllPersonList().size());
	}
	
	

}
