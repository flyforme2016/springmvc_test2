package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junefw.infra.modules.member.Member;

@Service
public class CodeServiceImpl implements CodeService{

	@Autowired
	CodeDao dao;

	@Override
	public List<Code> selectList() throws Exception {
		return dao.selectList();
	}
	
	public int insert(Code dto) throws Exception{
		return dao.insert(dto);
	}

}