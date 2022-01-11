package kr.or.iei.member.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.or.iei.member.model.vo.Member;

public class MemberRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rset, int rowNum) throws SQLException {

		Member m = new Member();
		
		m.setUserNo(rset.getInt("userNo"));
		m.setUserId(rset.getString("userId"));
		m.setUserPwd(rset.getString("userPwd"));
		m.setUserName(rset.getString("userName"));
		m.setAge(rset.getInt("age"));
		m.setAddress(rset.getString("address"));
		m.setEnrollDate(rset.getDate("enrollDate"));
		m.setEndYN(rset.getString("end_yn").charAt(0));
		
		return m;
	}

}
