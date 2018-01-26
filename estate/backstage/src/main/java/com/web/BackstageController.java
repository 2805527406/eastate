package com.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.scripting.xmltags.VarDeclSqlNode;
import org.pojo.Buliding;
import org.pojo.Homeimg;
import org.pojo.Management;
import org.pojo.Rate;
import org.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.BackstageService;
import com.sun.org.apache.xpath.internal.functions.Function;
import com.util.Base;
import com.util.Picture;
import com.util.Topic;

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
	
	
	
	/********************************************************/
	//��ѯ����
		@RequestMapping(value="/builder")
		@ResponseBody
		public Object builder(Integer id){
			System.out.println("�ҽ�����ѽ��+"+id);
			return bss.findBuild(id);
		}
	//����
		@RequestMapping(value = "/fanggai")
		@ResponseBody
		public Object fanggai(Buliding b) {
			bss.updateBuild(b);
			return "ok";
		}

		// ��ɾ
		@RequestMapping(value = "/fangdel")
		@ResponseBody
		public Object fangshan(Integer id) {
			bss.deleteBulid(id);
			return "ok";
		}
		
		// ��ɾ
		@RequestMapping(value = "/urlList")
		@ResponseBody
		public Object urlList(HttpServletRequest request) throws ParseException {
			
			//�Ȳ���Ƿ�������
				System.out.println("�ҵ�������");
				String num=request.getParameter("num");
				Date d=new Date();
				System.out.println("������"+num);
				if(num!=null&&num!="0"){
					String viewimg=request.getParameter("viewimg");
					String image2 = viewimg.substring(viewimg.indexOf(",") + 1);//��ȡ��ʼ��ȡ��λ��
					String[] strings3=viewimg.split(",");
					String[] strings4=strings3[0].split("/|;");
					String suffix2=strings4[1];//��׺
					String str2="."+suffix2;
					String pic2=d.getTime()+"ggl"+str2;
					Base.generateImage(image2,"D:\\��Դ\\������ĿͼƬ·��\\home\\"+pic2);
					Buliding build = obj(request);
					build.setViewimg("/img/"+pic2);
					bss.addbuil(build);
					//ͼƬ�ϴ�
					int n=Integer.parseInt(num);
					for(int i=1;i<=n;i++){
						String wenjian1=request.getParameter("s"+i);
						
						String image = wenjian1.substring(wenjian1.indexOf(",") + 1);//��ȡ��ʼ��ȡ��λ��
						String[] strings=wenjian1.split(",");
						String[] strings2=strings[0].split("/|;");
						String suffix=strings2[1];//��׺
						String str="."+suffix;
						String pic=d.getTime()+i+str;
						Base.generateImage(image,"D:\\��Դ\\������ĿͼƬ·��\\home\\"+pic);
						Homeimg img=new Homeimg();
						img.setHsrc("/img/"+pic);
						img.setBulid(build.getBulid());
						img.setMid(24);//�ȸ����̶�ֵ¥��ͼ
						bss.addImg(img);
					}
				}
				
				return "ok";
		}
		//������ķ��������������������
		public Buliding obj(HttpServletRequest request) throws ParseException{
			Buliding buliding=new Buliding();
			String bulid=request.getParameter("bulid");
			buliding.setBulid(Integer.parseInt(bulid));
			String buliname=request.getParameter("buliname");
			buliding.setBuliname(buliname);
			String reid=request.getParameter("reid");
			buliding.setReid(Integer.parseInt(reid));
			String regnid=request.getParameter("regnid");
			buliding.setRegnid(Integer.parseInt(regnid));
			String sid=request.getParameter("sid");
			buliding.setSid(Integer.parseInt(sid));
			String manid=request.getParameter("manid");
			buliding.setManid(Integer.parseInt(manid));
			String moid=request.getParameter("moid");
			buliding.setMoid(Integer.parseInt(moid));
			String fid=request.getParameter("fid");
			buliding.setFid(Integer.parseInt(fid));
			String jprice=request.getParameter("jprice");
			buliding.setJprice(Float.parseFloat(jprice));
			String starttime=request.getParameter("starttime");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			buliding.setStarttime(sdf.parse(starttime));
			String endtime=request.getParameter("endtime");
			buliding.setEndtime(sdf.parse(endtime));
			String addres=request.getParameter("addres");
			buliding.setAddres(addres);
			String phone=request.getParameter("phone");
			buliding.setPhone(phone);
			
			String district=request.getParameter("district");
			buliding.setDistrict(district);
			String developers=request.getParameter("developers");
			buliding.setDevelopers(developers);
			String licence=request.getParameter("licence");
			buliding.setLicence(licence);
			String jzarea=request.getParameter("jzarea");
			buliding.setJzarea(Float.parseFloat(jzarea));
			String zdarea=request.getParameter("zdarea");
			buliding.setZdarea(Float.parseFloat(zdarea));
			String volume=request.getParameter("volume");
			buliding.setVolume(Float.parseFloat(volume));
			String green=request.getParameter("green");
			buliding.setGreen(Float.parseFloat(green));
			String company=request.getParameter("company");
			buliding.setCompany(company);
			String cost=request.getParameter("cost");
			buliding.setCost(Float.parseFloat(cost));
			String garage=request.getParameter("garage");
			buliding.setGarage(Integer.parseInt(garage));
			String message=request.getParameter("message");
			buliding.setMessage(message);
			String information=request.getParameter("information");
			buliding.setInformation(information);
			return buliding;
		}
	/*******************************************************************************************************/
		//�������ʵĲ�ѯ
		@RequestMapping(value="/rate")
		@ResponseBody
		public Object findRate(){
			return bss.findRate();
		}
		
		//��Ӱ������� web
			@RequestMapping(value="/addrate")
			@ResponseBody
			public Object  add(Rate rate){
				bss.saverate(rate);
				 //Map<Object,Object> map = new HashMap<Object,Object>();
				 //map.put("rates", bss.findRate());
				
				return "ok";
			}
				
		
		//������ѯ��������
		@RequestMapping(value="/loadrate")
		@ResponseBody
		public Object loadrate(Integer raid){
			System.out.println("�޸ĵ�raid"+raid);
			return bss.loadrate(raid);
		}
		
		//�޸İ�������
		@RequestMapping(value="/updaterate")
		@ResponseBody
		public Object updaterate(Rate rate){
			Rate oldrate= bss.loadrate(rate.getRaid());
			oldrate.setNature(rate.getNature());
			oldrate.setRetname(rate.getRetname());
			oldrate.setRayear(rate.getRayear());
			oldrate.setReyear2(rate.getReyear2());
			oldrate.setRet(rate.getRet());
			oldrate.setRet2(rate.getRet2());
			oldrate.setRetime(rate.getRetime());
			oldrate.setStatu(rate.getStatu());
			
			bss.updaterate(oldrate);
			return "ok";
		}
		
		//ɾ����������
		@RequestMapping(value="/deleterate")
		@ResponseBody
		public Object deleterate(Integer raid){//raid��������ݿ���е��ֶ�һ��
					bss.del(raid);
					return "ok";
		}
		
		/**********************************************************************************************/
	     
		//��¥�����
		@RequestMapping(value="/addbuil")
		@ResponseBody
		public Object addbuil(Buliding b ){
			System.out.println("tianjiazhi:"+b);
			bss.addbuil(b);
			return "ok";
		}
		//״̬�����б��ѯ
		@RequestMapping(value="/findzt")
		@ResponseBody
		public Object findzt(){
			return bss.findzt();
		}
		//���������б��ѯ
				@RequestMapping(value="/findqy")
				@ResponseBody
				public Object findqy(){
					return bss.findqy();
				}
	  //��Ȧ�����б��ѯ
				@RequestMapping(value="/findsq")
				@ResponseBody
				public Object findsq(Integer mid){
					System.out.println("�ҽ�����ѽ��+"+mid );
					return bss.findsq(mid);
				}
		//¥�������б��ѯ
				@RequestMapping(value="/findlx")
				@ResponseBody
				public Object findlx(){
					return bss.findlx();
				}
		//���������б��ѯ
				@RequestMapping(value="/findliex")
				@ResponseBody
				public Object findleix(){
					return bss.findleix();
				}
		//���������б��ѯ
				@RequestMapping(value="/findzhx")
				@ResponseBody
				public Object findzhx(){
					return bss.findzhx();
				}
				
	   //�·�¥���޸ļ���
				@RequestMapping(value="/loadbiu")
				@ResponseBody
				public Object loadbiu(Integer bulid){
					System.out.println("�·�id"+bulid);
					Buliding b=bss.loadbiu(bulid);
					b.setViewimg(subimg(b.getViewimg()));
					if(!b.getHomeimg().isEmpty()){
						ArrayList<Homeimg> homeimg=(ArrayList<Homeimg>)b.getHomeimg();
						for(int i=0;i<homeimg.size();i++){
							homeimg.get(i).setHsrc(subimg(homeimg.get(i).getHsrc()));
						}
						b.setHomeimg(homeimg);
					}
					return b;
				}
				//
				public String subimg(String varchar){
					String[] strings3=varchar.split("/");
					String str=strings3[strings3.length-1];
					String[] strings=str.split("\\.");
					String pre=strings[1];
					String img=Picture.GetImageStr("D:\\��Դ\\������ĿͼƬ·��\\home\\"+str);
					String prefix="data:image/"+pre+";base64,"+img;
					return prefix;
				}
		//�·�¥���޸ļ���
				@RequestMapping(value="/updatebiu")
				@ResponseBody
				public Object updatebiu(HttpServletRequest request,String starttime,String endtime) throws ParseException{
					Buliding biu=obj(request);
					System.out.println("�޸��·�id"+biu);
					Buliding oldbiu =bss.loadbiu(biu.getBulid());
					oldbiu.setBulid(biu.getBulid());
					oldbiu.setBuliname(biu.getBuliname());
					oldbiu.setReid(biu.getReid());
					oldbiu.setRegnid(biu.getRegnid());
					oldbiu.setSid(biu.getSid());
					oldbiu.setManid(biu.getManid());
					oldbiu.setMoid(biu.getMoid());
					oldbiu.setFid(biu.getFid());
					oldbiu.setJprice(biu.getJprice());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					oldbiu.setStarttime(sdf.parse(starttime));
					oldbiu.setEndtime(sdf.parse(endtime));
					oldbiu.setStatu("y");
					oldbiu.setAddres(biu.getAddres());
					oldbiu.setPhone(biu.getPhone());
					oldbiu.setDistrict(biu.getDistrict());
					oldbiu.setDevelopers(biu.getDevelopers());
					oldbiu.setLicence(biu.getLicence());
					oldbiu.setJzarea(biu.getJzarea());
					oldbiu.setZdarea(biu.getZdarea());
					oldbiu.setVolume(biu.getVolume());
					oldbiu.setGreen(biu.getGreen());
					oldbiu.setCompany(biu.getCompany());
					oldbiu.setCost(biu.getCost());
					oldbiu.setGarage(biu.getGarage());
					oldbiu.setMessage(biu.getMessage());
					oldbiu.setInformation(biu.getInformation());
					oldbiu.setMaid(biu.getMaid());
					oldbiu.setHid(1);
					
					System.out.println("�ҵ��޸�������");
					String num=request.getParameter("num");
					Date d=new Date();
					System.out.println("������"+num);
					if(num!=null&&num!="0"){
						String viewimg=request.getParameter("viewimg");
						String image2 = viewimg.substring(viewimg.indexOf(",") + 1);//��ȡ��ʼ��ȡ��λ��
						String[] strings3=viewimg.split(",");
						String[] strings4=strings3[0].split("/|;");
						String suffix2=strings4[1];//��׺
						String str2="."+suffix2;
						String pic2=d.getTime()+"ggl"+str2;
						Base.generateImage(image2,"D:\\��Դ\\������ĿͼƬ·��\\home\\"+pic2);
						oldbiu.setViewimg("/img/"+pic2);
						bss.updatebiu(oldbiu);
						//ͼƬ�ϴ�
						int n=Integer.parseInt(num);
						System.out.println("������յ�����ͼƬ:"+n);
						bss.delImg(biu.getBulid());//���ݷ�Դidɾ��ͼƬ
						for(int i=1;i<=n;i++){
							String wenjian1=request.getParameter("s"+i);
							String image = wenjian1.substring(wenjian1.indexOf(",") + 1);//��ȡ��ʼ��ȡ��λ��
							String[] strings=wenjian1.split(",");
							String[] strings2=strings[0].split("/|;");
							String suffix=strings2[1];//��׺
							String str="."+suffix;
							String pic=d.getTime()+i+str;
							Base.generateImage(image,"D:\\��Դ\\������ĿͼƬ·��\\home\\"+pic);
							Homeimg img=new Homeimg();
							img.setHsrc("/img/"+pic);
							img.setBulid(biu.getBulid());
							img.setMid(24);//�ȸ����̶�ֵ¥��ͼ
							bss.addImg(img);//�������ͼƬ
						}
					}
				
				 return "ok";
				}
