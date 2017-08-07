package com.emaillist.repository;//getlist만들꺼야


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emaillist.vo.EmaillistVo;

@Repository
public class EmaillistDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	public List<EmaillistVo> getListByMap(Map<String,Object>map){
		return sqlSession.selectList("emaillist.getListByMap",map);	
	}
	
	
	
	
	public EmaillistVo getByNo(int no) {
		return sqlSession.selectOne("emaillist.getByNo",no);
	}
	
	
	public int insert(EmaillistVo vo) {
		/*sqlSession.insert("emaillist.insert",vo);
		return ;*/
		return sqlSession.insert("emaillist.insert",vo);
	}
	
	
	
	public List<EmaillistVo> getlist() {
		/*List<EmaillistVo> list=sqlSession.selectList("emaillist.getList2");
		return list;*/
		return sqlSession.selectList("emaillist.getList2");
	}								

}
