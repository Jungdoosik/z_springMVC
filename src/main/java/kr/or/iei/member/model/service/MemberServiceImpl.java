package kr.or.iei.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.iei.member.model.dao.MemberDAO;
import kr.or.iei.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO mDAO;

	@Override
	public Member selectLoginMember(String userId, String userPwd) {

		return mDAO.selectLoginMember(userId, userPwd);
		
		
		
	}

	@Override
	public int memberUpdate(Member m) {

		return mDAO.memberUpdate(m);
		
	}

	@Override
	public int memberWithDraw(String userId, String userPwd) {
		return mDAO.memberWithDraw(userId, userPwd);
		
	}

	@Override
	public ArrayList<Member> memberAllList() {
		return mDAO.memberAllList();
		
	}

	@Override
	public int withDrawChangeBtn(char endYN, int userNo) {
		return mDAO.withDrawChange(endYN, userNo);
		
	}
}
