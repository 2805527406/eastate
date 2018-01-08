package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.pojo.Buliding;
import org.pojo.Grou;
import org.pojo.Home;
import org.pojo.Management;

public interface BackstageDao {
	//查询区域管理
	@Select("select * from grou")
	public List<Grou> findGrou();
	public List<Management> findManage(Integer id);
	//查询区域管理
	@Select("select * from management where parid=#{value}")
	public List<Management> findManage2(Integer id);
	//查询区域管理
	@Select("select * from management where mid=#{value}")
	public List<Management> findManage3(Integer id);
	//修改区域管理
	public void updateManage(Management man);
	//删除区域管理
	@Delete("delete from management where mid=${value}")
	public void delManage(Integer d);
	//添加区域管理
	@Insert("insert into management(id,mname,time,statu) values(1,#{mname},now(),'y')")
	public void addManage(Management m);
	//添加商圈管理
	@Insert("insert into management(id,parid,mname,time,statu) values(2,#{mid},#{mname},now(),'y')")
	public void addManage2(Management m);
	/******************************分割线*************************************************/
	//查询所有的房源分类
	@Select("select * from home")
	public List<Home> findHome();
	@Select("select * from buliding where hid=#{value}")
	public List<Buliding> findBulid(Integer id);
	
}
