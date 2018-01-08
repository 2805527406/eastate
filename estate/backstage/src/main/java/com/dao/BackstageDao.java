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
	//��ѯ�������
	@Select("select * from grou")
	public List<Grou> findGrou();
	public List<Management> findManage(Integer id);
	//��ѯ�������
	@Select("select * from management where parid=#{value}")
	public List<Management> findManage2(Integer id);
	//��ѯ�������
	@Select("select * from management where mid=#{value}")
	public List<Management> findManage3(Integer id);
	//�޸��������
	public void updateManage(Management man);
	//ɾ���������
	@Delete("delete from management where mid=${value}")
	public void delManage(Integer d);
	//����������
	@Insert("insert into management(id,mname,time,statu) values(1,#{mname},now(),'y')")
	public void addManage(Management m);
	//�����Ȧ����
	@Insert("insert into management(id,parid,mname,time,statu) values(2,#{mid},#{mname},now(),'y')")
	public void addManage2(Management m);
	/******************************�ָ���*************************************************/
	//��ѯ���еķ�Դ����
	@Select("select * from home")
	public List<Home> findHome();
	@Select("select * from buliding where hid=#{value}")
	public List<Buliding> findBulid(Integer id);
	
}
