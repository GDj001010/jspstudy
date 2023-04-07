package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDAO;

public class MemberDetailService implements IMemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		// DB에서 memberNo값을 가진 회원 정보 받아오기
		Member member = MemberDAO.getInstance().selectMemberByNo(memberNo);
		
		// 응답 데이터 형식 (JSON)
		response.setContentType("application/json; charset=UTF-8");
		
		// 응답 데이터 만들기
		/*
		{
			응답 데이터가 객체로{} 만들어 진다
			"member"{ 라는 프로퍼티 하나만 만들어 진다
				"memberNo": 회원번호,
				"id": 회원아이디,
				"name": 회원이름,
				"gender": 성별,
				"address": 주소
			}
		}
		*/
		JSONObject obj = new JSONObject();
		obj.put("member", new JSONObject(member));
		
		// 응답
		PrintWriter out = response.getWriter();
		out.println(obj.toString());
		out.flush();
		out.close();
		
	}

}
