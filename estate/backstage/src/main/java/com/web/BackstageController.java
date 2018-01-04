package com.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.BackstageService;

@Controller
public class BackstageController {
	@Resource(name="backstageservice")
	private BackstageService bss;
	//查询所有分类
	@RequestMapping(value="/grou")
	@ResponseBody
	public Object find(){
		return bss.findGrou();
	}
	
	//查询区域管理
	@RequestMapping(value="/region")
	@ResponseBody
	public Object region(Integer id){
		return bss.findManage(id);
	}

	
}
