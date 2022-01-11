package kr.or.iei.member.model.service;

import kr.or.iei.member.model.vo.Member;

public interface MemberService {

	Member selectLoginMember(String userId, String userPwd);

	int memberUpdate(Member m);

	int memberWithDraw(String userId, String userPwd);

}
