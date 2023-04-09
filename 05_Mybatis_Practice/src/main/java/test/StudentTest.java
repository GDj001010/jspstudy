package test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Student;
import repository.StudentDAO;

public class StudentTest {

	private StudentDAO dao = StudentDAO.getInstance();
	
	@Test
	public void 삽입테스트() {
		Student student = new Student();
		
		student.setStuNo(1);
		student.setName("dd");
		student.setKor(50);
		student.setEng(50);
		student.setMath(60);
		student.setAve(40.3);
		student.setGrade("A");
		
		
		assertEquals(1, dao.insertStudent(student));
	}
	
	@Test
	public void 목록테스트() {
		assertEquals(1, dao.selectAllStudentList().size());
	}
	
	@Test
	public void 상세테스트() {
		assertNotNull(dao.selectDetailStudent(1));
	}

}
