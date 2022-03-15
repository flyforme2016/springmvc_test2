package com.junefw.infra.modules.code;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.junefw.infra.modules.member.Member;

@Repository
public class CodeDao {
	
	@Inject
//	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	private static String namespace = "com.junefw.infra.modules.code.CodeMpp";
	
	/* infrCodeGroup */
	public int selectOneCount(CodeVo vo) {return sqlSession.selectOne(namespace + ".selectOneCount", vo);}
	public List<Code> selectList(CodeVo vo) {return sqlSession.selectList(namespace + ".selectList", vo);}
	public int insert(Code dto){ return sqlSession.insert(namespace + ".insert", dto);}
	public Code selectOne(CodeVo vo) {return sqlSession.selectOne(namespace + ".selectOne", vo);}
	public int update(Code dto){ return sqlSession.update(namespace + ".update", dto);}
	
	/* infrCode */
	public List<Code> selectListCode(CodeVo vo) {return sqlSession.selectList(namespace + ".selectListCode", vo);}
	public Code selectOneCode(CodeVo vo) {return sqlSession.selectOne(namespace + ".selectOneCode", vo);}
	public int insertCode(Code dto){ return sqlSession.insert(namespace + ".insertCode", dto);}
	public int updateCode(Code dto){ return sqlSession.update(namespace + ".updateCode", dto);}
	
}