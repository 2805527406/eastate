package com.service;

import java.util.List;

import org.pojo.Buliding;
import org.pojo.Grou;
import org.pojo.Home;
import org.pojo.Management;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BackstageDao;
@Service("backstageservice")
public class BackstageService {
	@Autowired
	private BackstageDao bsd;
	
	public List<Grou> findGrou(){
		return bsd.findGrou();
	}
	
	public List<Management> findManage(Integer id){
		return bsd.findManage(id);//
	}
	public List<Management> findManage2(Integer id){
		return bsd.findManage2(id);//
	}
	//修改管理
	public void updateManage(Management man){
		bsd.updateManage(man);
	}
	//删除
	public void delManage(Integer man){
		bsd.delManage(man);
	}
	//添加区域
	public void addManage(Management m){
		bsd.addManage(m);
	}
	//添加商圈
		public void addManage2(Management m){
			bsd.addManage2(m);
		}
		
		/********************************************************************************/
		//查询所有房源管理
	public List<Home> findHome(){
		return bsd.findHome();
	}
	public List<Buliding> findBuild(Integer id){
		return bsd.findBulid(id);
	}
	
}
