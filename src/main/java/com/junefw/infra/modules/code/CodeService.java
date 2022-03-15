package com.junefw.infra.modules.code;

import java.util.List;

import com.junefw.infra.modules.member.Member;

public interface CodeService {
	//Default : public abstract
	/* infrCodeGroup */
	int selectOneCount(CodeVo vo) throws Exception;
	List<Code> selectList(CodeVo vo) throws Exception;
	Code selectOne(CodeVo vo) throws Exception;
	int insert(Code dto) throws Exception;
	int update(Code dto) throws Exception;

	/* infrCode */
	List<Code> selectListCode(CodeVo vo) throws Exception;
	Code selectOneCode(CodeVo vo) throws Exception;
	int insertCode(Code dto) throws Exception;
	int updateCode(Code dto) throws Exception;

}