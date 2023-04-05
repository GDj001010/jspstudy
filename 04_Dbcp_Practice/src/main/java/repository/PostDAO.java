package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import domain.PostVO;

public class PostDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	// connection Pool 관리하는 객체
	private DataSource dataSource;
	
	private static PostDAO dao = new PostDAO();
	
	private PostDAO() {
		try {
			// context.xml 파일 내용을 읽어서 dataSource를 만들어주세용
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static PostDAO getInstance() {
		return dao;
	}
	
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<PostVO> getAllPosts() throws Exception {
		List<PostVO> posts = new ArrayList<PostVO>();
		con = dataSource.getConnection(); // connection 받아오기
		sql = "SELECT POST_NO, WRITER, TITLE, CONTENT, IP, MODIFIED_DATE, CREATED_DATE";
		sql += " FROM POST";
		sql += " ORDER BY POST_NO DESC";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			// 객체로 만들어서 list에 집어넣기
			PostVO post = PostVO.builder()	// PostVO에 칼럼 값을 넣겠다.
							.post_no(rs.getInt(1))	// SELECT문에 적힌 순서 setPost_no(rs.getInt(1))
							.writer(rs.getString(2))	// setWriter(rs.getString(2)) 와 같은 역할
							.title(rs.getString(3))
							.content(rs.getString(4))
							.ip(rs.getString(5))
							.modified_date(rs.getDate(6))
							.created_date(rs.getDate(7))
							.build();
			posts.add(post);
		}
		close();
		return posts;
		
	}
	
	public int savePost(PostVO post) throws Exception {
		con = dataSource.getConnection();
		sql = "INSERT INTO POST(POST_NO, WRITER, TITLE, CONTENT, IP, MODIFIED_DATE, CREATED_DATE)";
		sql += " VALUES(POST_SEQ.NEXTVAL, ?, ?, ?, ?, NULL, SYSDATE)";
		ps = con.prepareStatement(sql);
		
		ps.setString(1, post.getWriter());
		ps.setString(2, post.getTitle());
		ps.setString(3, post.getContent());
		ps.setString(4, post.getIp());
		int saveResult = ps.executeUpdate();
		close();
		return saveResult;
	}
	
	public PostVO getPostByNo(int post_no) throws Exception {
		PostVO post = null;
		con = dataSource.getConnection();
		sql = "SELECT POST_NO, WRITER, TITLE, CONTENT, IP, MODIFIED_DATE, CREATED_DATE";
		sql += " FROM POST";
		sql += " WHERE POST_NO = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, post_no);
		rs = ps.executeQuery();
		if(rs.next()) {
			post = PostVO.builder()
						 .post_no(post_no)
						 .writer(rs.getString(2))
						 .title(rs.getString(3))
						 .content(rs.getString(4))
						 .ip(rs.getString(5))
						 .modified_date(rs.getDate(6))
						 .created_date(rs.getDate(7))
						 .build();
		}
		close();
		return post;
		
	}
	
	public int updatePost(PostVO post) throws Exception {
		con = dataSource.getConnection();
		sql = "UPDATE POST";
		sql += " SET TITLE = ?, CONTENT = ?, MODIFIED_DATE = SYSDATE";
		sql += " WHERE POST_NO = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, post.getTitle());
		ps.setString(2, post.getContent());
		ps.setInt(3, post.getPost_no());
		int updateResult = ps.executeUpdate();
		
		close();
		return updateResult;
	}
	
	public int deletePost(int post_no) throws Exception {
		con = dataSource.getConnection();
		sql = "DELETE FROM POST WHERE POST_NO = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, post_no);
		int deleteResult = ps.executeUpdate();
		
		close();
		return deleteResult;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
