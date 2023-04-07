package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Person;

public class PersonDAO {

	private SqlSessionFactory factory;
	
	private static PersonDAO dao = new PersonDAO();
	
	private PersonDAO() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static PersonDAO getInstance() {
		return dao;
	}
	
	private final String NS = "mybatis.mapper.person.";
	
	
	public List<Person> selectAllPersonList(){
		SqlSession ss = factory.openSession();
		List<Person> persons = ss.selectList(NS + "selectAllPersonList");
		ss.close();
		return persons;
	}
	
	public Person selectDetailPerson(int personNo) {
		SqlSession ss = factory.openSession();
		Person person = ss.selectOne(NS + "selectDetailPerson", personNo);
		ss.close();
		return person;
	}
	
	public int insertPerson(Person person) {
		SqlSession ss = factory.openSession(false);
		int insertResult = ss.insert(NS + "insertPerson", person);
		if(insertResult == 1) {
			ss.commit();
		}
		ss.close();
		return insertResult;
	}
	
	public int updatePerson(Person person) {
		SqlSession ss = factory.openSession(false);
		int updateResult = ss.update(NS + "updatePerson", person);
		if(updateResult == 1) {
			ss.commit();
		}
		ss.close();
		return updateResult;
	}
	
	public int deletePerson(int personNo) {
		SqlSession ss = factory.openSession();
		int deleteResult = ss.delete(NS + "deletePerson", personNo);
		if(deleteResult == 1) {
			ss.commit();
		}
		ss.close();
		return deleteResult;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