//				@RequestMapping(value="/updatebiu")
//				@ResponseBody
//				public Object updatebiu(HttpServletRequest request) throws ParseException{
//					//System.out.println("�޸��·�id"+biu);
//					Buliding biu=obj(request);
//					Buliding oldbiu =bss.loadbiu(biu.getBulid());
//					oldbiu.setBulid(biu.getBulid());
//					oldbiu.setBuliname(biu.getBuliname());
//					oldbiu.setReid(biu.getReid());
//					oldbiu.setRegnid(biu.getRegnid());
//					oldbiu.setSid(biu.getSid());
//					oldbiu.setManid(biu.getManid());
//					oldbiu.setMoid(biu.getMoid());
//					oldbiu.setFid(biu.getFid());
//					oldbiu.setJprice(biu.getJprice());
//					oldbiu.setStarttime(biu.getStarttime());
//					oldbiu.setEndtime(biu.getEndtime());
//					oldbiu.setStatu("y");
//					oldbiu.setAddres(biu.getAddres());
//					oldbiu.setPhone(biu.getPhone());
//					//oldbiu.setViewimg(biu.getViewimg());
//					oldbiu.setDistrict(biu.getDistrict());
//					oldbiu.setDevelopers(biu.getDevelopers());
//					oldbiu.setLicence(biu.getLicence());
//					oldbiu.setJzarea(biu.getJzarea());
//					oldbiu.setZdarea(biu.getZdarea());
//					oldbiu.setVolume(biu.getVolume());
//					oldbiu.setGreen(biu.getGreen());
//					oldbiu.setCompany(biu.getCompany());
//					oldbiu.setCost(biu.getCost());
//					oldbiu.setGarage(biu.getGarage());
//					oldbiu.setMessage(biu.getMessage());
//					oldbiu.setInformation(biu.getInformation());
//					oldbiu.setMaid(biu.getMaid());
//					oldbiu.setHid(1);
//				 bss.updatebiu(oldbiu);
//				 return "ok";
//				}	
				
			
				@RequestMapping(value="/dd")
				@ResponseBody
				public String dd(Integer bulid){
					Buliding b=bss.loadbiu(bulid);
					
					return "ok";
				}
				
				//�û�
				@RequestMapping(value="/findallu",method={RequestMethod.POST})
				@ResponseBody
				public Object findallu(@RequestParam(name="username") String username,
						@RequestParam(name="password") String password
						){
					System.out.println("username======"+username+"password:"+password);
				    Users users =new Users();
				    users.setUsername(username);
				    users.setPassword(password);
				    //	return bss.findallu();
				//	Users userl=bss.findallu(users);
				//	System.out.println("�ҵȵ���ֵ��"+userl);
					Map<Object,Object> map=new HashMap<Object, Object>();
					//bss.findallu(username, password);
					Users u=bss.findallu(users);
					if(u==null){
						map.put("e", "ee");
					}else{
						map.put("e", bss.findallu(users));
					}
					
					
					
					return map;
				}		
		
				
				
				
				@RequestMapping(value="/zcpd",method={RequestMethod.POST})
				@ResponseBody//@RequestParam(name="zcusername") String zcusername
				public Object zcpd(Users users){
				    System.out.println("���������"+users);
					Map<Object,Object> map=new HashMap<Object, Object>();
					Users u=bss.findzc(users);
					 System.out.println("���������yyyy��"+bss.findzc(users));
					if(u==null){
						bss.adduser(users);
						map.put("e", "addok");
					}else{
						map.put("e", "no");
					}
					return map;
				}	
		
}
