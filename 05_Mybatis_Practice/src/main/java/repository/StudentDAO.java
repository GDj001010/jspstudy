package repository;

import java.io.InputStream;
import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Student;

public class StudentDAO {
	
	private SqlSessionFactory factory;
	
	private static StudentDAO dao = new StudentDAO();
	
	private StudentDAO() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static StudentDAO getInstance() {
		return dao;
	}
	
	private final String NS = "mybatis.mapper.student.";
	
	public List<Student> selectAllStudentList() {
		SqlSession ss = factory.openSession();
		
		List<Student> students = ss.selectList(NS + "selectAllStudentList");
		
		ss.close();
		return students;
	}
	
	public Student selectDetailStudent(int stuNo) {
		SqlSession ss = factory.openSession();
		
		Student student = ss.selectOne(NS + "selectDetailStudent", stuNo);
		
		ss.close();
		
		return student;
	}
	
	public int insertStudent(Student student) {
		SqlSession ss = factory.openSession(false);
		
		int insertResult = ss.insert(NS + "insertStudent", student);
		if(insertResult == 1) {
			ss.commit();
		}
		ss.close();
		return insertResult;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
