package com.web;

import java.util.List;

import javax.annotation.Resource;

import org.pojo.Management;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.BackstageService;

@Controller
public class BackstageController {
	@Resource(name="backstageservice")
	private BackstageService bss;
	//查询所有分类管理分类
	@RequestMapping(value="/grou")
	@ResponseBody
	public Object find(){
		return bss.findGrou();
	}
	//查询所有房源管理分类
		@RequestMapping(value="/grou2")
		@ResponseBody
		public Object find2(){
			return bss.findHome();
		}
	
	//查询区域管理
	@RequestMapping(value="/region")
	@ResponseBody
	public Object region(Integer id){
		return bss.findManage(id);
	}
	//查询区域管理
	@RequestMapping(value="/builder")
	@ResponseBody
	public Object builder(Integer id){
		return bss.findBuild(id);
	}
	
	//区改
	@RequestMapping(value = "/qugai")
	@ResponseBody
	public Object qugai(Management mage) {
		bss.updateManage(mage);
		return "ok";
	}

	// 区删
	@RequestMapping(value = "/qudel")
	@ResponseBody
	public Object qushan(Integer mid) {
		//先查出是否有子类
		List<Management> s=bss.findManage2(mid);
		if(s!=null){
			for(Management m:s){
				bss.delManage(m.getMid());
			}
		}
		bss.delManage(mid);
		return "ok";
	}
	//区添
	@RequestMapping(value = "/tianjia")
	@ResponseBody
	public Object tianjia(Management m) {
		if(m.getMid()==0&&m.getMid()!=null){
			bss.addManage(m);
			return "ok";
		}
		if(m.getMid()!=0&&m.getMid()!=null){
			bss.addManage2(m);
			return "ok";
		}
		return "no";
	}

	
}
