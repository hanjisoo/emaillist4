package com.emaillist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emaillist.repository.EmaillistDao;
import com.emaillist.vo.EmaillistVo;



@Controller
public class EmaillistController {
	
	@Autowired//new해줘
	private EmaillistDao dao;
	
	@RequestMapping("/test")
	public void test() {
		//겁색기능 성이 박인애랑 이메일이 aa인 애를 불러와.
			 //키값,		별명
		Map<String, Object> map =new HashMap<String,Object>();
		map.put("last_name", "박");	//키,값	키를 부르면 값을 꺼내올꺼야.
		map.put("email", "aa");
		List<EmaillistVo>list=dao.getListByMap(map);
		System.out.println(list.toString());
		
		/*EmaillistVo vo=dao.getByNo(4);
		System.out.println("getByNo()");
		System.out.println(vo.toString());*/
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		/*EmaillistDao dao=new EmaillistDao();삭제해버렷*/
		List<EmaillistVo> list=dao.getlist();
		System.out.println(list.toString());
		model.addAttribute("list", list);//위에 모델써주고 데이터 받아줌
		return"list";
		/*return"WEB-INF/views/list.jsp";*/
		//포워드
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)// "/add"라고 쓰면 get방식이다.
	public String add(@ModelAttribute EmaillistVo vo) {
		System.out.println(vo.toString());
		dao.insert(vo);
		return"redirect:/list";
		//리다이랙트
	}
	
	@RequestMapping("/form")
	//form	리턴형이 스트링이야
	public String form() {
		return"form";
		/*return"/WEB-INF/views/form.jsp";*/
	}
}
