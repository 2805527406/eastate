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
	//��ѯ���з���������
	@RequestMapping(value="/grou")
	@ResponseBody
	public Object find(){
		return bss.findGrou();
	}
	//��ѯ���з�Դ�������
		@RequestMapping(value="/grou2")
		@ResponseBody
		public Object find2(){
			return bss.findHome();
		}
	
	//��ѯ�������
	@RequestMapping(value="/region")
	@ResponseBody
	public Object region(Integer id){
		return bss.findManage(id);
	}
	//��ѯ�������
	@RequestMapping(value="/builder")
	@ResponseBody
	public Object builder(Integer id){
		return bss.findBuild(id);
	}
	
	//����
	@RequestMapping(value = "/qugai")
	@ResponseBody
	public Object qugai(Management mage) {
		bss.updateManage(mage);
		return "ok";
	}

	// ��ɾ
	@RequestMapping(value = "/qudel")
	@ResponseBody
	public Object qushan(Integer mid) {
		//�Ȳ���Ƿ�������
		List<Management> s=bss.findManage2(mid);
		if(s!=null){
			for(Management m:s){
				bss.delManage(m.getMid());
			}
		}
		bss.delManage(mid);
		return "ok";
	}
	//����
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
