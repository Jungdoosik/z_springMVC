package kr.or.iei.member.model.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.iei.member.model.vo.Member;

@Repository
public class MemberDAO {
	

	@Autowired
	@Qualifier(value="jdbcTemplate")
	JdbcTemplate jdbc;

	public Member selectLoginMember(String userId, String userPwd) {
		
		String query = "select * from member where userId=? and userPwd=? and end_YN='N'";
		
		Object [] params = {userId, userPwd};
		
		ArrayList<Member> list = new ArrayList<Member>(jdbc.query(query, params, new MemberRowMapper()));
		
		if(list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
		
	}

	public int memberUpdate(Member m) {
		String query = "update member set userName=?, age=?, address=? where userId=?";
		
		return jdbc.update(query, m.getUserName(),m.getAge(), m.getAddress(), m.getUserId());
		
		
		
	}

	public int memberWithDraw(String userId, String userPwd) {
		String query = "update member set end_YN = 'Y' where userId=? and userPwd=?";
		
		return jdbc.update(query, userId, userPwd);
		
	}

	public ArrayList<Member> memberAllList() {
		String query = "select * from member";
		
		return new ArrayList<Member>(jdbc.query(query, new MemberRowMapper()));
		
	}

	public int withDrawChange(char endYN, int userNo) {
		String query = "update member set end_YN=? where userNo = ?";
		
		return jdbc.update(query, String.valueOf(endYN), userNo);		
		
	}

}
