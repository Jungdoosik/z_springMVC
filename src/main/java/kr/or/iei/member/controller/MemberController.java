package kr.or.iei.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	
	@RequestMapping(value="/member/login.do", method = RequestMethod.POST)
	public String selectLoginMember(HttpServletRequest requset,
								 @RequestParam String userId,
								 @RequestParam String userPwd) {
		
		Member m = mService.selectLoginMember(userId, userPwd);
		
		if(m != null) {
			HttpSession session = requset.getSession();
			session.setAttribute("member", m);
			
			return "redirect:/";
		}else {
			return "member/loginFail";
		}

	}
	
	@RequestMapping(value="/member/logout.do", method = RequestMethod.GET)
	public String logoutMember(HttpSession session, @SessionAttribute Member member) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/member/myPage.do")
	public String myPagePassCheck(HttpServletRequest request,@SessionAttribute Member member,HttpSession session,Model model) {
		String userPwd = request.getParameter("userPwd");
		
		System.out.println(userPwd);
		
		if(userPwd == null) {
			return "member/myPagePassCheck";
		}else {
			String userId = member.getUserId();
			
			Member m = mService.selectLoginMember(userId, userPwd);
			
			if(m != null) {
				session.setAttribute("member", m);
				
				return "member/myPage";
			}else {
				
				model.addAttribute("msg","???????????? ???????????????");
				model.addAttribute("location","/member/myPage.do");
				
				return "member/msg";
			}
		
		}
		
	}
	
	
	@RequestMapping(value="/member/memberUpdate.do", method=RequestMethod.POST)
	public String memberUpdate(HttpServletRequest request, @SessionAttribute Member member, Model model) {
		
		String uri = request.getRequestURI().toString();
		System.out.println("["+uri+"] ????????????" );
		
		
		String userName = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		
		String userId = member.getUserId();
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserName(userName);
		m.setAge(age);
		m.setAddress(address);
		
		int result = mService.memberUpdate(m);
		
		if(result>0) {
			model.addAttribute("msg","?????? ?????? ?????? ??????");
			model.addAttribute("location","/member/myPage.do");
		}else {
			model.addAttribute("msg","?????? ?????? ?????? ??????");
			model.addAttribute("location","/");
		}
		return "member/msg";
	}
	
	@RequestMapping(value="/member/withDraw.do")
	public String MemberWithDraw(HttpServletRequest request, Model model, @SessionAttribute Member member,HttpSession session) {
		
		String userPwd = request.getParameter("userPwd");
		
		
		
		if(userPwd == null) {
			return "member/withDraw";	
		}
		
		String agree = request.getParameter("agree");
		
		if(agree == null || (!agree.equals("Y")) ) {
			model.addAttribute("msg","??????????????? ????????? ???????????????.");
			model.addAttribute("location","/member/withDraw.do");
			return "member/msg";
		}
		
		String userId = member.getUserId();
		
		int result = mService.memberWithDraw(userId , userPwd);
		
		if(result >0) {
			session.invalidate();
			
			model.addAttribute("msg","????????????. ???????????????.");
			model.addAttribute("location","/");
		}else {
			model.addAttribute("msg","???????????? ??????????????????. - ???????????? ?????? ????????? ??????????????? ??????????????????.");
			model.addAttribute("location","/member/withDraw.do");
		}
		
		
		return "member/msg";
	}
	
	@RequestMapping(value="/member/memberAllList.do")
	public ModelAndView memberAllList(ModelAndView mav) {
		
		ArrayList<Member> list = mService.memberAllList();
		
		mav.addObject("list", list );
		
		mav.setViewName("member/memberAllList");
		
		return mav;
		
	}
	
	@RequestMapping(value="/member/withDrawChangeBtn.do",method=RequestMethod.GET)
	public void withDrawChangeBtn(@RequestParam char endYN, @RequestParam int userNo,HttpServletResponse response) throws IOException {
		
		endYN = endYN == 'Y'?'N':'Y';
		
		int result = mService.withDrawChangeBtn(endYN, userNo);
		
		if(result>0) {
			response.getWriter().print(endYN);
		}else {
			response.getWriter().print(false);
		}
	}
}
