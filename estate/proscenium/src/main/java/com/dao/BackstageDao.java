package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.pojo.Buliding;
import org.pojo.Grou;
import org.pojo.Home;
import org.pojo.Homeimg;
import org.pojo.Management;
import org.pojo.Rate;

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
	//修改楼盘
	public void updateBulid(Buliding b);
	@Delete("delete from buliding where bulid=#{value}")
	public void deleteBulid(Integer b);
	
	
	
	
	/************按揭利率**********************************///************///
	//查询按揭利率
		@Select("select * from rate")
		public List<Rate> findRate();
		
		//添加按揭利率
		public  void save(Rate rate);
		
		//单独查询按揭利率
		public Rate loadrate(Integer id);
		
		//修改按揭利率
		public void updaterate(Rate rate) ;
		
		//删除按揭利率
		public void del(Integer id);

		/***************************************************************************************/
	    //新盘列表添加
		@Insert("insert into buliding (buliname,reid,regnid,sid,manid,moid,fid,jprice,starttime,endtime,statu,addres,phone,viewimg,district,developers,licence,jzarea,zdarea,volume,green,company,cost,garage,message,information,maid,hid) values(#{buliname},#{reid},#{regnid},#{sid},#{manid},#{moid},#{fid},#{jprice},#{starttime},#{endtime},'y',#{addres},#{phone},#{viewimg},#{district},#{developers},#{licence},#{jzarea},#{zdarea},#{volume},#{green},#{company},#{cost},#{garage},#{message},#{information},null,1)")
		@SelectKey(before=false,statement="select last_insert_id()",keyProperty="bulid",resultType=Integer.class)
	    public void addbuil(Buliding b);
		
		//状态下拉列表查询
		@Select("select * from management where id=3")
		public List<Management> findzt();
		
		//区域下拉列表查询
		@Select("select * from management where id=1")
		public List<Management> findqy();
		//商圈下拉列表查询
		@Select("select * from management where parid=#{mid}")
		public List<Management> findsq(Integer mid);
		
		//楼型下拉列表查询
		@Select("select * from management where id=4")
		public List<Management> findlx();
		
		//类型下拉列表查询
		@Select("select * from management where id=5")
		public List<Management> findleix();
		//类型下拉列表查询
		@Select("select * from management where id=6")
		public List<Management> findzhx();
		
		//修改前的加载新盘列表 查询楼盘
		public Buliding loadbiu(Integer id);
		//新盘楼房修改
		public void updatebiu(Buliding biu);
//*****************************************************************
		@Insert("insert into homeimg(hsrc,mid,bulid) values(#{hsrc},#{mid},#{bulid})")
		public void addImg(Homeimg img);
		@Select("select * from homeimg where bulid=#{value}")
		public List<Homeimg> findimg(Integer bulid);
}
