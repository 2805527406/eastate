package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.pojo.Grou;
import org.pojo.Management;

public interface BackstageDao {
	//查询区域管理
	@Select("select * from grou")
	public List<Grou> findGrou();
	
	
	public List<Management> findManage(Integer id);
	//查询区域管理
	@Select("select * from management where parid=#{value}")
	public List<Management> findManage2(Integer id);
}
