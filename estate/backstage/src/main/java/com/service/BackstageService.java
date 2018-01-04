package com.service;

import java.util.List;

import org.pojo.Grou;
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
}
