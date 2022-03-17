package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

	@Autowired
	CodeServiceImpl service;

	/* infrCodeGroup */
	@RequestMapping(value = "/code/codeGroupList")
	public String codeGroupList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		//count가 0이 아니면 list 가져오는 부분 수행 후 model 개체에 담기
		int count = service.selectOneCount(vo);
		
		vo.setParamsPaging(count);
		
		if(count != 0) {
			List<Code> list = service.selectList(vo);
			
			model.addAttribute("list", list);
		}
		
		return "code/codeGroupList";
	}
	
	@RequestMapping(value = "/code/codeGroupForm")
	public String codeGroupForm(Model model) throws Exception {

		return "code/codeGroupForm";
	}

	@RequestMapping(value = "/code/codeGroupForm2")
	public String codeGroupForm2(CodeVo vo, Model model) throws Exception {

		Code rt = service.selectOne(vo);

		model.addAttribute("item", rt);

		return "code/codeGroupForm2";
	}

	@RequestMapping(value = "/code/codeGroupInst")
	public String codeGroupInst(Model model, Code dto) throws Exception {

		// 입력을 작동시킨다.
		int result = service.insert(dto);

		System.out.println("result: " + result);

		return "redirect:/code/codeGroupList";
	}

	@RequestMapping(value = "/code/codeGroupUpdt")
	public String codeGroupUpdt(Code dto) throws Exception {

		service.update(dto);

		System.out.println("Controller dto.getIfcgSeq: " + dto.getIfcgSeq());

		return "redirect:/code/codeGroupView?ifcgSeq="+ dto.getIfcgSeq();
	}

	@RequestMapping(value = "/code/codeGroupView")
	public String codeGroupView(Model model, CodeVo vo) throws Exception {

		System.out.println("vo.getIfcgSeq(): " + vo.getIfcgSeq());
		Code rt = service.selectOne(vo);

		model.addAttribute("item", rt);

		return "code/codeGroupView";
	}

	/* ------------------------- infrCode -------------------------*/
	@RequestMapping(value = "/code/codeList")
	public String codeList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {

		List<Code> list = service.selectListCode(vo);
		model.addAttribute("list", list);

		List<Code> listCodeGroup = service.selectList(vo);
		model.addAttribute("listCodeGroup", listCodeGroup);
		
		return "code/codeList";
	}

	@RequestMapping(value = "/code/codeForm")
	public String codeForm(CodeVo vo, Model model) throws Exception {

		List<Code> list = service.selectListCode(vo);

		model.addAttribute("list", list);

		return "code/codeForm";
	}

	@RequestMapping(value = "/code/codeForm2")
	public String codeForm2(CodeVo vo, Model model) throws Exception {

		Code rt = service.selectOneCode(vo);

		model.addAttribute("item", rt);

		return "code/codeForm2";
	}

	@RequestMapping(value = "/code/codeInst")
	public String codeInst(Model model, Code dto) throws Exception {

		service.insertCode(dto);

		return "redirect:/code/codeList";
	}

	@RequestMapping(value = "/code/codeUpdt")
	public String codeUpdt(Code dto) throws Exception {

		service.updateCode(dto);

		return "";
	}

	@RequestMapping(value = "/code/codeView")
	public String codeView(Model model, CodeVo vo) throws Exception {

		System.out.println("vo.getIfcgSeq(): " + vo.getIfcgSeq());
		Code rt = service.selectOneCode(vo);

		model.addAttribute("item", rt);

		return "code/codeView";
	}

}