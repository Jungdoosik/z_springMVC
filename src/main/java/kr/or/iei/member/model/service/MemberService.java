package kr.or.iei.member.model.service;

import java.util.ArrayList;

import kr.or.iei.member.model.vo.Member;

public interface MemberService {

	Member selectLoginMember(String userId, String userPwd);

	int memberUpdate(Member m);

	int memberWithDraw(String userId, String userPwd);

	ArrayList<Member> memberAllList();

	int withDrawChangeBtn(char endYN, int userNo);

}
