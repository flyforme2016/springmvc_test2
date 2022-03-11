package com.junefw.infra.modules.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junefw.infra.modules.code.Code;
import com.junefw.infra.modules.code.CodeVo;

@Controller
public class MemberController {

	@Autowired
	MemberServiceImpl service;
	
	@RequestMapping(value = "/member/memberList")
//	public String memberList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {
	public String memberList(Model model) throws Exception {

		List<Member> list = service.selectList();
		model.addAttribute("list", list);

		return "member/memberList";
	}
	
	@RequestMapping(value = "/member/memberForm")
	public String memberForm(Model model) throws Exception {

		List<Member> list = service.selectList();
		
		model.addAttribute("list", list);
		
		return "member/memberForm";
	}
	
	@RequestMapping(value = "/member/memberForm2")
	public String memberForm2(MemberVo vo, Model model) throws Exception {
		
		Member rt = service.selectOne(vo);
		
		model.addAttribute("item", rt);
		
		return "member/memberForm2";
	}
	
	@RequestMapping(value = "/member/memberInst")
	public String memberInst(Model model, Member dto) throws Exception {
		
		System.out.println("dto.getIfmmId(): " + dto.getIfmmId());
		System.out.println("dto.getIfmmName(): " + dto.getIfmmName());

		// 입력을 작동시킨다.
		int result = service.insert(dto);
		
		System.out.println("result: " + result);

		return "member/memberList";
	}
	
	@RequestMapping(value = "/member/memberUpdt")
	public String memberUpdt(Member dto) throws Exception {
		
		service.update(dto);
		
		System.out.println("Controller dto.getIfmmSeq: " + dto.getIfmmSeq());
		
		return "redirect:/member/memberView?ifmmSeq="+ dto.getIfmmSeq();
	}
	
	
	@RequestMapping(value = "/member/memberView")
	public String memberView(Model model, MemberVo vo) throws Exception{
		
		System.out.println("vo.getIfmmSeq(): " + vo.getIfmmSeq());
		Member rt = service.selectOne(vo);
		
		model.addAttribute("item", rt);
		
		return "member/memberView";
	}
	
	
}