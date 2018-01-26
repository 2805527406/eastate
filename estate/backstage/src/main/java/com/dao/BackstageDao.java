package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.pojo.Buliding;
import org.pojo.Grou;
import org.pojo.Home;
import org.pojo.Homeimg;
import org.pojo.Management;
import org.pojo.Rate;
import org.pojo.Users;

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
	//�޸�¥��
	public void updateBulid(Buliding b);
	@Delete("delete from buliding where bulid=#{value}")
	public void deleteBulid(Integer b);
	
	
	
	
	/************��������**********************************///************///
	//��ѯ��������
		@Select("select * from rate")
		public List<Rate> findRate();
		
		//��Ӱ�������
		public  void save(Rate rate);
		
		//������ѯ��������
		public Rate loadrate(Integer id);
		
		//�޸İ�������
		public void updaterate(Rate rate) ;
		
		//ɾ����������
		public void del(Integer id);

		/***************************************************************************************/
	    //�����б����
		@Insert("insert into buliding (buliname,reid,regnid,sid,manid,moid,fid,jprice,starttime,endtime,statu,addres,phone,viewimg,district,developers,licence,jzarea,zdarea,volume,green,company,cost,garage,message,information,maid,hid) values(#{buliname},#{reid},#{regnid},#{sid},#{manid},#{moid},#{fid},#{jprice},#{starttime},#{endtime},'y',#{addres},#{phone},#{viewimg},#{district},#{developers},#{licence},#{jzarea},#{zdarea},#{volume},#{green},#{company},#{cost},#{garage},#{message},#{information},null,1)")
		@SelectKey(before=false,statement="select last_insert_id()",keyProperty="bulid",resultType=Integer.class)
	    public void addbuil(Buliding b);
		
		//״̬�����б��ѯ
		@Select("select * from management where id=3")
		public List<Management> findzt();
		
		//���������б��ѯ
		@Select("select * from management where id=1")
		public List<Management> findqy();
		//��Ȧ�����б��ѯ
		@Select("select * from management where parid=#{mid}")
		public List<Management> findsq(Integer mid);
		
		//¥�������б��ѯ
		@Select("select * from management where id=4")
		public List<Management> findlx();
		
		//���������б��ѯ
		@Select("select * from management where id=5")
		public List<Management> findleix();
		//���������б��ѯ
		@Select("select * from management where id=6")
		public List<Management> findzhx();
		//��ѯ¥���ȫ��ͼƬ
		@Select("select * from homeimg where bulid=#{value}")
		public List<Homeimg> findimg(Integer bulid);
		//�޸�ǰ�ļ��������б� ��ѯ¥��
		public Buliding loadbiu(Integer id);
		//����¥���޸�
		public void updatebiu(Buliding biu);
		//�޸�ͼƬ
		@Update("update homeimg set hsrc=#{hsrc},mid=#{mid},bulid=#{bulid} where maid=#{maid}")
		public void updateimg(Homeimg h);
		//ɾ��ͼƬ
		@Delete("delete from homeimg where bulid=#{value}")
		public void delImg(Integer main);
//*****************************************************************
		@Insert("insert into homeimg(hsrc,mid,bulid) values(#{hsrc},#{mid},#{bulid})")
		public void addImg(Homeimg img);
		
/////////////////////////////////////////////////////////////////////
//�û���¼
@Select("select * from users where username=#{username} and password=#{password}")
public Users findallu(Users usrs);
//�û�ע���ѯ
@Select("select * from users where username=#{username}")
public Users findzc(Users usrs);
//ע���û�
@Insert("insert into users (username,password,sex,phone,email,tximg,statu) values(#{username},#{password},null,null,#{email},null,'y')")
public void adduser(Users usrs);
}
