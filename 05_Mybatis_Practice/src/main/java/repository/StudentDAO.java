package repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

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
	
	// 목록
	public List<Student> selectAllStudentList() {
		SqlSession ss = factory.openSession();
		
		List<Student> students = ss.selectList(NS + "selectAllStudentList");
		
		ss.close();
		return students;
	}
	
	// 상세
	public Student selectDetailStudent(int stuNo) {
		SqlSession ss = factory.openSession();
		
		Student student = ss.selectOne(NS + "selectDetailStudent", stuNo);
		
		ss.close();
		
		return student;
	}
	
	// 삽입
	public int insertStudent(Student student) {
		SqlSession ss = factory.openSession(false);
		
		int insertResult = ss.insert(NS + "insertStudent", student);
		if(insertResult == 1) {
			ss.commit();
		}
		ss.close();
		return insertResult;
	}
	
	public int getAllCountStudent() {
		SqlSession ss = factory.openSession();
		
		int count = ss.selectOne(NS + "getAllCountStudent");
		ss.close();
		return count;
	}
	
	// 조호된 학생 점수 평균
	public double getFindStudentAverage(Map<String, Double> map) {
		SqlSession ss = factory.openSession();
		
		double average = ss.selectOne(NS + "getFindStudentAverage", map);
		ss.close();
		return average;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
